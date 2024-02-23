import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.sql.SQLException;


public class Menu {
    public static void main(String[] args) throws SQLException, ParseException {
    Integer choice, cityId,temperature ;
    String cityName, HistoricaldataID;
    Double currentTemperature, currentWindSpeed ;
    Float currentHumidity;
    LocalDate eventDate;

            do{
                System.out.println("|======================================================================|");
                System.out.println("|------------<                City Management              >-----------|");
                System.out.println("|======================================================================|");
                System.out.println("|------------<   1: Ajouter une veille                     >-----------|");
                System.out.println("|------------<   2: Mise à jour une ville                  >-----------|");
                System.out.println("|------------<   3: Supprimer une ville                    >-----------|");
                System.out.println("|------------<   4: Afficher les villes                    >-----------|");
                System.out.println("|======================================================================|");
                System.out.println("|------------<   5: Ajouter une histoire d'une veille      >-----------|");
                System.out.println("|------------<   6: Mise à jour une histoire d'une ville   >-----------|");
                System.out.println("|------------<   7: Supprimer une histoire d'une ville     >-----------|");
                System.out.println("|------------<   8: Afficher les histoires des villes      >-----------|");
                System.out.println("|======================================================================|");
                System.out.println("|------------<   9: Quitter application                    >-----------|");
                System.out.println("|======================================================================|");
                System.out.println("Enter votre choix: ");
                choice = new Scanner(System.in).nextInt();
                switch (choice) {
                    case 1:
                        System.out.print(" entrez l'identifiant unique pour la ville : ");
                        cityId = new Scanner(System.in).nextInt();
                        System.out.print(" Entrez le nom de la ville : ");
                        cityName = new Scanner(System.in).nextLine();
                        System.out.print(" Entrez la température actuelle de la ville  : ");
                        currentTemperature = new Scanner(System.in).nextDouble();
                        System.out.print(" Entrez le taux d'humidité actuelle :");
                        currentHumidity = new Scanner(System.in).nextFloat();
                        System.out.println(" Entrez la vitesse du vent actuelle :");
                        currentWindSpeed = new Scanner(System.in).nextDouble();
                        DatabaaseManager.addCity(new City(cityId, cityName, currentTemperature,currentHumidity, currentWindSpeed));
                        break;
                    case 2:
                        System.out.print("Entrez l'identifiant unique de la ville à mettre à jour : ");
                        cityId = new Scanner(System.in).nextInt();
                        System.out.print("Entrez un nouveau nom : ");
                        cityName = new Scanner(System.in).nextLine();
                        System.out.print("Entrez la température actuelle de la ville : ");
                        currentTemperature = new Scanner(System.in).nextDouble();
                        System.out.println(" Entrez le taux d'humidité actuelle :");
                        currentHumidity = new Scanner(System.in).nextFloat();
                        System.out.println(" Entrez la vitesse du vent actuelle :");
                        currentWindSpeed = new Scanner(System.in).nextDouble();
                        DatabaaseManager.updateCity(new City(cityId, cityName, currentTemperature,currentHumidity, currentWindSpeed));

                        break;
                    case 3:
                        System.out.print("Entrez le numéro d'identifiant de la ville à supprimer: ");
                        cityId= new Scanner(System.in).nextInt();
                        DatabaaseManager.deleteCity(cityId);
                        break;
                    case 4:
                        System.out.println("tout les villes:");
                        for (City city: DatabaaseManager.DisplayCity()) {
                            System.out.println(city);
                        }
                        break;
                    case 5:
                        System.out.print(" entrez Identifiant unique pour les données historiques : ");
                        HistoricaldataID = new Scanner(System.in).nextLine();
                        System.out.print(" Entrez Identifiant de la ville associée : ");
                        cityId = new Scanner(System.in).nextInt();
                        System.out.print("Entrez Date de l'événement météorologique historique (YYYY-MM-DD) : ");
                        String DateE = new Scanner(System.in).next();
                        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        eventDate = LocalDate.parse(DateE, dateTimeFormatter);
                        System.out.print(" Entrez Température historique :");
                        temperature = new Scanner(System.in).nextInt();
                        DatabaaseManager.addCityHistory(new CityHistory(HistoricaldataID, cityId, eventDate,temperature));
                        break;
                    case 6:
                        System.out.print(" Entrez Identifiant de la ville associée : ");
                        cityId = new Scanner(System.in).nextInt();
                        System.out.print(" entrez Identifiant unique pour les données historiques : ");
                        HistoricaldataID = new Scanner(System.in).nextLine();
                        System.out.print("Entrez Date de l'événement météorologique historique (YYYY-MM-DD) : ");
                        DateE = new Scanner(System.in).next();
                         dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                        eventDate = LocalDate.parse(DateE, dateTimeFormatter);
                        System.out.print(" Entrez Température historique :");
                        temperature = new Scanner(System.in).nextInt();
                        DatabaaseManager.updateCity(new CityHistory(HistoricaldataID, cityId, eventDate,temperature));

                        break;
                    case 7:
                        System.out.print("Entrez Identifiant de la ville associée : ");
                        cityId= new Scanner(System.in).nextInt();
                        DatabaaseManager.deleteCityHistory(cityId);
                        break;
                    case 8:
                        System.out.println(" tout les villes : ");
                        for (CityHistory cityHistory : DatabaaseManager.DisplayCityHistory()) {
                            System.out.println(cityHistory);
                        }
                        break;
                    case 9:
                        System.out.println("à bientot , vous avez quitter !");
                    default:
                        System.out.println(" choix invalid !");
                }

            }while(choice != 9);

        }
}
