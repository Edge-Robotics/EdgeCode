//Property of FTC Team 22346 - All External users must request permission to access and utilize code
//Authors: Avaninder B.
package org.firstinspires.ftc.teamcode.test;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import org.firstinspires.ftc.teamcode.subsystems.Claw;
import org.firstinspires.ftc.teamcode.subsystems.Elevator;
import org.firstinspires.ftc.teamcode.subsystems.Mechanum;


@TeleOp(name="LiftLimits", group="TeleOp")

public class LiftLimits extends LinearOpMode {

    Elevator elevator = new Elevator();

    @Override
    public void runOpMode() {
        waitForStart();
        elevator.init(hardwareMap);

        while (opModeIsActive()) {
            telemetry.addData("Elevator Pos ", elevator.get_lift_position());
            telemetry.update();
        }
    }}
