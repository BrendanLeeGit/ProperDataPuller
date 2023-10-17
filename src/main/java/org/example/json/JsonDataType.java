package org.example.json;

/**
 * Superclass for the datatypes. This is mainly used so that I can hold multiple of them in a single JSON object. It
 * also has the added bonus of allowing me to give it abstract methods they'll all share. Tbh could also be an
 * interface,but I already did this so... fk it we ball.
 */
public abstract class JsonDataType {

    /**
     * Returns the data type's String representation for a JSON file.
     * @return The data type's String representation for a JSON file
     */
    public abstract String toJSONString();

    /**
     * Returns the data type's identifier as a String. Objects don't seem to have one, so theirs will be null. I'm suspecting
     * that there may be some edge case where an object DOES have one though.
     * @return  The data type's identifier as a String
     */
    public abstract String getIdentifier();

    public abstract String getDataAsString();

}
