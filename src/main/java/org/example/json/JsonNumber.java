package org.example.json;

/**
 * Represents a Number from a JSON File. Only does floats.
 */
public class JsonNumber extends JsonDataType {
    private String identifier;
    private float data;

    /**
     * Initializes the JsonNumber with an inputted identifier and data.
     * @param identifier    The identifier for the JsonNumber
     * @param data          The number the JsonNumber will store
     */
    public JsonNumber(String identifier, float data){
        this.identifier = identifier;
        this.data = data;
    }

    /**
     * Returns the number stored by the JsonNumber.
     * @return  the number stored by the JsonNumber
     */
    public float getData(){
        return data;
    }

    /**
     * Returns the data type's String representation for a JSON file.
     * @return  The data type's String representation for a JSON file
     */
    @Override
    public String toJSONString() {
        //{"name":"John"}
        return "\"" + identifier + "\":" + data;
    }

    /**
     * Returns the data type's String representation for a JSON file when the string is a value of an array.
     * @return The data type's String representation for a JSON file
     */
    public String toJsonStringArrayValue(){
        return Float.toString(data);
    }

    /**
     * Returns the data type's identifier as a String.
     * @return  The data type's identifier as a String
     */
    @Override
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Specifically returns the data of the object, not the identifier, as a normal, basic String.
     * @return  the data of the object as a String
     */
    @Override
    public String getDataAsString(){
        return Float.toString(data);
    }
}
