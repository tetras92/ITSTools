package fr.lip6.move.gal.gal2smt.popup;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.smtlib.ICommand;
import org.smtlib.IPrinter;
import org.smtlib.IResponse;
import org.smtlib.ISolver;
import org.smtlib.plugin.Preferences;

import fr.lip6.move.gal.Property;
import fr.lip6.move.gal.Specification;
import fr.lip6.move.gal.flatten.popup.actions.GalAction;
import fr.lip6.move.gal.gal2smt.GalToSMT;
import fr.lip6.move.gal.gal2smt.IGalToSMTAction;
import fr.lip6.move.gal.gal2smt.PropertySMT;
import fr.lip6.move.gal.gal2smt.SmtSerializationUtil;

public class Gal2SmtBenchmark extends GalAction implements IGalToSMTAction {
	
	private static final int PORTEE = 10;
	private List<ICommand> commandList;
	private List<Property> propertiesList;
	private Specification s;

	private static List<String> res = new ArrayList<String>();
	
	@Override
	protected String getServiceName() {
		return "Benchmark";
	}

	@Override
	protected void workWithSystem(Specification s) throws Exception {	
		this.s = s;
	}

	@Override
	public void run(IAction action) {
		super.run(action);

		/*TODO: Recuperer Le path de la selection pour bien placer le fichier*/
		System.out.println("Folder: "+super.getWorkFolder());
		System.out.println("---Action unique---");
		
		/* Ecriture du fichier */
		SmtSerializationUtil.benchmarkToFile(super.getWorkFolder(), res);
		/* supprime les fichiers .txt.gal */
		SmtSerializationUtil.deleteFiles(super.getWorkFolder(), ".txt.gal"); 		
		res.clear();
	}
	
	@Override
	public void workWithFile(IFile file, StringBuilder log) {
		super.workWithFile(file, log);
		long trad, solverTime;
		boolean isOk=false;
		List<ICommand> tmp;		
				
		String directory = file.getParent().getRawLocationURI().getPath();
		
		/* Gal -> SMT */
		trad = System.currentTimeMillis();			
		commandList = GalToSMT.transformeGal(s, this);	
		trad = System.currentTimeMillis() - trad;		
		
		/* Pour chaque property */
		for (int i = 0; i < propertiesList.size(); i++) {
			solverTime = System.currentTimeMillis();
			
			/* Ajout de la property */
			tmp = addProperty(i,PORTEE);
			/* Resolution */
			try {
				isOk = solver(tmp);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			solverTime = System.currentTimeMillis()- solverTime;			
			
			/* Ajout du resultat */
			res.add(file.getName()+" "+propertiesList.get(i).getName()+" "+isOk+" "+solverTime+"ms");			
			
			/* supprime les fichiers .txt.gal */
			SmtSerializationUtil.deleteFiles(directory, ".txt.gal"); 
		}
	}


	
	private List<ICommand> addProperty(int i, int portee) {
		List<ICommand> tmp;
		tmp = new ArrayList<ICommand>(this.getCommandList());
		
		/* On place la property juste avant le check sat */
		tmp.addAll(getCommandList().subList(0, getCommandList().size()-3)); 
		PropertySMT.addProperty(propertiesList.get(i), portee, tmp);
		tmp.addAll(getCommandList().subList(getCommandList().size() -3, getCommandList().size()));
		return tmp;
	}
	
	private boolean solver(List<ICommand> commands) throws Exception {
		ICommand.IScript script = new org.smtlib.impl.Script();
		ISolver solver = new org.smtlib.solvers.Solver_z3_4_3(GalToSMT.getSMT().smtConfig, Preferences.getExec("Z3-4.3"));
		solver.start();
		script.commands().addAll(commands);
		
		IResponse response = script.execute(solver);
		IPrinter printer = GalToSMT.getSMT().smtConfig.defaultPrinter;
		System.out.println(printer.toString(response));
		return response.isOK();
	}
	

	public List<ICommand> getCommandList() {
		return this.commandList;
	}
	
	public void setPropertiesList(List<Property> properties){
		this.propertiesList = properties;
	}
	
	@Override
	protected String getAdditionalExtension() {
		return ".txt";
	}
	
	@Override
	protected String getTargetExtension() {
		return ".gal";
	}
	
	public void clearRes(){
		res.clear();
	}
}
