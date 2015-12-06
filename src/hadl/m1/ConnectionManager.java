package hadl.m1;

import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.PortComposantFourni;
import hadl.m2.ports.PortComposantRequis;
import hadl.m2.ports.ServiceRequis;

public class ConnectionManager extends Cpt_Simple {

	private PortComposantFourni sec = new PortComposantFourni("SecurityCheck");
	private PortComposantFourni dbq = new PortComposantFourni("DBQuery");
	private PortComposantRequis ext = new PortComposantRequis("ExternalSocket");
	
	public ConnectionManager() {
		addPortFourni(sec);
		addPortFourni(dbq);
		addPortRequis(ext);
		//Connecter le service requis à son port
		ext.registerObserver(serviceExternalSocket);
	}
	
	private ServiceRequis serviceExternalSocket = new ServiceRequis() {

		@Override
		public void passMessage(Object message) {
			Requete msg = (Requete) message;
			System.out.println("[ConnectionManager] Message reçu : "+msg);
			//Suivant le type de la requête, appeler le service correspondant
			switch (msg.getType()) {
			case SECURITE:
				serviceSecurityCheck(msg);
				break;
			case SQL:
				serviceDBQuery(msg.getRequete());
			}
		}
	};
	
	public void serviceDBQuery(Object message) {
		System.out.println("[ConnectionManager] Envoi d'une requête SQL non sécurisée.");
		dbq.notifyObservers(message);
	}
	
	public void serviceSecurityCheck(Object message) {
		System.out.println("[ConnectionManager] Envoi d'une requête sécurisée.");
		sec.notifyObservers(message);
	}

}
