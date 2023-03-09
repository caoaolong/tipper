package club.calong.tipper;

import club.calong.tipper.domain.TipperRequest;
import club.calong.tipper.domain.TipperResponse;
import club.calong.tipper.service.TipperService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@SpringBootApplication
@RestController
public class TipperServerApplication {

    public static void main(String[] args) {

        SpringApplication.run(TipperServerApplication.class, args);
    }

    @Resource
    TipperService tipperService;

    @PostMapping("/tipper")
    public TipperResponse tipper(TipperRequest request) {

        return tipperService.serve(request);
    }
}
