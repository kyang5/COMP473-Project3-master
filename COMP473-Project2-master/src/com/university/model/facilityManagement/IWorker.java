package com.university.model.facilityManagement;

public interface IWorker {
    String getMaintFirstName();
    String getMaintLastName();
    int getMaintWorkerID();
    String getMaintTitle();
    void setMaintFirstName(String firstName);
    void setMaintLastName(String lastName);
    void setMaintWorkerID(int maintenanceWorkerID);
    void setMaintTitle(String title);
}
