package org.example.json;

public class JsonArray extends JsonObject {
    /**
     * Constructs a JsonObject with the inputted identifier.
     *
     * @param identifier
     */
    public JsonArray(String identifier) {
        super(identifier);
    }

    /**
     * Returns the data type's String representation for a JSON file.
     * @return  the data type's String representation for a JSON file
     */
    @Override
    public String toJSONString() {
        //TODO: Fnd proper way to print this object as text for a JSON file
        return getIdentifier() + "[]";
    }

    /**
     * Returns the data type's String representation for a JSON file when the string is a value of an array.
     * @return The data type's String representation for a JSON file
     */
    public String toJsonStringArrayValue(){
        return "[]";
    }

    //public String getIdentifier
}
