import java.io.File;

class dirtree{
    dirtree() {
        realSearch("/home/ta/Desktop/New directory/Processing",1);
    }
    public static void main(String args[]) {
        new dirtree();
    }
    void println(String in) {
        System.out.println(in);
    }
    void print(String in) {
        System.out.print(in);
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
              print("\t");
            }
            println(names[i]);
            printlist(dir + "/" + names[i], level+1,limitlevel);
          }
        }
    }
}