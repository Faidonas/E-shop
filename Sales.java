import java.util.*;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Sales {
    DateTimeFormatter myOtherFormat = DateTimeFormatter.ofPattern("dd-MMMM-yyyy");

    public ArrayList<Sale> sales = new ArrayList<Sale>();
    int saleID = 0;

    void addSale(Sale s) {
        saleID += 1;
        s.SetSalesID(saleID);
        sales.add(s);
    }

    void addFileSale(Sale s) {
        saleID = Integer.max(saleID, s.GetSalesID());
        sales.add(s);
    }

    int ShowSales() {
        System.out.println("Overview Sales:");
        int i = 0;
        for (Sale s : sales) {
            System.out.println("\nSale with Id = " + s.saleID);
            i += 1;
        }
        return i;
    }

    Sale listSales(int n) {
        int i = 0;
        for (Sale s : sales) {
            i += 1;
            if (i == n) {
                return s;
            }
        }
        return null;
    }

    // private Sale ss;

    public void CreateSalesFile() {
        FileWriter writer = null;
        Product nextprod;
        System.out.println("\n >>>>>>> Adding Sales from list to file ...");
        try {
            writer = new FileWriter(new File("sales.txt"));
            writer.write("SALE_LIST \n{");
            for (Sale ss : sales) {
                if (ss != null) {
                    nextprod = ss.soldproduct;
                    if (nextprod instanceof CPU) {
                        writer.write("\n" + "\t" + "SALE" + "\n" + "\t" + "{"
                                + "\n" + "\t\t" + "NUMBER " + ss.GetSalesID()
                                + "\n" + "\t\t" + "NAME " + ss.cus_name
                                + "\n" + "\t\t" + "PHONE " + ss.cus_phone
                                + "\n" + "\t\t" + "SALE_DATE " + ss.other_form_sale_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "CPU"
                                + "\n" + "\t\t" + "MODEL " + nextprod.model
                                + "\n" + "\t\t" + "PRICE " + ((CPU) nextprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nextprod.manufacturer
                                + "\n" + "\t\t" + "SPEED " + ((CPU) nextprod).speed
                                + "\n" + "\t\t" + "CORE " + ((CPU) nextprod).core
                                + "\n" + "\t\t" + "GRAPHICS " + ((CPU) nextprod).graphics
                                + "\n" + "\t" + "}" + "\n");
                    } // CPU
                    else if (nextprod instanceof GPU) {
                        writer.write("\t" + "SALE" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + ss.GetSalesID()
                                + "\n" + "\t\t" + "NAME " + ss.cus_name
                                + "\n" + "\t\t" + "PHONE " + ss.cus_phone
                                + "\n" + "\t\t" + "SALE_DATE " + ss.other_form_sale_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "GPU"
                                + "\n" + "\t\t" + "MODEL " + nextprod.model
                                + "\n" + "\t\t" + "PRICE " + ((GPU) nextprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nextprod.manufacturer
                                + "\n" + "\t\t" + "CHIPSET " + ((GPU) nextprod).chipset
                                + "\n" + "\t\t" + "MEMORY " + ((GPU) nextprod).memory
                                + "\n" + "\t" + "}" + "\n");
                    } // GPU
                    else if (nextprod instanceof HardDrive) {
                        writer.write("\t" + "SALE" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + ss.GetSalesID()
                                + "\n" + "\t\t" + "NAME " + ss.cus_name
                                + "\n" + "\t\t" + "PHONE " + ss.cus_phone
                                + "\n" + "\t\t" + "SALE_DATE " + ss.other_form_sale_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "HARDDRIVE"
                                + "\n" + "\t\t" + "MODEL " + nextprod.model
                                + "\n" + "\t\t" + "PRICE " + ((HardDrive) nextprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nextprod.manufacturer
                                + "\n" + "\t\t" + "TYPE " + ((HardDrive) nextprod).type
                                + "\n" + "\t\t" + "SIZE " + ((HardDrive) nextprod).size
                                + "\n" + "\t\t" + "CAPACITY " + ((HardDrive) nextprod).capacity
                                + "\n" + "\t" + "}" + "\n");
                    } // Hard Drive
                    else if (nextprod instanceof Motherboard) {
                        writer.write("\t" + "SALE" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + ss.GetSalesID()
                                + "\n" + "\t\t" + "NAME " + ss.cus_name
                                + "\n" + "\t\t" + "PHONE " + ss.cus_phone
                                + "\n" + "\t\t" + "SALE_DATE " + ss.other_form_sale_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "MOTHERBOARD"
                                + "\n" + "\t\t" + "MODEL " + nextprod.model
                                + "\n" + "\t\t" + "PRICE " + ((Motherboard) nextprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nextprod.manufacturer
                                + "\n" + "\t\t" + "PROCESSOR " + ((Motherboard) nextprod).processor
                                + "\n" + "\t\t" + "MEMORY " + ((Motherboard) nextprod).memory
                                + "\n" + "\t\t" + "SATAPORTS " + ((Motherboard) nextprod).SATAports
                                + "\n" + "\t" + "}" + "\n");
                    } // MotherBoard
                    else if (nextprod instanceof RAM) {
                        writer.write("\t" + "SALE" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + ss.GetSalesID()
                                + "\n" + "\t\t" + "NAME " + ss.cus_name
                                + "\n" + "\t\t" + "PHONE " + ss.cus_phone
                                + "\n" + "\t\t" + "SALE_DATE " + ss.other_form_sale_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "RAM"
                                + "\n" + "\t\t" + "MODEL " + nextprod.model
                                + "\n" + "\t\t" + "PRICE " + ((RAM) nextprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nextprod.manufacturer
                                + "\n" + "\t\t" + "TYPE " + ((RAM) nextprod).type
                                + "\n" + "\t\t" + "SIZE " + ((RAM) nextprod).size
                                + "\n" + "\t\t" + "FREQUENCY " + ((RAM) nextprod).frequency
                                + "\n" + "\t" + "}" + "\n");
                    } // RAM
                    else if (nextprod instanceof Keyboard) {
                        writer.write("\t" + "SALE" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + ss.GetSalesID()
                                + "\n" + "\t\t" + "NAME " + ss.cus_name
                                + "\n" + "\t\t" + "PHONE " + ss.cus_phone
                                + "\n" + "\t\t" + "SALE_DATE " + ss.other_form_sale_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "KEYBOARD"
                                + "\n" + "\t\t" + "MODEL " + nextprod.model
                                + "\n" + "\t\t" + "PRICE " + ((Keyboard) nextprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nextprod.manufacturer
                                + "\n" + "\t\t" + "CONNECTION " + ((Keyboard) nextprod).connection
                                + "\n" + "\t" + "}" + "\n");
                    } // Keyboard
                    else if (nextprod instanceof Monitor) {
                        writer.write("\t" + "ORDER" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + ss.GetSalesID()
                                + "\n" + "\t\t" + "NAME " + ss.cus_name
                                + "\n" + "\t\t" + "PHONE " + ss.cus_phone
                                + "\n" + "\t\t" + "SALE_DATE " + ss.other_form_sale_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "MONITOR"
                                + "\n" + "\t\t" + "MODEL " + nextprod.model
                                + "\n" + "\t\t" + "PRICE " + ((Monitor) nextprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nextprod.manufacturer
                                + "\n" + "\t\t" + "KIND " + ((Monitor) nextprod).kind
                                + "\n" + "\t\t" + "SCREEN SIZE " + ((Monitor) nextprod).screensize
                                + "\n" + "\t\t" + "RESOLUTION " + ((Monitor) nextprod).resolution
                                + "\n" + "\t\t" + "PORTS " + ((Monitor) nextprod).ports
                                + "\n" + "\t" + "}" + "\n");
                    } // Monitor
                    else if (nextprod instanceof Mouse) {
                        writer.write("\t" + "SALE" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + ss.GetSalesID()
                                + "\n" + "\t\t" + "NAME " + ss.cus_name
                                + "\n" + "\t\t" + "PHONE " + ss.cus_phone
                                + "\n" + "\t\t" + "SALE_DATE " + ss.other_form_sale_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "MOUSE"
                                + "\n" + "\t\t" + "MODEL " + nextprod.model
                                + "\n" + "\t\t" + "PRICE " + ((Mouse) nextprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nextprod.manufacturer
                                + "\n" + "\t\t" + "TECHNOLOGY " + ((Mouse) nextprod).getTechnology()
                                + "\n" + "\t\t" + "CONNECTION " + ((Mouse) nextprod).getConnection()
                                + "\n" + "\t" + "}" + "\n");
                    } // Mouse
                    else if (nextprod instanceof Printer) {
                        writer.write("\t" + "SALE" + "\n" + "{"
                                + "\n" + "\t\t" + "NUMBER " + ss.GetSalesID()
                                + "\n" + "\t\t" + "NAME " + ss.cus_name
                                + "\n" + "\t\t" + "PHONE " + ss.cus_phone
                                + "\n" + "\t\t" + "SALE_DATE " + ss.other_form_sale_date
                                + "\n" + "\t\t" + "ITEM_TYPE " + "PRINTER"
                                + "\n" + "\t\t" + "MODEL " + nextprod.model
                                + "\n" + "\t\t" + "PRICE " + ((Printer) nextprod).finalPrice
                                + "\n" + "\t\t" + "MANUFACTURER " + nextprod.manufacturer
                                + "\n" + "\t\t" + "PRINT_TYPE " + ((Printer) nextprod).print_type
                                + "\n" + "\t\t" + "TECHNOLOGY " + ((Printer) nextprod).technology
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

    void ReadSalesFile() {
        BufferedReader reader = null;
        Product prod = null;
        String line;
        System.out.println("\n >>>>>>> Adding Sales from file to list ...");
        try {
            reader = new BufferedReader(new FileReader(new File("sales.txt")));
            line = reader.readLine();
            if (line != null) {
                if (line.trim().equals("SALE_LIST") || line.trim().equals("sale_list")) {
                    line = reader.readLine();
                    if (line.trim().equals("{")) {
                        while ((line = reader.readLine()) != null) {
                            if (line.trim().startsWith("SALE") || line.trim().equals("sale")) {
                                line = reader.readLine();
                                if (line.trim().equals("{")) {
                                    line = reader.readLine();
                                    Sale sal = new Sale();
                                    if (line.trim().startsWith("NUMBER ") || line.trim().startsWith("number "))
                                        sal.SetSalesID(Integer.parseInt(line.trim().substring(7)));
                                    line = reader.readLine();
                                    if (line.trim().startsWith("NAME ") || line.trim().startsWith("name "))
                                        sal.cus_name = line.trim().substring(5);
                                    line = reader.readLine();
                                    if (line.trim().startsWith("PHONE ") || line.trim().startsWith("phone "))
                                        sal.cus_phone = Integer.parseInt(line.trim().substring(6));
                                    line = reader.readLine();
                                    if (line.trim().startsWith("SALE_DATE ") || line.trim().startsWith("sale_date "))
                                        sal.sal_date = LocalDate.parse((line.trim()
                                                .substring(10)), myOtherFormat);
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
                                                ((CPU) prod).speed = Double.parseDouble(line.trim()
                                                        .substring(6));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CORE ") || line.trim().startsWith("core "))
                                                ((CPU) prod).core = Integer.parseInt(line.trim().substring(5));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("GRAPHICS ")
                                                    || line.trim().startsWith("graphics "))
                                                ((CPU) prod).graphics = line.trim().substring(9);
                                            line = reader.readLine();
                                            if (line.trim().equals("}"))
                                                sal.soldproduct = prod;
                                            addFileSale(sal);
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
                                                sal.soldproduct = prod;
                                            addFileSale(sal);
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
                                                sal.soldproduct = prod;
                                            addFileSale(sal);
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
                                                sal.soldproduct = prod;
                                            addFileSale(sal);
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
                                                sal.soldproduct = prod;
                                            addFileSale(sal);
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
                                                sal.soldproduct = prod;
                                            addFileSale(sal);
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
                                            if (line.trim().startsWith("KIND ")
                                                    || line.trim().startsWith("kind "))
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
                                                sal.soldproduct = prod;
                                            addFileSale(sal);
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
                                                sal.soldproduct = prod;
                                            addFileSale(sal);
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
                                                sal.soldproduct = prod;
                                            addFileSale(sal);
                                        } // Printer
                                        else {
                                            System.out
                                                    .println("The product with item type: <<" +
                                                            line.trim().substring(10) + ">> is not available!");
                                        }
                                    } // ITEM_TYPE
                                } // SALE
                            }
                        } // while
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
