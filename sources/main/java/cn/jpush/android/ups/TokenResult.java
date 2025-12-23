package cn.jpush.android.ups;

/* loaded from: D:\Downloads\app\classes2.dex */
public class TokenResult {
    private String actionType;
    private int returnCode;
    private String token;

    public TokenResult(String str, int i6) {
        this.token = str;
        this.returnCode = i6;
    }

    public TokenResult(String str, int i6, String str2) {
        this.token = str;
        this.returnCode = i6;
        this.actionType = str2;
    }

    public String getActionType() {
        return this.actionType;
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getToken() {
        return this.token;
    }

    public void setActionType(String str) {
        this.actionType = str;
    }

    public void setReturnCode(int i6) {
        this.returnCode = i6;
    }

    public void setToken(String str) {
        this.token = str;
    }

    public String toString() {
        return "TokenResult{token='" + this.token + "', returnCode=" + this.returnCode + ", actionType='" + this.actionType + "'}";
    }
}
