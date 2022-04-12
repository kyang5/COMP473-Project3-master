package com.university.model.facility;

import java.util.List;

public interface IFacilityManager {
    String getManagerFirstName();
    void setManagerFirstName(String managerFirstName);
    String getManagerLastName();
    void setManagerLastName(String managerLastName);
    int getManagerId();
    void setManagerId(int managerId);
    // returns a list of all facilities a facility manager is assigned to
    List<IFacilityLocation> getListFacilities();
    void setListFacilities(List<IFacilityLocation> listFacilities);
    void addFacilities(IFacilityLocation facilityLocation);
    void removeFacilities(IFacilityLocation facilityLocation);
}
