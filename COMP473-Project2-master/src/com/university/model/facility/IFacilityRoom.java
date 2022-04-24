package com.university.model.facility;

import com.university.model.use.IUser;

import java.util.List;

public interface IFacilityRoom {
    String getPhoneNumber();
    void setPhoneNumber(String phoneNumber);
    int getFacilityRoomId();
    void setFacilityRoomId(int facilityRoomId);
    int getRoomNumber();
    void setRoomNumber(int roomNumber);
    int getCapacity();
    void setCapacity(int capacity);
    IFacilityLocation getFacilityLocation();
    void setFacilityLocation(IFacilityLocation facilityLocation);
    boolean isInUse();
    void setInUse(boolean inUse);
    // get list of all users who want to be notified if a room is available
    List<IUser> getUsers();
    void setUsers(List<IUser> users);
    //Implementation of the Observer Pattern.
    void subscribe(IUser user);
    void unsubscribe(IUser user);
    // send notification message to users who subscribed for room availability notification and implements
    //the Observer Pattern.
    void notifyAllUsers(boolean inUse, int roomNumber);
}
