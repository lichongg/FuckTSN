package cn.jiguang.bi;

/* loaded from: D:\Downloads\app\classes2.dex */
public class e extends Exception {

    /* renamed from: a, reason: collision with root package name */
    public final int f2231a;

    public int a() {
        return this.f2231a;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "JException(" + this.f2231a + "):" + getLocalizedMessage();
    }

    public e(int i6, String str) {
        super(str);
        this.f2231a = i6;
    }
}
