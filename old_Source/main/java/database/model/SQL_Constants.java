package src.database.model;


public class SQL_Constants {

    /* 
    This is the SQL Constants library, theses Constants are modelled specificly for the vIndex Database: Wine Inventory application.
    The getters below are used to return the correct Strings when needed. 
    These are all called by the DataSourceThread class, which is again intantiated in the main class, within the main method.

        
    Old database reference-model
    
    [ "Country", "Country of origin", 0, 0, 0, ["geo-location", "options"]],
    [ "Region", "Region", 0, 0, 0, ["geo-location", "options"]],
    [ "Producer", "Producer", 0, 0, 0, ["Website", "Telephone number", "geo-location"]],
    [ "Prod date", "Production Date", 0, 0, 0, ["drink before", "reminder"]],
    [ "Grape", "grape type", 0, 0, 0, ["Wiki-link", "Wiki-grape-types"]],
    [ "Color", "color of wine", 0, 0, 0, ["options", "options"]],
    [ "Taste", "wine taste", 0, 0, 0, ["Goes with", "Comment"]],
    [ "Price", "price per bottle", 0, 0, 0, ["currentmarketvalue fetch", "purchase price"]],
    [ "Stock", "bottles in stock", 0, 0, 0, ["qty per box", "where to buy"]],
    [ "Comment", "Comments", 0, 0, 0, ["options", "options"]],
    [ "pictures", "Pictures", 0, 0, 0, ["front", "rear","other"]]


    Some explenations:

        
        whenever a string gets an "" comment, the actual column value is a number, 
        which refers to the same number "_id" located in the named table-row.
        So,
            TABLE "region" REGION_COUNTRY == 12, refers to TABLE "country" where COUNTRY_ID == 12

    */

    // DataBase Path & name
    private static final String dbPath = "jdbc:sqlite:/home/obi/Development/Repositories/Java/vIndex/vIndex_Server/vIndex_Java_Server/src/database/";
    private static final String dbname = "wine.db";
    

    // Country table
    private static final String COUNTRY_TABLE = "country";
    private static final String COUNTRY_ID = "_id";
    private static final String COUNTRY_NAME = "country";
    private static final String COUNTRY_GEOLOCATION = "geo";
    private static final int INDEX_COUNTRY_ID = 1;
    private static final int INDEX_COUNTRY = 2;
    private static final int INDEX_GEOLOCATION = 3;

    // Region table
    private static final String REGION_TABLE = "region";
    private static final String REGION_ID = "_id";
    private static final String REGION_NAME = "name";
    private static final String REGION_COUNTRY = "country";
    private static final String REGION_GEOLOCATION = "geo";
    private static final int INDEX_REGION_ID = 1;
    private static final int INDEX_REGION_NAME = 2;
    private static final int INDEX_REGION_COUNTRY = 3;
    private static final int INDEX_REGION_GEOLOCATION = 4;

    // Producer table
    private static final String PRODUCER_TABLE = "producer";
    private static final String PRODUCER_ID = "_id";
    private static final String PRODUCER_NAME = "name";
    private static final String PRODUCER_COUNTRY = "country";
    private static final String PRODUCER_REGION = "region";
    private static final String PRODUCER_ADRESS_1 = "adres1"; 
    private static final String PRODUCER_ADRESS_2 = "adres2"; 
    private static final String PRODUCER_ADRESS_3 = "adres3"; 
    private static final String PRODUCER_ADRESS_4 = "adres4"; 
    private static final String PRODUCER_PHONE = "phone";
    private static final int INDEX_PRODUCER_ID = 1;
    private static final int INDEX_PRODUCER_NAME = 2;
    private static final int INDEX_PRODUCER_COUNTRY = 3;
    private static final int INDEX_PRODUCER_REGION = 4;
    private static final int INDEX_PRODUCER_ADRESS_1 = 5;
    private static final int INDEX_PRODUCER_ADRESS_2 = 6;
    private static final int INDEX_PRODUCER_ADRESS_3 = 7;
    private static final int INDEX_PRODUCER_ADRESS_4 = 8;
    private static final int INDEX_PRODUCER_PHONE = 6;

