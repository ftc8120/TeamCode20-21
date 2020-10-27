package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import org.firstinspires.ftc.teamcode.ColorRangeSensor;

public class RobotBrian {
    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backLeft;
    private DcMotor backRight;
    private DcMotor impell;
    private Servo blocker;
    public ColorRangeSensor rightColor;
    public ColorRangeSensor leftColor;
    // smart servos:
    public Servo foundationMoverRight;
    private Servo foundationMoverLeft;
    //private Servo grabber;

    public void init(HardwareMap map) {
        // Initialize & configure drive motors
        frontLeft = map.dcMotor.get("front_left");
        frontRight = map.dcMotor.get("front_right");
        backLeft = map.dcMotor.get("back_left");
        backRight = map.dcMotor.get("back_right");
        backLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeft.setDirection(DcMotorSimple.Direction.REVERSE);
        impell = map.dcMotor.get("impeller");
        blocker = map.servo.get("blocker");
        foundationMoverRight = map.servo.get("foundation");
        //foundationMoverLeft = map.servo.get("foundation_left");
        //grabber = map.servo.get("grabber");

        LynxI2cColorRangeSensor rightRange = map.get(LynxI2cColorRangeSensor.class, "rightRange");
        rightColor = new ColorRangeSensor(rightRange);
        rightColor.calibrate();

        LynxI2cColorRangeSensor leftRange = map.get(LynxI2cColorRangeSensor.class, "leftRange");
        leftColor = new ColorRangeSensor(leftRange);
        leftColor.calibrate();

        stop();
        setEncoders(false);
    }

    /**
     * Stop the robot
     */

    public void stop() {
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backRight.setPower(0);
        backLeft.setPower(0);
    }

    /**
     * Enable/disable encoders
     * @param enabled
     */
    public void setEncoders(boolean enabled) {
        if(enabled)
        {
            frontRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        }
        else
        {
            frontRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            frontLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            backLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        }
    }


    /**
     *
     * @param fL
     * @param fR
     * @param bL
     * @param bR
     * @param speed
     */
    public void drive(double fL, double fR, double bL,double bR, double speed) {
        frontLeft.setPower(fL*speed);
        frontRight.setPower(fR*speed);
        backLeft.setPower(bL*speed*-1);
        backRight.setPower(bR*speed*-1);
    }

    /**
     *
     * @param speed
     */
    public void impell( double speed) {
        impell.setPower(speed * -1);
    }

    public void expell( double speed){
        impell.setPower(speed* 1);
    }

    public void stoppell(){
        impell.setPower(0);
    }

    public void forward(double speed){
        drive(1, 1, 1, 1, speed);
    }

    public void backward(double speed){
        drive(-1,-1,-1,  -1,speed);
    }

    public void left(double speed){
        drive(-1, 1, .9, -.9, speed);
    }

    public void right(double speed){
       drive(1, -1, -.9, .9, speed);
    }

    public void spinleft(){
        drive(-1, 1, -1, 1, 1);
    }

    public void spinright(){
        drive(1, -1, 1, -1, 1);
    }

    /*
    //servos programmed 0 to 1
    public void leftmoverUp(){
       foundationMoverLeft.setPower(.05);
    }

    public void leftmoverDown(){
        foundationMoverLeft.setPower(-.05);
    }


    public void leftmoverstop(){
        foundationMoverLeft.setPower(0);
    }

    public void rightmoverUp(){
        foundationMoverRight.setPosition(.05);
    }

    public void rightmoverDown(){
        foundationMoverRight.setPower(-.05);
    }

    public void rightmoverstop(){
        foundationMoverRight.setPower(0);
    }*/

    public void moverUp(){
        //foundationMoverLeft.setPosition(0);
        foundationMoverRight.setPosition(.9);
    }

    public void moverDown(){
        //foundationMoverLeft.setPosition(1);
        foundationMoverRight.setPosition(0);
    }

    public void block(){
        blocker.setPosition(.6);
    }

    public void unblock(){
        blocker.setPosition(0);
    }

    public void grab(){
        //grabber.setPosition(0);
    }

    public void release(){
        //grabber.setPosition(1);
    }

    public boolean rightIsBlack(){
        return rightColor.isBlack();
    }

    public boolean leftIsBlack(){
        return leftColor.isBlack();
    }

}
