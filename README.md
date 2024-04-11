[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/IPHBGZ6v)
# Assignment A1 - Maze Runner

  * **Student**: [Anam Khan](khana489@mcmaster.ca)
  * **Program**: B. Eng. In Software Engineering
  * **Course code**: SFWRENG 2AA4
  * **Course Title**: Software Design I - Introduction to Software Development 
  * Term: *Level II - Winter 2024*

## Business Logic Specification

This program explores a maze, finding a path from an entry point to an exit one.

- The maze is stored in a text file, with `#` representing walls and `␣` (_empty space_) representing passages.
- You’ll find examples of such mazes in the [`examples`](./examples) directory. 
    - You can also use the [Maze Generator](https://github.com/ace-lectures/maze-gen) to generate others.
- The Maze is surrounded by walls on its four borders, except for its entry/exit points.
    - Entry and exit points are always located on the East and West border.
    - The maze is not directed. As such, exit and entry can be interchanged.
- At the beginning of the exploration, we're located on the entry tile, facing the opposite side (e.g., if entering by the eastern entry, you're facing West).
- The program generates a sequence of instructions to reach the opposite exit (i.e., a "path"):
    - `F` means 'move forward' according to your current direction
    - `R` means 'turn right' (does not move, just change direction), and `L` means ‘turn left’. 
- A canonical path contains only `F`, `R` and `L` symbols
- A factorized path squashes together similar instructions (i.e., `FFF` = `3F`, `LL` = `2L`).
- Spaces are ignored in the instruction sequence (only for readability: `FFLFF` = `FF L FF`)
- The program takes as input a maze and print the path on the standard output.
    - For this assignment, the path does not have to be the shortest one.
- The program can take a path as input and verify if it's a legit one.

## How to run this software?

To build the program, simply package it with Maven:

```
khana489@AnamThinkpad A1-Template % mvn -q clean package 
```
### Delivered version

#### Command line arguments

The delivered program at the end of this assignment should use the following flags:

- `-i MAZE_FILE`: specifies the filename to be used;
- `-p PATH_SEQUENCE`: activates the path verification mode to validate that PATH_SEQUENCE is correct for the maze
- `-method {bfs, righthand}`: specifies which path computation method to use. (default is bfs)
- `-baseline {bfs, righthand}: specifies the baseline to execute benchmark mode

#### Examples

When no logs are activated, the programs only print the computed path on the standard output.

```
khana489@AnamThinkpad A1-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt
FFFF
khana489@AnamThinkpad A1-Template %
```

If a given path is correct, the program prints the message `correct path` on the standard output.

```
khana489@AnamThinkpad A1-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -p FFFF
correct path
khana489@AnamThinkpad A1-Template %
```

If a given path is incorrect, the program prints the message `incorrect path` on the standard output.

```
khana489@AnamThinkpad A1-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -p 3F
inccorrect path
khana489@AnamThinkpad A1-Template %
```

If running in benchmark mode, the program displays performance metrics

```
khana489@AnamThinkpad A1-Template % java -jar target/mazerunner.jar -i ./examples/straight.maz.txt -method righthand -baseline bfs
Time spent loading maze from file (in ms): 23.00
Time spent exploring the maze using the provided -method (in ms): 4.00
Time spent exploring the maze using the provided -baseline (in ms): 4.00
Improvement on the path as a speedup: 1.0
```

#### Sources
- Breadth First Search shortest path graph algorithm: Algorithms, 4th edition, by Robert Sedgewick and Kevin Wayne

#### Authors
- Anam Khan
- Alexandre Lachance (provided parts of starter code from: https://github.com/2AA4-W24/a1-solution)
