import java.util.Scanner;

public class MainIsp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Imprimer");
            System.out.println("2. Scanner");
            System.out.println("3. Faxer");
            System.out.println("0. Quitter");
            System.out.print("Choix fonctionnalité : ");

            int fonction = lireEntier(scanner);
            if (fonction == 0) break;

            System.out.println("\nChoisir la machine :");
            System.out.println("1. Imprimante simple");
            System.out.println("2. Imprimante multifonction");
            System.out.print("Choix machine : ");

            int machineChoisie = lireEntier(scanner);

            Printer machine;
            if (machineChoisie == 2) {
                machine = new ImprimanteMultifonction();
            } else {
                machine = new ImprimanteSimple();
            }

            try {
                executerFonction(machine, fonction);
            } catch (UnsupportedOperationException e) {
                System.out.println("Fonctionnalité non supportée par cette machine");
            }
        }

        scanner.close();
    }

    private static void executerFonction(Printer machine, int fonction) {
        switch (fonction) {
            case 1: machine.print(); break;
            case 2:
                if (machine instanceof Scanne) {
                    ((Scanne) machine).scan();
                } else {
                    throw new UnsupportedOperationException();
                }
                break;
            case 3:
                if (machine instanceof Fax) {
                    ((Fax) machine).fax();
                } else {
                    throw new UnsupportedOperationException();
                }
                break;
            default: System.out.println("Fonction inconnue");
        }
    }

    private static int lireEntier(Scanner scanner) {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrée invalide : ");
            }
        }
    }
}
