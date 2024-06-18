public class Motherboard extends Hardware {
    String processor;
    int memory;
    int SATAports;

    public Motherboard() {
        this.model = "";
        this.model_year = "";
        this.manufacturer = "";
        this.price = 0;
        this.memory = 0;
        this.SATAports = 0;
        this.processor = "";
        this.stock = 0;
    }

    // Constructor
    public Motherboard(String model, String model_year, String manufacturer, Double price, String processor, int memory,
            int SATAports, int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.processor = processor;
        this.memory = memory;
        this.SATAports = SATAports;
        this.stock = stock;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nMotherboard details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nProcessor: "
                + processor + "\nMemory: " + memory + " GB" + "\nSATA ports: " + SATAports + "\nStock: " + stock;
    }
}
