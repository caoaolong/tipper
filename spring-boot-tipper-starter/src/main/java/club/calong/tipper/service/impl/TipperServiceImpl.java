package club.calong.tipper.service.impl;

import club.calong.tipper.domain.TipperRequest;
import club.calong.tipper.domain.TipperResponse;
import club.calong.tipper.properties.TipperProperties;
import club.calong.tipper.service.TipperService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

@Component
public class TipperServiceImpl implements TipperService {

    @Override
    public TipperResponse serve(TipperRequest request) {

        return new TipperResponse("Hello,World!");
    }
}
