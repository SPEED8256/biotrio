package dk.kea.project.biotrio.Service;


import dk.kea.project.biotrio.Domain.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
