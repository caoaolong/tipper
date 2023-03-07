package club.calong.tipper.service.impl;

import club.calong.tipper.service.TipperService;
import org.springframework.stereotype.Component;

@Component
public class TipperServiceImpl implements TipperService {

    @Override
    public void parse(String name) {

        System.out.printf("Parse %s\n", name);
    }
}
