package persistence;

import java.util.ArrayList;
import java.util.List;

// JobService class responsible for fetching jobs based on a location
public class JobService {

    public List<Job> getJobs(){
        return getJobsFromDatabase();
    }

    // Method to get jobs based on the geographical area
    public List<Job> getJobsByLocation(String userLocation) {
        // Simulated database or service call to retrieve jobs by location
        // This is an example, you will need to implement the actual data retrieval logic

        // Assuming there's a list of jobs available
        // You'd replace this logic with a call to your actual job database or service
        List<Job> allJobs = getJobsFromDatabase(); // Assuming this method retrieves all available jobs

        // Filter jobs based on user's location
        return filterJobsByLocation(allJobs, userLocation);
    }

    // Example method to retrieve jobs from a database (simulated)
    private List<Job> getJobsFromDatabase() {

        return List.of(
                new Job("Software Developer", "Durban", List.of(new String[]{"Coding and Programming","Design and Development","Design and Development"})),
                new Job("Sales Manager", "Los Angeles", List.of(new String[]{"Sales Strategy Development","Team Leadership","Sales Monitoring and Analysis"})),
                new Job("Data Analyst", "Botswana", List.of(new String[]{"Data Collection and Processing","Data Analysis","Data Visualization"})),
                new Job("Business Manager", "Nigeria", List.of(new String[]{"Strategic Planning","Financial Management","Team Management and Leadership"})),
                new Job("Geographical Analyst", "San Francisco", List.of(new String[]{"Data Collection and Analysis","GIS Software Utilization","Map Creation"})),
                new Job("Sales Associate", "United Kingdom", List.of(new String[]{"Customer Assistance","Product Knowledge","Sales Transactions"})),
                new Job("Electrician", "San Francisco", List.of(new String[]{"Installation","Reading Blueprints and Technical Diagrams","Troubleshooting and Repair"}))
                // Add more jobs...
        );
    }

    // Example method to filter jobs by location
    private List<Job> filterJobsByLocation(List<Job> allJobs, String userLocation) {
        // Filter jobs based on user's geographical area
        return allJobs.stream()
                .filter(job -> job.getLocation().equalsIgnoreCase(userLocation))
                .toList(); // Java 16+: Replace with .collect(Collectors.toList());
    }
}
