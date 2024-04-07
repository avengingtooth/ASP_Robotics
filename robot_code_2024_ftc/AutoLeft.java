package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DistanceSensor;

import java.util.ArrayList;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@Autonomous
public class AutoLeft extends LinearOpMode {
  private DistanceSensor distance1;
  private DistanceSensor distance2;
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
  private ArrayList <double []> path;
  private CRServo airplane;
  private boolean boolAirplane = false;
  private double maxArmPower = 0.8;
  public double robotSpeed = 0.5;
    
  public void resetMotors(){
    FR.setPower(0);
    FL.setPower(0);
    BR.setPower(0);
    BL.setPower(0);
  }

  public void clawDown(){
    claw.setPower(0.3);
    sleep(100);
    claw.setPower(0.2);
  }

  public void clawUp(){
    claw.setPower(-0.3);
  }

  public void updateClaw(){
    clawUp();
    clawClose.setPower(1);
    sleep(2000);
    clawDown();
    
  }

  public void closeHatch(){
    cageClose.setPower(-1);
  }

  public void openHatch(){
    cageClose.setPower(1);
  }
  
  public void upArm(){
    while(arm.getCurrentPosition() > -470){
      telemetry.addData("s", arm.getCurrentPosition());
      telemetry.update();
      arm.setPower(-0.6);
    }
    while(arm.getCurrentPosition() > -500){
      telemetry.addData("s", arm.getCurrentPosition());
      telemetry.update();
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

  public void moveLeft(){
    FR.setPower(-robotSpeed);
    FL.setPower(-robotSpeed);
    BR.setPower(robotSpeed);
    BL.setPower(robotSpeed);
  }

  public void moveRight(){
    FR.setPower(robotSpeed);
    FL.setPower(robotSpeed);
    BR.setPower(-robotSpeed);
    BL.setPower(-robotSpeed);
  }

  public void moveForward(){
    FR.setPower(-robotSpeed);
    FL.setPower(robotSpeed);
    BR.setPower(-robotSpeed);
    BL.setPower(robotSpeed);
  }

  public void moveBackWards(){
    FR.setPower(robotSpeed);
    FL.setPower(-robotSpeed);
    BR.setPower(robotSpeed);
    BL.setPower(-robotSpeed);
  }

  public void moveTo(int frontDistance){
      double robotSpeed = 0.4;
      // move forward
      while (frontDistance < distance1.getDistance(DistanceUnit.CM)) {
        moveForward();
      }
      
      // move back
      while (frontDistance > distance1.getDistance(DistanceUnit.CM)) {
        moveBackWards();
      }
      resetMotors();
  }

  @Override
  public void runOpMode() {
    distance1 = hardwareMap.get(DistanceSensor.class, "distance1");
    distance2 = hardwareMap.get(DistanceSensor.class, "distance2");
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
    arm.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    arm.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

    // Put initialization blocks here.
    waitForStart();
    
    if (opModeIsActive()) {
      // Put run blocks here.
      moveRight();
      sleep(2100);
      resetMotors();
      clawDown();
      sleep(2000);
      clawClose.setPower(1);
      sleep(2000);
    }
  }
}
