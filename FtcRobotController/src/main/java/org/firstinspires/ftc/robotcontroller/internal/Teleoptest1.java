package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@TeleOp(name="Cooler Design", group="Teleop")
public class Teleoptest1 extends OpMode {

    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private DcMotor leftArm;
    private DcMotor rightArm;

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.dcMotor.get(Properties.FRONT_LEFT_MOTOR);
        frontRightMotor = hardwareMap.dcMotor.get(Properties.FRONT_RIGHT_MOTOR);
        backLeftMotor = hardwareMap.dcMotor.get(Properties.BACK_LEFT_MOTOR);
        backRightMotor = hardwareMap.dcMotor.get(Properties.BACK_RIGHT_MOTOR);
        leftArm = hardwareMap.dcMotor.get(Properties.LEFT_ARM);
        rightArm = hardwareMap.dcMotor.get(Properties.RIGHT_ARM);

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        leftArm.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {

        mecanumDrive(gamepad1.left_stick_x, gamepad1.left_stick_y, gamepad1.right_stick_x);
        arm(gamepad1.left_trigger, gamepad1.right_trigger);
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
    private void arm(double leftt, double rightt) {
        double armSpeed = 0;
        if (leftt != 0) {
            armSpeed = leftt;
        }
        else if (rightt != 0) {
            armSpeed = -rightt;
        }
        else {
            armSpeed = 0;
        }

        leftArm.setPower(armSpeed);
        rightArm.setPower(armSpeed);
    }

}
