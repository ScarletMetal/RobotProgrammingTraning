package com.spikes2212.robot;

import com.spikes2212.robot.commands.basic.CollectBalls;
import com.spikes2212.robot.commands.basic.MoveCrane;
import com.spikes2212.robot.commands.basic.Shoot;
import com.spikes2212.robot.subsystems.Crane;
import com.spikes2212.robot.subsystems.Feeder;
import com.spikes2212.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

public class OI /* GEVALD */ {

    private Joystick leftJoystick;
    private Joystick rightJoystick;

    private JoystickButton moveCraneUpButton;
    private JoystickButton shootButton;
    private JoystickButton collectBallsButton;

    public OI() {
        rightJoystick = new Joystick(0);
        leftJoystick = new Joystick(1);

        moveCraneUpButton = new JoystickButton(rightJoystick, 3);
        shootButton = new JoystickButton(leftJoystick, 1);
        collectBallsButton = new JoystickButton(leftJoystick, 2);

        initButtons();
    }

    private void initButtons() {
        moveCraneUpButton.whileHeld(new MoveCrane(Crane.CRANE_UP_SPEED));
        shootButton.whileHeld(new Shoot(Shooter.SHOOTING_SPEED));
        collectBallsButton.whileHeld(new CollectBalls(Feeder.FEEDER_SPEED));
    }

    private static double adjust(double val) {
        return val * Math.abs(val);
    }
    public double getLeftY() {
        return adjust(leftJoystick.getY());
    }

    public double getRightY() {
        return adjust(rightJoystick.getY());
    }
}
