package hadl.observer;

import java.util.List;

public abstract class HadlUtil {
	
	public static <T extends Subject> T getElement(String nom, List<T> elements) {
		for (T elt : elements) {
			if (elt.getNom().equals(nom)) {
				return elt;
			}
		}
		throw new RuntimeException("L'élément n'existe pas");
	}
}
