package requestPayloads;

public class NationalIdentityPayload {
    private Images images;
    private String category;
    private String number;

    // Getters and Setters
    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    // Inner class for Images
    public static class Images {
        private String back;
        private String front;

        public String getBack() {
            return back;
        }

        public void setBack(String back) {
            this.back = back;
        }

        public String getFront() {
            return front;
        }

        public void setFront(String front) {
            this.front = front;
        }
    }
}
