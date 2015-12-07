package hadl.m1;

/**
 * Type d'un message pour le M1.
 * Un message est soit une requête SQL, soit une requête de sécurité.
 * Le serveur vérifie l'identité de l'émetteur avant d'effectuer la requête sur la BDD.
 */
public class Requete {
	
	public enum Type {
		/** Requête SQL, nécessite une connexion préalable */
		SQL,
		/** Requête de connexion avec login/mdp, doit être validée par le SecurityManager */
		LOGIN,
		LOGOUT
	};
	private Type type;
	private String login, mdp, requete;

	/**
	 * Requête de type login
	 */
	public Requete(String login, String mdp) {
		this(Type.LOGIN, login, mdp, "");
	}
	/**
	 * Requête de type SQL
	 */
	public Requete(String requete) {
		this(Type.SQL, "", "", requete);
	}
	
	public Requete(Type type) {
		this.type = type;
	}
	
	private Requete(Type type, String login, String mdp, String requete) {
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
		switch (type) {
		case LOGIN:
			return "Requête connexion : login="+login+" ; pass="+mdp;
		case SQL:
			return "Requête SQL : "+requete;
		case LOGOUT:
			return "Requête déconnexion";
		default:
			return "";
		}
	}
	
}
