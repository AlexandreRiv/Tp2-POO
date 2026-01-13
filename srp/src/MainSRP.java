import java.util.Scanner;

public class MainSRP {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        FacturationService service = new FacturationService();

        boolean quitter = false;

        while (!quitter) {
            afficherMenu();

            int choix = lireEntier(scanner, "Choix : ");

            switch (choix) {
                case 1:
                    traiterDocument(scanner, service, true);
                    break;
                case 2:
                    traiterDocument(scanner, service, false);
                    break;
                case 0:
                    quitter = true;
                    System.out.println("Au revoir !");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }

        scanner.close();
    }

    private static void afficherMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Créer une facture");
        System.out.println("2. Créer un devis");
        System.out.println("0. Quitter");
    }

    private static void traiterDocument(Scanner scanner, FacturationService service, boolean facture) {
        double montantHT = lireDoublePositif(scanner, "Montant HT : ");

        if (facture) {
            System.out.print("Nom du client : ");
            String client = scanner.nextLine().trim();
            service.creerFacture(montantHT, client);
        } else {
            service.creerDevis(montantHT);
        }
    }

    private static int lireEntier(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                int valeur = Integer.parseInt(scanner.nextLine().trim());
                return valeur;
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre entier valide.");
            }
        }
    }

    private static double lireDoublePositif(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            try {
                double valeur = Double.parseDouble(scanner.nextLine().trim());
                if (valeur < 0) {
                    System.out.println("Le montant doit être positif.");
                } else {
                    return valeur;
                }
            } catch (NumberFormatException e) {
                System.out.println("Veuillez entrer un nombre valide (ex: 123.45).");
            }
        }
    }
}
