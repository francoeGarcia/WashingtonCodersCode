package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp
public class telop extends LinearOpMode {
    private DcMotor FrontLeftMotor;
    private DcMotor FrontRightMotor;

    @Override
    public void runOpMode() throws InterruptedException {
        FrontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeft");
        FrontLeftMotor.setPower(0);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.FORWARD);

        FrontRightMotor = hardwareMap.get(DcMotor.class, "frontRight");
        FrontRightMotor.setPower(0);
        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);
        waitForStart();

        if (opModeIsActive()) {
            while (opModeIsActive()) {
                telemetry.addData("Status", "Initialized");
                telemetry.addData("gamepad", gamepad1.left_stick_x);
                FrontLeftMotor.setPower(gamepad1.left_stick_x);
                FrontRightMotor.setPower(gamepad1.left_stick_x);
                telemetry.update(); // Appear on driver station
                // Wait for the game to start (driver presses PLAY)

            }
        }
    }
}
