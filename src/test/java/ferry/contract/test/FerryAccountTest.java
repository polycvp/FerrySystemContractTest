package ferry.contract.test;

import static ferry.contract.test.FerryContractHolder.contract;
import ferry.dto.AbstractAccount;
import ferry.dto.AccountDetail;
import ferry.dto.AccountSummary;
import ferry.eto.InvalidAccountException;
import ferry.eto.NoSuchAccountException;
import org.junit.Test;
import static org.junit.Assert.*;

public class FerryAccountTest {
    private AccountDetail ad = new AccountDetail(12, "1234561234", "password", "Test1", "test@test.dk", "DK");
    public FerryAccountTest() {
    }

     @Test
     public void testMakeAccount() throws InvalidAccountException {
        boolean makeAccount = contract.makeAccount(ad);
        assertTrue(makeAccount);
     }
      @Test
     public void testEditAccount() throws NoSuchAccountException {
         ad.setAddress("EN");
        boolean editAccount = contract.editAccount(ad);
        assertTrue(editAccount);
     }
        @Test
     public void testShowAccount() throws NoSuchAccountException {
        AccountDetail showAccount = contract.showAccount(new AbstractAccount(1) {});
        assertEquals(showAccount.getId(),1);
     }
       @Test
     public void testDeleteAccount() throws NoSuchAccountException {
        AccountSummary deleteAccount = contract.deleteAccount(ad);
        assertEquals(deleteAccount.getId(),ad.getId());
     }
       @Test
     public void testValidLogin() throws NoSuchAccountException {
        AccountDetail login = contract.login("user@user.dk", "password");
        assertEquals(1,login.getId());
     }
       @Test(expected=NoSuchAccountException.class)
     public void testInvalidLogin() throws NoSuchAccountException {
         AccountDetail login = contract.login("user@user.dk", "ionvalid");
     }
       @Test
     public void testIsUserResident() {
        boolean userResident = contract.isUserResident(new AbstractAccount(1) {});
        assertTrue(userResident);
     }
}
