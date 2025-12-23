package com.bykv.vk.component.ttvideo.mediakit.net;

/* loaded from: D:\Downloads\app\classes3.dex */
public class Error {
    int code;
    public String errStr;
    public String host;
    public String id;

    public Error(int i6, String str, String str2) {
        this.code = i6;
        this.host = str;
        this.id = str2;
        this.errStr = null;
    }

    public Error(int i6, String str, String str2, String str3) {
        this.code = i6;
        this.host = str;
        this.id = str2;
        this.errStr = str3;
    }
}
