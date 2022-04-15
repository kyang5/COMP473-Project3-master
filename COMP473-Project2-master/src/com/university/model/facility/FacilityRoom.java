package com.university.model.facility;

import com.university.model.use.IUser;

import java.util.ArrayList;
import java.util.List;

public class FacilityRoom implements IFacilityRoom{
    private String phoneNumber;
    private int facilityRoomId;
    private int roomNumber;
    private int capacity;
    private IFacilityLocation facilityLocation;
    private boolean inUse;
    private List<IUser> users = new ArrayList<>();


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getFacilityRoomId() {
        return facilityRoomId;
    }

    public void setFacilityRoomId(int facilityRoomId) {
        this.facilityRoomId = facilityRoomId;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public IFacilityLocation getFacilityLocation() {
        return facilityLocation;
    }

    public void setFacilityLocation(IFacilityLocation facilityLocation) {
        this.facilityLocation = facilityLocation;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public List<IUser> getUsers() {
        return users;
    }

    public void setUsers(List<IUser> users) {
        this.users = users;
    }

    public void subscribe(IUser user) {
        users.add(user);
    }

    public void unsubscribe(IUser user) {
        users.remove(user);
    }

    public void notifyAllUsers() {

    }
}