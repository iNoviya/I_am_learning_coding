/**
 * @author b2230356164 Muhannet Nustafa KARATAS
 * It stores the price, calories, protein,
 * fat and carbohydrate amounts of these class products.
 */

class Product {
    String name;
    int price;
    double protein;
    double carbohydrate;
    double fat;
    int calorie;

    public Product(String name, int price, double protein, double carbohydrate, double fat,int calorie) {
        this.name = name;
        this.price = price;
        this.protein = protein;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.calorie = calorie;
    }

    // These functions are for accessing data in the class.
    public String getName(){
        return this.name = name;
    }
    public int getPrice (){
        return this.price;
    }
    public double getProtein(){
        return this.protein;
    }
    public double getCarbohydrate(){
        return this.carbohydrate;
    }
    public double getFat(){
        return this.fat;
    }
    public int getCalorie(){
        return calorie;
    }
}
