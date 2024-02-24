Problem 2 strategy 2:

Advantages:
* Increases concurrency with threads being able to independently check available flag
* In the context of the problem, guests are prevented from being in the room at the same time. To be specific, this means that
  data interference issues are eliminated.

Disadvantages:
* Very slight increase in runtime with updating availabity flag
* Causes more randomization when it comes to allowing guests to see vase
* Increases runtime with synchronize statement
