package parcial.arsw.parcial1.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

/**
 * Rest class that allows to connect to any agent specified in the url component
 */
public class Client {

    static APISend url = new AdvantageApi();

    static final String USER_AGENT = url.getUserAgent();
    static final String BODY = url.getBody();
    static final String KEY = url.getKey();

    private static HashMap<String, String> cache = new HashMap<>();

    /**
     * Method to invoke a Restfull api and get it's corresponding response
     * @param val value of the search
     * @param type type of search
     * @return Json formatted String with the response
     * @throws IOException
     */
    public String invoke(String val, String type) throws IOException {
        String newurl = "";
        if(type.equals(Type.TIME_SERIES_INTRADAY.name())){
            newurl = BODY + "function=" + type + "&symbol=" + val +"&interval=5min&apikey=" + KEY;
        }else{
            newurl =  BODY + "function=" + type + "&symbol=" + val +"&apikey=" + KEY;
        }
        if(cache.get(newurl) == null){
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
        }else{
            System.out.println("cacheWorking");
            return cache.get(newurl);
        }
        
    }

    /**
     * Method to invoke a Restfull api and get it's corresponding response made for a concurrent test client
     * @param val value of the search
     * @param type type of search
     * @return Json formatted String with the response
     * @throws IOException
     */
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
