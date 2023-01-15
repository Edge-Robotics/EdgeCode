//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Stanley H.
package org.firstinspires.ftc.teamcode.subsystems;

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

public class Elevator {

    private DcMotorEx elevatorLeft;
    private DcMotorEx elevatorRight;
    double leftPower;
    double rightPower;

    public void init(HardwareMap hardwareMap) {
        elevatorLeft = hardwareMap.get(DcMotorEx.class, "elevatorLeft");
        elevatorRight = hardwareMap.get(DcMotorEx.class, "elevatorRight");

        elevatorLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        elevatorRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        elevatorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevatorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    public void setTargetPosition(double target){
        int currentPos = elevatorLeft.getCurrentPosition();

        if (currentPos < target) {
            // Going up
            leftPower = 0.85;
            rightPower = -0.85;
        } else if (currentPos > target) {
            // Going down
            leftPower = -0.4;
            rightPower = 0.4;}

        elevatorLeft.setTargetPosition((int) target);
        elevatorRight.setTargetPosition((int) -target);

        elevatorLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        elevatorRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        elevatorLeft.setPower(leftPower);
        elevatorRight.setPower(rightPower);

    }

    public int get_lift_position(){
        return elevatorLeft.getCurrentPosition();
    }


}