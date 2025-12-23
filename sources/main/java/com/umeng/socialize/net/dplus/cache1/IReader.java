package com.umeng.socialize.net.dplus.cache1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public abstract class IReader<T> {

    /* renamed from: a, reason: collision with root package name */
    private String f42473a;
    public T result;

    public static double formatSize(long j6) {
        return (j6 / 1024.0d) / 1024.0d;
    }

    public abstract void create(String str);

    public String getLogFileName() {
        return this.f42473a;
    }

    public IReader(String str) {
        this.f42473a = str;
    }
}
