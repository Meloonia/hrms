package io.kodlama.adapters;

import org.apache.axis.AxisFault;
import org.springframework.stereotype.Component;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;


@Component("mernis")
public interface MernisService {


    KPSPublicSoap mernis() throws AxisFault;
}
