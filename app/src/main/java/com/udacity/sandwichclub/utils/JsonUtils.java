package com.udacity.sandwichclub.utils;

import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        //{"name":{"mainName":"Pljeskavica","alsoKnownAs":[]},"placeOfOrigin":"Serbia","description":"Pljeskavica, a grilled dish of spiced meat patty mixture of pork, beef and lamb, is a national dish of Serbia, also popular in Bosnia and Herzegovina and Croatia. It is a main course served with onions, kajmak (milk cream), ajvar (relish), and urnebes (spicy cheese salad), either on plate with side dishes, or with lepinja (flatbread, as a type of hamburger). Recently, Pljeskavica has gained popularity elsewhere in Europe and is served in a few speciality fast food restaurants in Germany, Sweden, and Austria.","image":"https://upload.wikimedia.org/wikipedia/commons/thumb/8/8f/Pljeskavica_%286883073017%29.jpg/800px-Pljeskavica_%286883073017%29.jpg","ingredients":["Two or more of beef, lamb, pork, veal","Onions","Bread crumbs","Lard"]}

        Sandwich sandwich = new Sandwich();

        try {
            JSONObject sandwichJson = new JSONObject(json);
            JSONObject nameJson = sandwichJson.getJSONObject("name");
            sandwich.setMainName(nameJson.getString("mainName"));
            sandwich.setDescription(sandwichJson.getString("description"));
            sandwich.setImage(sandwichJson.getString("image"));
            sandwich.setPlaceOfOrigin(sandwichJson.getString("placeOfOrigin"));

            List akas = new ArrayList();
            JSONArray jsonAkas = nameJson.getJSONArray("alsoKnownAs");
            for (int i=0;  i<jsonAkas.length();  i++){
                akas.add(jsonAkas.getString(i));
            }
            sandwich.setAlsoKnownAs(akas);

            List ingredients = new ArrayList();
            JSONArray jsonIngredients = sandwichJson.getJSONArray("ingredients");
            for (int i=0;  i<jsonIngredients.length();  i++){
                ingredients.add(jsonIngredients.getString(i));
            }
            sandwich.setIngredients(ingredients);
        } catch (JSONException e) {

        }
        return sandwich;
        //return null;
    }
}
