package hadl.m1;

import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.PortComposantFourni;
import hadl.m2.ports.PortComposantRequis;
import hadl.m2.ports.ServiceRequis;

public class ConnectionManager extends Cpt_Simple {

	private PortComposantFourni sec = new PortComposantFourni("SecurityCheck");
	private PortComposantFourni dbq = new PortComposantFourni("DBQuery");
	private PortComposantRequis ext = new PortComposantRequis("ExternalSocket");

	//Gérer le droit d'accès à la BDD
	private boolean authorized = false;

	public ConnectionManager() {
		addPortFourni(sec);
		addPortFourni(dbq);
		addPortRequis(ext);
		//Connecter le service requis à son port
		ext.registerObserver(serviceExternalSocket);
	}

	private ServiceRequis serviceExternalSocket = new ServiceRequis() {

		@Override
		public Object passMessage(Object message) {
			Requete msg = (Requete) message;
			System.out.println("[ConnectionManager] Message reçu : "+msg);
			//Suivant le type de la requête, appeler le service correspondant
			switch (msg.getType()) {
			case LOGIN:
				if (authorized) {
					return "Erreur : déjà connecté";
				} else {
					return serviceSecurityCheck(msg);
				}
			case LOGOUT:
				if (authorized) {
					authorized = false;
					return "Déconnexion OK";
				} else {
					return "Erreur : déjà déconnecté";
				}
			case SQL:
				//il faut être connecté avant de faire une requête SQL
				if (!authorized) {
					return "Requête refusée : vous n'êtes pas connecté";
				} else {
					return serviceDBQuery(msg.getRequete());
				}
			default: //N'arrivera jamais, mais Eclipse le veut :p
				return null;
			}
		}
	};

	private Object serviceDBQuery(Object message) {
		System.out.println("[ConnectionManager] Envoi d'une requête SQL.");
		Object rep = dbq.notifyObservers(message);
		System.out.println("[ConnectionManager] Retour de DBQuery : "+rep);
		return rep;
	}

	private Object serviceSecurityCheck(Object message) {
		System.out.println("[ConnectionManager] Envoi d'une demande d'authentification.");
		SecurityManager.ReponseAuth rep = (SecurityManager.ReponseAuth) sec.notifyObservers(message);
		System.out.println("[ConnectionManager] Retour de SecurityCheck : "+rep);
		this.authorized = rep.valide;
		if (authorized) {
			return "Login OK";
		} else {
			return "Echec login, raison : "+rep.raisonEchec;
		}
	}

}
