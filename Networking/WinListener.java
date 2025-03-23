/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dgram_client;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

/*
 * @author njpar
 */
public class WinListener extends WindowAdapter{
    public void windowClosing(WindowEvent e){        
        //ds.close();
        System.exit(0);
    }//wC
}//class
