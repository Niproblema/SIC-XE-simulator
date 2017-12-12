
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 *
 * @author jan
 */
public class Machine {
    Register A, X, L, B, S, T, F, SW;
    PCRegister PC;
    Register[] indexReg;
    final int MAX_ADDRESS;
    Memory mem;
    Device[] dev;

    public Machine() {
        A = new Register(0);
        X = new Register(0);
        L = new Register(0);
        B = new Register(0);
        S = new Register(0);
        T = new Register(0);
        F = new Register(0.0);
        PC = new PCRegister(0);
        SW = new SWRegister(0);
        indexReg = new Register[] {A,X,L,B,S,T};
        
        MAX_ADDRESS = (int)Math.pow(2, 15);
        mem = new Memory(MAX_ADDRESS);
        
        dev = new Device[256];
        
    }
    
    public Register getReg(int i){
        if(i >= 0 && i < indexReg.length){
            return indexReg[i];
        }else 
            return null;
    }
    public void setReg(int i, int val){
        if(i >= 0 && i < indexReg.length){
            if(indexReg[i] != null){
                indexReg[i].setValue(val);
            }else{
                indexReg[i] = new Register(val);
            }
        }
    }

}
