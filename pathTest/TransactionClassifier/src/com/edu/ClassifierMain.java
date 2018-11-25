package com.edu;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import categoriesAPI.TransactionCategory;
import categoriesAPI.TransactionType;
import transactionAPI.TransactionDetails;

public class ClassifierMain {
	public static void main(String[] args) throws IOException {
		int accNo = 123;
		TransactionDetails transactionDetails = TransactionDetails.getTransactionDetails(accNo);
		
		FileInputStream fStream = new FileInputStream("resources/Categories.xlsx");
		TransactionCategory transactionCategory = new TransactionCategory();
		ArrayList<TransactionType> transactionTypes = transactionCategory.getData(fStream);
		
		Classifier classifier = new Classifier();
		classifier.load(transactionDetails.getDtos(), transactionCategory);
		System.out.println(classifier.wasteTotal);
		System.out.println(classifier.usefulTotal);
		
		System.out.println("test comment");
		
	}
}
