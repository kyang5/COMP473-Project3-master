package com.university.model.use;

import com.university.model.facility.IFacilityRoom;

import java.util.*;

public class UseSchedule implements IUseSchedule{
    private int availableCapacity;
    // date and time entered at the same time in same variable
    private List<IType> listActualUsage = new ArrayList<>();
    private List<IUser> listUsers = new ArrayList<>();

    public boolean isAtCapacity() {
        return availableCapacity == 0;
    }

    public int requestAvailableCapacity(IFacilityRoom room, IUser user) {
        availableCapacity = room.getCapacity() - user.getOccupancy();
        if (availableCapacity < 0) {
            throw new IllegalArgumentException ("Occupancy exceeds room occupancy");
        } else {
            return availableCapacity;
        }
    }

    // get list of users, room they are using and what they are using the room for
    public List<IUser> getListUsers() {
        return listUsers;
    }

    public void setListUsers(List<IUser> listUsers) {
        this.listUsers = listUsers;
    }

    public void assignUserToFacilityRoom(IUser user) {
        listUsers.add(user);
    }

    public void vacateFacilityRoom(IUser user) {
        // remove user and the facility use type from facility room
        listUsers.remove(user);
    }

    public List<IType> getListActualUsage() {
        return listActualUsage;
    }

    public void setListActualUsage(List<IType> listActualUsage) {
        this.listActualUsage = listActualUsage;
    }

    // add a facility room and its use type to list of actual usage
    public void addActualUsage (IType facilityUseType) {
        listActualUsage.add(facilityUseType);
    }

    public void removeActualUsage(IType facilityUseType) {
        listActualUsage.remove(facilityUseType);
    }


    // how long a room is in use
    public long timeInterval(IType facilityUseType) {
        long end = facilityUseType.getUseEndDate().getTime();
        long start = facilityUseType.getUseStartDate().getTime();
        return end - start;
    }
}