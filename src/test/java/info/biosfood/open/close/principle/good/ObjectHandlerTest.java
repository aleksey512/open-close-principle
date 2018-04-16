package info.biosfood.open.close.principle.good;

import info.biosfood.open.close.principle.better.handler.FileHandler;
import info.biosfood.open.close.principle.good.holder.AbstractHolder;
import info.biosfood.open.close.principle.good.holder.TextHolder;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ObjectHandlerTest {

    ObjectHandler subject = new ObjectHandler();

    @Test
    public void testSave() {
        AbstractHolder object = spy(new TextHolder(new FileHandler()));

        subject.save(object);

        verify(object, times(1)).save();
    }

}
