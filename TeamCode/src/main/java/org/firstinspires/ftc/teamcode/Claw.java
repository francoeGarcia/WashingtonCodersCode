package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoController;

@TeleOp
public class Claw extends LinearOpMode {
    private Servo ClawMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        ClawMotor = hardwareMap.get(Servo.class, "ClawMotor");
        ClawMotor.setPosition(0);
        ClawMotor.setDirection(Servo.Direction.REVERSE);

        waitForStart();
        if (opModeIsActive()) {
            while (opModeIsActive()) {
                telemetry.addData("Status", "Initialized");
                //telemetry.addData("Status", gamepad1.right_trigger);
                ClawMotor.setPosition(3*gamepad1.right_trigger);
            }
        }
    }
}