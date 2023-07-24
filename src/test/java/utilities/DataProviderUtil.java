package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {
    @DataProvider
    public static Object[][] sehirverileri() {
        return new Object[][]{
                {"Ankara","icanadolu",06},
                {"Istanbul","Marmara",34},
                {"Izmir","Ege",35},
                {"Diyarbakir","Güneydoguoguanadolu",21},
                {"Corum","icanadolu",19}


        };
    }
}
