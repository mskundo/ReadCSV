package com.wallmart.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wallmart.model.Product;
import com.wallmart.repository.ReportRepository;

@Transactional
@Service
public class ReportService {
	@Autowired
	private ReportRepository reportRepo;

	public void save(List<Product> p) throws IOException {

		for (Product p1 : p) {
			reportRepo.save(p1);
		}
	}
}
