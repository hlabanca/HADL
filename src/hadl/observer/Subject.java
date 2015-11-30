package hadl.observer;

import java.util.List;

public class Subject {

	private List<Observer> observers;
	
	private String nom;
	
	public void registerObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void unregisterObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyObservers(Object message) {
		for (Observer obs : observers) {
			obs.passMessage(message);
		}
	}
	
	public String getNom() {
		return nom;
	}
	
	public Subject(String nom) {
		this.nom = nom;
	}

}
