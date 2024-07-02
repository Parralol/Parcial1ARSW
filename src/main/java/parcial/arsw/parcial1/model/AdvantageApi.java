package parcial.arsw.parcial1.model;

public class AdvantageApi implements APISend{
    static final String USER_AGENT = "Mozilla/5.0";
    static final String BODY = "https://www.alphavantage.co/query?";
    static final String KEY = "demo";

    public AdvantageApi(){
    }

    @Override
    public String getBody() {
        return BODY;
    }

    @Override
    public String getKey() {
        return KEY;
    }

    @Override
    public String getUserAgent() {
        return USER_AGENT;
    }
    
}
