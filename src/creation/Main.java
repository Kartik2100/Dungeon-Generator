package creation;

import dnd.models.Treasure;
import java.util.Scanner;
import dnd.models.ChamberShape;
import dnd.models.ChamberContents;
import dnd.models.Exit;
import dnd.models.Monster;
import dnd.models.Stairs;
import dnd.models.Trap;
import dnd.exceptions.NotProtectedException;
import dnd.exceptions.UnusualShapeException;


/**
 * This is the main class of the program.
 * The main class is based off the information of the D&D game.
 */
public class Main {

    /**
    * This is the main method.
    * It calls classes that are imported and uses them to create a generator.
    * There are four main stages of this main method which are treasure, shape, contents and full generator.
    * (1)The treasure  part calls gets the treasure contents and where its store with sometype of protection.
    * (2)The shape part gets the shape of size of the chamber as well as the exits.
    * (3)The contents gets what is in the chamber (monster, stair, trap, treasure, or nothing).
    * (4)The full generator prints out a whole generated chamber either randomly or by inputing the dice rolls.
    *@param args is arguments from the command line that is in an array of strings
    */
    public static void main(String[] args) {

        // creating objects for classes
        Treasure treasure = new Treasure();
        ChamberShape chamberShape = new ChamberShape();
        ChamberContents chamberContents = new ChamberContents();
        Exit exit = new Exit();
        Monster monster = new Monster();
        Stairs stairs = new Stairs();
        Trap trap = new Trap();

        Scanner scan = new Scanner(System.in);
        // printing out the menu
        System.out.println("***Welcome to random dungeon generator for D&D***");
        System.out.println("Please type in the number(1-4) for which function you choose to do.");
        System.out.println("1.  Treasure");
        System.out.println("2.  Size and shape of chamber");
        System.out.println("3.  Contents of the chamber");
        System.out.println("4.  Generate entire chamber");

        System.out.println("Enter Number: ");
        String menu = scan.next();

        //If the menu equals to one then methods in treasure class is called
        if (menu.equals("1")) {
            System.out.println("Please input a roll number for a specific treasure or 'r' for a random treasure: ");

            String randomTreasure = scan.next();

            if (randomTreasure.equals("r")) {
                treasure.setDescription();
            } else {
                int convertOne = Integer.parseInt(randomTreasure);
                treasure.setDescription(convertOne);
            }

            System.out.println("Please input a roll number for a specific container or 'r' for a random container: ");

            String randomContainer = scan.next();

            if (randomContainer.equals("r")) {
                treasure.setContainer();
            } else {
                int convertFour = Integer.parseInt(randomContainer);
                treasure.setContainer(convertFour);
            }

            String resultProtection = " ";

            try {
                resultProtection = treasure.getProtection();
            } catch (NotProtectedException ex) {
                resultProtection = "No Protection";
            }


            String resultTreasure = treasure.getDescription();
            String resultContainer = treasure.getContainer();

            System.out.println("The treasure is: " + resultTreasure);
            System.out.println("The treasure is contained in: " + resultContainer);
            System.out.println("The treasure is protected by: " + resultProtection);
        // if menu is 2 then methods in chamberShape is called
        } else if (menu.equals("2")) {

            System.out.println("Please input a roll number for a specific shape and size or 'r' for a random shape and size: ");

            String randomShape = scan.next();

            if (randomShape.equals("r")) {
                chamberShape.setShape();

            } else {
                int convertTwo = Integer.parseInt(randomShape);
                chamberShape.setShape(convertTwo);
            }

            System.out.println("Please input a roll number for a number of exits or 'r' for a random number of exits: ");

            String randomExit = scan.next();

            if (randomExit.equals("r")) {
                chamberShape.setNumExits();

            } else {
                int convertFive = Integer.parseInt(randomExit);
                chamberShape.setNumExits(convertFive);
            }

            int resultExits = chamberShape.getNumExits();
            String resultShape = chamberShape.getShape();
            int resultArea = chamberShape.getArea();
            int resultLength = 0;
            int resultWidth = 0;
            String resultExitD = exit.getDirection();
            String resultExitL = exit.getLocation();
            String conversionL = " ";
            String conversionW = " ";
            try {
                resultLength = chamberShape.getLength();
                conversionL = Integer.toString(resultLength);

            } catch (UnusualShapeException ex) {
                conversionL = "No Dimension";
            }

            try {
                resultWidth = chamberShape.getWidth();
                conversionW = Integer.toString(resultWidth);

            } catch (UnusualShapeException ex) {
                conversionW = "No Dimension";
            }


            System.out.println("The shape is: " + resultShape);
            System.out.println("The size is: " + resultArea + " square ft" + ", " + conversionL + " x " + conversionW);
            System.out.println("The number of exits are: " + resultExits);
            System.out.println("The exit location is: " + resultExitL);
            System.out.println("The exit direction is: " + resultExitD);
        // if menu is 3 then method in the chamber contents are called
        } else if (menu.equals("3")) {

            System.out.println("Please input a roll number for specific chamber contents or 'r' for random chamber contents: ");

            String randomContent = scan.next();

            if (randomContent.equals("r")) {
                chamberContents.setDescription();
            } else {
                int convertThree = Integer.parseInt(randomContent);
                chamberContents.setDescription(convertThree);
            }

            String resultContent = chamberContents.getDescription();

            System.out.println("The Contents in the chamber are: " + resultContent);
        //creates the full chamber
        } else {

            System.out.println("Please enter 'r' if you are randomly generating the whole chamber or 's' if you want to generate the chamber step by step: ");

            String choice = scan.next();
            //this makes the whole chamber from randomization
            if (choice.equals("r")) {
                chamberShape.setShape();
                chamberShape.setNumExits();
                int resultArea = chamberShape.getArea();
                String resultShape = chamberShape.getShape();
                int resultNumExits = chamberShape.getNumExits();
                String resultExitD = exit.getDirection();
                String resultExitL = exit.getLocation();
                chamberContents.setDescription();
                String resultContent = chamberContents.getDescription();

                int resultLength = 0;
                int resultWidth = 0;
                String conversionL = " ";
                String conversionW = " ";

                try {
                    resultLength = chamberShape.getLength();
                    conversionL = Integer.toString(resultLength);
                } catch (UnusualShapeException ex) {
                    conversionL = "No Dimension";
                }

                try {
                    resultWidth = chamberShape.getWidth();
                    conversionW = Integer.toString(resultWidth);
                } catch (UnusualShapeException ex) {
                    conversionW = "No Dimension";
                }



                System.out.println("The shape of the chamber is: " + resultShape);
                System.out.println("The size of the chamber is: " + resultArea + " square ft" + ", " + conversionL + " x " + conversionW);
                System.out.println("The number of exits in the chamber are: " + resultNumExits);
                System.out.println("The location of the exit is: " + resultExitL);
                System.out.println("The direction of the exit is: " + resultExitD);
                System.out.println("The contents of the chamber are: " + resultContent);

                if (resultContent.equals("empty")) {
                    System.out.println("The chamber is empty");

                } else if (resultContent.equals("monster only")) {
                    monster.setType();
                    String resultMonster = monster.getDescription();
                    int monsterMax = monster.getMaxNum();
                    int monsterMin = monster.getMinNum();

                    System.out.println("There are " + monsterMin + " to " + monsterMax + " " + resultMonster + " in the chamber");

                } else if (resultContent.equals("monster and treasure")) {
                    monster.setType();
                    String resultMonster = monster.getDescription();
                    int monsterMax = monster.getMaxNum();
                    int monsterMin = monster.getMinNum();
                    treasure.setDescription();
                    treasure.setContainer();
                    String resultTreasure = treasure.getDescription();
                    String resultContainer = treasure.getContainer();
                    String resultProtection = " ";

                    try {
                        resultProtection = treasure.getProtection();

                    } catch (NotProtectedException ex) {
                        resultProtection = "No Protection";
                    }

                    System.out.println("There are " + monsterMin + " to " + monsterMax + " " + resultMonster + " in the chamber");
                    System.out.println("The treasure is " + resultTreasure + " contained in " + resultContainer + " protected by " + resultProtection);

                } else if (resultContent.equals("stairs")) {
                    stairs.setType();
                    String resultStairs = stairs.getDescription();

                    System.out.println("Stairs type: " + resultStairs);

                } else if (resultContent.equals("trap")) {
                    trap.setDescription();
                    String resultTrap = trap.getDescription();

                    System.out.println("Trap type: " + resultTrap);

                } else if (resultContent.equals("treasure")) {
                    treasure.setDescription();
                    treasure.setContainer();
                    String resultTreasure = treasure.getDescription();
                    String resultContainer = treasure.getContainer();
                    String resultProtection = " ";

                    try {
                        resultProtection = treasure.getProtection();
                    } catch (NotProtectedException ex) {
                        resultProtection = "No Protection";
                    }
                    System.out.println("The treasure is " + resultTreasure + " contained in " + resultContainer + " protected by " + resultProtection);

                }
            //full chamber with user input is built
            } else {
                System.out.println("Please input a roll number for a specific shape and size or 'r' for a random shape and size: ");

                String randomShape = scan.next();

                if (randomShape.equals("r")) {
                    chamberShape.setShape();

                } else {
                    int convertTwo = Integer.parseInt(randomShape);
                    chamberShape.setShape(convertTwo);
                }

                System.out.println("Please input a roll number for a number of exits or 'r' for a random number of exits: ");

                String randomExit = scan.next();

                if (randomExit.equals("r")) {
                    chamberShape.setNumExits();

                } else {
                    int convertFive = Integer.parseInt(randomExit);
                    chamberShape.setNumExits(convertFive);
                }

                int resultNumExits = chamberShape.getNumExits();
                String resultShape = chamberShape.getShape();
                String resultExitD = exit.getDirection();
                String resultExitL = exit.getLocation();
                int resultArea = chamberShape.getArea();
                int resultLength = 0;
                int resultWidth = 0;
                String conversionL = " ";
                String conversionW = " ";
                try {
                    resultLength = chamberShape.getLength();
                    conversionL = Integer.toString(resultLength);

                } catch (UnusualShapeException ex) {
                    conversionL = "No Dimension";
                }

                try {
                    resultWidth = chamberShape.getWidth();
                    conversionW = Integer.toString(resultWidth);

                } catch (UnusualShapeException ex) {
                    conversionW = "No Dimension";
                }

                System.out.println("Please input a roll number for specific chamber contents or 'r' for random chamber contents: ");

                String randomContent = scan.next();

                if (randomContent.equals("r")) {
                    chamberContents.setDescription();

                } else {
                    int convertThree = Integer.parseInt(randomContent);
                    chamberContents.setDescription(convertThree);
                }

                String resultContent = chamberContents.getDescription();

                System.out.println("The contents of the chamber are: " + resultContent);

                if (resultContent.equals("empty")) {
                    System.out.println("The shape of the chamber is: " + resultShape);
                    System.out.println("The size of the chamber is: " + resultArea + " square ft" + ", " + conversionL + " x " + conversionW);
                    System.out.println("The number of exits in the chamber are: " + resultNumExits);
                    System.out.println("The location of the exit is: " + resultExitL);
                    System.out.println("The direction of the exit is: " + resultExitD);
                    System.out.println("The chamber is empty");

                } else if (resultContent.equals("monster only")) {
                    System.out.println("Please input a roll number for a type of monster or 'r' for a random monster: ");

                    String randomMonster = scan.next();

                    if (randomMonster.equals("r")) {
                        monster.setType();

                    } else {
                        int convertSix = Integer.parseInt(randomMonster);
                        monster.setType(convertSix);
                    }

                    int monsterMax = monster.getMaxNum();
                    int monsterMin = monster.getMinNum();
                    String resultMonster = monster.getDescription();

                    System.out.println("The shape of the chamber is: " + resultShape);
                    System.out.println("The size of the chamber is: " + resultArea + " square ft" + ", " + conversionL + " x " + conversionW);
                    System.out.println("The number of exits in the chamber are: " + resultNumExits);
                    System.out.println("The location of the exit is: " + resultExitL);
                    System.out.println("The direction of the exit is: " + resultExitD);
                    System.out.println("The contents of the chamber are: " + resultContent);
                    System.out.println("There are " + monsterMin + " to " + monsterMax + " " + resultMonster + " in the chamber");

                } else if (resultContent.equals("monster and treasure")) {
                    System.out.println("Please input a roll number for a type of monster or 'r' for a random monster: ");

                    String randomMonster = scan.next();

                    if (randomMonster.equals("r")) {
                        monster.setType();

                    } else {
                        int convertSix = Integer.parseInt(randomMonster);
                        monster.setType(convertSix);
                    }

                    int monsterMax = monster.getMaxNum();
                    int monsterMin = monster.getMinNum();
                    String resultMonster = monster.getDescription();

                    System.out.println("Please input a roll number for a specific treasure or 'r' for a random treasure: ");

                    String randomTreasure = scan.next();

                    if (randomTreasure.equals("r")) {
                        treasure.setDescription();

                    } else {
                        int convertOne = Integer.parseInt(randomTreasure);
                        treasure.setDescription(convertOne);
                    }

                    System.out.println("Please input a roll number for a specific container or 'r' for a random container: ");

                    String randomContainer = scan.next();

                    if (randomContainer.equals("r")) {
                        treasure.setContainer();

                    } else {
                        int convertFour = Integer.parseInt(randomContainer);
                        treasure.setContainer(convertFour);
                    }

                    String resultProtection = " ";

                    try {
                        resultProtection = treasure.getProtection();

                    } catch (NotProtectedException ex) {
                        resultProtection = "No Protection";
                    }


                    String resultTreasure = treasure.getDescription();
                    String resultContainer = treasure.getContainer();

                    System.out.println("The shape of the chamber is: " + resultShape);
                    System.out.println("The size of the chamber is: " + resultArea + " square ft" + ", " + conversionL + " x " + conversionW);
                    System.out.println("The number of exits in the chamber are: " + resultNumExits);
                    System.out.println("The location of the exit is: " + resultExitL);
                    System.out.println("The direction of the exit is: " + resultExitD);
                    System.out.println("The contents of the chamber are: " + resultContent);
                    System.out.println("There are " + monsterMin + " to " + monsterMax + " " + resultMonster + " in the chamber");
                    System.out.println("The treasure is " + resultTreasure + " contained in " + resultContainer + " protected by " + resultProtection);

                } else if (resultContent.equals("stairs")) {
                    System.out.println("Please input a roll number for the type of stairs or 'r' for random type of stairs: ");

                    String randomStairs = scan.next();

                    if (randomStairs.equals("r")) {
                        stairs.setType();

                    } else {
                        int convertSeven = Integer.parseInt(randomStairs);
                        stairs.setType(convertSeven);
                    }

                    String resultStairs = stairs.getDescription();
                    System.out.println("The shape of the chamber is: " + resultShape);
                    System.out.println("The size of the chamber is: " + resultArea + " square ft" + ", " + conversionL + " x " + conversionW);
                    System.out.println("The number of exits in the chamber are: " + resultNumExits);
                    System.out.println("The location of the exit is: " + resultExitL);
                    System.out.println("The direction of the exit is: " + resultExitD);
                    System.out.println("The contents of the chamber are: " + resultContent);
                    System.out.println("Stairs type: " + resultStairs);

                } else if (resultContent.equals("trap")) {
                    System.out.println("Please input a roll number for the type of trap or 'r' for random type of trap: ");

                    String randomTrap = scan.next();

                    if (randomTrap.equals("r")) {
                        trap.setDescription();

                    } else {
                        int convertEight = Integer.parseInt(randomTrap);
                        trap.setDescription(convertEight);
                    }

                    String resultTrap = trap.getDescription();
                    System.out.println("The shape of the chamber is: " + resultShape);
                    System.out.println("The size of the chamber is: " + resultArea + " square ft" + ", " + conversionL + " x " + conversionW);
                    System.out.println("The number of exits in the chamber are: " + resultNumExits);
                    System.out.println("The location of the exit is: " + resultExitL);
                    System.out.println("The direction of the exit is: " + resultExitD);
                    System.out.println("The contents of the chamber are: " + resultContent);
                    System.out.println("Trap type: " + resultTrap);

                } else {
                    System.out.println("Please input a roll number for a specific treasure or 'r' for a random treasure: ");

                    String randomTreasure = scan.next();

                    if (randomTreasure.equals("r")) {
                        treasure.setDescription();

                    } else {
                        int convertOne = Integer.parseInt(randomTreasure);
                        treasure.setDescription(convertOne);
                    }

                    System.out.println("Please input a roll number for a specific container or 'r' for a random container: ");

                    String randomContainer = scan.next();

                    if (randomContainer.equals("r")) {
                        treasure.setContainer();

                    } else {
                        int convertFour = Integer.parseInt(randomContainer);
                        treasure.setContainer(convertFour);
                    }
                    String resultProtection = " ";

                    try {
                        resultProtection = treasure.getProtection();

                    } catch (NotProtectedException ex) {
                        resultProtection = "No Protection";
                    }


                    String resultTreasure = treasure.getDescription();
                    String resultContainer = treasure.getContainer();

                    System.out.println("The shape of the chamber is: " + resultShape);
                    System.out.println("The size of the chamber is: " + resultArea + " square ft" + ", " + conversionL + " x " + conversionW);
                    System.out.println("The number of exits in the chamber are: " + resultNumExits);
                    System.out.println("The location of the exit is: " + resultExitL);
                    System.out.println("The direction of the exit is: " + resultExitD);
                    System.out.println("The contents of the chamber are: " + resultContent);
                    System.out.println("The treasure is " + resultTreasure + " contained in " + resultContainer + " protected by " + resultProtection);
                }



            }
        }
    }
}

