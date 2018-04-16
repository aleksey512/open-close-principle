package info.biosfood.open.close.principle.better;

import info.biosfood.open.close.principle.better.handler.DatabaseHandlerTest;
import info.biosfood.open.close.principle.better.handler.ElasticSearchHandler;
import info.biosfood.open.close.principle.better.handler.FileHandler;
import org.junit.Test;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ObjectHandlersTest {

    ObjectHandlers oh = new ObjectHandlers();

    @Test
    public void testGetByType() {
        assertTrue(oh.getByType(1) instanceof FileHandler);
        assertTrue(oh.getByType(2) instanceof DatabaseHandlerTest);
        assertTrue(oh.getByType(3) instanceof ElasticSearchHandler);
        assertNull(oh.getByType(4));
    }

}
