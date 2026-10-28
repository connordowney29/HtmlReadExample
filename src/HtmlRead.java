import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HtmlRead {

    public static void main(String[] args) {
        HtmlRead html = new HtmlRead();
    }

    public HtmlRead() {

        try {
            System.out.println();
            System.out.print("hello \n");
            URL url = new URL("https://www.milton.edu/");

            URLConnection urlc = url.openConnection();
            urlc.setRequestProperty("User-Agent", "Mozilla 5.0 (Windows; U; " + "Windows NT 5.1; en-US; rv:1.8.0.11) ");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(urlc.getInputStream())
            );
            String line;
            while ( (line = reader.readLine()) != null ) {
                //todo: only print line when there is a link
                if(line.contains("http")) {
                    //todo: get rid of the html before the link
                    int start = line.indexOf("http");
                    //todo: get rid of the html afer the link
                    int end = line.indexOf('"', start);
                    System.out.println(line.substring(start, end-1));
                }
            }
            reader.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }

    }

}
