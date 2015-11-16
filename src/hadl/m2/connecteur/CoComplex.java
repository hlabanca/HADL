package hadl.m2.connecteur;

import hadl.m2.composant.Configuration;

public class CoComplex extends Connecteur {

	public CoComplex(RoleTo[] to, RoleFrom[] from) {
		super(to, from);
	}

	private Configuration config;
}
