# Sorted Array — Practice: Build a Leaderboard

One practice problem: build a `Leaderboard`, a bounded, always-sorted
top-`k` high-score table, reusing the chapter's binary search and shifting.

## Prerequisites

- JDK 17+

## Repository layout

```plaintext
code/
  README.md
  .gitignore
  src/
    main/
      practice/
        Leaderboard.java    # a bounded, always-sorted high-score table
        PracticeMain.java   # a small demo of the practice solution
  scripts/
    run.sh                  # compile everything and run the practice demo
```

## How to compile and run

- `scripts/run.sh` — compiles all source into `out/` and runs the
  `PracticeMain` demo.

There is no build tool and no test suite: testing is introduced later in the
course. The script above is all you need.

## What's here

- `practice.Leaderboard<T extends Comparable<T>>` — a fixed-capacity
  leaderboard that keeps only the `k` largest elements it has ever been
  offered, in sorted order. It reimplements the insertion-point binary search
  and the shift-based `add` from the chapter, so it has no dependency on the
  chapter's own code and compiles and runs on its own.
- `practice.PracticeMain` — a runnable demo that feeds the board a jumbled
  sequence of scores and prints it after each `add`.
