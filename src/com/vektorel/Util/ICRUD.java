/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vektorel.Util;

import java.util.List;

/**
 *
 * @author vektorel
 */
public interface ICRUD {
    
    public void kaydet(Object o);
    public void duzenle(Object o);
    public void sil(int id);
   // public List<Object> listele();
   // public List<Object> ara(Object o);
   // public Object bul(int id);
}
