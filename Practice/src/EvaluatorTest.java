import static org.junit.Assert.*;

import org.junit.Test;

public class EvaluatorTest {

    @Test
    public void test1() throws Exception {
        Evaluator eval = new Evaluator();
        assertEquals(10, eval.evaluate("2 3 9 4 / + *"));
    }
    
    @Test
    public void test2() throws Exception {
        Evaluator eval = new Evaluator();
        assertEquals(20, eval.evaluate("2 3 + 9 5 - *"));
    }
    
    @Test
    public void test3() throws Exception {
        Evaluator eval = new Evaluator();
        assertEquals(10, eval.evaluate("2 3 9 4 / + *"));
    }
    
    @Test
    public void test4() throws Exception {
        Evaluator eval = new Evaluator();
        assertEquals(10, eval.evaluate("2 3 9 4 / + *"));
    }

}
