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
    private DcMotor liftMotor;
    private Servo leftArm;
    private Servo rightArm;

    @Override
    public void init() {
        frontLeftMotor = hardwareMap.dcMotor.get(Properties.FRONT_LEFT_MOTOR);
        frontRightMotor = hardwareMap.dcMotor.get(Properties.FRONT_RIGHT_MOTOR);
        backLeftMotor = hardwareMap.dcMotor.get(Properties.BACK_LEFT_MOTOR);
        backRightMotor = hardwareMap.dcMotor.get(Properties.BACK_RIGHT_MOTOR);
        liftMotor = hardwareMap.dcMotor.get(Properties.LIFT);
        leftArm = hardwareMap.servo.get(Properties.LEFT_ARM);
        rightArm = hardwareMap.servo.get(Properties.RIGHT_ARM);

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void loop() {
        mecanumDrive(-gamepad1.left_stick_x, -gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_button);
        arm(gamepad1.left_trigger, gamepad1.right_trigger, gamepad1.right_stick_button, gamepad1.left_stick_button);
    }

    private void mecanumDrive(double leftx, double lefty, double rightx, boolean speed) {
        double fl = lefty-leftx+rightx;
        double fr = lefty+leftx-rightx;
        double bl = lefty+leftx+rightx;
        double br = lefty-leftx-rightx;
        double speedMultiplier = 0.75;
        if (speed == true) {
            fl *= speedMultiplier;
            fr *= speedMultiplier;
            bl *= speedMultiplier;
            br *= speedMultiplier;
        }
        frontLeftMotor.setPower(fl);
        frontRightMotor.setPower(fr);
        backLeftMotor.setPower(bl);
        backRightMotor.setPower(br);
    }
    private void arm(double up, double down, boolean state, boolean speed) {
        double lift = 0;
        double speedMultiplier = 0.75;
        double leftArmPosition = 0;
        double rightArmPosition = 0;
        if (0 < up) {
            lift = up;
        }
        else if (0 < down) {
            lift = -down;
        }
        if (state == true) {
            leftArmPosition = 1.0;
            rightArmPosition = 0;
        }
        else {
            leftArmPosition = 0;
            rightArmPosition = 1.0;
        }
        if (speed == true) {
            lift *= speedMultiplier;
        }
        liftMotor.setPower(lift);
        leftArm.setPosition(leftArmPosition);
        rightArm.setPosition(rightArmPosition);
    }

}