    // Adress table
    private static final String ADRESS_TABLE = "adres";
    private static final String ADRESS_ID = "_id";
    private static final String ADRESS_STREET = "street";
    private static final String ADRESS_HOUSE_NUMBER = "housenumber";
    private static final String ADRESS_ZIP_CODE = "zip";
    private static final String ADRESS_CITY = "city";
    private static final String ADRESS_COUNTRY = "country";
    private static final String ADRESS_REGION = "region"; 
    private static final String ADRESS_DESCRIPTION = "description";
    private static final int INDEX_ADRESS_ID = 1;
    private static final int INDEX_ADRESS_STREET = 2;
    private static final int INDEX_ADRESS_HOUSENUMBER = 3;
    private static final int INDEX_ADRESS_ZIPCODE = 4;
    private static final int INDEX_ADRESS_CITY = 5;
    private static final int INDEX_ADRESS_COUNTRY = 6;
    private static final int INDEX_ADRESS_REGION = 7;
    private static final int INDEX_ADDRESS_DESCRIPTION = 8;
    
    // Wine Table
    private static final String WINE_TABLE = "wine";
    private static final String WINE_ID = "_id";    
    private static final String WINE_GRAPE = "grape";
    private static final String WINE_COLOR = "color";
    private static final String WINE_TASTE = "taste";
    private static final String WINE_PRODUCER = "producer";
    private static final String WINE_IN_STOCK = "instock";
    private static final String WINE__ATRRIB = "more";
    private static final String WINE_PICS = "pics";
    private static final int INDEX_WINE_ID = 1;
    private static final int INDEX_WINE_GRAPE = 2;
    private static final int INDEX_WINE_COLOR = 3;
    private static final int INDEX_WINE_TASTE = 4;
    private static final int INDEX_WINE_PRODUCER = 5;
    private static final int INDEX_WINE_IN_STOCK = 6;
    private static final int INDEX_WINE_ATTRIB = 7;
    private static final int INDEX_WINE_PICS = 8;    

    // More Table
    private static final String MORE_TABLE = "more";
    private static final String MORE_ID = "_id";
    private static final String MORE_WINE_GOES_WITH = "goes_with";
    private static final String MORE_WINE_PRICE = "price";
    private static final int INDEX_MORE_ID = 1;
    private static final int INDEX_MORE_WINE_GOES_WITH = 2;
    private static final int INDEX_PRICE = 3;

    private static final String PICS_TABLE = "pics";
    private static final String PICS_FRONT = "front";
    private static final String PICS_BACK = "back";
    private static final String PICS_OTHER1 = "other1";
    private static final String PICS_OTHER2 = "other2";
    private static final String PICS_OTHER3 = "other3";

    // Getters
    public String dbPath(){
        return dbPath+dbname;
    }

    public String getDbpath() {
        return dbPath;
    }

    public String getDbname() {
        return dbname;
    }

    public String getCountryTable() {
        return COUNTRY_TABLE;
    }

    public String getCountryId() {
        return COUNTRY_ID;
    }

    public String getCountryName() {
        return COUNTRY_NAME;
    }

    public String getCountryGeolocation() {
        return COUNTRY_GEOLOCATION;
    }

    public int getIndexCountryId() {
        return INDEX_COUNTRY_ID;
    }

    public int getIndexCountry() {
        return INDEX_COUNTRY;
    }

    public int getIndexGeolocation() {
        return INDEX_GEOLOCATION;
    }

    public String getRegionTable() {
        return REGION_TABLE;
    }

    public String getRegionId() {
        return REGION_ID;
    }

    public String getRegionName() {
        return REGION_NAME;
    }

    public String getRegionCountry() {
        return REGION_COUNTRY;
    }

    public String getRegionGeolocation() {
        return REGION_GEOLOCATION;
    }

    public int getIndexRegionId() {
        return INDEX_REGION_ID;
    }

    public int getIndexRegionName() {
        return INDEX_REGION_NAME;
    }

    public int getIndexRegionCountry() {
        return INDEX_REGION_COUNTRY;
    }

    public int getIndexRegionGeolocation() {
        return INDEX_REGION_GEOLOCATION;
    }

    public String getProducerTable() {
        return PRODUCER_TABLE;
    }

    public String getProducerId() {
        return PRODUCER_ID;
    }

    public String getProducerName() {
        return PRODUCER_NAME;
    }

    public String getProducerCountry() {
        return PRODUCER_COUNTRY;
    }

    public String getProducerRegion() {
        return PRODUCER_REGION;
    }

    public String getProducerAdress1() {
        return PRODUCER_ADRESS_1;
    }

    public String getProducerAdress2() {
        return PRODUCER_ADRESS_2;
    }

    public String getProducerAdress3() {
        return PRODUCER_ADRESS_3;
    }

    public String getProducerAdress4() {
        return PRODUCER_ADRESS_4;
    }

    public String getProducerPhone() {
        return PRODUCER_PHONE;
    }

    public int getIndexProducerId() {
        return INDEX_PRODUCER_ID;
    }

