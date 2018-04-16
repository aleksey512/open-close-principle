package info.biosfood.open.close.principle.better;

/**
 * That implementation is much better.
 * The class doesn't mixes a logic for different types of saving information.
 * Finally, we have an interface Handler and each class that provides any way of storing a result has his own class and
 * separated implementation.
 *
 * It's quite easy to test savers separately, but still there are issues here:
 * - you have to pass all available types and be sure that an appropriate instance of Handler is returned by
 *   numeric type
 * - you store the handlers in a map and it's quite easy to add new types here, but still you have to change code
 *
 * But still there is a room to improve
 * */
public class ObjectHandler {

    ObjectHandlers savers = new ObjectHandlers();

    public void save(int type, Object o) {
        savers.getByType(type).save(o);
    }

}
