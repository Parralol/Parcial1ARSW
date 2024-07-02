package parcial.arsw.parcial1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import parcial.arsw.parcial1.model.Client;

/**
 * Concurrent class to make multiple REST requests to the controller
 */
public class ConcurrentController implements Runnable {

    static JSONParser parser = new JSONParser();
    static ArrayList<String> urls = new ArrayList<String>();
    static Client invoke = new Client();
    static ArrayList<Thread> threads = new ArrayList<>();
    static ArrayList<String> resp = new ArrayList<>();

    public static void main(String[] args) {
        fetchData();
        for (int i = 0; i < 100; i++) {
            Thread t = new Thread(new ConcurrentController());
            threads.add(t);
        }
        for (Thread t : threads) {
            t.start();
        }
    }

    @Override
    public void run() {
        Random rand = new Random();
        int n = rand.nextInt(1000);
        String res = "";
        try {
            res = invoke.TestInvoke(urls.get(n));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(res);
        }
        try {
            
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(res);
            System.out.println(json.toJSONString() + "\n");
            resp.add(res);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            System.out.println(res);
        }
    }

    /**
     * Allows to get all data stored in /resources/templates/MOCK_DATA.json, get names and types and save the data as an localhost url
     */
    public static void fetchData() {
        try {
            JSONArray a = (JSONArray) parser.parse(new FileReader("src\\main\\resources\\templates\\MOCK_DATA.json"));
            for (Object b : a) {
                JSONObject thing = (JSONObject) b;
                String name = (String) thing.get("Name");
                String type = (String) thing.get("type");
                urls.add("http://localhost:8080/rest?quer="+name+"&type="+ type);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
