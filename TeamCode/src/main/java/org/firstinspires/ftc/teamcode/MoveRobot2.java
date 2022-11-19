package org.firstinspires.ftc.teamcode;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous
public class MoveRobot2 extends LinearOpMode {

    private DcMotor FrontLeftMotor;
    //private DcMotor FrontRightMotor;
    //private DcMotor BackLeftMotor;
    //private DcMotor BackRightMotor;

    @Override
    public void runOpMode() throws InterruptedException {

        FrontLeftMotor = hardwareMap.get(DcMotor.class, "motor1");
        //FrontRightMotor = hardwareMap.get(DcMotor.class, "22");
        //BackLeftMotor = hardwareMap.get(DcMotor.class, "23");
        //BackRightMotor = hardwareMap.get(DcMotor.class, "31");

        telemetry.addData("Status", "Initialized");
        telemetry.update(); // Appear on driver station
        // Wait for the game to start (driver presses PLAY)
        waitForStart();

    // MotorName.setPower(); 0-1
    // sleep(time); *time is in milliseconds
    // MotorName.setDirection();
        FrontLeftMotor.setDirection(FORWARD);
        FrontLeftMotor.setPower(.5);
        sleep(5000);
        FrontLeftMotor.setPower(0);
    //moveForward(.5,5000);
    //  moveBackward(.5, 5000);
    //  moveRight(.5, 5000);
    //  moveLeft(.5, 5000);
}

    }

