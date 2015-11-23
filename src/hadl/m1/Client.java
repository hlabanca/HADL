package hadl.m1;


import hadl.m2.composant.Cpt_Simple;

public class Client extends Cpt_Simple {

	private SendRequest sendRequest = new SendRequest();
	
	public SendRequest getSendRequest() {
		return sendRequest;
	}
}
