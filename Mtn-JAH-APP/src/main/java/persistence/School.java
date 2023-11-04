package persistence;

import persistence.collections.SchoolDOA;

import java.util.ArrayList;
import java.util.List;

// Example School class - Represents a school entity
public class School implements SchoolDOA {
    private final String name;
    private final String location;
    private final List<String> programs;

    public School(String name, String location, List<String> programs) {
        this.name = name;
        this.location = location;
        this.programs = programs;
    }

    // Getters for name, location, and programs
    // (Getters for individual fields are omitted for brevity)

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public List<String> getPrograms() {
        return programs;
    }
}

