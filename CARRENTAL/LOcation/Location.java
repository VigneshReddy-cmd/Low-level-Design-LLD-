package CARRENTAL.LOcation;

public class Location {
    private  String name;
    private  String ZIP_CODE;
   private Longitude longitude;
   private Lattitude lattitude;
    public Location(String name,String ZIP_CODE,String string,String string2){
        this.name=name;
        this.ZIP_CODE=ZIP_CODE;
       Lattitude lt=new Lattitude(string2);
       this.lattitude=lt;
       Longitude lot=new Longitude(string);
       this.longitude=lot;
    }
    public String getName(){
        return name;
    }
    public String getZip(){
        return ZIP_CODE;
    }
    public Lattitude gLattitude(){
        return lattitude;
    }
    public Longitude gLongitude(){
        return longitude;
    }

}
