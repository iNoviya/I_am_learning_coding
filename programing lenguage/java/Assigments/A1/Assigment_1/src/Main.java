import java.io.*;
import java.util.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        String inputProductFileName = args[0];
        String inputPurchaseFileName = args[1];
        String outputFileName = args[2];
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName));


        List<List<Object>> productInfo = preliminaryPruduct( readFile(inputProductFileName));
        List<String> produckPlacementList = productPlacement( readFile(inputProductFileName));

        List<List<Object>> purchaseList = preliminaryPurchase( readFile(inputPurchaseFileName));
        List<String> purchaseRawList = readFile(inputPurchaseFileName);

        int[][] slots = {
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0},
                {0,0,0,0}
        };
        String[][] slotsName = {
                {null,null,null,null},
                {null,null,null,null},
                {null,null,null,null},
                {null,null,null,null},
                {null,null,null,null},
                {null,null,null,null}
        };



        fill ( produckPlacementList , slots , slotsName,writer);
        gymMachine(slots,slotsName,productInfo,writer);
        buy (productInfo , purchaseList , purchaseRawList, slots , slotsName , writer);
    }

    public static List<String> readFile(String inputFileName) {

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

    public static List<List<Object>> preliminaryPruduct(List<String> event){

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
            int calorie = (int) calculateCalorie(protein,carbohydrate,fat);

            row.add(name);
            row.add(price);
            row.add(protein);
            row.add(carbohydrate);
            row.add(fat);
            row.add(calorie);

            productSet.add(row);
        }
        List<List<Object>> productList = new ArrayList<>();

        for (List<Object> icSet : productSet) {
            List<Object> icList = new ArrayList<>(icSet);
            productList.add(icList);
        }
        return productList;
    }

    public static List<List<Object>> preliminaryPurchase(List<String> event) {
        List<List<Object>> purchasesList = new ArrayList<>();

        for (String line : event) {
            List<Object> row = new ArrayList<>();

            String[] parts = line.split("\t");
            String typeOfMoney = parts[0];
            int totalMoneys = Arrays.stream(parts[1].split(" "))
                    .mapToInt(Integer::parseInt)
                    .sum();
            String typeOfChose = parts[2];
            Integer enteredParameter = Integer.parseInt(parts[3]);

            row.add(typeOfMoney);
            row.add(totalMoneys);
            row.add(typeOfChose);
            row.add(enteredParameter);

            purchasesList.add(row);
        }
        return purchasesList;
    }

    public static List<String> productPlacement(List<String> event){
        List<String> produckPlacementList = new ArrayList<>();
        for (String line : event){
            String[] part = line.split("\t");

            String productName = part[0];
            produckPlacementList.add(productName);
        }
        return produckPlacementList;
    }

    public static double calculateCalorie (double protein , double carbohydrate , double fat){
        return (int) Math.round(4*protein + 4*carbohydrate + 9 * fat);
    }

    public static void fill(
            List<String> produckPlacementList,
            int[][] slots,
            String[][] slotsName, BufferedWriter writer) throws IOException{

        for (int i =0 ; i < produckPlacementList.size(); i++){
            int checkSettl = 0;
            int flag =0;
            if (checkSlots(slots)){
                String text = "INFO: There is no available place to put "+produckPlacementList.get(i)+"\n";
                writer.write(text);
                writer.flush();
                text = "INFO: The machine is full!\n";
                writer.write(text);
                writer.flush();
                break;
            }
            for (int r = 0; r < 6; r++){
                for (int c =0; c < 4; c++ ){
                    if (slotsName[r][c] != null ){
                        if ( produckPlacementList.get(i).equals(slotsName[r][c])){
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

                    } else {
                        slotsName[r][c] = produckPlacementList.get(i);
                        slots[r][c] +=1;
                        checkSettl =1;
                        flag = 1;
                        break;
                    }

                }
                if (flag == 1)break;
            }
            if (checkSettl == 0) {
                String text = "INFO: There is no available place to put "+produckPlacementList.get(i)+"\n";
                writer.write(text);
                writer.flush();
            }

        }
        return;
    }
    public static boolean checkSlots(int[][] slots){
        for (int r = 0; r <6; r++ ){
            for (int c = 0; c <4 ; c++) {
                if (slots[r][c] != 10) {

                    return false;
                }
            }
        }
        return true;
    }

    public  static void buy(
            List<List<Object>> productInfo,
            List<List<Object>> purchaseList,
            List<String> purchaseRawList,
            int[][] slots,
            String[][] slotsName,
            BufferedWriter writer) throws IOException {
        int flag = 0;
        for (int i = 0; i< purchaseRawList.size(); i++){

            List<Object> event = purchaseList.get(i);
            writer.write("INPUT: "+purchaseRawList.get(i)+"\n");

            int eMoney = (Integer) event.get(1);
            String eType = (String) event.get(2);
            int eParameter = (Integer) event.get(3);

            if (eType.equals("NUMBER")){
                String text;
                int r = (Integer) eParameter / 4;
                int c = (Integer) eParameter % 4;
                if (eParameter <=23 && eParameter >=0) {
                    int charge = checkMoney(slotsName[r][c],eMoney,productInfo);
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
                progressOfGYMMachine (productInfo,slots, slotsName, eType,eMoney, eParameter, writer);
            }
        }
        gymMachine(slots,slotsName,productInfo,writer);
        writer.flush();
    }

    public static void gymMachine (int[][] slots, String[][] slotsName,List<List<Object>> productInfo, BufferedWriter writer) throws IOException {
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
                    for (List<Object> e : productInfo) {
                        String eName = (String) e.get(0);
                        eCalorie = (Integer) e.get(5);

                        if (eName.equals(productName)) {
                            text = slotsName[r][c] + "(" + eCalorie + ", " + slots[r][c] + ")___";
                            writer.write(text);
                            writer.flush();
                            break;
                        }
                    }



                };
            }
            writer.write("\n");
        }
        writer.write("----------\n");
        writer.flush();
    }

    public static Object searchProduct (List<List<Object>> productInfo , String eType, int eParameter,String[][] slotName, int[][] slots) {
        Object turn = null;
        int temp = 0;
        switch (eType) {
            case "PROTEIN": {
                temp = 2;
                double differance =10;
                int flag =0;
                for (int r = 0; r <6 ; r++) {
                    for (int c = 0; c <4 ; c++) {
                        if (slots[r][c]==0){
                            continue;
                        }
                        for (List<Object> e : productInfo){
                            if (e.get(0).equals(slotName[r][c]) ){
                                differance = (double) Math.abs((double) eParameter - (double) e.get(temp));
                                if (differance <= 5){
                                    turn = (Object) slotName[r][c];
                                    flag =1;
                                    break;
                                }
                            }
                        }
                        if (flag ==1)break;

                    }
                    if (flag ==1) break;

                }
                /*
                for (List<Object> e : productInfo) {
                    difference = Math.abs((double) eParameter - (double) e.get(temp));
                    if (difference <= 5)  turn = (Object) e.get(0);
                    break;
                }
                 */
                break;
            }
            case "CARB": {
                temp = 3;
                int flag =0;
                double differance =10;
                for (int r = 0; r <6 ; r++) {
                    for (int c = 0; c <4 ; c++) {
                        if (slots[r][c]==0){
                            continue;
                        }
                        for (List<Object> e : productInfo){
                            if (e.get(0).equals(slotName[r][c]) ){
                                differance = Math.abs((double) eParameter - (double) e.get(temp));
                                if (differance <= 5){
                                    turn = (Object) slotName[r][c];
                                    flag =1;
                                    break;
                                }
                            }
                        }
                        if (flag ==1)break;

                    }
                    if (flag ==1) break;

                }
                break;
            }
            case "FAT": {
                temp = 4;
                double differance =10;
                int flag =0;
                for (int r = 0; r <6 ; r++) {
                    for (int c = 0; c <4 ; c++) {
                        if (slots[r][c]==0){
                            continue;
                        }
                        for (List<Object> e : productInfo){
                            if (e.get(0).equals(slotName[r][c]) ){
                                differance = Math.abs((double) eParameter - (double) e.get(temp));
                                if ( differance <= 5){
                                    turn = (Object) slotName[r][c];
                                    flag =1;
                                    break;
                                }
                            }
                        }
                        if (flag ==1)break;

                    }
                    if (flag ==1) break;

                }
            }
            case "CALORIE": {
                temp = 5;
                double differance = 10;
                int flag =0;
                for (int r = 0; r <6 ; r++) {
                    for (int c = 0; c <4 ; c++) {
                        if (slots[r][c]==0){
                            continue;
                        }
                        for (List<Object> e : productInfo){
                            if (e.get(0).equals(slotName[r][c]) ){
                                differance = Math.abs((int) eParameter - (int) e.get(temp));

                                if ( differance <= 5){
                                    turn = (Object) slotName[r][c];
                                    flag =1;
                                    break;
                                }
                            }
                        }
                        if (flag ==1)break;

                    }
                    if (flag ==1) break;

                }
            }

        }
        return turn;
    }

    public static int checkMoney (String name, int wallet, List<List<Object>> productInfo){
        int charge = 0;
        for (int i =0 ; i< productInfo.size() ; i++ ){
            List<Object> e = productInfo.get(i);
            String eName = (String) e.get(0);
            if (eName.equals(name)) {
                charge = wallet-  (int) (e.get(1));
            }
        }
        return charge;
    }
    public static void progressOfGYMMachine (
            List<List<Object>> productInfo,
            int[][] slots,
            String[][] slotsName,
            String eType,
            int eMoney,
            int eParameter,
            BufferedWriter writer
    ) throws IOException {
        String text;
        int flag =0;
        Object product = searchProduct(productInfo, eType,eParameter,slotsName,slots);
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
                        int charge = checkMoney(slotsName[r][c],eMoney,productInfo);
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
}

