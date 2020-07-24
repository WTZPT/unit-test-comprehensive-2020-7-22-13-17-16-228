package example.service.vo;

public class CheckedResult {
    private boolean isLegal;
    private String msg;

    public CheckedResult(boolean isLegal) {
        this.isLegal = isLegal;
    }

    public CheckedResult(boolean isLegal, String msg) {
        this.isLegal = isLegal;
        this.msg = msg;
    }

    public boolean isLegal() {
        return isLegal;
    }

    public String getMsg() {
        return msg;
    }

}
