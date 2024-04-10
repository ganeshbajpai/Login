package com.login.service;

import java.util.List;
import java.util.Optional;

import com.login.model.Login;

public interface LoginServiceinf {

    List<Login> LoginInfo();

    Optional<Login> getCustomer(long Id);

    Login addCustomer(Login login);

    Login updateCustomer(Login login, long Id);

    void deleteLogin(long customerId);

    boolean verifyLoginDetails(String email, String password);
}
