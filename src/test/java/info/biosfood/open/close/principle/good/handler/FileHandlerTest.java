package info.biosfood.open.close.principle.good.handler;

import info.biosfood.open.close.principle.good.holder.AbstractHolder;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class FileHandlerTest {

    FileHandler subject = new FileHandler();

    @Test
    public void testSave() {
        subject.save(mock(AbstractHolder.class));
        //  verification logic here
    }

}
