# svitlana-shepotilova
n26

Test Plan added here. Only some fields were covered due to luck of time, should be expanded
https://docs.google.com/document/d/1S0IYipM7VpY7IOHYZwXvITIllT6YFKsYlNnE1bJ3Bm0/edit?usp=sharing

For automation i used simple libraries to create initial framework faster.
If i have more time i would add .pom file, implement logger, implement reports, add BDD style (cucumber, Jbehave ets)

I decided to cover only some functionality,  
AUTTest - Application under test test includs verification of correct behaviour after:
a) screen orientation
b) Correct state after return from background (this test fails)
c) possibility to swipe pages
Create Account test includes:
a) verification that account could be added and founded in Accounts when SAVE button clicked
b) verification that account could not be added and not founded in Accounts when X button clicked
Initial setup includes:
a) test Gnucash setup part of Application, verification of titles, fields and possibility to change options and select options

To Run test cline the folder, open as project in your IntelliJ IDEA or Eclipse
Start Appium Server
Start emulator (I use Genimotion Nexus 5 version 6)
To change emulator settings go to CoreTestCase and change capabilities

In project right click on tests folder -> run tests
Open emulator to see tests run




