package hadl.m2.liens;

import hadl.m2.ports.PortComposantRequis;
import hadl.m2.ports.PortConfigRequis;

public class LienBindingRequis extends Lien {
	
	public LienBindingRequis(PortConfigRequis source, PortComposantRequis destination) {
		super(source, destination);
	}
}
