import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static com.mysql.cj.conf.PropertyKey.PASSWORD;
import static java.sql.DriverManager.getConnection;


public  class City {

    private Integer cityId;
    private String cityName;
    private Double currentTemperature;
    private Float currentHumidity;
    private Double currentWindSpeed;
    public City(Integer cityId, String cityName, Double currentTemperature,Float currentHumidity, Double currentWindSpeed){
        this.cityId=cityId;
        this.cityName=cityName;
        this.currentTemperature=currentTemperature;
        this.currentHumidity=currentHumidity;
        this.currentWindSpeed=currentWindSpeed;
    }

 


    public Integer getCityId(){
        return cityId;
    }
    public void setCityId(Integer cityId){
        this.cityId=cityId;
    }

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName){
      this.cityName=cityName;
    }
    public Double getCurrentTemperature(){
        return currentTemperature;
    }
    public void setCurrentTemperature(Double currentTemperature){
    this.currentTemperature=currentTemperature;
    }
    public Float getCurrentHumidity(){
        return currentHumidity;
    }
    public void setCurrentHumidity(Float currentHumidity){
        this.currentHumidity=currentHumidity;
    }
    public Double getCurrentWindSpeed(){
        return currentWindSpeed;
    }
    public void setCurrentWindSpeed(Double currentWindSpeed){
        this.currentWindSpeed=currentWindSpeed;
    }
    Scanner input = new Scanner(System.in);

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", cityName='" + cityName + '\'' +
                ", currentTemperature=" + currentTemperature +
                ", currentHumidity=" + currentHumidity +
                ", currentWindSpeed=" + currentWindSpeed +
                '}';
    }
}
