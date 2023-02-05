//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Avaninder B., Stanley H.+++
package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.Mechanum;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.hardware.NormalizedColorSensor;
import com.qualcomm.robotcore.hardware.NormalizedRGBA;
import com.qualcomm.robotcore.hardware.SwitchableLight;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;


@TeleOp(name="TeleV2_OnePlayer", group="TeleOp")

public class TeleV2_OnePlayer extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    private DcMotorEx elevator = null;
    private Servo leftServo = null;
    private Servo rightServo = null;
    private Claw mainClaw = new Claw();
    private Mechanum mainMechanum = new Mechanum();
    private Elevator mainElevator = new Elevator();
    private NormalizedColorSensor MainColorSensor;
    double bottomPosition = 0;
    double slightPosition = 300;
    double midPosition = 2020;
    double topPosition = 2755;
    double cone1 = 400;
    double cone2 = 300;
    double cone3 = 200;
    double cone4 = 100;
    double cone5 = 0;



    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        elevator = hardwareMap.get(DcMotorEx.class, "elevator");
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");

        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        waitForStart();
        mainClaw.init(hardwareMap);
        mainElevator.init(hardwareMap);
        runtime.reset();

        mainElevator.setTargetPosition(bottomPosition);

        while (opModeIsActive()) {
            telemetry.addData("Robot", "Initialized");
            telemetry.addData("Elevator Position: ", elevator.getCurrentPosition());
            telemetry.addData("Front Left: ", frontLeft.getCurrentPosition());
            telemetry.addData("Front Right: ", frontRight.getCurrentPosition());
            telemetry.addData("Back Left: ", backLeft.getCurrentPosition());
            telemetry.addData("Back Right: ", backRight.getCurrentPosition());
            telemetry.addData("Elevator: ", elevator.getCurrentPosition());
            telemetry.addData("left stick y", gamepad1.left_stick_y);
            telemetry.addData("left stick x", gamepad1.left_stick_x);
            telemetry.addData("right stick x", gamepad1.right_stick_x);
            telemetry.addData("A", gamepad1.a);
            telemetry.addData("B", gamepad1.b);
            telemetry.addData("X", gamepad1.x);
            telemetry.addData("Y", gamepad1.y);
            telemetry.addData("Right Trigger", gamepad1.right_trigger);
            telemetry.addData("Right Bumper", gamepad1.right_bumper);
            telemetry.addData("Left Trigger", gamepad1.left_trigger);
            telemetry.addData("Left Bumper", gamepad1.left_bumper);
            telemetry.addData("Left Servo Position", leftServo.getPosition());
            telemetry.addData("Right Servo Position", rightServo.getPosition());

            telemetry.addData("Code uploaded", "yes");

            while (!isStopRequested()) {
                // Translation
                if (Math.abs(gamepad1.left_stick_y) > 0.35 || Math.abs(gamepad1.left_stick_x) > 0.35 || Math.abs(gamepad1.right_stick_x) > 0.35) {
                    frontLeft.setPower(((gamepad1.left_stick_y - gamepad1.right_stick_x) - gamepad1.left_stick_x) / 1.5);
                    frontRight.setPower(((gamepad1.left_stick_y * -1 - gamepad1.right_stick_x) - gamepad1.left_stick_x) / 1.5);
                    backRight.setPower(((gamepad1.left_stick_y  + gamepad1.right_stick_x) - gamepad1.left_stick_x) / 1.5);
                    backLeft.setPower(((gamepad1.left_stick_y * -1 + gamepad1.right_stick_x) - gamepad1.left_stick_x) / 1.5);
                } else {
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
                    backRight.setPower(0);
                    backLeft.setPower(0);
                }

                if (gamepad1.dpad_up) {
                    mainElevator.setTargetPosition(topPosition);
                    bottomPosition -= 5;
                }

                if (gamepad1.dpad_down) {
                    mainElevator.setTargetPosition(bottomPosition);
                }

                if (gamepad1.dpad_right) {
                    mainElevator.setTargetPosition(midPosition);
                }

                if (gamepad1.dpad_left) {
                    mainElevator.setTargetPosition(slightPosition);
                }


                if (gamepad1.right_trigger > 0.3) {
                    mainClaw.openClaw();
                }

                if (gamepad1.right_bumper) {
                    mainClaw.closeClaw();
                }


                while (gamepad1.left_trigger > 0.3) {
                    mainElevator.setTargetPosition(elevator.getCurrentPosition()-(60 * gamepad1.left_trigger));
                }

                while (gamepad1.left_bumper) {
                    mainElevator.setTargetPosition(elevator.getCurrentPosition()+50);
                }

                if (gamepad1.y){
                    mainElevator.setTargetPosition(cone1);
                }
                if (gamepad1.b){
                    mainElevator.setTargetPosition(cone2);
                }
                if (gamepad1.x){
                    mainElevator.setTargetPosition(cone3);
                }
                if (gamepad1.a){
                    mainElevator.setTargetPosition(cone4);
                }

                telemetry.update();
            }
        }
    }}
