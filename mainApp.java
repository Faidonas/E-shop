
import java.util.*;
import java.time.LocalDate;

public class mainApp {
    public static void main(String args[]) {
        Lists myLists = new Lists();
        Sales mySales = new Sales();
        Orders myOrders = new Orders();

        Scanner sc = new Scanner(System.in);
        boolean done = false, done2 = false, done3 = false;
        String choice0, choice1, choice2, choice3;
        int nItems = 0;

        myLists.ReadProductFile();
        myOrders.ReadOrdersFile();
        mySales.ReadSalesFile();

        while (!done) {
            System.out.println("\n1. Overview Available Products");
            System.out.println("2. Overview Orders");
            System.out.println("3. Overview Sales");
            System.out.println("4. Exit");
            System.out.println("5. Write txt documents\n");
            choice0 = sc.nextLine();
            int _choice0 = 0;
            try {
                _choice0 = Integer.parseInt(choice0);
            } catch (NumberFormatException e) {
                continue;
            }
            if (_choice0 < 1 || _choice0 > 5)
                continue;

            done2 = false;
            while (!done2) {

                // CHOICE = 1; Overview Available Products ----->
                if (choice0.equals("1")) {
                    System.out.println("\nChoose a category: 1. Hardware / 2. Peripherals / 3. Back");
                    choice1 = sc.nextLine();
                    if (Integer.parseInt(choice1) == 3)
                        break; // fallback to main menu

                    done3 = false;
                    while (!done3) {
                        // SUBMENU1 = HARDWARE
                        if (choice1.equals("1")) {
                            System.out.println(
                                    "\nChoose product type: 1. CPU / 2. GPU / 3. Hard Disk Drive / 4. Motherboard / 5. RAM / 6. Back");
                            choice2 = sc.nextLine();
                            if (choice2.equals("1")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listCPUs();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product cpu = myLists.listCPU(nChoice);
                                        if (cpu.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Long.parseLong(sc.nextLine());
                                                sale.soldproduct = cpu;
                                                mySales.addSale(sale);
                                                cpu.ReduceStock();
                                                System.out.println("\nSales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Long.parseLong(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    order.customer_date = LocalDate.parse(order.del_date,
                                                            order.myFormat);
                                                    order.customer_other_date = order.myOtherFormat.format(
                                                            order.customer_date);
                                                    if (order.ordr_date.isBefore(order.customer_date) == false) {
                                                        order.customer_date = LocalDate.now();
                                                        order.customer_other_date = order.customer_date.format(
                                                                order.myOtherFormat);
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = cpu;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else if (choice2.equals("2")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listGPUs();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product gpu = myLists.listGPU(nChoice);
                                        if (gpu.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Long.parseLong(sc.nextLine());
                                                sale.soldproduct = gpu;
                                                mySales.addSale(sale);
                                                gpu.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Long.parseLong(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    order.customer_date = LocalDate.parse(order.del_date,
                                                            order.myFormat);
                                                    order.customer_other_date = order.myOtherFormat.format(
                                                            order.customer_date);
                                                    if (order.ordr_date.isBefore(order.customer_date) == false) {
                                                        order.customer_date = LocalDate.now();
                                                        order.customer_other_date = order.customer_date.format(
                                                                order.myOtherFormat);
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = gpu;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else if (choice2.equals("3")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listHDDs();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product hdd = myLists.listHDD(nChoice);
                                        if (hdd.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Long.parseLong(sc.nextLine());
                                                sale.soldproduct = hdd;
                                                mySales.addSale(sale);
                                                hdd.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Long.parseLong(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    order.customer_date = LocalDate.parse(order.del_date,
                                                            order.myFormat);
                                                    order.customer_other_date = order.myOtherFormat.format(
                                                            order.customer_date);
                                                    if (order.ordr_date.isBefore(order.customer_date) == false) {
                                                        order.customer_date = LocalDate.now();
                                                        order.customer_other_date = order.customer_date.format(
                                                                order.myOtherFormat);
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = hdd;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }

                            } else if (choice2.equals("4")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listMotherboards();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product motherboard = myLists.listMotherboard(nChoice);
                                        if (motherboard.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Long.parseLong(sc.nextLine());
                                                sale.soldproduct = motherboard;
                                                mySales.addSale(sale);
                                                motherboard.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Long.parseLong(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    order.customer_date = LocalDate.parse(order.del_date,
                                                            order.myFormat);
                                                    order.customer_other_date = order.myOtherFormat.format(
                                                            order.customer_date);
                                                    if (order.ordr_date.isBefore(order.customer_date) == false) {
                                                        order.customer_date = LocalDate.now();
                                                        order.customer_other_date = order.customer_date.format(
                                                                order.myOtherFormat);
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = motherboard;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else if (choice2.equals("5")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listRAMs();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product ram = myLists.listRAM(nChoice);
                                        if (ram.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Long.parseLong(sc.nextLine());
                                                sale.soldproduct = ram;
                                                mySales.addSale(sale);
                                                ram.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Long.parseLong(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    order.customer_date = LocalDate.parse(order.del_date,
                                                            order.myFormat);
                                                    order.customer_other_date = order.myOtherFormat.format(
                                                            order.customer_date);
                                                    if (order.ordr_date.isBefore(order.customer_date) == false) {
                                                        order.customer_date = LocalDate.now();
                                                        order.customer_other_date = order.customer_date.format(
                                                                order.myOtherFormat);
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = ram;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else
                                break;

                        } else if (choice1.equals("2")) {
                            System.out.println(
                                    "\nChoose product type: 1. Printer / 2. Keyboard / 3. Monitor / 4. Mouse / 5. Back");
                            choice2 = sc.nextLine();
                            if (choice2.equals("1")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listPrinters();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product printer = myLists.listPrinter(nChoice);
                                        if (printer.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Long.parseLong(sc.nextLine());
                                                sale.soldproduct = printer;
                                                mySales.addSale(sale);
                                                printer.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Long.parseLong(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    order.customer_date = LocalDate.parse(order.del_date,
                                                            order.myFormat);
                                                    order.customer_other_date = order.myOtherFormat.format(
                                                            order.customer_date);
                                                    if (order.ordr_date.isBefore(order.customer_date) == false) {
                                                        order.customer_date = LocalDate.now();
                                                        order.customer_other_date = order.customer_date.format(
                                                                order.myOtherFormat);
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = printer;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else if (choice2.equals("2")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listKeyboards();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product keyboard = myLists.listKeyboard(nChoice);
                                        if (keyboard.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Long.parseLong(sc.nextLine());
                                                sale.soldproduct = keyboard;
                                                mySales.addSale(sale);
                                                keyboard.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Long.parseLong(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    order.customer_date = LocalDate.parse(order.del_date,
                                                            order.myFormat);
                                                    order.customer_other_date = order.myOtherFormat.format(
                                                            order.customer_date);
                                                    if (order.ordr_date.isBefore(order.customer_date) == false) {
                                                        order.customer_date = LocalDate.now();
                                                        order.customer_other_date = order.customer_date.format(
                                                                order.myOtherFormat);
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = keyboard;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }

                            } else if (choice2.equals("3")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listMonitors();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product monitor = myLists.listMonitor(nChoice);
                                        if (monitor.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Long.parseLong(sc.nextLine());
                                                sale.soldproduct = monitor;
                                                mySales.addSale(sale);
                                                monitor.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Long.parseLong(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    order.customer_date = LocalDate.parse(order.del_date,
                                                            order.myFormat);
                                                    order.customer_other_date = order.myOtherFormat.format(
                                                            order.customer_date);
                                                    if (order.ordr_date.isBefore(order.customer_date) == false) {
                                                        order.customer_date = LocalDate.now();
                                                        order.customer_other_date = order.customer_date.format(
                                                                order.myOtherFormat);
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }

                                                order.ordproduct = monitor;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }

                                        done3 = true;
                                        done2 = true;
                                    }
                                }

                            } else if (choice2.equals("4")) {
                                System.out.println("\nChoose your product");
                                nItems = myLists.listMousee();
                                if (nItems > 0) {
                                    System.out.println((nItems + 1) + ". Back");
                                    choice3 = sc.nextLine();
                                    int nChoice = Integer.parseInt(choice3);
                                    done3 = nChoice > nItems ? false : true;
                                    if (nChoice > 0 && nChoice <= nItems) {
                                        Product mouse = myLists.listMouse(nChoice);
                                        if (mouse.GetStock() > 0) {
                                            System.out.println("\nDo you want to purchase the product (Y\\N)?");
                                            String buyProd = sc.nextLine();
                                            if (buyProd.equals("Y") || buyProd.equals("y")) {
                                                Sale sale = new Sale();
                                                System.out.println("Enter your name: ");
                                                sale.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                sale.cus_phone = Long.parseLong(sc.nextLine());
                                                sale.soldproduct = mouse;
                                                mySales.addSale(sale);
                                                mouse.ReduceStock();
                                                System.out.println("Sales ID: " + sale.GetSalesID());
                                                System.out.println("Sales Date: " + sale.sale_date);
                                            }
                                        } else {
                                            System.out.println(
                                                    "\nOut of Stock!! Do you want to order the product (Y\\N)?");
                                            String orderProd = sc.nextLine();
                                            if (orderProd.equals("Y") || orderProd.equals("y")) {
                                                Order order = new Order();
                                                System.out.println("Enter your name: ");
                                                order.cus_name = sc.nextLine();
                                                System.out.println("Enter your phone number: ");
                                                order.cus_phone = Long.parseLong(sc.nextLine());
                                                System.out.println("Order date: " + order.order_date);
                                                boolean done4 = false;
                                                while (!done4) {
                                                    System.out.println("\nEnter desirable arrival date (dd-MM-yyyy):");
                                                    order.del_date = sc.nextLine();
                                                    order.customer_date = LocalDate.parse(order.del_date,
                                                            order.myFormat);
                                                    order.customer_other_date = order.myOtherFormat.format(
                                                            order.customer_date);
                                                    if (order.ordr_date.isBefore(order.customer_date) == false) {
                                                        order.customer_date = LocalDate.now();
                                                        order.customer_other_date = order.customer_date.format(
                                                                order.myOtherFormat);
                                                        System.out.println(
                                                                "\nDesirable date should be later than today!! Try again...");
                                                        continue;
                                                    }
                                                    done4 = true;
                                                }
                                                order.ordproduct = mouse;
                                                myOrders.addOrder(order);
                                                System.out.println("Orders ID: " + order.GetOrderID());
                                            }
                                        }
                                        done3 = true;
                                        done2 = true;
                                    }
                                }
                            } else
                                break;
                        }
                    }

                } else if (choice0.equals("2")) {
                    if (myOrders.ShowOrders() > 0) {
                        System.out.print("\nChoose order ID: ");
                        int num_order = Integer.parseInt(sc.nextLine());
                        Order o = myOrders.listOrders(num_order);
                        System.out.println(o.toString());
                        if (o.order_state != "Complete") {
                            System.out.println("\nDo you want to complete the order?(Y\\N)");
                            String choice5 = sc.nextLine();
                            if (choice5.equals("Y") || choice5.equals("y")) {
                                Sale s = new Sale();
                                s.cus_name = o.cus_name;
                                s.cus_phone = o.cus_phone;
                                s.sale_date = o.del_date;
                                s.finalprice = o.finalprice;
                                o.order_state = "Complete";
                                mySales.addSale(s);
                                System.out.println("\nThe order is complete!");
                            }
                        }
                    } else
                        System.out.println("\nThere are no orders");
                    done2 = true;
                } else if (choice0.equals("3")) {
                    if (mySales.ShowSales() > 0) {
                        System.out.print("\nChoose sale ID:");
                        int num_sale = Integer.parseInt(sc.nextLine());
                        Sale s = mySales.listSales(num_sale);
                        System.out.println(s.toString());
                    } else
                        System.out.println("\nThere are no sales");
                    done2 = true;
                } else if (choice0.equals("4")) {
                    mySales.CreateSalesFile();
                    myOrders.CreateOrdersFile();
                    done = true;
                    break;
                } else if (choice0.equals("5")) {
                    mySales.CreateSalesFile();
                    myOrders.CreateOrdersFile();
                    done2 = true;
                }
            }
        }
        sc.close();
    }
}
