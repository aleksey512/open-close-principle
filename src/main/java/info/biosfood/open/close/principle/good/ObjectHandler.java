package info.biosfood.open.close.principle.good;

import info.biosfood.open.close.principle.good.holder.AbstractHolder;

/*
 * In my opinion it's one of the best ways how to implement saving of an object.
 * A handler cares how the data is saved in a storage and the handler is assigned from outside.
 * We don't have access to internal logic about serialization of data and how the data is actually saved.
 * A developer can implement custom logic for serialization and assign a handler that saves data.
 * Actually, a subject how to serialize deserves another discussion here, but let it be that
 * any handler knows how to serialize a certain instance of AbstractHolder properly
 *
 * */
public class ObjectHandler {

    public void save(AbstractHolder o) {
        o.save();
    }

}
