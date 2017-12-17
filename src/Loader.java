
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jan, povzeto po https://github.com/jurem/SicTools
 */
public class Loader {

    public static String readString(Reader r, int len) {
        String s = "";
        try { 
            for (int i = 0; i < len; i++) {
                s += (char)r.read();
            }
        } catch (Exception e) {
            System.out.println("Error reading string from ObjectFile");
        }

        return s;
    }

    public static int readByte(Reader r) throws IOException {
        return Integer.parseInt(readString(r, 2), 16) & 0xFF;
    }

    public static int readWord(Reader r) throws IOException {
        return Integer.parseInt(readString(r, 6), 16) & 0xFFFFFF;
    }

    public static void loadObjFile(Machine machine, String filename) {
        try {
            Reader reader = new FileReader(filename);
            if(!Loader.loadSection(machine, reader)){
                System.out.println("Object file has not been parsed!");
            }
        } catch (Exception e) {
            System.out.println("Error loading object file");
        }
    }

    public static boolean loadSection(Machine machine, Reader r) {
        try {
            // header record
            if (r.read() != 'H') {
                return false;
            }
            readString(r, 6);	// name is ignored
            int start = readWord(r);
            int length = readWord(r);
            r.read();  // EOL

            Memory mem = machine.mem;
            // text records
            int ch = r.read();
            while (ch == 'T') {
                int loc = readWord(r);
                int len = readByte(r);
                while (len-- > 0) {
                    if (loc < start || loc >= start + length) {
                        return false;
                    }
                    byte val = (byte) readByte(r);
                    mem.setByte(loc++, val);
                }
                r.read();  // EOL
                ch = r.read();
            }

            // modification records
            while (ch == 'M') {
                readWord(r);	// addr
                readByte(r);	// len
                r.read();  // EOL
                ch = r.read();
            }

            // load end record
            if (ch != 'E') {
                return false;
            }
            machine.PC.setValue(readWord(r));
        } catch (IOException e) {
            return false;
        }
        return true;
    }

}
