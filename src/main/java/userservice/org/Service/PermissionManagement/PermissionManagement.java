package userservice.org.Service.PermissionManagement;

import java.util.List;

public interface PermissionManagement {
    public Boolean addPermission(String email, String Password, String email2, List<String> permissions) throws Exception;
    public Boolean removePermission(String email, String Password, String email2, List<String> permissions) throws Exception;
}
