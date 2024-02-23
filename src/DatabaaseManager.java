import com.mysql.cj.jdbc.StatementImpl;
import java.sql.Date;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class DatabaaseManager {
    public static String URL = "jdbc:mysql://localhost/weatherapp?serverTimeZone=UTC";
   public static String USERNAME= "ilham";
    public static String PASSWORD= "ilham12";
    StatementImpl statement;

    public static Connection tCon()throws SQLException{
        return DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    public static List<City> DisplayCity()throws SQLException {
        List <City> cities = new ArrayList<>();
        String sql = "SELECT * FROM city";
        Connection connection = tCon();
        PreparedStatement s = connection.prepareStatement(sql);
        ResultSet resultSet = s.executeQuery();
        while (resultSet.next()) {
            Integer cityId = resultSet.getInt("cityId");
            String cityName = resultSet.getString("cityName");
            Double currentTemperature = resultSet.getDouble("currentTemperature");
            Float currentHumidity = resultSet.getFloat("currentHumidity");
            Double currentWindSpeed = resultSet.getDouble("currentWindSpeed");
            cities.add(new City(cityId,cityName,currentTemperature,currentHumidity,currentWindSpeed));
        }
        s.close();
        connection.close();
        resultSet.close();
        return cities;
    }
    public static void addCity(City city) throws SQLException{
        String sql = "INSERT INTO city ( cityId,cityName, currentTemperature, currentHumidity, currentWindSpeed) VALUES (?,?,?,?,?)";
        Connection connection = tCon();
        PreparedStatement s = connection.prepareStatement(sql);
        s.setInt(1,city.getCityId());
        s.setString(2, city.getCityName());
        s.setDouble(3,city.getCurrentTemperature());
        s.setFloat(4,city.getCurrentHumidity());
        s.setDouble(5,city.getCurrentWindSpeed());
        s.executeUpdate();
        connection.close();
        s.close();
        System.out.println("La ville ajoutée avec succées !");
    }

    public static void deleteCity(Integer cityID) throws SQLException {
        String sql = "DELETE FROM city WHERE cityId = ?";
        Connection connection = tCon();
        PreparedStatement ps = connection.prepareStatement(sql) ;
        ps.setInt(1,cityID);
        ps.executeUpdate();
        connection.close();
        ps.close();
        System.out.println("La ville a été supprimer avec succées !");
    }
    public static void updateCity(City city) throws SQLException {
        String sql = "UPDATE City SET cityName = ? ,currentTemperature =?, currentHumidity=? ,currentWindSpeed=? WHERE cityId = ?";
        Connection connection = tCon();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,city.getCityName());
        ps.setDouble(2,city.getCurrentTemperature());
        ps.setFloat(3, city.getCurrentHumidity());
        ps.setDouble(4, city.getCurrentWindSpeed());
        ps.setInt(5,city.getCityId());
        ps.executeUpdate();
        connection.close();
        ps.close();
        System.out.println("la ville mise à jour avec succès");
    }

    public static List<CityHistory> DisplayCityHistory()throws SQLException {
        List <CityHistory> cityHistories = new ArrayList<>();
        String sql = "SELECT * FROM cityhistory";
        Connection connection = tCon();
        PreparedStatement s = connection.prepareStatement(sql);
        ResultSet resultSet = s.executeQuery();
        while (resultSet.next()){
            String HistoricaldataID = resultSet.getString("HistoricaldataID");
            Integer cityId= resultSet.getInt("cityId");
            LocalDate eventDate = resultSet.getDate("eventDate").toLocalDate();
            Integer temperature = resultSet.getInt("temperature");
        cityHistories.add(new CityHistory(HistoricaldataID,cityId,eventDate,temperature));
        }
        s.close();
        connection.close();
        resultSet.close();
        return cityHistories;
    }
    public static void addCityHistory(CityHistory cityHistory) throws SQLException{
        String sql = "INSERT INTO cityhistory (HistoricaldataID, cityId, eventDate, temperature) VALUES (?,?,?,?)";
        Connection connection = tCon();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1, cityHistory.getHistoricaldataID());
        ps.setInt(2,cityHistory.getCityId());
        ps.setDate(3, Date.valueOf(cityHistory.getEventDate()));
        ps.setFloat(4,cityHistory.getTemperature());
        ps.executeUpdate();
        connection.close();
        ps.close();
        System.out.println("Histoire de la ville ajoutée avec succées !");
    }
    public static void deleteCityHistory(Integer cityID) throws SQLException {
        String sql = "DELETE FROM cityhistory WHERE cityId = ?";
        Connection connection = tCon();
        PreparedStatement ps = connection.prepareStatement(sql) ;
        ps.setInt(1,cityID);
        ps.executeUpdate();
        connection.close();
        ps.close();
        System.out.println("L'Histoire de la ville a été supprimer avec succés .");
    }
    public static void updateCity(CityHistory cityHistory) throws SQLException {
        String sql = "UPDATE CityHistory SET HistoricaldataID = ? ,eventDate =?, temperature=? WHERE cityId = ?";
        Connection connection = tCon();
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,cityHistory.getHistoricaldataID());
        ps.setDate(2, Date.valueOf(cityHistory.getEventDate()));
        ps.setFloat(3, cityHistory.getTemperature());
        ps.setDouble(4, cityHistory.getCityId());
        ps.executeUpdate();
        connection.close();
        ps.close();
        System.out.println(" Histoire de la ville mise à jour avec succès");
    }





    }


