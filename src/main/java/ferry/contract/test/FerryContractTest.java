package ferry.contract.test;


import static ferry.contract.test.FerryContractHolder.contract;
import ferry.dto.AccountDetail;
import ferry.eto.NoSuchAccountException;
import static org.hamcrest.CoreMatchers.is;
import org.junit.Assert;
import org.junit.Test;

public class FerryContractTest {

     @Test
     public void TestLogin1() throws Exception {
        AccountDetail acc = new AccountDetail(1, "1234561234", "password", "User", "user@user.dk", "DK");
        AccountDetail login = contract.login(acc.getEmail(), acc.getPassword());
        Assert.assertThat(acc.getCprNo(), is(login.getCprNo()));
     }
     
     @Test(expected = NoSuchAccountException.class)
     public void TestLogin2() throws Exception {
        contract.login("fakeaccount@user.dk", "nopassword");
     }
}
