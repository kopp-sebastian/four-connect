# Fourconnect
Rule: Game is won when 4 disks of one player are in a line<br/>
Rule: Only one piece is played at a time. <br />
Rule: The game ends when there is a 4-in-a-row or a stalemate.<br/>
Rule: Min # of player 2. Max # of player 5.<br/>
Rule: Adjust number size of board<br/>


### Acceptance Criteria

##### Scenario: Simple horizontal line
Given empty board
When player1 drops disks starting with col 0 up to col 3
And player2 drops his disks on top of disks from player1
Then after 4 rounds player1 has won the game

##### Scenario: Simple vertical line
Given empty board
When player1 drops disks always in col 0
And player2 drops his disks always in col 1
Then after 4 rounds player1 has won the game

##### Scenario: Simple diagonal line up
Given empty board
When player1 drops his disks in cols 0,1,3,2,3,3
And player2 drops his discs in cols 1,2,2,4,3
Then after 6 rounds player1 has won the game

##### Scenario: Simple diagonal line down
Given empty board
When player1 drops his disks in cols 0,0,3,0,1,2
And player2 drops his discs in cols 1,2,0,1,4
Then after 6 rounds player1 has won the game

##### Scenario: Reject invalid number of player
Given at app start a player gets asked about the number of players
When the player types in less than min# or more than max#
Then the player gets a warning
And the player is asked again.

##### Scenario Outline: Size of is changed based on number of players.
Given at app start a player gets asked about the number of players
When player enters <#players>
Then the boards layout will set to cols columns and rows rows
Examples:
| #players | cols | rows |
| 2        | 7    | 5    |