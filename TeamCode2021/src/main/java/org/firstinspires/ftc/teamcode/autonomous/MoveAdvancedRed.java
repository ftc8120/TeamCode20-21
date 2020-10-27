package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RobotBrian;

@Autonomous(name = "MoveAdvancedRed")
public class MoveAdvancedRed extends OpMode {


    ElapsedTime timer;
    private RobotBrian robot;
    private double speed;
    private int state;

    @Override
    public void init() {
        //initializes timer, starting the autonomous
        timer = new ElapsedTime();
        robot = new RobotBrian();
        robot.init(hardwareMap);
        speed = .5;
        state = 0;
    }

    @Override
    public void loop() {

        switch (state) {
            case -1:
                timer.reset();
                //delay the start of the program
                if(timer.seconds() >= 10) {
                    state++;
                }
                break;
            case 0:
                //reset timer
                timer.reset();
                state++;
                break;
            case 1:
                //go forward and impell
                robot.forward(speed*.9);
                robot.impell(speed);
                if (timer.seconds() >= 1) {
                    state++;
                }
                break;
            case 2:
                //stop robot
                robot.stop();
                state++;
                break;
            case 3:
                //sit still and impell
                robot.forward(speed*.5);
                if (timer.seconds() >= 2) {
                    state++;
                }
                break;
            case 4:
                //stop impelling and move backwards half the distance
                //robot.stoppell();
                state++;
                break;
            case 5:
                robot.backward(speed);
                if (timer.seconds() >= 3.5) {
                    state++;
                }
                break;
            case 6:
                //move left across to other side of bars
                robot.right(speed*.7);
                if (timer.seconds() >= 6.5) {
                    state++;
                }
                break;
            case 7:
                robot.stop();
                robot.expell(speed);
                robot.backward(speed);
                //expell
                if (timer.seconds() >= 11) {
                    state++;
                }
                break;
            case 8:
                robot.left(speed);
                if (timer.seconds() >= 12) {
                    state++;
                }
                break;
            default:
                robot.stop();
                robot.stoppell();
                break;
        }
    }
}