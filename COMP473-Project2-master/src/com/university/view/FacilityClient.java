package com.university.view;


import com.university.model.facility.*;
import com.university.model.facilityManagement.*;
import com.university.model.use.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

public class FacilityClient {
    public static void main(String[] args) throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/app-context.xml");
        System.out.println("***************** Application Context instantiated! ******************");
        //FacilityManagement instantiation



                // Facility instantiation
        FacilityLocation facility1 = (FacilityLocation) context.getBean("facilityLocation");

        facility1.setFacilityId(1);
        facility1.setName("Coffee Hall");
        facility1.setAddressNumber(123);
        facility1.setStreetName("Main Ave");
        facility1.setCity("Chicago");
        facility1.setZipcode(123456);

        FacilityLocation facility2 = (FacilityLocation) context.getBean("facilityLocation");

        facility2.setFacilityId(2);
        facility2.setName("Brown Hall");
        facility2.setAddressNumber(124);
        facility2.setStreetName("Main Ave");
        facility2.setCity("Chicago");
        facility2.setZipcode(123456);


        FacilityRoom room1 = (FacilityRoom) context.getBean("facilityRoom");

        room1.setFacilityRoomId(1);
        room1.setRoomNumber(101);
        room1.setPhoneNumber("123-4567");
        room1.setCapacity(10);
        room1.setInUse(true);

        FacilityRoom room2 = (FacilityRoom) context.getBean("facilityRoom");

        room2.setFacilityRoomId(2);
        room2.setRoomNumber(102);
        room2.setPhoneNumber("123-4568");
        room2.setCapacity(9);
        room2.setInUse(true);

        FacilityRoom room3 = (FacilityRoom) context.getBean("facilityRoom");

        room3.setFacilityRoomId(3);
        room3.setRoomNumber(101);
        room3.setPhoneNumber("123-4569");
        room3.setCapacity(1);
        room3.setInUse(true);

        FacilityRoom room4 = (FacilityRoom) context.getBean("facilityRoom");

        room4.setFacilityRoomId(4);
        room4.setRoomNumber(102);
        room4.setPhoneNumber("123-4560");
        room4.setCapacity(3);
        room4.setInUse(false);

        FacilityManager manager = (FacilityManager) context.getBean("facilityManager");

        manager.setManagerId(1);
        manager.setManagerFirstName("Bob");
        manager.setManagerLastName("Doe");

        // Associate facility room with facility location 1
        facility1.addFacilityRoom(room1);
        facility1.addFacilityRoom(room2);

        // Associate facility room with facility location 2
        facility2.addFacilityRoom(room3);
        facility2.addFacilityRoom(room4);

        // Associate facility locations with facility manager
        manager.addFacilities(facility1);
        manager.addFacilities(facility2);

        /*************************************************************************************/

        // Use instantiation

        Student student = (Student) context.getBean("student");

        student.setUserFirstName("Tom");
        student.setUserLastName("Thumb");
        student.setUserId(1);
        student.setOccupancy(10);

        Employee employee = (Employee) context.getBean("employee");

        employee.setUserFirstName("Bob");
        employee.setUserLastName("Doe");
        employee.setUserId(2);
        employee.setOccupancy(1);


        Office office = (Office) context.getBean("office");

        office.setTypeId(1);
        office.setUseStartDate(new Date(2020, 12, 1, 13, 45));
        office.setUseEndDate(new Date(2020, 12, 22, 10, 15));

        ClassRoom classRoom = (ClassRoom) context.getBean("classRoom");

        classRoom.setTypeId(2);
        classRoom.setUseStartDate(new Date(2020, 11, 1, 10, 00));
        classRoom.setUseEndDate(new Date(2020, 11, 1, 10, 45));

        // Associate facility use types with facility rooms
        office.setFacilityRoom(room1);
        classRoom.setFacilityRoom(room2);

        // Associate users with facility use type
        // TODO
        //student(classRoom);
        //employee.(office);

        // Use schedule contains list of facility room users and what the facility rooms are used for
        UseSchedule schedule = (UseSchedule) context.getBean("useSchedule");

        // Add users to use schedule
        schedule.assignUserToFacilityRoom(student);
        schedule.assignUserToFacilityRoom(employee);

        // Add use type to use schedule
        schedule.addActualUsage(office);
        schedule.addActualUsage(classRoom);

        // Print out facility management info
        System.out.println("\tFacility Manager: \t\t\t" + manager.getManagerFirstName() + " " + manager.getManagerLastName() + "\n");

