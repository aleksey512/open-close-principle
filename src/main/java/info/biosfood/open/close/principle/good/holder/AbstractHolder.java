package info.biosfood.open.close.principle.good.holder;

import info.biosfood.open.close.principle.better.handler.Handler;

abstract public class AbstractHolder {

    abstract protected Handler getHandler();

    public void save() {
        getHandler().save(this);
    }

}
