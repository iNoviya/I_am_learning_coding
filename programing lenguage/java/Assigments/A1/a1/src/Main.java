/**
 * @author b2230356164 Muhammet Mustafa KARATAS
 * It is the main class that contains all the necessary operations and methods.
 */

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        /**
            reads file with argument
        */
        String inputProductFileName = args[0];
        String inputPurchaseFileName = args[1];
        String outputFileName = args[2];
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));

        /**
         * Stores product data in class
         */
        List<Product> products = preliminaryProduct( readFile(inputProductFileName));
        /**
         * Stores purchase data in class
         */
        List<Purchase> purchases = preliminaryPurchase( readFile(inputPurchaseFileName),writer);
        /**
         * Stores the order in which the products are placed on the gym machine.
         */
        List<String> productsPlacementList = productPlacementList( readFile(inputProductFileName));

        /**
         * It stores the product numbers in the slots on the machine. defaults to "0".
         */
        int[][] slots = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        /**
         * It stores the slot names of the products placed in the machine. By default it is "null".
         */
        String[][] slotsName = {
                {null,null,null,null},
                {null,null,null,null},
                {null,null,null,null},
                {null,null,null,null},
                {null,null,null,null},
                {null,null,null,null}
        };

        gymLoud(productsPlacementList,slots,slotsName,writer);

        gymHave(products, slots, slotsName, writer);

        buy (products , purchases , slots , slotsName , writer);
    }


    /**
     * It reads files and adds them to the string list structure.
     * @param inputFileName     its save file way in dist/server etc
     * @return
     */
    private static List<String> readFile(String inputFileName) {
        File INPUT_FILE = new File(inputFileName);

        List<String> inputList = new ArrayList<>();

        try (BufferedReader i1Reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            String row;
            while ((row = i1Reader.readLine()) != null) {
                inputList.add(row);
            }
        } catch (IOException e) {
            System.out.println("File read error: " + e.getMessage());
        }
        return inputList;
    }


    /**
     *  It separates the data in the bill of materials in the appropriate format and assigns it to a set list.
     *  The resulting unit converts the data in the list into a list and assigns it to a class structure.
     * @param event     It is the data read from the input file.
     * @return      its return Product class veriables
     */
    public static List<Product> preliminaryProduct(List<String> event){

        /**
         * throws the products into the set.
         */
        Set<List<Object>> productSet = new HashSet<>();
        for (String line : event){
            List<Object> row = new ArrayList<>();
            String[] parts = line.split("\t");

            String name = parts[0];

            int price = Integer.parseInt(parts[1]);
            String[] number = parts[2].split(" ");

            double protein = Double.parseDouble(number[0]);
            double carbohydrate = Double.parseDouble(number[1]);
            double fat = Double.parseDouble(number[2]);

            /**
             * calculates the calories of the product and rounds it to the nearest whole number.
             */
            int calorie = (int) Math.round((4*protein) + (4*carbohydrate) + (9* fat));

            row.add(name);
            row.add(price);
            row.add(protein);
            row.add(carbohydrate);
            row.add(fat);
            row.add(calorie);

            productSet.add(row);
        }

        /**
         * Converts the set structure to a list structure.
         */
        List<List<Object>> productList = new ArrayList<>();
        for (List<Object> icSet : productSet) {
            List<Object> icList = new ArrayList<>(icSet);
            productList.add(icList);
        }

        /**
         * Assigns the resulting list into the class
         */
        List<Product> products = new ArrayList<>();
        for (List<Object> row : productList) {
            String name = (String) row.get(0);
            int price = (Integer) row.get(1);
            double protein = (Double) row.get(2);
            double carbohydrate = (Double) row.get(3);
            double fat = (Double) row.get(4);
            int calorie = (Integer) row.get(5);

            products.add(new Product(name, price, protein, carbohydrate, fat, calorie));
        }
        return products;
    }

    /**
     * It adds the operations and variables to be performed on the machine into the class in an appropriate format.
     * It also checks whether the coins added to the machine are suitable for the machine.
     * @param event     It is the data read from the input file.
     * @param writer    Required parameter to print file
     * @return          Returns the purchase class
     * @throws IOException
     */
    public static List<Purchase> preliminaryPurchase(List<String> event,BufferedWriter writer) throws IOException {
        List<List<Object>> purchasesList = new ArrayList<>();

        for (String line : event) {
            List<Object> row = new ArrayList<>();

            String[] parts = line.split("\t");
            String typeOfMoney = parts[0];

            /**
             * It checks the money loaded into the machine.
             */
            int[] validValues = {1, 5, 10, 20, 50, 100, 200};
            int totalMoneys =0;
            String[] moneys = parts[1].split(" ");
            for (String stringMoney : moneys){
                int money = Integer.parseInt(stringMoney);
                boolean isValid = false;
                for (int validValue : validValues) {
                    if (money == validValue) {
                        isValid = true;
                        totalMoneys +=money;
                        break;
                    }
                }
                if (!isValid) {
                    writer.write(money + " is not a valid value.");
                }
            }

            String chose = parts[2];
            Integer value = Integer.parseInt(parts[3]);

            row.add(typeOfMoney);
            row.add(totalMoneys);
            row.add(chose);
            row.add(value);
            row.add(line);

            purchasesList.add(row);
        }
        /**
         * throws it into the class.
         */
        List<Purchase> purchase = new ArrayList<>();
        for (List<Object> row : purchasesList) {
            String typeOfMoney = (String) row.get(0);
            int totalMoneys = (Integer) row.get(1);
            String typeOfChose = (String) row.get(2);
            int enteredParameter = (int) row.get(3);
            String rowList = (String) row.get(4);

            purchase.add(new Purchase(typeOfMoney, totalMoneys, typeOfChose, enteredParameter,rowList));
        }
        return purchase;
    }

    /**
     * Stores the order in which products are placed into the machine.
     * @param event     It is the data read from the input file.
     * @return          Returns the list of product placements
     */
    public static List<String> productPlacementList(List<String> event){
        List<String> placementList = new ArrayList<>();

        for (String line : event){
            List<Object> row = new ArrayList<>();
            String[] parts = line.split("\t");
            String name = parts[0];

            placementList.add(name);
        }
        return placementList;
    }

    /**
     * It is the method that places the products into the machine.
     * @param productPlacementList      this is prodyct placement list
     * @param slots                     stores product counts on the machine
     * @param slotsName                 It stores the names of the locations of the products positioned in the slots.
     * @param writer                    Required parameter to print file
     * @throws IOException
     */
    public static void gymLoud (
            List<String> productPlacementList,
            int[][] slots,
            String[][] slotsName,
            BufferedWriter writer) throws IOException {
        for (int i =0 ; i < productPlacementList.size(); i++){

            int checkSettl = 0;
            int flag =0;

            /**
             *  This code block runs if the machine is full. It shows the user that the machine is full.
             */
            if (fill(slots)){
                String text = "INFO: There is no available place to put "+productPlacementList.get(i)+"\n";
                writer.write(text);
                writer.flush();
                text = "INFO: The machine is full!\n";
                writer.write(text);
                writer.flush();
                break;
            }
            /**
             * loads products into the machine
             */
            for (int r = 0; r < 6; r++){
                for (int c =0; c < 4; c++ ){
                    if (slotsName[r][c] != null ){
                        if ( productPlacementList.get(i).equals(slotsName[r][c])){
                            if (slots[r][c] != 10 ){
                                slots[r][c] +=1;
                                checkSettl =1;
                                flag = 1;
                                break;
                            }
                            else{ continue;
                            }
                        }
                        else continue;

                    }
                    /**
                     * If there is no room for the product trying to be installed on the machine,
                     *  this code block runs and gives the necessary feedback to the user.
                     */
                    else {
                        slotsName[r][c] = productPlacementList.get(i);
                        slots[r][c] +=1;
                        checkSettl =1;
                        flag = 1;
                        break;
                    }
                }
                if (flag == 1)break;
            }
            if (checkSettl == 0) {
                String text = "INFO: There is no available place to put "+productPlacementList.get(i)+"\n";
                writer.write(text);
                writer.flush();
            }
        }
    }

    /**
     * It checks whether the machine is full or not.
     * @param slots     stores product counts on the machine
     * @return          true or false
     */
    public static boolean fill(int[][] slots){
        for (int r = 0; r <6; r++ ){
            for (int c = 0; c <4 ; c++) {
                if (slots[r][c] != 10) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * It shows the user which products are in the machine and how many they are.
     * @param products      This is class of product
     * @param slots         stores product counts on the machine
     * @param slotsName     It stores the names of the locations of the products positioned in the slots.
     * @param writer        Required parameter to print file
     * @throws IOException
     */
    public static void gymHave(
            List<Product> products,
            int[][] slots,
            String[][] slotsName,
            BufferedWriter writer) throws IOException{
        writer.write("-----Gym Meal Machine-----\n");

        for (int r = 0 ; r < 6 ; r++){
            String text = "";
            for (int c = 0 ; c < 4 ; c++){
                if (slotsName[r][c] == null){
                    text =  "___(0, 0)___";
                    writer.write(text);
                    writer.flush();
                } else {
                    String productName = slotsName[r][c];
                    int eCalorie = 0;
                    for (Product product : products) {
                        String eName = (String) product.getName();
                        eCalorie = (Integer) product.getCalorie();

                        if (eName.equals(productName)) {
                            text = slotsName[r][c] + "(" + eCalorie + ", " + slots[r][c] + ")___";
                            writer.write(text);
                            writer.flush();
                            break;
                        }
                    }
                }
            }
            writer.write("\n");
        }
        writer.write("----------\n");
        writer.flush();
    }

    /**
     *  It is the main function that handles purchasing transactions.
     * @param products      This is class of product
     * @param purchases     This is class of purchase
     * @param slots         stores product counts on the machine
     * @param slotsName     It stores the names of the locations of the products positioned in the slots.
     * @param writer        Required parameter to print file
     * @throws IOException
     */
    private static void buy(
            List<Product> products,
            List<Purchase> purchases,
            int[][] slots,
            String[][] slotsName,
            BufferedWriter writer) throws IOException {
        int flag = 0;
        for (Purchase purchase : purchases){

            writer.write("INPUT: "+(String) purchase.getRowList() +"\n");

            int eMoney = (Integer) purchase.getTotalMoney();
            String eType = (String) purchase.getChoice();
            int eParameter = (Integer) purchase.getValue();

            /**
             * If the user selects the slot number, this code block runs and gives the necessary feedback.
             */
            if (eType.equals("NUMBER")){
                String text;
                int r = (Integer) eParameter / 4;
                int c = (Integer) eParameter % 4;
                if (eParameter <=23 && eParameter >=0) {
                    int charge = checkMoney(slotsName[r][c],eMoney,products);
                    if (slotsName[r][c] ==null){
                        text ="INFO: This slot is empty, your money will be returned.\n";
                        writer.write(text);
                        writer.flush();
                        text = "RETURN: Returning your change: "+ eMoney +" TL\n";
                        writer.write(text);
                        writer.flush();
                    } else {
                        if (charge >0){
                            slots[r][c] -= 1;
                            text = "PURCHASE: You have bought one "+(String) slotsName[r][c]+"\n";
                            writer.write(text);
                            writer.flush();
                            text = "RETURN: Returning your change: "+ charge +" TL\n";
                            writer.write(text);
                            writer.flush();
                            if (slots[r][c] == 0) slotsName[r][c] = null;

                        } else {
                            text ="INFO: Insufficient money, try again with more money.\n";
                            writer.write(text);
                            writer.flush();
                            text = "RETURN: Returning your change: "+ eMoney +" TL\n";
                            writer.write(text);
                            writer.flush();
                        }
                    }
                } else {
                    text = "INFO: Number cannot be accepted. Please try again with another number.\n";
                    writer.write(text);
                    writer.flush();
                    text = "RETURN: Returning your change: "+ eMoney +" TL\n";
                    writer.write(text);
                    writer.flush();
                }
                text ="";
                writer.write(text);
                writer.flush();
            } else {
                /**
                 * For other preferences, this code block runs and provides the necessary feedback.
                 */
                progressOfGYMMachine (products,slots, slotsName, eType,eMoney, eParameter, writer);
            }
        }
        /**
         * It shows the products remaining in the machine after all operations are completed.
         */
        gymHave(products, slots, slotsName, writer);
        writer.flush();

    }

    /**
     * It compares the product price with the money the user loads into the machine. Returns the change amount, if any.
     * @param slotName      It stores the names of the locations of the products positioned in the slots.
     * @param eMoney        Indicates the amount of money the user loads into the machine.
     * @param products      This is class of product
     * @return
     */
    private static int checkMoney(String slotName, int eMoney, List<Product> products) {
        int charge = 0;
        for (Product product : products ){
            String eName = product.getName();
            if (eName.equals(slotName)) {
                charge = eMoney-  product.getPrice();
            }
        }
        return charge;
    }

    /**
     *  It finds the most suitable product in the machine in line
     *  with the user's preferences and turns it into the "BUY" method for use.
     * @param products      This is class of product
     * @param slots         stores product counts on the machine
     * @param slotsName     It stores the names of the locations of the products positioned in the slots.
     * @param eType         It is the product type selected by the user.
     * @param eMoney        Indicates the amount of money the user loads into the machine.
     * @param eParameter    It is the parameter entered into the machine.
     * @param writer        Required parameter to print file
     * @throws IOException
     */
    public static void progressOfGYMMachine (
            List<Product> products,
            int[][] slots,
            String[][] slotsName,
            String eType,
            int eMoney,
            int eParameter,
            BufferedWriter writer
    ) throws IOException {
        String text;
        int flag =0;
        Object product = searchProduct(products, eType,eParameter,slotsName,slots);
        if (product == null) {
            text ="INFO: Product not found, your money will be returned.\n";

            writer.write(text);
            writer.flush();
            text = "RETURN: Returning your change: "+ eMoney +" TL\n";
            writer.write(text);
            writer.flush();
        } else {
            for(int r = 0; r < 6 ; r++ ){
                for (int c = 0; c<4 ; c++) {
                    if (product.equals(slotsName[r][c])){
                        int charge = checkMoney(slotsName[r][c],eMoney,products);
                        if (charge > 0){
                            slots[r][c] -= 1;
                            text = "PURCHASE: You have bought one "+(String) slotsName[r][c]+"\n";
                            writer.write(text);
                            writer.flush();
                            text = "RETURN: Returning your change: "+ charge +" TL\n";
                            writer.write(text);
                            writer.flush();
                            if (slots[r][c] == 0) slotsName[r][c] = null;
                            flag = 1;
                            break;

                        } else {
                            text ="INFO: Insufficient money, try again with more money.\n";
                            writer.write(text);
                            writer.flush();
                            text = "RETURN: Returning your change: "+ eMoney +" TL\n";
                            writer.write(text);
                            writer.flush();
                            flag =1;
                            break;
                        }
                    }
                }
                if (flag == 1){
                    flag =0;
                    break;
                }
            }
            writer.flush();
        }
        writer.flush();
    }

    /**
     * It is a sub-method of the progress Of GYM Machine method. It carries out the necessary operations
     * for protein, fat, carbohydrate and calorie values.
     * @param products      This is class of product
     * @param eType         It is the product type selected by the user.
     * @param eParameter
     * @param slots         stores product counts on the machine
     * @param slotsName     It stores the names of the locations of the products positioned in the slots.
     * @return              Returns the found product name.
     */
    private static Object searchProduct(
            List<Product> products,
            String eType, int eParameter,
            String[][] slotsName,
            int[][] slots) {
        Object turn = null;

        /**
         * It is the code blog responsible for finding the appropriate product according to user preference.
         */
        if (Objects.equals(eType, "PROTEIN")){
            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 4; c++) {
                    if (slotsName[r][c]== null || slots[r][c] ==0){
                        continue;
                    }
                    for (Product product : products){
                        if (slotsName[r][c].equals(product.getName())){
                            double differance = Math.abs((double) eParameter - product.getProtein());
                            if (differance <=5){
                                turn = slotsName[r][c];
                                return turn;
                            }
                        }
                    }
                }
            }
        } else if (Objects.equals(eType, "CARB")) {
            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 4; c++) {
                    if (slotsName[r][c]== null || slots[r][c] ==0){
                        continue;
                    }
                    for (Product product : products){
                        if (slotsName[r][c].equals(product.getName())){
                            double differance = Math.abs((double) eParameter - product.getCarbohydrate());
                            if (differance <=5){
                                turn = slotsName[r][c];
                                return turn;
                            }
                        }
                    }
                }
            }
        } else if (Objects.equals(eType, "FAT")) {
            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 4; c++) {
                    if (slotsName[r][c]== null || slots[r][c] ==0){
                        continue;
                    }
                    for (Product product : products){
                        if (slotsName[r][c].equals(product.getName())){
                            double differance = Math.abs((double) eParameter - product.getFat());
                            if (differance <=5){
                                turn = slotsName[r][c];
                                return turn;
                            }
                        }
                    }
                }
            }
        } else if (Objects.equals(eType, "CALORIE")) {
            for (int r = 0; r < 6; r++) {
                for (int c = 0; c < 4; c++) {
                    if (slotsName[r][c]== null || slots[r][c] ==0){
                        continue;
                    }
                    for (Product product : products){
                        if (slotsName[r][c].equals(product.getName())){
                            int differance = Math.abs(eParameter - product.getCalorie());
                            if (differance <=5){
                                turn = slotsName[r][c];
                                return turn;
                            }
                        }
                    }
                }
            }
        }
        return turn;
    }
}