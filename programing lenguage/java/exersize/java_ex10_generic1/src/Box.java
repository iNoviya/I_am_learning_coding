public  class  Box <T> {
    private  T item;

    public Box(T item){
        this.item = item;
    }

    public T getItem() {
        return item;
    }
    public void setItem(T item) {
        this.item = item;
    }

    public void printBoxInfo(){
        System.out.println("Item: " + item.toString());
    }


}
