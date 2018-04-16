package info.biosfood.open.close.principle.good.handler;

import info.biosfood.open.close.principle.good.holder.AbstractHolder;
import org.junit.Test;

import static org.mockito.Mockito.mock;

public class ElasticSearchHandlerTest {

    ElasticSearchHandler subject = new ElasticSearchHandler();

    @Test
    public void testSave() {
        subject.save(mock(AbstractHolder.class));
        //  verification logic here
    }

}
