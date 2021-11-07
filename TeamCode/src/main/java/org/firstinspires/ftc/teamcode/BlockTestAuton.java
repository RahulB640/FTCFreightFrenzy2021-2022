package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware;

@Autonomous(name="Block Test Auton", group="Auton")
public class BlockTestAuton extends LinearOpMode {

    Hardware robot = new Hardware();


    static final double CountesPerRevolution = 2240 ;    // eg: TETRIX Motor Encoder
    static final double DistancePerRevolution = 319.024 ;     // Circumferance in mm


    @Override
    public void runOpMode() {

        robot.initialize(hardwareMap);


        robot.frontLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backLeftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        robot.backRightMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        robot.frontLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.frontRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backLeftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        robot.backRightMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        int driveTicks = 975;
        int strafeTicks = 1000;
        int turnTicks = 750;
        int intakeSlackTime = 750;

        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        if (opModeIsActive()){
            telemetry.addData("Front Left Motor Encoder Position", robot.frontLeftMotor.getCurrentPosition());
            telemetry.addData("Front Right Motor Encoder Position", robot.frontRightMotor.getCurrentPosition());
            telemetry.addData("Back Left Motor Encoder Position", robot.backLeftMotor.getCurrentPosition());
            telemetry.addData("Back Right Motor Encoder Position", robot.backRightMotor.getCurrentPosition());
            telemetry.update();

            robot.frontLeftMotor.setTargetPosition(0);
            robot.frontRightMotor.setTargetPosition(0);
            robot.backLeftMotor.setTargetPosition(0);
            robot.backRightMotor.setTargetPosition(0);

            robot.frontLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.frontRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backLeftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            robot.backRightMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);

            robot.frontLeftMotor.setPower(0.8);
            robot.frontRightMotor.setPower(0.8);
            robot.backLeftMotor.setPower(0.8);
            robot.backRightMotor.setPower(0.8);

            //Goes forward 1 block
            robot.frontLeftMotor.setTargetPosition(driveTicks);
            robot.frontRightMotor.setTargetPosition(driveTicks);
            robot.backLeftMotor.setTargetPosition(driveTicks);
            robot.backRightMotor.setTargetPosition(driveTicks);
            sleep(5000);

            //Goes to the right 1
            robot.frontLeftMotor.setTargetPosition(robot.frontLeftMotor.getCurrentPosition() + strafeTicks);
            robot.frontRightMotor.setTargetPosition(robot.frontRightMotor.getCurrentPosition() - strafeTicks);
            robot.backLeftMotor.setTargetPosition(robot.backLeftMotor.getCurrentPosition() - strafeTicks);
            robot.backRightMotor.setTargetPosition(robot.backRightMotor.getCurrentPosition() + strafeTicks);
            sleep(5000);

            //goes clockwise 90 degrees
            robot.frontLeftMotor.setTargetPosition(robot.frontLeftMotor.getCurrentPosition() + turnTicks);
            robot.frontRightMotor.setTargetPosition(robot.frontRightMotor.getCurrentPosition() - turnTicks);
            robot.backLeftMotor.setTargetPosition(robot.backLeftMotor.getCurrentPosition() + turnTicks);
            robot.backRightMotor.setTargetPosition(robot.backRightMotor.getCurrentPosition() - turnTicks);
            sleep(5000);

            //Test intake Slack
            robot.intakeLifter.setPower(-0.65);
            sleep(intakeSlackTime);
            robot.intakeLifter.setPower(0);

        }

    }
}


