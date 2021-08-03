package io.kodlama.adapters;

import org.springframework.stereotype.Component;
import tr.gov.nvi.tckimlik.WS.*;

@Component("mernis")
public class MernisAdapter implements MernisService {

    public KPSPublicSoap mernis()  {
        return new KPSPublicSoapProxy().getKPSPublicSoap();

    }


}
