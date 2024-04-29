package com.controller;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.exception.InvalidCredentialsException;
import com.model.User;
import com.service.UserService;

public class LoginController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UserService userService = new UserService();

		while (true) {
			try {
				System.out.println("\nWelcome to the Insurance.\n");
				System.out.println("Press 1. Login");
				System.out.println("Press 0. Exit");
				System.out.print("Enter a number to continue : ");
				int input = sc.nextInt();
				if (input == 0) {
					System.out.println("Exiting Insurance Application.");
					break;
				}

				switch (input) {
				case 1:
					System.out.print("\nEnter username: ");
					sc.nextLine();
					String username = sc.next();
					System.out.print("Enter password: ");
					String password = sc.next();

					User user = userService.login(username, password);

					if (user.getRole().equalsIgnoreCase("agent")) {
						System.out.println("Agent Menu");
						AgentController.agentMenu();
						
						//username = agent
						//password = 1234

					} else {
						System.out.println("Admin Menu");
						// System.out.println("This section needs to be updated");
						// ClientController.clientMenu();
					}

					break;
				default:
					System.out.println("Invalid input given, try again later!!!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid number.");
				sc.next();
				continue;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			} catch (InvalidCredentialsException e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();
	}

}