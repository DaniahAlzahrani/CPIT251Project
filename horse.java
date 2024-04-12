/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2251;
import java.util.ArrayList;

/**
 *
 * @author Tony-
 */
public class horse {
    //atributes
    private String name ;
    private String type ;
    private String status;
    private ArrayList<String > horses = new ArrayList<String>();
    //methods
    public  horse (String Name , String Type , String Status ){
        this.name=Name;
        this.type=Type;
        this.status=Status;
    }
    public String  Add_horse(String Name , String Type , String Status){
        String a = (Name+" "+Type+" "+Status);
        String horse = a.toLowerCase() ; 
        horses.add(horse);
        return "added successfully";
    }
    public void Change_horse_status(String name , String type , String oldstatus  , String newstatus){
       
        for ( int i =0 ; i<horses.size() ; i++){
            if (horses.get(i).equalsIgnoreCase(name)){
                String change = horses.get(i).replace(oldstatus, newstatus);
                horses.set(i, change);
                break;
            }
        }
        System.out.println(horses);
    
    
    
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<String> getHorses() {
        return horses;
    }

    public void setHorses(ArrayList<String> horses) {
        this.horses = horses;
    }
    
}
