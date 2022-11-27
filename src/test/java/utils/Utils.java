package utils;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Utils {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void readUserCredentials(int pos) throws IOException, org.json.simple.parser.ParseException {

        String fileName="./src/test/resources/user.json";
        JSONParser jsonParser = new JSONParser();
        Object obj = jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray=(JSONArray) obj;
        JSONObject userObj = (JSONObject) jsonArray.get(pos);

        setUsername((String) userObj.get("username"));
        setPassword((String) userObj.get("password"));


    }
    public static void main(String[] args) throws IOException, ParseException {
        Utils util=new Utils();
        //util.readUserCredentials(0);
       // util.getUsername();
       // util.getPassword();
    }


}
