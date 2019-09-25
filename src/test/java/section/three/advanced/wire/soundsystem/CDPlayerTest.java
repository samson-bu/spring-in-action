package section.three.advanced.wire.soundsystem;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import section.two.wire.soundsystem.CompactDisc;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ExpressiveConfig.class})
public class CDPlayerTest {

    @Inject
    private CompactDisc cd;

    @Test
    public void play() {
        cd.play();
    }

}
