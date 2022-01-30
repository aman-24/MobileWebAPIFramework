package utils.APIUtils;

import java.util.HashMap;

public class HeaderBuilder {

    HashMap<String, String> headersMap = new HashMap<>();

    public HashMap<String, String> getBasicHeaders(){
        headersMap.put("Content-Type", "application/json");
        return headersMap;
    }

}
