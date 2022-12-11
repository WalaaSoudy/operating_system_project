import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.*;
import java.io.IOException;
import java.util.*;



public class form extends JFrame {
    private JTextField n;
    private JTextField file;
    private JTextField buffer;
    private JButton startProducerButton;
    private JLabel large;
    private JLabel num;
    private JLabel time;
    private JPanel mainPanal;

    //fun prime
    public Vector<Integer> calculatePrime(int n) {
        Vector<Integer> vector = new Vector<Integer>();
        for (int i = 0; i <= n; i++) {
            boolean b = true;
            if (i == 1 || i == 0)
                continue;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    b = false;
                    break;
                }
            }
            if(b){
                vector.add(i);
            }
        }
        return vector;
    }
    public form(String title) throws IOException{
        super(title);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanal);
        this.pack();



        startProducerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int N = (int) Integer.parseInt(n.getText());
                int b = (int) Integer.parseInt(buffer.getText());
                String o = file.getText();

                 buffer buf = new buffer(b);
                Vector<Integer> vec_tor = new Vector<Integer>();
                vec_tor=calculatePrime(N);
                long startTime=System.nanoTime();
                producer P = new producer(buf,vec_tor);
                consumer C = new consumer(buf,o);
                P.start();
                C.start();



                long endTime=System.nanoTime();
                long duration=(endTime-startTime);

                int rnum = vec_tor.size();
                int rlarge = vec_tor.get(vec_tor.size()-1);
                long rtime = duration;
                String snum = Integer.toString(rnum);
                num.setText(snum);
                String slarge = Integer.toString(rlarge);
                large.setText(slarge);
                String stime = Long.toString(rtime);
                stime+=" ms";
                time.setText(stime);



            }
        });
    }

    public static void main(String[] args) throws IOException{
        JFrame frame = new form("Prime numbers");
        frame.setVisible(true);

    }



}
