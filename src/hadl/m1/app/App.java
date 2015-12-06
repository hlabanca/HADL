package hadl.m1.app;

import java.util.Scanner;

import hadl.m1.Requete;
import hadl.m1.Requete.Type;
import hadl.m1.SimpleCS;

public class App {

	private static Scanner sc = new Scanner(System.in);
	private static SimpleCS cs = new SimpleCS();
	
	public static void main(String[] args) {
		//Boucle d'envoi de requêtes
		while (true) {
			System.out.println("Sélectionner le type de requête. 1:Requête non sécurisée, 2:Requête sécurisée");
			int choix = sc.nextInt();
			sc.nextLine();
			Requete req = null;
			switch (choix) {
			case 1:
				req = requeteSql();
				break;
			case 2:
				req = requeteSecu();
				break;
			default:
				System.out.println("Mauvais choix.");
				continue;
			}
			Object reponse = cs.sendRequest(req);
			System.out.println("Réponse : "+reponse);
		}
	}

	private static Requete requeteSecu() {
		System.out.println("Entrez votre login :");
		String login = sc.nextLine();
		System.out.println("Entrez votre mot de passe :");
		String pass = sc.nextLine();
		System.out.println("Entrez la requête :");
		String req = sc.nextLine();
		
		return new Requete(Type.SECURITE, login, pass, req);
	}

	private static Requete requeteSql() {
		System.out.println("Entrez la requête :");
		String req = sc.nextLine();
		
		return new Requete(Type.SQL, "", "", req);
	}

}
