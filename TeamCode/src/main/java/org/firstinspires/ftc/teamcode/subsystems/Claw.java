//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Stanley H.+++
package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.util.ElapsedTime;

//import com.qualcomm.robotcore.hardware.opmode;
//import com.qualcomm.robotcore.hardware.opmode.Autonomous;


public class Claw {

    private CRServo leftServo;
    private CRServo rightServo;
    public boolean intakeWasCalled = false;
    public boolean outtakeWasCalled = false;
    private ElapsedTime timer = new ElapsedTime();

    public void init(HardwareMap hardwareMap) {
        leftServo = hardwareMap.get(CRServo.class, "leftServo");
        rightServo = hardwareMap.get(CRServo.class, "rightServo");
    }
    public void setIntakePower(double power){
        leftServo.setPower(-power);
        rightServo.setPower(power);
    }

    public void intake(){
        if (!intakeWasCalled){
            intakeWasCalled = true;
            setIntakePower(-1);
            timer.reset();
        }
    }
    public void outTake(){
        if (!outtakeWasCalled){
            outtakeWasCalled = true;
            setIntakePower(1);
            timer.reset();
        }
    }

    public void updateIntake(){
        if (intakeWasCalled && timer.seconds() > .25){
            setIntakePower(0);
            intakeWasCalled = false;
        }
        else if (outtakeWasCalled && timer.seconds() > .25){
            setIntakePower(0);
            outtakeWasCalled = false;
        }
    }






}