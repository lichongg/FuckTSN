package com.uyumao;

import android.content.Context;
import com.stub.StubApp;
import com.uyumao.j;
import org.json.JSONArray;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public final class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f42560a;

    public a(Context context) {
        this.f42560a = context;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            Context context = this.f42560a;
            if (j.f42597a == null && context != null) {
                j.f42597a = StubApp.getOrigApplicationContext(context.getApplicationContext());
            }
            c.a(this.f42560a, c.a(this.f42560a, j.a.f42598a.a(), (JSONArray) null), false);
        } catch (Throwable unused) {
        }
    }
}
