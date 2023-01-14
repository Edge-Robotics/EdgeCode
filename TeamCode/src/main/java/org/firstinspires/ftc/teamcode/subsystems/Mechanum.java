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

public class Mechanum {

    private DcMotor frontLeft;
    private DcMotor frontRight;
    private DcMotor backRight;
    private DcMotor backLeft;

    public void init(HardwareMap hardwareMap) {
        frontLeft = hardwareMap.get(DcMotor.class, "frontleft");
        frontRight = hardwareMap.get(DcMotor.class, "frontright");
        backRight = hardwareMap.get(DcMotor.class, "backright");
        backLeft = hardwareMap.get(DcMotor.class, "backleft");
    }


}