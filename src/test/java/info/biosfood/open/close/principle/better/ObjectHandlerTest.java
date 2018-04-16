package info.biosfood.open.close.principle.better;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class ObjectHandlerTest {

    ObjectHandler subject;

    @Before
    public void setup() {
        subject = spy(new ObjectHandler());
        subject.savers = spy(subject.savers);
    }

    @Test
    public void testSave() {
        subject.save(1, new Object());

        verify(subject.savers, times(1)).getByType(eq(1));
    }

}
