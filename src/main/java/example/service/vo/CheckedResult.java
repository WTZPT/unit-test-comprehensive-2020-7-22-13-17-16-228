package example.service.vo;

public class CheckedResult {
    private boolean legal;
    private String msg;

    public CheckedResult(boolean legal) {
        this.legal = legal;
    }

    public CheckedResult(boolean legal, String msg) {
        this.legal = legal;
        this.msg = msg;
    }

    public boolean isLegal() {
        return legal;
    }

    public String getMsg() {
        return msg;
    }

}
