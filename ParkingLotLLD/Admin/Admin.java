package ParkingLotLLD.Admin;


import ParkingLotLLD.Account.Account;
import ParkingLotLLD.ParkingLot.ParkingLot;
import ParkingLotLLD.ParkingLot.DisplayBoard.ParkingDisplayBoard;
import ParkingLotLLD.ParkingLot.Floors.ParkingFloor;
import ParkingLotLLD.ParkingLot.Floors.ParkingSpaceType;

public  class Admin extends Account{
   public static boolean addParkingFloor(ParkingLot parkingLot,ParkingFloor parkingFloor){
      return false;
   }   
   public static boolean addParkingSpace(ParkingFloor parkingFloor,ParkingSpaceType parkingSpaceType){
      return false;
   }
   public static boolean addParkingDisplayBoard(ParkingFloor parkingFloor,ParkingDisplayBoard parkingDisplayBoard){
      return false;
   }
   
  
}
