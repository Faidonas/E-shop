class Printer extends Peripheral {
    String technology;
    String print_type;

    public Printer() {
        this.model = "";
        this.model_year = "";
        this.manufacturer = "";
        this.price = 0;
        this.print_type = "";
        this.technology = "";
        this.stock = 0;
    }

    // Constructor
    public Printer(String model, String model_year, String manufacturer, Double price, String technology,
            String print_type,
            int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.technology = technology;
        this.print_type = print_type;
        this.stock = stock;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nPrinter details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nTechnology: "
                + technology + "\nPrinting style: " + print_type + "\nStock: " + stock;
    }
}
