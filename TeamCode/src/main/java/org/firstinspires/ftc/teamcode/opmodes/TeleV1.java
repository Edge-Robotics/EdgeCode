package org.firstinspires.ftc.teamcode.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Mechanum;


@TeleOp(name="TeleV1", group="TeleOp")

public class TeleV1 extends LinearOpMode {

    private ElapsedTime runtime = new ElapsedTime();
    private DcMotor frontleft = null;
    private DcMotor frontright = null;
    private DcMotor backleft = null;
    private DcMotor backright = null;
    private Claw mainClaw = new Claw();
    private Mechanum mainMecanum = new Mechanum();

    @Override
    public void runOpMode() {
        waitForStart();
        mainClaw.init(hardwareMap);
        runtime.reset();

        while (opModeIsActive()) {
            frontleft.setPower(((gamepad1.right_stick_y - gamepad1.right_stick_x) - gamepad1.left_stick_x) / 1.75);
            frontright.setPower(((gamepad1.right_stick_y * -1 - gamepad1.right_stick_x) - gamepad1.left_stick_x) / 1.75);
            backright.setPower(((gamepad1.right_stick_y * -1 + gamepad1.right_stick_x) - gamepad1.left_stick_x) / 1.75);
            backleft.setPower(((gamepad1.right_stick_y + gamepad1.right_stick_x) - gamepad1.left_stick_x) / 1.75);
            mainClaw.setIntakePower(gamepad1.right_stick_y);

            telemetry.update();
        }
    }}
