package adf2.model;

import adf2.entity.Account;
import adf2.helper.ConnectionHelper;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

public class AccountModelImplement implements AccountModel {

    public boolean save(Account account) {
        try {
            PreparedStatement preparedStatement = ConnectionHelper.getConnection()
                    .prepareStatement("insert into accounts (username, password, fullName, createdDate) values (?,?,?,?)");
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getFullName());
            Date date = Date.valueOf(account.getCreatedDate()); // dần chuyển sang Calendar.
            preparedStatement.setDate(4, date);
            preparedStatement.execute();
            return true;
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Account> loadList() {
        ArrayList<Account> list = new ArrayList<Account>();
        try {
            String cmd = "select * from accounts"; // chưa có phân trang.
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(cmd);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                Date date = resultSet.getDate("createdDate");
                String strPublicDate = date.toString();
                Account obj = new Account(username, password, fullName, strPublicDate);
                list.add(obj);
            }
        } catch (Exception ex) {
            System.err.println("Không thể lấy dữ liệu từ database. Message: " + ex.getMessage());
        }
        return list;
    }

    public Account getByUsernameAndPassword(String usernamePara, String passwordPara) {
        try {
            String cmd = "select * from accounts where username = ? and password = ?"; // chưa có phân trang.
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(cmd);
            preparedStatement.setString(1, usernamePara);
            preparedStatement.setString(2, passwordPara);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String fullName = resultSet.getString("fullName");
                Date date = resultSet.getDate("createdDate");
                String strPublicDate = date.toString();
                Account obj = new Account(username, password, fullName, strPublicDate);
                return obj;
            }
        } catch (Exception ex) {
            System.err.println("Không thể lấy dữ liệu từ database. Message: " + ex.getMessage());
        }
        return null;
    }

    public boolean clearData(){
        try {
            Statement stt = ConnectionHelper.getConnection().createStatement();
            stt.execute("truncate table accounts");
            return true;
        } catch (Exception ex) {
            System.err.println("Error: " + ex.getMessage());
            return false;
        }
    }
}
