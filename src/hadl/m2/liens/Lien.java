package hadl.m2.liens;

import hadl.observer.Observer;
import hadl.observer.Subject;

public class Lien implements Observer {

	private Subject source;
	private Subject destination;
	
	public Lien(Subject source, Subject destination) {
		this.source = source;
		this.destination = destination;
		source.registerObserver(this);
	}
	
	public void detacher() {
		source.unregisterObserver(this);
	}
	
	@Override
	public void passMessage(Object message) {
		destination.notifyObservers(message);
	}
	
	
}
