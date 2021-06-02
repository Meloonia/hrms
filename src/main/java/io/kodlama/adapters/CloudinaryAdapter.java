package io.kodlama.adapters;
import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryAdapter {

    Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
            "cloud_name", "ilkerhrmsproject",
            "api_key", "459134255231215",
            "api_secret", "FXSRUi6ovTlehQ26gPZ_mrxgTqc"));


    public Cloudinary CloudinaryAdapter(){
        Cloudinary cloudinary = new Cloudinary();
        return cloudinary;

    }

}
