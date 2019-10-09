package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Basic Mecanum Drive", group="Teleop")
public class Teleop extends OpMode {

    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.dcMotor.get(Properties.FRONT_LEFT_MOTOR);
        frontRightMotor = hardwareMap.dcMotor.get(Properties.FRONT_RIGHT_MOTOR);
        backLeftMotor = hardwareMap.dcMotor.get(Properties.BACK_LEFT_MOTOR);
        backRightMotor = hardwareMap.dcMotor.get(Properties.BACK_RIGHT_MOTOR);

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
       mecanumDrive(gamepad1.right_stick_x, -gamepad1.left_stick_y, gamepad1.left_stick_x);

//        if (Math.abs(gamepad1.left_stick_y) < 0.1 && Math.abs(gamepad1.right_stick_y) < 0.1 && gamepad1.left_bumper)
//        {
//            frontLeftMotor.setPower(-1);
//            frontRightMotor.setPower(-1);
//            backLeftMotor.setPower(1);
//            backRightMotor.setPower(1);
//            // Strafe
//        }
//        else if  (Math.abs(gamepad1.left_stick_y) < 0.1 && Math.abs(gamepad1.right_stick_y) < 0.1 && gamepad1.right_bumper){
//            // Strafe the other way
//
//            frontLeftMotor.setPower(1);
//            frontRightMotor.setPower(1);
//            backLeftMotor.setPower(-1);
//            backRightMotor.setPower(-1);
//        }
//
//        else{
//            frontLeftMotor.setPower(-gamepad1.left_stick_y); // normal driving
//            frontRightMotor.setPower(-gamepad1.right_stick_y);
//            backLeftMotor.setPower(-gamepad1.left_stick_y);
//            backRightMotor.setPower(-gamepad1.right_stick_y);
//
//        }

    }


    private void mecanumDrive(double leftx, double lefty, double rightx) {
        double fl = lefty+leftx+rightx;
        double fr = lefty-leftx-rightx;
        double bl = lefty+leftx-rightx;
        double br = lefty-leftx+rightx;
        frontLeftMotor.setPower(fl);
        frontRightMotor.setPower(fr);
        backLeftMotor.setPower(bl);
        backRightMotor.setPower(br);
    }

}
