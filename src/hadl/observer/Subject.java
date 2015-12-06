package hadl.observer;

public class Subject {

	private Observer observer;
	
	private String nom;
	
	public void registerObserver(Observer observer) {
		this.observer = observer;
	}
	
	public void unregisterObserver(Observer observer) {
		observer = null;
	}
	
	public Object notifyObservers(Object message) {
		if (observer == null) {
			return null;
		}
		return observer.passMessage(message);
	}
	
	public String getNom() {
		return nom;
	}
	
	public Subject(String nom) {
		this.nom = nom;
	}

}
