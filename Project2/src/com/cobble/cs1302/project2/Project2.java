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
import java.util.Date;
import java.util.stream.Stream;

public class Project2 {

    private static String template;

    public static void main(String[] args) {
        StringBuilder templateBuilder = new StringBuilder(); // String builder for the template string.
        try (Stream<String> stream = Files.lines(Paths.get("res/template.txt"))) { // read each line from the template file and appends it to the string builder.
            stream.forEach((line) -> {
                templateBuilder.append(line).append("\n");
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        template = templateBuilder.toString();

        try (Stream<String> stream = Files.lines(Paths.get("res/dataCollection.txt"))) {
            stream.forEach((line) -> {
                Client client = new Client(line);
                if (client.getBalance() > 5)
                    printClientLetter(client);
            });
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static void printClientLetter(Client client) {
        try {
            Date todayDate = new Date();
            File letterFile = new File("out/ColLetter_" + client.getFirstName().substring(client.getFirstName().length() - 3) + ".txt");
            File parent = letterFile.getParentFile();
            if (!parent.exists())
                parent.mkdirs();
            if (!letterFile.exists())
                letterFile.createNewFile();
            FileOutputStream letterWriter = new FileOutputStream(letterFile);

            String formattedLetter = template.replaceAll("\\{\\{FirstName}}", client.getFirstName())
                    .replaceAll("\\{\\{LastName}}", client.getLastName())
                    .replaceAll("\\{\\{Address1}}", client.getAddress1())
                    .replaceAll("\\{\\{Address2}}", client.getAddress2());

            letterWriter.write(formattedLetter.getBytes(StandardCharsets.UTF_8));
            letterWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
