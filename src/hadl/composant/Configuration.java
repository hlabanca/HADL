package hadl.composant;

import java.util.List;

import hadl.ports.PortConfigFourni;
import hadl.ports.PortConfigRequis;

public class Configuration implements Composant {

	private List<Composant> composites;
	private List<PortConfigFourni> fournis;
	private List<PortConfigRequis> requis;
}
