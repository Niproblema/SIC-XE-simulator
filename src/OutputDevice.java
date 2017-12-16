
import java.io.OutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class OutputDevice implements Device {
    
    private OutputStream OS;
    
    public OutputDevice(OutputStream os){
       this.OS = os;
    }

    @Override
    public boolean test() {
        return true;
    }

    @Override
    public byte readDevice() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void writeDevice(byte val) throws RuntimeException {
        try {
            OS.write(val);
            OS.flush();
        } catch (Exception e) {
            throw new RuntimeException("Error in reading device");
        }
    }
    
}
