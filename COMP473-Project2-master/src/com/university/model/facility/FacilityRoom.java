package com.university.model.facility;

public class FacilityRoom implements IFacilityRoom{
    private String phoneNumber;
    private int facilityRoomId;
    private int roomNumber;
    private int capacity;
    private IFacilityLocation facilityLocation;
    private boolean inUse;


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



}