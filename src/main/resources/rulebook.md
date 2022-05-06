Rule: Game is won when 4 disks of one player are in a line

Scenario: Simple horizontal line
Given empty board
When player1 drops disks starting with col 0 up to col 3
And player2 drops his disks on top of disks from player1
Then after 4 rounds player1 has won the game

Scenario: Simple vertical line
Given empty board
When player1 drops disks always in col 0
And player2 drops his disks always in col 1
Then after 4 rounds player1 has won the game

Scenario: Simple diagonal line up
Given empty board
When player1 drops his disks in cols 0,1,3,2,3,3
And player2 drops his discs in cols 1,2,2,4,3
Then after 6 rounds player1 has won the game

Scenario: Simple diagonal line down
Given empty board
When player1 drops his disks in cols 0,0,3,0,1,2
And player2 drops his discs in cols 1,2,0,1,4
Then after 6 rounds player1 has won the game