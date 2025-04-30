package com.mynsu.project6;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 
 * Brandon Cruz, Mark-Anthony Wright, Marcos Rodriguez, Jonathan Vargas
 *
 * The Simulator class handles the train simulation process.
 * It interacts with the user to get the number of stops, loads customer data from a file,
 * validates the data, and runs the simulation using a Train object.
 */
public class Simulator {

    /**
     * Prompts the user to enter the number of stops for the train route.
     * Validates that the input is an integer greater than 1.
     *
     * @return the number of stops entered by the user
     */
    public int getStopsFromUser() {
        Scanner sc = new Scanner(System.in);
        int stops = 0;
        boolean valid = false;

        while (!valid) {
            System.out.println("Enter number of stops the train has on its route (must be greater than 1):");
            try {
                stops = Integer.parseInt(sc.nextLine());
                if (stops > 1) {
                    valid = true;
                } else {
                    System.out.println("Invalid input, try again");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, try again");
            }
        }
        return stops;
    }

    /**
     * Prompts the user to provide the file path for customer data.
     * If the user presses Enter, a default path is used.
     * Ensures that the file exists before returning it.
     *
     * @return a valid File object pointing to the customer data
     */
    public File getInputFile() {
        Scanner sc = new Scanner(System.in);
        File file = null;
        boolean valid = false;

        while (!valid) {
            System.out.println("Enter absolute path for data file or for default (C:/train/customer-data.txt) press Enter:");
            String input = sc.nextLine().trim();
            if (input.isEmpty()) {
                input = "C:/train/customer-data.txt";
            }
            file = new File(input);
            if (file.exists()) {
                valid = true;
            } else {
                System.out.println("File not found, try again.");
            }
        }
        return file;
    }

    /**
     * Reads and validates customer data from a file.
     * Ensures each line has exactly four integers: ID, time, enter stop, and exit stop.
     * Checks for unique customer IDs and valid stop numbers (within the range of stops).
     *
     * @param stops number of stops on the train route
     * @param file  File object pointing to the data file
     * @return a list of validated Customer objects, or null if any error occurs
     */
    public ArrayList<Customer> checkFile(int stops, File file) {
        Scanner sc = null;
        try {
            sc = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            return null;
        }

        ArrayList<Customer> list = new ArrayList<>();
        ArrayList<Integer> ids = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] tokens = line.trim().split("\\s+");

            // Validate correct number of fields
            if (tokens.length != 4) {
                System.out.println("Each line must have four integers. Try again.");
                return null;
            }

            try {
                int id = Integer.parseInt(tokens[0]);
                int time = Integer.parseInt(tokens[1]);
                int enter = Integer.parseInt(tokens[2]);
                int exit = Integer.parseInt(tokens[3]);

                // Check for duplicate ID
                if (ids.contains(id)) {
                    System.out.println("Data in input file is not correct. Try again.");
                    return null;
                }
                ids.add(id);

                // Check for valid stop range
                if (enter > stops || exit > stops) {
                    System.out.println("Data in input file is not correct. Try again.");
                    return null;
                }

                // Add validated customer to the list
                Customer cust = new Customer(id, time, enter, exit);
                list.add(cust);
            } catch (NumberFormatException e) {
                System.out.println("Data in input file is not correct. Try again.");
                return null;
            }
        }

        return list;
    }

    /**
     * Creates a Train object and starts the simulation.
     * Then displays the results of each stop after simulation.
     *
     * @param stops number of stops on the train route
     * @param list  list of valid Customer objects
     */
    public void run(int stops, ArrayList<Customer> list) {
        Train train = new Train(stops, list);
        train.simulate();
        train.displayStops();
    }

    /**
     * Main method that drives the simulator.
     * Gets input from the user, loads and validates data, and initiates the simulation.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        Simulator sim = new Simulator();
        int stops = sim.getStopsFromUser();            // Prompt for number of stops
        File file = sim.getInputFile();                // Prompt for file location
        ArrayList<Customer> list = sim.checkFile(stops, file);  // Read and validate customer data
        if (list != null) {
            sim.run(stops, list);                      // Run simulation if data is valid
        }
    }
}
