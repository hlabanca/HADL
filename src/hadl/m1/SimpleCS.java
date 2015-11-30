package hadl.m1;

import hadl.m2.composant.Configuration;
import hadl.m2.liens.LienAttachmentFourniFrom;
import hadl.m2.liens.LienAttachmentToRequis;

public class SimpleCS extends Configuration {

	public SimpleCS() {
		//Relier le port SendRequest du Client au rôle Caller de RPC
		//avec un lien attachment
		new LienAttachmentFourniFrom(client.getPortFourni("SendRequest"), rpc.getRoleFrom("Caller"));
		new LienAttachmentToRequis(rpc.getRoleTo("Called"), servSimple.getPortRequis("ReceiveRequest"));
	}
	
	private Client client = new Client();
	private ServerSimple servSimple = new ServerSimple();
	private RPC rpc = new RPC();
}
