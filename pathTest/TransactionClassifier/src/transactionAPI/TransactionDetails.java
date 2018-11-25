package transactionAPI;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TransactionDetails {
	ArrayList<TransactionDTO> dtos = new ArrayList<>();
	
	public ArrayList<TransactionDTO> getDtos() {
		return dtos;
	}
	
	public static TransactionDetails getTransactionDetails(int accNo) {
		TransactionDetails transactionDetails = new TransactionDetails();
		try {
			String filePath = "resources/transactions/" + accNo + ".txt";
			String transactionData = FileUtils.readFileToString(new File(filePath));
			transactionDetails.buildTransactions(transactionData);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return transactionDetails;
	}
	
	private void buildTransactions(String transactionData) {
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(transactionData);
        JsonObject json = (JsonObject) element;
        JsonArray jsonArray = json.getAsJsonArray("transaction");
        for(JsonElement j : jsonArray) {
        	TransactionDTO transactionDTO = new Gson().fromJson(j.toString(), TransactionDTO.class);
        	dtos.add(transactionDTO);
        }
	}
}
