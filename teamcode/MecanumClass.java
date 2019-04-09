package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Gamepad;

public class MecanumClass implements Runnable
{

    Gamepad gamepad1;

    DcMotor leftFront;
    DcMotor rightFront;
    DcMotor leftBack;
    DcMotor rightBack;

    public MecanumClass (Gamepad g1,DcMotor lF, DcMotor rF, DcMotor lB, DcMotor rB)
    {

        g1 = gamepad1;
        lF = leftFront;
        rF = rightFront;
        lB = leftBack;
        rB = rightBack;

    }

    void motor (DcMotor x, double spd)
    {

        //simple motor power

        x.setPower(spd);

    }

    void forward (DcMotor x)
    {

        //sets direction of motor to normal

        x.setDirection(DcMotor.Direction.FORWARD);

    }

    void reverse (DcMotor x)
    {

        //sets direction of motor to reverse

        x.setDirection(DcMotor.Direction.REVERSE);

    }

    //sets up the method for multi threads
    public void run()
    {

        //catches any errors
        try
        {

            //Gamepad 1 controls

            motor(leftFront, gamepad1.left_stick_y + gamepad1.right_stick_x);
            motor(rightFront, gamepad1.left_stick_y - gamepad1.right_stick_x);
            motor(leftBack, gamepad1.left_stick_y + gamepad1.right_stick_x);
            motor(rightBack, gamepad1.left_stick_y - gamepad1.right_stick_x);

        } catch (Exception e)
        {



        }

    }

    void forwards (double spd, int tic)
    {

        //moves forwards using the speed and ticks on the motors.

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setTargetPosition(tic);
        rightFront.setTargetPosition(tic);
        leftBack.setTargetPosition(tic);
        rightBack.setTargetPosition(tic);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFront.setPower(spd);
        rightFront.setPower(spd);
        leftBack.setPower(spd);
        rightBack.setPower(spd);

        while (leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy())
        {



        }

        kill();

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    void backwards (double spd, int tic)
    {

        //moves backwards at a select speed and tick value on motors

        leftFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightFront.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        leftBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        rightBack.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftFront.setTargetPosition(-tic);
        rightFront.setTargetPosition(-tic);
        leftBack.setTargetPosition(-tic);
        rightBack.setTargetPosition(-tic);

        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftFront.setPower(spd);
        rightFront.setPower(spd);
        leftBack.setPower(spd);
        rightBack.setPower(spd);

        while (leftFront.isBusy() && rightFront.isBusy() && leftBack.isBusy() && rightBack.isBusy())
        {



        }

        kill();

        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }

    void kill ()
    {

        motor(leftFront,  0);
        motor(rightFront, 0);
        motor(leftBack,   0);
        motor(rightBack,  0);

    }

}
