package com.university.model.use;

import com.university.model.facility.IFacilityRoom;

import java.util.List;

public interface IUseSchedule {
    boolean isAtCapacity();
    int requestAvailableCapacity(IFacilityRoom room, IUser user);
    List<IUser> getListUsers();
    void setListUsers(List<IUser> listUsers);
    void assignUserToFacilityRoom(IUser user);
    void vacateFacilityRoom(IUser user);
    List<IType> getListActualUsage();
    void setListActualUsage(List<IType> listActualUsage);
    void addActualUsage(IType facilityUseType);
    void removeActualUsage(IType facilityUseType);
    long timeInterval(IType facilityUseType);
}
