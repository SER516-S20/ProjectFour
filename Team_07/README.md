# Team 07

## How to run
```sh
$ cd Team_07/src ; javac MainFrame.java ; java MainFrame
```
## Burndown Chart
<img src="Burndown Chart.png"
     alt="Burndown Chart"
     style="float: left; margin-right: 10px;" />

## Sprint Review
- What did we do?
  - Fixed existing bugs from previous Project/Sprint
  - Completed all the product backlog items
  - Finished the basic features ahead of the deadline
- What could be better?
  - Application could have been optimized more for better performance
  - Team communication
- What will we do?
  - Extensively test our application for bugs
  - Fix any bugs if found during testing

## Sprint Retrospective
- What did we do well?
  - Worked on the project design and structure before starting to code
  - GUI looks pretty good
  - Followed good coding standards
  - Used appropriate design patterns
  - Proper code cleaning was done and good coding structure was maintained
- What should we have done better?
  - Could have increased the performance of the application
  - Lack of planning lead to some rework during the sprint
  - Knowledge acquisition's estimation
- What should we start doing?
  - Should start using multithreading for better performance
  - Assigning related user stories to same person
  - Assigning user stories depending on the expertise of the person
  - Better estimation for each task
- What should we stop doing?
  - Starting to code before knowledge acquisition
  - Reworking on the same thing for efficiency too early before integration
- What should we keep doing?
  - Code clean up and unit testing after each major task
  - Applying appropriate design principles 
  - Try to increase the performance of the application

## Product Backlog
|  **No.** | **User Stories** | **Acceptance Criteria** | **Status** | **Effort** | **Author** |
| --- | --- | --- | --- | --- | --- |
|  1 | As a user, I want a main window with three panels - top panel, right tabbed panel, and left panel. | Main Window is resizable. | Completed | 3 | Karandeep |
|  2 | As a user, I want a top panel that will contain various buttons. | Contains the buttons - Open, Save, New Tab & Compile | Completed | 3 | Karandeep |
|  3 | As a user, I want an "open" button in the top panel that I can open a saved workspace file. | 1. User can browse the system and open the file<br/>2. Tabs are loaded in the same order.<br/>3. Operators in the tabs have all the functionality and values (stored with input popup) | Completed | 5 | Praveen |
|  4 | As a user, I want a "save" button so that I can save the current workspace instance. | 1. User can browse the system and save the file<br/>2. Tabs are saved in the same order.<br/>3. Operators and Connections in the tabs are saved successfully.<br/>4. Operator values (stored with input popup) should be also saved | Completed | 5 | Praveen |
|  5 | As a user, I want a "new tab" button so that I can create a new tab in the right tabbed panel. | 1. New tab is created.<br/>2. Tab number is correct. | Completed | 3 | Aditya |
|  6 | As a user, I want a "compile" button so that I can check if the current tab's operators and connections are following all the rules. | Checks all the following rules:<br/>1. Every connector of each operator should be connected.<br/>2. The "@" operator should have a loop from any one output connector to any one input connector.<br/>3. There should be only one "(" operators in each tab.<br/>4. There should be only one ")" operator in each tab. | Completed | 8 | Karandeep |
|  7 | As a user, I want a left panel that contains all the operators so that I can select any of the operators in the left panel and create the same in the right panel. | 1. User can select any operator.<br/>2. There should be some graphical element showing the currently selected operator. | Completed | 5 | Karandeep |
|  8 | As a user, I want a right tabbed panel so that I can have multiple tabs to work. | 1. User is able to create new tabs.<br/>2. No two tabs affect each other.<br/>3. User should be able to create operators in the current tab by clicking in the tab. | Completed | 3 | Karandeep |
|  9 | As a user, I want a "(" operator in the left panel that has one connector dot on its right. | 1. User can drag the shapes.<br/>2. User can double click the shape to enter a string value | Completed | 2 | Arvind |
|  10 | As a user, I want a ")" operator in the left panel that has one connector dot on its left. | 1. User can drag the shapes.<br/>2. User can double click the shape to enter a string value | Completed | 2 | Arvind |
|  13 | As a user, I want a "<" operator in the left panel that has two connector dots on its right and one connector dot on its left. | 1. User can drag the shapes.<br/>2. User can double click the shape to enter a string value | Completed | 2 | Arvind |
|  14 | As a user, I want a "<" operator in the left panel that has two connector dots on its right and one connector dot on its left. | 1. User can drag the shapes.<br/>2. User can double click the shape to enter a string value | Completed | 2 | Arvind |
|  12 | As a user, I want a "@" operator in the left panel that has two connector dots on its right and two connector dots on its left | 1. User can drag the shapes.<br/>2. User can double click the shape to enter a string value | Completed | 5 | Praveen |
|  15 | As a user, I want a "&#124; &#124;" operator in the left panel that has one connector bar on its right and one connector bar on its right. | 1. User can drag the shapes.<br/>2. User can double click the shape to enter a string value | Completed | 2 | Arvind |
|  11 | As a user, I want a "-" operator in the left panel that has one connector dot on its right and another connector on its left. | 1. User can drag the shapes.<br/>2. User can double click the shape to enter a string value | Completed | 2 | Arvind |
|  19 | As a user, I want to connect two connector dots with a line by clicking on them | 1. Each dot must have only one connection.<br/>2. The line should be directed from the firstly clicked dot to the other dot | Completed | 5 | Aditya |
|  20 | As a user, I want to connect two connector bars with a line by clicking on them | 1. Each bar can have multiple connections.<br/>2. The line should be directed from the firstly clicked bar to the other bar. | Completed | 5 | Aditya |
|  21 | As a user, I want a input popup when I double click on any operator so that I can input and store a string value in that operator | 1. Every operator should store the value given as input by user | Completed | 3 | Karandeep |
|  22 | As a user, I want to connect a bar and dot with a line by clicking on them | 1. Each bar can have multiple connections. <br/>2. Each dot must have only one connection.<br/>3. The line should be directed from the firstly clicked bar to the other bar. | Completed | 5 | Aditya |

### Authors
- Aditya Bajaj
- Aravind Thillai Villalan
- Karandeep Singh Grewal
- Praveen Kumar P
