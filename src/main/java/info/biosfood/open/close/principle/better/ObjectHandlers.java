package info.biosfood.open.close.principle.better;

import info.biosfood.open.close.principle.better.handler.DatabaseHandler;
import info.biosfood.open.close.principle.better.handler.ElasticSearchHandler;
import info.biosfood.open.close.principle.better.handler.FileHandler;
import info.biosfood.open.close.principle.better.handler.Handler;

import java.util.HashMap;
import java.util.Map;

public class ObjectHandlers {

    Map<Integer, Handler> savers = new HashMap<>();

    public ObjectHandlers() {
        savers.put(1, new FileHandler());
        savers.put(2, new DatabaseHandler());
        savers.put(3, new ElasticSearchHandler());
    }

    public Handler getByType(int type) {
        return savers.get(type);
    }

}
