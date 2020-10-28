package com.chimemoo.fooddeliveryapp.data;

import com.chimemoo.fooddeliveryapp.R;
import com.chimemoo.fooddeliveryapp.model.ProductModel;

import java.util.ArrayList;

public class ProductData {

    public static String[] foodTypes = {
            "Foods",
            "Foods",
            "Snacks",
            "Foods",
            "Drinks",
            "Sauces"
    };

    public static String[] foodNames = {
            "Veggie potato milk",
            "Rendang ayam",
            "Donat Srikaya",
            "Telor Rebus",
            "Teh Manis",
            "Sambal"
    };

    public static String[] foodPrice = {
            "1.500",
            "2.500",
            "23.500",
            "23.000",
            "1000",
            "1.500"
    };

    private static int[] foodImages = {
            R.drawable.food1,
            R.drawable.food2,
            R.drawable.food3,
            R.drawable.food4,
            R.drawable.food1,
            R.drawable.food2
    };

    public static ArrayList<ProductModel> getListData(){
        ArrayList<ProductModel> list = new ArrayList<>();
        for (int position = 0; position < foodTypes.length; position++){
            ProductModel product = new ProductModel();
            product.setName(foodNames[position]);
            product.setType(foodTypes[position]);
            product.setImage(foodImages[position]);
            product.setPrice(foodPrice[position]);

            list.add(product);
        }

        return list;
    }

    public static ArrayList<ProductModel> getFilteredListData(String foodType){
        ArrayList<ProductModel> list = new ArrayList<>();
        for (int position = 0; position < foodTypes.length; position++){
            if(foodTypes[position].equals(foodType)){
                ProductModel product = new ProductModel();
                product.setName(foodNames[position]);
                product.setType(foodTypes[position]);
                product.setImage(foodImages[position]);
                product.setPrice(foodPrice[position]);

                list.add(product);
            }
        }

        return list;
    }



}
