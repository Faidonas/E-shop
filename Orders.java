import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Orders {
    DateTimeFormatter myOtherFormat = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");
    int orderID = 0;

    // sales list
    public ArrayList<Order> orders = new ArrayList<Order>();

    void addOrder(Order o) {
        orderID += 1;
        o.SetOrderID(orderID);
        orders.add(o);
    }

    void addFileOrder(Order o) {
        orderID = Integer.max(orderID, o.GetOrderID());
        orders.add(o);
    }

    int ShowOrders() {
        System.out.println("Overview Orders:");
        int i = 0;
        for (Order o : orders) {
            System.out.println("\nOrder with Id = " + o.orderID);
            i += 1;
        }
        return i;
    }

    void RemoveOrder(Order o) {
        orders.remove(o);
    }

    Order listOrders(int n) {
        int i = 0;
        for (Order o : orders) {
            i += 1;
            if (i == n) {
                return o;
            }
        }
        return null;
    }

    public void CreateOrdersFile() {
        FileWriter writer = null;
        Product nxtprod;
        System.out.println("\n >>>>>>> Adding Orders from list to file ...");
        try {
            writer = new FileWriter(new File("orders.txt"));
            writer.write("ORDER_LIST \n{");
            for (Order oo : orders) {
                if (oo != null) {
                    nxtprod = oo.GetOrderProduct();
                    if (nxtprod instanceof CPU) {
                        writer.write("\n\t" + "ORDER" + "\n" + "\t" + "{"
                                + "\n" + "\t\t" + "NUMBER " + oo.GetOrderID()
                                + "\n" + "\t\t" + "NAME " + oo.cus_name
                                + "\n" + "\t\t" + "PHONE " + oo.cus_phone
                                + "\n" + "\t\t" + "ORDER_DATE " + oo.other_form_order_date
                                + "\n" + "\t\t" + "DELIVERY_DATE " + oo.customer_other_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "CPU"
                                + "\n" + "\t\t" + "MODEL " + nxtprod.model
                                + "\n" + "\t\t" + "PRICE " + ((CPU) nxtprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nxtprod.manufacturer
                                + "\n" + "\t\t" + "SPEED " + ((CPU) nxtprod).speed
                                + "\n" + "\t\t" + "CORE " + ((CPU) nxtprod).core
                                + "\n" + "\t\t" + "GRAPHICS " + ((CPU) nxtprod).graphics
                                + "\n" + "\t" + "}" + "\n");
                    } // CPU
                    else if (nxtprod instanceof GPU) {
                        writer.write("\t" + "ORDER" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + oo.GetOrderID()
                                + "\n" + "\t\t" + "NAME " + oo.cus_name
                                + "\n" + "\t\t" + "PHONE " + oo.cus_phone
                                + "\n" + "\t\t" + "ORDER_DATE " + oo.other_form_order_date
                                + "\n" + "\t\t" + "DELIVERY_DATE " + oo.del_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "GPU"
                                + "\n" + "\t\t" + "MODEL " + nxtprod.model
                                + "\n" + "\t\t" + "PRICE " + ((GPU) nxtprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nxtprod.manufacturer
                                + "\n" + "\t\t" + "CHIPSET " + ((GPU) nxtprod).chipset
                                + "\n" + "\t\t" + "MEMORY " + ((GPU) nxtprod).memory
                                + "\n" + "\t" + "}" + "\n");
                    } // GPU
                    else if (nxtprod instanceof HardDrive) {
                        writer.write("\t" + "ORDER" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + oo.GetOrderID()
                                + "\n" + "\t\t" + "NAME " + oo.cus_name
                                + "\n" + "\t\t" + "PHONE " + oo.cus_phone
                                + "\n" + "\t\t" + "ORDER_DATE " + oo.other_form_order_date
                                + "\n" + "\t\t" + "DELIVERY_DATE " + oo.del_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "HARDDRIVE"
                                + "\n" + "\t\t" + "MODEL " + nxtprod.model
                                + "\n" + "\t\t" + "PRICE " + ((HardDrive) nxtprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nxtprod.manufacturer
                                + "\n" + "\t\t" + "TYPE " + ((HardDrive) nxtprod).type
                                + "\n" + "\t\t" + "SIZE " + ((HardDrive) nxtprod).size
                                + "\n" + "\t\t" + "CAPACITY " + ((HardDrive) nxtprod).capacity
                                + "\n" + "\t" + "}" + "\n");
                    } // Hard Drive
                    else if (nxtprod instanceof Motherboard) {
                        writer.write("\t" + "ORDER" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + oo.GetOrderID()
                                + "\n" + "\t\t" + "NAME " + oo.cus_name
                                + "\n" + "\t\t" + "PHONE " + oo.cus_phone
                                + "\n" + "\t\t" + "ORDER_DATE " + oo.other_form_order_date
                                + "\n" + "\t\t" + "DELIVERY_DATE " + oo.del_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "MOTHERBOARD"
                                + "\n" + "\t\t" + "MODEL " + nxtprod.model
                                + "\n" + "\t\t" + "PRICE " + ((Motherboard) nxtprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nxtprod.manufacturer
                                + "\n" + "\t\t" + "PROCESSOR " + ((Motherboard) nxtprod).processor
                                + "\n" + "\t\t" + "MEMORY " + ((Motherboard) nxtprod).memory
                                + "\n" + "\t\t" + "SATAPORTS " + ((Motherboard) nxtprod).SATAports
                                + "\n" + "\t" + "}" + "\n");
                    } // MotherBoard
                    else if (nxtprod instanceof RAM) {
                        writer.write("\t" + "ORDER" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + oo.GetOrderID()
                                + "\n" + "\t\t" + "NAME " + oo.cus_name
                                + "\n" + "\t\t" + "PHONE " + oo.cus_phone
                                + "\n" + "\t\t" + "ORDER_DATE " + oo.other_form_order_date
                                + "\n" + "\t\t" + "DELIVERY_DATE " + oo.del_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "RAM"
                                + "\n" + "\t\t" + "MODEL " + nxtprod.model
                                + "\n" + "\t\t" + "PRICE " + ((RAM) nxtprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nxtprod.manufacturer
                                + "\n" + "\t\t" + "TYPE " + ((RAM) nxtprod).type
                                + "\n" + "\t\t" + "SIZE " + ((RAM) nxtprod).size
                                + "\n" + "\t\t" + "FREQUENCY " + ((RAM) nxtprod).frequency
                                + "\n" + "\t" + "}" + "\n");
                    } // RAM
                    else if (nxtprod instanceof Keyboard) {
                        writer.write("\t" + "ORDER" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + oo.GetOrderID()
                                + "\n" + "\t\t" + "NAME " + oo.cus_name
                                + "\n" + "\t\t" + "PHONE " + oo.cus_phone
                                + "\n" + "\t\t" + "ORDER_DATE " + oo.other_form_order_date
                                + "\n" + "\t\t" + "DELIVERY_DATE " + oo.del_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "KEYBOARD"
                                + "\n" + "\t\t" + "MODEL " + nxtprod.model
                                + "\n" + "\t\t" + "PRICE " + ((Keyboard) nxtprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nxtprod.manufacturer
                                + "\n" + "\t\t" + "CONNECTION " + ((Keyboard) nxtprod).connection
                                + "\n" + "\t" + "}" + "\n");
                    } // Keyboard
                    else if (nxtprod instanceof Monitor) {
                        writer.write("\t" + "ORDER" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + oo.GetOrderID()
                                + "\n" + "\t\t" + "NAME " + oo.cus_name
                                + "\n" + "\t\t" + "PHONE " + oo.cus_phone
                                + "\n" + "\t\t" + "ORDER_DATE " + oo.other_form_order_date
                                + "\n" + "\t\t" + "DELIVERY_DATE " + oo.del_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "MONITOR"
                                + "\n" + "\t\t" + "MODEL " + nxtprod.model
                                + "\n" + "\t\t" + "PRICE " + ((Monitor) nxtprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nxtprod.manufacturer
                                + "\n" + "\t\t" + "KIND " + ((Monitor) nxtprod).kind
                                + "\n" + "\t\t" + "SCREENSIZE " + ((Monitor) nxtprod).screensize
                                + "\n" + "\t\t" + "RESOLUTION " + ((Monitor) nxtprod).resolution
                                + "\n" + "\t\t" + "PORTS " + ((Monitor) nxtprod).ports
                                + "\n" + "\t" + "}" + "\n");
                    } // Monitor
                    else if (nxtprod instanceof Mouse) {
                        writer.write("\t" + "ORDER" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + oo.GetOrderID()
                                + "\n" + "\t\t" + "NAME " + oo.cus_name
                                + "\n" + "\t\t" + "PHONE " + oo.cus_phone
                                + "\n" + "\t\t" + "ORDER_DATE " + oo.other_form_order_date
                                + "\n" + "\t\t" + "DELIVERY_DATE " + oo.del_date
                                + "\n" + "\t\t" + "PRICE " + ((Mouse) nxtprod).finalPrice
                                + "\n" + "\t\t" + "ITEM_TYPE " + "MOUSE"
                                + "\n" + "\t\t" + "MODEL " + nxtprod.model
                                + "\n" + "\t\t" + "MANUFACTURER " + nxtprod.manufacturer
                                + "\n" + "\t\t" + "TECHNOLOGY " + ((Mouse) nxtprod).getTechnology()
                                + "\n" + "\t\t" + "CONNECTION " + ((Mouse) nxtprod).getConnection()
                                + "\n" + "\t" + "}" + "\n");
                    } // Mouse
                    else if (nxtprod instanceof Printer) {
                        writer.write("\t" + "ORDER" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + oo.GetOrderID()
                                + "\n" + "\t\t" + "NAME " + oo.cus_name
                                + "\n" + "\t\t" + "PHONE " + oo.cus_phone
                                + "\n" + "\t\t" + "ORDER_DATE " + oo.other_form_order_date
                                + "\n" + "\t\t" + "DELIVERY_DATE " + oo.del_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "PRINTER"
                                + "\n" + "\t\t" + "MODEL " + nxtprod.model
                                + "\n" + "\t\t" + "PRICE " + ((Printer) nxtprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nxtprod.manufacturer
                                + "\n" + "\t\t" + "PRINT_TYPE " + ((Printer) nxtprod).print_type
                                + "\n" + "\t\t" + "TECHNOLOGY " + ((Printer) nxtprod).technology
                                + "\n" + "\t" + "}" + "\n");
                    } // Printer
                }
            }
            writer.write("}");
            writer.close();
        } // try

        catch (IOException e) {
            System.err.println("Error writing file.");
        }

    }

    void ReadOrdersFile() {
        BufferedReader reader = null;
        Product prod = null;
        String line;
        System.out.println("\n >>>>>>> Adding Orders from file to list ...");
        try {
            reader = new BufferedReader(new FileReader(new File("orders.txt")));
            line = reader.readLine();
            if (line != null) {
                if (line.trim().equals("ORDER_LIST") || line.trim().equals("order_list")) {
                    line = reader.readLine();
                    if (line.trim().equals("{")) {
                        while ((line = reader.readLine()) != null) {
                            if (line.trim().startsWith("ORDER") || line.trim().equals("order")) {
                                line = reader.readLine();
                                if (line.trim().equals("{")) {
                                    line = reader.readLine();
                                    Order or = new Order();
                                    if (line.trim().startsWith("NUMBER ") || line.trim().startsWith("number "))
                                        or.SetOrderID(Integer.parseInt(line.trim().substring(7)));
                                    line = reader.readLine();
                                    if (line.trim().startsWith("NAME ") || line.trim().startsWith("name "))
                                        or.cus_name = line.trim().substring(5);
                                    line = reader.readLine();
                                    if (line.trim().startsWith("PHONE ") || line.trim().startsWith("phone "))
                                        or.cus_phone = Integer.parseInt(line.trim().substring(6));
                                    line = reader.readLine();
                                    if (line.trim().startsWith("ORDER_DATE ") || line.trim().startsWith("order_date "))
                                        or.ordr_date = LocalDate.parse((line.trim().substring(11)), myOtherFormat);
                                    line = reader.readLine();
                                    if (line.trim().startsWith("DELIVERY_DATE ")
                                            || line.trim().startsWith("delivery_date "))
                                        or.customer_date = LocalDate.parse((line.trim()
                                                .substring(14)), myOtherFormat);
                                    line = reader.readLine();
                                    if (line.trim().startsWith("ITEM_TYPE ") || line.trim().startsWith("item_type ")) {
                                        if (line.trim().substring(10).trim().equals("CPU")) {
                                            prod = new CPU();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                ((CPU) prod).model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                ((CPU) prod).finalPrice = Double.parseDouble(line.trim()
                                                        .substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ")
                                                    || line.trim().startsWith("manufacturer "))
                                                ((CPU) prod).manufacturer = line.trim().substring(13);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("SPEED ") || line.trim().startsWith("speed "))
                                                ((CPU) prod).speed = Double.parseDouble(line.trim().substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CORE ") || line.trim().startsWith("core "))
                                                ((CPU) prod).core = Integer.parseInt(line.trim().substring(5));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("GRAPHICS ")
                                                    || line.trim().startsWith("graphics "))
                                                ((CPU) prod).graphics = line.trim().substring(9);
                                            line = reader.readLine();
                                            if (line.trim().equals("}"))
                                                or.ordproduct = prod;
                                            addFileOrder(or);
                                        } // CPU
                                        else if (line.trim().substring(10).trim().equals("GPU")) {
                                            prod = new GPU();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                ((GPU) prod).model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                ((GPU) prod).finalPrice = Double.parseDouble(line.trim()
                                                        .substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ")
                                                    || line.trim().startsWith("manufacturer "))
                                                ((GPU) prod).manufacturer = line.trim().substring(13);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CHIPSET ")
                                                    || line.trim().startsWith("chipset "))
                                                ((GPU) prod).chipset = line.trim().substring(8);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MEMORY ") || line.trim().startsWith("memory "))
                                                ((GPU) prod).memory = Integer.parseInt(line.trim().substring(7));
                                            line = reader.readLine();
                                            if (line.trim().equals("}"))
                                                or.ordproduct = prod;
                                            addFileOrder(or);
                                        } // GPU
                                        else if (line.trim().substring(10).trim().equals("HARDDRIVE")) {
                                            prod = new HardDrive();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                ((HardDrive) prod).model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                ((HardDrive) prod).finalPrice = Double
                                                        .parseDouble(line.trim().substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ")
                                                    || line.trim().startsWith("manufacturer "))
                                                ((HardDrive) prod).manufacturer = line.trim().substring(13);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("TYPE ") || line.trim().startsWith("type "))
                                                ((HardDrive) prod).type = line.trim().substring(5);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("SIZE ") || line.trim().startsWith("size "))
                                                ((HardDrive) prod).size = Double.parseDouble(line.trim()
                                                        .substring(5));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CAPACITY ")
                                                    || line.trim().startsWith("capacity "))
                                                ((HardDrive) prod).capacity = Integer
                                                        .parseInt(line.trim().substring(9));
                                            line = reader.readLine();
                                            if (line.trim().equals("}"))
                                                or.ordproduct = prod;
                                            addFileOrder(or);
                                        } // Hard Drive
                                        else if (line.trim().substring(10).trim().equals("MOTHERBORAD")) {
                                            prod = new Motherboard();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                ((Motherboard) prod).model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                ((Motherboard) prod).finalPrice = Double
                                                        .parseDouble(line.trim().substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ")
                                                    || line.trim().startsWith("manufacturer "))
                                                ((Motherboard) prod).manufacturer = line.trim().substring(13);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PROCESSOR ")
                                                    || line.trim().startsWith("processor "))
                                                ((Motherboard) prod).processor = line.trim().substring(10);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MEMORY ") || line.trim().startsWith("memory "))
                                                ((Motherboard) prod).memory = Integer
                                                        .parseInt(line.trim().substring(7));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("SATAPORTS ")
                                                    || line.trim().startsWith("sataports "))
                                                ((Motherboard) prod).SATAports = Integer
                                                        .parseInt(line.trim().substring(10));
                                            line = reader.readLine();
                                            if (line.trim().equals("}"))
                                                or.ordproduct = prod;
                                            addFileOrder(or);
                                        } // Motherboard
                                        else if (line.trim().substring(10).trim().equals("RAM")) {
                                            prod = new RAM();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                ((RAM) prod).model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                ((RAM) prod).finalPrice = Double.parseDouble(line.trim()
                                                        .substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ")
                                                    || line.trim().startsWith("manufacturer "))
                                                ((RAM) prod).manufacturer = line.trim().substring(13);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("TYPE ") || line.trim().startsWith("type "))
                                                ((RAM) prod).type = line.trim().substring(5);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("SIZE ") || line.trim().startsWith("size "))
                                                ((RAM) prod).size = Integer.parseInt(line.trim().substring(5));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("FREQUENCY ")
                                                    || line.trim().startsWith("frequency "))
                                                ((RAM) prod).frequency = Integer.parseInt(line.trim()
                                                        .substring(10));
                                            line = reader.readLine();
                                            if (line.trim().equals("}"))
                                                or.ordproduct = prod;
                                            addFileOrder(or);
                                        } // RAM
                                        else if (line.trim().substring(10).trim().equals("KEYBOARD")) {
                                            prod = new Keyboard();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                ((Keyboard) prod).model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                ((Keyboard) prod).finalPrice = Double
                                                        .parseDouble(line.trim().substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ")
                                                    || line.trim().startsWith("manufacturer "))
                                                ((Keyboard) prod).manufacturer = line.trim().substring(13);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CONNECTION ")
                                                    || line.trim().startsWith("connection "))
                                                ((Keyboard) prod).connection = line.trim().substring(11);
                                            line = reader.readLine();
                                            if (line.trim().equals("}"))
                                                or.ordproduct = prod;
                                            addFileOrder(or);
                                        } // Keyboard
                                        else if (line.trim().substring(10).trim().equals("MONITOR")) {
                                            prod = new Monitor();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                ((Monitor) prod).model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                ((Monitor) prod).finalPrice = Double
                                                        .parseDouble(line.trim().substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ")
                                                    || line.trim().startsWith("manufacturer "))
                                                ((Monitor) prod).manufacturer = line.trim().substring(13);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("KIND ") || line.trim().startsWith("kind "))
                                                ((Monitor) prod).kind = line.trim().substring(5);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("SCREENSIZE ")
                                                    || line.trim().startsWith("screensize "))
                                                ((Monitor) prod).screensize = Integer
                                                        .parseInt(line.trim().substring(11));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("RESOLUTION ")
                                                    || line.trim().startsWith("resolution "))
                                                ((Monitor) prod).resolution = line.trim().substring(11);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PORTS ") || line.trim().startsWith("ports "))
                                                ((Monitor) prod).ports = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().equals("}"))
                                                or.ordproduct = prod;
                                            addFileOrder(or);
                                        } // Monitor
                                        else if (line.trim().substring(10).trim().equals("MOUSE")) {
                                            prod = new Mouse();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                ((Mouse) prod).model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                ((Mouse) prod).finalPrice = Double
                                                        .parseDouble(line.trim().substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ")
                                                    || line.trim().startsWith("manufacturer "))
                                                ((Mouse) prod).manufacturer = line.trim().substring(13);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("TECHNOLOGY ")
                                                    || line.trim().startsWith("technology "))
                                                ((Mouse) prod).technology = line.trim().substring(11);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CONNECTION ")
                                                    || line.trim().startsWith("connection "))
                                                ((Mouse) prod).connection = line.trim().substring(11);
                                            line = reader.readLine();
                                            if (line.trim().equals("}"))
                                                or.ordproduct = prod;
                                            addFileOrder(or);
                                        } // Mouse
                                        else if (line.trim().substring(10).trim().equals("PRINTER")) {
                                            prod = new Printer();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                ((Printer) prod).model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                ((Printer) prod).finalPrice = Double
                                                        .parseDouble(line.trim().substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ")
                                                    || line.trim().startsWith("manufacturer "))
                                                ((Printer) prod).manufacturer = line.trim().substring(13);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRINT_TYPE ")
                                                    || line.trim().startsWith("print_type "))
                                                ((Printer) prod).technology = line.trim().substring(11);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("TECHNOLOGY ")
                                                    || line.trim().startsWith("technology "))
                                                ((Printer) prod).technology = line.trim().substring(11);
                                            line = reader.readLine();
                                            if (line.trim().equals("}"))
                                                or.ordproduct = prod;
                                            addFileOrder(or);
                                        } // Printer
                                        else {
                                            System.out
                                                    .println("The product with item type: <<" +
                                                            line.trim().substring(10) + ">> is not available!");
                                        }
                                    } // ITEM_TYPE
                                } // ORDER
                            }
                        } // WHILE
                    }
                    reader.close();
                }
            }
        } // try
        catch (IOException e) {
            System.out.println("Error reading line ...");
        }
    }
}
