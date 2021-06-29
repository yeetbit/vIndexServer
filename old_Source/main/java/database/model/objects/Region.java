package src.database.model.objects;

public class Region {
    private int regionId;
    private String regionName;
    private int regionCountry;// id
    private String regionGeolocation;

    public Region(){

    }

    public int getRegionId() {
        return regionId;
    }

    public void setRegionId(int regionId) {
        this.regionId = regionId;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public int getRegionCountry() {
        return regionCountry;
    }

    public void setRegionCountry(int regionCountry) {
        this.regionCountry = regionCountry;
    }

    public String getRegionGeolocation() {
        return regionGeolocation;
    }

    public void setRegionGeolocation(String regionGeolocation) {
        this.regionGeolocation = regionGeolocation;
    }
    
}
