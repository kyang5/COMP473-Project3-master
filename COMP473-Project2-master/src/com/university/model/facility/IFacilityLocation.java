package com.university.model.facility;

import java.util.List;

public interface IFacilityLocation {
    int getFacilityId();
    void setFacilityId(int facilityId);
    String getName();
    void setName(String name);
    int getAddressNumber();
    void setAddressNumber(int addressNumber);
    String getStreetName();
    void setStreetName(String streetName);
    String getCity();
    void setCity(String city);
    int getZipcode();
    void setZipcode(int zipcode);
    List<IFacilityRoom> getListFacilityRooms();
    void setListFacilityRooms(List<IFacilityRoom> listFacilityRooms);

    // same as addFacilityDetail()
    void addFacilityRoom(IFacilityRoom facilityRoom);
    void removeFacilityRoom(IFacilityRoom facilityRoom);
    IFacilityManager getFacilityManager();
    void setFacilityManager(IFacilityManager facilityManager);
    // same as calcUsageRate()
    double calcFacilityUsage(List<IFacilityRoom> listFacilityRooms);
}
