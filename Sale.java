import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sale {
    int saleID = 0;
    String cus_name; // customer name
    long cus_phone; // customer phone
    LocalDate sal_date = LocalDate.now(); // sale date
    DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    String sale_date = sal_date.format(myFormat);
    DateTimeFormatter myOtherFormat = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
    String other_form_sale_date = sal_date.format(myOtherFormat);
    double finalprice;
    Product soldproduct;

    public Sale() {
        this.cus_name = "";
        this.cus_phone = 0;
        this.sale_date = "";
        this.finalprice = 0;
        sal_date = LocalDate.now(); // sale date
        sale_date = sal_date.format(myFormat);
        other_form_sale_date = sal_date.format(myOtherFormat);
        soldproduct = null;
    }

    public Sale(Product soldproduct, String cus_name, int cus_phone, String sale_date, double finalprice) {
        this.cus_name = cus_name;
        this.cus_phone = cus_phone;
        this.sale_date = sale_date;
        this.finalprice = soldproduct.getFinalPrice();
    }

    public Product GetSoldProduct() {
        return soldproduct;
    }

    public void SetSalesID(int saleID) {
        this.saleID = saleID;
    }

    public int GetSalesID() {
        return this.saleID;
    }

    // toString method
    public String toString() {
        return "\n-----------------------" + "\nSale ID: " + saleID + "\nCustomer name: "
                + cus_name + "\nCustomer phone: " + cus_phone
                + "\nSale date: " + sale_date;
    }
}
