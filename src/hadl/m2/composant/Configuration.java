package hadl.m2.composant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hadl.m2.connecteur.Connecteur;
import hadl.m2.ports.PortConfigFourni;
import hadl.m2.ports.PortConfigRequis;

public class Configuration implements Composant {

	private List<Composant> composites = new ArrayList<>();
	private List<Connecteur> connecteurs = new ArrayList<>();
	private List<PortConfigFourni> fournis = new ArrayList<>();
	private List<PortConfigRequis> requis = new ArrayList<>();
	
	public Configuration(Composant[] composites,
			Connecteur[] connecteurs,
			PortConfigFourni[] fournis,
			PortConfigRequis[] requis) {
		this.composites.addAll(Arrays.asList(composites));
		this.connecteurs.addAll(Arrays.asList(connecteurs));
		this.fournis.addAll(Arrays.asList(fournis));
		this.requis.addAll(Arrays.asList(requis));
	}
}
