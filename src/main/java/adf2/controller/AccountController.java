package adf2.controller;

import adf2.entity.Account;
import adf2.model.AccountModelImplement;

import java.util.ArrayList;
import java.util.Scanner;

public class AccountController {

    private AccountModelImplement model = new AccountModelImplement();
    private Scanner scanner = new Scanner(System.in);

    public ArrayList<Account> getList(){
        return model.loadList();
    }

    public Account getAccountByUsernamePassword(){
        System.out.println("Vui lòng nhập username: ");
        String username = scanner.nextLine();
        System.out.println("Vui lòng nhập password: ");
        String pwd = scanner.nextLine();
        return model.getByUsernameAndPassword(username, pwd);
    }
}
