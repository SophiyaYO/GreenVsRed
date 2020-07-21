# MENTORMATE DevCamp
---

## Rookie to Rockstar Full-Stack Intern
---

### First Assignment


<details>
<summary>Green vs. Red project /assignment description and requirements/</summary>

<br/>

Green vs Red is a game played on a 2D grid that in theory can be infinite (in our case we will assume 
that x <= y < 1 000)

Each cell on this grid can be either green (represented by 1) or red (represented by 0) The game always 
receives an initial state of the grid which we will call •Generation Zero'. After that a set of 4 rules are
applied across the grid and those rules form the next generation


Rules that create the next generation:
    1. Each red cell is surrounded by exactly 3 or exactly 6 green cells will also become green in 
the nod generation
    2. A red cell will stay red in the next generation if it has either O. 1, 2. 4. 5. 7 or 8 green 
neighbours.
    3. Each green cell surrounded by O. 1, 4. 5. 7 or 8 green neighbours will become red in the next 
generation
    4. A green cell MI stay green in the next generation if it has either 2. 3 or 6 green neighbours 


**Important facts:** 
    - Each cell can be surrounded by up to 8 cells 4 on the sides and 4 on the comers. Exceptions are the corners and the side of the grid.
    - All the 4 rules apply at the same time for the whole grid in order for the next generation to be formed

Your Task:
    Create a program that accepts:
    The size of our grid - x, y (x being the width and y being the height)
    Then the next y lines should contain strings (long x characters) created by Os and 1s which will 
represent the •Generation Zero' state and help us build the grid
    The last arguments to the program should be coordinates (x1 and y1) and the number N. 

(x1 and y1) will be coordinates of a cell in the grid We would like to calculate in how many generations 
from Generation Zero until generation N this cell was green. (The calculation should include generation 
Zero and generation N)

Print your result in the console.

Example1:
3x3 grid, in the initial state, the second row is all 1s. how many times will the cell (1. 0) (top center) 
become green in 10 turns?

3,3<br/>
000<br/>
111<br/>
000<br/>
1,0,10<br/>
expected result: 5 

Example2:
4x4 grid. Input: 

4,4<br/>
1001<br/>
1111<br/>
0100<br/>
1010<br/>
2,2,15<br/>
expected result: 14

</details>

## Programming language and frameworks

1. Programming language- Java EE.
    -  Java 8 Release;
    -  SDK 11.0.2;
2. IDE - IntelliJ  Platform.
3. VCS - Git.


## Solution

1. Classes:
    - [GreenVsRed.java](https://github.com/SophiyaYO/GreenVsRed/blob/master/src/main/java/GreenVsRed/GreenVsRed.java)
    - [Main.java](https://github.com/SophiyaYO/GreenVsRed/blob/master/src/main/java/GreenVsRed/Main.java)
    - 