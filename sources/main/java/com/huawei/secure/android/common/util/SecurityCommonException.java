package com.huawei.secure.android.common.util;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public class SecurityCommonException extends Exception {

    /* renamed from: c, reason: collision with root package name */
    private static final long f35255c = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f35256a;

    /* renamed from: b, reason: collision with root package name */
    private String f35257b;

    public SecurityCommonException() {
    }

    public SecurityCommonException(Throwable th) {
        super(th);
    }

    public String getMsgDes() {
        return this.f35257b;
    }

    public String getRetCd() {
        return this.f35256a;
    }

    public SecurityCommonException(String str, Throwable th) {
        super(str, th);
    }

    public SecurityCommonException(String str) {
        super(str);
        this.f35257b = str;
    }

    public SecurityCommonException(String str, String str2) {
        this.f35256a = str;
        this.f35257b = str2;
    }
}
