package transactionAPI;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class TransactionBuilder {
	//Receives transaction json string
	public static ArrayList<TransactionDTO> buildTransactions(String transactionsString) {
		ArrayList<TransactionDTO> dtos = new ArrayList<>();
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(transactionsString);
        JsonObject json = (JsonObject) element;
        JsonArray jsonArray = json.getAsJsonArray("transaction");
        for(JsonElement j : jsonArray) {
        	TransactionDTO transactionDTO = new Gson().fromJson(j.toString(), TransactionDTO.class);
        	dtos.add(transactionDTO);
        }
        return dtos;
	}

}
