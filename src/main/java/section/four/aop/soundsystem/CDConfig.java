package section.four.aop.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;

@Configuration
@EnableAspectJAutoProxy
public class CDConfig {

    @Bean
    public CompactDisc sample() {
        ArrayList<String> tracks = new ArrayList<>();
        tracks.add("track1: aaaa");
        tracks.add("track2: bbbb");
        tracks.add("track3: cccc");

        return new SampleCompactDisc(tracks);
    }

    @Bean
    public TrackCounter trackCounter() {
        return new TrackCounter();
    }
}
