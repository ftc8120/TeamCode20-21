package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "Test")
public class Teaching extends OpMode {

    DcMotor a;
    DcMotor b;
    DcMotor c;
    DcMotor d;

    //initializing hardware elements
    @Override
    public void init() {
        a = hardwareMap.dcMotor.get("back_left");
        b = hardwareMap.dcMotor.get("front_left");
        c = hardwareMap.dcMotor.get("back_right");
        d = hardwareMap.dcMotor.get("front_right");
    }

    //what runs
    @Override
    public void loop() {
        final double s = .5;
        if(gamepad1.dpad_down){
            a.setPower(-s);
            b.setPower(-s);
            c.setPower(-s);
            d.setPower(-s);
        }
        else if(gamepad1.dpad_up){
            a.setPower(s);
            b.setPower(s);
            c.setPower(s);
            d.setPower(s);
        }
        else if(gamepad1.dpad_right){
            a.setPower(-s);
            b.setPower(s);
            c.setPower(-s);
            d.setPower(s);
        }
        else if(gamepad1.dpad_left){
            a.setPower(s);
            b.setPower(-s);
            c.setPower(s);
            d.setPower(-s);
        }
        else if(gamepad1.a){
            a.setPower(-s);
            b.setPower(-s);
            c.setPower(s);
            d.setPower(s);
        }
        else if(gamepad1.b){
            a.setPower(s);
            b.setPower(s);
            c.setPower(-s);
            d.setPower(-s);
        }
        else{
            a.setPower(0);
            b.setPower(0);
            c.setPower(0);
            d.setPower(0);
        }
    }
}
