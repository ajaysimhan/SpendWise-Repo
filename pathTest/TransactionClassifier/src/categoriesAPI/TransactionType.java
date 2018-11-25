package categoriesAPI;

import java.util.ArrayList;

public class TransactionType {
	String catergoryType;
	ArrayList<CategoryDTO> elements = new ArrayList<>();
	@Override
	public String toString() {
		return "TransactionType [catergoryType=" + catergoryType + ", elements=" + elements + "]";
	}
}
