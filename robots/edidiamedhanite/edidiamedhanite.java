package edidiamedhanite;
import robocode.Robot;
import robocode.ScannedRobotEvent;
import robocode.WinEvent;
import robocode.HitWallEvent;
import robocode.HitByBulletEvent;
import robocode.HitRobotEvent;


import java.awt.*;

public class edidiamedhanite extends Robot {
    
    public void run(){
        setBodyColor(Color.blue);
        setGunColor(Color.green);
        setRadarColor(Color.red);


        while(true){
            turnLeft(85);
            ahead(150);
            turnGunLeft(360);
            back(100);
            //turnRadarRight(180);
            turnRight(500);
            ahead(100);
        }
    }   
    public void onScannedRobot(ScannedRobotEvent e){
        //gets distance of the scanned robot
        double distance = e.getDistance();
        double energy = e.getEnergy();
        

        if(distance >= 800 && distance <= 100){
            turnRadarLeft(360);
            fire(3);
            
        }
        else if(distance > 700 && distance <= 800){
            fire(2);
            ahead(100);
        }
        else if(distance > 300 && distance <= 700){
            fire(2.5);
            ahead(50);
        }
        else if(distance > 100 && distance <=300){
            fire(2.7);
            
        }
        else if(distance < 100 && energy > 30 ){
            fire(3);
        }
        else {
            fire(2);
        }
    }
    public void onHitWall(HitWallEvent e) {
        
        System.out.println("Wall Hit: " + e.getBearing());

        if(e.getBearing() >= -90 && e.getBearing() <= 90){
            back(100);
        }
        else{
            ahead(100);
        }
    }
    public void onHitByBullet(HitByBulletEvent e){
        turnRight(70 - e.getBearing());
        ahead(70);
       
    }
    public void onHitRobot(HitRobotEvent e){
        turnLeft(90);
        turnRadarRight(90);
        turnGunLeft(90);
    }
    public void onWin(WinEvent e){
        turnRadarLeft(170);
        turnRadarRight(190);
        turnRadarLeft(170);
        turnRadarRight(190);
        turnRadarLeft(170);
        turnRadarRight(190);
    }
}
