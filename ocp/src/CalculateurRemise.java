public class CalculateurRemise {
    private final Remise strategie;

    public CalculateurRemise(Remise strategie) {
        this.strategie = strategie;
    }

    public double calculerTotal(double montant) {
        return strategie.RemiseAppliquer(montant);
    }
}
