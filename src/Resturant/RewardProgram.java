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
public class RewardProgram implements Serializable {

    protected String Cobon;
    protected String cobonDescription;

    FileManager FManager = new FileManager();
    private final String rewardFile = "Rewards.bin";

    public RewardProgram(String Cobon, String cobonDescription ) {
        this.Cobon = Cobon;
        this.cobonDescription = cobonDescription;
    }

    public RewardProgram() {
    }
    

    public String getCobon() {
        return Cobon;
    }

    public void setCobon(String Cobon) {
        this.Cobon = Cobon;
    }

    public String getCobonDescription() {
        return cobonDescription;
    }

    public void setCobonDescription(String cobonDescription) {
        this.cobonDescription = cobonDescription;
    }

    
    
    public boolean addReward(RewardProgram r) {
        loadFromFile();
        
        return commitToFile(r);
    }

    public boolean commitToFile(RewardProgram x) {
        return FManager.write(rewardFile, x);
    } 
    
    
    public RewardProgram loadFromFile() {
         return (RewardProgram) FManager.read(rewardFile);
    }

    

  
   
    
    
    public boolean deleteReward() {
        loadFromFile();
        RewardProgram j = new RewardProgram();
        j.commitToFile(j);
        return true;
    }

    @Override
    public String toString() {
        return  "\nCobon = " + Cobon + "\nCobon Description = " + cobonDescription ;
    }
    
    
    

}
