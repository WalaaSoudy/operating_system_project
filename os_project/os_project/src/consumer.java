import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
public class consumer extends Thread{
    buffer buf;
    String str;

    public consumer(buffer buf,String s) {
        this.buf = buf;
        this.str=s;

    }
    public void run() {


           try
             {
                 File file = new File(str);

                 FileWriter fr = new FileWriter(file, true);

                 while(buf.q.size()>0) {


                 fr.write("' "+(buf.consume().toString())+" ',");

                 }
                 fr.write("\n");
                 fr.close();
            } catch (IOException e) {
                 System.out.println("error");
            }


    }

}
