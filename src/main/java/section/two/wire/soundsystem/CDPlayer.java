package section.two.wire.soundsystem;

import javax.inject.Inject;
import javax.inject.Named;

//@Named("cdPlayer")
public class CDPlayer implements MediaPlayer{

    private CompactDisc cd;

    @Inject
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }
}
