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
		sec.unregisterObserver(serviceSecurityAuth);
	}

	private ServiceRequis serviceSecurityAuth = new ServiceRequis() {
		@Override
		public void passMessage(Object message) {
			Requete msg = (Requete) message;
			System.out.println("[SecurityManager] Message reçu : "+msg);
			System.out.println("[SecurityManager] Login validé");
			//L'identité est validée, la base n'a besoin que du corps de la requête.
			serviceCheckQuery(msg.getRequete());
		}
	};
	
	public void serviceCheckQuery(Object message) {
		System.out.println("[SecurityManager] Envoi d'une CheckQuery");
		checkQuery.notifyObservers(message);
	}
}
