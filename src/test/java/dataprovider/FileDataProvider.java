package dataprovider;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

 public  class FileDataProvider {
        //Здесь мы берём данные из файла user.data в папке resources
        @DataProvider(parallel = true)
        public static Iterator<Object[]> loadUserFromFile() throws IOException {
            final BufferedReader in = new BufferedReader(
                    new InputStreamReader(FileDataProvider.class.getResourceAsStream("resources/user.data")));

            List<Object[]> userData = new ArrayList<Object[]>() {{
                String line = in.readLine();
                while (line != null) {
                    add(line.split(";"));
                    line = in.readLine();
                }
            }};

            return userData.iterator();
        }
    }

