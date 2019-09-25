package section.four.aop.soundsystem;

import java.util.List;

public class SampleCompactDisc implements CompactDisc {

    private List<String> tracks;

    public SampleCompactDisc(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Playing sample CD");
    }

    @Override
    public void playTrack(int track) {
        if (track < tracks.size()) {
            System.out.println("Playing the " + track + "'th track!");
        } else {
            System.out.println(track + " exceeds the number of tracks: " + tracks.size());
        }
    }
}
