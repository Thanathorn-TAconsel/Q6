import java.io.File;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;

class dirtree{
    JFrame f = new JFrame();
    ArrayList<JButton> bs = new ArrayList<JButton>();
    dirtree() {
        f.setBounds(100,100,400,600);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setVisible(true);
        realSearch("/home/ta/Desktop/New directory/Processing",1);
    }
    private void addButton(String name,int level) {
        JButton b = new JButton(name);
        b.setLocation(level * 20,bs.size() * 30);
        b.setSize(200,30);
        bs.add(b);
        f.repaint();
        f.add(b);
    }
    public static void main(String args[]) {
        new dirtree();
    }
    void realSearch(String rootpath,int limitlevel) {
        printlist(rootpath, 0,limitlevel);
      }
    void printlist(String dir, int level,int limitlevel) {
        File file = new File(dir); 
        if (file.isDirectory() && level <= limitlevel) {
          String names[] = file.list();
          for (int i = 0; i < names.length; i++) {
            for (int j = 0; j < level; j++) {
                System.out.print("\t");
            }
            System.out.println(names[i]);
            addButton(names[i], level);
            printlist(dir + "/" + names[i], level+1,limitlevel);
          }
        }
    }
}