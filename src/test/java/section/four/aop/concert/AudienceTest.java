package section.four.aop.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {PerformanceConfig.class})
public class AudienceTest {

    @Autowired
    private Performance performance;

    @Test
    public void perform() {
        performance.perform();
    }

}
