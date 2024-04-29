package com.controller;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.exception.PolicyNotFoundException;
import com.model.Policy;
import com.service.AgentService;

public class AgentController {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		AgentService agentService = new AgentService();

		while (true) {
			System.out.println("\nAgent Dashboard");
			System.out.println("1. Create Policy");
			System.out.println("2. Get All Policy");
			System.out.println("3. Get Policy Details using Policy Id");
			System.out.println("4. Update Policy");
			System.out.println("5. Delete Policy");
			System.out.println("6. Logout");
			
			System.out.println("\nPress a number to continue");
			try {
				int input = sc.nextInt();

				if (input == 6) {
					System.out.println("Thanks");
					break;
				}

				switch (input) {
				case 1:
					sc.nextLine();
					Random random = new Random();
					int randomNum = random.nextInt();
					randomNum = randomNum > 0 ? randomNum : randomNum * -1;

					Policy policy = new Policy();
					policy.setPolicyId(randomNum);

					System.out.print("Enter Policy Name: ");
					String name = sc.nextLine();
					policy.setName(name);

			

					System.out.print("Enter Premium: ");
					double premium = sc.nextDouble();
					policy.setPremium(premium);
				

					System.out.print("Enter Rate of Interest: ");
					double rateOfInterest = sc.nextDouble();
					policy.setRateOfInterest(rateOfInterest);
					

					boolean isAdded = agentService.insert(policy);

					if (isAdded)
						System.out.println("Policy Added successfully");
					else
						System.out.println("Policy not added");

					break;

				case 2:
					List<Policy> policies = agentService.getAllPolicies();
					for (Policy p : policies)
						System.out.println(p);

					break;

				case 3:
					List<Policy> poll = agentService.getAllPolicies();
					for (Policy p : poll) {
						System.out.println("Policy id = " + p.getPolicyId() + "\n" +"Policy Name = "+ p.getName());
						System.out.println();
					}
					System.out.print("Enter policy Id: ");
					int policyId = sc.nextInt();
					Policy p = agentService.findPolicy(policyId);
					System.out.println(p);
					break;

				case 4:
					List<Policy> allPolicies = agentService.getAllPolicies();

					for (Policy allP : allPolicies)
						System.out.println(allP);

					System.out.print("Enter policy Id :");
					int polId = sc.nextInt();

					Policy pol = new Policy();
					pol.setPolicyId(polId);
					System.out.print("Enter Premium: ");
					pol.setPremium(sc.nextDouble());
					System.out.print("Enter Rate of Interest: ");
					pol.setRateOfInterest(sc.nextDouble());

					boolean isUpdated = agentService.updatePolicy(pol);
					if (isUpdated)
						System.out.println("Policy updated successfully");
					else
						System.out.println("Policy not updated");

					break;

				case 5:
					List<Policy> allPolicy = agentService.getAllPolicies();

					for (Policy allP : allPolicy)
						System.out.println(allP);

					System.out.print("Enter policy id: ");
					int pId = sc.nextInt();
					boolean isDeleted = agentService.deletePolicy(pId);

					if (isDeleted)
						System.out.println("Deleted Successfully");
					else
						System.out.println("Not deleted");
					break;

				default:
					throw new IllegalArgumentException("Unexpected value: " + input);
				}
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a valid input type.");
				sc.next();
				continue;
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}catch (PolicyNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public static void agentMenu() {
		String[] args = { "" };
		main(args);
	}
}
