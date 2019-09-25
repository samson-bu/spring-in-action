package section.three.advanced.wire.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import section.two.wire.soundsystem.BlankDisc;

import java.util.ArrayList;

@Configuration
@PropertySource("classpath:section/three/advanced/wire/soundsystem/app.properties")
public class ExpressiveConfig {
    @Autowired
    private Environment env;

    @Bean
    public BlankDisc disc() {
        BlankDisc bd = new BlankDisc();

        bd.setTitle(env.getProperty("disc.title"));
        bd.setArtist(env.getProperty("disc.artist"));
        bd.setTracks(new ArrayList<>());

        return bd;
    }
}
