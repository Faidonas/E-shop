class Monitor extends Peripheral {
    String kind;
    int screensize;
    String resolution;
    String ports;

    public Monitor() {
        this.model = "";
        this.model_year = "";
        this.manufacturer = "";
        this.price = 0;
        this.screensize = 0;
        this.resolution = "";
        this.ports = "";
        this.kind = "";
        this.stock = 0;
    }

    public Monitor(String model, String model_year, String manufacturer, Double price, String kind, int screensize,
            String resolution, String ports,
            int stock) {
        super(model, model_year, manufacturer, price, stock);
        this.kind = kind;
        this.screensize = screensize;
        this.resolution = resolution;
        this.ports = ports;
        this.stock = stock;
    }

    // toString method
    public String toString() {
        return "\n-------------------------------------------------" + "\nMonitor details :" + super.toString()
                + "\nDiscount rate: " + discRate + "\nFinal Price: " + getFinalPrice() + " $" + "\nKind: " + kind
                + "\nScreen size(inches): " + screensize + "\nResolution: " + resolution + "\nPorts: " + ports
                + "\nStock: " + stock;
        // den kserw an gia to ports thelei lista
    }
}
