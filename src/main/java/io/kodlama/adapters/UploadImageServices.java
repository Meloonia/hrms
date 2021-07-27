package io.kodlama.adapters;

import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public interface UploadImageServices {
    Cloudinary CloudinaryAdapter();
}
