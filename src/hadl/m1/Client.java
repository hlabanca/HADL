package hadl.m1;


import hadl.m2.composant.Cpt_Simple;
import hadl.m2.ports.PortComposantFourni;

public class Client extends Cpt_Simple {

	private PortComposantFourni sendRequest = new PortComposantFourni("SendRequest");
	public Client() {
		addPortFourni(sendRequest);
	}
	public void makeRequest() {
		sendRequest.notifyObservers("message");
	}
}
