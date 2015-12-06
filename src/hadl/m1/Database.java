package hadl.m1;

import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.PortComposantRequis;
import hadl.m2.ports.ServiceRequis;

public class Database extends Cpt_Simple {

	PortComposantRequis queryd = new PortComposantRequis("QueryD");
	PortComposantRequis sec = new PortComposantRequis("SecurityManagement");
	
	public Database() {
		addPortRequis(queryd);
		addPortRequis(sec);
		queryd.registerObserver(serviceQueryD);
		sec.registerObserver(serviceSecurityManagement);
	}

	private ServiceRequis serviceQueryD = new ServiceRequis() {
		
		@Override
		public Object passMessage(Object message) {
			System.out.println("[Database] Reçu QueryD : "+message);
			return "Je suis une réponse à une requête SQL.";
		}
	};
	
	private ServiceRequis serviceSecurityManagement = new ServiceRequis() {
		
		@Override
		public Object passMessage(Object message) {
			System.out.println("[Database] Reçu SecurityManagement : "+message);
			return true;
		}
	};
}
