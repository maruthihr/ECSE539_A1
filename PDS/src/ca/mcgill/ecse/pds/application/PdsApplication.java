package ca.mcgill.ecse.pds.application;


import java.awt.EventQueue;

import ca.mcgill.ecse.pds.model.PDS;
import ca.mcgill.ecse.pds.persistence.PersistenceObjectStream;
import ca.mcgill.ecse.pds.view.PDSPage1;
import ca.mcgill.ecse.pds.model.Menu;

public class PdsApplication {
	
	private static PDS pds;
	private static Menu pdsMenu;
	private static String filename = "data.pds";
	
	public static void main(String[] args) {
		// start UI
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new PDSPage1().frmPds.setVisible(true);
            }
        });
        
	}


	public static PDS getPds() {
		if (pds == null) {
			// load model
			pds = load();
		}
 		return pds;
	}
	
	public static void save() {
		PersistenceObjectStream.serialize(pds);
	}
	
	public static PDS load() {
		PersistenceObjectStream.setFilename(filename);
		pds = (PDS) PersistenceObjectStream.deserialize();
		// model cannot be loaded - create empty PDS
		if (pds == null) {
			pds = new PDS();
			
		}
		else {
			pds.reinitialize();
		}
		return pds;
	}
	
	public static void setFilename(String newFilename) {
		filename = newFilename;
	}
	
	public static Menu getPdsMenu() {
		if (pdsMenu == null) {
			// load menu
			pdsMenu = loadMenu();
		}
 		return pdsMenu;
	}
	
	public static Menu loadMenu() {
		PersistenceObjectStream.setFilename(filename);
		pdsMenu = (Menu) PersistenceObjectStream.deserialize();
		// model cannot be loaded - create empty PDS
		if (pdsMenu == null) {
			PDS pds1 = getPds();
			pdsMenu = new Menu(pds1);
			
		}
		else {
			pdsMenu.reinitialize();
		}
		return pdsMenu;
	}
	

}
