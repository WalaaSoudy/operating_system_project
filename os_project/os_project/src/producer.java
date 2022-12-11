import java.util.*;

public class producer extends Thread{
    buffer buf;
    Vector<Integer> vec =new Vector<Integer>();
    public producer(buffer buf,Vector<Integer> v) {
        this.buf = buf;
        vec = v;
    }
    public void run() {
        for (int i = 0; i < vec.size(); i++){
            buf.produce(vec.get(i));
        }


    }


}
