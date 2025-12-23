package com.kwad.sdk;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class e {
    public static final e arU = new e(10000, "其他异常");
    public static final e arV = new e(10001, "初始化参数异常");
    public static final e arW = new e(11001, "SDK未调用init方法");
    public int code;
    public String msg;

    public e(int i6, String str) {
        this.code = i6;
        this.msg = str;
    }
}
