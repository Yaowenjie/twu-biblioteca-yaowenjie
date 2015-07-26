package entity;

//import com.twu.biblioteca.*;
/**
 * Created by admin on 2015/7/26.
 */
public class User {
    private String libNumber;
    private String libPassword;
    private String name;
    private String emailAddress;
    private String phoneNumber;

    public User(String libNumber, String libPassword, String name, String emailAddress, String phoneNumber) {
        this.libNumber = libNumber;
        this.libPassword = libPassword;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }


    public String getLibNumber() {
        return libNumber;
    }

    public void setLibNumber(String libNumber) {
        this.libNumber = libNumber;
    }

    public String getLibPassword() {
        return libPassword;
    }

    public void setLibPassword(String libPassword) {
        this.libPassword = libPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isLogin(String libNum,String libPw){
        if(this.libNumber.equals(libNum) && this.libPassword.equals(libPw)) return true;
        else return false;
    }
}
