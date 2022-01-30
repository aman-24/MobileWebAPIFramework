package utils.APIUtils;

import utils.ConfigProperties;

public class URLBuilder {
    private static final String user= "/users";
    public static String getUserEndPointUrl() {
        return ConfigProperties.baseAPIURL + user;
    }
}
