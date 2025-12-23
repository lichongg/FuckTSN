package cn.jpush.android.f;

import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private String f3655a;

    /* renamed from: b, reason: collision with root package name */
    private long f3656b;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f3657c;

    @Override // java.lang.Runnable
    public final void run() {
        c.a(this.f3655a, this.f3656b, this.f3657c);
    }

    public d(String str, long j6, JSONObject jSONObject) {
        this.f3655a = str;
        this.f3656b = j6;
        this.f3657c = jSONObject;
    }
}
