package userservice.org.Service.DeactivateOrBan;

public interface DeactivateOrBan {
    public Boolean banAccount(String email, String password, String email2) throws Exception;
    public Boolean deactivateAccount(String email, String password) throws Exception;
}
