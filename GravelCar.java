package rallychampionship;

/**
 * Concrete implementation of RallyCar optimized for gravel surfaces
 */
public class GravelCar extends RallyCar {
    private int suspensionTravel;
    private double weightDistribution;

    public GravelCar(String make, String model, int horsepower, int suspensionTravel, double weightDistribution) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
        this.weightDistribution = weightDistribution;
    }

    // Getters and setters for specific properties
    public int getSuspensionTravel() {
        return suspensionTravel;
    }

    public void setSuspensionTravel(int suspensionTravel) {
        this.suspensionTravel = suspensionTravel;
    }

    public double getWeightDistribution() {
        return weightDistribution;
    }

    public void setWeightDistribution(double weightDistribution) {
        this.weightDistribution = weightDistribution;
    }

    // Implementation of performance calculation for gravel
    @Override
    public double calculatePerformance() {
        // Algorithm for gravel - emphasizes suspension travel and weight distribution
        return (getHorsepower() * 0.6) + (suspensionTravel * 1.5) + (weightDistribution * 30);
    }
}