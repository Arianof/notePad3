import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name;
        String note;
        Scanner scanner = new Scanner(System.in);
        name = scanner.next();
        note = scanner.nextLine();
        note = scanner.nextLine();
        notePad notePad = new notePad(name , note);

        try {
            FileOutputStream fOut = new FileOutputStream(name + ".bin");
            ObjectOutputStream out = new ObjectOutputStream(fOut);
            out.writeObject(notePad);
            fOut.close();
            out.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }


    }
}