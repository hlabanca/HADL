package hadl.m1;

import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.PortComposantFourni;
import hadl.m2.ports.PortComposantRequis;
import hadl.m2.ports.ServiceRequis;

public class SecurityManager extends Cpt_Simple {

	private PortComposantFourni checkQuery = new PortComposantFourni("CheckQuery");
	private PortComposantRequis sec = new PortComposantRequis("SecurityAuth");
	
	public SecurityManager() {
		addPortFourni(checkQuery);;
		addPortRequis(sec);
		sec.registerObserver(serviceSecurityAuth);
	}

	private ServiceRequis serviceSecurityAuth = new ServiceRequis() {
		@Override
		public Object passMessage(Object message) {
			Requete msg = (Requete) message;
			System.out.println("[SecurityManager] Reçu demande SecurityAuth : "+msg);
			//Construire une pseudo-requête SQL pour vérifier les infos de l'utilisateur
			String req = "SELECT authorized FROM Users WHERE login="+msg.getLogin()+" AND pass="+msg.getMdp();
			String res = (String) serviceCheckQuery(req);
			ReponseAuth reponse = new ReponseAuth();
			//Traitement de la réponse
			if (res != null && !res.isEmpty()) {
				if (res.equals("1")) {
					reponse.valide = true;
				} else {
					reponse.valide = false;
					reponse.raisonEchec = "Utilisateur non autorisé";
				}
			} else {
				reponse.valide = false;
				reponse.raisonEchec = "Utilisateur inconnu ou mot de passe incorrect";
			}
			return reponse;
		}
	};
	
	private Object serviceCheckQuery(Object message) {
		System.out.println("[SecurityManager] Envoi d'une CheckQuery : "+message);
		Object rep = checkQuery.notifyObservers(message);
		System.out.println("[SecurityManager] Retour de CheckQuery : "+rep);
		return rep;
	}
	
	/** Réponse à une demande d'authentification */
	public class ReponseAuth {
		public boolean valide;
		public String raisonEchec;
		@Override
		public String toString() {
			return "valide="+valide+",raison="+raisonEchec;
		}
	}
}
