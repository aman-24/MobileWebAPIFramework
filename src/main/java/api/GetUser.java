package api;

import java.util.ArrayList;

public class GetUser {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public ArrayList<Data> data;
    public Support support;

    public static class Data {
        public int id;
        public String email;
        public String first_name;
        public String last_name;
        public String avatar;
    }

    public static class Support{
        public String url;
        public String text;
    }
}
