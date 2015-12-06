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
			switch (choix) {
			case 1:
				requeteSql();
				break;
			case 2:
				requeteSecu();
				break;
			default:
				System.out.println("Mauvais choix.");
			}
		}
	}

	private static void requeteSecu() {
		System.out.println("Entrez votre login :");
		String login = sc.nextLine();
		System.out.println("Entrez votre mot de passe :");
		String pass = sc.nextLine();
		System.out.println("Entrez la requête :");
		String req = sc.nextLine();
		
		cs.sendRequest(new Requete(Type.SECURITE, login, pass, req));
	}

	private static void requeteSql() {
		System.out.println("Entrez la requête :");
		String req = sc.nextLine();
		
		cs.sendRequest(new Requete(Type.SQL, "", "", req));
	}

}
