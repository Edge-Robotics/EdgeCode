//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Stanley H., Avaninder B.
package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.AutoMechanum;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.Claw;


@Autonomous(name = "Left", group = "AutoOp")

public class Left extends LinearOpMode {
    DcMotorEx frontLeft;
    DcMotorEx backLeft;
    DcMotorEx backRight;
    DcMotorEx frontRight;
    ColorSensor colorSensor;
    double bottomPosition = 0;
    double slightPosition = 55;
    double midPosition = 2020;
    double topPosition = 2780;
    boolean red = false;
    boolean green = false;
    boolean blue = false;
    boolean prevRed = false;
    boolean prevGreen = false;
    boolean prevBlue = false;
    boolean reset = false;
    private Servo leftServo = null;
    private Servo rightServo = null;
    private final Claw mainClaw = new Claw();
    private final AutoMechanum mainAutoMechanum = new AutoMechanum();
    private final Elevator mainElevator = new Elevator();
    private DcMotorEx elevator = null;
    private final ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {
        elevator = hardwareMap.get(DcMotorEx.class, "elevator");
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");

        mainClaw.init(hardwareMap);
        mainElevator.init(hardwareMap);
        mainAutoMechanum.init(hardwareMap);

        colorSensor = hardwareMap.get(ColorSensor.class, "ColorSensor");

        mainElevator.setTargetPosition(bottomPosition);
        waitForStart();

        red = false;
        green = false;
        blue = false;
        prevRed = false;
        prevGreen = false;
        prevBlue = false;

        mainAutoMechanum.strafeLeft(.3);
        timer.reset();
        while (timer.seconds()<2){
            telemetry.addData("frontRightPos", mainAutoMechanum.frontRight.getCurrentPosition());
            telemetry.update();
        }
        mainAutoMechanum.brake();

        while (timer.seconds() < 2) {
            telemetry.addData("Red", colorSensor.red());
            telemetry.addData("Green", colorSensor.green());
            telemetry.addData("Blue", colorSensor.blue());
            if (colorSensor.red() > colorSensor.blue()  && colorSensor.red() > colorSensor.green()) {
                red = true;
                green = false;
                blue = false;
                if (!prevRed){
                    timer.reset();
                }
            } else if (colorSensor.green() > colorSensor.red() && colorSensor.green() > colorSensor.blue()) {
                green = true;
                red = false;
                blue = false;
                if (!prevGreen){
                    timer.reset();
                }
            } else if (colorSensor.blue() > colorSensor.green() && colorSensor.blue() > colorSensor.red()) {
                blue = true;
                red = false;
                green = false;
                if (!prevBlue){
                    timer.reset();
                }
            }
            else{
                timer.reset();
            }

            if (red) {
                telemetry.addData("Current Color Detected", "Red");
                prevRed = true;
                prevBlue = false;
                prevGreen = false;
            } else if (green) {
                telemetry.addData("Current Color Detected", "Green");
                prevGreen = true;
                prevRed = false;
                prevBlue = false;
            } else if (blue) {
                telemetry.addData("Current Color Detected", "Blue");
                prevBlue = true;
                prevRed = false;
                prevGreen = false;
            } else {
                telemetry.addData("Current Color Detected", "Unknown");
                prevRed = false;
                prevGreen = false;
                prevBlue = false;
            }

            red = false;
            green = false;
            blue = false;
        }

        if (red) {
            telemetry.addData("Final Color Detected", "Red");
        } else if (green) {
            telemetry.addData("Final Color Detected", "Green");
        } else if (blue) {
            telemetry.addData("Final Color Detected", "Blue");
        } else {
            telemetry.addData("Final Color Detected", "Unknown");
            //if it detects unknown for more that 3 seconds, have it park in substation
        }

        mainAutoMechanum.strafeLeft(.3);
        timer.reset();
        while (timer.seconds()<2){
            telemetry.addData("frontRightPos", mainAutoMechanum.frontRight.getCurrentPosition());
            telemetry.update();
        }
        mainAutoMechanum.brake();
        sleep(500);

        mainElevator.setTargetPosition(topPosition);
        sleep(500);

        mainAutoMechanum.driveForward(.2);
        timer.reset();
        while (timer.seconds()<0.5){
            telemetry.addData("frontRightPos", mainAutoMechanum.frontRight.getCurrentPosition());
            telemetry.update();
        }
        mainAutoMechanum.brake();
        sleep(500);
        mainElevator.setTargetPosition(topPosition-50);
        sleep(500);
        mainClaw.openClaw();
        sleep(100);
        mainClaw.closeClaw();

        mainAutoMechanum.driveBackward(.2);
        timer.reset();
        while (timer.seconds()<0.5){
            telemetry.addData("frontRightPos", mainAutoMechanum.frontRight.getCurrentPosition());
            telemetry.update();
        }
        mainAutoMechanum.brake();
        mainElevator.setTargetPosition(bottomPosition);

        mainAutoMechanum.strafeRight(.3);
        timer.reset();
        while (timer.seconds()<3){
            telemetry.addData("frontRightPos", mainAutoMechanum.frontRight.getCurrentPosition());
            telemetry.update();
        }
        mainAutoMechanum.brake();

        if(red){
            mainAutoMechanum.driveBackward(.3);
            timer.reset();
            while (timer.seconds()<2){
                telemetry.addData("frontRightPos", mainAutoMechanum.frontRight.getCurrentPosition());
                telemetry.update();
            }
            mainAutoMechanum.brake();
        }
        else if(blue){
            mainAutoMechanum.driveForward(.3);
            timer.reset();
            while (timer.seconds()<2){
                telemetry.addData("frontRightPos", mainAutoMechanum.frontRight.getCurrentPosition());
                telemetry.update();
            }
            mainAutoMechanum.brake();
        }




//        mainAutoMechanum.driveForward(150, .275);
//        sleep(1000);
//
//        sleep(1000);
//        mainClaw.openClaw();
//        sleep(1000);
//        mainAutoMechanum.driveBackward(150, .275);
//        mainElevator.setTargetPosition(bottomPosition);
//        mainAutoMechanum.strafeRight(1000, .275);
//
//        if (red){
//            mainAutoMechanum.driveBackward(2000, .275);
//        }
//        if (blue){
//            mainAutoMechanum.driveForward(2000,.275);
//        }







//        while (mainAutoMechanum.isBusy()) {
//            telemetry.update();
//            telemetry.addData("Front Left: ", AutoMechanum.frontLeft.getCurrentPosition());
//            telemetry.addData("Front Right: ", AutoMechanum.frontRight.getCurrentPosition());
//            telemetry.addData("Back Left: ", AutoMechanum.backLeft.getCurrentPosition());
//            telemetry.addData("Back Right: ", AutoMechanum.backRight.getCurrentPosition());
//            telemetry.addData("Code uploaded", "yes");
//        }




    }


}


