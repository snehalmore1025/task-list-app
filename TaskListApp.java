import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TaskListApp extends JFrame implements ActionListener {

    JPanel p1;
    ArrayList<String> tasks;
    JTextField t1;
    JTextArea ta1;
    JButton addb, removeb, listb, quitb;
    JLabel l1;

    public TaskListApp() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        p1=new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.WHITE);
        p1.setBounds(320, 70, 500, 600);

        tasks = new ArrayList<>();

        l1=new JLabel("Enter Task :");
        l1.setBounds(20,10,200,30);
        l1.setFont(new FontUIResource("Serif", java.awt.Font.BOLD, 20));
        p1.add(l1);
        t1 = new JTextField(50);
        t1.setBounds(150,10,290,30);
        t1.setFont(new FontUIResource("Serif", java.awt.Font.BOLD, 20));
        ta1 = new JTextArea(100,100);
        ta1.setFont(new FontUIResource("Serif", java.awt.Font.BOLD, 20));

        addb = new JButton("Add Task");
        addb.setBounds(140,90,200,30);
        addb.setFont(new FontUIResource("Serif", java.awt.Font.BOLD, 20));
        addb.addActionListener(this);

        removeb = new JButton("Remove Task");
        removeb.setBounds(140,150,200,30);
        removeb.setFont(new FontUIResource("Serif", java.awt.Font.BOLD, 20));
        removeb.addActionListener(this);

        listb = new JButton("List Tasks");
        listb.setBounds(140,210,200,30);
        listb.setFont(new FontUIResource("Serif", java.awt.Font.BOLD, 20));
        listb.addActionListener(this);

        quitb = new JButton("Quit");
        quitb.setBounds(140,270,200,30);
        quitb.setFont(new FontUIResource("Serif", java.awt.Font.BOLD, 20));
        quitb.addActionListener(this);
        
        p1.add(t1);
        p1.add(addb);
        p1.add(removeb);
        p1.add(listb);
        p1.add(quitb);
        add(p1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addb) {
            String task = t1.getText().trim();
            if (!task.isEmpty()) {
                tasks.add(task);
                t1.setText("");
                update();
            }
        } else if (e.getSource() == removeb) {
            String task = t1.getText().trim();
            if (tasks.remove(task)) {
                update();
            }
        } else if (e.getSource() == listb) {
            StringBuilder taskList = new StringBuilder("Tasks:\n");
            for (int i = 0; i < tasks.size(); i++) {
                taskList.append(i + 1).append(". ").append(tasks.get(i)).append("\n");
            }
            JOptionPane.showMessageDialog(this, taskList.toString(), "Task List", JOptionPane.INFORMATION_MESSAGE);
        } else if (e.getSource() == quitb) {
            System.exit(0);
        }
    }

    private void update() {
        ta1.setText("");
        for (String task : tasks) {
            ta1.append(task + "\n");
        }
    }

    public static void main(String[] args) {
        java.awt.Color bg = new java.awt.Color(1f, 0.85f,0.72f );
        TaskListApp t = new TaskListApp();
        t.setTitle("Task List Application");
        t.setVisible(true);
        t.setBackground(bg);
        t.setBounds(350, 100, 500, 500);
    }
}
