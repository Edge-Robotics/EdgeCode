//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Avaninder B.
package org.firstinspires.ftc.teamcode.test;

import static com.qualcomm.robotcore.hardware.Servo.MAX_POSITION;
import static com.qualcomm.robotcore.hardware.Servo.MIN_POSITION;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.subsystems.Claw;


@TeleOp(name="ServoLimits", group="TeleOp")

public class ServoLimits extends LinearOpMode {

    Claw mainClaw = new Claw();
    private Servo leftServo = null;
    private Servo rightServo = null;

    @Override
    public void runOpMode() {
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");

        waitForStart();
        mainClaw.init(hardwareMap);

        while (opModeIsActive()) {
            leftServo.setPosition(MAX_POSITION);
            telemetry.addData("Left Claw Pos ", leftServo.getPosition());
            telemetry.addData("Right Claw Pos ", rightServo.getPosition());
            telemetry.update();
            sleep(5000);
            leftServo.setPosition(MIN_POSITION);
            telemetry.addData("Left Claw Pos ", leftServo.getPosition());
            telemetry.addData("Right Claw Pos ", rightServo.getPosition());
            telemetry.update();

        }
    }}
