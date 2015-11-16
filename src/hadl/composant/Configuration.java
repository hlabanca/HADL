package hadl.composant;

import java.util.List;

import hadl.ports.PortConfig;

public class Configuration implements Composant {

	private List<Composant> composites;
	private List<PortConfig> fournis;
	private List<PortConfig> requis;
}
