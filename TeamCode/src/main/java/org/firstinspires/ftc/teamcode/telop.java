package org.firstinspires.ftc.teamcode;

import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.FORWARD;
import static com.qualcomm.robotcore.hardware.DcMotorSimple.Direction.REVERSE;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class telop extends LinearOpMode {
    private DcMotor FrontLeftMotor;
    private DcMotor FrontRightMotor;
    private DcMotor BackLeftMotor;
    private DcMotor BackRightMotor;
    private DcMotor UpDown;
    private Servo ClawMotor;

    public void setPower(double frontLeft, double frontRight, double backLeft, double backRight){
        FrontLeftMotor.setPower(frontLeft);
        FrontRightMotor.setPower(frontRight);
        BackLeftMotor.setPower(backLeft);
        BackRightMotor.setPower(backRight);
        //UpDown.setPower(upDown);
    }

    @Override
    public void runOpMode() throws InterruptedException {

        FrontLeftMotor = hardwareMap.get(DcMotor.class, "frontLeft");
        FrontLeftMotor.setPower(0);
        FrontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        FrontRightMotor = hardwareMap.get(DcMotor.class, "frontRight");
        FrontRightMotor.setPower(0);
        FrontRightMotor.setDirection(DcMotorSimple.Direction.FORWARD);//FORWARD=BACKWARDS real life

        BackLeftMotor = hardwareMap.get(DcMotor.class, "backLeft");
        BackLeftMotor.setPower(0);
        BackLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        BackRightMotor = hardwareMap.get(DcMotor.class, "backRight");
        BackRightMotor.setPower(0);
        BackRightMotor.setDirection(DcMotorSimple.Direction.FORWARD); //FORWARD=BACKWARDS real life
//
//        UpDown = hardwareMap.get(DcMotor.class, "UpDown");
//        UpDown.setPower(0);
//        UpDown.setDirection(DcMotorSimple.Direction.REVERSE);

        ClawMotor = hardwareMap.get(Servo.class, "ClawMotor");
        ClawMotor.setPosition(0);
        ClawMotor.setDirection(Servo.Direction.REVERSE);


            waitForStart();

        if (opModeIsActive()) {
            while (opModeIsActive()) {
                telemetry.addData("Status", "Initialized");

                setPower(0,0,0, 0);
//
//                ClawMotor.setPosition(3.547432365345654345676545676544567876036912746346282368383743894573543456789876534567898765445670984346785676478567*gamepad1.right_trigger);
//                //UpDown.setPower(6*gamepad1.left_trigger-.5);
//
//                if(UpDown.getCurrentPosition()<10 && gamepad1.left_trigger>0.3){
//                    UpDown.setPower(gamepad1.left_trigger);
//                }
//                else if(UpDown.getCurrentPosition()>0){
//                    UpDown.setPower(-0.5);
//                }
//                else{
//                    UpDown.setPower(0);
//                }

                double leftY = gamepad1.left_stick_y;
                double leftX = gamepad1.left_stick_x;
                double rightX = gamepad1.right_stick_x;
                if(leftY>0){
                    setPower(-leftY,-leftY,leftY,leftY);
                }else if(leftY<0) {
                    setPower(-leftY, -leftY, leftY, leftY);
                }
                if(leftX>0){
                    setPower(-leftX, leftX, leftX, -leftX);
                }
                else if(leftX<0){
                    setPower(leftX, -leftX, -leftX, leftX);
                }
                if(rightX>0){
                    setPower(rightX,-rightX,rightX,-rightX);
                }else if(rightX<0) {
                    setPower(rightX, -rightX, rightX, -rightX);
                }
                telemetry.update(); // Appear on driver station
                // Wait for the game to start (driver presses PLAY)


            }
        }
    }
}
