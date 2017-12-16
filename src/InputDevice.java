
import java.io.InputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class InputDevice implements Device {
    
    private InputStream IS;
    
    public InputDevice(InputStream is){
        this.IS = is;        
    }

    @Override
    public boolean test() {
      return true;
    }

    @Override
    public byte readDevice() throws RuntimeException {
        try {
            return (byte)IS.read();
        } catch (Exception e) {
            throw new RuntimeException("Error in reading device");
        }
    }

    @Override
    public void writeDevice(byte val) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
