# MENTORMATE DevCamp
---

## Rookie to Rockstar Full-Stack Intern
---

### First Assignment


## Changed the program with full Object-oriented principles

<details>
<summary>What has changed? Read more here/</summary>
<br/>

- added 4 more classes
- 1 is Abstract : class Cell
- class RedCell and class GreenCell inherit class Cell, better polymorphism
- class Board is initializing and implementing the game options and takes care to operate simultaneously with Red and Green classes
- class Game has object Board and takes care of the new generations, also plays by using the Board methods

With this refactoring of the code I am trying to achieve better encapsulation, abstraction, inheritance and polymorphism
</details>


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

<details>
<summary>Programming language and frameworks</summary>

<br/>

1. Programming language- Java EE.
    -  Java 8 Release;
    -  SDK 11.0.2;
2. IDE - IntelliJ  Platform.
3. VCS - Git.
</details>


<details>
<summary>Solution</summary>

<br/>

I. Classes:<br/>
    - [GreenVsRed.java](https://github.com/SophiyaYO/GreenVsRed/blob/master/src/main/java/GreenVsRed/GreenVsRed.java)<br/>
    - [Main.java](https://github.com/SophiyaYO/GreenVsRed/blob/master/src/main/java/GreenVsRed/Main.java)<br/>
    - [Exceptions](https://github.com/SophiyaYO/GreenVsRed/tree/master/src/main/java/GreenVsRed/Exceptions)<br/>
        - [ArrayIndexOutOfBoundsException.java](https://github.com/SophiyaYO/GreenVsRed/blob/master/src/main/java/GreenVsRed/Exceptions/ArrayIndexOutOfBoundsException.java)<br/>
        - [IOException.java](https://github.com/SophiyaYO/GreenVsRed/blob/master/src/main/java/GreenVsRed/Exceptions/IOException.java)<br/>
        - [InputMismatchException.java](https://github.com/SophiyaYO/GreenVsRed/blob/master/src/main/java/GreenVsRed/Exceptions/InputMismatchException.java)<br/>
        - [InvalidNumberException.java](https://github.com/SophiyaYO/GreenVsRed/blob/master/src/main/java/GreenVsRed/Exceptions/InvalidNumberException.java)<br/>
        - [NumberFormatException.java](https://github.com/SophiyaYO/GreenVsRed/blob/master/src/main/java/GreenVsRed/Exceptions/NumberFormatException.java)<br/>
       
 1. GreenVsRed 
    - class GreenVsRed
        - encapsulation:
            - private for all not allowed outside 
            - protected 
        - *for more information on how the code works, please check the comment in the code*
     
    - class Main- where code is invoke and run
        - imports custom Exception classes - from GreenVsRed\src\main\java\GreenVsRed\Exceptions    
        - use try - catch block to check for errors while executed
        - isInScope(...) - check if given number is in exact scope
        - mapInput(...) - read from user input from console, parse to integers and maps in array.<br/> In addition throws exception
   
    - dir Exceptions
        - ArrayIndexOutOfBoundsException - throws custom message if index is out of array scope
        - IOException - input/output custom exception
        - InputMismatchException - not in use for now/ deprecated
        - InvalidNumberException - throws custom message if input is not integer as required
        - NumberFormatException - throws custom message if input is not a number and/or does not contain "," or "" as separator
    </details>   