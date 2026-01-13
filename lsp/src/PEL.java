import java.util.Date;

public class PEL extends Banque {
    private final double tauxInteret = 0.03;
    protected double solde = 100;

    public double ajouter(double montant) {
        solde += montant;
        return solde;
    }
}
