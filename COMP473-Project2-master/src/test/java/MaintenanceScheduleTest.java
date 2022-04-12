package test.java;

import com.university.model.facilityManagement.MaintenanceSchedule;
import com.university.model.use.UseSchedule;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceScheduleTest {
    private Date maintenanceStartDate;
    private Date maintenanceEndDate;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        Date maintenanceStartDate;
        Date maintenanceEndDate;
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        Date maintenanceStartDate = null;
        Date maintenanceEndDate = null;
    }

    @org.junit.jupiter.api.Test
    void calcDownTimeForFacilityRoom() {

        MaintenanceSchedule schedule = new MaintenanceSchedule();
        schedule.setMaintenanceEndDate(new Date(2021, 02, 02, 8, 30));
        schedule.setMaintenanceStartDate(new Date(2021, 01, 25, 9,56));

        long result = schedule.calcDownTimeForFacilityRoom(schedule.getMaintenanceStartDate(),schedule.getMaintenanceEndDate());
        assertEquals(426840000, result);
    }
}