package com.umeng.analytics.pro;

import android.text.TextUtils;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class an implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public static final String f40866a = "https://aspect-upush.umeng.com/occa/v1/event/report";

    /* renamed from: b, reason: collision with root package name */
    private String f40867b;

    /* renamed from: c, reason: collision with root package name */
    private String f40868c;

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (TextUtils.isEmpty(this.f40868c)) {
                return;
            }
            am.b(this.f40867b, this.f40868c.getBytes());
        } catch (Throwable unused) {
        }
    }

    public an(String str, JSONObject jSONObject) {
        this.f40867b = str;
        this.f40868c = jSONObject.toString();
    }
}
