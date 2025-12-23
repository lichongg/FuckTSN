package xyz.adscope.amps.common;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSError {
    private String code;
    private String message;

    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String toString() {
        return "{\"code\":\"" + this.code + "\", \"message\":\"" + this.message + "\"}";
    }

    public AMPSError(String str, String str2) {
        this.code = str;
        this.message = str2;
    }
}
