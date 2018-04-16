package info.biosfood.open.close.principle.good.holder;

import info.biosfood.open.close.principle.better.handler.Handler;

public class TextHolder extends AbstractHolder {

    Handler handler;

    public TextHolder(Handler handler) {
        this.handler = handler;
    }

    protected Handler getHandler() {
        return handler;
    }

}
