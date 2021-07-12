package io.kodlama.adapters;

import io.kodlama.Utils.Controls.Mernis.TQHKPSPublicSoap12;
import org.springframework.stereotype.Component;

@Component
public interface MernisServices{

    TQHKPSPublicSoap12 MernisImpl();
}
