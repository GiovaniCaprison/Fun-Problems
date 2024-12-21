Resource Hierarchy Solution:
Ensure that each philosopher picks up the chopsticks in a predefined order—either always starting from the lower numbered chopstick or the higher. For example, the philosopher can always pick the lower numbered chopstick first, then the higher. This way, one of the chopsticks will always be the last one picked up by any philosopher, preventing a cycle that would lead to a deadlock.

Arbitrator Solution:
Introduce an additional semaphore that acts as an arbitrator. This semaphore, often called a “waiter,” is used to limit the number of philosophers that can attempt to eat at the same time. Typically, this is set to allow N-1 philosophers (where N is the total number of philosophers) to pick up chopsticks at any one time.