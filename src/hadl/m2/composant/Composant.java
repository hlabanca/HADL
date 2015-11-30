package hadl.m2.composant;

import java.util.List;

import hadl.m2.ports.PortFourni;
import hadl.m2.ports.PortRequis;
import hadl.observer.HadlUtil;

public abstract class Composant<F extends PortFourni, R extends PortRequis> {
	
	private List<F> portsFournis;
	private List<R> portsRequis;
	
	public F getPortFourni(String nom) {
		return HadlUtil.getElement(nom, portsFournis);
	}
	
	public R getPortRequis(String nom) {
		return HadlUtil.getElement(nom, portsRequis);
	}
	
	public void addPortFourni(F port) {
		portsFournis.add(port);
	}
	
	public void addPortRequis(R port) {
		portsRequis.add(port);
	}

}
