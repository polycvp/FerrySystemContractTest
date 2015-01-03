/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferry.contract.test;

import ferry.contract.FerryContract;
import static ferry.contract.test.FerryContractHolder.contract;
import ferry.dto.AccountDetail;
import ferry.eto.NoSuchAccountException;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Paul
 */
public class FerrycontractTest {
    
    public FerrycontractTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    @Test
     public void TestLogin1() {
        Assert.assertThat(1, is(1));
     }
     
     @Test(expected = Exception.class)
     public void TestLogin2() throws Exception {
        contract.login("fakeaccount@user.dk", "nopassword");
     }
}
