## google中国编程挑战赛模拟题 -- DrawLines (250分)

#### Problem Statement

A simple line drawing program uses a blank 20 x 20 pixel canvas and a directional cursor that starts at the upper left corner pointing straight down. 
The upper left corner of the canvas is at (0, 0) and the lower right corner is at (19, 19). You are given a String[], commands, each element of which 
contains one of two possible commands. A command of the form "FORWARD x" means that the cursor should move forward by x pixels. Each pixel on its path,
including the start and end points, is painted black. The only other command is "LEFT", which means that the cursor should change its direction by 90 
degrees counterclockwise. So, if the cursor is initially pointing straight down and it receives a single "LEFT" command, it will end up pointing straight
to the right. Execute all the commands in order and return the resulting 20 x 20 pixel canvas as a String[] where character j of element i represents 
the pixel at (i, j). Black pixels should be represented as uppercase 'X' characters and blank pixels should be represented as '.' characters.
Definition
    
Class:
DrawLines
Method:
execute
Parameters:
String[]
Returns:
String[]
Method signature:
String[] execute(String[] commands)
(be sure your method is public)
    

Notes
-
The cursor only paints the canvas if it moves (see example 1).
Constraints
-
commands will contain between 1 and 50 elements, inclusive.
-
Each element of commands will be formatted as either "LEFT" or "FORWARD x" (quotes for clarity only), where x is an integer between 1 and 19,
 inclusive, with no extra leading zeros.
-
When executing the commands in order, the cursor will never leave the 20 x 20 pixel canvas.
Examples
0)

    
{"FORWARD 19", "LEFT", "FORWARD 19", "LEFT", "FORWARD 19", "LEFT", "FORWARD 19"}
Returns: 
{"XXXXXXXXXXXXXXXXXXXX",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "X..................X",
 "XXXXXXXXXXXXXXXXXXXX" }
This sequence of commands draws a 20 x 20 outline of a square. The cursor is initially at (0, 0) pointing straight down.
It then travels to (0, 19) after the first FORWARD command, painting each pixel along its path with a '*'. 
It then rotates 90 degrees left, travels to (19, 19), rotates 90 degrees left, travels to (19, 0), rotates 90 degrees left,
and finally travels back to (0, 0).
1)

    
{"LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT", "LEFT"}
Returns: 
{"....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "...................." }
The cursor spins round and round, but never actually paints any pixels. The result is an empty canvas.
2)

    
{"FORWARD 1"}
Returns: 
{"X...................",
 "X...................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "....................",
 "...................." }
Going forward by one pixel creates a line that is 2 pixels long because both the start and end points are painted.
3)

    
{"LEFT", "FORWARD 19", "LEFT", "LEFT", "LEFT",
 "FORWARD 18", "LEFT", "LEFT", "LEFT", "FORWARD 17",
 "LEFT", "LEFT", "LEFT", "FORWARD 16", "LEFT",
 "LEFT", "LEFT", "FORWARD 15", "LEFT", "LEFT", "LEFT",
 "FORWARD 14", "LEFT", "LEFT", "LEFT", "FORWARD 13",
 "LEFT", "LEFT", "LEFT", "FORWARD 12", "LEFT", "LEFT",
 "LEFT", "FORWARD 11", "LEFT", "LEFT", "LEFT", "FORWARD 10",
 "LEFT", "LEFT", "LEFT", "FORWARD 9", "LEFT", "LEFT",
 "LEFT", "FORWARD 8", "LEFT", "LEFT", "LEFT", "FORWARD 7"}
Returns: 
{"XXXXXXXXXXXXXXXXXXXX",
 "...................X",
 "..XXXXXXXXXXXXXXXX.X",
 "..X..............X.X",
 "..X.XXXXXXXXXXXX.X.X",
 "..X.X..........X.X.X",
 "..X.X.XXXXXXXX.X.X.X",
 "..X.X.X........X.X.X",
 "..X.X.X........X.X.X",
 "..X.X.X........X.X.X",
 "..X.X.X........X.X.X",
 "..X.X.X........X.X.X",
 "..X.X.X........X.X.X",
 "..X.X.X........X.X.X",
 "..X.X.XXXXXXXXXX.X.X",
 "..X.X............X.X",
 "..X.XXXXXXXXXXXXXX.X",
 "..X................X",
 "..XXXXXXXXXXXXXXXXXX",
 "...................." }

This problem statement is the exclusive and proprietary property of TopCoder, Inc. Any unauthorized use or reproduction of this information 
without the prior written consent of TopCoder, Inc. is strictly prohibited. (c)2003, TopCoder, Inc. All rights reserved.