import java.io.*;

public class ObjectIOStream {
    ObjectInputStream ois;

    ObjectOutputStream oos;


    public ObjectIOStream() {

        try {
           // this.oos = new ObjectOutputStream( new FileOutputStream("object_file.xyz") );

            this.ois = new ObjectInputStream( new FileInputStream("object_file.xyz"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeObj() {
        // creating some objects
        Student s1 = new Student(1, "Pink", 25, 50);
        Student s2 = new Student(2, "Floyd", 23, 55);

        try {
            // write the objects as bytes/binary data to a file using ObjectOutputStream in a specific sequence
//            this.oos.writeObject(s1);
//            this.oos.writeObject(s2);
//
//            this.oos.close();

            // Then reading those objects from previously stored file according to insertion order
            // It will throw ugly exceptions if we don't follow insertion order
            // Remember to implement Serializable

            for(int i=0; i < 2; i++) {
                Student s = (Student) this.ois.readObject();
                System.out.println(s.toString());
            }
            this.ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
