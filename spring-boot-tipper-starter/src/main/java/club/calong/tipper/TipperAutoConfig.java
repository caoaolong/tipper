package club.calong.tipper;

import club.calong.tipper.properties.TipperProperties;
import club.calong.tipper.service.TipperService;
import club.calong.tipper.service.impl.TipperServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.io.File;
import java.net.URL;

@Configuration
@EnableConfigurationProperties({TipperProperties.class})
public class TipperAutoConfig {

    @Resource
    private TipperProperties tipperProperties;

    @Bean
    public TipperContext tipperContext() {

        TipperContext tipperContext = new TipperContext();

        URL resource = this.getClass().getClassLoader().getResource(tipperProperties.getBase());
        if (resource != null) {
            File tippers = new File(resource.getFile());
            System.out.println(tippers.isDirectory());
        }

        return tipperContext;
    }

    @Bean
    public TipperService tipperService() {
        return new TipperServiceImpl();
    }
}
