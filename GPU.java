public class GPU extends Hardware {
    String chipset;
    int memory;

    public GPU() {
        this.model = "";
        this.model_year = "";
        this.manufacturer = "";
        this.price = 0;
        this.memory = 0;
        this.chipset = "";
        this.stock = 0;
    }

    // Constructor
    public GPU(String model, String model_year, String manufacturer, Double price, String chipset, int memory,
            int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.chipset = chipset;
        this.memory = memory;
        this.stock = stock;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nGraphics Card details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nChipset: " + chipset
                + "\nMemory: " + memory + " GB" + "\nStock: " + stock;
    }
}
