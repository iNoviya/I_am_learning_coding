public class Minibus extends Bus {

    public Minibus(String type, int id, String boarding, String landing, int rows, double prize) {
        super(type, id, boarding, landing, rows, prize);
    }

    public int calculatingNumberOfSeat() {
        return _rows * 2;
    }

    public void zReport() {
        GlobalLogger.log("Voyage " + _id );
        GlobalLogger.log(_boarding +"-"+_landing);
        String text ="";
        for (int i = 0; i < _sittingPlan.size(); i++) {
            if (i % 2 == 0 && i !=0) text = text + "\n";
            if (_sittingPlan.get(i) == true){
                text += "X ";
            } else text += "* ";
            if (i % 2 == 1 ) text = text.trim();
        }
        GlobalLogger.log(text);
        GlobalLogger.log("Revenue: " + String.format("%.2f",getRevenue()));
        GlobalLogger.log("----------------");
    }

    public void printVoyage(){
        GlobalLogger.log("Voyage " + _id);
        GlobalLogger.log(_boarding +"-"+_landing  );
        String text ="";
        for (int i = 0; i < _sittingPlan.size(); i++) {
            if (i % 2 == 0 && i !=0) text = text + "\n";
            if (_sittingPlan.get(i) == true){
                text += "X ";
            } else text += "* ";
            if (i % 2 == 1 ) text = text.trim();
        }
        GlobalLogger.log(text);
        GlobalLogger.log("Revenue: " + String.format("%.2f",getRevenue()) );
    }

    public void setInitInfo(){
        GlobalLogger.log("Voyage "+_id + " was initialized as a " + _type.toLowerCase() + " (2) voyage from " + _boarding + " to " + _landing + " with " + String.format("%.2f",_price)  + " TL priced " + calculatingNumberOfSeat() + " regular seats. Note that minibus tickets are not refundable.");
    }
}
