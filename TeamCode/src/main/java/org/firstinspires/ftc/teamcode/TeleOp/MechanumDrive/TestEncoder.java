package org.firstinspires.ftc.teamcode.TeleOp.MechanumDrive;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.RobotBrian;

@TeleOp(name = "TestEncoder")
public class TestEncoder extends OpMode {
    private DcMotor lift;
    private double speed;


    public void feedback(Telemetry telemetry){
        telemetry.addData("Encoder:", lift.getCurrentPosition());
    }

    @Override
    public void init() {
        lift = hardwareMap.dcMotor.get("lift");
        speed = 1;
        lift.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }

    @Override
    public void loop() {
        if(gamepad1.a){
            lift.setPower(speed);
        }
        else{
            lift.setPower(0);
        }
        feedback(telemetry);
    }
}
