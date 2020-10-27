package org.firstinspires.ftc.teamcode;
import com.qualcomm.hardware.lynx.LynxI2cColorRangeSensor;
import com.qualcomm.robotcore.hardware.I2cDeviceSynchSimple;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

/**
 * Wrapper class for the LynxI2cColorRangeSensor
 */
public class ColorRangeSensor {

    public ColorRangeSensor(LynxI2cColorRangeSensor sense) {
        sensor = sense;
        sensor.enableLed(true);
    }

    /**
     * The sensor itself
     */
    private LynxI2cColorRangeSensor sensor;

    // Base values for calibration
    private int baseRed = 0;
    private int baseBlue = 0;
    private int baseGreen = 0;
    private double baseDist = 0;


    /**
     * Reset all the base values
     */
    public void reset() {
        baseRed = 0;
        baseBlue = 0;
        baseGreen = 0;
    }

    /**
     * Calibrate the sensor to ambient light
     */
    public void calibrate() {
        baseRed = sensor.red();
        baseBlue = sensor.blue();
        baseGreen = sensor.green();

    }

    public void led(){
        sensor.enableLed(true);
    }



    public synchronized int red() {
        return sensor.red();
    }

    /**
     * Alias for the green() function on wrapped sensor
     * @return the calibrated green value
     */
    public synchronized int green() {
        return sensor.green();
    }

    public synchronized int blue() {
        return sensor.blue();
    }

    /**
     * Alias for the getDistance(DistanceUnit unit) function on wrapped sensor
     * @return the distance value
     */
    public double getDistance(DistanceUnit unit) {
        return sensor.getDistance(unit);
    }

    /**
     * Determines if the red jewel is detected
     * @return if it is red

    public boolean isRed() {
        return this.red() > this.blue();
    }
*/
    public boolean isBlack() {
        return (sensor.red()< 20);
    }

    /**
     * Provides telemetry data for the sensor
     */
    public void feedback(Telemetry telemetry) {
        // Print out the color sensor RGB values
        telemetry.addData("Right R", sensor.red());
        telemetry.addData("Right G", sensor.green());
        telemetry.addData("Right B", sensor.blue());
        // Print out the distance from the right sensor in CM
        //telemetry.addData("Right Distance (cm)", this.getDistance(DistanceUnit.CM));
    }

}