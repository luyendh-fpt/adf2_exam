package adf2.model;


import adf2.entity.Account;

import java.util.ArrayList;

// Thao tác với bảng accounts
public interface AccountModel {

    boolean save(Account account);

    ArrayList<Account> loadList();

    Account getByUsernameAndPassword(String username, String password);
}
