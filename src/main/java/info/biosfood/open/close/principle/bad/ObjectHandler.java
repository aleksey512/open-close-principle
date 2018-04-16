package info.biosfood.open.close.principle.bad;

/**
 * Real-life example. It happens quite often when a developer decides how to save a file base on a numeric type
 * and inside some class implements logic how to save.
 * One class aggregates diverse logic for saving an object.
 * Problems here:
 * - it's difficult to extend
 * - it's difficult to test, you have to be sure, that based on a numeric type an appropriate method will be called
 * - the class mixes logic, it looks like a storage after a riot...
 * */
public class ObjectHandler {

    /*
     * That is explicit violation of open-close principle
     * You can't add a new type processor without modifying current method
     * */
    public void save(int type, Object o) {
        if(type == 1) {
            saveInFile(o);
        } else if(type == 2) {
            saveInDatabase(o);
        } else if(type == 3) {
            saveInElasticSearch(o);
        } else {
            throw new RuntimeException();
        }
    }

    void saveInFile(Object o) {

    }

    void saveInDatabase(Object o) {

    }

    void saveInElasticSearch(Object o) {

    }

}
