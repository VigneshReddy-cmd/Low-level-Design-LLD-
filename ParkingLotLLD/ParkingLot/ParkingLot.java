package ParkingLotLLD.ParkingLot;
import java.util.List;

import ParkingLotLLD.ParkingLot.Gates.Entrance;
import ParkingLotLLD.ParkingLot.Gates.Exit;
import ParkingLotLLD.Vechile.Vechile;
import ParkingLotLLD.ParkingLot.Floors.ParkingFloor;;

public abstract class ParkingLot {
    List<ParkingFloor> floors;
    List<Entrance> entry;
    List<Exit> exit;
    Adress adress;
    String name;
    public void is_Space_Avaliable(Vechile vechile){}
}
