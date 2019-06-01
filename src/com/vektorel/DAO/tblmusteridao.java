/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.DAO;

import com.vektorel.Models.tblmusteri;
import com.vektorel.Util.ICRUD;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vektorel
 */
public class tblmusteridao implements ICRUD{

    List<tblmusteri> myList = new ArrayList<>();
    
    @Override
    public void kaydet(Object o) {
        myList.add((tblmusteri)o);
    }

    @Override
    public void duzenle(Object o) {
        tblmusteri tmp = (tblmusteri)o;
        for(tblmusteri item : myList){
            if(item.getId()==tmp.getId()){
            item = tmp;
            }
        }
    }

    @Override
    public void sil(int id) {
        myList.remove(id);
    }

   
    public List<tblmusteri> listele() {
        return myList;
    }

    
    public List<Object> ara(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public Object bul(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}