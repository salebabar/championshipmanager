package rallychampionship;

import java.util.ArrayList;
import java.util.List;

/**
 * Singleton class to manage the championship
 */
public class ChampionshipManager {
    private static ChampionshipManager instance;
    private static int totalDrivers = 0;
    private static int totalRaces = 0;

    private List<Driver> drivers;
    private List<RaceResult> races;

    // Private constructor to enforce Singleton pattern
    private ChampionshipManager() {
        drivers = new ArrayList<>();
        races = new ArrayList<>();
    }

    // Static method to get the singleton instance
    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    // Method to register a driver
    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    // Method to add a race result
    public void addRaceResult(RaceResult result) {
        races.add(result);
        totalRaces++;
    }

    // Method to get championship standings
    public List<Driver> getChampionshipStandings() {
        // Create a copy of drivers to avoid modifying the original list
        List<Driver> standings = new ArrayList<>(drivers);

        // Sort by total points in descending order
        standings.sort((d1, d2) -> Integer.compare(d2.getTotalPoints(), d1.getTotalPoints()));

        return standings;
    }

    // Method to find the leading driver
    public Driver getLeadingDriver() {
        if (drivers.isEmpty()) {
            return null;
        }

        return getChampionshipStandings().get(0);
    }

    // Method to calculate total championship points
    public int getTotalChampionshipPoints() {
        int totalPoints = 0;
        for (Driver driver : drivers) {
            totalPoints += driver.getTotalPoints();
        }
        return totalPoints;
    }

    // Getters for static counters
    public static int getTotalDrivers() {
        return totalDrivers;
    }

    public static int getTotalRaces() {
        return totalRaces;
    }

    public List<Driver> getDrivers() {
        return new ArrayList<>(drivers);
    }

    public List<RaceResult> getRaces() {
        return new ArrayList<>(races);
    }
}