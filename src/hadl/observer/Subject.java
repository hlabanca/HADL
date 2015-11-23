package hadl.observer;

import java.util.List;

public class Subject {

	private List<Observer> observers;
	
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
}
