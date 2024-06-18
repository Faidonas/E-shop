class RAM extends Hardware {
    String type;
    int size;
    int frequency;

    public RAM() {
        this.model = "";
        this.model_year = "";
        this.manufacturer = "";
        this.price = 0;
        this.frequency = 0;
        this.size = 0;
        this.type = "";
        this.stock = 0;
    }

    // Constructor
    public RAM(String model, String model_year, String manufacturer, Double price, String type, int size, int frequency,
            int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.type = type;
        this.size = size;
        this.frequency = frequency;
        this.stock = stock;

    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nRAM details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nType: " + type
                + "\nSize: " + size + " GB" + "\nFrequency: " + frequency + " MHz" + "\nStock: " + stock;
    }
}