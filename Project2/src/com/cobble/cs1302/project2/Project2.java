//Class:      CS1301/08
//Term:       Spring 2017
//Name:       Logan Thompson
//Instructor: Monisha Verma
//Assignment: Project 2 | Option 1
package com.cobble.cs1302.project2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

public class Project2 {

    private static String template;

    private static SimpleDateFormat dateFormatter = new SimpleDateFormat("MM/dd/yyyy");

    public static void main(String[] args) {
        StringBuilder templateBuilder = new StringBuilder(); // String builder for the template string.
        try (Stream<String> stream = Files.lines(Paths.get("template.txt"))) { // Read each line from the template file and appends it to the string builder.
            stream.forEach((line) -> templateBuilder.append(line).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        template = templateBuilder.toString();

        try (Stream<String> stream = Files.lines(Paths.get("dataCollection.txt"))) { // Get stream of the dataCollection file
            stream.forEach((line) -> { // Loop over every line in the dataCollection file
                Client client = new Client(line); // Create a client from each line of the dataCollection file
                if (client.getBalance() > 5) // Print the collection letter for the client if it's balance is greater than 5
                    printCollectionLetter(client);
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void printCollectionLetter(Client client) {
        try {
            String initials = client.getFirstName().substring(client.getFirstName().length() - 3); // Extracts the client's initials from the first name.
            System.out.println("Printing the collection letter for client: " + initials + "...");
            Date todayDate = new Date(); // Current date.
            Date futureDate = new Date(System.currentTimeMillis() + 864000000); // Add 10 days to current date.
            File letterFile = new File("out/ColLetter_" + initials + ".txt");
            File parent = letterFile.getParentFile();

            // Create the parent directory if needed.
            if (!parent.exists()) //noinspection ResultOfMethodCallIgnored
                parent.mkdirs();

            //Create the file if needed.
            if (!letterFile.exists()) //noinspection ResultOfMethodCallIgnored
                letterFile.createNewFile();

            String formattedLetter = template.replaceAll("\\{\\{FirstName}}", client.getFirstName()) // Replace first name field from template.
                    .replaceAll("\\{\\{LastName}}", client.getLastName()) // Replace last name from template.
                    .replaceAll("\\{\\{Address1}}", client.getAddress1()) // Replace address1 from template.
                    .replaceAll("\\{\\{Address2}}", client.getAddress2()) // Replace address2 from template.
                    .replaceAll("\\{\\{City}}", client.getCity()) // Replace city from template.
                    .replaceAll("\\{\\{State}}", client.getState()) // Replace state from template.
                    .replaceAll("\\{\\{ZipCode}}", client.getZipCode()) // Replace zip code from template
                    .replaceAll("\\{\\{TodayDate}}", dateFormatter.format(todayDate)) // Replace current date from template.
                    .replaceAll("\\{\\{FutureDate}}", dateFormatter.format(futureDate)) // Replace future date from template.
                    .replaceAll("\\{\\{CurrentBalance}}", String.format("%.2f", client.getBalance())) // Replace current balance from template.
                    .replaceAll("\\{\\{TotalBalance}}", String.format("%.2f", client.getBalance() * 1.1)); // Replace total balance from template.

            FileOutputStream letterOutStream = new FileOutputStream(letterFile); // Create the output stream.
            letterOutStream.write(formattedLetter.getBytes(StandardCharsets.UTF_8)); // Write the formatted template to the proper file.
            letterOutStream.close(); // Close the output stream.
            System.out.println("Finished the printing collection letter for client: " + initials);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
