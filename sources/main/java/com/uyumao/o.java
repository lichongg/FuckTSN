package com.uyumao;

import android.content.Context;
import android.text.TextUtils;
import com.stub.StubApp;
import com.umeng.analytics.pro.bi;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class o {

    /* renamed from: a, reason: collision with root package name */
    public static volatile o f42607a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f42608b;

    /* renamed from: c, reason: collision with root package name */
    public final a f42609c = new a(this, "AZX");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public final String f42610a;

        public final void a(String str, String str2) {
            try {
                if (n.c(e.f42582a)) {
                    m a6 = m.a();
                    a6.getClass();
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    a6.f42602b.edit().putString(str, str2).apply();
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }

        public void b(String str, long j6) {
            a(this.f42610a + str, String.valueOf(j6));
        }

        public a(o oVar, String str) {
            if (!TextUtils.isEmpty(str)) {
                str = str + "_";
            }
            this.f42610a = str;
        }

        public long a(String str, long j6) {
            String str2 = this.f42610a + str;
            String valueOf = String.valueOf(j6);
            try {
                if (n.c(e.f42582a)) {
                    valueOf = m.a().f42602b.getString(str2, valueOf);
                }
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            try {
                return Long.parseLong(valueOf);
            } catch (Exception unused) {
                return j6;
            }
        }
    }

    public void a(long j6) {
        this.f42609c.b(com.umeng.socialize.a.a.f42201e + bi.aX, j6);
        this.f42609c.b(com.umeng.socialize.a.a.f42201e + "ts", System.currentTimeMillis());
    }

    public o(Context context) {
        this.f42608b = StubApp.getOrigApplicationContext(context.getApplicationContext());
    }

    public final boolean a(String str) {
        long a6 = this.f42609c.a(str + bi.aX, 0L);
        if (a6 <= 0) {
            return true;
        }
        a aVar = this.f42609c;
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("ts");
        return Math.abs(System.currentTimeMillis() - aVar.a(sb.toString(), 0L)) / 1000 >= a6;
    }

    public long a() {
        return this.f42609c.a(com.umeng.socialize.a.a.f42200d, 0L);
    }
}
