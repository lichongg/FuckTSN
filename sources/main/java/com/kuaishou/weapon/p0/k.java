package com.kuaishou.weapon.p0;

import android.content.Context;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class k<T> implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private String f36057a;

    /* renamed from: b, reason: collision with root package name */
    private JSONObject f36058b;

    /* renamed from: c, reason: collision with root package name */
    private j f36059c;

    /* renamed from: d, reason: collision with root package name */
    private Context f36060d;

    /* renamed from: e, reason: collision with root package name */
    private String f36061e;

    /* renamed from: f, reason: collision with root package name */
    private String f36062f;

    @Override // java.lang.Runnable
    public void run() {
        try {
            l a6 = l.a(this.f36060d);
            m mVar = new m(this.f36057a, this.f36058b);
            mVar.a(this.f36061e);
            mVar.b(this.f36062f);
            a6.b(mVar, new j() { // from class: com.kuaishou.weapon.p0.k.1
                @Override // com.kuaishou.weapon.p0.j
                public void a(String str) {
                    e.c("WeaponHttpTask sendLog response: --- " + str);
                    if (k.this.f36059c != null) {
                        k.this.f36059c.a(str);
                    }
                }

                @Override // com.kuaishou.weapon.p0.j
                public void b(String str) {
                    e.c("WeaponHttpTask sendLog errorMsg: --- " + str);
                    if (k.this.f36059c != null) {
                        k.this.f36059c.b(str);
                    }
                }
            });
        } catch (Throwable unused) {
        }
    }

    public k(Context context, String str, String str2, String str3, JSONObject jSONObject, j jVar) {
        this.f36060d = context;
        this.f36057a = str3;
        this.f36058b = jSONObject;
        this.f36059c = jVar;
        this.f36061e = str;
        this.f36062f = str2;
    }
}
