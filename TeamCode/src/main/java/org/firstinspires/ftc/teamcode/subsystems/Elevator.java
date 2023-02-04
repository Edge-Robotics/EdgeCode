//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Avaninder B., Stanley H.+++
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

    private DcMotorEx elevator;

    double Power;

    public void init(HardwareMap hardwareMap) {
        elevator = hardwareMap.get(DcMotorEx.class, "elevator");
        elevator.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);
        elevator.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void setTargetPosition(double target){
        int currentPos = elevator.getCurrentPosition();

        if (currentPos < target) {
            // Going up
            Power = 0.65;
        } else if (currentPos > target) {
            // Going down
            Power = -0.6;
        }

        elevator.setTargetPosition((int) target);
        elevator.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);
        elevator.setPower(Power);
    }

    public int get_lift_position(){
        return elevator.getCurrentPosition();
    }


}