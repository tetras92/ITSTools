package fr.lip6.move.gal.itstools.launch.devTools;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.debug.core.ILaunchConfiguration;

import fr.lip6.move.gal.itstools.launch.LaunchConstants;

public class DefaultValueComputed { //Peut évoluer en implantant une interface qui calcule des valeurs par défaut
	
	private String extension;

	public DefaultValueComputed(String extension) {
		this.extension = extension;
	}

	public String computeConfigurationDefaultValue(ILaunchConfiguration configuration){
		String oriString = null, defaultValue = null;
		try {
			oriString = configuration.getAttribute(LaunchConstants.MODEL_FILE, "model.gal");
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		IPath oriPath;
		if (oriString != null){
			oriPath= Path.fromPortableString(oriString);
			defaultValue = oriPath.removeFileExtension().lastSegment() + extension;
		}
		return defaultValue;
		
	}

}
