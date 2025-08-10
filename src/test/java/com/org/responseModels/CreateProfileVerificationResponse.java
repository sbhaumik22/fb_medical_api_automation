package com.org.responseModels;

public class CreateProfileVerificationResponse {
    private String status;
    private Data data;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }

    public static class Data {
        private Request request;

        public Request getRequest() {
            return request;
        }
        public void setRequest(Request request) {
            this.request = request;
        }
    }

    public static class Request {
        private String _id;
        private String user;
        private String relative;
        private String userAddress;
        private String nationalId;
        private String[] insurance;
        private String status;
        private String rejectionReason;
        private String assignedTo;
        private String createdAt;
        private String updatedAt;
        private int __v;

        public String get_id() {
            return _id;
        }
        public void set_id(String _id) {
            this._id = _id;
        }

        public String getUser() {
            return user;
        }
        public void setUser(String user) {
            this.user = user;
        }

        public String getRelative() {
            return relative;
        }
        public void setRelative(String relative) {
            this.relative = relative;
        }

        public String getUserAddress() {
            return userAddress;
        }
        public void setUserAddress(String userAddress) {
            this.userAddress = userAddress;
        }

        public String getNationalId() {
            return nationalId;
        }
        public void setNationalId(String nationalId) {
            this.nationalId = nationalId;
        }

        public String[] getInsurance() {
            return insurance;
        }
        public void setInsurance(String[] insurance) {
            this.insurance = insurance;
        }

        public String getStatus() {
            return status;
        }
        public void setStatus(String status) {
            this.status = status;
        }

        public String getRejectionReason() {
            return rejectionReason;
        }
        public void setRejectionReason(String rejectionReason) {
            this.rejectionReason = rejectionReason;
        }

        public String getAssignedTo() {
            return assignedTo;
        }
        public void setAssignedTo(String assignedTo) {
            this.assignedTo = assignedTo;
        }

        public String getCreatedAt() {
            return createdAt;
        }
        public void setCreatedAt(String createdAt) {
            this.createdAt = createdAt;
        }

        public String getUpdatedAt() {
            return updatedAt;
        }
        public void setUpdatedAt(String updatedAt) {
            this.updatedAt = updatedAt;
        }

        public int get__v() {
            return __v;
        }
        public void set__v(int __v) {
            this.__v = __v;
        }
    }
}
