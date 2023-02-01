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

    public DcMotorEx frontLeft;
    public DcMotorEx frontRight;
    public DcMotorEx backLeft;
    public DcMotorEx backRight;


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
        backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);

        frontLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        frontRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        backLeft.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);
        backRight.setMode(DcMotorEx.RunMode.RUN_WITHOUT_ENCODER);

        frontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

    }

    public void setTargetPositionFrontLeft(int target, double power){
        frontLeft.setTargetPosition(-target);
        frontLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        frontLeft.setPower(power);
    }


    public void setTargetPositionFrontRight(int target, double power){
        frontRight.setTargetPosition(target);
        frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        frontRight.setPower(power);
    }

    public void setTargetPositionBackLeft(int target, double power){
        backLeft.setTargetPosition(-target);
        backLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backLeft.setPower(power);
    }

    public void setTargetPositionBackRight(int target, double power){
        backRight.setTargetPosition(target);
        backRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        backRight.setPower(power);
    }

    public void driveForward(int target, double power){
        setTargetPositionFrontLeft(target, power);
        setTargetPositionFrontRight(target, power);
        setTargetPositionBackLeft(target, power);
        setTargetPositionBackRight(target, power);
    }

    public void driveBackward(int target, double power){
        setTargetPositionFrontLeft(-target, power);
        setTargetPositionFrontRight(-target, power);
        setTargetPositionBackLeft(-target, power);
        setTargetPositionBackRight(-target, power);
    }

    public void turnRight(int target, double power){
        setTargetPositionFrontLeft(-target, power);
        setTargetPositionFrontRight(target, power);
        setTargetPositionBackLeft(-target, power);
        setTargetPositionBackRight(target, power);

    }

    public void turnLeft(int target, double power){
        setTargetPositionFrontLeft(target, power);
        setTargetPositionFrontRight(-target, power);
        setTargetPositionBackLeft(target, power);
        setTargetPositionBackRight(-target, power);
    }

    public void strafeRight(int target, double power){
        setTargetPositionFrontLeft(target, power);
        setTargetPositionFrontRight(target, power);
        setTargetPositionBackLeft(-target, power);
        setTargetPositionBackRight(-target, power);
    }

    public void strafeLeft(int target, double power){
        setTargetPositionFrontLeft(target, power);
        setTargetPositionFrontRight(target, power);
        setTargetPositionBackLeft(target, power);
        setTargetPositionBackRight(target, power);
    }
    public void strafeLeft(double power){ // change mecanum directions and add all other movement functions
        frontLeft.setPower(power);
        frontRight.setPower(power);
        backLeft.setPower(power);
        backRight.setPower(power);
    }


    public void brake(){
        frontLeft.setPower(0);
        frontRight.setPower(0);
        backLeft.setPower(0);
        backRight.setPower(0);
    }

    public void reset_encoders(){
        frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
    }

    public boolean isBusy(){
        return (frontLeft.isBusy() && frontRight.isBusy() && backRight.isBusy() && backLeft.isBusy());
    }


}

