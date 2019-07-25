package com.spring.demo.dto;

import com.spring.demo.entity.Account;

import java.util.Calendar;

public class StudentDto {
    private long accountId;
    private String username;
    private String rollNumber;
    private String currentClass;
    private long createdAtMLS;
    private String createdAt;
    private long updatedAtMLS;
    private int status;

    public StudentDto() {

    }

    public StudentDto(Account account) {
        this.accountId = account.getId();
        this.username = account.getUsername();
        if (account.getStudent() != null) {
            this.rollNumber = account.getStudent().getRollNumber();
            this.currentClass = account.getStudent().getCurrentClass();
        }
        this.createdAtMLS = account.getCreatedAt();
        if (createdAtMLS > 0) {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(account.getCreatedAt());
            this.createdAt = calendar.getTime().toString();
        }
        this.updatedAtMLS = account.getUpdatedAt();
        this.status = account.getStatus();
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCurrentClass() {
        return currentClass;
    }

    public void setCurrentClass(String currentClass) {
        this.currentClass = currentClass;
    }

    public long getCreatedAtMLS() {
        return createdAtMLS;
    }

    public void setCreatedAtMLS(long createdAtMLS) {
        this.createdAtMLS = createdAtMLS;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAtMLS() {
        return updatedAtMLS;
    }

    public void setUpdatedAtMLS(long updatedAtMLS) {
        this.updatedAtMLS = updatedAtMLS;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
