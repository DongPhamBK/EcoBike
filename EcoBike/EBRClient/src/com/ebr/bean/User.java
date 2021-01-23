package com.ebr.bean;

public class User {
    private String userId;
    private String idCard; //{SINGLE_BIKE, SINGLE_E_BIKE, DOUBLE_BIKE, DOUBLE_E_BIKE}
    private long accountBalance;
    private String name;
    // userId
    public User() {
        super();
    }

    public User(String userId, String name, String idCard , long accountBalance) {
        this.userId = userId;
        this.name = name;
        this.accountBalance = accountBalance;
        this.idCard = idCard;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getIdCard() {
        return idCard;
    }
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public long getAccountBalance() {
        return accountBalance;
    }
    public void setAccountBalance(long accountBalance ) {
        this.accountBalance = accountBalance;
    }



    public boolean match(User user) {
        if (user == null)
            return true;
        if (user.userId != null && !user.userId.equals("") && !this.userId.contains(user.userId)) {
            return false;
        }
        if (user.idCard != null && !user.idCard.equals("") && !this.idCard.contains(user.idCard)) {
            return false;
        }
        if (user.name != null && !user.name.equals("") && !this.name.contains(user.name)) {
            return false;
        }
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            return this.userId.equals(((User) obj).userId);
        }
        return false;
    }
}
