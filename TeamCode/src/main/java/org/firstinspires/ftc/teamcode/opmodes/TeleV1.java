//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Stanley H.
package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.Mechanum;


@TeleOp(name="TeleV1", group="TeleOp")

public class TeleV1 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontLeft = null;
    private DcMotor frontRight = null;
    private DcMotor backLeft = null;
    private DcMotor backRight = null;
    private DcMotorEx elevatorLeft = null;
    private DcMotorEx elevatorRight = null;
    private Claw mainClaw = new Claw();
    private Mechanum mainMechanum = new Mechanum();
    private Elevator mainElevator = new Elevator();
    double bottomPosition = 0;
    double slightPosition = 65;
    double midPosition = 2030;
    double topPosition = 2780;


    @Override
    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotor.class, "frontLeft");
        frontRight = hardwareMap.get(DcMotor.class, "frontRight");
        backLeft = hardwareMap.get(DcMotor.class, "backLeft");
        backRight = hardwareMap.get(DcMotor.class, "backRight");
        elevatorLeft = hardwareMap.get(DcMotorEx.class, "elevatorLeft");
        elevatorRight = hardwareMap.get(DcMotorEx.class, "elevatorRight");

        waitForStart();
        mainClaw.init(hardwareMap);
        mainElevator.init(hardwareMap);
        runtime.reset();

        mainElevator.setTargetPosition(bottomPosition);

        while (opModeIsActive()) {
            telemetry.addData("Robot Status", "Initialized");
            telemetry.addData("Elevator Position: ", elevatorLeft.getCurrentPosition());
            telemetry.addData("Front Left: ", frontLeft.getCurrentPosition());
            telemetry.addData("Front Right: ", frontRight.getCurrentPosition());
            telemetry.addData("Back Left: ", backLeft.getCurrentPosition());
            telemetry.addData("Back Right: ", backRight.getCurrentPosition());
            telemetry.addData("left stick y", gamepad1.left_stick_y);
            telemetry.addData("left stick x", gamepad1.left_stick_x);
            telemetry.addData("right stick x", gamepad1.right_stick_x);

            telemetry.addData("Code uploaded", "yes");

            while (!isStopRequested()) {
                // Translation
                if (Math.abs(gamepad1.left_stick_y) > 0.3 || Math.abs(gamepad1.left_stick_x) > 0.3 || Math.abs(gamepad1.right_stick_x) > 0.3) {
                    frontLeft.setPower(((gamepad1.left_stick_y - gamepad1.left_stick_x) - gamepad1.right_stick_x) / 1.75);
                    frontRight.setPower(((gamepad1.left_stick_y * -1 - gamepad1.left_stick_x) - gamepad1.right_stick_x) / 1.75);
                    backRight.setPower(((gamepad1.left_stick_y * -1 + gamepad1.left_stick_x) - gamepad1.right_stick_x) / 1.75);
                    backLeft.setPower(((gamepad1.left_stick_y + gamepad1.left_stick_x) - gamepad1.right_stick_x) / 1.75);
                } else {
                    frontLeft.setPower(0);
                    frontRight.setPower(0);
                    backRight.setPower(0);
                    backLeft.setPower(0);
                }

                if (gamepad1.dpad_up) {
                    mainElevator.setTargetPosition(topPosition);
                    slightPosition += 15;
                    midPosition += 15;
                    topPosition += 15;
                }

                if (gamepad1.dpad_down) {
                    mainElevator.setTargetPosition(bottomPosition);
                    //elevatorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                    //elevatorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                }

                if (gamepad1.dpad_right) {
                    mainElevator.setTargetPosition(midPosition);
                }

                if (gamepad1.dpad_left) {
                    mainElevator.setTargetPosition(slightPosition);
                }


                if (gamepad1.right_trigger > 0.8) {
                    mainClaw.setIntakePower(-1);
                } else {
                    mainClaw.setIntakePower(0);
                }

                if (gamepad1.right_bumper) {
                    mainClaw.setIntakePower(1);
                } else {
                    mainClaw.setIntakePower(0);
                }

                telemetry.update();
            }
        }
    }}
