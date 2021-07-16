package io.kodlama.adapters;

import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Service;

@Service
public interface UploadImageServices {
    Cloudinary CloudinaryAdapter();
}
