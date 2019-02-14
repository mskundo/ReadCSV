package com.wallmart.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.opencsv.CSVReader;
import com.wallmart.model.Product;
import com.wallmart.service.ReportService;

@RestController
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportService reportService;

	@PostMapping("/add")
	public String addReport() throws IOException {
		AmazonS3 s3Client = new AmazonS3Client();

		S3Object s3Object = s3Client
				.getObject(new GetObjectRequest("wallmart-daily", "wallmart_transaction_11-02-2019.csv"));
		BufferedReader br = new BufferedReader(new InputStreamReader(s3Object.getObjectContent()));

		CSVReader reader = new CSVReader(br);

		List<Product> p = new ArrayList<Product>();

		String[] record = null;

		int iteration = 0;
		while ((record = reader.readNext()) != null) {
			if (iteration == 0) {
				iteration++;
				continue;
			}
			Product pro = new Product();
			pro.setId(record[0]);
			pro.setProductName(record[1]);
			pro.setPrice(record[2]);
			pro.setQuantity(record[3]);
			p.add(pro);
		}

		reader.close();
		System.out.println("controller");
		reportService.save(p);
		return "Added";

	}

}
