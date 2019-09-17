package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name="Basic Mecanum Drive", group="Teleop")
public class Teleop extends OpMode {

    private DcMotor frontLeftMotor;
    private DcMotor frontRighttMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.dcMotor.get(Properties.FRONT_LEFT_MOTOR);
        frontRighttMotor = hardwareMap.dcMotor.get(Properties.FRONT_RIGHT_MOTOR);
        backLeftMotor = hardwareMap.dcMotor.get(Properties.BACK_LEFT_MOTOR);
        backRightMotor = hardwareMap.dcMotor.get(Properties.BACK_RIGHT_MOTOR);
    }

    @Override
    public void loop() {
        mecanumDrive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
    }

    private void mecanumDrive(double leftx, double lefty, double rightx) {
        double fl = lefty+leftx+rightx;
        double fr = lefty-leftx-rightx;
        double bl = lefty-leftx+rightx;
        double br = lefty+leftx-rightx;
        frontLeftMotor.setPower(fl);
        frontRighttMotor.setPower(fr);
        backLeftMotor.setPower(bl);
        backRightMotor.setPower(br);
    }

}
