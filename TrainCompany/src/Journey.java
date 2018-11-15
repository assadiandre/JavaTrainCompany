public class Journey
{
    private String routeCode;
    private int delay;
    private boolean weatherRelated;


    public Journey(String code, int delay, boolean weatherRelated) {
        this.routeCode = code;
        this.delay = delay;
        this.weatherRelated = weatherRelated;
    }


    public int getDelay(){
        return this.delay;
    }

    public boolean getWeatherRelated() {
        return this.weatherRelated;
    }

    public String getRouteCode() {
        return this.routeCode;
    }
}