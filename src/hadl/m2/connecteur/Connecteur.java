package hadl.m2.connecteur;

import java.util.List;

import hadl.observer.HadlUtil;

public abstract class Connecteur {

	private List<RoleFrom> rolesFrom;
	private List<RoleTo> rolesTo;
	
	public RoleFrom getRoleFrom(String nom) {
		return HadlUtil.getElement(nom, rolesFrom);
	}
	
	public RoleTo getRoleTo(String nom) {
		return HadlUtil.getElement(nom, rolesTo);
	}
	
	public void addRoles(RoleFrom roleFrom, RoleTo roleTo) {
		rolesFrom.add(roleFrom);
		rolesTo.add(roleTo);
	}
}
