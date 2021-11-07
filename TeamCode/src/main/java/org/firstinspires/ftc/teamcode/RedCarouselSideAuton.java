/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.Hardware;

@Autonomous(name="Basic Red Auton for First Meet", group="Auton")
public class RedCarouselSideAuton extends LinearOpMode {

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




        // Wait for the game to start (driver presses PLAY)
        waitForStart();


        if (opModeIsActive()){
            telemetry.addData("Front Left Motor Encoder Position", robot.frontLeftMotor.getCurrentPosition());
            telemetry.addData("Front Right Motor Encoder Position", robot.frontRightMotor.getCurrentPosition());
            telemetry.addData("Back Left Motor Encoder Position", robot.backLeftMotor.getCurrentPosition());
            telemetry.addData("Back Right Motor Encoder Position", robot.backRightMotor.getCurrentPosition());
            telemetry.update();


            robot.intakeLifter.setPower(-0.8);
            sleep(1000);
            robot.intakeLifter.setPower(0);

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

            robot.frontLeftMotor.setTargetPosition(750);
            robot.frontRightMotor.setTargetPosition(750);
            robot.backLeftMotor.setTargetPosition(750);
            robot.backRightMotor.setTargetPosition(750);
            sleep(500);
            robot.frontLeftMotor.setTargetPosition(700);
            robot.frontRightMotor.setTargetPosition(700);
            robot.backLeftMotor.setTargetPosition(700);
            robot.backRightMotor.setTargetPosition(700);

            robot.frontLeftMotor.setTargetPosition(1500);
            robot.frontRightMotor.setTargetPosition(0);
            robot.backLeftMotor.setTargetPosition(0);
            robot.backRightMotor.setTargetPosition(1500);
            sleep(500);
            robot.intakeSpinner.setPower(-0.8);
            sleep(1000);
            robot.intakeSpinner.setPower(0);

            robot.frontLeftMotor.setTargetPosition(-1500);
            robot.frontRightMotor.setTargetPosition(250);
            robot.backLeftMotor.setTargetPosition(1000);
            robot.backRightMotor.setTargetPosition(-750);
            sleep(1000);









        }

    }
}


