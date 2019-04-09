package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

public class Drive extends OpMode
{

    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;

    MecanumClass mC;

    Thread movementT;

    @Override
    public void init()
    {

        //classifies the variables
        leftFront = hardwareMap.dcMotor.get("leftFront");
        rightFront = hardwareMap.dcMotor.get("leftFront");
        leftBack = hardwareMap.dcMotor.get("leftFront");
        rightBack = hardwareMap.dcMotor.get("leftFront");

        mC = new MecanumClass(gamepad1, leftFront, rightFront, leftBack, rightBack);

        movementT = new Thread(new MecanumClass(gamepad1, leftFront, rightFront, leftBack, rightBack));

        //stops everything
        mC.kill();

    }

    @Override
    public void start()
    {

        //stops everything
        mC.kill();

    }

    @Override
    public void loop()
    {

        //starts the movement thread
        movementT.start();

    }

    @Override
    public void stop()
    {

        //stops everything
        mC.kill();

    }

}
