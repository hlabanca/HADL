package hadl.m2.connecteur;

import hadl.m2.liens.Lien;

/**
 * Une glue associe directement un rôle from à un rôle to.
 * @author E15A968H
 *
 */
public class Glue extends Lien {

	protected Glue(RoleFrom from, RoleTo to) {
		super(from, to);
	}
}
