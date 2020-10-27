package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

@Autonomous(name = "MechAuto")
public class MechAutoTest extends OpMode {

    //Speed the robot will always go (unless set to slow)
    final double speed = .7;
    final double rspeed = -.7;

    //Boolean which tells whether we are set to go slow or fast
    boolean fast = true;

    //Set up timer for autonomous to tell time with
    ElapsedTime timer;

    //Set up the four motors on the robot for driving
    DcMotor frontRight, frontLeft, backRight, backLeft;

    //Set up combined motors for impeller
    DcMotor impeller;

    //Methods to activate the four directions of movement
    public void FORWARD(){
        frontRight.setPower(fast?speed:speed/2);
        frontLeft.setPower(fast?rspeed:rspeed/2);
        backRight.setPower(fast?speed:speed/2);
        backLeft.setPower(fast?rspeed:rspeed/2);
    }

    public void BACKWARD(){
        frontRight.setPower(fast?-1*speed:-1*speed/2);
        frontLeft.setPower(fast?-1*rspeed:-1*rspeed/2);
        backRight.setPower(fast?-1*speed:-1*speed/2);
        backLeft.setPower(fast?-1*rspeed:-1*rspeed/2);
    }

    public void LEFT(){
        frontRight.setPower(fast?-1*speed:-1*speed/2);
        frontLeft.setPower(fast?-1*rspeed:-1*rspeed/2);
        backRight.setPower(fast?speed:speed/2);
        backLeft.setPower(fast?rspeed:rspeed/2);
    }

    public void RIGHT(){
        frontRight.setPower(fast?speed:speed/2);
        frontLeft.setPower(fast?rspeed:rspeed/2);
        backRight.setPower(fast?-1*speed:-1*speed/2);
        backLeft.setPower(fast?-1*rspeed:-1*rspeed/2);
    }

    public void TURN_LEFT(){
        frontRight.setPower(fast?-1*speed:-1*speed/2);
        frontLeft.setPower(fast?rspeed:rspeed/2);
        backRight.setPower(fast?-1*speed:-1*speed/2);
        backLeft.setPower(fast?rspeed:rspeed/2);
    }

    public void TURN_RIGHT(){
        frontRight.setPower(fast?speed:speed/2);
        frontLeft.setPower(fast?-1*rspeed:-1*rspeed/2);
        backRight.setPower(fast?speed:speed/2);
        backLeft.setPower(fast?-1*rspeed:-1*rspeed/2);
    }

    public void STOP(){
        frontRight.setPower(0);
        frontLeft.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }

    public void IMPELL(){
        impeller.setPower(-.5);
    }

    public void EXPELL(){
        impeller.setPower(
                .5);
    }

    public void STOP_IMPELLER(){
        impeller.setPower(0);
    }

    @Override
    public void init() {
        //initializes all the motors and servos on the chassis
        frontRight = hardwareMap.dcMotor.get("frontRight");
        frontLeft = hardwareMap.dcMotor.get("frontLeft");
        backRight = hardwareMap.dcMotor.get("backRight");
        backLeft = hardwareMap.dcMotor.get("backLeft");
        impeller = hardwareMap.dcMotor.get("impeller");

        //initializes timer, starting the autonomous
        timer = new ElapsedTime();
    }

    @Override
    public void loop() {
        if(timer.seconds() <= 2){
            FORWARD();
            IMPELL();
        }
        else if(timer.seconds() <=4){
            STOP_IMPELLER();
            BACKWARD();
        }
        else if(timer.seconds() <= 7){
            RIGHT();
        }
        else if(timer.seconds() <= 9){
            STOP();
            EXPELL();
        }
        else if(timer.seconds() <=11){
            STOP_IMPELLER();
            FORWARD();
        }
        else{
            STOP();
        }
    }
}
