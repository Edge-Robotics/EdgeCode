package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
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

    private DcMotor elevator_1;
    private DcMotor elevator_2;

    public void init(HardwareMap hardwareMap) {
        elevator_1 = hardwareMap.get(DcMotor.class, "elevator_1");
        elevator_2 = hardwareMap.get(DcMotor.class, "elevator_2");
    }


}