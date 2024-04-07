# ASP FTC code documentation 2024

## Code.java
This was our controller code.

### Movements:
The joystick allowed up to move according to its position going forward when the joystick was pointed up. However unlike the omniwheels we could not go side ways on turn on spot.

Our omi-wheels were coded using the dpad.left and right in order to horizontally move left and right.

### Pixel collection:
We picked up pixels with our claw setting power to 1 or -1 in order to open and close it using the back left and right bumpers.

To avoid the servo overrotating we build a little Y under the claw so it forced the max position of the open claw.

To lift and drop the claw we used the y axis data off the left joystick setting the speed of the claw vertical movement to the value from -1 to 1 outputted by the joystick.


### Cage rotation:
The cage rotated upwards using the triangle button and down using the cross button. In order to avoid the cage slamming too agressively we powered the cage in the opposite direction it was going for a few seconds in order to slow in down so it would smoothly go up and down.

At the launch of the code we reset the encoder position to make sure position 0 is always at the start so the positions remain consistent.

### Cage opening:
The cage opened using the back triggers allowing us to drop pixels into the cage even though we didn't end up using the mechanic in games as the pixels were dropped too high.

### Airplane launcher:
The airplane launched by using the circle button which rotated a servo in order to release an elastic band which would fire the airplane. This was a press and hold button which meant we had to keep it pressed or the servo would return to its initial position blocking the elastic.

### Hanging mechanism
The hanging mechanism was activated by pressing the square button which caused to motors to roll up a string and the arm to press downwards on the bar we were attempting to hang on.

## Autonomous code

### AutoRight.java & AutoLeft.java
We loaded two pixels into our claw and then would use the omi-drive in order to move left or right depending on the side of the playing field we were on in order to then drop the claw and open it to place two pixels as well the robot into the backstage.

### RedoHang.java & UndoHang.java
These two codes allowed us to easily change how taught the string for the hang was without having to plug batteries into the motors to turn them manually.


## Camera

### Camera.java
Test code to try and understand how the camera data functions (Doesn't do anything but display when pixels are spotted)