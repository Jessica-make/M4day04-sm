package org.spoto.model;

public class Account {
    private Integer id;
    private String account;
    private String passwd;

    //user_id=userId

    public Account() {
    }

    public Account(Integer id, String account, String passwd) {
        this.id = id;
        this.account = account;
        this.passwd = passwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", passwd='" + passwd + '\'' +
                '}';
    }
}
