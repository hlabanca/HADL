package hadl.m2.composant;

import java.util.List;

import hadl.m2.ports.PortComposantFourni;
import hadl.m2.ports.PortComposantRequis;
import hadl.observer.HadlUtil;

public abstract class Cpt_Simple implements Composant {

	private List<PortComposantFourni> portsFournis;
	private List<PortComposantRequis> portsRequis;
	
	public PortComposantFourni getPortFourni(String nom) {
		return HadlUtil.getElement(nom, portsFournis);
	}
	
	public PortComposantRequis getPortRequis(String nom) {
		return HadlUtil.getElement(nom, portsRequis);
	}
	
	public void addPortFourni(PortComposantFourni port) {
		portsFournis.add(port);
	}
	
	public void addPortRequis(PortComposantRequis port) {
		portsRequis.add(port);
	}
}
