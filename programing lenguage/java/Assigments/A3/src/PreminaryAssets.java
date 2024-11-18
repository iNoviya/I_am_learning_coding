import java.util.*;

/**
 * It is the place where the properties of the items to be used in the game are created.
 *
 * @personalNote  I created it manually because the number of items to be used was small.
 */

public class PreminaryAssets  {
   ArrayList<Mines> minesList = new ArrayList<>();
   ArrayList<Ground> groundList = new ArrayList<>();
   String baseFileWay ="file:src/assets/underground/";

   /**
    * Creates mineral items and puts them into a class list
    * @return It returns the mineralist parameter to access the data in it when necessary.
    */
   public ArrayList<Mines> loadMineralAssets (){
      Mines amazonite = new Mines("amazonite",500000,120,baseFileWay + "valuable_amazonite.png");
      minesList.add(amazonite);
      Mines brozinum = new Mines("bronzium",60,10,baseFileWay + "valuable_bronzium.png");
      minesList.add(brozinum);
      Mines diamond = new Mines("diamond",60,10,baseFileWay + "valuable_diamond.png");
      minesList.add(diamond);
      Mines einsteinium = new Mines("einsteinium",60,10,baseFileWay + "valuable_einsteinium.png");
      minesList.add(einsteinium);
      Mines emerald = new Mines("emerald",60,10,baseFileWay + "valuable_emerald.png");
      minesList.add(emerald);
      Mines goldium = new Mines("goldium",60,10,baseFileWay + "valuable_goldium.png");
      minesList.add(goldium);
      Mines ironium = new Mines("ironium",60,10,baseFileWay + "valuable_ironium.png");
      minesList.add(ironium);
      Mines platinium = new Mines("platinium",60,10,baseFileWay + "valuable_platinum.png");
      minesList.add(platinium);
      Mines ruby = new Mines("ruby",60,10,baseFileWay + "valuable_ruby.png");
      minesList.add(ruby);
      Mines silverium = new Mines("silverium",60,10,baseFileWay + "valuable_silverium.png");
      minesList.add(silverium);

   return minesList;
   }

   /**
    * With this method, stone, soil, lava and earth items to be used in the game are created.
    * @return It returns the ground parameter to access the data in it when necessary.
    */
   public ArrayList<Ground> loadEarthAssets (){
      Ground top = new Ground("top",baseFileWay + "top_02.png");
      groundList.add(top);
      Ground soil = new Ground("soil",baseFileWay + "soil_01.png");
      groundList.add(soil);
      Ground stone = new Ground("stone",baseFileWay + "obstacle_01.png");
      groundList.add(stone);
      Ground lava = new Ground("lava",baseFileWay + "lava_02.png");
      groundList.add(lava);
      return groundList;
   }
}
