package categoriesAPI;

public class CategoryDTO {
	int categoryId;
	String description;
	String nature;
	@Override
	public String toString() {
		return "CategoryDTO [categoryId=" + categoryId + ", description=" + description + ", nature=" + nature + "]";
	}
}
