/*
 * generated by Xtext
 */
package fr.lip6.move.scoping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xtext.XtextScopeProvider;

import com.google.inject.Inject;

import fr.lip6.move.gal.ArrayInstanceDeclaration;
import fr.lip6.move.gal.ArrayReference;
import fr.lip6.move.gal.InstanceDecl;
import fr.lip6.move.gal.InstanceDeclaration;
import fr.lip6.move.gal.AbstractParameter;
import fr.lip6.move.gal.CompositeTypeDeclaration;
import fr.lip6.move.gal.For;
import fr.lip6.move.gal.GALParamDef;
import fr.lip6.move.gal.GALTypeDeclaration;
import fr.lip6.move.gal.InstanceCall;
import fr.lip6.move.gal.Interface;
import fr.lip6.move.gal.Label;
import fr.lip6.move.gal.Parameter;
import fr.lip6.move.gal.Predicate;
import fr.lip6.move.gal.Property;
import fr.lip6.move.gal.QualifiedReference;
import fr.lip6.move.gal.Reference;
import fr.lip6.move.gal.SelfCall;
import fr.lip6.move.gal.Specification;
import fr.lip6.move.gal.Synchronization;
import fr.lip6.move.gal.TemplateTypeDeclaration;
import fr.lip6.move.gal.Transient;
import fr.lip6.move.gal.Transition;
import fr.lip6.move.gal.TypeDeclaration;
import fr.lip6.move.gal.TypedefDeclaration;
import fr.lip6.move.gal.VariableReference;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class GalScopeProvider extends XtextScopeProvider {

	@Inject
	static ITSQualifiedNameProvider nameProvider;


	public static IScope sgetScope (EObject context, EReference reference) {
		String clazz = reference.getEContainingClass().getName() ;
		String prop = reference.getName();

		if ("SelfCall".equals(clazz) && "label".equals(prop)) {
			if (context instanceof SelfCall) {
				SelfCall call = (SelfCall) context;
				TypeDeclaration td = getVarScope(context);
				return Scopes.scopeFor(getLabels(td)) ;
				
//				Transition p = getOwningTransition(call);
//				List<Label> labs= new ArrayList<Label>();
//				Set<String> seen = new HashSet<String>();
//				GALTypeDeclaration s = getSystem(context);
//				if (s==null) {
//					return null;
//				}
//				for (Transition t  : s.getTransitions()) {
//					if (t!=p && t.getLabel() != null && ! seen.contains(t.getLabel().getName())) {
//						labs.add(t.getLabel());
//						seen.add(t.getLabel().getName());
//					}
//				}
			}
		} else 	if ("ref".equals(prop) && "VariableReference".equals(clazz)) {
			// depends on context
			TypeDeclaration scopingType = getVarScope(context);
			return getVars(scopingType);

//		}if ("VariableRef".equals(clazz) && "referencedVar".equals(prop)) {
//			if (getOwningTransition(context)==null && ! isPredicate(context)) {
//				return IScope.NULLSCOPE;
//			}
//			if (context.eContainer() instanceof QualifiedVarAccess) {
//				QualifiedVarAccess qva = (QualifiedVarAccess) context.eContainer();
//				if (qva.getQualifier() == null || ! (qva.getQualifier() instanceof GalInstance)) {
//					return IScope.NULLSCOPE;
//				}
//				GalInstance gal = (GalInstance) qva.getQualifier();
//				if ( gal != null) {
//					return Scopes.scopeFor(gal.getType().getVariables());
//				}
//				return IScope.NULLSCOPE;
//			}
//
//			GALTypeDeclaration s = getSystem(context);
//			if (s==null) {
//				return IScope.NULLSCOPE;
//			}
//			return Scopes.scopeFor(s.getVariables());
//		} else if ("ArrayVarAccess".equals(clazz) && "prefix".equals(prop)) {
//			if (getOwningTransition(context)==null && ! isPredicate(context)) {
//				return IScope.NULLSCOPE;
//			}
//			
//			if (context.eContainer() instanceof QualifiedVarAccess) {
//				QualifiedVarAccess qva = (QualifiedVarAccess) context.eContainer();
//				if (qva.getQualifier() == null || ! (qva.getQualifier() instanceof GalInstance)) {
//					return IScope.NULLSCOPE;
//				}
//				GalInstance gal = (GalInstance) qva.getQualifier();
//				if ( gal != null) {
//					return Scopes.scopeFor(gal.getType().getArrays());
//				}
//				return IScope.NULLSCOPE;
//			}
//
//			GALTypeDeclaration s = getSystem(context);
//			if (s==null) {
//				return IScope.NULLSCOPE;
//			}
//			return Scopes.scopeFor(s.getArrays());
		} else if (clazz.contains("ParamRef") && "refParam".equals(prop)) {
			List<AbstractParameter> union = new ArrayList<AbstractParameter>();
			EObject parent = context.eContainer();
			while (parent != null) {
				if (parent instanceof For) {
					union.add(((For)parent).getParam());
				} else if (parent instanceof GALTypeDeclaration) {
					GALTypeDeclaration gal = (GALTypeDeclaration) parent;
					union.addAll(gal.getParams());
				} else if (parent instanceof Transition) {
					Transition tr = (Transition) parent;
					union.addAll(tr.getParams());
				} else if (parent instanceof Synchronization) {
					Synchronization tr = (Synchronization) parent;
					union.addAll(tr.getParams());
				} else if (parent instanceof Specification) {
					Specification spec = (Specification) parent;
					union.addAll(spec.getParams());
					break;
				} 
				parent = parent.eContainer();
			}
			return Scopes.scopeFor(union);
		} else if (context instanceof SelfCall && "label".equals(prop)) {
			SelfCall selfcall = (SelfCall) context;
			
			EList<Synchronization> a = ((CompositeTypeDeclaration) selfcall.eContainer().eContainer()).getSynchronizations();
			List<Label> toScope = new ArrayList<Label>();
			Set<String> seen = new HashSet<String>();
			for (Synchronization t : a){
				if (t.getLabel() != null && ! seen.contains(t.getLabel().getName()) &&  ((Synchronization) selfcall.eContainer()).getLabel() != t.getLabel()){
					toScope.add(t.getLabel());
					seen.add(t.getLabel().getName());
				}
			}
			return Scopes.scopeFor(toScope) ;
//		} else if  (context instanceof InstanceCall && "instance".equals(prop) ){
//			if (context.eContainer().eContainer() instanceof CompositeTypeDeclaration) {
//				CompositeTypeDeclaration ctd = (CompositeTypeDeclaration) context.eContainer().eContainer();
//				return Scopes.scopeFor(ctd.getInstances());
//			}
		} else if (context instanceof InstanceCall && "label".equals(prop) ){
			InstanceCall call = (InstanceCall) context;
			Reference ref = call.getInstance();
			TypeDeclaration type =null ;
			if (ref instanceof VariableReference) {
				VariableReference vref = (VariableReference) ref;
				if (vref.getRef() instanceof InstanceDeclaration) {
					InstanceDeclaration inst = (InstanceDeclaration) vref.getRef();
					type = inst.getType();
				} else {
					return IScope.NULLSCOPE;
				}
				InstanceDeclaration decl = (InstanceDeclaration) vref.getRef();
			} else if (ref instanceof ArrayReference) {
				ArrayReference aref = (ArrayReference) ref;
				if (aref.getArray().getRef() instanceof ArrayInstanceDeclaration) {
					type = ((ArrayInstanceDeclaration) aref.getArray().getRef()).getType();
				} else { 
					return IScope.NULLSCOPE;
				}
			}
			return Scopes.scopeFor(getLabels(type));

//			 			else if (inst instanceof OtherInstance) {
//				OtherInstance other = (OtherInstance) inst;
//				ArrayList<Tattribute> toScope = new ArrayList<Tattribute>();
//				if (other.getType().getNodes() == null){
//					return null;
//				}
//				QualifiedName name = nameProvider.getFullyQualifiedName(other.getType());
//				for (Tnode node: other.getType().getNodes().getNode()){
//					EList<Tattribute> attss = node.getAttributes().getAttribute();
//					for (Tattribute att : attss){
//						//							if (att.getName().equals("label")) {
//						//								EObject oatts = att.eContainer();
//						//								if (oatts instanceof Tattributes) {
//						//									Tattributes atts = (Tattributes) oatts;
//						//									for (Tattribute iatt :atts.getAttribute()) {
//						//										if (iatt.getName().equals("visibility")) {
//						//											if ( "PUBLIC".equalsIgnoreCase(iatt.getValue())) {
//						//												
//						//												toScope.add(att);
//						//												break;
//						//											} else {
//						//												break;
//						//											}
//						//										}
//						//									}
//						//								}
//						if (nameProvider.getFullyQualifiedName(att) != null){
//							toScope.add(att);
//						}
//					}
//				}
//
//				return Scopes.scopeFor(toScope, new Function<EObject, QualifiedName>() {
//					@Override
//					public QualifiedName apply(EObject o){
//						return nameProvider.getFullyQualifiedName(o);							
//					}
//				}, IScope.NULLSCOPE);

		} else if (context instanceof GALParamDef && "param".equals(prop)) {
			if (context.eContainer() instanceof InstanceDeclaration) {
				InstanceDeclaration inst = (InstanceDeclaration) context.eContainer();
				if (inst.getType() instanceof GALTypeDeclaration) {
					GALTypeDeclaration gal = (GALTypeDeclaration) inst.getType();
					return Scopes.scopeFor(gal.getParams());
				}
				return IScope.NULLSCOPE;
			}
		} else if (context instanceof Specification && "main".equals(prop)) {
			return Scopes.scopeFor(((Specification)context).getTypes());
		} else if ( (context instanceof InstanceDecl || context instanceof CompositeTypeDeclaration) && "type".equals(prop)) {
			// todo : add template params ?
			EObject parent = context;
			List<TypeDeclaration> toscope = new ArrayList<TypeDeclaration>();
			while ( ! (parent instanceof Specification) ) {
				if (parent instanceof CompositeTypeDeclaration) {
					CompositeTypeDeclaration ctd = (CompositeTypeDeclaration) parent;
					toscope.addAll(ctd.getTemplateParams());
				}
				parent = parent.eContainer();
			}
			toscope.addAll(((Specification) parent).getTypes());
			return Scopes.scopeFor(toscope);
		} else if ( (context instanceof Parameter  && "type".equals(prop)) || 
				("hottype".equals(prop)  )) { // handles hottype of arrays and variable declarations
			List<TypedefDeclaration> types = new ArrayList<TypedefDeclaration>();
			for (EObject p = context.eContainer() ; p != null ; p =p.eContainer()) {
				if (p instanceof GALTypeDeclaration) {
					GALTypeDeclaration gal = (GALTypeDeclaration) p;
					types.addAll(gal.getTypes());
				}
				if (p instanceof CompositeTypeDeclaration) {
					CompositeTypeDeclaration gal = (CompositeTypeDeclaration) p;
					types.addAll(gal.getTypes());
				}
				if (p instanceof Specification) {
					Specification spec = (Specification) p;
					types.addAll(spec.getTypedefs());
					break;
				}
			}
			return Scopes.scopeFor(types);
		} 
//		else if (clazz.equals("QualifiedVarAccess")  && "qualifier".equals(prop)) {
//			// path element in a property
//			System.out.println("scoping " + prop + " to variable : clazz="+clazz+"  context=" + context.getClass().getName() + " ref.parent="+ reference.getContainerClass().getName());
//
//
//			if (context.eContainer() instanceof QualifiedVarAccess) {
//				QualifiedVarAccess qva = (QualifiedVarAccess) context.eContainer(); 
//				if (qva.getQualifier() == null) 
//					return IScope.NULLSCOPE;
//				if (qva.getQualifier() instanceof ItsInstance) {
//					ItsInstance itsi = (ItsInstance) qva.getQualifier();
//					return Scopes.scopeFor(itsi.getType().getInstances());
//				}
//				return IScope.NULLSCOPE;
//			} else {
//				boolean isProp =false;
//				EObject parent = context.eContainer();
//				while (parent != null && !(parent instanceof Specification)) {
//					if (parent instanceof Property) isProp = true;
//					parent = parent.eContainer();
//				}
//				if (! isProp) return IScope.NULLSCOPE;
//				if (parent == null) return IScope.NULLSCOPE;
//				Specification spec = (Specification) parent;
//				if (spec.getMain() == null) return IScope.NULLSCOPE;
//
//				if (spec.getMain() instanceof CompositeTypeDeclaration) {
//					CompositeTypeDeclaration ctd = (CompositeTypeDeclaration) spec.getMain();
//
//					return Scopes.scopeFor(ctd.getInstances());				
//				} 
//			}
//			return IScope.NULLSCOPE;
//		} 	
		//		else if ( context instanceof FinalQualifyVarAccess && "gal".equals(prop)) {
		//			
		//			if ( context.eContainer() instanceof PathToVarAccess) {
		//				ItsInstance itsi = ((PathToVarAccess) context.eContainer()).getPath();
		//				if (itsi == null || itsi.getType()==null ) return IScope.NULLSCOPE;
		//				List<AbstractInstance> possibles = new ArrayList<AbstractInstance>();
		//				for (AbstractInstance ai : itsi.getType().getInstances()) {
		//					if (ai instanceof GalInstance) {
		//						possibles.add(ai);
		//					}
		//				}
		//				return Scopes.scopeFor(possibles);
		//			}
		//			
		//			boolean isProp =false;
		//			EObject parent = context.eContainer();
		//			while (parent != null && !(parent instanceof Specification)) {
		//				if (parent instanceof Property) isProp = true;
		//				parent = parent.eContainer();
		//			}
		//			if (! isProp) return IScope.NULLSCOPE;
		//			if (parent == null) return IScope.NULLSCOPE;
		//			Specification spec = (Specification) parent;
		//			if (spec.getMain() == null) return IScope.NULLSCOPE;
		//			
		//			
		//			// path element in a property
		//			System.out.println("scoping " + prop + " to variable : context=" + context.getClass().getName() + " ref.parent="+ reference.getContainerClass().getName());
		//			
		//			if (spec.getMain() instanceof GALTypeDeclaration) return IScope.NULLSCOPE;
		//			
		//			// ok so we have a main type, that is not a GAL
		//			if (spec.getMain() instanceof CompositeTypeDeclaration) {
		//				CompositeTypeDeclaration ctd = (CompositeTypeDeclaration) spec.getMain();
		//				List<GalInstance> possibles = new ArrayList<GalInstance>();
		//				for (AbstractInstance ai : ((CompositeTypeDeclaration) spec.getMain()).getInstances()) {
		//					if (ai instanceof GalInstance) {
		//						possibles.add((GalInstance) ai);
		//					}
		//				}
		//				
		//				return Scopes.scopeFor(possibles);
		//			}			

		//		}


		return null;
	}

	private static Iterable<? extends EObject> getLabels(TypeDeclaration type) {
		Map<String,Label> toScope = new HashMap<String, Label>();
		if (type instanceof GALTypeDeclaration) {
			GALTypeDeclaration gal = (GALTypeDeclaration) type;
			EList<Transition> a = gal.getTransitions();
			for (Transition t : a){
				Label lab = t.getLabel();
				String name = lab.getName();
				if (lab != null && ! toScope.containsKey(name)) {
							toScope.put(name, lab);
				}
			}

		} else if (type instanceof CompositeTypeDeclaration) {
			CompositeTypeDeclaration ctd = (CompositeTypeDeclaration) type;
			for (Synchronization t : ctd.getSynchronizations()){
				Label lab = t.getLabel();
				String name = lab.getName();
				if (lab != null && ! name.equals("") && ! toScope.containsKey(name)) {
							toScope.put(name, lab);
				}
			}
			return toScope.values() ;
		} else if (type instanceof TemplateTypeDeclaration) {
			TemplateTypeDeclaration tpl = (TemplateTypeDeclaration) type;
			for (Interface t : tpl.getInterfaces()){
				for (Label lab : t.getLabels()) {
					String name = lab.getName();
					if (lab != null && ! name.equals("") && ! toScope.containsKey(name)) {
						toScope.put(name, lab);
					}
				}
			}
		} 
		return toScope.values() ;

	}

	@Override
	public IScope getScope(EObject context, EReference reference) {
		IScope res = sgetScope(context, reference);
		if (res == null) {

//			if (context instanceof ItsInstance && "type".equals(reference.getName())){
//				IScope scope = super.getScope(context, reference);
//				Iterable<IEObjectDescription> it = scope.getAllElements();
//				Set<IEObjectDescription> toScope = new HashSet<IEObjectDescription>();
//				for (IEObjectDescription ieo : it){				
//					if (false == ((CompositeTypeDeclaration)context.eContainer()).getName().equals(ieo.getQualifiedName().toString())){
//						toScope.add(ieo);
//					}
//				}
//				return new SimpleScope(toScope);
//			}	

			System.err.println("Defaulting to xbase scope for  "+context.getClass().getName() + " ref" + reference.getName() );
			return super.getScope(context, reference);
		} else {
			return res;
		}
	}

	public static Transition getOwningTransition(EObject call) {
		EObject parent = call.eContainer();
		while (parent != null && !(parent instanceof fr.lip6.move.gal.Specification)) {
			if (parent instanceof Transition) {
				return (Transition) parent;
			}
			parent = parent.eContainer();
		}

		// should not happen
		return null;
	}


	public static boolean isPredicate (EObject call) {
		EObject parent = call.eContainer();
		while (parent != null && !(parent instanceof Specification)) {
			if (parent instanceof Transient) {
				return true;
			} 
			if (parent instanceof Predicate) {
				return true;
			}
			if (parent instanceof Property) {
				return true;
			}
			parent = parent.eContainer();
		}
		return false;
	}

	public static GALTypeDeclaration getSystem(EObject call) {

		EObject parent = call.eContainer();
		while (parent != null && !(parent instanceof GALTypeDeclaration) && !(parent instanceof Property)) {
			parent = parent.eContainer();
		}
		if (parent instanceof Property) {
			Specification spec = (Specification) parent.eContainer();
			TypeDeclaration td =null;
			if (spec.getMain() == null && ! spec.getTypes().isEmpty()) {
				td = spec.getTypes().get(spec.getTypes().size()-1);				
			} else {
				td = spec.getMain();
			}
			if (td instanceof GALTypeDeclaration) {
				parent = td;
			} else {
				parent = null;
			}
		}
		return (GALTypeDeclaration) parent;
	}
	
	private static IScope getVars(TypeDeclaration type) {
		if (type instanceof GALTypeDeclaration) {
			GALTypeDeclaration gal = (GALTypeDeclaration) type;
			List<EObject> res = new ArrayList<EObject>();
			res.addAll(gal.getVariables());
			res.addAll(gal.getArrays());
			return Scopes.scopeFor(res);
		}
		if (type instanceof CompositeTypeDeclaration) {
			CompositeTypeDeclaration comp = (CompositeTypeDeclaration) type;
			return Scopes.scopeFor(comp.getInstances());
		}
		return IScope.NULLSCOPE;
	}

	
	private static TypeDeclaration getVarScope(EObject context) {
		if (context instanceof VariableReference) {
			if (context.eContainer() instanceof QualifiedReference && "next".equals(context.eContainingFeature().getName())) {
				// resolve type as qualifier
				QualifiedReference qref = (QualifiedReference) context.eContainer();
				VariableReference qual = qref.getQualifier();
				
				if (qual.getRef() instanceof InstanceDeclaration) {
					return getType((InstanceDeclaration)qual.getRef());
				}					
			}
			if (context.eContainer() instanceof QualifiedReference && "qualifier".equals(context.eContainingFeature().getName())) {
				// avoid cyclic resolution
				return getVarScope(context.eContainer().eContainer());
			}
		}
		if (context instanceof QualifiedReference) {
			QualifiedReference qref = (QualifiedReference) context;
			// resolve type as qualifier
			VariableReference qual = qref.getQualifier();
			
			if (qual.getRef() instanceof InstanceDeclaration) {
				return getType((InstanceDeclaration) qual.getRef());
			}					

		}
		if (context instanceof TypeDeclaration) {
			TypeDeclaration td = (TypeDeclaration) context;
			return td;
		}
		if (context instanceof Specification) {
			return ((Specification) context).getMain();
		}
		return getVarScope(context.eContainer());
	}

	private static TypeDeclaration getType(InstanceDeclaration ref) {
		return ref.getType();
	}

	
}
