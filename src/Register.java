/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jan
 */
public class Register {

    Class<?> mType ; 
    int mIValue;
    double mFValue;

    public Register() {
        mIValue = 0;
        mFValue = 0.f;
        mType = null;
    }

    public Register(Object o) {
        setValue(o);
    }

   public void setValue(Object o) throws IllegalStateException {
       if(o.getClass().equals(Integer.class)){
           mIValue = (int)o;
       }else if(o.getClass().equals(double.class)){
           mFValue = (double)o;
       }else{
           throw new IllegalStateException();
       }
       mType = o.getClass();
    }
   
   public Number getValue() throws IllegalStateException {
       if(mType.equals(Integer.class)){
           return mIValue;
       }else if(mType.equals(Double.class)){
           return mFValue;
       }else{
           throw new IllegalStateException();
       }
   }
}
