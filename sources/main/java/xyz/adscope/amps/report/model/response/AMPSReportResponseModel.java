package xyz.adscope.amps.report.model.response;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class AMPSReportResponseModel {
    private int code;
    private int dlvy;
    private String ext;
    private String msg;
    private SpecModel spec;

    public int getCode() {
        return this.code;
    }

    public int getDlvy() {
        return this.dlvy;
    }

    public String getExt() {
        return this.ext;
    }

    public String getMsg() {
        return this.msg;
    }

    public SpecModel getSpec() {
        return this.spec;
    }

    public void setCode(int i6) {
        this.code = i6;
    }

    public void setDlvy(int i6) {
        this.dlvy = i6;
    }

    public void setExt(String str) {
        this.ext = str;
    }

    public void setMsg(String str) {
        this.msg = str;
    }

    public void setSpec(SpecModel specModel) {
        this.spec = specModel;
    }
}
