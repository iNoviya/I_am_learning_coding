/**
 * @author b2230356164 Muhammet Mustafa KARATAS
 * This class stores the money type of the transactions to be
 * made in the vending machine, the names of the products loaded into the vending machine,
 * and the user's preferences as separate objects.
 */

class Purchase {
    String typeOfMoney;
    int totalMoney;
    String choice;
    int value;
    String rowList;

    public Purchase(String typeOfMoney, int totalMoney, String choice, int value, String rowList) {
        this.typeOfMoney = typeOfMoney;
        this.totalMoney = totalMoney;
        this.choice = choice;
        this.value = value;
        this.rowList = rowList;
    }

    // These functions are for accessing data in the class.
    public String getTypeOfMoney(){
        return this.typeOfMoney;
    }
    public int getTotalMoney(){
        return this.totalMoney;
    }
    public String getChoice(){
        return this.choice;
    }
    public int getValue(){
        return this.value;
    }
    public String getRowList(){
        return this.rowList;
    }
}