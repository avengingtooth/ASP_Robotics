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
public class RedoHang extends LinearOpMode {
  private DcMotor hang1;
  private DcMotor hang2;
  
  public void undo(){
    hang1.setPower(1);
    hang2.setPower(1);
  }

  @Override
  public void runOpMode() {
    hang1 = hardwareMap.get(DcMotor.class, "hang1");
    hang2 = hardwareMap.get(DcMotor.class, "hang2");

    // Put initialization blocks here.
    waitForStart();
    
    if (opModeIsActive()) {
      // Put run blocks here.
      undo();
      sleep(10000);
    }
  }
}
