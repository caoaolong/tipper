package club.calong.tipper;

import club.calong.tipper.properties.TipperProperties;
import club.calong.tipper.service.TipperService;
import club.calong.tipper.service.impl.TipperServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.annotation.Resource;
import java.io.File;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

@Configuration
@EnableConfigurationProperties({TipperProperties.class})
public class TipperAutoConfig {

    @Resource
    private TipperProperties tipperProperties;

    @Bean
    public TipperContext tipperContext() {

        TipperContext tipperContext = new TipperContext(tipperProperties);

        URL resource = this.getClass().getClassLoader().getResource(tipperProperties.getBase());
        List<File> tipperFiles = new LinkedList<>();
        if (resource != null) {
            File tippers = new File(resource.getFile());
            if (tippers.isDirectory()) {
                tipperContext.scanTipperFiles(tippers, tipperFiles);
            }
        }
        for (File tipperFile : tipperFiles) {
            tipperContext.loadTipperFile(tipperFile);
        }

        System.out.println(TipperContext.getTippers());

        return tipperContext;
    }

    @Bean
    public TipperService tipperService() {
        return new TipperServiceImpl();
    }
}
