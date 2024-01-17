package org.example.testing.task;

import java.security.NoSuchProviderException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;



public class UserServiceTest {

    private UserRepository mockUserRepository;
    private AddressService mockAddressService;
    private UserService userService;

    @Before
    public void setUp() {
        mockUserRepository = mock(UserRepository.class);
        mockAddressService = mock(AddressService.class);
        userService = new UserService(mockUserRepository, mockAddressService);
    }

    @Test
    public void getUser() throws NoSuchProviderException  {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User mockUser = new User(1, "John Doe", "john@example.com", mockAddress, "+123456789012", 25);

        when(mockUserRepository.findUser(1)).thenReturn(mockUser);
        when(mockAddressService.findAddress(1)).thenReturn(mockAddress);

        User resultUser = userService.getUser(1);

        assertNotNull(resultUser);
        assertEquals(mockUser, resultUser);

        assertEquals(mockAddress, resultUser.getAddress());

    }

    @Test
    public void deleteUser() throws NoSuchProviderException {


        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User mockUser = new User(1, "John Doe", "john@example.com", mockAddress, "+123456789012", 25);

        when(mockUserRepository.findUser(1)).thenReturn(mockUser);
        when(mockAddressService.findAddress(1)).thenReturn(mockAddress);

        userService.deleteUser(1);

        verify(mockAddressService).deleteAddress(mockAddress.getAddressId());
        verify(mockUserRepository).deleteUser(1);


    }

    @Test
    public void createUser() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User mockUser = new User(1, "Aaron Doe", "john@example.com", mockAddress, "+12345768901", 19);
        userService.createUser(mockUser);
    }



    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithNullId() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(null, "Aaron", "aaron@email.com", mockAddress, "+12345768901", 19);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithNullAddress() throws NoSuchProviderException {
        User invalidUser = new User(null, "Aaron", "aaron@email.com", null, "+12345768901", 19);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithNullIdAddress() throws NoSuchProviderException {
        Address mockAddress = new Address(null, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Aaron", "aaron@email.com", mockAddress, "+12345768901", 19);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithNullAge() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Aaron", "aaron@email.com", mockAddress, "+12345768901", null);
        userService.createUser(invalidUser);
    }

    @Test(expected = ArithmeticException.class)
    public void testCreateUserWithInvalidAgeMoreThan19() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Aaron", "aaron@email.com", mockAddress, "+12345768901", 20);
        userService.createUser(invalidUser);
    }
    @Test(expected = ArithmeticException.class)
    public void testCreateUserWithInvalidAgeLessThen0() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Aaron", "aaron@email.com", mockAddress, "+12345768901", 0);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithNullEmail() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Aaron", null, mockAddress, "+12345768901", 19);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithInvalidEmail() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Aaron", "aaronemail.com", mockAddress, "+12345768901", 19);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithInvalidPhoneStartWithPlus() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Aaron", "aaron@email.com", mockAddress, "12345768901", 19);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithInvalidPhoneLengthNotEquals12() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Aaron", "aaron@email.com", mockAddress, "+1234576890", 19);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithInvalidPhoneContains67() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Aaron", "aaron@email.com", mockAddress, "+12345678901", 19);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithNullUser() throws NoSuchProviderException {
        userService.createUser(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithNullName() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, null, "aaron@email.com", mockAddress, "+12345768901", 19);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithInvalidNameStartWithA() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Baron", "aaron@email.com", mockAddress, "+12345768901", 19);
        userService.createUser(invalidUser);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithInvalidNameLengthMoreThan20() throws NoSuchProviderException {
        Address mockAddress = new Address(1, 1, "Country", "City", "Street", "Building");
        User invalidUser = new User(1, "Aaron678901234567890", "aaron@email.com", mockAddress, "+12345768901", 19);
        userService.createUser(invalidUser);
    }




}