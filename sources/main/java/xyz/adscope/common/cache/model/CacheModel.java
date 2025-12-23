package xyz.adscope.common.cache.model;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class CacheModel {

    /* renamed from: a, reason: collision with root package name */
    private String f56293a;

    /* renamed from: b, reason: collision with root package name */
    private long f56294b;

    /* renamed from: c, reason: collision with root package name */
    private long f56295c;

    /* renamed from: d, reason: collision with root package name */
    private int f56296d;

    public int getCanDelete() {
        return this.f56296d;
    }

    public String getFileName() {
        return this.f56293a;
    }

    public long getFileSize() {
        return this.f56294b;
    }

    public long getLastUsedTime() {
        return this.f56295c;
    }

    public void setCanDelete(int i6) {
        this.f56296d = i6;
    }

    public void setFileName(String str) {
        this.f56293a = str;
    }

    public void setFileSize(long j6) {
        this.f56294b = j6;
    }

    public void setLastUsedTime(long j6) {
        this.f56295c = j6;
    }
}
