package test.java;

import com.university.model.facility.FacilityLocation;
import com.university.model.facility.FacilityManager;
import com.university.model.facility.FacilityRoom;
import com.university.model.facilityManagement.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MaintenanceLogTest {
    private List<MaintenanceOrder> maintenanceList = new ArrayList<>();
    private List<MaintenanceSchedule> scheduleList = new ArrayList<>();
    private List<MaintenanceRequest> requestList = new ArrayList<>();
    private List<Inspection> inspectionList = new ArrayList<>();

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        maintenanceList = new ArrayList<>();
        scheduleList = new ArrayList<>();
        requestList = new ArrayList<>();
        inspectionList = new ArrayList<>();

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        maintenanceList = null;
        scheduleList = null;
        requestList = null;
        inspectionList = null;
    }

    @org.junit.jupiter.api.Test
    void addInspection() {
        FacilityLocation facilityLocation = new FacilityLocation();
        facilityLocation.setFacilityId(1);
        facilityLocation.setName("Murphy Building");
        facilityLocation.setAddressNumber(123);
        facilityLocation.setStreetName("State Street");
        facilityLocation.setCity("Chicago");
        facilityLocation.setZipcode(123456);

        FacilityManager facilityManager = new FacilityManager();
        facilityManager.setManagerId(1);
        facilityManager.setManagerFirstName("Bob");
        facilityManager.setManagerLastName("Doe");
        facilityLocation.setFacilityManager(facilityManager);

        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);
        facilityRoom1.setFacilityLocation(facilityLocation);

        Inspector inspector = new Inspector();
        inspector.setInspectorID(1);
        inspector.setInspectorFirstName("Dan");
        inspector.setInspectorLastName("Tan");
        inspector.setInspectorTitle("Fire Safety Inspector");

        Inspection inspection = new Inspection();
        inspection.setInspectionID(1);
        inspection.setInspectionName("Fire safety");
        inspection.setInspector(inspector);
        inspection.setFacilityRoom(facilityRoom1);

        inspectionList.add(inspection);
        assertEquals(true, inspectionList.contains(inspection));
    }



    @org.junit.jupiter.api.Test
    void removeInspection() {
        FacilityLocation facilityLocation = new FacilityLocation();
        facilityLocation.setFacilityId(1);
        facilityLocation.setName("Murphy Building");
        facilityLocation.setAddressNumber(123);
        facilityLocation.setStreetName("State Street");
        facilityLocation.setCity("Chicago");
        facilityLocation.setZipcode(123456);

        FacilityManager facilityManager = new FacilityManager();
        facilityManager.setManagerId(1);
        facilityManager.setManagerFirstName("Bob");
        facilityManager.setManagerLastName("Doe");
        facilityLocation.setFacilityManager(facilityManager);

        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);
        facilityRoom1.setFacilityLocation(facilityLocation);

        Inspector inspector = new Inspector();
        inspector.setInspectorID(1);
        inspector.setInspectorFirstName("Dan");
        inspector.setInspectorLastName("Tan");
        inspector.setInspectorTitle("Fire Safety Inspector");

        Inspection inspection = new Inspection();
        inspection.setInspectionID(1);
        inspection.setInspectionName("Fire safety");
        inspection.setInspector(inspector);
        inspection.setFacilityRoom(facilityRoom1);

        inspectionList.add(inspection);
        inspectionList.remove(inspection);
        assertTrue(inspectionList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addMaintenanceRequest() {
        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);

        MaintenanceRequest request = new MaintenanceRequest();
        request.setRequestType("Plumbing");
        request.setRequestID(1);
        request.setRequestorID(1);
        request.setProblem("Leaking pipes");
        request.setRequestStatus("Open");
        request.setFacilityRoom(facilityRoom1);
        requestList.add(request);
        assertEquals(true, requestList.contains(request));
    }

    @org.junit.jupiter.api.Test
    void cancelMaintenanceRequest() {
        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);

        MaintenanceRequest request = new MaintenanceRequest();
        request.setRequestType("Plumbing");
        request.setRequestID(1);
        request.setRequestorID(1);
        request.setProblem("Leaking pipes");
        request.setRequestStatus("Open");
        request.setFacilityRoom(facilityRoom1);
        requestList.remove(request);
        assertEquals(true, requestList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void scheduleMaintenance() {
        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);

        MaintenanceWorker worker = new MaintenanceWorker();
        worker.setMaintWorkerID(1);
        worker.setMaintFirstName("Bob");
        worker.setMaintLastName("Bob");
        worker.setMaintTitle("Senior Electrician");

        MaintenanceSchedule schedule = new MaintenanceSchedule();
        schedule.setMaintenanceEndDate(new Date(2021, 02, 02, 8, 30));
        schedule.setMaintenanceStartDate(new Date(2021, 01, 25, 9,56));
        schedule.setMaintenanceWorker(worker);
        schedule.setFacilityRoom(facilityRoom1);

        scheduleList.add(schedule);
        assertEquals(true, scheduleList.contains(schedule));
    }

    @org.junit.jupiter.api.Test
    void cancelSchedule() {
        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);

        MaintenanceWorker worker = new MaintenanceWorker();
        worker.setMaintWorkerID(1);
        worker.setMaintFirstName("Bob");
        worker.setMaintLastName("Bob");
        worker.setMaintTitle("Senior Electrician");

        MaintenanceSchedule schedule = new MaintenanceSchedule();
        schedule.setMaintenanceEndDate(new Date(2021, 02, 02, 8, 30));
        schedule.setMaintenanceStartDate(new Date(2021, 01, 25, 9,56));
        schedule.setMaintenanceWorker(worker);
        schedule.setFacilityRoom(facilityRoom1);

        scheduleList.remove(schedule);
        assertEquals(true, scheduleList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void addMaintenanceOrder() {
        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);

        MaintenanceOrder order = new MaintenanceOrder();
        order.setOrderType("Urgent");
        order.setOrderID(1);
        order.setOrderDate(new Date(2021, 03, 01, 16, 45));
        order.setCost(100.0);
        order.setFacilityRoom(facilityRoom1);

        maintenanceList.add(order);
        assertEquals(true, maintenanceList.contains(order));
    }

    @org.junit.jupiter.api.Test
    void cancelMaintenanceOrder() {
        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);

        MaintenanceOrder order = new MaintenanceOrder();
        order.setOrderType("Urgent");
        order.setOrderID(1);
        order.setOrderDate(new Date(2021, 03, 01, 16, 45));
        order.setCost(100.0);
        order.setFacilityRoom(facilityRoom1);

        maintenanceList.remove(order);
        assertEquals(true, maintenanceList.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void calcMaintenanceCostForFacility() {
        FacilityLocation facilityLocation = new FacilityLocation();
        facilityLocation.setFacilityId(1);
        facilityLocation.setName("Murphy Building");
        facilityLocation.setAddressNumber(123);
        facilityLocation.setStreetName("State Street");
        facilityLocation.setCity("Chicago");
        facilityLocation.setZipcode(123456);

        FacilityManager facilityManager = new FacilityManager();
        facilityManager.setManagerId(1);
        facilityManager.setManagerFirstName("Bob");
        facilityManager.setManagerLastName("Doe");
        facilityLocation.setFacilityManager(facilityManager);
        facilityManager.addFacilities(facilityLocation);

        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);
        facilityRoom1.setFacilityLocation(facilityLocation);
        facilityLocation.addFacilityRoom(facilityRoom1);

        FacilityRoom facilityRoom2 = new FacilityRoom();
        facilityRoom2.setFacilityRoomId(2);
        facilityRoom2.setPhoneNumber("123-456-7890");
        facilityRoom2.setCapacity(9);
        facilityRoom2.setFacilityLocation(facilityLocation);
        facilityLocation.addFacilityRoom(facilityRoom2);
        facilityLocation.getListFacilityRooms();

        Inspector inspector = new Inspector();
        inspector.setInspectorID(1);
        inspector.setInspectorFirstName("Dan");
        inspector.setInspectorLastName("Tan");
        inspector.setInspectorTitle("Fire Safety Inspector");

        Inspection inspection = new Inspection();
        inspection.setInspectionID(1);
        inspection.setInspectionName("Fire safety");
        inspection.setInspector(inspector);
        inspection.setFacilityRoom(facilityRoom1);
        inspection.addInspector(inspector);
        inspection.getInspectorList();

        MaintenanceRequest request = new MaintenanceRequest();
        request.setRequestType("Plumbing");
        request.setRequestID(1);
        request.setRequestorID(1);
        request.setProblem("Leaking pipes");
        request.setRequestStatus("Open");
        request.setFacilityRoom(facilityRoom1);


        MaintenanceOrder order = new MaintenanceOrder();
        order.setOrderType("Urgent");
        order.setOrderID(1);
        order.setOrderDate(new Date(2021, 03, 01, 16, 45));
        order.setCost(100.0);
        order.setFacilityRoom(facilityRoom1);

        MaintenanceOrder order2 = new MaintenanceOrder();
        order2.setOrderType("Urgent");
        order2.setOrderID(2);
        order2.setOrderDate(new Date(2021, 04, 01, 16, 45));
        order2.setCost(50.0);
        order2.setFacilityRoom(facilityRoom2);

        MaintenanceWorker worker = new MaintenanceWorker();
        worker.setMaintWorkerID(1);
        worker.setMaintFirstName("Bob");
        worker.setMaintLastName("Bob");
        worker.setMaintTitle("Senior Electrician");

        MaintenanceSchedule schedule = new MaintenanceSchedule();
        schedule.setMaintenanceEndDate(new Date(2021, 02, 02, 8, 30));
        schedule.setMaintenanceStartDate(new Date(2021, 01, 25, 9,56));
        schedule.setMaintenanceWorker(worker);
        schedule.setFacilityRoom(facilityRoom1);


        MaintenanceLog maintenanceLog = new MaintenanceLog();
        maintenanceLog.addInspection(inspection);
        maintenanceLog.addMaintenanceOrder(order);
        maintenanceLog.addMaintenanceOrder(order2);

        double result = maintenanceLog.calcMaintenanceCostForFacility(facilityLocation);

        assertEquals(150, result);
    }

    @org.junit.jupiter.api.Test
    void calcProblemRateForFacility() {
        FacilityLocation facilityLocation = new FacilityLocation();
        facilityLocation.setFacilityId(1);
        facilityLocation.setName("Murphy Building");
        facilityLocation.setAddressNumber(123);
        facilityLocation.setStreetName("State Street");
        facilityLocation.setCity("Chicago");
        facilityLocation.setZipcode(123456);

        FacilityManager facilityManager = new FacilityManager();
        facilityManager.setManagerId(1);
        facilityManager.setManagerFirstName("Bob");
        facilityManager.setManagerLastName("Doe");
        facilityLocation.setFacilityManager(facilityManager);
        facilityManager.addFacilities(facilityLocation);

        FacilityRoom facilityRoom1 = new FacilityRoom();
        facilityRoom1.setFacilityRoomId(1);
        facilityRoom1.setPhoneNumber("123-456-7890");
        facilityRoom1.setCapacity(10);
        facilityRoom1.setFacilityLocation(facilityLocation);
        facilityLocation.addFacilityRoom(facilityRoom1);

        FacilityRoom facilityRoom2 = new FacilityRoom();
        facilityRoom2.setFacilityRoomId(2);
        facilityRoom2.setPhoneNumber("123-456-7890");
        facilityRoom2.setCapacity(9);
        facilityRoom2.setFacilityLocation(facilityLocation);
        facilityLocation.addFacilityRoom(facilityRoom2);
        facilityLocation.getListFacilityRooms();

        Inspector inspector = new Inspector();
        inspector.setInspectorID(1);
        inspector.setInspectorFirstName("Dan");
        inspector.setInspectorLastName("Tan");
        inspector.setInspectorTitle("Fire Safety Inspector");

        Inspection inspection = new Inspection();
        inspection.setInspectionID(1);
        inspection.setInspectionName("Fire safety");
        inspection.setInspector(inspector);
        inspection.setFacilityRoom(facilityRoom1);
        inspection.addInspector(inspector);
        inspection.getInspectorList();

        MaintenanceRequest request = new MaintenanceRequest();
        request.setRequestType("Plumbing");
        request.setRequestID(1);
        request.setRequestorID(1);
        request.setProblem("Leaking pipes");
        request.setRequestStatus("Open");
        request.setFacilityRoom(facilityRoom1);


        MaintenanceOrder order = new MaintenanceOrder();
        order.setOrderType("Urgent");
        order.setOrderID(1);
        order.setOrderDate(new Date(2021, 03, 01, 16, 45));
        order.setCost(100.0);
        order.setFacilityRoom(facilityRoom1);

        MaintenanceOrder order2 = new MaintenanceOrder();
        order2.setOrderType("Urgent");
        order2.setOrderID(2);
        order2.setOrderDate(new Date(2021, 04, 01, 16, 45));
        order2.setCost(50.0);
        order2.setFacilityRoom(facilityRoom2);

        MaintenanceWorker worker = new MaintenanceWorker();
        worker.setMaintWorkerID(1);
        worker.setMaintFirstName("Bob");
        worker.setMaintLastName("Bob");
        worker.setMaintTitle("Senior Electrician");

        MaintenanceSchedule schedule = new MaintenanceSchedule();
        schedule.setMaintenanceEndDate(new Date(2021, 02, 02, 8, 30));
        schedule.setMaintenanceStartDate(new Date(2021, 01, 25, 9,56));
        schedule.setMaintenanceWorker(worker);
        schedule.setFacilityRoom(facilityRoom1);


        MaintenanceLog maintenanceLog = new MaintenanceLog();
        maintenanceLog.addInspection(inspection);
        maintenanceLog.addMaintenanceOrder(order);
        maintenanceLog.addMaintenanceOrder(order2);
        maintenanceLog.addMaintenanceRequest(request);

        double result = maintenanceLog.calcProblemRateForFacility(facilityLocation);

        assertEquals(0.5, result);
    }

}