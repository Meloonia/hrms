package io.kodlama.adapters;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

public class CloudinaryAdapter {
    @Bean
    public Cloudinary CloudinaryAdapter(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "ilkerhrmsproject",
                "api_key", "459134255231215",
                "api_secret", "FXSRUi6ovTlehQ26gPZ_mrxgTqc"));


    }

}