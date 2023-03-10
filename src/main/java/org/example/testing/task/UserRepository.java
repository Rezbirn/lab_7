package org.example.testing.task;

import java.security.NoSuchProviderException;

public class UserRepository {

    public User findUser(Integer id) throws NoSuchProviderException {
        throw new NoSuchProviderException();
    }

    public User saveUser(User user) throws NoSuchProviderException {
        throw new NoSuchProviderException();
    }

    public User updateUser(User user) throws NoSuchProviderException {
        throw new NoSuchProviderException();
    }

    public void deleteUser(Integer id) throws NoSuchProviderException {
        throw new NoSuchProviderException();
    }
}
