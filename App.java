import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class App {

    public static void main(String[] args) {
        try {
            // https://www.ncdc.noaa.gov/swdiws
            URL url = new URL("https://www.ncdc.noaa.gov/swdiws/xml/n3mda/20121029");
            HttpsURLConnection httpsCon = (HttpsURLConnection) url.openConnection();
            httpsCon.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                new InputStreamReader(httpsCon.getInputStream()));
            
            System.out.println(httpsCon.getResponseCode());

            boolean done = false;
            String responseLine = "";
            
            while (!done) {

                responseLine = in.readLine();
                if (responseLine == null) {
                    done = true;
                }
                else {
                    System.out.println(responseLine);
                }
            }
        } 
        catch (Exception e) {
            System.out.println("Error");
            e.printStackTrace();
        }
    }   
}