package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="blueGrabBlock")
public class blueGrabBlock extends LinearOpMode {

    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private DcMotor liftMotor;
    private Servo leftArm;
    private Servo rightArm;
    private AnalogInput armPot;
    private ColorSensor armColor;
    private ColorSensor floorColor;

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeftMotor = hardwareMap.dcMotor.get(Properties.FRONT_LEFT_MOTOR);
        frontRightMotor = hardwareMap.dcMotor.get(Properties.FRONT_RIGHT_MOTOR);
        backLeftMotor = hardwareMap.dcMotor.get(Properties.BACK_LEFT_MOTOR);
        backRightMotor = hardwareMap.dcMotor.get(Properties.BACK_RIGHT_MOTOR);
        leftArm = hardwareMap.servo.get(Properties.LEFT_ARM);
        rightArm = hardwareMap.servo.get(Properties.RIGHT_ARM);
        armPot = hardwareMap.analogInput.get(Properties.ARM_POT);
        armColor = hardwareMap.get(ColorSensor.class, Properties.ARM_COLOR);
        floorColor = hardwareMap.get(ColorSensor.class, Properties.FLOOR_COLOR);

        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        final double SPEED = .25;

        waitForStart();
        autonomous();
    }

    //autonomous period
    public void autonomous() {
        arm(1);
        forward();
        while (armColor.red() < 170){
        }
        off();
        for(int i = 0; i < 2; i++) {
            if(armColor.alpha() < 1000){
                left(8);
            }
            else{
                break;
            }
        }
        forward(4);
        arm(0);
        backward(4);
        right();
        //change floorColor.alpha() number at competition
        while (floorColor.alpha() < 170){
        }
        off();
        right(12);
        arm(1);
        left();
        //change floorColor.alpha() number at competition
        while (floorColor.alpha() < 170){
        }
        off();
    }

    //open arms
    public void arm(int state) {
        if (state == 0) {
            leftArm.setPosition(1);
            rightArm.setPosition(0);
        }
        else if (state == 1){
            leftArm.setPosition(0);
            rightArm.setPosition(1);
        }
        else{
            leftArm.setPosition(.75);
            rightArm.setPosition(.25);
        }
        sleep(1000);
    }

    //moves robot forward x inches with y speed
    public void forward() {
        frontLeftMotor.setPower(.5);
        frontRightMotor.setPower(.5);
        backLeftMotor.setPower(.5);
        backRightMotor.setPower(.5);
    }
    public void forward(int inches) {
        int sec = inches * 77;
        frontLeftMotor.setPower(.5);
        frontRightMotor.setPower(.5);
        backLeftMotor.setPower(.5);
        backRightMotor.setPower(.5);
        sleep(sec);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //moves robot backwards x inches
    public void backward() {
        frontLeftMotor.setPower(-.5);
        frontRightMotor.setPower(-.5);
        backLeftMotor.setPower(-.5);
        backRightMotor.setPower(-.5);
    }
    public void backward(int inches) {
        int sec = inches * 77;
        frontLeftMotor.setPower(-.5);
        frontRightMotor.setPower(-.5);
        backLeftMotor.setPower(-.5);
        backRightMotor.setPower(-.5);
        sleep(sec);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //straft robot right x inches with y speed
    public void right() {
        frontLeftMotor.setPower(.5);
        frontRightMotor.setPower(-.5);
        backLeftMotor.setPower(-.5);
        backRightMotor.setPower(.5);
    }
    public void right(int inches) {
        int sec = inches * 84;
        frontLeftMotor.setPower(.5);
        frontRightMotor.setPower(-.5);
        backLeftMotor.setPower(-.5);
        backRightMotor.setPower(.5);
        sleep(sec);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //straft robot left
    public void left() {
        frontLeftMotor.setPower(.5);
        frontRightMotor.setPower(-.5);
        backLeftMotor.setPower(-.5);
        backRightMotor.setPower(.5);
    }
    public void left(int inches) {
        int sec = inches * 84;
        frontLeftMotor.setPower(-.5);
        frontRightMotor.setPower(.5);
        backLeftMotor.setPower(.5);
        backRightMotor.setPower(-.5);
        sleep(sec);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //turn robot right x degrees
    public void turnright() {
        frontLeftMotor.setPower(.5);
        frontRightMotor.setPower(-.5);
        backLeftMotor.setPower(.5);
        backRightMotor.setPower(-.5);
    }
    public void turnright(int degrees) {
        int sec = degrees * 2;
        frontLeftMotor.setPower(.5);
        frontRightMotor.setPower(-.5);
        backLeftMotor.setPower(.5);
        backRightMotor.setPower(-.5);
        sleep(sec);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    //turn robot left x degrees
    public void turntleft() {
        frontLeftMotor.setPower(-.5);
        frontRightMotor.setPower(.5);
        backLeftMotor.setPower(-.5);
        backRightMotor.setPower(.5);
    }
    public void turnleft(int degrees) {
        int sec = degrees * 2;
        frontLeftMotor.setPower(-.5);
        frontRightMotor.setPower(.5);
        backLeftMotor.setPower(-.5);
        backRightMotor.setPower(.5);
        sleep(sec);
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }

    public void off() {
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);
    }
}

