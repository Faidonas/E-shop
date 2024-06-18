public class CPU extends Hardware {
    double speed;
    int core;
    String graphics;

    public CPU() {
        this.model = "";
        this.model_year = "";
        this.manufacturer = "";
        this.price = 0;
        this.speed = 0;
        this.core = 0;
        this.graphics = "";
        this.stock = 0;
    }

    // Constructor
    public CPU(String model, String model_year, String manufacturer, Double price, double speed, int core,
            String graphics, int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.speed = speed;
        this.core = core;
        this.graphics = graphics;
        this.stock = stock;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nCPU details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nSpeed: " + speed
                + " GHz " + "\nCores: " + core + "\nIntegrated Graphics: " + graphics + "\nStock: " + stock;
    }
}
