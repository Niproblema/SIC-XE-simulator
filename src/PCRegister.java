/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jan
 */
public class PCRegister extends Register {

    public PCRegister() {
        super(0);
    }

    public PCRegister(int n) {
        super(n);
    }
    
    public void increment(){
        setValue(getValue().intValue()+1);
    }
    public void increment(int k){
        setValue(getValue().intValue()+k);
    }
    

    //PCRegister specific methods
}
