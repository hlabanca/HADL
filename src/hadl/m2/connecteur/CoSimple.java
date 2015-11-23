package hadl.m2.connecteur;

import java.util.List;

public class CoSimple extends Connecteur {
	
	/**
	 * Ajouter un couple de rôles, les messages passant par from
	 * sortiront immédiatement par to.
	 * @param from Point d'entrée
	 * @param to Point de sortie
	 */
	public void addRoles(RoleFrom from, RoleTo to) {
		couplesFromTo.add(new Glue(from, to));
	}

	private List<Glue> couplesFromTo;
}
