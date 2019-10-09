package org.firstinspires.ftc.robotcontroller.internal;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

@Autonomous(name="moveLeftToPark")
public class moveLeft extends LinearOpMode {

    private DcMotor frontLeftMotor;
    private DcMotor frontRightMotor;
    private DcMotor backLeftMotor;
    private DcMotor backRightMotor;

    //Set up Variables
    static final double COUNTS_PER_MOTOR_REV    = 1120 ;
    static final double DRIVE_GEAR_REDUCTION    = 1 ;
    static final double WHEEL_DIAMETER_INCHES   = 3.25 ;
    static final double COUNTS_PER_INCH         =(COUNTS_PER_MOTOR_REV * DRIVE_GEAR_REDUCTION)/(WHEEL_DIAMETER_INCHES * Math.PI);

    //autonomous period
    public void autonomous() {
        forward(12,1);
    }

    //moves robot forward x inches with y speed
    public void forward(int inches, int speed) {

        //sets
        // the target position for each motor
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
        frontLeftMotor.setPower(Math.abs(speed));
        frontRightMotor.setPower(Math.abs(speed));
        backLeftMotor.setPower(Math.abs(speed));
        backRightMotor.setPower(Math.abs(speed));

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
    }

    @Override
    public void runOpMode() throws InterruptedException {
        frontLeftMotor = hardwareMap.dcMotor.get(Properties.FRONT_LEFT_MOTOR);
        frontRightMotor = hardwareMap.dcMotor.get(Properties.FRONT_RIGHT_MOTOR);
        backLeftMotor = hardwareMap.dcMotor.get(Properties.BACK_LEFT_MOTOR);
        backRightMotor = hardwareMap.dcMotor.get(Properties.BACK_RIGHT_MOTOR);
        waitForStart();
        autonomous();
    }
}