    public int getIndexProducerName() {
        return INDEX_PRODUCER_NAME;
    }

    public int getIndexProducerCountry() {
        return INDEX_PRODUCER_COUNTRY;
    }

    public int getIndexProducerRegion() {
        return INDEX_PRODUCER_REGION;
    }

    public int getIndexProducerAdress1() {
        return INDEX_PRODUCER_ADRESS_1;
    }

    public int getIndexProducerAdress2() {
        return INDEX_PRODUCER_ADRESS_2;
    }

    public int getIndexProducerAdress3() {
        return INDEX_PRODUCER_ADRESS_3;
    }

    public int getIndexProducerAdress4() {
        return INDEX_PRODUCER_ADRESS_4;
    }

    public int getIndexProducerPhone() {
        return INDEX_PRODUCER_PHONE;
    }

    public String getAdressTable() {
        return ADRESS_TABLE;
    }

    public String getAdressId() {
        return ADRESS_ID;
    }

    public String getAdressStreet() {
        return ADRESS_STREET;
    }

    public String getAdressHouseNumber() {
        return ADRESS_HOUSE_NUMBER;
    }

    public String getAdressZipCode() {
        return ADRESS_ZIP_CODE;
    }

    public String getAdressCity() {
        return ADRESS_CITY;
    }

    public String getAdressCountry() {
        return ADRESS_COUNTRY;
    }

    public String getAdressRegion() {
        return ADRESS_REGION;
    }

    public String getAdressDescription() {
        return ADRESS_DESCRIPTION;
    }

    public int getIndexAdressId() {
        return INDEX_ADRESS_ID;
    }

    public int getIndexAdressStreet() {
        return INDEX_ADRESS_STREET;
    }

    public int getIndexAdressHousenumber() {
        return INDEX_ADRESS_HOUSENUMBER;
    }

    public int getIndexAdressZipcode() {
        return INDEX_ADRESS_ZIPCODE;
    }

    public int getIndexAdressCity() {
        return INDEX_ADRESS_CITY;
    }

    public int getIndexAdressCountry() {
        return INDEX_ADRESS_COUNTRY;
    }

    public int getIndexAdressRegion() {
        return INDEX_ADRESS_REGION;
    }

    public int getIndexAddressDescription() {
        return INDEX_ADDRESS_DESCRIPTION;
    }

    public String getWineTable() {
        return WINE_TABLE;
    }

    public String getWineId() {
        return WINE_ID;
    }

    public String getWineGrape() {
        return WINE_GRAPE;
    }

    public String getWineColor() {
        return WINE_COLOR;
    }

    public String getWineTaste() {
        return WINE_TASTE;
    }

    public String getWineProducer() {
        return WINE_PRODUCER;
    }

    public String getWineInStock() {
        return WINE_IN_STOCK;
    }

    public String getWineAtrrib() {
        return WINE__ATRRIB;
    }

    public String getWinePics() {
        return WINE_PICS;
    }

    public int getIndexWineId() {
        return INDEX_WINE_ID;
    }

    public int getIndexWineGrape() {
        return INDEX_WINE_GRAPE;
    }

    public int getIndexWineColor() {
        return INDEX_WINE_COLOR;
    }

    public int getIndexWineTaste() {
        return INDEX_WINE_TASTE;
    }

    public int getIndexWineProducer() {
        return INDEX_WINE_PRODUCER;
    }

    public int getIndexWineInStock() {
        return INDEX_WINE_IN_STOCK;
    }

    public int getIndexWineAttrib() {
        return INDEX_WINE_ATTRIB;
    }

    public int getIndexWinePics() {
        return INDEX_WINE_PICS;
    }

    public String getMoreTable() {
        return MORE_TABLE;
    }

    public String getMoreId() {
        return MORE_ID;
    }

    public String getMoreWineGoesWith() {
        return MORE_WINE_GOES_WITH;
    }

    public String getMoreWinePrice() {
        return MORE_WINE_PRICE;
    }

    public int getIndexMoreId() {
        return INDEX_MORE_ID;
    }

    public int getIndexMoreWineGoesWith() {
        return INDEX_MORE_WINE_GOES_WITH;
    }

    public int getIndexPrice() {
        return INDEX_PRICE;
    }


    public String getPicsTable() {
        return PICS_TABLE;
    }

    public String getPicsFront() {
        return PICS_FRONT;
    }

    public String getPicsBack() {
        return PICS_BACK;
    }

    public String getPicsOther1() {
        return PICS_OTHER1;
    }

    public String getPicsOther2() {
        return PICS_OTHER2;
    }

    public String getPicsOther3() {
        return PICS_OTHER3;
    }
}
