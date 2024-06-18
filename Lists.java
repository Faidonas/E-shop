import java.util.*;
import java.io.*;

public class Lists {
    // available products list
    public ArrayList<Product> products = new ArrayList<Product>();
    Scanner sc = new Scanner(System.in);

    void storeProduct(Product p) {
        products.add(p);
    }

    void listProducts() {
        for (Product p : products) {
            System.out.println(p.toString());
        }
    }

    int listMotherboards() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Motherboard) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listMotherboard(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Motherboard) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listCPUs() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof CPU) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listCPU(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof CPU) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listGPUs() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof GPU) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listGPU(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof GPU) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listHDDs() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof HardDrive) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listHDD(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof HardDrive) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listKeyboards() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Keyboard) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listKeyboard(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Keyboard) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listMonitors() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Monitor) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listMonitor(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Monitor) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listMousee() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Mouse) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listMouse(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Mouse) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listPrinters() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Printer) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listPrinter(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof Printer) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    int listRAMs() {
        int i = 0;
        for (Product p : products) {
            if (p instanceof RAM) {
                i += 1;
                System.out.println(i + ". " + p.GetModel());
            }
        }
        return i;
    }

    Product listRAM(int n) {
        int i = 0;
        for (Product p : products) {
            if (p instanceof RAM) {
                i += 1;
                if (i == n) {
                    System.out.println(i + ". " + p.toString());
                    return p;
                }
            }
        }
        return null;
    }

    Product GetProduct(String model) {
        for (Product p : products) {
            if (p.GetModel() == model) {
                return p;
            }
        }
        return null;
    }

    void ReadProductFile() {
        BufferedReader reader = null;
        Product prod = null;
        String line;
        System.out.println("\n >>>>>>> Adding Products from file to list ...");
        try {
            reader = new BufferedReader(new FileReader(new File("ITEM_LIST.txt")));
            line = reader.readLine();
            if (line.trim().equals("ITEM_LIST") || line.trim().equals("item_list")) {
                line = reader.readLine();
                if (line.trim().equals("{")) {
                    while (line != null) {
                        line = reader.readLine();
                        if (line != null) {
                            if (line.trim().equals("ITEM") || line.trim().equals("item")) {
                                line = reader.readLine();
                                if (line.trim().equals("{")) {
                                    line = reader.readLine();
                                    if (line.trim().startsWith("ITEM_TYPE ") || line.trim().startsWith("item_type ")) {
                                        if (line.trim().substring(10).trim().equals("MOTHERBOARD") || line.trim()
                                                .substring(10).trim().equals("motherboard")) {// motherboard
                                            prod = new Motherboard();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                prod.model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL_YEAR ") || line.trim()
                                                    .startsWith("model_year "))
                                                prod.model_year = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ") || line.trim()
                                                    .startsWith("manufacturer "))
                                                prod.manufacturer = line.trim().substring(13);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                prod.price = (Double.parseDouble(line.trim().substring(6)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PROSECCOR ") || line.trim()
                                                    .startsWith("proseccor "))
                                                ((Motherboard) prod).processor = (line.trim().substring(10));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MEMORY ") || line.trim().startsWith("memory "))
                                                ((Motherboard) prod).memory = (Integer
                                                        .parseInt(line.trim().substring(7)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("SATA_PORTS ") || line.trim()
                                                    .startsWith("sata_ports "))
                                                ((Motherboard) prod).SATAports = (Integer
                                                        .parseInt(line.trim().substring(11)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PIECES ") || line.trim().startsWith("pieces "))
                                                prod.stock = (Integer.parseInt(line.trim().substring(7)));
                                            line = reader.readLine();
                                            if (line.trim().equals("}")) {
                                                products.add(prod);// motherboard
                                                prod.CalcFinalPrice();
                                            }
                                        } else if (line.trim().substring(10).trim().equals("CPU")) {// CPU
                                            prod = new CPU();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                prod.model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL_YEAR ") || line.trim()
                                                    .startsWith("model_year "))
                                                prod.model_year = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ") || line.trim()
                                                    .startsWith("manufacturer "))
                                                prod.manufacturer = line.trim().substring(13).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                prod.price = (Double.parseDouble(line.trim().substring(6)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("SPEED ") || line.trim().startsWith("speed "))
                                                ((CPU) prod).speed = (Double
                                                        .parseDouble(line.trim().substring(6).trim()));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CORE ") || line.trim().startsWith("core "))
                                                ((CPU) prod).core = (Integer.parseInt(line.trim().substring(5).trim()));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("GRAPHICS ")
                                                    || line.trim().startsWith("graphics "))
                                                ((CPU) prod).graphics = line.trim().substring(9).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PIECES ") || line.trim().startsWith("pieces "))
                                                prod.stock = (Integer.parseInt(line.trim().substring(7)));
                                            line = reader.readLine();
                                            if (line.trim().equals("}")) {
                                                products.add(prod);// CPU
                                                prod.CalcFinalPrice();
                                            }
                                        } else if (line.trim().substring(10).trim().equals("GPU")) {// GPU
                                            prod = new GPU();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                prod.model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL_YEAR ") || line.trim()
                                                    .startsWith("model_year "))
                                                prod.model_year = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ") || line.trim()
                                                    .startsWith("manufacturer "))
                                                prod.manufacturer = line.trim().substring(13).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                prod.price = (Double.parseDouble(line.trim().substring(6)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CHIPSET ")
                                                    || line.trim().startsWith("chipset "))
                                                ((GPU) prod).chipset = line.trim().substring(8).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MEMORY ") || line.trim().startsWith("memory "))
                                                ((GPU) prod).memory = (Integer
                                                        .parseInt(line.trim().substring(7).trim()));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PIECES ") || line.trim().startsWith("pieces "))
                                                prod.stock = (Integer.parseInt(line.trim().substring(7)));
                                            line = reader.readLine();
                                            if (line.trim().equals("}")) {
                                                products.add(prod);// GPU
                                                prod.CalcFinalPrice();
                                            }
                                        } else if (line.trim().substring(10).trim().equals("HARDDRIVE")) {// HDD
                                            prod = new HardDrive();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                prod.model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL_YEAR ") || line.trim()
                                                    .startsWith("model_year "))
                                                prod.model_year = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ") || line.trim()
                                                    .startsWith("manufacturer "))
                                                prod.manufacturer = line.trim().substring(13).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                prod.price = (Double.parseDouble(line.trim().substring(6)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("TYPE ") || line.trim().startsWith("type "))
                                                ((HardDrive) prod).type = line.trim().substring(5).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("SIZE ") || line.trim().startsWith("size "))
                                                ((HardDrive) prod).size = (Double
                                                        .parseDouble(line.trim().substring(5).trim()));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CAPACITY ")
                                                    || line.trim().startsWith("capacity "))
                                                ((HardDrive) prod).capacity = (Integer
                                                        .parseInt(line.trim().substring(9).trim()));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PIECES ") || line.trim().startsWith("pieces "))
                                                prod.stock = (Integer.parseInt(line.trim().substring(7)));
                                            line = reader.readLine();
                                            if (line.trim().equals("}")) {
                                                products.add(prod);// HDD
                                                prod.CalcFinalPrice();
                                            }
                                        } else if (line.trim().substring(10).trim().equals("KEYBOARD")) {// KEYBOARD
                                            prod = new Keyboard();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                prod.model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL_YEAR ") || line.trim()
                                                    .startsWith("model_year "))
                                                prod.model_year = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ") || line.trim()
                                                    .startsWith("manufacturer "))
                                                prod.manufacturer = line.trim().substring(13).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                prod.price = (Double.parseDouble(line.trim().substring(6)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CONNECTION ") || line.trim()
                                                    .startsWith("connection "))
                                                ((Keyboard) prod).connection = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PIECES ") || line.trim().startsWith("pieces "))
                                                prod.stock = (Integer.parseInt(line.trim().substring(7)));
                                            line = reader.readLine();
                                            if (line.trim().equals("}")) {
                                                products.add(prod);// Keyboard
                                                prod.CalcFinalPrice();
                                            }
                                        } else if (line.trim().substring(10).trim().equals("MONITOR")) {// MONITOR
                                            prod = new Monitor();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                prod.model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL_YEAR ") || line.trim()
                                                    .startsWith("model_year "))
                                                prod.model_year = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ") || line.trim()
                                                    .startsWith("manufacturer "))
                                                prod.manufacturer = line.trim().substring(13).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                prod.price = (Double.parseDouble(line.trim().substring(6)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("KIND ") || line.trim().startsWith("kind "))
                                                ((Monitor) prod).kind = line.trim().substring(5).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("SCREEN_SIZE ") || line.trim()
                                                    .startsWith("screen_size "))
                                                ((Monitor) prod).screensize = (Integer
                                                        .parseInt(line.trim().substring(12).trim()));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("RESOLUION ") || line.trim()
                                                    .startsWith("resolution "))
                                                ((Monitor) prod).resolution = line.trim().substring(10).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PORTS ") || line.trim().startsWith("ports "))
                                                ((Monitor) prod).ports = line.trim().substring(6).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PIECES ") || line.trim().startsWith("pieces "))
                                                prod.stock = (Integer.parseInt(line.trim().substring(7)));
                                            line = reader.readLine();
                                            if (line.trim().equals("}")) {
                                                products.add(prod);// Monitor
                                                prod.CalcFinalPrice();
                                            }
                                        } else if (line.trim().substring(10).trim().equals("MOUSE")) {// MOUSE
                                            prod = new Mouse();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                prod.model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL_YEAR ") || line.trim()
                                                    .startsWith("model_year "))
                                                prod.model_year = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ") || line.trim()
                                                    .startsWith("manufacturer "))
                                                prod.manufacturer = line.trim().substring(13).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                prod.price = (Double.parseDouble(line.trim().substring(6)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("TECHNOLOGY ") || line.trim()
                                                    .startsWith("technology "))
                                                ((Mouse) prod).technology = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("CONNECTION ") || line.trim()
                                                    .startsWith("connection "))
                                                ((Mouse) prod).connection = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PIECES ") || line.trim().startsWith("pieces "))
                                                prod.stock = (Integer.parseInt(line.trim().substring(7)));
                                            line = reader.readLine();
                                            if (line.trim().equals("}")) {
                                                products.add(prod);// Mouse
                                                prod.CalcFinalPrice();
                                            }
                                        } else if (line.trim().substring(10).trim().equals("PRINTER")) {// PRINTER
                                            prod = new Printer();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                prod.model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL_YEAR ") || line.trim()
                                                    .startsWith("model_year "))
                                                prod.model_year = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ") || line.trim()
                                                    .startsWith("manufacturer "))
                                                prod.manufacturer = line.trim().substring(13).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                prod.price = (Double.parseDouble(line.trim().substring(6)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("TECHNOLOGY ") || line.trim()
                                                    .startsWith("technology "))
                                                ((Printer) prod).technology = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRINT_TYPE ") || line.trim()
                                                    .startsWith("print_type "))
                                                ((Printer) prod).print_type = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PIECES ") || line.trim().startsWith("pieces "))
                                                prod.stock = (Integer.parseInt(line.trim().substring(7)));
                                            line = reader.readLine();
                                            if (line.trim().equals("}")) {
                                                products.add(prod);// Printer
                                                prod.CalcFinalPrice();
                                            }
                                        } else if (line.trim().substring(10).trim().equals("RAM")) {// RAM
                                            prod = new RAM();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL ") || line.trim().startsWith("model "))
                                                prod.model = line.trim().substring(6);
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MODEL_YEAR ") || line.trim()
                                                    .startsWith("model_year "))
                                                prod.model_year = line.trim().substring(11).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("MANUFACTURER ") || line.trim()
                                                    .startsWith("manufacturer "))
                                                prod.manufacturer = line.trim().substring(13).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PRICE ") || line.trim().startsWith("price "))
                                                prod.price = (Double.parseDouble(line.trim().substring(6)));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("TYPE ") || line.trim().startsWith("type "))
                                                ((RAM) prod).type = line.trim().substring(5).trim();
                                            line = reader.readLine();
                                            if (line.trim().startsWith("SIZE ") || line.trim().startsWith("size "))
                                                ((RAM) prod).size = (Integer.parseInt(line.trim().substring(5).trim()));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("FREQUENCY ") || line.trim()
                                                    .startsWith("frequency "))
                                                ((RAM) prod).frequency = (Integer
                                                        .parseInt(line.trim().substring(10).trim()));
                                            line = reader.readLine();
                                            if (line.trim().startsWith("PIECES ") || line.trim().startsWith("pieces "))
                                                prod.stock = (Integer.parseInt(line.trim().substring(7)));
                                            line = reader.readLine();
                                            if (line.trim().equals("}")) {
                                                products.add(prod);// RAM
                                                prod.CalcFinalPrice();
                                            }
                                        }

                                    } // ITEM TYPE
                                }
                            } // ITEM
                        }
                    }
                    line = reader.readLine();
                } // while
                reader.close();
            } // ITEM_LIST
        } // try

        catch (

        IOException e) {
            System.out.println("Error reading line ...");
        }
    }
}