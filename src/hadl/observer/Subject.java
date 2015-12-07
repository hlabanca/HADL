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
			System.out.println("Erreur : "+nom+" n'est pas connecté.");
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
