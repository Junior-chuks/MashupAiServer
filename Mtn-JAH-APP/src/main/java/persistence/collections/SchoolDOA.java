package persistence.collections;

import java.util.List;

public interface SchoolDOA {

        String name = null;
        String location = null;
        List<String> programs = null;



        // Getters for name, location, and programs
        // (Getters for individual fields are omitted for brevity)

        public default String getName() {
            return null;
        }

        public default String getLocation() {
            return null;
        }

        public default List<String> getPrograms() {
            return null;
        }
    }

