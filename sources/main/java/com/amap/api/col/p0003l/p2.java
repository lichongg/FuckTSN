package com.amap.api.col.p0003l;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class p2 {

    /* renamed from: c, reason: collision with root package name */
    private static boolean f6882c;

    /* renamed from: d, reason: collision with root package name */
    private static volatile p2 f6883d;

    /* renamed from: a, reason: collision with root package name */
    private Hashtable<String, String> f6884a = new Hashtable<>();

    /* renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f6885b = null;

    public static p2 a() {
        if (f6883d == null) {
            synchronized (p2.class) {
                try {
                    if (f6883d == null) {
                        f6883d = new p2();
                    }
                } finally {
                }
            }
        }
        return f6883d;
    }

    private void d(String str) {
        Hashtable<String, String> hashtable;
        if (str == null || (hashtable = this.f6884a) == null) {
            return;
        }
        synchronized (hashtable) {
            try {
                String d6 = m4.d(str);
                Hashtable<String, String> hashtable2 = this.f6884a;
                if (hashtable2 != null && !hashtable2.contains(d6)) {
                    this.f6884a.put(d6, str);
                }
                if (i()) {
                    h();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static void e(boolean z5) {
        f6882c = z5;
    }

    public static void f() {
        if (f6883d != null) {
            if (f6883d.f6884a != null && f6883d.f6884a.size() > 0) {
                synchronized (f6883d.f6884a) {
                    try {
                        f6883d.h();
                        if (f6883d.f6885b != null) {
                            f6883d.f6885b.clear();
                        }
                    } finally {
                    }
                }
            }
            f6883d = null;
        }
        e(false);
    }

    public static boolean g() {
        return f6882c;
    }

    private void h() {
        WeakReference<Context> weakReference;
        if (!f6882c) {
            this.f6884a.clear();
            return;
        }
        if (this.f6884a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int size = this.f6884a.size();
            if (size > 0) {
                stringBuffer.append("[");
                Iterator<String> it = this.f6884a.values().iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    i6++;
                    stringBuffer.append(it.next());
                    if (i6 < size) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append("]");
                String stringBuffer2 = stringBuffer.toString();
                if (!TextUtils.isEmpty(stringBuffer2) && (weakReference = this.f6885b) != null && weakReference.get() != null) {
                    e7.a(stringBuffer2, this.f6885b.get());
                }
            }
            this.f6884a.clear();
        }
    }

    private boolean i() {
        Hashtable<String, String> hashtable = this.f6884a;
        return hashtable != null && hashtable.size() > 20;
    }

    public final void b(Context context) {
        if (context != null) {
            this.f6885b = new WeakReference<>(context);
        }
    }

    public final void c(LatLng latLng, String str, String str2) {
        if (!f6882c) {
            this.f6884a.clear();
            return;
        }
        if (latLng == null || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("{");
        stringBuffer.append("\"lon\":");
        stringBuffer.append(latLng.longitude);
        stringBuffer.append(",");
        stringBuffer.append("\"lat\":");
        stringBuffer.append(latLng.latitude);
        stringBuffer.append(",");
        stringBuffer.append("\"title\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        stringBuffer.append("\"snippet\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        stringBuffer.append("}");
        d(stringBuffer.toString());
    }

    private p2() {
    }
}
