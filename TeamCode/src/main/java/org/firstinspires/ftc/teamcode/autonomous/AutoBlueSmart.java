package org.firstinspires.ftc.teamcode.autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RobotBrian;

@Autonomous(name = "SingleSkystoneBlue")
public class AutoBlueSmart extends OpMode {

    ElapsedTime timer;
    private RobotBrian robot;
    private double speed;
    private int state;
    private int numMove;

    @Override
    public void init() {
        //initializes timer, starting the autonomous
        timer = new ElapsedTime();
        robot = new RobotBrian();
        robot.init(hardwareMap);
        speed = .4;
        state = 0;
        numMove = 0;
    }

    @Override
    public void loop() {
        switch(state){
            case 0:
                timer.reset();
                state+=2;
                break;
            case 2:
                robot.forward(speed);
                if(timer.seconds()>.8){
                    state++;
                }
                break;
            case 3:
                robot.stop();
                if(timer.seconds()>1.3){
                    state++;
                }
                break;
            case 4:
                if(robot.leftIsBlack()){
                    state+=3;
                }
                else {
                    numMove++;
                    state++;
                }
                timer.reset();
                break;
            case 5:
                robot.left(speed);
                if(timer.seconds()>.3){
                    state++;
                }
                break;
            case 6:
                robot.stop();
                if(numMove == 8){
                    state++;
                    timer.reset();
                }
                else if (timer.seconds()>.8)
                    state-=2;
                break;
            case 7:
                robot.right(speed);
                if(timer.seconds()>.2){
                    state++;
                }
                break;
            case 8:
                timer.reset();
                state++;
                break;
            case 9:
                //go forward and impell
                robot.forward(speed*.9);
                robot.impell(.5);
                if (timer.seconds() >= .5) {
                    state++;
                }
                break;
            case 10:
                //stop robot
                robot.stop();
                state++;
                break;
            case 11:
                //sit still and impell
                robot.forward(speed*.5);
                if (timer.seconds() >= 2) {
                    state++;
                }
                break;
            case 12:
                //stop impelling and move backwards half the distance
                //robot.stoppell();
                robot.backward(speed);
                if(timer.seconds() >=3) {
                    state++;
                }
                break;
            case 13:
                //move right across to other side of bars
                robot.right(speed);
                if (timer.seconds() >= 6.4+(.1*numMove)) {
                    state+=2;
                }
                break;
            case 14:
                //robot.forward(speed);
                //if(timer.seconds() >= 9.5){
                state++;
                //}
                break;
            case 15:
                robot.stop();
                robot.expell(.5);
                //robot.backward(speed);
                //expell
                if (timer.seconds() >= 11) {
                    state++;
                }
                break;
            case 16:
                robot.left(speed);
                if (timer.seconds() >= 13) {
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