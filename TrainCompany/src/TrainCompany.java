import java.util.ArrayList;

public class TrainCompany
{
    private String companyName;
    private String companyCode;
    private int numberOfJourneys;
    private Journey[] journeyHistory = new Journey[100000];
    public TrainCompany(String x, String y)
    {
        this.companyName = x;
        this.companyCode = y;
        this.numberOfJourneys = 0;
    }
    public TrainCompany(){ }


    // accessor and mutator methods
    Journey getJourney(int x)
    {
        return journeyHistory[x];
    }

    public void addJourney(Journey j) {
        journeyHistory[numberOfJourneys] = j;
        numberOfJourneys++;
    }

    public double averageDelay() {
        double totalJourneyDelay = 0;
        double totalJourneyCount = 0;
        for (int i = 0; i < numberOfJourneys; i++) {
            if ( !journeyHistory[i].getWeatherRelated()  ) {
                totalJourneyDelay += journeyHistory[i].getDelay();
                totalJourneyCount += 1;
            }
        }

        return totalJourneyDelay/totalJourneyCount;
    }
    // returns the average delay for all of a company’s journeys
    public String longestDelay(Codes[] c) {

        int minDelay = 0;
        Journey minDelayJourney = null;
        for (Journey journey : journeyHistory ) {
            if (journey.getDelay() < minDelay && journey.getWeatherRelated() == false ) {
                minDelay = journey.getDelay();
                minDelayJourney = journey;
            }
        }

        for (Codes code : c) {
            if ( minDelayJourney.getRouteCode() == code.getRouteCode() ) {
                return code.getRouteName();
            }
        }
        return "";
    }

    public ArrayList convert(Codes[] allCodes) {

        Boolean allowEntry = true;
        ArrayList<Codes> noDuplicates = new ArrayList<Codes>();

        for (Codes possibleDuplicate : allCodes ) {

            for (Codes nonDuplicate : noDuplicates ) {
                if ( nonDuplicate.getRouteCode() == possibleDuplicate.getRouteCode() ) {
                    allowEntry = false;
                }
            }
            if (allowEntry == true) {
                noDuplicates.add(possibleDuplicate);
            }
            allowEntry = true;

        }
        return noDuplicates;
    }




    public String getCompanyCode() {
        return companyCode;
    }

    public int getNumberOfJourneys() {
        return this.numberOfJourneys;
    }

}