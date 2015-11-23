package hadl.m2.liens;

import hadl.m2.connecteur.RoleFrom;
import hadl.m2.ports.PortFourni;
import hadl.observer.Observer;

public class LienAttachmentFourniFrom implements Observer {

	private PortFourni fourni;
	private RoleFrom from;

	public LienAttachmentFourniFrom(PortFourni fourni, RoleFrom from) {
		this.fourni = fourni;
		this.from = from;
		fourni.registerObserver(this);
	}
	
	public void detacher() {
		fourni.unregisterObserver(this);
	}
	
	@Override
	public void passMessage(Object message) {
		from.notifyObservers(message);
	}
}
