package hadl.m1;

import hadl.m2.composant.Composant;
import hadl.m2.composant.Configuration;
import hadl.m2.connecteur.Connecteur;

public class SimpleCS extends Configuration {

	public SimpleCS() {
		super(new Composant[] {new Client(), new ServerSimple()},
				new Connecteur[] {new RPC()},
		null, null);
	}
}
