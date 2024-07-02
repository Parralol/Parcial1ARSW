package parcial.arsw.parcial1.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class Client {

    private static final String USER_AGENT = "Mozilla/5.0";
    //private static final String GET_URL = "https://www.alphavantage.co/query??function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=XAYXQXZQJVWAA98S";
    private static final String BODY = "https://www.alphavantage.co/query?";
    private static final String KEY="demo";

    private static HashMap<String, String> cache = new HashMap<>();

    public String invoke(String val, String type) throws IOException {
        String newurl = "";
        if(type.equals(Type.TIME_SERIES_INTRADAY.name())){
            newurl = BODY + "function=" + type + "&symbol=" + val +"&interval=5min&apikey=" + KEY;
        }else{
            newurl =  BODY + "function=" + type + "&symbol=" + val +"&apikey=" + KEY;
        }
        
        URL obj = new URL(newurl);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
            cache.put(newurl, response.toString());
           return response.toString();
        } else {
            return "GET request not worked";
        }
    }

    public String TestInvoke(String url) throws IOException {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        
        //The following invocation perform the connection implicitly before getting the code
        int responseCode = con.getResponseCode();
        //System.out.println("GET Response Code :: " + responseCode);
        
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result
           return response.toString();
        } else {
            return "GET request not worked";
        }
    }
}
