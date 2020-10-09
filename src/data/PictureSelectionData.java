package data;



import models.PictureSquareModel;

import java.util.ArrayList;
import java.util.Arrays;

public class PictureSelectionData {



    public static ArrayList<PictureSquareModel> shoe1 = new ArrayList<>(
            Arrays.asList(
                    new PictureSquareModel("/assets/1-1.png"  , true,true),
                    new PictureSquareModel("/assets/1-2.png"  , false,false),
                    new PictureSquareModel("/assets/1-3.png"  , false,false)
            )
    );


    public static ArrayList<PictureSquareModel> shoe2 = new ArrayList<>(
            Arrays.asList(
                    new PictureSquareModel("/assets/2-1.png"  , true,true),
                    new PictureSquareModel("/assets/2-2.png"  , false,false),
                    new PictureSquareModel("/assets/2-3.png"  , false,false)
            )
    );


    public static ArrayList<PictureSquareModel> shoe3 = new ArrayList<>(
            Arrays.asList(
                    new PictureSquareModel("/assets/3-1.png"  , true,true),
                    new PictureSquareModel("/assets/3-2.png"  , false,false),
                    new PictureSquareModel("/assets/3-3.png"  , false,false)
            )
    );


    public static ArrayList<PictureSquareModel> shoe4 = new ArrayList<>(
            Arrays.asList(
                    new PictureSquareModel("/assets/4-1.png"  , true,true),
                    new PictureSquareModel("/assets/4-2.png"  , false,false),
                    new PictureSquareModel("/assets/4-3.png"  , false,false)
            )
    );

    public static void updateStatus(int index , int currentMenuItem){
        for (int i = 0; i < shoe1.size() ; i++) {
            getShoe(currentMenuItem).get(i).setPressed(i == index);
        }
    }

    public static ArrayList<PictureSquareModel> getShoe(int index){
        switch(index)
        {
            case 0 :
                return shoe1;
            case 1 :
                return shoe2;
            case 2 :
                return shoe3;
            default :
                return shoe4;
        }
    }

}
