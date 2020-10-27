package org.firstinspires.ftc.teamcode.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.RobotBrian;


@Autonomous(name = "MoveLeft")
public class MoveLeft extends OpMode {


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
            case 0:
                //reset timer
                timer.reset();
                state++;
                break;
            case 1:
                if(timer.seconds()>=5){
                    state++;
                }
                break;
            case 2:
                robot.forward(speed);
                if (timer.seconds()>=5.5){
                    state++;
                }
                break;
            default:
                robot.stop();
        }
    }
}
