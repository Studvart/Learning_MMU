package DigitalArtifact_Refactored2_OOP;

public class Main {
    public static void main(String[] args) {

        // RUN Programme and create a new manager object.
        // Object is held in session only.
        Manager manager = new Manager();
        manager.processManager();
    }

    /*
    Checklist
    - Console output                       |    Yes
    - User input                           |    Yes
    - Selection (If, If-else, Switch)      |    Yes
    - Loops                                |    Yes
    - Methods                              |    Yes
    - Arrays                               |
    - Testing                              |
    - Objects                              |    Yes

    Code Features:                         |
    - Additional Features                  |    Additional Feature 1's completed.
    - Feature set 2                        |
    - Feature set 1                        |    Yes
    - Arrays, Testing                      |
    - Loops, Methods                       |    Yes
    - Selection                            |    Yes
    - Basic user input                     |    Yes

    Code Style:                            |
    - Self-directed code management        |
    - Appropriate package structure        |
    - Extensive comments                   |
    - Consistent indentation               |
    - Variables named appropriately        |    Yes

    Feature Set 1:
    Are at least 2 Implemented? -- Yes
    - A Data Object                        |    Yes - See Customer and Product Class'
    - File Input                           |    Yes - See ReadFile Class
    - File Output                          |    Yes - See WriteFile Class
    - Custom Exceptions                    |    Yes - See InvalidPolicyNumberException
    - User friendly UI                     |    Yes - See try-catch in ReadFile and do-while in Customer and .toLowerCase() in process manager.

    Feature Set 2:
    Are at least 2 Implemented? -- No
    - Encapsulation                        |    TBC - Likely
    - Abstract Classes or Interfaces       |    TBC - Likely
    - Inheritance                          |    TBC - Likely
    - Streams API                          |    No
    - GUI                                  |    Not Likely
    - Software Architecture/Design Patterns|    No

     */

}
