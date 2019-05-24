package dk.kea.project.biotrio.Service;

public interface SecurityService {
    String findLoggedInUsername();

    void autoLogin(String username, String password);
}
