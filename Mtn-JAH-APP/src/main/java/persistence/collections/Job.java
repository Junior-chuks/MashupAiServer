package persistence.collections;

public interface Job {

    String title = null;
    String location = null;

    // Getters and setters for title and location

    public default String getTitle() {
        return null;
    }


    public default String getLocation() {return null;}
}

