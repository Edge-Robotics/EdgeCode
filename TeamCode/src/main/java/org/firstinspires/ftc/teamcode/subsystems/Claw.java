//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Avaninder B., Stanley H.+++
package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

//import com.qualcomm.robotcore.hardware.opmode;
//import com.qualcomm.robotcore.hardware.opmode.Autonomous;


public class Claw {

    private Servo leftServo;
    private Servo rightServo;

    public void init(HardwareMap hardwareMap) {
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");
    }

    double LeftClosePos = -1;
    double LeftOpenPos = 1;
    double RightClosePos = -1;
    double RightOpenPos = 1;

    public void openClaw(){
        leftServo.setPosition(LeftOpenPos);
        rightServo.setPosition(RightOpenPos);
    }

    public void closeClaw(){
        leftServo.setPosition(LeftClosePos);
        rightServo.setPosition(RightClosePos);
    }





}