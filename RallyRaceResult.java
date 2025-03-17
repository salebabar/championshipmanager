package rallychampionship;

/**
 * Concrete implementation of RaceResult for rally races
 */
public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Driver[] driversInOrder;
    private int[] pointsPerPosition;

    public RallyRaceResult(String raceName, String location, int numCompetitors) {
        this.raceName = raceName;
        this.location = location;
        this.driversInOrder = new Driver[numCompetitors];
        // Define points system (25-18-15-12-10-8-6-4-2-1)
        this.pointsPerPosition = new int[]{25, 18, 15, 12, 10, 8, 6, 4, 2, 1};
    }

    @Override
    public void recordResult(Driver driver, int position) {
        if (position >= 1 && position <= driversInOrder.length) {
            driversInOrder[position - 1] = driver;

            // Update driver's points if position is eligible for points
            if (position <= pointsPerPosition.length) {
                driver.addPoints(pointsPerPosition[position - 1]);
            }
        }
    }

    @Override
    public int getDriverPosition(Driver driver) {
        for (int i = 0; i < driversInOrder.length; i++) {
            if (driversInOrder[i] != null && driversInOrder[i].equals(driver)) {
                return i + 1;
            }
        }
        return -1; // Driver not found
    }

    @Override
    public int getDriverPoints(Driver driver) {
        int position = getDriverPosition(driver);
        if (position > 0 && position <= pointsPerPosition.length) {
            return pointsPerPosition[position - 1];
        }
        return 0;
    }

    @Override
    public String getRaceName() {
        return raceName;
    }

    @Override
    public String getRaceLocation() {
        return location;
    }

    @Override
    public Driver[] getResultsOrder() {
        return driversInOrder;
    }
}