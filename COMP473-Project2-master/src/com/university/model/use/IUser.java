package com.university.model.use;

public interface IUser {
    String getUserFirstName();
    void setUserFirstName(String userFirstName);
    String getUserLastName();
    void setUserLastName(String userLastName);
    int getUserId();
    void setUserId(int userId);
    String getUserTitle();
    IType getUseType();
    int getOccupancy();
    void setOccupancy(int occupancy);
    void update(boolean inUse, int roomNumber);
}
