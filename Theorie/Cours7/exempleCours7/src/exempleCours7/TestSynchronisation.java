package exempleCours7;
public class TestSynchronisation {
    public static void main(String args[]) {
        Messager m = new Messager();
       
        new AppelDeMessager(m, "Message 3");
        new AppelDeMessager(m, "Message 2");
        new AppelDeMessager(m, "Message 1");
        new AppelDeMessager(m, "Message 4");
    }
}


