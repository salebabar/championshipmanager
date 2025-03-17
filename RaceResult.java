package rallychampionship;

/**
 * Interface for race results
 */
public interface RaceResult {
    void recordResult(Driver driver, int position);
    int getDriverPosition(Driver driver);
    int getDriverPoints(Driver driver);
    String getRaceName();
    String getRaceLocation();
    Driver[] getResultsOrder();
}