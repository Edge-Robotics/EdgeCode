//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Stanley H.
package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.subsystems.AutoMechanum;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.Claw;


@Autonomous(name = "AutoV1", group = "AutoOp")

public class AutoV1 extends LinearOpMode {
    DcMotorEx frontLeft;
    DcMotorEx backLeft;
    DcMotorEx backRight;
    DcMotorEx frontRight;
    ColorSensor colorSensor;
    double bottomPosition = 0;
    double slightPosition = 55;
    double midPosition = 2020;
    double topPosition = 2780;
    boolean yellow = false;
    boolean magenta = false;
    boolean cyan = false;
    boolean reset = false;
    private Servo leftServo = null;
    private Servo rightServo = null;
    private final Claw mainClaw = new Claw();
    private final AutoMechanum mainAutoMechanum = new AutoMechanum();
    private final Elevator mainElevator = new Elevator();
    private DcMotorEx elevator = null;
    private final ElapsedTime timer = new ElapsedTime();

    public void runOpMode() {
        elevator = hardwareMap.get(DcMotorEx.class, "elevator");

        frontLeft = hardwareMap.get(DcMotorEx.class, "frontLeft");
        frontLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        frontRight = hardwareMap.get(DcMotorEx.class, "frontRight");
        frontRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        frontRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        backLeft = hardwareMap.get(DcMotorEx.class, "backLeft");
        backLeft.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backLeft.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        backRight = hardwareMap.get(DcMotorEx.class, "backRight");
        backRight.setMode(DcMotorEx.RunMode.STOP_AND_RESET_ENCODER);
        backRight.setZeroPowerBehavior(DcMotorEx.ZeroPowerBehavior.BRAKE);

        mainClaw.init(hardwareMap);
        mainElevator.init(hardwareMap);
        mainAutoMechanum.init(hardwareMap);

        colorSensor = hardwareMap.get(ColorSensor.class, "ColorSensor");


            mainElevator.setTargetPosition(bottomPosition);
            waitForStart();

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
                telemetry.addData("Red", colorSensor.red());
                telemetry.addData("Green", colorSensor.green());
                telemetry.addData("Blue", colorSensor.blue());
                yellow = false;
                magenta = false;
                cyan = false;

            //while(frontLeft.getCurrentPosition() < 1500) {
                //mainAutoMechanum.driveForward(1500, 0.3);
            //}
           /* sleep(4000);
            mainAutoMechanum.driveForward(10000, 1);
            sleep(500);
            mainClaw.setIntakePower(-1);
            sleep(500);
            mainClaw.setIntakePower(0);
            sleep(500);
            mainAutoMechanum.driveBackward(1000, 500);
            sleep(500);
            mainElevator.setTargetPosition(bottomPosition);


            sleep(500);
            mainAutoMechanum.driveBackward(200, 500);
            sleep(500);
            mainAutoMechanum.turnLeft(200, 500); // MAKE FUNCTION FOR 90 DEGREE TURNS (OR TURNS OF X DEGREES IN GENERAL)
            sleep(500);
            mainAutoMechanum.turnRight(200, 500);
            sleep(500);
            mainAutoMechanum.strafeLeft(200, 500);
            sleep(500);
            mainAutoMechanum.strafeRight(200, 500);
            sleep(500);
            mainElevator.setTargetPosition(topPosition);
            sleep(500);
            mainElevator.setTargetPosition(bottomPosition);
            sleep(500);
            mainClaw.intake();
            sleep(500);
            mainClaw.setIntakePower(0);
            sleep(500);
            mainClaw.outTake();
            mainClaw.setIntakePower(0);
*/
            if (colorSensor.green() > 3500 && colorSensor.blue() < 2500 && colorSensor.red() < 5000) {
                yellow = true;
            } else if (colorSensor.blue() > 2750 && colorSensor.green() > 2750 && colorSensor.red() < 4250) {
                cyan = true;
            } else if (Math.abs(colorSensor.blue() - colorSensor.red()) < 600 && Math.abs(colorSensor.green() - colorSensor.red()) < 600) {
                magenta = true;
            }

            if (yellow) {
                telemetry.addData("Current Color Detected", "Yellow");
            } else if (cyan) {
                telemetry.addData("Current Color Detected", "Cyan");
            } else if (magenta) {
                telemetry.addData("Current Color Detected", "Magenta");
            } else {
                telemetry.addData("Current Color Detected", "Unknown");
            }

            telemetry.update();

        }

    }

}
