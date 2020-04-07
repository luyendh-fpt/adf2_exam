package adf2.view;

import adf2.controller.AccountController;
import adf2.entity.Account;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleView {

    private AccountController controller = new AccountController();
    private Scanner scanner = new Scanner(System.in);

    // Menu
    // 1. Danh sách accounts.
    // 2. Xem account chi tiết -> Yêu cầu người dùng nhập username và password // login
    // 2.1. Nếu có username và password trùng thì hiển thị thông tin đầy đủ của account.
    // 2.2. Nếu không có thì báo "không tìm thấy account"
    // 3. Thoát.
    // Nhập lựa chọn của bạn.
    public void generateMenu() {
        while (true) {
            System.out.println("------------Account Management-----------");
            System.out.println("1. Danh sách account.");
            System.out.println("2. Xem account chi tiết.");
            System.out.println("3. Thoát chương trình.");
            System.out.println("-------------------------------------");
            System.out.println("Vui lòng nhập lựa chọn của bạn (1 đến 3) : ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    ArrayList<Account> list = controller.getList();
                    printList(list);
                    break;
                case 2:
                    Account account = controller.getAccountByUsernamePassword();
                    printDetail(account);
                    break;
                case 3:
                    System.out.println("Thoát chương trình. Hẹn lại bạn sau!");
                    break;
                default:
                    System.out.println("Vui lòng lựa chọn trong khoảng từ 1 đến 3.");
                    break;
            }
            if (choice == 3) {
                break;
            }
        }
    }

    private void printDetail(Account account) {
        if (account == null) {
            System.out.println("Không tìm thấy account!");
        } else {
            System.out.println(String.format("Thông tin account, username: %s, full name: %s",
                    account.getUsername(),
                    account.getFullName()
            ));
        }
    }

    private void printList(ArrayList<Account> list) {
        if (list.size() == 0) {
            System.out.println("Hiện tại không có account trong danh sách.");
            return;
        }
        System.out.println("------------------------------------------------------------Danh sách các account----------------------------------------------------");
        System.out.printf("%5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s\n"
                , "", "Username", "", "|"
                , "", "Password", "", "|"
                , "", "Full Name", "", "|"
                , "", "Created At", "");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s %s %5s %20s %5s\n"
                    , "", list.get(i).getUsername(), "", "|"
                    , "", "*****", "", "|"
                    , "", list.get(i).getFullName(), "", "|"
                    , "", list.get(i).getCreatedDate(), "");
        }
    }

}
