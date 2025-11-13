class Login {
    private String userId;
    private String pass;
    public Login(String u, String p) {
        this.userId = u;
        this.pass = p;
    }

    public boolean authenticate() {
        return true;
    }

    public String getUserId() { return userId; }
}
