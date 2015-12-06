package hadl.m1;

/**
 * Type d'un message pour le M1.
 * Un message est soit une requête SQL, soit une requête de sécurité.
 * Le serveur vérifie l'identité de l'émetteur avant d'effectuer la requête sur la BDD.
 */
public class Requete {
	
	public enum Type {
		/** Requête SQL non sécurisée (login/mdp non requis), passe directement à la Database */
		SQL,
		/** Requête sécurisée, avec login/mdp, doit être validée par le SecurityManager */
		SECURITE
	};
	private Type type;
	private String login, mdp, requete;

	public Requete(Type type, String login, String mdp, String requete) {
		this.type = type;
		this.login = login;
		this.mdp = mdp;
		this.requete = requete;
	}

	public String getLogin() {
		return login;
	}

	public String getMdp() {
		return mdp;
	}

	public String getRequete() {
		return requete;
	}
	
	public Type getType() {
		return type;
	}
	
	@Override
	public String toString() {
		return "[Requete "+type+"]Utilisateur : "+login+", Pass : "+mdp+", Requête : "+requete;
	}
	
}
