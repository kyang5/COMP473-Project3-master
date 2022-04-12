package com.university.model.facilityManagement;

public class MaintenanceWorker implements IWorker {
    private String firstName;
    private String lastName;
    private int maintenanceWorkerID;
    private String title;

    public String getMaintFirstName(){
        return firstName;
    }
    public String getMaintLastName(){
        return lastName;
    }
    public int getMaintWorkerID(){
        return maintenanceWorkerID;
    }
    public String getMaintTitle(){
        return title;
    }
    public void setMaintFirstName(String firstName){
        this.firstName = firstName;
    }
    public void setMaintLastName(String lastName){
        this.lastName = lastName;
    }
    public void setMaintWorkerID(int maintenanceWorkerID){
        this.maintenanceWorkerID = maintenanceWorkerID;
    }
    public void setMaintTitle(String title){
        this.title = title;
    }
}
