package test.java;

import com.university.model.facility.FacilityLocation;
import com.university.model.facility.FacilityRoom;
import com.university.model.use.IUser;
import com.university.model.use.Office;
import com.university.model.use.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FacilityRoomTest {

    private List<IUser> users = new ArrayList<>();

    @BeforeEach
    void setUp() {
        List<IUser> users = new ArrayList<>();
    }

    @AfterEach
    void tearDown() {
        users = null;
    }

    @Test
    void subscribe() {
        FacilityLocation facility = new FacilityLocation();
        facility.setFacilityId(1);
        facility.setName("Murphy Building");
        facility.setAddressNumber(123);
        facility.setStreetName("State Street");
        facility.setCity("Chicago");
        facility.setZipcode(123456);

        FacilityRoom room = new FacilityRoom();
        room.setFacilityRoomId(1);
        room.setRoomNumber(101);
        room.setPhoneNumber("123-456-7890");
        room.setCapacity(10);
        room.setFacilityLocation(facility);
        room.setInUse(true);

        Office office =  new Office();
        office.setTypeId(1);
        office.setFacilityRoom(room);
        office.setUseStartDate(new Date(2020, 12, 1, 13, 45));
        office.setUseEndDate(new Date(2020, 12, 1, 14, 45));

        Student student = new Student(office);
        student.setUserFirstName("John");
        student.setUserLastName("Doe");
        student.setUserId(1);
        student.setOccupancy(1);

        users.add(student);

        assertEquals("John", student.getUserFirstName());
        assertEquals("Doe", student.getUserLastName());
        assertEquals(1, student.getUserId());
        assertEquals(1, student.getOccupancy());
        assertTrue(users.contains(student));
    }

    @Test
    void unsubscribe() {
        FacilityLocation facility = new FacilityLocation();
        facility.setFacilityId(1);
        facility.setName("Murphy Building");
        facility.setAddressNumber(123);
        facility.setStreetName("State Street");
        facility.setCity("Chicago");
        facility.setZipcode(123456);

        FacilityRoom room = new FacilityRoom();
        room.setFacilityRoomId(1);
        room.setRoomNumber(101);
        room.setPhoneNumber("123-456-7890");
        room.setCapacity(10);
        room.setFacilityLocation(facility);
        room.setInUse(true);

        Office office =  new Office();
        office.setTypeId(1);
        office.setFacilityRoom(room);
        office.setUseStartDate(new Date(2020, 12, 1, 13, 45));
        office.setUseEndDate(new Date(2020, 12, 1, 14, 45));

        Student student = new Student(office);
        student.setUserFirstName("John");
        student.setUserLastName("Doe");
        student.setUserId(1);
        student.setOccupancy(1);

        users.add(student);
        users.remove(student);

        assertTrue(users.isEmpty());
    }
}