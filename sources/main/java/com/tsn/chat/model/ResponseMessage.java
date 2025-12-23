package com.tsn.chat.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class ResponseMessage {
    private byte controlType;
    private String datas;

    public byte getControlType() {
        return this.controlType;
    }

    public String getDatas() {
        return this.datas;
    }

    public void setControlType(byte b6) {
        this.controlType = b6;
    }

    public void setDatas(String str) {
        this.datas = str;
    }

    public String toString() {
        return "ResponseMessage [controlType=" + ((int) this.controlType) + ", datas=" + this.datas + "]";
    }

    public ResponseMessage(byte b6, String str) {
        this.controlType = b6;
        this.datas = str;
    }
}
