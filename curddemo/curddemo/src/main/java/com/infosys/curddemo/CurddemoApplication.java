package com.infosys.curddemo;

import com.infosys.curddemo.beans.Batches;
import com.infosys.curddemo.services.BatchServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@SpringBootApplication
public class CurddemoApplication implements CommandLineRunner {
	@Autowired
	BatchServices batchServices;

	public static void main(String[] args) {
		SpringApplication.run(CurddemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter 1 to add new batch");
		System.out.println("Enter 2 to add multiple batches ");
		System.out.println("Enter 3 to find the batch on basis of id");
		System.out.println("Enter 4 to update batch details");
		System.out.println("Enter 5 to remove batch ");
		int operation =scanner.nextInt();
		switch (operation)
		{
			case 1:
				System.out.println("Enter Batch Name");
				String batchName = scanner.next();
				System.out.println("Enter Batch Start Date");
				String startDate = scanner.next();
				System.out.println("Enter Batch End Date");
				String endDate = scanner.next();
				Batches batch1 = new Batches();
				batch1.setBatchName(batchName);
				batch1.setBatchStartDate(startDate);
				batch1.setBatchEndDate(endDate);
				batchServices.addBatch(batch1);
				break;
			case 2:
				int noofbatches = scanner.nextInt();
				List<Batches>  batchesList = new ArrayList<Batches>();
				for (int i =0;i<noofbatches;i++)
				{
					System.out.println("Enter Batch Name");
					String batchName1 = scanner.next();
					System.out.println("Enter Batch Start Date");
					String startDate1 = scanner.next();
					System.out.println("Enter Batch End Date");
					String endDate1 = scanner.next();
					Batches batch2 = new Batches();
					batch2.setBatchName(batchName1);
					batch2.setBatchStartDate(startDate1);
					batch2.setBatchEndDate(endDate1);
					batchesList.add(batch2);
				}
				batchServices.addMultipleBatches(batchesList);
				break;
			case 3:
				System.out.println("Enter batchId to see batch details");
				 int batchId= scanner.nextInt();
				 try {
					 Optional<Batches> optional = batchServices.findBatchById(batchId);
					 Batches batch = optional.get();
					 System.out.println(batch.toString());
				 } catch (Exception e) {
					 System.err.println("Id not found");
				 }
				 break;
			default:

				System.out.println("Please select valid opertation.Thank you!");


		}
	}
}
