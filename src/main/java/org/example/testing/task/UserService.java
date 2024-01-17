package org.example.testing.task;

import java.security.NoSuchProviderException;

public class UserService {

    private UserRepository userRepository;
    private AddressService addressService;


    public UserService(UserRepository userRepository, AddressService addressService)
    {
        this.userRepository = userRepository;
        this.addressService = addressService;
    }

    public User getUser(Integer id) throws NoSuchProviderException {
        if (id == null) {
            throw new IllegalArgumentException("userId could not be null");
        }
        User user = userRepository.findUser(id);
        if (user == null) {
            throw new IllegalArgumentException("Could not find user with id=" + id);
        }
        Address address = addressService.findAddress(user.getUserId());
        user.setAddress(address);
        return user;
    }

    public void deleteUser(Integer id) throws NoSuchProviderException {
        if (id == null) {
            throw new IllegalArgumentException("userId could not be null");
        }
        User user = userRepository.findUser(id);
        Address address = addressService.findAddress(user.getUserId());
        addressService.deleteAddress(address.getAddressId());
        userRepository.deleteUser(id);
    }

    public User createUser(User user) throws NoSuchProviderException {
        if (user.getUserId() == null) {
            throw new IllegalArgumentException("userId could not be null");
        }
        Address address = user.getAddress();
        if (address == null) {
            throw new IllegalArgumentException("Address could not be null");
        }
        if (address.getAddressId() == null) {
            throw new IllegalArgumentException("addressId could not be null");
        }
        validateUser(user);
        validateAge(user.getAge());
        validateEmail(user.getEmail());
        validatePhone(user.getPhoneNumber());
        validateName(user.getName());

        addressService.addAddress(address);
        userRepository.saveUser(user);
        return user;
    }

    private void validateAge(Integer age) {
        if (age == null) {
            throw new IllegalArgumentException("age could not be null");
        }
        if (age < 0) {
            throw new ArithmeticException("wrong age");
        }
        if (age > 20) {
            throw new ArithmeticException("wrong age");
        }
    }

    private void validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("email could not be null");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("wrong email");
        }
    }

    private void validatePhone(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isEmpty()) {
            throw new IllegalArgumentException("phoneNumber could not be null");
        }
        if (!phoneNumber.startsWith("+")) {
            throw new IllegalArgumentException("phoneNumber should start with '+'");
        }
        if (phoneNumber.length() != 12) {
            throw new IllegalArgumentException("wrong phone number");
        }
        if (phoneNumber.contains("67")) {
            throw new IllegalArgumentException("wrong phone number");
        }
    }

    private void validateUser(User user) {
        if (user == null ) {
            throw new IllegalArgumentException("user could not be null");
        }
        user.setName(user.getName().replace("a", "A"));
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("name could not be null");
        }
        if (!name.startsWith("A")) {
            throw new IllegalArgumentException("name should start with 'A'");
        }
        if (name.length() > 20) {
            throw new RuntimeException("wrong name");
        }

    }
}
