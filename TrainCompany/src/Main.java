public class Main {



    public static void main(String[] args) {

        TrainCompany[] allCompanies = new TrainCompany[3];
        allCompanies[0] = new TrainCompany("Southern","T290");
        allCompanies[1] = new TrainCompany("Northern","T400");
        allCompanies[2] = new TrainCompany("Eastern","T155");

        allCompanies[0].addJourney(new Journey("J101",6, false));
        allCompanies[0].addJourney(new Journey("J102",5, true));

        System.out.println(allCompanies[0].getCompanyCode());
        System.out.println(allCompanies[0].getJourney(1).getDelay());
        System.out.println(allCompanies[1].getNumberOfJourneys());


        System.out.println( allCompanies[0].averageDelay() );
    }





}
