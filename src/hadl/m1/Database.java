package hadl.m1;

import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.PortComposantRequis;

public class Database extends Cpt_Simple {

	public Database() {
		addPortRequis(new PortComposantRequis("QueryD"));
		addPortRequis(new PortComposantRequis("SecurityManagement"));
	}

}
