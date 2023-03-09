package club.calong.tipper.service;

import club.calong.tipper.domain.TipperRequest;
import club.calong.tipper.domain.TipperResponse;

public interface TipperService {

    TipperResponse serve(TipperRequest request);
}
