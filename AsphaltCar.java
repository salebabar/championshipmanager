package rallychampionship;

/**
 * Concrete implementation of RallyCar optimized for asphalt surfaces
 */
public class AsphaltCar extends RallyCar {
    private int downforce;
    private double tireCompound;

    public AsphaltCar(String make, String model, int horsepower, int downforce, double tireCompound) {
        super(make, model, horsepower);
        this.downforce = downforce;
        this.tireCompound = tireCompound;
    }

    // Getters and setters for specific properties
    public int getDownforce() {
        return downforce;
    }

    public void setDownforce(int downforce) {
        this.downforce = downforce;
    }

    public double getTireCompound() {
        return tireCompound;
    }

    public void setTireCompound(double tireCompound) {
        this.tireCompound = tireCompound;
    }

    // Implementation of performance calculation for asphalt
    @Override
    public double calculatePerformance() {
        // Algorithm for asphalt - emphasizes downforce and tire compound
        return (getHorsepower() * 0.8) + (downforce * 0.9) + (tireCompound * 50);
    }
}