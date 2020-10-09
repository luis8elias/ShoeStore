package data;

import models.MenuItemModel;


import java.util.ArrayList;
import java.util.Arrays;

public class MenuItemData {

    public static ArrayList<MenuItemModel> menuItems = new ArrayList<>(
            Arrays.asList(
                    new MenuItemModel("LIFESTYLE"  , false,"Nike Lebron","Witness IV","111.55"),
                    new MenuItemModel("TRAINING"  , false,"Nike Zoom","Freak 1","129.16" ),
                    new MenuItemModel("RUNNING"    , false,"Nike Zoom","All Bros 2", "130.50"),
                    new MenuItemModel("JORDAN"     , true,"Jordan","Proto-Max 720","200.00")
            )
    );

    public static void updateStatus(int index){
        for (int i = 0; i < menuItems.size() ; i++) {
            menuItems.get(i).setPressed(i == index);
        }
    }
}
