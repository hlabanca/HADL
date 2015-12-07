package hadl.m1;

import java.util.HashMap;
import java.util.Map;

import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.PortComposantRequis;
import hadl.m2.ports.ServiceRequis;

public class Database extends Cpt_Simple {

	private PortComposantRequis queryd = new PortComposantRequis("QueryD");
	private PortComposantRequis sec = new PortComposantRequis("SecurityManagement");
	
	//Couple "user pass"->autorisé ("1" ou "0")
	private Map<String, String> users = new HashMap<>();
	
	public Database() {
		addPortRequis(queryd);
		addPortRequis(sec);
		queryd.registerObserver(serviceQueryD);
		sec.registerObserver(serviceSecurityManagement);
		
		//ajout d'utilisateurs
		users.put("toto pass", "1");
		users.put("tata pass", "0");
	}

	private ServiceRequis serviceQueryD = new ServiceRequis() {
		
		@Override
		public Object passMessage(Object message) {
			System.out.println("[Database] Reçu QueryD : "+message);
			return "(Database : requêtes SQL non implémentées)";
		}
	};
	
	private ServiceRequis serviceSecurityManagement = new ServiceRequis() {
		
		@Override
		public Object passMessage(Object message) {
			System.out.println("[Database] Reçu SecurityManagement : "+message);
			String req = (String) message;
			//Extraire le login et mpd de la requête
			int logIndex = req.indexOf("=")+1;
			int passIndex = req.lastIndexOf("=")+1;
			String login = req.substring(logIndex, req.indexOf(" ", logIndex));
			String pass = req.substring(passIndex);
			//Renvoyer l'autorisation de l'utilisateur, null si login/mdp incorrects
			return users.get(login+" "+pass);
		}
	};
}
