package rallychampionship;

import java.util.List;

/**
 * Main class that demonstrates the rally championship system
 */
public class App {
    public static void main(String[] args) {
        // Get the ChampionshipManager singleton instance
        ChampionshipManager championshipManager = ChampionshipManager.getInstance();

        // Create cars for different surfaces
        GravelCar gravelCar1 = new GravelCar("Toyota", "Yaris WRC", 380, 270, 55.0);
        GravelCar gravelCar2 = new GravelCar("Hyundai", "i20 WRC", 380, 260, 53.0);
        AsphaltCar asphaltCar1 = new AsphaltCar("Ford", "Puma Rally1", 375, 150, 8.5);
        AsphaltCar asphaltCar2 = new AsphaltCar("Citroën", "C3 WRC", 370, 145, 8.2);

        // Create and register drivers
        Driver ogier = new Driver("Sébastien Ogier", "France", asphaltCar1);
        Driver tanak = new Driver("Ott Tänak", "Estonia", gravelCar1);
        Driver rovanpera = new Driver("Kalle Rovanperä", "Finland", gravelCar2);
        Driver neuville = new Driver("Thierry Neuville", "Belgium", asphaltCar2);

        championshipManager.registerDriver(ogier);
        championshipManager.registerDriver(tanak);
        championshipManager.registerDriver(rovanpera);
        championshipManager.registerDriver(neuville);

        // Create first race - Rally Finland (Gravel)
        RallyRaceResult finlandRally = new RallyRaceResult("Rally Finland", "Jyväskylä", 4);

        // Switch to gravel cars for this race
        ogier.setCar(gravelCar1);
        neuville.setCar(gravelCar2);

        // Record results for Finland Rally
        finlandRally.recordResult(ogier, 1);  // 25 points
        finlandRally.recordResult(tanak, 2);  // 18 points
        finlandRally.recordResult(rovanpera, 3);  // 15 points
        finlandRally.recordResult(neuville, 4);  // 12 points

        championshipManager.addRaceResult(finlandRally);

        // Create second race - Monte Carlo Rally (Asphalt)
        RallyRaceResult monteCarloRally = new RallyRaceResult("Monte Carlo Rally", "Monaco", 4);

        // Switch to asphalt cars for this race
        ogier.setCar(asphaltCar1);
        tanak.setCar(asphaltCar2);
        rovanpera.setCar(asphaltCar1);
        neuville.setCar(asphaltCar2);

        // Record results for Monte Carlo Rally
        monteCarloRally.recordResult(rovanpera, 1);  // 25 points
        monteCarloRally.recordResult(neuville, 2);  // 18 points
        monteCarloRally.recordResult(ogier, 3);  // 15 points
        monteCarloRally.recordResult(tanak, 4);  // 12 points

        championshipManager.addRaceResult(monteCarloRally);

        // Display championship standings
        List<Driver> standings = championshipManager.getChampionshipStandings();
        for (int i = 0; i < standings.size(); i++) {
            Driver driver = standings.get(i);
            System.out.println((i + 1) + ". " + driver.getName() + " (" + driver.getCountry() + "): " +
                    driver.getTotalPoints() + " points");
        }

        // Display championship leader
        Driver leader = championshipManager.getLeadingDriver();
        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(leader.getName() + " with " + leader.getTotalPoints() + " points");

        // Display championship statistics
        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + ChampionshipManager.getTotalDrivers());
        System.out.println("Total Races: " + ChampionshipManager.getTotalRaces());
        System.out.printf("Average Points Per Driver: %.2f%n", ChampionshipStatistics.calculateAveragePointsPerDriver(championshipManager));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(championshipManager));
        System.out.println("Total Championship Points: " + championshipManager.getTotalChampionshipPoints());

        // Display race results
        System.out.println("\n===== RACE RESULTS =====");
        for (RaceResult race : championshipManager.getRaces()) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getRaceLocation() + ")");
            Driver[] results = race.getResultsOrder();
            for (int i = 0; i < results.length; i++) {
                if (results[i] != null) {
                    System.out.println(" Position " + (i + 1) + ": " + results[i].getName() + " - " +
                            race.getDriverPoints(results[i]) + " points");
                }
            }
            System.out.println();
        }

        // Display car performance ratings
        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + gravelCar1.calculatePerformance());
        System.out.println("Asphalt Car Performance: " + asphaltCar1.calculatePerformance());
    }
}