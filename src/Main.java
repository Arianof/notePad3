import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to notepad++!!");

        while(true) {
            System.out.println("Enter a number to do what you want to do:");
            System.out.println("1.add a note");
            System.out.println("2.delete a note");
            System.out.println("3.notes");
            System.out.println("4.export");
            System.out.println("5-exit");
            String name;
            String note;
            ArrayList<notePad> notePadArrayList = new ArrayList<>();
            ArrayList<String> stringArrayList = new ArrayList<>();

            try {
                FileReader fileReader = new FileReader("C:\\Users\\arian\\Documents\\uni\\Java\\notePad3\\names.txt");
                BufferedReader br = new BufferedReader(fileReader);
                String st;
                while ((st = br.readLine()) != null) {
                    try {
                        FileInputStream fIn = new FileInputStream("C:\\Users\\arian\\Documents\\uni\\Java\\notePad3\\" + st + ".bin");
                        ObjectInputStream in = new ObjectInputStream(fIn);
                        notePad notePad = (notePad) in.readObject();
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
            } catch (IOException e) {
                e.printStackTrace();
            }
            Scanner intScanner = new Scanner(System.in);
            int n = intScanner.nextInt();
            if (n == 1) {

                    Scanner scanner = new Scanner(System.in);
                    System.out.println("name: ");
                    name = scanner.next();
                    if (name.equals("exit")) {
                        break;
                    }
                    for (notePad no : notePadArrayList) {
                        if (name.equals(no.getName())) {
                            System.out.println("a file with this name exists already!");
                            return;
                        }
                    }
                    System.out.println("note: ");
                    note = scanner.nextLine();
                    note = scanner.nextLine();
                    notePad notePad = new notePad(name, note);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
                    LocalDateTime now = LocalDateTime.now();
                    notePad.setDate(dtf.format(now));
                    notePadArrayList.add(notePad);

                    try {
                        FileOutputStream fOut = new FileOutputStream(name + ".bin");
                        ObjectOutputStream out = new ObjectOutputStream(fOut);
                        FileWriter fileWriter = new FileWriter("names.txt");
                        for (String s : stringArrayList) {
                            fileWriter.write(s);
                            fileWriter.write("\n");
                        }
                        fileWriter.write(name);
                        out.writeObject(notePad);
                        fOut.close();
                        out.close();
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }



            }
            if (n == 2) {
                System.out.println("Enter exit to exit");
                while (true) {
                    System.out.println("choose a note to delete: ");
                    int i = 1;
                    for (notePad no : notePadArrayList) {
                        System.out.println(i + "-" + no.getName() + " , " + no.getDate());
                        i++;
                    }
                    Scanner scanner = new Scanner(System.in);
                    String in = scanner.next();
                    i = 0;
                    if (in.equals("exit")) {
                        break;
                    }
                    for (notePad no : notePadArrayList) {
                        if (in.equals(no.getName())) {
                            File file = new File("C:\\Users\\arian\\Documents\\uni\\Java\\notePad3\\" + no.getName() + ".bin");
                            file.delete();
                            notePadArrayList.remove(i);
                            stringArrayList.remove(i);
                            break;
                        }
                        i++;
                    }
                    File file = new File("C:\\Users\\arian\\Documents\\uni\\Java\\notePad3\\names.txt");
                    file.delete();
                    try {
                        FileWriter fileWriter = new FileWriter("names.txt");
                        for (String s : stringArrayList) {
                            fileWriter.write(s);
                            fileWriter.write("\n");
                        }
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (n == 3) {
                System.out.println("Enter 0 to exit");
                while (true) {
                    int i = 1;
                    for (notePad no : notePadArrayList) {
                        System.out.println(i + "-" + no.getName() + "," + no.getDate());
                        i++;
                    }
                    int m = intScanner.nextInt();
                    if (m == 0) {
                        break;
                    }
                    System.out.println("note: ");
                    System.out.println(notePadArrayList.get(m - 1).getNote());
                }
            }
            if (n == 4) {
                System.out.println("Enter 0 to exit");
                while (true) {
                    int i = 1;
                    for (notePad no : notePadArrayList) {
                        System.out.println(i + "-" + no.getName() + "," + no.getDate());
                        i++;
                    }
                    System.out.println("choose a note to export:");
                    int m = intScanner.nextInt();
                    if (m == 0) {
                        break;
                    }
                    try {
                        FileWriter fileWriter = new FileWriter(notePadArrayList.get(m - 1).getName() + ".txt");
                        fileWriter.write(notePadArrayList.get(m - 1).getNote());
                        fileWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if(n == 5){
                System.out.println("Hava a good day!");
                break;
            }

        }
    }
}