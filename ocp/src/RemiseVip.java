public class RemiseVip implements Remise{
    @Override
    public double RemiseAppliquer(double montant) {
        return montant * 0.8;
    }
}
