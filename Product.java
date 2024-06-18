public abstract class Product {
   String model;
   String model_year;
   String manufacturer;
   double price;
   int stock;

   public Product() {
      this.model = "";
      this.model_year = "";
      this.manufacturer = "";
      this.price = 0;
      this.stock = 0;
   }

   // Constructor
   public Product(String model, String model_year, String manufacturer, Double price, int stock) {
      this.model = model;
      this.model_year = model_year;
      this.manufacturer = manufacturer;
      this.price = price;
      this.stock = stock;
   }

   abstract void CalcFinalPrice();

   // Getters
   public String GetModel() {
      return model;
   }

   public String GetModelYear() {
      return model_year;
   }

   public String GetManufacturer() {
      return manufacturer;
   }

   public Double GetPrice() {
      return price;
   }

   public int GetStock() {
      return stock;
   }

   public int ReduceStock() {
      return (stock -= 1);
   }

   // getFinalPrice method
   abstract double getFinalPrice();

   // method toString
   public String toString() {
      return "\nModel: " + model + "\nModel year: " + model_year + "\nManufacturer: " + manufacturer
            + "\nInitial Price: " + price + " $";
   }

}