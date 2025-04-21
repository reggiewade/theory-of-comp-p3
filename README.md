# Turing Machine Simulator

## Authors
- Vladyslav (Vlad) Maliutin
- Reggie Wade

## Overview
This project implements a **bi-infinite deterministic Turing Machine simulator** in Java. It reads a machine definition and input string from a file, simulates execution on a bi-directional tape, and prints the resulting content of the visited tape cells. The machine halts upon reaching the designated halting state.

## Files Included
- `TMSimulator.java` — The main class to execute the simulation.
- `TM.java` — Core class for managing states, transitions, and machine logic.
- `TMState.java` — Represents an individual Turing Machine state with transition mappings.
- `Transition.java` — Represents a transition between states including direction and symbol to write.
- `Tape.java` — Simulates the infinite tape with head movement, reading, and writing.
- `README.md` — This documentation file.

## Features Implemented

- **Bi-infinite Tape Simulation**  
  The tape supports infinite movement in both left and right directions using a `HashMap` to dynamically store visited cells.

- **Deterministic Transition Handling**  
  Each state processes exactly one transition per symbol, enforcing deterministic behavior.

- **TM Configuration Parser**  
  The program reads Turing Machine definitions from a file including state count, input alphabet, transitions, and input string.

- **State and Transition Management**  
  Clean object-oriented modeling of states (`TMState`) and transitions (`Transition`) to maintain modularity.

- **Blank Symbol Support (`0`)**  
  The blank symbol (`0`) is automatically included in the tape alphabet and treated as the default symbol.

- **Halting Detection**  
  The simulator halts upon reaching the final (highest-numbered) state as defined by the TM specification.

- **Output of Visited Tape Content**  
  Only visited (non-default) tape cells are printed, representing the effective result of TM execution.

- **Edge Case Handling**  
  Supports both non-empty and ε (empty) inputs, including machines that halt immediately.

- **Efficient Execution**  
  Optimized data structures (like `LinkedHashMap`, `HashMap`, `Set`) are used to ensure fast lookup and low overhead for large simulations.

## Reflection

Working on this Turing Machine simulator helped reinforce our understanding of automata theory and low-level computation models. By breaking down the simulation into clearly defined classes like `TM`, `TMState`, and `Tape`, we got to apply core object-oriented principles in a meaningful way.

One of the most interesting parts was designing the tape as a bi-infinite structure using a `HashMap`. It challenged our usual thinking around fixed-size arrays and made us think about dynamic memory access patterns. Parsing the input file and ensuring transitions were correctly assigned based on their position in the file also required careful logic.

Debugging transitions and verifying correct halting behavior gave us good experience with edge cases and off-by-one indexing—things that can easily go wrong in simulations like this. In the end, it was satisfying to see the Turing Machine halt and print the right output.

This project also gave us insight into how theoretical models like TMs can be implemented in code, bridging the gap between abstract CS concepts and real-world programming.


## Compilation Instructions
Make sure all `.java` files are in the same directory. Then compile with:
```bash
javac *.java
