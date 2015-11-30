package hadl.m1;

import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.PortComposantFourni;
import hadl.m2.ports.PortComposantRequis;

public class SecurityManager extends Cpt_Simple {

	public SecurityManager() {
		addPortFourni(new PortComposantFourni("CheckQuery"));
		addPortRequis(new PortComposantRequis("SecurityAuth"));
	}

}
