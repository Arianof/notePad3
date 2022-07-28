import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        String note;
        ArrayList<notePad> notePadArrayList = new ArrayList<>();
        ArrayList<String> stringArrayList = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("C:\\Users\\arian\\Documents\\uni\\Java\\notePad\\names.txt");
            BufferedReader br = new BufferedReader(fileReader);
            String st;
            while ((st = br.readLine()) != null){
                try {
                    FileInputStream fIn = new FileInputStream("C:\\Users\\arian\\Documents\\uni\\Java\\notePad\\"+ st+".bin");
                    ObjectInputStream in = new ObjectInputStream(fIn);
                    notePad notePad = (notePad)in.readObject();
                    notePadArrayList.add(notePad);
                    stringArrayList.add(st);
                    fIn.close();
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException c) {
                    c.printStackTrace();
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        note = scanner.nextLine();
        note = scanner.nextLine();
        notePad notePad = new notePad(name , note);
        notePadArrayList.add(notePad);

        try {
            FileOutputStream fOut = new FileOutputStream(name + ".bin");
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            FileWriter fileWriter = new FileWriter("names.txt");
            for (String s : stringArrayList){
                fileWriter.write(s);
                fileWriter.write("\n");
            }
            fileWriter.write(name);
            out.writeObject(notePad);
            fOut.close();
            out.close();
            fileWriter.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }



    }
}