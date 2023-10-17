package org.example.json;

import java.util.ArrayList;

public class JsonObject extends JsonDataType {
    private ArrayList<JsonDataType> dataList;

    /**
     * If you want to send a completed ArrayList of the data here, use this constructor.
     * @param dataList  The ArrayList of data the JSON object will contain
     */
    public JsonObject(ArrayList<JsonDataType> dataList){
        this.dataList = dataList;
    }

    /**
     * If you want to instead initialize it empty and add them as you go, use this constructor.
     */
    public JsonObject(){
        dataList = new ArrayList<JsonDataType>();
    }

    /**
     * Adds the data to the ArrayList of data the object contains.
     * @param data  The data to be added to the ArrayList of data
     */
    public void addDataType(JsonDataType data){
        dataList.add(data);
    }

    /**
     * Returns the data type's String representation for a JSON file.
     * @return  the data type's String representation for a JSON file
     */
    @Override
    public String toJSONString() {
        //It's basically just brackets with all its items inside. Yeah, just a container. Yep. Or is it...?
        return "{" + JSONObjectStringBuilder() + "}";
    }

    /**
     * Returns the identifier of the object. In this case, we actually return null since there is no identifier.
     * @return
     */
    @Override
    public String getIdentifier() {
        return null;
    }

    /**
     * Helper method for toJSONString. Not meant to be used anywhere else by anyone else.
     * @return  The concatenated String of all the data types in their JSON String forms
     */
    private String JSONObjectStringBuilder(){
        //Initialize the string we'll be building upon
        String resultingString = "{";

        //Now iterate through the ArrayList of data, concatenating everything into resultingString
        for (JsonDataType jDS : dataList){
            resultingString = resultingString + jDS.toJSONString();
        }
        return resultingString + "}";
    }

    public String getDataAsString(){
        return "I haven't decided what this will return yet";
        //TODO: Figure out above lol
    }
}
