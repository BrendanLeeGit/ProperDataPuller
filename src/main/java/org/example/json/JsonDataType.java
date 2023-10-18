package org.example.json;

/**
 * Superclass for the data types. This is mainly used so that I can hold multiple of them in a single JSON object. It
 * also has the added bonus of allowing me to give it abstract methods they'll all share.
 */
public abstract class JsonDataType {

    /**
     * Returns the data type's String representation for a JSON file.
     * @return The data type's String representation for a JSON file
     */
    public abstract String toJSONString();

    /**
     * Returns the data type's identifier as a String.
     * @return  The data type's identifier as a String
     */
    public abstract String getIdentifier();

    /**
     * Specifically returns the data of the object, not the identifier, as a normal, basic String.
     * @return  the data of the object as a String
     */
    public abstract String getDataAsString();

}
