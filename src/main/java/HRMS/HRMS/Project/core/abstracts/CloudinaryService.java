package HRMS.HRMS.Project.core.abstracts;

import java.io.File;
import java.util.Map;

public interface CloudinaryService {
    Map<String,Object> uploadAvatar(File file);
}
