package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Hardware;

@TeleOp(name = "Final TeleOp Joke", group = "TeleOps")
public class FinalTeleOpSmileyFace extends LinearOpMode {

    Hardware robot = new Hardware();

    @Override
    public void runOpMode() {

        boolean isReversed = false;

        double drive;
        double strafe;
        double turn;

        double frontLeftPower;
        double frontRightPower;
        double backLeftPower;
        double backRightPower;

        double carouselSpeed = 0.4;

        double max;
        double maxSpeed = 0.2;


        robot.initialize(hardwareMap);

        waitForStart();

        while (opModeIsActive()) {

            if (gamepad2.a){
                isReversed = true;
            }




            if (!isReversed) {
                drive = -gamepad1.left_stick_y;
                strafe = gamepad1.left_stick_x;
                turn = gamepad1.right_stick_x;
            }
            else{
                drive = -gamepad2.left_stick_y;
                strafe = gamepad2.left_stick_x;
                turn = gamepad2.right_stick_x;
            }

            frontLeftPower = drive + strafe + turn;
            frontRightPower = drive - strafe - turn;
            backLeftPower = drive - strafe + turn;
            backRightPower = drive + strafe - turn;

            if (Math.abs(frontLeftPower) > 1 || Math.abs(backLeftPower) > 1 || Math.abs(frontRightPower) > 1 || Math.abs(backRightPower) > 1) {
                max = Math.max(Math.abs(frontLeftPower), Math.abs(backLeftPower));
                max = Math.max(max, Math.abs(frontRightPower));
                max = Math.max(max, Math.abs(backRightPower));

                frontLeftPower /= max;
                frontRightPower /= max;
                backLeftPower /= max;
                backRightPower /= max;
            }

            robot.frontLeftMotor.setPower(frontLeftPower*maxSpeed);
            robot.frontRightMotor.setPower(frontRightPower*maxSpeed);
            robot.backLeftMotor.setPower(backLeftPower*maxSpeed);
            robot.backRightMotor.setPower(backRightPower*maxSpeed);


            if (!isReversed) {
                if (gamepad1.right_bumper) {
                    robot.carouselSpinner.setPower(carouselSpeed);
                } else if (gamepad1.left_bumper) {
                    robot.carouselSpinner.setPower(-carouselSpeed);
                } else {
                    robot.carouselSpinner.setPower(0);
                }

                if (gamepad1.left_trigger > 0.1) {
                    robot.intakeSpinner.setPower(gamepad1.left_trigger);
                } else if (gamepad1.right_trigger > 0.1) {
                    robot.intakeSpinner.setPower(-gamepad1.right_trigger);
                } else {
                    robot.intakeSpinner.setPower(0);
                }

                if (gamepad1.a) {
                    robot.intakeLifter.setPower(-0.65);
                } else if (gamepad1.y) {
                    robot.intakeLifter.setPower(0.75);
                } else {
                    robot.intakeLifter.setPower(0);
                }
            }
            else{
                if (gamepad2.right_bumper) {
                    robot.carouselSpinner.setPower(carouselSpeed);
                } else if (gamepad2.left_bumper) {
                    robot.carouselSpinner.setPower(-carouselSpeed);
                } else {
                    robot.carouselSpinner.setPower(0);
                }

                if (gamepad2.left_trigger > 0.1) {
                    robot.intakeSpinner.setPower(gamepad1.left_trigger);
                } else if (gamepad2.right_trigger > 0.1) {
                    robot.intakeSpinner.setPower(-gamepad1.right_trigger);
                } else {
                    robot.intakeSpinner.setPower(0);
                }

                if (gamepad2.a) {
                    robot.intakeLifter.setPower(-0.65);
                } else if (gamepad1.y) {
                    robot.intakeLifter.setPower(0.75);
                } else {
                    robot.intakeLifter.setPower(0);
                }
            }


            telemetry.addData("Driving: ", drive);    //sends data on forward power
            telemetry.addData("Strafing: ", strafe);   //sends data for strafing powers
            telemetry.addData("Turning: ", turn);    //sends data for turning powers
            telemetry.addData("frontRightMotor:", robot.frontRightMotor.getPower());
            telemetry.addData("frontLeftMotor", robot.frontLeftMotor.getPower());
            telemetry.addData("backRightMotor:", robot.backRightMotor.getPower());
            telemetry.addData("backLeftMotor", robot.backLeftMotor.getPower());
            telemetry.addData("Carousel Spinner Power", robot.carouselSpinner.getPower());
            telemetry.addData("Intake Spinner Power", robot.intakeSpinner.getPower());
            telemetry.addData("Intake Lifter Power", robot.intakeLifter.getPower());
            telemetry.update();
        }
    }
}















