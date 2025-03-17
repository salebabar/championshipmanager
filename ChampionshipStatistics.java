package rallychampionship;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Static utility class for championship statistics
 */
public class ChampionshipStatistics {
    // Private constructor to prevent instantiation
    private ChampionshipStatistics() {}

    // Calculate average points per driver
    public static double calculateAveragePointsPerDriver(ChampionshipManager championshipManager) {
        List<Driver> drivers = championshipManager.getDrivers();
        if (drivers.isEmpty()) {
            return 0.0;
        }

        int totalPoints = championshipManager.getTotalChampionshipPoints();
        return (double) totalPoints / drivers.size();
    }

    // Find the most successful country
    public static String findMostSuccessfulCountry(ChampionshipManager championshipManager) {
        List<Driver> drivers = championshipManager.getDrivers();
        if (drivers.isEmpty()) {
            return "No drivers registered";
        }

        // Create a map to track points by country
        Map<String, Integer> countryPoints = new HashMap<>();

        for (Driver driver : drivers) {
            String country = driver.getCountry();
            countryPoints.put(country, countryPoints.getOrDefault(country, 0) + driver.getTotalPoints());
        }

        // Find country with maximum points
        return countryPoints.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No country found");
    }

    // Count total races held
    public static int countTotalRacesHeld(ChampionshipManager championshipManager) {
        return championshipManager.getRaces().size();
    }
}