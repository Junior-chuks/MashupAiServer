package persistence;

import java.util.List;

// Example Job class - Represents a job entity
public class Job implements persistence.collections.Job {
    private final String title;
    private final String location;
    private final List<String> description;

    public Job(String title, String location, List<String> description) {
        this.title = title;
        this.location = location;
        this.description = description;
    }

    // Getters and setters for title and location

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getDescription() {
        return description;
    }
}
