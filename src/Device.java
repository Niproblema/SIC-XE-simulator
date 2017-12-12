
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author jan
 */
public interface Device {

    public boolean test();

    public byte readDevice();

    public void writeDevice(byte val);
}
