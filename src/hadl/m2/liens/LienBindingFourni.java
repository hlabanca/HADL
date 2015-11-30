package hadl.m2.liens;

import hadl.m2.ports.PortComposantFourni;
import hadl.m2.ports.PortConfigFourni;

public class LienBindingFourni extends Lien {

	public LienBindingFourni(PortComposantFourni source, PortConfigFourni destination) {
		super(source, destination);
	}
}
