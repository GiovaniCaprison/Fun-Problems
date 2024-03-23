In the reality game show The Traitors there are 22 participants.
Initially, n participants are selected by the host Claudia Winkleman as traitors.

The remaining “faithful” participants have to figure out who the traitors are and banish them to win the game. 
Each night all remaining participants, traitors and faithful, vote to banish someone from the game. Whoever has the most votes is eliminated.

Subsequently, the traitors choose to “murder” one of the faithful each night. In this manner, 2 people are eliminated each night.

The game continues until there are only 2 people left. If they are both faithful, the faithful have won, otherwise the traitors have won.

This is a Monte Carlo simulation that calculates, given n traitors, the probability that the traitors will win.

We assume that the faithful are stupid and they always vote randomly.
We also assume that the traitors select one of the faithful randomly, and all of them vote for that same person. 
