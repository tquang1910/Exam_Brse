package com.vti.entity;

public class User {
    private int id;
    private String fullName;
    private String email;
    private String password;
    private int projectId;
    private byte expInYear;
    private String proSkill;
    private Role role;
    public enum Role {
        ADMIN, EMPLOYEE, MANAGER
    }

    public User(int id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public byte getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(byte expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", projectId=" + projectId +
                ", expInYear=" + expInYear +
                ", proSkill='" + proSkill + '\'' +
                ", role=" + role +
                '}';
    }
}
