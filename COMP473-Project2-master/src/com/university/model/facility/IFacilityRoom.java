package com.university.model.facility;

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
}
