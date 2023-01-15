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
    double slightPosition = 50;
    double midPosition = 2000;
    double topPosition = 2750;


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
            frontLeft.setPower(((gamepad1.left_stick_y - gamepad1.left_stick_x) - gamepad1.right_stick_x) / 1.75);
            frontRight.setPower(((gamepad1.left_stick_y * -1 - gamepad1.left_stick_x) - gamepad1.right_stick_x) / 1.75);
            backRight.setPower(((gamepad1.left_stick_y * -1 + gamepad1.left_stick_x) - gamepad1.right_stick_x) / 1.75);
            backLeft.setPower(((gamepad1.left_stick_y + gamepad1.left_stick_x) - gamepad1.right_stick_x) / 1.75);
            mainClaw.setIntakePower(0.1);

            if (gamepad1.dpad_up){
                mainElevator.setTargetPosition(topPosition);
            }

            if (gamepad1.dpad_down){
                mainElevator.setTargetPosition(bottomPosition);
                //elevatorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
                //elevatorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            }

            if (gamepad1.dpad_right){
                mainElevator.setTargetPosition(midPosition);
            }

            if (gamepad1.dpad_left){
                mainElevator.setTargetPosition(slightPosition);
            }


            if (gamepad1.a){
                mainClaw.setIntakePower(-1);
            }
            else {
                mainClaw.setIntakePower(0);
            }

            if (gamepad1.b){
                mainClaw.setIntakePower(1);
            }
            else {
                mainClaw.setIntakePower(0);
            }

            telemetry.update();
        }
    }}
