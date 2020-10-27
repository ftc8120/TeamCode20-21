package org.firstinspires.ftc.teamcode.autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.RobotBrian;





    @Autonomous(name = "FoundationMoverRed")
    public class FoundationRed extends OpMode {


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
                    robot.moverUp();
                    state++;
                    break;
                case 1:
                    //move right to aline robot with foundation
                    robot.right(speed*.9);
                    if (timer.seconds() >= 1) {
                        state++;
                    }
                    break;
                case 2:
                    //backward toward foundation
                    robot.backward(speed*.9);
                    if (timer.seconds() >= 2.5) {
                        state++;
                    }
                    break;
                case 3:
                    //stop robot
                    robot.stop();
                    state++;
                    break;
                case 4:
                    //move foundation mover down
                    robot.moverDown();
                    if (timer.seconds() >= 3.5){
                        state++;
                    }
                    break;
                case 5:
                    robot.forward(speed*.9);
                    if (timer.seconds() >= 5){
                        robot.stop();
                        state++;
                    }
                    break;
                case 6:
                    //robot.left(speed*.9);
                    if (timer.seconds() >= 5.5){
                        state++;
                    }
                    break;
                case 7:
                    //robot spin right to move foundation
                    robot.spinleft();
                    if (timer.seconds() >= 6){
                        state++;
                    }
                    break;
                case 8:
                    //stop robot
                    robot.stop();
                    state++;
                break;
                case 9:
                    //robot.right(speed*9);
                    if(timer.seconds()>=8){
                        state++;
                    }
                    break;
                case 10:
                    robot.stop();
                    timer.reset();
                    state++;
                    break;
                case 11:
                    //push foundation against wall
                    robot.backward(speed*.9);
                    if (timer.seconds() >= 1) {
                        state++;
                    }
                    break;
                case 12:
                    //move right
                    robot.right(speed*.9);
                    if (timer.seconds() >= 3) {
                        state++;
                    }
                case 13:
                    //stop robot
                    robot.stop();
                    state++;
                break;
                case 14:
                    //move foundation mover up
                    robot.moverUp();
                    if (timer.seconds() >= 4){
                        state++;
                    }
                    break;
                case 15:
                    //move forward to park robot against bridge side
                    robot.forward(speed*.9);
                    if (timer.seconds() >= 5.5){
                        state++;
                    }
                    break;
                case 16:
                    //stop robot
                    robot.stop();
                    state++;
                    break;
            }
        }
    }


