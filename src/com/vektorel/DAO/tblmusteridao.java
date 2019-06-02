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
        
        for (int i = 0; i < myList.size(); i++) {
            if(myList.get(i).getId() == tmp.getId())
            {
                myList.get(i).setAd(tmp.getAd());
                myList.get(i).setAdres(tmp.getAdres());
                myList.get(i).setSoyad(tmp.getSoyad());
                myList.get(i).setImageurl(tmp.getImageurl());
                myList.get(i).setTelefon(tmp.getTelefon());
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

    
    public List<tblmusteri> adara(String ad) {
       List<tblmusteri> tmplist = new ArrayList<>();
       String aranandeger = ad;
        for(tblmusteri item : myList){
            if(item.getAd().contains(aranandeger))
                tmplist.add(item);
        }
        return tmplist;
    }

    public List<tblmusteri> soyadara(String soyad) {
       List<tblmusteri> tmplist = new ArrayList<>();
       String aranandeger = soyad;
        for(tblmusteri item : myList){
            if(item.getSoyad().contains(aranandeger))
                tmplist.add(item);
        }
        return tmplist;
    }
   
    
    public List<tblmusteri> listem(String ad){
       List<tblmusteri> tmplist = new ArrayList<>();
       for(tblmusteri item : myList){
           if(item.getAd().contains(ad))
               tmplist.add(item);                      
                       
       }
       return tmplist;
    }
    
    
   
    
    
    public Object bul(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
   
}
