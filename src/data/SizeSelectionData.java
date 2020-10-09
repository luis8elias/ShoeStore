package data;

import models.SizeSquareModel;

import java.util.ArrayList;
import java.util.Arrays;

public class SizeSelectionData {

   public static final ArrayList<SizeSquareModel> squares = new ArrayList<>(
           Arrays.asList(
                   new SizeSquareModel("7"  , true),
                   new SizeSquareModel("7.5", false),
                   new SizeSquareModel("8"  , false),
                   new SizeSquareModel("8.5", false),
                   new SizeSquareModel("9"  , false),
                   new SizeSquareModel("9.5", false),
                   new SizeSquareModel("10" , false),
                   new SizeSquareModel("11" , false)
           )
   );


   public static void updateStatus(int index){
       for (int i = 0; i < squares.size() ; i++) {
           squares.get(i).setPressed(i == index);
       }
   }

   public static void updateColor(int index){

       for (SizeSquareModel square: squares) {
           square.setColor(index);
       }

   }





}
