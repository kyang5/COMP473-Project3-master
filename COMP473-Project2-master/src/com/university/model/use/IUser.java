package com.university.model.use;

public interface IUser {
    public String getUserFirstName();
    public void setUserFirstName(String userFirstName);
    public String getUserLastName();
    public void setUserLastName(String userLastName);
    public int getUserId();
    public void setUserId(int userId);
    public String getUserTitle();
    public void setUserTitle(String userTitle);
    // abstract useType
    //abstract public void assignUseType();
    //abstract IType getUseType();
    //abstract void setUseType(IType useType);
}
