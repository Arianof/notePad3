import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class notePad implements Serializable {
    private String name;
    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public notePad(String name, String note) {
        this.name = name;
        this.note = note;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "notePad{" +
                "name='" + name + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
