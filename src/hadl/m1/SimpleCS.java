package hadl.m1;

import hadl.m2.composant.Configuration;
import hadl.m2.liens.LienAttachmentFourniFrom;
import hadl.m2.liens.LienAttachmentToRequis;
import hadl.m2.liens.LienBindingDetailRequis;

public class SimpleCS extends Configuration {

	public SimpleCS() {
		//Relier le port SendRequest du Client au rôle Caller de RPC
		//avec un lien attachment
		new LienAttachmentFourniFrom(client.getPortFourni("SendRequest"), rpc.getRoleFrom("Caller"));
		new LienAttachmentToRequis(rpc.getRoleTo("Called"), servSimple.getPortRequis("ReceiveRequest"));
		//Lier le composant Server avec son "zoom" (config)
		new LienBindingDetailRequis(servSimple.getPortRequis("ReceiveRequest"), servConf.getPortRequis("ReceiveRequest"));
	}
	
	private Client client = new Client();
	private ServerSimple servSimple = new ServerSimple();
	private ServerConfig servConf = new ServerConfig();
	private RPC rpc = new RPC();
	
	//Service fourni
	public void sendRequest(Object request) {
		client.serviceSendRequest(request);
	}
}
