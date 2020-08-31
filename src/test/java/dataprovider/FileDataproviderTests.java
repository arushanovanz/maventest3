package dataprovider;

import org.testng.annotations.Test;


public class FileDataproviderTests {



    @Test(dataProviderClass = FileDataProvider.class,dataProvider = "loadUserFromFile")
    public void test1(String user, String password) {
        System.out.println("test with data from file "+ user + ": " + password);
    }


}
