import java.util.*;

public class Temp {
    public static void main(String[] args) {

        
        HashMap<String, ArrayList<String>> companyEmployees = new HashMap<>();

        ArrayList<String> tcsList = new ArrayList<>();
        tcsList.add("Aashish");
        tcsList.add("Ravi");
        tcsList.add("Priya");
        companyEmployees.put("TCS", tcsList);


        ArrayList<String> googleList = new ArrayList<>();
        googleList.add("Neha");
        googleList.add("Rahul");
        companyEmployees.put("Google", googleList);

        
        companyEmployees.put("Microsoft", new ArrayList<>(List.of("Ankit", "Sanya", "Deepak")));

        
        for (var entry : companyEmployees.entrySet()) {
            System.out.println("Company: " + entry.getKey());
            System.out.println("Employees: " + entry.getValue());
            System.out.println();
        }

        if (companyEmployees.containsKey("Cognizant ")) {
            if (companyEmployees.get("TCS").contains("Ravi")) {
                System.out.println("Ravi works at Cognizant");
            } else {
                System.out.println("Ravi does not work at Cognizant");
            }
        }
        else {
            System.out.println("No Such Company Found Creating New Entry");
            ArrayList<String> Cognizant = new ArrayList<>();
            companyEmployees.put("Cognizent",Cognizant);
        }
    }
}
