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
}
