import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Order {
    int orderID = 0;
    String cus_name; // customer name
    long cus_phone; // customer phone
    String del_status; // delivery status
    double finalprice;
    LocalDate ordr_date = LocalDate.now(); // order date
    LocalDate customer_date;
    DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    DateTimeFormatter myOtherFormat = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
    String order_date = ordr_date.format(myFormat);
    String other_form_order_date = ordr_date.format(myOtherFormat);
    String del_date; // delivery date
    String order_state;
    String customer_other_date;
    Product ordproduct;

    public Order() {
        this.orderID = 0;
        this.cus_name = "";
        this.cus_phone = 0;
        this.order_date = "";
        this.finalprice = 0;
        this.del_date = "";
        this.order_state = "Pending...";
        ordr_date = LocalDate.now(); // sale date
        order_date = ordr_date.format(myFormat);
        other_form_order_date = ordr_date.format(myOtherFormat);
        customer_date = LocalDate.now();
        customer_other_date = customer_date.format(myOtherFormat);
        ordproduct = null;
    }

    public Order(Product ordproduct, int orderID, String cus_name, int cus_phone,
            String order_date, String del_date,
            String del_status, double finalprice, String order_state) {
        this.orderID = orderID;
        this.cus_name = cus_name;
        this.cus_phone = cus_phone;
        this.order_date = order_date;
        this.order_state = order_state;
        this.finalprice = ordproduct.getFinalPrice();
        this.del_date = del_date;
    }

    public void SetOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int GetOrderID() {
        return this.orderID;
    }

    public Product GetOrderProduct() {
        return ordproduct;
    }

    // toString method
    public String toString() {
        return "\n--------------------------" + "\nOrder ID: " + orderID + "\nCustomer name: "
                + cus_name + "\nCustomer phone: " + cus_phone
                + "\nOrder date: " + order_date + "\nDelivery date: " + del_date + "\nOrder state: " + order_state;
    }
}
