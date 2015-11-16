package hadl.m2.composant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hadl.m2.ports.EntreeSortie;

public class Cpt_Simple implements Composant {

	private List<Propriete> proprietes = new ArrayList<>();
	private List<EntreeSortie> fournis = new ArrayList<>();
	private List<EntreeSortie> requis = new ArrayList<>();
	
	public Cpt_Simple(Propriete[] proprietes,
			EntreeSortie[] fournis,
			EntreeSortie[] requis) {
		this.proprietes.addAll(Arrays.asList(proprietes));
		this.fournis.addAll(Arrays.asList(fournis));
		this.requis.addAll(Arrays.asList(requis));
	}
}
