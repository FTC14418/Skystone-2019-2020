package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name="blueRightGetBlockPark")
public class blueRightGetBlockPark extends LinearOpMode {

    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;
    private Servo leftArm;
    private Servo rightArm;

    //Set up Variables
    static final double COUNTS_PER_MOTOR_REV    = 1120;
    static final double DRIVE_GEAR_REDUCTION    = 1;
    static final double WHEEL_DIAMETER_INCHES   = 3.25;
    static final double COUNTS_PER_INCH         =(COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION)/(WHEEL_DIAMETER_INCHES * Math.PI);

    //autonomous period
    public void autonomous() {
        arm(0);
        straft(-40,.5);
        arm(1);
        straft(30,.5);
        turn(180,.5);
        forward(20,.5);
        arm(0);
        forward(-10,.5);
    }

    //open arms
    public void arm(int state) {
        if (state == 0) {
            leftArm.setPosition(1);
            rightArm.setPosition(0);
        }
        else {
            leftArm.setPosition(0);
            rightArm.setPosition(1);
        }
    }

    //moves robot forward x inches with y speed
    public void forward(int inches, double speed) {

        int calibration = 1;
        //reverses the right motors
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        //set the target position for each motor
        frontLeftMotor.setTargetPosition(frontLeftMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH) + calibration);
        frontRightMotor.setTargetPosition(frontRightMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH));
        backLeftMotor.setTargetPosition(backLeftMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH) + calibration);
        backRightMotor.setTargetPosition(backRightMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH));

        //turns on run to position
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // reset the timeout time and start motion.
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(speed);
        backLeftMotor.setPower(speed);
        backRightMotor.setPower(speed);

        //keep looping while we are still active
        while (opModeIsActive() && frontLeftMotor.isBusy() && frontRightMotor.isBusy() && backLeftMotor.isBusy() && backRightMotor.isBusy()){
        }

        // Stop all motion;
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);

        // Turn off RUN_TO_POSITION
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //reverses the right motors
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    //straft robot right x inches with y speed
    public void straft(int inches, double speed) {

        int calibration = 10;
        //reverses the right motors
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        //set the target position for each motor
        frontLeftMotor.setTargetPosition(frontLeftMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH) + calibration);
        frontRightMotor.setTargetPosition(frontRightMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH) + calibration);
        backLeftMotor.setTargetPosition(backLeftMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH));
        backRightMotor.setTargetPosition(backRightMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH));

        //turns on run to position
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // reset the timeout time and start motion.
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(speed);
        backLeftMotor.setPower(speed);
        backRightMotor.setPower(speed);

        //keep looping while we are still active
        while (opModeIsActive() && frontLeftMotor.isBusy() && frontRightMotor.isBusy() && backLeftMotor.isBusy() && backRightMotor.isBusy()){
        }

        // Stop all motion;
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);

        // Turn off RUN_TO_POSITION
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //reverses the right motors
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }
    //turn robot right x degrees with y speed
    public void turn(int degrees, double speed) {

        //reverses the right motors
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        //sets degrees to values
        double inches = degrees * .21;

        //set the target position for each motor
        frontLeftMotor.setTargetPosition(frontLeftMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH));
        frontRightMotor.setTargetPosition(frontRightMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH));
        backLeftMotor.setTargetPosition(backLeftMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH));
        backRightMotor.setTargetPosition(backRightMotor.getCurrentPosition() + (int)(inches * COUNTS_PER_INCH));

        //turns on run to position
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        // reset the timeout time and start motion.
        frontLeftMotor.setPower(speed);
        frontRightMotor.setPower(speed);
        backLeftMotor.setPower(speed);
        backRightMotor.setPower(speed);

        //keep looping while we are still active
        while (opModeIsActive() && frontLeftMotor.isBusy() && frontRightMotor.isBusy() && backLeftMotor.isBusy() && backRightMotor.isBusy()){
        }

        // Stop all motion;
        frontLeftMotor.setPower(0);
        frontRightMotor.setPower(0);
        backLeftMotor.setPower(0);
        backRightMotor.setPower(0);

        // Turn off RUN_TO_POSITION
        frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        //reverses the right motors
        frontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeftMotor = hardwareMap.dcMotor.get(Properties.FRONT_LEFT_MOTOR);
        frontRightMotor = hardwareMap.dcMotor.get(Properties.FRONT_RIGHT_MOTOR);
        backLeftMotor = hardwareMap.dcMotor.get(Properties.BACK_LEFT_MOTOR);
        backRightMotor = hardwareMap.dcMotor.get(Properties.BACK_RIGHT_MOTOR);
        leftArm = hardwareMap.servo.get(Properties.LEFT_ARM);
        rightArm = hardwareMap.servo.get(Properties.RIGHT_ARM);
        waitForStart();
        autonomous();
    }
}

