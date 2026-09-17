import java.time.LocalDateTime;
import java.util.ArrayList;

public class Household{

    private int id;
    private String name;
    private String address;
    private LocalDateTime joiningdate;

 private double totalWeightRecycled =0;
    ArrayList<RecyclingEvent> recyclingevents = new ArrayList<>();

    Household(int id,String name,String address,LocalDateTime joiningdate){
        this.address =address;
        this.id=id;
        this.name=name;
        this.joiningdate=joiningdate;
    }



    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public LocalDateTime getJoiningDate() {
        return this.joiningdate;
    }

    public double calulateTotalWeight(){

        for (RecyclingEvent recyclingEvent : recyclingevents) {
           totalWeightRecycled+=recyclingEvent.weight;
        }

        return totalWeightRecycled;
    }
    
    }