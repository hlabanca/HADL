package hadl.m1;

import hadl.m2.connecteur.CoSimple;
import hadl.m2.connecteur.RoleFrom;
import hadl.m2.connecteur.RoleTo;

public class RPC extends CoSimple {

	private Called called = new Called();
	private Caller caller = new Caller();
	
	public RPC() {
		addRoles(caller, called);
	}

	public Called called() {
		return called;
	}
	
	public Caller caller() {
		return caller;
	}
}
