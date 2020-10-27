package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "TankDrive")
public class TankDrive extends OpMode {
    DcMotor left;
    DcMotor right;

    @Override
    public void init() {
        left = hardwareMap.dcMotor.get("left");
        right = hardwareMap.dcMotor.get("right");

    }

    //write comments and make functions + rename it tankdrive
    @Override
    public void loop() {
        if(gamepad1.dpad_up){
            left.setPower(-1);
            right.setPower(1);
        }
        else if(gamepad1.dpad_down){
            left.setPower(1);
            right.setPower(-1);
        }
        else if(gamepad1.dpad_left){
            left.setPower(1);
            right.setPower(1);
        }
        else if(gamepad1.dpad_right){
            left.setPower(-1);
            right.setPower(-1);
        }
        else{
            left.setPower(0);
            right.setPower(0);
        }




        //debug
        telemetry.addData("left encoder",left.getCurrentPosition());
        telemetry.addData("right encoder",right.getCurrentPosition());

    }
}