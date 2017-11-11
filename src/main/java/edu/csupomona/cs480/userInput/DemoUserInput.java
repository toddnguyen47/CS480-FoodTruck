package edu.csupomona.cs480.userInput;

import java.util.ArrayList;
import java.util.Map;

public class DemoUserInput {
   private String locationString;
   private String locationType;
   private double latitude;
   private double longitude;
   private ArrayList<String> typesOfFood;
   
   public DemoUserInput(Map<String, Object> selection) {
       typesOfFood = new ArrayList<String>();
       locationString = selection.get("search_input").toString();
       locationType = selection.get("opt").toString();
       latitude = Double.parseDouble(selection.get("lat").toString());
       longitude = Double.parseDouble(selection.get("lon").toString());
       typesOfFood = parseFoodTypes(selection.get("typeOfFood").toString());
   }
   
   private ArrayList<String> parseFoodTypes(String typeOfFood) {
       ArrayList<String> types = new ArrayList<String>();
       while (typeOfFood.contains("name")) {
           int nameIndex = typeOfFood.indexOf("name=");
           typeOfFood = typeOfFood.substring(nameIndex + 5);
           int commaIndex = typeOfFood.indexOf(",");
           types.add(typeOfFood.substring(0, commaIndex));
       }
       return types;
   }
   
   @Override
   public String toString() {
       String allInfo = "Location Type: " + locationType
             + "; Location String: " + locationString
             + "; Lat,Lon: " + latitude + "," + longitude
             + "; Types of Foods: { ";
       for (int i = 0; i < typesOfFood.size(); ++i)
       {
           allInfo += typesOfFood.get(i);
           if (i < typesOfFood.size() - 1)
           {
               allInfo += ", ";
           }
       }
       allInfo += " }";
       return allInfo;
   }
   
   public String getLocationString() {
      return locationString;
   }

   public String getLocationType() {
      return locationType;
   }

   public double getLatitude() {
      return latitude;
   }

   public double getLongitude() {
      return longitude;
   }

   public ArrayList<String> getTypesOfFood() {
      return typesOfFood;
   }
}
