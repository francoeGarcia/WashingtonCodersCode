package org.firstinspires.ftc.teamcode;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class UpMecha extends LinearOpMode {
    private DcMotor FrontRightMotor;


    public void setPower(double frontRight){
        FrontRightMotor.setPower(frontRight);

        //UpDown.setPower(upDown);
    }

    @Override
    public void runOpMode() throws InterruptedException {

        FrontRightMotor = hardwareMap.get(DcMotor.class, "frontRight");
        FrontRightMotor.setPower(0);
        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);//FORWARD=BACKWARDS real life
        FrontRightMotor.setPower(0);

        waitForStart();

        if (opModeIsActive()) {
            while (opModeIsActive()) {
                telemetry.addData("Status", "Initialized");

//
                double leftY = gamepad1.left_stick_y;
                double leftX = gamepad1.left_stick_x;
                double rightX = gamepad1.right_stick_x;
                if(leftY>0){
                    setPower(-leftY);
                }else if(leftY<0) {
                    setPower(-leftY);
                }
                if(leftX>0){
                    setPower(leftX);
                }
                else if(leftX<0){
                    setPower(-leftX);
                }
                if(rightX>0){
                    setPower(-rightX);
                }else if(rightX<0) {
                    setPower(-rightX);
                }else if(leftY==0) {
                setPower(0);
            }
                telemetry.update(); // Appear on driver station
                // Wait for the game to start (driver presses PLAY)


            }
        }
    }
}
