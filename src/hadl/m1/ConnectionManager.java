package hadl.m1;

import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.PortComposantFourni;
import hadl.m2.ports.PortComposantRequis;

public class ConnectionManager extends Cpt_Simple {

	public ConnectionManager() {
		addPortFourni(new PortComposantFourni("SecurityCheck"));
		addPortFourni(new PortComposantFourni("DBQuery"));
		addPortRequis(new PortComposantRequis("ExternalSocket"));
	}

}
