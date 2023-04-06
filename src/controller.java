import javax.swing.*;

public class controller {
    private model m;
    private view v;

    public controller(model m, view v) {
        this.m = m;
        this.v = v;

        JFrame frame = new JFrame("Forum");
        frame.setContentPane(v.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800,800);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public void forum(){
        m.databaseConector();
        m.getForum();
        String msg = m.printArrays();

    }

    public static void main(String[] args) {
        model m = new model();
        view v = new view();
        controller c = new controller(m,v);
        c.forum();

    }
}
