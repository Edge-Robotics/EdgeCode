//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Stanley H.
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


public class Claw {

    private CRServo leftServo;
    private CRServo rightServo;

    public void init(HardwareMap hardwareMap) {
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");
    }
    public void setIntakePower(double power){
        leftServo.setPower(-power);
        rightServo.setPower(power);
    }


}