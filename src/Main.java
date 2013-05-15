/**
 * Created with IntelliJ IDEA.
 * User: Jason Edstrom
 * Class: ICS 340
 * Assignment: PHPConnection
 * Date: 5/15/13
 * Time: 11:23 AM
 * Java Class: PACKAGE_NAME
 */
import java.net.*;
import java.io.*;

public class Main {
    public static void main(String args[]) throws IOException {


            try {
                URL url;
                URLConnection urlConnection;
                DataOutputStream outStream;
                DataInputStream inStream;

                // Build request body
                String body =
                        "fName=" + URLEncoder.encode("Atli", "UTF-8") +
                                "&lName=" + URLEncoder.encode("Þór", "UTF-8");

                // Create connection
                url = new URL("http://www.agentmoobius.net/test/POST/post.php");
                urlConnection = url.openConnection();
                ((HttpURLConnection)urlConnection).setRequestMethod("POST");
                urlConnection.setDoInput(true);
                urlConnection.setDoOutput(true);
                urlConnection.setUseCaches(false);
                urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
                urlConnection.setRequestProperty("Content-Length", ""+ body.length());

                // Create I/O streams
                outStream = new DataOutputStream(urlConnection.getOutputStream());


                // Send request
                outStream.writeBytes(body);
                outStream.flush();
                outStream.close();

                // Get Response
                inStream = new DataInputStream(urlConnection.getInputStream());
                // - For debugging purposes only!
                String buffer;
                while((buffer = inStream.readLine()) != null) {
                    System.out.println(buffer);
                }

                // Close I/O streams
                inStream.close();
                outStream.close();
            }
            catch(Exception ex) {
                System.out.println("Exception caught:\n"+ ex.toString());
            }
        }

    }

