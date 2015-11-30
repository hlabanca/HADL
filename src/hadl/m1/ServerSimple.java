package hadl.m1;

import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.PortComposantRequis;

public class ServerSimple extends Cpt_Simple {

	public ServerSimple() {
		addPortRequis(new PortComposantRequis("ReceiveRequest"));
	}
	
}