        List<IFacilityLocation> facilities = manager.getListFacilities();

        for (IFacilityLocation facility : facilities) {
            System.out.println("\n\t" + "+++++++++++++++++++++++++++++++++");
            System.out.println("\tBuilding ID: \t\t" + facility.getFacilityId() + "\n");
            System.out.println("\tBuilding Name: \t\t" + facility.getName() + "\n");
            System.out.println("\tAddress: \t\t" + facility.getAddressNumber() + " " + facility.getStreetName() + "\n");
            System.out.println("\tCity: \t\t" + facility.getCity() + "\n");
            System.out.println("\tZipCode: \t\t" + facility.getZipcode() + "\n");

            List<IFacilityRoom> rooms = facility.getListFacilityRooms();

            System.out.println("\tFacility Usage Rate: \t\t" + facility.calcFacilityUsage(rooms) + "\n");

            for(IFacilityRoom room : rooms) {
                System.out.println("\n\t\t" + "+++++++++++++++++++++++++++++++++");
                System.out.println("\t\tRoom ID: \t\t" + room.getFacilityRoomId() + "\n");
                System.out.println("\t\tRoom Number: \t\t" + room.getRoomNumber() + "\n");
                System.out.println("\t\tPhone Number: \t\t" + room.getPhoneNumber() + "\n");
                System.out.println("\t\tCapacity: \t\t" + room.getCapacity() + "\n");
                System.out.println("\t\tUse Status: \t\t" + room.isInUse() + "\n");
            }
        }

        // Print facility use info
        System.out.println("\t" + "++++++++++++++++++++++++++++++++++++");
        List<IUser> users = schedule.getListUsers();
        for(IUser user : users) {
            System.out.println("\tUser ID: \t\t" + user.getUserId()+ "\n");
            System.out.println("\tUser Name: \t\t" + user.getUserFirstName() + " " + user.getUserLastName()+ "\n");
            System.out.println("\tUser Title: \t\t" + user.getUserTitle()+ "\n");
            System.out.println("\n" + "+++++++++++++++++++++++++++++++++");
        }

        List<IType> types = schedule.getListActualUsage();
        for (IType type: types) {
            System.out.println("\t\tType ID: \t\t" + type.getTypeId()+ "\n");
            System.out.println("\t\tUse: \t\t" + type.getFacilityUseType() + "\n");
            System.out.println("\t\tUse Start Date: \t\t" + type.getUseStartDate() + "\n");
            System.out.println("\t\tUse End Date: \t\t" + type.getUseEndDate() + "\n");
            System.out.println("\n\t" + "+++++++++++++++++++++++++++++++++");
        }

       // System.out.println("\tAvailable Capacity for use type 1: \t\t" + schedule.requestAvailableCapacity(room1, type1) + "\n");
       // System.out.println("\tRoom 1 is in use for: \t\t" + schedule.timeInterval(type1) + " seconds" + "\n");
        System.out.println("\n\t" + "+++++++++++++++++++++++++++++++++");

        /*************************************************************************************/
        // Facility Maintenance instantiation
        Inspection inspection1 = (Inspection) context.getBean("inspection");
        inspection1.setInspectionID(1234);
        inspection1.setInspectionName("day1");


        Inspection inspection2 = (Inspection) context.getBean("inspection");
        inspection2.setInspectionID(5678);
        inspection2.setInspectionName("day1");

        Inspector inspector1 = (Inspector) context.getBean("inspector");
        inspector1.setInspectorID(1234);
        inspector1.setInspectorTitle("Mister");
        inspector1.setInspectorFirstName("James");
        inspector1.setInspectorLastName("Earl");

        MaintenanceLog log1 = (MaintenanceLog) context.getBean("maintenanceLog");

        MaintenanceOrder order1 = (MaintenanceOrder) context.getBean("maintenanceOrder");
        order1.setOrderID(123456);
        order1.setOrderDate(new Date(2020, 12, 1, 13, 45));
        order1.setCost(0.1);
        order1.setOrderType("new");
        order1.setFacilityRoom(room1);


        MaintenanceRequest request1 = (MaintenanceRequest) context.getBean("maintenanceRequest");

        request1.setRequestID(1234);
        request1.setProblem("broken");
        request1.setRequestDate(new Date(2020, 12, 1, 13, 45));
        request1.setRequestStatus("broken");
        request1.setRequestorID(12345);
        request1.setRequestType("fix");

        MaintenanceSchedule schedule1 = (MaintenanceSchedule) context.getBean("maintenanceSchedule");

