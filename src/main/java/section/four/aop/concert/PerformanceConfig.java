package section.four.aop.concert;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.ArrayList;

@Configuration
@EnableAspectJAutoProxy
public class PerformanceConfig {
    @Bean
    public Audience audience() {
        return new Audience();
    }
    @Bean
    public Performance samplePerformance() {
        return new SamplePerformance();
    }
    @Bean
    public CriticismEngine criticismEngine() {
        CriticismEngineImpl criticismEngine = new CriticismEngineImpl();
        ArrayList<String> pool = new ArrayList<>();
        pool.add("Worst performance ever!");
        pool.add("I laughed, I cried, then I realized I was at the wrong show.");
        pool.add("A must see show!");

        criticismEngine.setCriticismPool((String[])pool.toArray());
        return criticismEngine;
    }
}
