package models.responses;


import java.util.List;

public class GetNIDCategoriesResponse {
    private String status;
    private Data data;

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public static class Data {
        private List<Category> categories;

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public List<Category> getCategories() {
            return categories;
        }
    }
}
