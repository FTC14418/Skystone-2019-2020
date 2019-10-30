package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="Cooler Design", group="Teleop")
public class Teleoptest1 extends OpMode {

    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private Servo leftArm;
    private Servo rightArm;

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.dcMotor.get(Properties.FRONT_LEFT_MOTOR);
        frontRightMotor = hardwareMap.dcMotor.get(Properties.FRONT_RIGHT_MOTOR);
        backLeftMotor = hardwareMap.dcMotor.get(Properties.BACK_LEFT_MOTOR);
        backRightMotor = hardwareMap.dcMotor.get(Properties.BACK_RIGHT_MOTOR);
        leftArm = hardwareMap.servo.get(Properties.LEFT_ARM);
        rightArm = hardwareMap.servo.get(Properties.RIGHT_ARM);

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        mecanumDrive(-gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x);
        arm(gamepad1.left_trigger);
    }

    private void mecanumDrive(double leftx, double lefty, double rightx) {
        double fl = lefty-leftx+rightx;
        double fr = lefty+leftx-rightx;
        double bl = lefty+leftx+rightx;
        double br = lefty-leftx-rightx;
        frontLeftMotor.setPower(fl);
        frontRightMotor.setPower(fr);
        backLeftMotor.setPower(bl);
        backRightMotor.setPower(br);
    }
    private void arm(double position) {
        double leftArmPosition = 0;
        double rightArmPosition = 0;
        if (position != 0) {
            leftArmPosition = 1.0;
            rightArmPosition = 0;
        }
        else {
            leftArmPosition = 0;
            rightArmPosition = 1.0;
        }
        leftArm.setPosition(leftArmPosition);
        rightArm.setPosition(rightArmPosition);
    }

}
