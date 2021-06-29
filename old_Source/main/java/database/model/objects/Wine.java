package src.database.model.objects;

public class Wine {
    
    private int wineId;    
    private String wineGrape;
    private String wineColor;
    private String wineTaste;
    private int wineProducer;
    private int wineInStock;
    private int wineMore;
    private int winePics;

    public Wine(){
        
    }

    public int getWineId() {
        return wineId;
    }

    public void setWineId(int wineId) {
        this.wineId = wineId;
    }

    public String getWineGrape() {
        return wineGrape;
    }

    public void setWineGrape(String wineGrape) {
        this.wineGrape = wineGrape;
    }

    public String getWineColor() {
        return wineColor;
    }

    public void setWineColor(String wineColor) {
        this.wineColor = wineColor;
    }

    public String getWineTaste() {
        return wineTaste;
    }

    public void setWineTaste(String wineTaste) {
        this.wineTaste = wineTaste;
    }

    public int getWineProducer() {
        return wineProducer;
    }

    public void setWineProducer(int wineProducer) {
        this.wineProducer = wineProducer;
    }

    public int getWineInStock() {
        return wineInStock;
    }

    public void setWineInStock(int wineInStock) {
        this.wineInStock = wineInStock;
    }

    public int getWineMore() {
        return wineMore;
    }

    public void setWineMore(int wineMore) {
        this.wineMore = wineMore;
    }

    public int getWinePics() {
        return winePics;
    }

    public void setWinePics(int winePics) {
        this.winePics = winePics;
    }
    
}