        schedule1.setScheduleID(1234);
        schedule1.setMaintenanceEndDate(new Date(2020, 12, 1, 13, 45));

        schedule1.setMaintenanceStartDate(new Date(2020, 12, 1, 13, 45));

        MaintenanceWorker worker1 = (MaintenanceWorker) context.getBean("maintenanceWorker");
        worker1.setMaintFirstName("earl");
        worker1.setMaintWorkerID(1234);
        worker1.setMaintLastName("Young");
        worker1.setMaintTitle("worker");

        schedule1.setMaintenanceWorker(worker1);
        request1.setFacilityRoom(room1);
        order1.setFacilityRoom(room1);
        inspection1.setFacilityRoom(room1);
        inspection2.setFacilityRoom(room1);
        schedule1.setFacilityRoom(room1);

        inspection1.addInspector(inspector1);
        inspection2.addInspector(inspector1);
        log1.addInspection(inspection1);
        log1.addMaintenanceRequest(request1);
        log1.addMaintenanceOrder(order1);
        log1.scheduleMaintenance(schedule1);

        // Print out maintenance log info
        List<IInspector> inspectors = inspection1.getInspectorList();
        for(IInspector inspector : inspectors) {
            System.out.println("\tInspector ID: \t\t" + inspector.getInspectorID() + "\n");
            System.out.println("\tInspector Name: \t\t" + inspector.getInspectorFirstName() + " " + inspector.getInspectorLastName() + "\n");
            System.out.println("\tInspector Title: \t\t" + inspector.getInspectorTitle() + "\n");
            System.out.println("\n\t" + "+++++++++++++++++++++++++++++++++");
        }

        List<IOrder> orders = log1.getMaintenanceOrderList();
        for(IOrder order : orders) {
            System.out.println("\tOrder Type: \t\t" + order.getOrderType() + "\n");
            System.out.println("\tOrder ID: \t\t" + order.getOrderID() + "\n");
            System.out.println("\tOrder Date: \t\t" + order.getOrderDate() + "\n");
            System.out.println("\tOrder Cost: \t\t" + order.getCost() + "\n");
            System.out.println("\n\t" + "+++++++++++++++++++++++++++++++++");
        }

        List<ISchedule> schedules = log1.getMaintenanceScheduleList();
        for(ISchedule maintSchedule : schedules) {
            System.out.println("\tMaintenance Start Date: \t\t" + maintSchedule.getMaintenanceStartDate() + "\n");
            System.out.println("\tMaintenance End Date: \t\t" + maintSchedule.getMaintenanceEndDate() + "\n");
            System.out.println("\tSchedule ID: \t\t" + maintSchedule.getScheduleID() + "\n");
            System.out.println("\tDown Time: \t\t" + maintSchedule.calcDownTimeForFacilityRoom(maintSchedule.getMaintenanceStartDate(), maintSchedule.getMaintenanceEndDate()) + "\n");
            System.out.println("\n\t" + "+++++++++++++++++++++++++++++++++");
        }

        List<IRequest> requests = log1.getMaintenanceRequestList();
        for(IRequest request : requests) {
            System.out.println("\tRequest Type: \t\t" + request.getRequestType() + "\n");
            System.out.println("\tRequest ID: \t\t" + request.getRequestID() + "\n");
            System.out.println("\tRequest Date: \t\t" + request.getRequestDate() + "\n");
            System.out.println("\tRequestor ID: \t\t" + request.getRequestorID() + "\n");
            System.out.println("\tRequest Status: \t\t" + request.getRequestStatus() + "\n");
            System.out.println("\tProblem: \t\t" + request.getProblem() + "\n");
            System.out.println("\n\t" + "+++++++++++++++++++++++++++++++++");
        }
        List<IInspection> inspections = log1.getInspectionList();
        for(IInspection inspection : inspections) {
            System.out.println("\tInspection Name: \t\t" + inspection.getInspectionName()+ "\n");
            System.out.println("\tInspection ID: \t\t" + inspection.getInspectionID() + "\n");
            System.out.println("\n\t" + "+++++++++++++++++++++++++++++++++");
        }

        System.out.println("\t Total Cost for Maintenance: \t\t" + log1.calcMaintenanceCostForFacility(facility1) + "\n");
        System.out.println("\t Problem Rate: \t\t" + log1.calcProblemRateForFacility(facility1) + "\n");
        System.out.println("\n\t" + "+++++++++++++++++++++++++++++++++");

    }
}
