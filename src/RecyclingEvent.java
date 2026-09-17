import java.time.LocalDate;

public class RecyclingEvent{

  String materialtype;
  double weight ; //in kg
  LocalDate dateofrecycling ;
  double pointsearned=0;
  
  
  RecyclingEvent(String materialtype,double weight,LocalDate dateofrecycling,double pointsearned){
    this.materialtype = materialtype;
    this.weight = weight;
    this.dateofrecycling = dateofrecycling;
    this.pointsearned += pointsearned;
  }
  


public String getMaterialtype() {
    return materialtype;
}

public double getWeight() {
    return weight;
}

public LocalDate getDateofrecycling() {
    return dateofrecycling;
}

public double getPointsearned() {
    return pointsearned;
}


}