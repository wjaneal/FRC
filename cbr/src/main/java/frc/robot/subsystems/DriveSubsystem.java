/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
  import edu.wpi.first.wpilibj.drive.*;
  import edu.wpi.first.wpilibj.SpeedControllerGroup;
  import edu.wpi.first.wpilibj.XboxController;
  
  //import edu.wpi.first.wpilibj.ADXRS450_Gyro;
  //import edu.wpi.first.wpilibj.Encoder;

public class DriveSubsystem extends SubsystemBase{
  /**
   * Creates a new driveSubsystem.
   */

  
  
  WPI_TalonSRX rightFront;
  WPI_TalonSRX rightBack;
  WPI_TalonSRX leftFront;
  WPI_TalonSRX leftBack;
  //Encoder EC1;
  //Encoder EC2;
  //ADXRS450_Gyro gyro;
  SpeedControllerGroup motorGroupLeft;
  SpeedControllerGroup motorGroupRight;
  DifferentialDrive m_drive;

  
 
  public DriveSubsystem() {
    // Initialize motors (competition robot)
   final WPI_TalonSRX rightFront = new WPI_TalonSRX(4);
   final WPI_TalonSRX rightBack = new WPI_TalonSRX(3);
   final WPI_TalonSRX leftFront = new WPI_TalonSRX(2);
   final WPI_TalonSRX leftBack = new WPI_TalonSRX(1);

  // This initializes the Encoders - two encoders at the base
  //Encoder EC1,EC2;
  //final Encoder EC1 = new Encoder(0, 1, false, Encoder.EncodingType.k1X); // encoder at the base
  //final Encoder EC2 = new Encoder(2, 3, false, Encoder.EncodingType.k1X); // encoder at the base

  //gyro
   //final ADXRS450_Gyro gyro = new ADXRS450_Gyro();

  //SpeedControllerGroup for arcade drive
  SpeedControllerGroup motorGroupLeft = new SpeedControllerGroup(leftFront, leftBack);
  SpeedControllerGroup motorGroupRight = new SpeedControllerGroup(rightFront, rightBack);
  m_drive = new DifferentialDrive(motorGroupLeft, motorGroupRight);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeedDrive(XboxController controller, double speed){
    m_drive.arcadeDrive(controller.getRawAxis(1)*speed,controller.getRawAxis(0)*speed);
  }
}
