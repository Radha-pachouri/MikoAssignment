package com.databse.MikoAiAssignment.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AssemblyService {
    private final Map<String, Integer> registers = new HashMap<>();

    public String executeProgram(String program) {
        String[] lines = program.split("\n");
        for (String line : lines) {
            System.out.println("Processing line: " + line); // Debugging statement
            String[] parts = line.trim().split("\\s+");
            if (parts.length < 2) {
                return "Invalid command format: " + line;
            }

            try {
                switch (parts[0]) {
                    case "MV":
                        if (parts.length != 3) {
                            return "Invalid MV command format: " + line;
                        }
                        handleMove(parts);
                        break;
                    case "ADD":
                        if (parts.length !=  3) {
                            return "Invalid ADD command format: " + line;
                        }
                        handleAdd(parts);
                        break;
                    case "SHOW":
                        if (parts.length != 2) {
                            return "Invalid SHOW command format: " + line;
                        }
                        return handleShow(parts);
                    default:
                        return "Invalid command: " + parts[0];
                }
            } catch (Exception e) {
                e.printStackTrace();
                return "Error processing line: " + line + " - " + e.getMessage();
            }
        }
        return "No SHOW command found in the program";
    }

    private String handleShow(String[] parts) {
        String reg = parts[1].toUpperCase();
        int value = registers.getOrDefault(reg, 0);
        return "Register " + reg + " = " + value;
    }

    private void handleAdd(String[] parts) {
        String reg1 = parts[1].toUpperCase();
        String reg2OrConst = parts[2];

        int value2;
        try {
            if (reg2OrConst.matches("\\d+")) {
                value2 = Integer.parseInt(reg2OrConst);
            } else {
                value2 = registers.getOrDefault(reg2OrConst.toUpperCase(), 0);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid value format for ADD command: " + reg2OrConst);
        }

        int currentValue = registers.getOrDefault(reg1, 0);
        registers.put(reg1, currentValue + value2);
    }

    private void handleMove(String[] parts) {
        String reg = parts[1].toUpperCase();
        String valuePart = parts[2];

        try {
            int value = Integer.parseInt(valuePart);
            registers.put(reg, value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid value format for MV command: " + valuePart);
        }
    }
}
