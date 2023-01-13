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

@Autonomous(name = "Elevator")
public class Elevator {

    private DcMotorEx elevatorLeft;
    private DcMotorEx elevatorRight;
    double leftPower;
    double rightPower;
    double bottomPosition = 0;
    double topPosition = 69;

    public void init(HardwareMap hardwareMap) {
        elevatorLeft = hardwareMap.get(DcMotorEx.class, "elevatorLeft"); //rename in hardware map
        elevatorRight = hardwareMap.get(DcMotorEx.class, "elevatorRight");

        elevatorLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        elevatorRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

    }

    public void setTargetPosition(double target){
        elevatorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        elevatorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        double currentPos = elevatorLeft.getCurrentPosition();

        if (currentPos < target) {
            // Going up
            leftPower = 1;
            rightPower = -1;
        } else if (currentPos > target) {
            // Going down
            leftPower = -0.5;
            rightPower = 0.5;
        }

        elevatorLeft.setTargetPosition((int) target);
        elevatorRight.setTargetPosition((int) -target);

        elevatorLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        elevatorRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        elevatorLeft.setPower(leftPower);
        elevatorRight.setPower(rightPower);
    }

    public double get_lift_position(){
        return elevatorLeft.getCurrentPosition();
    }


}