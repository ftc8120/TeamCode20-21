package org.firstinspires.ftc.teamcode.TeleOp.MechanumDrive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "MechDrive")
public class MechDrive extends OpMode {

    //Speed the robot will always go (unless set to slow)
    final double speed = .7;
    final double rspeed = -.7;

    //Boolean which tells whether we are set to go slow or fast
    boolean fast = true;

    //Set up the four motors on the robot for driving
    DcMotor frontRight, frontLeft, backRight, backLeft;

    //Set up the motor for impelling
    DcMotor impeller;

    //Servo fMover;


    //Methods to activate the four directions of movement
    public void FORWARD(){
        /*frontRight.setPower(fast?speed:speed/2);
        frontLeft.setPower(fast?rspeed:rspeed/2);
        backRight.setPower(fast?speed:speed/2);
        backLeft.setPower(fast?rspeed:rspeed/2);*/
        frontLeft.setPower(1);
        backLeft.setPower(1);
        frontRight.setPower(1);
        backRight.setPower(1);
    }

    public void BACKWARD(){
        frontRight.setPower(fast?-1*speed:-1*speed/2);
        frontLeft.setPower(fast?-1*rspeed:-1*rspeed/2);
        backRight.setPower(fast?-1*speed:-1*speed/2);
        backLeft.setPower(fast?-1*rspeed:-1*rspeed/2);
    }

    public void LEFT(){
        /*frontRight.setPower(fast?-1*speed:-1*speed/2);
        frontLeft.setPower(fast?-1*rspeed:-1*rspeed/2);
        backRight.setPower(fast?speed:speed/2);
        backLeft.setPower(fast?rspeed:rspeed/2);*/
        frontLeft.setPower(1);
        backLeft.setPower(-1);
        frontRight.setPower(-1);
        backRight.setPower(1);
    }

    public void RIGHT(){
        /*frontRight.setPower(fast?speed:speed/2);
        frontLeft.setPower(fast?rspeed:rspeed/2);
        backRight.setPower(fast?-1*speed:-1*speed/2);
        backLeft.setPower(fast?-1*rspeed:-1*rspeed/2);*/
        frontLeft.setPower(-1);
        backLeft.setPower(1);
        frontRight.setPower(1);
        backRight.setPower(-1);
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

/*
    public void FOUNDATIONDOWN(){
        fMover.setPosition(.5);
    }

    public void FOUNDATIONUP(){
        fMover.setPosition(.3);
    }
*/


    @Override
    public void init() {
        //initializes all the motors and servos on the chassis
       frontRight = hardwareMap.dcMotor.get("frontRight");
       frontLeft = hardwareMap.dcMotor.get("frontLeft");
       backRight = hardwareMap.dcMotor.get("backRight");
       backLeft = hardwareMap.dcMotor.get("backLeft");
       impeller = hardwareMap.dcMotor.get("impeller");
       //fMover = hardwareMap.servo.get("fMover");
    }

    @Override
    public void loop() {
        //Takes user input and calls function depending on what button pressed
        //Gamepad 1 controls the movement of the robot
        if (gamepad1.dpad_up) {
            if (gamepad1.dpad_up && gamepad1.left_trigger == 1) {
                fast = false;
                FORWARD();
            } else {
                fast = true;
                FORWARD();
            }
        } else if (gamepad1.dpad_down) {
            if (gamepad1.dpad_down && gamepad1.left_trigger == 1) {
                fast = false;
                BACKWARD();
            } else {
                fast = true;
                BACKWARD();
            }
        } else if (gamepad1.dpad_right) {
            if (gamepad1.dpad_right && gamepad1.left_trigger == 1) {
                fast = false;
                RIGHT();
            } else {
                fast = true;
                RIGHT();
            }
        } else if (gamepad1.dpad_left) {
            if (gamepad1.dpad_left && gamepad1.left_trigger == 1) {
                fast = false;
                LEFT();
            } else {
                fast = true;
                LEFT();
            }
        } else if (gamepad1.right_stick_x == 1) {
            if (gamepad1.right_stick_x == 1 && gamepad1.left_trigger == 1) {
                fast = false;
                TURN_RIGHT();
            } else {
                fast = true;
                TURN_RIGHT();
            }
        } else if (gamepad1.right_stick_x == -1) {
            if (gamepad1.right_stick_x == -1 && gamepad1.left_trigger == 1) {
                fast = false;
                TURN_LEFT();
            } else {
                fast = true;
                TURN_LEFT();
            }
        }
    }
        }

        //Gamepad 2 controls the various attachments
        /*
        if(gamepad2.right_trigger == 1){
            FOUNDATIONDOWN();
        }
        else if (gamepad2.right_bumper){
            FOUNDATIONUP();
        }
         */

