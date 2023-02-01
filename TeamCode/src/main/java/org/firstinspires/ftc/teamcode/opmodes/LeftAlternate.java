//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Stanley H.
package org.firstinspires.ftc.teamcode.opmodes;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.SwitchableLight;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.subsystems.Mechanum;



//import org.firstinspires.ftc.teamcode.subsystems.AutoMechanum;



import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;





@Autonomous(name="LeftAlternate", group="AutoOp")

public class LeftAlternate extends LinearOpMode {
    DcMotor frontLeft;
    DcMotor backLeft;
    DcMotor backRight;
    DcMotor frontRight;
    ColorSensor colorSensor;

    private Claw mainClaw = new Claw();
    //private AutoMechanum mainAutoMechanum = new AutoMechanum();
    private Elevator mainElevator = new Elevator();
    private DcMotorEx elevatorLeft = null;
    private DcMotorEx elevatorRight = null;
    private ElapsedTime timer = new ElapsedTime();



    double bottomPosition = 0;
    double slightPosition = 55;
    double midPosition = 2020;
    double topPosition = 2780;

    boolean yellow = false;
    boolean magenta = false;
    boolean cyan = false;
    boolean reset = false;


    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        //frontLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //frontLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        //frontRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        // backLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        //backLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        backRight = hardwareMap.get(DcMotorEx.class, "backRight");{
            //backRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            //backRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

            mainClaw.init(hardwareMap);
            mainElevator.init(hardwareMap);

            //colorSensor = hardwareMap.get(ColorSensor.class, "ColorSensor");




            waitForStart();
            while (opModeIsActive())
            {
                if (reset == false){
                    timer.reset();
                    reset = true;
                    mainElevator.setTargetPosition(slightPosition);
                }
                if (timer.seconds() < 2.25) {
                    frontLeft.setPower(-0.5);
                    frontRight.setPower(0.5);
                    backRight.setPower(0.5);
                    backLeft.setPower(-0.5);
                }
                else {
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
                    backRight.setPower(0);
                    backLeft.setPower(0);
                    mainElevator.setTargetPosition(bottomPosition);
                    break;
                }
            }
                /*telemetry.addData("Robot Status", "Initialized");
                telemetry.addData("Elevator Position: ", elevatorLeft.getCurrentPosition());
                telemetry.addData("Front Left: ", frontLeft.getCurrentPosition());
                telemetry.addData("Front Right: ", frontRight.getCurrentPosition());
                telemetry.addData("Back Left: ", backLeft.getCurrentPosition());
                telemetry.addData("Back Right: ", backRight.getCurrentPosition());
                telemetry.addData("Code uploaded", "yes");
                telemetry.addData("Red", colorSensor.red());
                telemetry.addData("Green", colorSensor.green());
                telemetry.addData("Blue", colorSensor.blue());
                yellow = false;
                magenta = false;
                cyan = false;*/

//                mainClaw.setIntakePower(1);
//                sleep(500);
//                mainClaw.setIntakePower(0);
//                sleep(500);
//                mainElevator.setTargetPosition(slightPosition);
//                sleep(500);
//                mainAutoMechanum.driveForward(200,500);
//                mainAutoMechanum.brake();
//                sleep(500);
//                mainElevator.setTargetPosition(topPosition);
//                sleep(500);
//                mainAutoMechanum.driveForward(50,100);
//                sleep(500);
//                mainClaw.setIntakePower(-1);
//                sleep(500);
//                mainClaw.setIntakePower(0);
//                sleep(500);
//                mainAutoMechanum.driveBackward(100,200);
//                sleep(500);
//                mainElevator.setTargetPosition(bottomPosition);


//                sleep(500);
//                mainAutoMechanum.driveBackward(200,500);
//                sleep(500);
//                mainAutoMechanum.turnLeft(200,500); // MAKE FUNCTION FOR 90 DEGREE TURNS (OR TURNS OF X DEGREES IN GENERAL)
//                sleep(500);
//                mainAutoMechanum.turnRight(200,500);
//                sleep(500);
//                mainAutoMechanum.strafeLeft(200,500);
//                sleep(500);
//                mainAutoMechanum.strafeRight(200,500);
//                sleep(500);
//                mainElevator.setTargetPosition(topPosition);
//                sleep(500);
//                mainElevator.setTargetPosition(bottomPosition);
//                sleep(500);
//                mainClaw.intake();
//                sleep(500);
//                mainClaw.setIntakePower(0);
//                sleep(500);
//                mainClaw.outTake();
            // mainClaw.setIntakePower(0);
            //
                /*
                if (colorSensor.green() > colorSensor.blue() && colorSensor.green() > colorSensor.red() && colorSensor.green() - colorSensor.blue() > 0.05 && colorSensor.green() - colorSensor.red() > 0.05){
                    yellow = true;
                }
                else if (colorSensor.blue() > colorSensor.red() && colorSensor.green() > colorSensor.red() && colorSensor.blue() - colorSensor.red() > 0.05){
                    cyan = true;
                }
                else if (Math.abs(colorSensor.blue() - colorSensor.red()) < 0.06 && Math.abs(colorSensor.red() - colorSensor.green()) < 0.06 && Math.abs(colorSensor.green() - colorSensor.blue()) > 0.06){
                    magenta = true;
                }
                if (yellow){
                    telemetry.addData("Current Color Detected", "Yellow");
                }
                else if (cyan){
                    telemetry.addData("Current Color Detected", "Cyan");
                }
                else if (magenta){
                    telemetry.addData("Current Color Detected", "Magenta");
                }
                else{
                    telemetry.addData("Current Color Detected", "Unknown");
                }*/





        }

    }

}