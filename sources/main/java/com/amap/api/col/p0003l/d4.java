package com.amap.api.col.p0003l;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.amap.api.maps.model.LatLng;
import com.amap.api.trace.LBSTraceClient;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class d4 {

    /* renamed from: b, reason: collision with root package name */
    private static volatile d4 f5899b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, a> f5900a;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a {

        /* renamed from: a, reason: collision with root package name */
        private int f5901a;

        /* renamed from: b, reason: collision with root package name */
        private int f5902b;

        /* renamed from: d, reason: collision with root package name */
        private int f5904d;

        /* renamed from: f, reason: collision with root package name */
        private HashMap<Integer, List<LatLng>> f5906f;

        /* renamed from: c, reason: collision with root package name */
        private int f5903c = 0;

        /* renamed from: e, reason: collision with root package name */
        private int f5905e = 0;

        /* renamed from: g, reason: collision with root package name */
        private List<LatLng> f5907g = new ArrayList();

        public a(int i6, int i7, int i8, HashMap<Integer, List<LatLng>> hashMap) {
            this.f5901a = 0;
            this.f5902b = 0;
            this.f5904d = 0;
            this.f5901a = i7;
            this.f5906f = hashMap;
            this.f5902b = i6;
            this.f5904d = i8;
        }

        private void d(Handler handler) {
            if (this.f5905e <= 0) {
                d4.c(handler, this.f5902b, LBSTraceClient.MIN_GRASP_POINT_ERROR);
                return;
            }
            int a6 = a4.a(this.f5907g);
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = this.f5907g;
            obtainMessage.what = 101;
            obtainMessage.arg1 = a6;
            obtainMessage.arg2 = this.f5904d;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.f5902b);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
        }

        public final HashMap<Integer, List<LatLng>> a() {
            return this.f5906f;
        }

        public final void b(Handler handler) {
            List<LatLng> list;
            for (int i6 = this.f5903c; i6 <= this.f5901a && (list = this.f5906f.get(Integer.valueOf(i6))) != null; i6++) {
                this.f5907g.addAll(list);
                c(handler, list);
            }
            if (this.f5903c == this.f5901a + 1) {
                d(handler);
            }
        }

        private void c(Handler handler, List<LatLng> list) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.obj = list;
            obtainMessage.what = 100;
            obtainMessage.arg1 = this.f5903c;
            Bundle bundle = new Bundle();
            bundle.putInt("lineID", this.f5902b);
            obtainMessage.setData(bundle);
            handler.sendMessage(obtainMessage);
            this.f5903c++;
            this.f5905e++;
        }
    }

    public final synchronized a a(String str) {
        Map<String, a> map = this.f5900a;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final synchronized void d(String str, int i6, int i7, int i8) {
        try {
            try {
                Map<String, a> map = this.f5900a;
                if (map != null) {
                    map.put(str, new a(i6, i7, i8, new HashMap(16)));
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            throw th;
        }
    }

    public final synchronized void e(String str, int i6, List<LatLng> list) {
        Map<String, a> map = this.f5900a;
        if (map != null) {
            map.get(str).a().put(Integer.valueOf(i6), list);
        }
    }

    public static d4 b() {
        if (f5899b == null) {
            synchronized (d4.class) {
                try {
                    if (f5899b == null) {
                        f5899b = new d4();
                    }
                } finally {
                }
            }
        }
        return f5899b;
    }

    public d4() {
        this.f5900a = null;
        this.f5900a = Collections.synchronizedMap(new HashMap());
    }

    public static void c(Handler handler, int i6, String str) {
        Message obtainMessage = handler.obtainMessage();
        obtainMessage.obj = str;
        obtainMessage.what = 102;
        Bundle bundle = new Bundle();
        bundle.putInt("lineID", i6);
        obtainMessage.setData(bundle);
        handler.sendMessage(obtainMessage);
    }
}
