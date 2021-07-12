package io.kodlama.adapters;

import io.kodlama.Utils.Controls.Mernis.TQHKPSPublicSoap12;
import org.springframework.stereotype.Component;

@Component("MernisImpl")
public class MernisImpl implements MernisServices {


    public TQHKPSPublicSoap12 MernisImpl() {

        TQHKPSPublicSoap12 mernis = new TQHKPSPublicSoap12();

        return mernis;

    }
}
