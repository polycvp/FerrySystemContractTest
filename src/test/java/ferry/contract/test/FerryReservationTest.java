package ferry.contract.test;

import static ferry.contract.test.FerryContractHolder.contract;
import ferry.dto.AbstractVehicle;
import ferry.dto.AccountDetail;
import ferry.dto.AccountSummary;
import ferry.dto.PassengerDTO;
import ferry.dto.ReservationDetail;
import ferry.dto.ReservationSummary;
import ferry.eto.NoSuchAccountException;
import ferry.eto.NoSuchReservationException;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;


public class FerryReservationTest {

    public FerryReservationTest() {
    }

    @Test
    public void testMakeReservation() throws NoSuchReservationException {
        AccountSummary accS = new AccountSummary(12,"1234561234", "Test3", "test3@test.dk", "EU");
        ArrayList<PassengerDTO> passengers = new ArrayList<PassengerDTO>();
        ArrayList<AbstractVehicle> vehicles = new ArrayList<AbstractVehicle>();
        
        ReservationDetail resDetail = new ReservationDetail(accS, passengers, vehicles, "Constanta", "Copenhagen", 
               new Date(), new Date(), 4590, "15RES31");
        ReservationSummary makeReservation = contract.makeReservation(resDetail);
        assertTrue(makeReservation.getReservationSerialNumber()=="15RES31");
    }

    @Test(expected =UnsupportedOperationException.class)
    public void testEditReservation() throws Exception {
        boolean editAccount = contract.editAccount(new AccountDetail(123, "1234561234", "password", "test100", "test100@test.dk", "ES"));
        assertTrue(editAccount);
    }

    @Test
    public void testDeleteReservation() throws NoSuchReservationException {
        assertTrue(contract.deleteReservation(1));
    }
    
}
