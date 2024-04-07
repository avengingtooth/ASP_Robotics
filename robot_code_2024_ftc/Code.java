package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DistanceSensor;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.CRServo;
import java.util.ArrayList;

@TeleOp

public class Code extends LinearOpMode{
    private DcMotor FL;
    private DcMotor FR;
    private DcMotor BR;
    private DcMotor BL;
    private CRServo clawClose;
    private CRServo cageClose;
    private DcMotor claw;
    private DcMotor arm;
    private double maxValue;
    private double maxClawPower;
    private double maxArmPower;
    private CRServo airplane;
    private boolean boolAirplane = false;
    private DcMotor hang1;
    private DcMotor hang2;

    @Override
    public void runOpMode() {
        hang1 = hardwareMap.get(DcMotor.class, "hang1");
        hang2 = hardwareMap.get(DcMotor.class, "hang2");
        FL = hardwareMap.get(DcMotor.class, "FL");
        FR = hardwareMap.get(DcMotor.class, "FR");
        BR = hardwareMap.get(DcMotor.class, "BR");
        BL = hardwareMap.get(DcMotor.class, "BL");
        clawClose = hardwareMap.get(CRServo.class, "clawClose");
        cageClose = hardwareMap.get(CRServo.class, "cageClose");
        claw = hardwareMap.get(DcMotor.class, "claw");
        arm = hardwareMap.get(DcMotor.class, "arm");
        airplane = hardwareMap.get(CRServo.class, "airplane");
        arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        maxValue = 0.7;
        maxClawPower = 0.5;
        maxArmPower = 0.5;
        
        waitForStart();
        while (opModeIsActive()) {
            central();
        }
    }
    
    public void move(double y, double x){
        double sideSpeed = 0.8;
        if(gamepad1.dpad_down){
            FR.setPower(-sideSpeed);
            FL.setPower(sideSpeed);
            BR.setPower(-sideSpeed);
            BL.setPower(sideSpeed);
        }
        else if(gamepad1.dpad_up){
            FR.setPower(sideSpeed);
            FL.setPower(-sideSpeed);
            BR.setPower(sideSpeed);
            BL.setPower(-sideSpeed);
        }
        if(gamepad1.dpad_left){
            FR.setPower(sideSpeed);
            FL.setPower(sideSpeed);
            BR.setPower(-sideSpeed);
            BL.setPower(-sideSpeed);
        }
        else if(gamepad1.dpad_right){
            FR.setPower(-sideSpeed);
            FL.setPower(-sideSpeed);
            BR.setPower(sideSpeed);
            BL.setPower(sideSpeed);
        }
        else{
            FL.setPower(-x * sideSpeed);
            BR.setPower(-y * sideSpeed);
            FR.setPower(-x * sideSpeed);
            BL.setPower(y * sideSpeed);
        }

    }
    
    public void updateClaw(){
        claw.setPower(gamepad1.right_stick_y * maxClawPower);
        if(gamepad1.right_bumper){
            clawClose.setPower(1);
        }
        else if (gamepad1.left_bumper){
            clawClose.setPower(-1);
        }
        if (gamepad1.right_trigger >= 0.5){
            cageClose.setPower(-1);
        }
        else if (gamepad1.left_trigger >= 0.5){
            cageClose.setPower(1);
        }
    }
    public void upArm(){
        while(arm.getCurrentPosition() > -470){
          arm.setPower(-0.6);
        }
        while(arm.getCurrentPosition() > -500){
          arm.setPower(0.01);
        }
        sleep(1000);
        arm.setPower(0);
    }
    

    public void downArm(){
        while(arm.getCurrentPosition() < -400){
            arm.setPower(0.6);
        }
        while(arm.getCurrentPosition() < -300){
            arm.setPower(0.4);
        }
        while(arm.getCurrentPosition() < -100){
            arm.setPower(-0.02);
        }
        arm.setPower(0);
    }

    public void updateArm(){
        if (gamepad1.triangle) {
            upArm();
        }
        if (gamepad1.cross){
            downArm();
        }
    }

    // gamepad 2
    public void checkAirplane(){
        if(gamepad1.circle){
            airplane.setPower(-1);
        }
        else{
            airplane.setPower(0);
        }
    }

    public void checkHang(){
        if(gamepad1.square){
            upArm();
            arm.setPower(-1);
            hang1.setPower(1);
            hang2.setPower(1);

        }
    }

    public void central(){
        double y = gamepad1.left_stick_y;
        double x = gamepad1.left_stick_x;
        
        move(y, x);
        updateClaw();
        updateArm();
        checkAirplane();
    }
}