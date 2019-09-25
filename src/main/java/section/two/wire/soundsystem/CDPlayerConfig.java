package section.two.wire.soundsystem;

import org.springframework.context.annotation.*;

@Configuration
@ImportResource("classpath:section/two/wire/soundsystem/web.xml")
//@ComponentScan
public class CDPlayerConfig {

//    @Bean(name = "sgtPeppers-javaConfig")
//    public CompactDisc sgtPeppers() {
//        return new SgtPeppers();
//    }
//
    @Bean(name = "cdPlayer")
    public MediaPlayer cdPlayer(CompactDisc cd) {
        return new CDPlayer(cd);
    }
}
