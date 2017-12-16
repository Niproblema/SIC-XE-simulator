
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jan
 */
public class FileDevice implements Device {

    private String path;
    private RandomAccessFile file;

    public FileDevice(String path) {
        this.path = path;
        try {
            file = new RandomAccessFile(path, "rw");
        } catch (Exception e) {
            System.out.println("File canno't be opened!");
        }
    }

    @Override
    public boolean test() {
        return true;
    }

    @Override
    public byte readDevice() {
        if(file!= null){
            try {
                return (byte)file.read();
            } catch (Exception e) {
                System.out.println("Error reading device");
            }
        }
        return -1;
    }

    @Override
    public void writeDevice(byte val) {
        if(file != null){
            try {
                file.write(val);
            } catch (Exception e) {
                System.out.println("Error writing to device");
            }
        }
    }

}
