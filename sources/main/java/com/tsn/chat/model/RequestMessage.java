package com.tsn.chat.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class RequestMessage {
    private byte controlType;
    private String datas;
    private byte header;
    private int length;

    public RequestMessage() {
    }

    public RequestMessage(int i6, byte b6, String str) {
        this.header = (byte) -2;
        this.length = i6;
        this.controlType = b6;
        this.datas = str;
    }

    public byte getControlType() {
        return this.controlType;
    }

    public String getDatas() {
        return this.datas;
    }

    public byte getHeader() {
        return this.header;
    }

    public int getLength() {
        return this.length;
    }

    public void setControlType(byte b6) {
        this.controlType = b6;
    }

    public void setDatas(String str) {
        this.datas = str;
    }

    public void setHeader(byte b6) {
        this.header = b6;
    }

    public void setLength(int i6) {
        this.length = i6;
    }

    public String toString() {
        return "RequestMessage [header=" + ((int) this.header) + ", length=" + this.length + ", controlType=" + ((int) this.controlType) + ", datas=" + this.datas + "]";
    }
}
