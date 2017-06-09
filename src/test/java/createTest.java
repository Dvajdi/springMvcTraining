import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class createTest {
    public GenericXmlApplicationContext getContext(){
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:META-INF/spring/spring-data.xml");
        ctx.refresh();
        return ctx;
    }
    @Test
    public void createContextTest() {
        assert (getContext()!=null);
    }
}
