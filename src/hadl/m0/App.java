package hadl.m0;

import java.util.Scanner;

import hadl.m1.Requete;
import hadl.m1.SimpleCS;

/**
 * Test du système client/serveur.
 * Couples login/pass valides : toto - pass, tata - pass (valide mais pas autorisé)
 */
public class App {

	private static Scanner sc = new Scanner(System.in);
	private static SimpleCS cs = new SimpleCS();
	
	public static void main(String[] args) {
		//Boucle d'envoi de requêtes
		while (true) {
			System.out.println("Sélectionner le type de requête. 1:Login, 2:Requête SQL, 3:Logout");
			int choix = sc.nextInt();
			sc.nextLine();
			Requete req = null;
			switch (choix) {
			case 1:
				req = requeteLogin();
				break;
			case 2:
				req = requeteSql();
				break;
			case 3:
				req = new Requete(Requete.Type.LOGOUT);
				break;
			default:
				System.out.println("Mauvais choix.");
				continue;
			}
			Object reponse = cs.sendRequest(req);
			System.out.println("----------------------------------------------");
			System.out.println("Réponse : "+reponse+"\n");
			System.out.println("==============================================");
		}
	}

	private static Requete requeteLogin() {
		System.out.println("Entrez votre login :");
		String login = sc.nextLine();
		System.out.println("Entrez votre mot de passe :");
		String pass = sc.nextLine();
		
		return new Requete(login, pass);
	}

	private static Requete requeteSql() {
		System.out.println("Entrez la requête :");
		String req = sc.nextLine();
		
		return new Requete(req);
	}

}
