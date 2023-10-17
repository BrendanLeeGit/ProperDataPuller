package org.example.json;

public class JsonNumber extends JsonDataType {
    String identifier;
    float data;

    public JsonNumber(String identifier, float data){
        this.identifier = identifier;
        this.data = data;
    }

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
        return "\"" + identifier + "\":\"" + data + "\"";
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public String getDataAsString(){
        return Float.toString(data);
    }
}
