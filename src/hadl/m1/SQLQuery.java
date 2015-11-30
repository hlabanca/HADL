package hadl.m1;

import hadl.m2.connecteur.CoSimple;
import hadl.m2.connecteur.RoleFrom;
import hadl.m2.connecteur.RoleTo;

public class SQLQuery extends CoSimple {

	public SQLQuery() {
		addRoles(new RoleFrom("Caller"), new RoleTo("Called"));
	}
}
