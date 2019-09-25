package section.four.aop.soundsystem;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {CDConfig.class})
public class CDTest {
    @Inject
    private CompactDisc cd;

    @Inject
    private TrackCounter counter;

    @Test
    public void play() {
        cd.playTrack(1);
        cd.playTrack(1);
        cd.playTrack(2);
        cd.playTrack(2);
        cd.playTrack(2);
        cd.playTrack(1);
        cd.playTrack(1);

        Assert.assertEquals(4, counter.getPlayCount(1));
        Assert.assertEquals(3, counter.getPlayCount(2));
    }
}
