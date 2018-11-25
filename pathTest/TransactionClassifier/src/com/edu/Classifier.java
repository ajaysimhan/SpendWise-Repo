package com.edu;

import java.util.ArrayList;

import categoriesAPI.TransactionCategory;
import transactionAPI.TransactionDTO;

public class Classifier {
	ArrayList<TransactionDTO> waste = new ArrayList<>();
	ArrayList<TransactionDTO> useful = new ArrayList<>();
	double wasteTotal;
	double usefulTotal;
	
	public void load(ArrayList<TransactionDTO> transactionList, TransactionCategory transactionCategory) {
		for(TransactionDTO t : transactionList) {
			if(transactionCategory.getWaste().contains(t.getCategoryId())) {
				waste.add(t);
				wasteTotal += t.getAmount().getAmount();
			} else {
				useful.add(t);
				usefulTotal += t.getAmount().getAmount();
			}
			
		}
		
	}

}
