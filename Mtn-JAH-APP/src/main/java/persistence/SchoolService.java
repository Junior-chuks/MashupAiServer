package persistence;

import java.util.ArrayList;
import java.util.List;

// SchoolService class responsible for fetching schools based on location and study interests
public class SchoolService {

    // Simulated database of schools
    private final List<School> schools;

    public SchoolService() {
        // Populate the simulated database of schools
        schools = new ArrayList<>();
        schools.add(new School("KZN University", "KwaZulu-Natal", List.of("Computer Science", "Biology")));
        schools.add(new School("DUT Institute", "Pietermariztburg", List.of("Business Administration", "Engineering")));
        schools.add(new School("WITS Institute", "Johannesburg", List.of("Medical Science", "Accounting")));
        // Add more schools with respective programs...
    }

    // Method to get schools based on the geographical area and study interests
    public List<School> getSchoolsByLocationAndInterest(String userLocation, String interest) {
        // Filter schools based on user's location and study interest
        return schools.stream()
                .filter(school -> school.getLocation().equalsIgnoreCase(userLocation) &&
                        school.getPrograms().contains(interest))
                .toList(); // Java 16+: Replace with .collect(Collectors.toList());
    }

    // Method to get schools based on the geographical area and study interests
    public List<School> getSchoolsByLocationAndInterest() {
        // Filter schools based on user's location and study interest
        return schools;// Java 16+: Replace with .collect(Collectors.toList());
    }
}
