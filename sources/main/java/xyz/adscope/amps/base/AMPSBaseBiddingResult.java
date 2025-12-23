package xyz.adscope.amps.base;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSBaseBiddingResult {
    private int ecpm;
    private String errorCode;
    private String errorMsg;
    private boolean isSuccess;

    public static AMPSBaseBiddingResult biddingFail(String str, String str2) {
        return new AMPSBaseBiddingResult(false, 0, str, str2);
    }

    public static AMPSBaseBiddingResult biddingSuccess(int i6) {
        return new AMPSBaseBiddingResult(true, i6, "", "");
    }

    public int getEcpm() {
        return this.ecpm;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public boolean isSuccess() {
        return this.isSuccess;
    }

    public void setEcpm(int i6) {
        this.ecpm = i6;
    }

    public void setErrorCode(String str) {
        this.errorCode = str;
    }

    public void setErrorMsg(String str) {
        this.errorMsg = str;
    }

    public void setSuccess(boolean z5) {
        this.isSuccess = z5;
    }

    public String toString() {
        return "AMPSBaseBiddingResult{isSuccess=" + this.isSuccess + ", ecpm=" + this.ecpm + ", errorCode='" + this.errorCode + "', errorMsg='" + this.errorMsg + "'}";
    }

    public AMPSBaseBiddingResult(boolean z5, int i6, String str, String str2) {
        this.isSuccess = z5;
        this.ecpm = i6;
        this.errorCode = str;
        this.errorMsg = str2;
    }
}
