package xyz.adscope.amps.model.crash;

import xyz.adscope.amps.model.AMPSBaseModel;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSCrashRequestModel extends AMPSBaseModel {
    private String affiliated;
    private String exception;
    private String log_time;

    public String getAffiliated() {
        return this.affiliated;
    }

    public String getException() {
        return this.exception;
    }

    public String getLog_time() {
        return this.log_time;
    }

    public void setAffiliated(String str) {
        this.affiliated = str;
    }

    public void setException(String str) {
        this.exception = str;
    }

    public void setLog_time(String str) {
        this.log_time = str;
    }
}
