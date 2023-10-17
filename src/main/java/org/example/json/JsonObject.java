package org.example.json;

import java.util.ArrayList;

public class JsonObject extends JsonDataType {
    private ArrayList<JsonDataType> dataList;
    private String identifier;

    /**
     * If you want to send a completed ArrayList of the data here, use this constructor.
     * @param dataList  The ArrayList of data the JSON object will contain
     */
    public JsonObject(String identifier, ArrayList<JsonDataType> dataList){
        this.dataList = dataList;
        this.identifier = identifier;
    }

    /**
     * If you want to instead initialize it empty and add them as you go, use this constructor.
     */
    public JsonObject(String identifier){
        dataList = new ArrayList<JsonDataType>();
        this.identifier = identifier;
    }

    /**
     * Returns the data type's String representation for a JSON file.
     * @return  the data type's String representation for a JSON file
     */
    @Override
    public String toJSONString() {
        //It's basically just brackets with all its items inside. Yeah, just a container. Yep. Or is it...?
        return "} " + identifier;
    }

    /**
     * Returns the identifier of the object. In this case, we actually return null since there is no identifier.
     * @return
     */
    @Override
    public String getIdentifier() {
        return identifier;
    }

    public String getDataAsString(){
        return "I haven't decided what this will return yet";
        //TODO: Figure out above lol
    }
}
