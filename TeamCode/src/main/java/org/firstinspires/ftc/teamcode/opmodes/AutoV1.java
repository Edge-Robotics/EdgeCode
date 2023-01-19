//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Stanley H.
package org.firstinspires.ftc.teamcode.opmodes;

import android.annotation.SuppressLint;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.Intake;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.subsystems.Mechanum;
import org.firstinspires.ftc.teamcode.subsystems.AutoMechanum;



@Autonomous(name="AutoV1", group="AutoOp")

public class AutoV1 extends LinearOpMode {
    DcMotorEx frontLeft;
    DcMotorEx backLeft;
    DcMotorEx backRight;
    DcMotorEx frontRight;
    private Intake mainClaw = new Intake();
    private AutoMechanum mainAutoMechanum = new AutoMechanum();
    private Elevator mainElevator = new Elevator();
    private DcMotorEx elevatorLeft = null;
    private DcMotorEx elevatorRight = null;
    private ElapsedTime runtime = new ElapsedTime();

    double bottomPosition = 0;
    double slightPosition = 55;
    double midPosition = 2020;
    double topPosition = 2780;

    public void runOpMode() {
        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        backRight = hardwareMap.get(DcMotorEx.class, "backRight");{
        backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setMode(DcMotorEx.RunMode.RUN_TO_POSITION);

        mainClaw.init(hardwareMap);
        mainElevator.init(hardwareMap);



            waitForStart();
            while (opModeIsActive())
            {
                telemetry.addData("Robot Status", "Initialized");
                telemetry.addData("Elevator Position: ", elevatorLeft.getCurrentPosition());
                telemetry.addData("Front Left: ", frontLeft.getCurrentPosition());
                telemetry.addData("Front Right: ", frontRight.getCurrentPosition());
                telemetry.addData("Back Left: ", backLeft.getCurrentPosition());
                telemetry.addData("Back Right: ", backRight.getCurrentPosition());
                telemetry.addData("Code uploaded", "yes");

                mainAutoMechanum.driveForward(1000,500);
                sleep(500);
                mainAutoMechanum.driveBackward(1000,500);
                sleep(500);
                mainAutoMechanum.turnLeft(1000,500); // MAKE FUNCTION FOR 90 DEGREE TURNS (OR TURNS OF X DEGREES IN GENERAL)
                sleep(500);
                mainAutoMechanum.turnRight(1000,500);
                sleep(500);
                mainAutoMechanum.strafeLeft(1000,500);
                sleep(500);
                mainAutoMechanum.strafeRight(1000,500);
                sleep(500);


            }

        }







        runtime.reset();


    }}
