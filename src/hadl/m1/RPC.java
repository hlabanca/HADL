package hadl.m1;

import hadl.m2.connecteur.CoSimple;
import hadl.m2.connecteur.RoleFrom;
import hadl.m2.connecteur.RoleTo;

public class RPC extends CoSimple {
	
	public RPC() {
		addRoles(new RoleFrom("Caller"), new RoleTo("Called"));
	}
}
