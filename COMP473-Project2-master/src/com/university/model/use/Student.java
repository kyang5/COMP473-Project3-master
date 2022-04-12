package com.university.model.use;

public class Student extends User{

    private String userTitle;
    private IType useType;

    public String getUserTitle() {
        return userTitle;
    }

    public void setUserTitle() {
        this.userTitle = "Student";
    }

    public IType getUseType() {
        return useType;
    }

    public void setUseType(IType useType) {
        this.useType = useType;
    }
}
