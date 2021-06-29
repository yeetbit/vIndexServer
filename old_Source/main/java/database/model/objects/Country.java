package src.database.model.objects;

public class Country {

    private int countryId;
    private String countryName;
    private String countryGeolocation;

    public Country(){

    }

    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryGeolocation() {
        return countryGeolocation;
    }

    public void setCountryGeolocation(String countryGeolocation) {
        this.countryGeolocation = countryGeolocation;
    }
    
}


