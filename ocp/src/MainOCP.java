import java.util.Scanner;

public class MainOCP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean quitter = false;

        while (!quitter) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Client standard");
            System.out.println("2. Client étudiant");
            System.out.println("3. Client VIP");
            System.out.println("0. Quitter");
            System.out.print("Choix : ");

            int choix = lireEntier(scanner);

            if (choix == 0) {
                quitter = true;
                continue;
            }

            System.out.print("Montant HT : ");
            double montant = lireDouble(scanner);

            Remise strategie = obtenirStrategie(choix);
            CalculateurRemise calculateur = new CalculateurRemise(strategie);
            double total = calculateur.calculerTotal(montant);

            System.out.println("Montant après remise : " + total);
        }

        scanner.close();
    }

    private static Remise obtenirStrategie(int choix) {
        switch (choix) {
            case 1:
                return new AucuneRemise();
            case 2:
                return new RemiseEtudiant();
            case 3:
                return new RemiseVip();
            default:
                return new AucuneRemise();
        }
    }

    private static int lireEntier(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide. Recommencez : ");
            }
        }
    }

    private static double lireDouble(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide. Recommencez : ");
            }
        }
    }
}
