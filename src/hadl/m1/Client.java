package hadl.m1;


import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.EntreeSortie;

public class Client extends Cpt_Simple {

	public Client() {
		super(null, new EntreeSortie[] {new SendRequest()}, null);
	}
}
