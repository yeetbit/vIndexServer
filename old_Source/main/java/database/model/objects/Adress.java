package src.database.model.objects;

public class Adress {

    private String adressTable;
    private int adressId;
    private String adressStreet;
    private String adressHouseNumber;
    private String adressZipCode;
    private String adressCity;
    private int adressCountry;
    private int adressRegion;
    private String adressDescription;

    public Adress(){
        
    }

    public String getAdressTable() {
        return adressTable;
    }

    public void setAdressTable(String adressTable) {
        this.adressTable = adressTable;
    }

    public int getAdressId() {
        return adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public String getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
        this.adressStreet = adressStreet;
    }

    public String getAdressHouseNumber() {
        return adressHouseNumber;
    }

    public void setAdressHouseNumber(String adressHouseNumber) {
        this.adressHouseNumber = adressHouseNumber;
    }

    public String getAdressZipCode() {
        return adressZipCode;
    }

    public void setAdressZipCode(String adressZipCode) {
        this.adressZipCode = adressZipCode;
    }

    public String getAdressCity() {
        return adressCity;
    }

    public void setAdressCity(String adressCity) {
        this.adressCity = adressCity;
    }

    public int getAdressCountry() {
        return adressCountry;
    }

    public void setAdressCountry(int adressCountry) {
        this.adressCountry = adressCountry;
    }

    public int getAdressRegion() {
        return adressRegion;
    }

    public void setAdressRegion(int adressRegion) {
        this.adressRegion = adressRegion;
    }

    public String getAdressDescription() {
        return adressDescription;
    }

    public void setAdressDescription(String adressDescription) {
        this.adressDescription = adressDescription;
    }

        
}
