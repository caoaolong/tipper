package club.calong.tipper;

import club.calong.tipper.properties.TipperProperties;
import club.calong.tipper.service.TipperService;
import club.calong.tipper.service.impl.TipperServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
@EnableConfigurationProperties({TipperProperties.class})
public class TipperAutoConfig {

    public TipperAutoConfig () {

        System.out.println("TipperAutoConfig");
    }

    @Resource
    private TipperProperties tipperProperties;

    @Bean
    public TipperService tipperService() {
        return new TipperServiceImpl();
    }
}
