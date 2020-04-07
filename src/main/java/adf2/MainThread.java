package adf2;

import adf2.entity.Account;
import adf2.model.AccountModelImplement;
import adf2.view.ConsoleView;

public class MainThread {
    public static void main(String[] args) {
        seeding(); // tạo dữ liệu mẫu.
        ConsoleView view = new ConsoleView();
        view.generateMenu();
    }

    // Insert vào bảng accounts 10 bản ghi.
    private static void seeding() {
        AccountModelImplement model = new AccountModelImplement();
        model.clearData();
        Account account0 = new Account("xuanhung", "1234", "Xuan Hung", "2010-10-10");
        model.save(account0);
        Account account1 = new Account("hongluyen", "4321", "Hong Luyen", "1999-02-20");
        model.save(account1);
        Account account2 = new Account("hoangtung", "3456", "Hoang Tung", "1990-11-15");
        model.save(account2);
        Account account3 = new Account("viettung", "9876", "Viet Tung", "2000-11-30");
        model.save(account3);
        Account account4 = new Account("vanbang", "2345", "Van Bang", "1995-09-02");
        model.save(account4);
        Account account5 = new Account("haituan", "2345", "Hai Tuan", "2000-03-12");
        model.save(account5);
        Account account7 = new Account("thanhtung", "2345", "Thanh Tung", "2001-02-03");
        model.save(account7);
    }
}
