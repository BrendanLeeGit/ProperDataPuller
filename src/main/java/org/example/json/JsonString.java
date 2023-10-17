package org.example.json;

/**
 * Used to represent a String from a JSON File.
 */
public class JsonString extends JsonDataType {
    private String identifier;
    private String data;

    public JsonString(String identifier, String data){
        this.identifier = identifier;
        this.data = data;
    }

    public String getData(){
        return data;
    }

    /**
     * Returns the data type's String representation for a JSON file.
     * @return  The data type's String representation for a JSON file
     */
    @Override
    public String toJSONString() {
        //{"name":"John"}
        return "\"" + identifier + "\":\"" + data + "\"";
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getDataAsString(){
        return data;
    }
}
