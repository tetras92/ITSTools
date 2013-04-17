/*
 * generated by Xtext
 */
package fr.lip6.move.scoping;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.xbase.scoping.XbaseScopeProvider;


import fr.lip6.move.gal.Call;
import fr.lip6.move.gal.Label;
import fr.lip6.move.gal.System;
import fr.lip6.move.gal.Transition;

/**
 * This class contains custom scoping description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#scoping
 * on how and when to use it 
 *
 */
public class GalScopeProvider extends XbaseScopeProvider {


	public IScope getScope(EObject context, EReference reference) {
		String clazz = reference.getEContainingClass().getName() ;
		String prop = reference.getName();
		if ("Call".equals(clazz) && "label".equals(prop)) {
			if (context instanceof Call) {
				Call call = (Call) context;
			
				System s = getSystem(call);
				Transition p = getOwningTransition(call);
				List<Label> labs= new ArrayList<Label>();
				Set<String> seen = new HashSet<String>();
				for (Transition t  : s.getTransitions()) {
					if (t!=p && t.getLabel() != null && ! seen.contains(t.getLabel().getName())) {
						labs.add(t.getLabel());
						seen.add(t.getLabel().getName());
					}
				}
				return Scopes.scopeFor(labs) ;
			}
		} else if ("VariableRef".equals(clazz) && "referencedVar".equals(prop)) {
			System s = getSystem(context);
			return Scopes.scopeFor(s.getVariables());
		} else if ("ArrayVarAccess".equals(clazz) && "prefix".equals(prop)) {
			System s = getSystem(context);
			return Scopes.scopeFor(s.getArrays());
		}
		return super.getScope(context, reference);
	}

	private Transition getOwningTransition(Call call) {
		EObject parent = call.eContainer();
		while (parent != null && !(parent instanceof fr.lip6.move.gal.System)) {
			if (parent instanceof Transition) {
				return (Transition) parent;
			}	
		}
		
		// should not happen
		return null;
	}

	
	private System getSystem(EObject call) {
		EObject parent = call.eContainer();
		while (parent != null && !(parent instanceof fr.lip6.move.gal.System)) {
			
			parent = parent.eContainer();
		}
		
		return (System) parent;
	}
}
