import java.time.LocalDate;

class CityHistory {

    private String HistoricaldataID;
    private Integer cityId;
    private LocalDate eventDate;
    private Integer temperature;
    public CityHistory(String HistoricaldataID , Integer cityId , LocalDate eventDate , Integer temperature){
        this.HistoricaldataID = HistoricaldataID;
        this.cityId = cityId;
        this.eventDate = eventDate;
        this.temperature = temperature;
    }



    public String getHistoricaldataID() {
        return HistoricaldataID;
    }

    public void setHistoricaldataID(String HistoricaldataID) {
        this.HistoricaldataID = HistoricaldataID;
    }
    public Integer getCityId(){
        return cityId;
    }
    public void setCityId(Integer cityId){
        this.cityId=cityId;
    }
    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Integer getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return "CityHistory{" +
                "HistoricaldataID='" + HistoricaldataID + '\'' +
                ", cityId=" + cityId +
                ", eventDate=" + eventDate +
                ", temperature=" + temperature +
                '}';
    }

    public void setTemperature() {
        this.temperature=temperature;
    }
}