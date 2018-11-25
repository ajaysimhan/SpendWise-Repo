package com.edu;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import categoriesAPI.TransactionCategory;
import categoriesAPI.TransactionType;
import transactionAPI.TransactionBuilder;
import transactionAPI.TransactionDTO;

public class ClassifierMain {
	public static void main(String[] args) throws IOException {
		String transactionsString = FileUtils.readFileToString(new File("resources/transactions.txt")).trim();
		ArrayList<TransactionDTO> transactionList = TransactionBuilder.buildTransactions(transactionsString);
		
		FileInputStream fStream = new FileInputStream("resources/Categories.xlsx");
		TransactionCategory transactionCategory = new TransactionCategory();
		ArrayList<TransactionType> transactionTypes = transactionCategory.getData(fStream);
		
		Classifier classifier = new Classifier();
		classifier.load(transactionList, transactionCategory);
		System.out.println(classifier.wasteTotal);
		System.out.println(classifier.usefulTotal);
	}
	
	
}
