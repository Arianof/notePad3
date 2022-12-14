import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

public class notePad implements Serializable {
    private String name;
    private String note;
    private String  date;

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setDate(String date) {
        this.date = date;
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

    @Override
    public String toString() {
        return "notePad{" +
                "name='" + name + '\'' +
                ", note='" + note + '\'' +
                ", date='" + date + '\'' +
                '}';
    }

    public void setNote(String note) {
        this.note = note;
    }


}
