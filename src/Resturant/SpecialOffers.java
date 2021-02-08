/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Resturant;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author meshm
 */
public class SpecialOffers implements Serializable{
    
        protected int OfferId;
        protected String OfferName ;
        protected String OfferDescription ;
        
        FileManager FManager = new FileManager();
        private final String spceialOffersFileName = "SpecialOffers.bin";
        public static ArrayList<SpecialOffers> Offers = new ArrayList<SpecialOffers>();

    public SpecialOffers() {
    }

    public SpecialOffers(int OfferId, String OfferName, String OfferDescription) {
        this.OfferId = OfferId;
        this.OfferName = OfferName;
        this.OfferDescription = OfferDescription;
    }
    
    

    public int getOfferId() {
        return OfferId;
    }

    public void setOfferId(int OfferId) {
        this.OfferId = OfferId;
    }

    public String getOfferName() {
        return OfferName;
    }

    public void setOfferName(String OfferName) {
        this.OfferName = OfferName;
    }

    public String getOfferDescription() {
        return OfferDescription;
    }

    public void setOfferDescription(String OfferDescription) {
        this.OfferDescription = OfferDescription;
    }

    
    
    
    public boolean addOffers() {
        loadFromFile();
        Offers.add(this);
        return commitToFile();
    }

    public boolean commitToFile() {
        return FManager.write(spceialOffersFileName, Offers);
    } 
    
    
    public void loadFromFile() {
        Offers = (ArrayList<SpecialOffers>) FManager.read(spceialOffersFileName);
    }

    private int getOfferIndex(int id) {
        for (int i = 0; i < Offers.size(); i++) {
            if (Offers.get(i).getOfferId() == id) {
                return i;
            }
        }

        return -1;
    }

    public String displayAllOffers() {
        loadFromFile();
        String S = "\nAll Offers Data:\n";
        for (SpecialOffers x : Offers) {
            S = S + x.toString();
        }
        return S;
    }

    public String searchOffers(int id) {
        loadFromFile();
        int index = getOfferIndex(id);
        if (index != -1) {
            return "\nFound ...!" + Offers.get(index).toString();
        } else {
            return "\nNot Found ...!";
        }
    }
    
    
    public boolean deleteOffer(int id) {
        loadFromFile();
        int index = getOfferIndex(id);

        if (index != -1) {
            Offers.remove(index);

            return commitToFile();
        }

        return false;
    }
    
    
    
    
    public boolean updateOffer(int oldID, SpecialOffers x) {
        loadFromFile();
        int index = getOfferIndex(oldID);

        if (index != -1) {
            
            Offers.set(index, x);
            return commitToFile();
        }

        return false;
    }

    @Override
    public String toString() {
        return   "\nOfferId = " + OfferId + "\nOfferName = " + OfferName + "\nOfferDescription = " + OfferDescription ;
    }
        
    
    
        

    
}
