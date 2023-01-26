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

        frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

    }

    public void setTargetPositionFrontLeft(int target, double power){
        frontLeft.setTargetPosition((int) target); // try using stop and reset encoder before this line
        frontLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        frontLeft.setPower(power);
        //frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setTargetPositionFrontRight(int target, double power){
        frontRight.setTargetPosition((int) target);
        frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        frontRight.setPower(power);
        //frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setTargetPositionBackLeft(int target, double power){
        backLeft.setTargetPosition((int) target);
        backLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backLeft.setPower(power);
        //backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setTargetPositionBackRight(int target, double power){
        backRight.setTargetPosition((int) target);
        backRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backRight.setPower(power);
        //backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void driveForward(int target, double power){
        setTargetPositionFrontLeft(-target, power);
        setTargetPositionFrontRight(target, power);
        setTargetPositionBackLeft(-target, power);
        setTargetPositionBackRight(target, power);
    }

    public void driveBackward(int target, double power){
        setTargetPositionFrontLeft(target, -power);
        setTargetPositionFrontRight(target, -power);
        setTargetPositionBackLeft(target, -power);
        setTargetPositionBackRight(target, -power);
    }

    public void turnRight(int target, double power){
        setTargetPositionFrontLeft(target, -power); //FOR ALL BELOW -- CHANGE THESE
        setTargetPositionFrontRight(target, power);
        setTargetPositionBackLeft(target, -power);
        setTargetPositionBackRight(target, power);

    }

    public void turnLeft(int target, double power){
        setTargetPositionFrontLeft(target, power);
        setTargetPositionFrontRight(target, -power);
        setTargetPositionBackLeft(target, power);
        setTargetPositionBackRight(target, -power);
    }

    public void strafeRight(int target, double power){
        setTargetPositionFrontLeft(target, -power);
        setTargetPositionFrontRight(target, power);
        setTargetPositionBackLeft(target, power);
        setTargetPositionBackRight(target, -power);
    }

    public void strafeLeft(int target, double power){
        setTargetPositionFrontLeft(target, power);
        setTargetPositionFrontRight(target, -power);
        setTargetPositionBackLeft(target, -power);
        setTargetPositionBackRight(target, power);
    }

    public void brake(){
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }


}

