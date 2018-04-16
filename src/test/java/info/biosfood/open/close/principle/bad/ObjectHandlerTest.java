package info.biosfood.open.close.principle.bad;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class ObjectHandlerTest {

    ObjectHandler subject = spy(ObjectHandler.class);

    @Test
    public void testSaveType1() {
        Object o = new Object();

        subject.save(1, o);

        verify(subject, times(1)).saveInFile(o);
    }

    @Test
    public void testSaveType2() {
        Object o = new Object();

        subject.save(2, o);

        verify(subject, times(1)).saveInDatabase(o);
    }

    @Test
    public void testSaveType3() {
        Object o = new Object();

        subject.save(3, o);

        verify(subject, times(1)).saveInElasticSearch(o);
    }

    @Test
    public void testSaveInFile() {
        Object o = new Object();

        subject.saveInFile(o);

        //  verification logic here
    }
    @Test
    public void testSaveInDatabase() {
        Object o = new Object();

        subject.saveInDatabase(o);

        //  verification logic here
    }

    @Test
    public void testSaveInElasticSearch() {
        Object o = new Object();

        subject.saveInElasticSearch(o);

        //  verification logic here
    }

}
