class Keyboard extends Peripheral {
    String connection;

    public Keyboard() {
        this.model = "";
        this.model_year = "";
        this.manufacturer = "";
        this.price = 0;
        this.connection = "";
        this.stock = 0;
    }

    // Constructor
    public Keyboard(String model, String model_year, String manufacturer, Double price, String connection, int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.connection = connection;
        this.stock = stock;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nKeyboard details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nConnection: "
                + connection + "\nStock: " + stock;
    }
}
