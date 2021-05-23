package io.kodlama.adapters;

import io.kodlama.Core.utilities.mernis.DHSKPSPublicSoap;
import org.springframework.stereotype.Component;

@Component
public class MernisAdapter implements  MernisAdapters {



    public DHSKPSPublicSoap MernisAdapters() {

        return new DHSKPSPublicSoap();



    }

}
