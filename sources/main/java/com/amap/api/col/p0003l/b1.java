package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.g4;
import com.amap.api.maps.AMapException;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class b1<T, V> {

    /* renamed from: a, reason: collision with root package name */
    protected T f5687a;

    /* renamed from: b, reason: collision with root package name */
    protected int f5688b = 3;

    /* renamed from: c, reason: collision with root package name */
    protected Context f5689c;

    private V g() throws AMapException {
        int i6;
        String str;
        AMapException aMapException;
        int i7 = 0;
        V v5 = null;
        g4.c cVar = null;
        while (i7 < this.f5688b) {
            try {
                cVar = g4.c(this.f5689c, b3.s(), b(), e());
                v5 = a(c(cVar));
                i7 = this.f5688b;
            } finally {
                if (i7 < i6) {
                    continue;
                }
            }
        }
        return v5;
    }

    protected abstract V a(JSONObject jSONObject) throws AMapException;

    protected abstract String b();

    protected abstract JSONObject c(g4.c cVar);

    protected abstract Map<String, String> e();

    private void d(Context context, T t5) {
        this.f5689c = context;
        this.f5687a = t5;
    }

    public final V f() throws AMapException {
        if (this.f5687a != null) {
            return g();
        }
        return null;
    }

    public b1(Context context, T t5) {
        d(context, t5);
    }
}
