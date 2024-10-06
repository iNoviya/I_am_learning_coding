public class Main {
   public static void main(String[] args) {
      System.out.println("Hello world!");


      Pair pair2 = new Pair<>("hasan",22);
      pair2.printer();
//      cause a ERROR 
   //      Pair<Integer,String> pair3 = new Pair<>("Arda" , 34);
      Pair<String,Double> pairC = new Pair<>();
      pairC.setContentT("Selma");
      pairC.setContentU(43.00);
      pairC.printer();

      Pair<Integer , String> pairTest = new Pair<>();
      //      cause a ERROR
      //      pairTest.setContentT("Selma");
      //      pairTest.setContentU();
   }




}

class Pair <T,U> {
   private T _contentT;
   private U _contentU;

   public Pair (T contentT, U contentU){
      this._contentT = contentT;
      this._contentU = contentU;
   }
   public Pair(){
   }

   public void printer (){
      System.out.println(_contentT +"    :    " + _contentU);
   }

   public void setContentT(T contentT) {
      this._contentT = contentT;
   }

   public T getContentT() {
      return _contentT;
   }

   public void setContentU(U contentU) {
      this._contentU = contentU;
   }

   public U getContentU() {
      return _contentU;
   }
}