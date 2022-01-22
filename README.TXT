------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Game Show Night

PURPOSE OF PROJECT: ICS4U Final Project Submission

VERSION or DATE: January 21, 2022

HOW TO START THIS PROJECT: Player would use the mouse to interact with 
buttons in the game.

AUTHORS: Melanie, Grace

DATA STRUCTURES:
1. Array in Title World: boolean[] gamesPlayed -> used in HangMan,
Jackpot, MemoryGame, RockPaperScissor, and Shop worlds
2. HashMap in Shop World: <ShopItem,Integer>items
3. ArrayList in Shop World: boughtItems
4. Arrays in MemoryGame World: Card[] cards & Card[] activeCards
5. 2D array in Jackpot World: GreenfootImage[][] spinner
6. Array in Inventory World: int[] prices
7. HashMap in Inventory World: itemImg
8. ArrayList in Inventory World: items
9. ArrayList in HangMan World: listOfWords
10. Array in HangMan World: letters
11. Array in Card Actor: images

SORTING METHOD:
Merge sort in MergeSort class, used in Inventory when sorting bought
item prices in an array

RECURSION: 
Merge sort in MergeSort class, used in Inventory when sorting bought
item prices in an array

CHEAT:
In Shop world, press SPACE to earn 100 Golden Tickets. There is only
one chance.