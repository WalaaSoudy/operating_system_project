import java.util.LinkedList;
import java.util.Queue;
public class buffer {
    private int size;
    semaphore spaces;
    semaphore elements;
    Queue<Object> q;
   public buffer(int s){
       size = s;
       spaces = new semaphore(size);
       elements = new semaphore(0);
       q = new LinkedList<>();
    }
    public void produce(Object value) {
        spaces.P();
        q.add(value);
        elements.V();
    }
    public Object consume() {
        Object value;
        elements.P();
        value = q.peek();
        q.remove();
        spaces.V();
        return value;
    }


}
