package com.huawei.hms.scankit;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.k1;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.v6;
import java.util.Collection;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class d extends Thread {

    /* renamed from: a, reason: collision with root package name */
    private Context f33878a;

    /* renamed from: b, reason: collision with root package name */
    private final j0 f33879b;

    /* renamed from: c, reason: collision with root package name */
    private final Map<l1, Object> f33880c;

    /* renamed from: d, reason: collision with root package name */
    private Handler f33881d;

    /* renamed from: e, reason: collision with root package name */
    private a f33882e;

    /* renamed from: g, reason: collision with root package name */
    private Rect f33884g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f33885h = true;

    /* renamed from: f, reason: collision with root package name */
    private final CountDownLatch f33883f = new CountDownLatch(1);

    public void a(Rect rect) {
        this.f33884g = rect;
    }

    public void b() {
        this.f33878a = null;
    }

    Handler a() {
        try {
            this.f33883f.await();
        } catch (InterruptedException unused) {
            o4.b("exception", "InterruptedException");
        }
        return this.f33881d;
    }

    d(Context context, j0 j0Var, a aVar, Collection<BarcodeFormat> collection, Map<l1, ?> map, String str, v6 v6Var) {
        this.f33878a = context;
        this.f33882e = aVar;
        this.f33879b = j0Var;
        EnumMap enumMap = new EnumMap(l1.class);
        this.f33880c = enumMap;
        if (map != null) {
            enumMap.putAll(map);
        }
        if (collection == null || collection.isEmpty()) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            collection = EnumSet.noneOf(BarcodeFormat.class);
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_product", true)) {
                collection.addAll(k1.f34482a);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_1D_industrial", true)) {
                collection.addAll(k1.f34484c);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_QR", true)) {
                collection.addAll(k1.f34485d);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Data_Matrix", true)) {
                collection.addAll(k1.f34487f);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_Aztec", false)) {
                collection.addAll(k1.f34486e);
            }
            if (defaultSharedPreferences.getBoolean("preferences_decode_PDF417", false)) {
                collection.addAll(k1.f34488g);
            }
        }
        enumMap.put((EnumMap) l1.f34505c, (l1) collection);
        if (str != null) {
            enumMap.put((EnumMap) l1.f34510h, (l1) str);
        }
        enumMap.put((EnumMap) l1.f34512j, (l1) v6Var);
        o4.d("DecodeThread", "Hints: " + enumMap);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Looper.prepare();
        this.f33881d = new c(this.f33878a, this.f33879b, this.f33882e, this.f33880c, this.f33884g, this.f33885h);
        this.f33883f.countDown();
        Looper.loop();
    }

    public void a(boolean z5) {
        this.f33885h = z5;
    }
}
