package com.spring.demo.entity;

import javax.persistence.*;
import java.security.SecureRandom;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Account {
    @Id
    @GeneratedValue
    private long id;
    private String username;
    private long createdAt;
    private long updatedAt;

    @Column(columnDefinition = "int default 1")
    private int status;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Student student;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Set<AccountCredential> accountCredentialSet;

    public Set<AccountCredential> getAccountCredentialSet() {
        return accountCredentialSet;
    }

    public void setAccountCredentialSet(Set<AccountCredential> accountCredentialSet) {
        this.accountCredentialSet = accountCredentialSet;
    }

    public void addAccountCredentialSet(AccountCredential accountCredential) {
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[20];
        random.nextBytes(bytes);
        String token = bytes.toString();
        accountCredential.setToken(token);
        if (this.accountCredentialSet == null) {
            this.accountCredentialSet = new HashSet<AccountCredential>();
        }
        this.accountCredentialSet.add(accountCredential);
    }

    public Account() {
        this.id = Calendar.getInstance().getTimeInMillis();
        this.createdAt = Calendar.getInstance().getTimeInMillis();
        this.updatedAt = Calendar.getInstance().getTimeInMillis();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
