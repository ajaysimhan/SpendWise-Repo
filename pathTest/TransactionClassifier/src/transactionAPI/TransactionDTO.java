package transactionAPI;

import java.util.ArrayList;
import java.util.Date;

public class TransactionDTO {
	String CONTAINER;
	long id;
	Amount amount;
	Amount runningBalance;
	String baseType;
	String categoryType;
	int categoryId;
	String category;
	String categorySource;
	long highLevelCategoryId;
	String date;
	Date createdDate;
	Date lastUpdated;
	String postDate;
	Description description;
	String isManual;
	String status;
	long accountId;
	String type;
	String subType;
	Merchant merchant;
	
	public String getCONTAINER() {
		return CONTAINER;
	}
	public long getId() {
		return id;
	}
	public Amount getAmount() {
		return amount;
	}
	public Amount getRunningBalance() {
		return runningBalance;
	}
	public String getBaseType() {
		return baseType;
	}
	public String getCategoryType() {
		return categoryType;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public String getCategory() {
		return category;
	}
	public String getCategorySource() {
		return categorySource;
	}
	public long getHighLevelCategoryId() {
		return highLevelCategoryId;
	}
	public String getDate() {
		return date;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public Date getLastUpdated() {
		return lastUpdated;
	}
	public String getPostDate() {
		return postDate;
	}
	public Description getDescription() {
		return description;
	}
	public String getIsManual() {
		return isManual;
	}
	public String getStatus() {
		return status;
	}
	public long getAccountId() {
		return accountId;
	}
	public String getType() {
		return type;
	}
	public String getSubType() {
		return subType;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	@Override
	public String toString() {
		return "TransactionDTO [CONTAINER=" + CONTAINER + ", id=" + id + ", amount=" + amount + ", runningBalance="
				+ runningBalance + ", baseType=" + baseType + ", categoryType=" + categoryType + ", categoryId="
				+ categoryId + ", category=" + category + ", categorySource=" + categorySource
				+ ", highLevelCategoryId=" + highLevelCategoryId + ", date=" + date + ", createdDate=" + createdDate
				+ ", lastUpdated=" + lastUpdated + ", postDate=" + postDate + ", description=" + description
				+ ", isManual=" + isManual + ", status=" + status + ", accountId=" + accountId + ", type=" + type
				+ ", subType=" + subType + ", merchant=" + merchant + "]";
	}
	public static class Amount {
		double amount;
		String currency;
		
		public double getAmount() {
			return amount;
		}

		public String getCurrency() {
			return currency;
		}

		@Override
		public String toString() {
			return "Amount [amount=" + amount + ", currency=" + currency + "]";
		}
		
	}
	public static class Description {
		String original;
		String consumer;
		String simple;
		@Override
		public String toString() {
			return "Description [original=" + original + ", consumer=" + consumer + ", simple=" + simple + "]";
		}
	}
	public static class Merchant {
		String id;
		String source;
		String name;
		ArrayList<String> categoryLabel;
		Address address;

		@Override
		public String toString() {
			return "Merchant [id=" + id + ", source=" + source + ", name=" + name + ", categoryLabel=" + categoryLabel
					+ ", address=" + address + "]";
		}

		public static class Address {
			String address1;
			String city;
			String state;
			String country;
			long zip;
			
			@Override
			public String toString() {
				return "Address [address1=" + address1 + ", city=" + city + ", state=" + state + ", country=" + country
						+ ", zip=" + zip + "]";
			}
		}
	}
}
