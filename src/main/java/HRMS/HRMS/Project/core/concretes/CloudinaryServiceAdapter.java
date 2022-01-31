package HRMS.HRMS.Project.core.concretes;

import HRMS.HRMS.Project.core.abstracts.CloudinaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.File;
import java.util.Map;

@Service
public class CloudinaryServiceAdapter implements CloudinaryService {
    private Cloudinary cloudinary;

    @Autowired
    public CloudinaryServiceAdapter() {
        this.cloudinary = new Cloudinary("cloudinary://248615774465761:fXC-AN0XvhHQdbG8Q5kTtT6ZBQg@bireysel");
    }

    @Override
    public Map<String, Object> uploadAvatar(File file) {
        try {

            Map params = ObjectUtils.asMap(
                    "folder", null,
                    "public_id", null,
                    "overwrite", true,
                    "notification_url", null,
                    "resource_type", "image"

            );

            Map<String, Object> upload = cloudinary.uploader().upload(file, params);
            return upload;

        }

        catch (Exception e) {

            return null;
        }
    }
}
