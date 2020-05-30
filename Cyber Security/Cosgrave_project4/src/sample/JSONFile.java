package sample;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class JSONFile {
    public static void Save(ArrayList<User> users){
        JSONArray userList = new JSONArray();

        if(users.size() > 0){
            for(int x=0; x < users.size(); x++){
                JSONObject data = new JSONObject();

                data.put("username", users.get(x).getUserName());
                data.put("name", users.get(x).getName());
                data.put("email", users.get(x).getEmail());
                data.put("password", users.get(x).getPassword());
                data.put("salt", users.get(x).getSalt());

                userList.add(data);
            }
        }

        try{
            FileWriter file = new FileWriter("users.json");
            file.write((userList.toString()));
            file.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static ArrayList<User> Load() {
        JSONParser parser = new JSONParser();
        ArrayList<User> _users = new ArrayList<>();

        try{
            FileReader file = new FileReader("users.json");

            Object data = parser.parse(file);
            JSONArray dataList = (JSONArray) data;

            for(int x=0; x<dataList.size(); x++){
                User user = new User();
                JSONObject record = (JSONObject) dataList.get(x);

                user.setUserName((String) record.get("username"));
                user.setEmail((String) record.get("email"));
                user.setName((String) record.get("name"));
                user.setPassword((String) record.get("password"));
                user.setSalt(record.get("salt").toString());

                _users.add(user);
            }

            return _users;

        }catch (IOException | ParseException ex){
            ex.printStackTrace();
            return null;
        }
    }
}
