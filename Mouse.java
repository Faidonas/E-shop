class Mouse extends Peripheral {
    String technology;
    String connection;

    public Mouse() {
        this.model = "";
        this.model_year = "";
        this.manufacturer = "";
        this.price = 0;
        this.connection = "";
        this.technology = "";
        this.stock = 0;
    }

    // Constructor
    public Mouse(String model, String model_year, String manufacturer, Double price, String technology,
            String connection,
            int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.technology = technology;
        this.connection = connection;
        this.stock = stock;
    }

    // Getters
    public String getTechnology() {
        return technology;
    }

    public String getConnection() {
        return connection;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nMouse details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nTechnology: "
                + technology + "\nConnection: " + connection + "\nStock: " + stock;
    }
}
