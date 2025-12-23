package com.umeng.socialize;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocializeException extends RuntimeException {

    /* renamed from: b, reason: collision with root package name */
    private static final long f42174b = 1;

    /* renamed from: a, reason: collision with root package name */
    protected int f42175a;

    /* renamed from: c, reason: collision with root package name */
    private String f42176c;

    public SocializeException(int i6, String str) {
        super(str);
        this.f42175a = i6;
        this.f42176c = str;
    }

    public int getErrorCode() {
        return this.f42175a;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f42176c;
    }

    public SocializeException(String str, Throwable th) {
        super(str, th);
        this.f42175a = 5000;
        this.f42176c = str;
    }

    public SocializeException(String str) {
        super(str);
        this.f42175a = 5000;
        this.f42176c = str;
    }
}
