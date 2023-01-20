//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Avaninder B., Stanley H.+++
package org.firstinspires.ftc.teamcode.subsystems;

import static java.lang.Thread.sleep;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.*;

//import com.qualcomm.robotcore.hardware.opmode;
//import com.qualcomm.robotcore.hardware.opmode.Autonomous;

public class AutoMechanum {

    private DcMotorEx frontLeft;
    private DcMotorEx frontRight;
    private DcMotorEx backLeft;
    private DcMotorEx backRight;


    double frontLeftPower;
    double frontRightPower;
    double backLeftPower;
    double backRightPower;


    public void init(HardwareMap hardwareMap) {
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backRight = hardwareMap.get(DcMotorEx.class, "backRight");

//        frontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//        frontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//        backLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//        backRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
//
//        frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//        frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//        backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
//        backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void setTargetPositionFrontLeft(double target, double power){
        frontLeft.setTargetPosition((int) target); // might need to changed to "frontLeft.setTargetPositionFrontLeft((int) target);"
        frontLeft.setPower(power);
    }

    public void setTargetPositionFrontRight(double target, double power){
        frontLeft.setTargetPosition((int) target);
        frontLeft.setPower(power);
    }

    public void setTargetPositionBackLeft(double target, double power){
        frontLeft.setTargetPosition((int) target);
        frontLeft.setPower(power);
    }

    public void setTargetPositionBackRight(double target, double power){
        frontLeft.setTargetPosition((int) target);
        frontLeft.setPower(power);
    }

    public void driveForward(double target, double power){
        power /= 1000;
        setTargetPositionFrontLeft(target, power);
        setTargetPositionFrontRight(target, power);
        setTargetPositionBackLeft(target, power);
        setTargetPositionBackRight(target, power);
    }

    public void driveBackward(double target, double power){
        power /= 1000;
        setTargetPositionFrontLeft(target, -power);
        setTargetPositionFrontRight(target, -power);
        setTargetPositionBackLeft(target, -power);
        setTargetPositionBackRight(target, -power);
    }

    public void turnRight(double target, double power){
        power /= 1000;
        setTargetPositionFrontLeft(target, -power); //FOR ALL BELOW -- CHANGE THESE
        setTargetPositionFrontRight(target, power);
        setTargetPositionBackLeft(target, -power);
        setTargetPositionBackRight(target, power);

    }

    public void turnLeft(double target, double power){
        power /= 1000;
        setTargetPositionFrontLeft(target, power);
        setTargetPositionFrontRight(target, -power);
        setTargetPositionBackLeft(target, power);
        setTargetPositionBackRight(target, -power);
    }

    public void strafeRight(double target, double power){
        power /= 1000;
        setTargetPositionFrontLeft(target, -power);
        setTargetPositionFrontRight(target, power);
        setTargetPositionBackLeft(target, power);
        setTargetPositionBackRight(target, -power);
    }

    public void strafeLeft(double target, double power){
        power /= 1000;
        setTargetPositionFrontLeft(target, power);
        setTargetPositionFrontRight(target, -power);
        setTargetPositionBackLeft(target, -power);
        setTargetPositionBackRight(target, power);
    }



}

