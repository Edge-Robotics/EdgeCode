//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Stanley H., Avaninder B.
package org.firstinspires.ftc.teamcode.opmodes;

import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.AutoMechanum;
import org.firstinspires.ftc.teamcode.subsystems.Camera;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.Claw;


@Autonomous(name = "FINAL_AUTO", group = "AutoOp")

public class AutoLeft extends LinearOpMode {
    DcMotorEx frontLeft;
    DcMotorEx backLeft;
    DcMotorEx backRight;
    DcMotorEx frontRight;
    ColorSensor colorSensor;
    double bottomPosition = 0;
    double slightPosition = 55;
    double midPosition = 2020;
    double topPosition = 2780;
    boolean red = false;
    boolean green = false;
    boolean blue = false;
    boolean prevRed = false;
    boolean prevGreen = false;
    boolean prevBlue = false;
    boolean reset = false;
    private Servo leftServo = null;
    private Servo rightServo = null;
    private final Claw mainClaw = new Claw();
    private final AutoMechanum mainAutoMechanum = new AutoMechanum();
    private final Elevator mainElevator = new Elevator();
    private DcMotorEx elevator = null;
    private final ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {
        Camera camera = new Camera();
        camera.init(hardwareMap);
        MultipleTelemetry telemetry = new MultipleTelemetry();
        elevator = hardwareMap.get(DcMotorEx.class, "elevator");
        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");

        mainClaw.init(hardwareMap);
        mainElevator.init(hardwareMap);
        mainAutoMechanum.init(hardwareMap, telemetry);

//        colorSensor = hardwareMap.get(ColorSensor.class, "ColorSensor");

        mainElevator.setTargetPosition(bottomPosition);

        waitForStart();

        timer.reset();
        int position = -1;
        position = camera.getPosition();
        telemetry.addData("position", position);
        telemetry.update();
        sleep(50);

        mainClaw.closeClaw();

        mainAutoMechanum.strafeLeft(.3, 3.2);
        sleep(300);
        mainAutoMechanum.strafeRight(.3, .35);

        if (position == 1) {
            telemetry.addData("not moving", "it was 1 i think");
            mainAutoMechanum.driveBackward(.3, 4);
        } else if (position == 3) {
            telemetry.addData("not moving", "it was 3 i think");
            mainAutoMechanum.driveForward(.3, 4);
            mainAutoMechanum.brake();
        }
        else if (position == 2){
            telemetry.addData("not moving", "it was 2 i think");
            telemetry.update();
        }
        else if (position == -1){
            telemetry.addData("not moving", "I have no idea :(");
            telemetry.update();
        }


    }}