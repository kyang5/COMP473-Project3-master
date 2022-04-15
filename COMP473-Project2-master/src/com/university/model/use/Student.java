package com.university.model.use;

public class Student implements IUser{

    private String userFirstName;
    private String userLastName;
    private int userId;
    private final IType useType;
    public int occupancy;

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserTitle() {
        return "Student";
    }

    public Student(IType useType) {
        this.useType = useType;
    }

    public IType getUseType() {
        return useType;
    }

    public int getOccupancy() {
        return occupancy;
    }

    public void setOccupancy(int occupancy) {
        this.occupancy = occupancy;
    }

    public void update(boolean inUse, int roomNumber){
        System.out.println("Room " + roomNumber + " is currently in use: " + inUse );
    }
}
