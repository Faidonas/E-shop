abstract class Peripheral extends Product {
    double finalPrice;
    double fdiscRate = .25;
    String discRate = "10%";

    public Peripheral() {
        this.model = "";
        this.model_year = "";
        this.manufacturer = "";
        this.price = 0;
    }

    // Constructor
    public Peripheral(String model, String model_year, String manufacturer, Double price, int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.finalPrice = price * (1 - fdiscRate);
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void CalcFinalPrice() {
        this.finalPrice = price * (1 - fdiscRate);
    }
}