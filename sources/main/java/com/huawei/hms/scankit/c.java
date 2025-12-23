package com.huawei.hms.scankit;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Display;
import android.view.WindowManager;
import com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.p.g0;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.k0;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.m0;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.s6;
import com.huawei.hms.scankit.p.w3;
import com.huawei.hms.scankit.p.y6;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
final class c extends Handler {

    /* renamed from: j, reason: collision with root package name */
    private static a f33859j;

    /* renamed from: k, reason: collision with root package name */
    private static long f33860k;

    /* renamed from: a, reason: collision with root package name */
    private final Context f33861a;

    /* renamed from: b, reason: collision with root package name */
    private final j0 f33862b;

    /* renamed from: c, reason: collision with root package name */
    private final com.huawei.hms.scankit.a f33863c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f33864d = true;

    /* renamed from: e, reason: collision with root package name */
    private int f33865e = 50;

    /* renamed from: f, reason: collision with root package name */
    private Rect f33866f;

    /* renamed from: g, reason: collision with root package name */
    private int f33867g;

    /* renamed from: h, reason: collision with root package name */
    private IRemoteFrameDecoderDelegate f33868h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33869i;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a extends AsyncTask<Object, Object, Object> {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<c> f33870a;

        /* renamed from: e, reason: collision with root package name */
        private List<k0.a> f33874e;

        /* renamed from: f, reason: collision with root package name */
        private List<k0.a> f33875f;

        /* renamed from: b, reason: collision with root package name */
        private boolean f33871b = true;

        /* renamed from: c, reason: collision with root package name */
        private boolean f33872c = false;

        /* renamed from: d, reason: collision with root package name */
        private int f33873d = 0;

        /* renamed from: g, reason: collision with root package name */
        private int f33876g = 0;

        /* renamed from: h, reason: collision with root package name */
        private int f33877h = 0;

        public void b(int i6) {
            this.f33877h = i6;
            c cVar = this.f33870a.get();
            if (cVar != null) {
                try {
                    cVar.a(this.f33877h, this.f33875f);
                    o4.d("DecodeHandler", "ScanCode handle global value" + this.f33877h);
                } catch (RuntimeException e6) {
                    o4.b("DecodeHandler", "RuntimeException: " + e6.getMessage());
                } catch (Exception unused) {
                    o4.b("DecodeHandler", "Exception");
                }
            }
        }

        public void a(int i6) {
            this.f33873d += i6;
            this.f33876g++;
        }

        @Override // android.os.AsyncTask
        protected Object doInBackground(Object... objArr) {
            if (c.f33859j.isCancelled()) {
                return null;
            }
            while (!this.f33872c) {
                if (this.f33871b) {
                    try {
                        Thread.sleep(400L);
                    } catch (InterruptedException unused) {
                        o4.d("ScankitDecode", "doInBackground  get InterruptedException  error!!!");
                    }
                    this.f33871b = false;
                } else {
                    c cVar = this.f33870a.get();
                    int i6 = this.f33876g;
                    if (i6 == 0) {
                        this.f33871b = true;
                    } else if (cVar != null) {
                        try {
                            cVar.a(this.f33873d / i6, this.f33874e);
                            o4.d("DecodeHandler", "ScanCode handle auto value" + (this.f33873d / this.f33876g));
                            a();
                            this.f33871b = true;
                        } catch (RuntimeException e6) {
                            o4.b("DecodeHandler", "RuntimeException: " + e6.getMessage());
                        } catch (Exception unused2) {
                            o4.b("DecodeHandler", "Exception");
                        }
                    }
                }
            }
            return null;
        }

        public a(c cVar) {
            this.f33870a = new WeakReference<>(cVar);
        }

        public void a(List<Rect> list, int i6, int i7, boolean z5) {
            if (list == null) {
                o4.a("ScankitDecode", "areas is null");
                return;
            }
            if (list.size() == 0) {
                this.f33875f = Collections.singletonList(new k0.a(new Rect(-100, -100, 100, 100), 1000));
                return;
            }
            this.f33875f = new ArrayList();
            for (Rect rect : list) {
                int centerX = ((rect.centerX() * 2000) / i6) - 1000;
                int centerY = ((rect.centerY() * 2000) / i7) - 1000;
                int width = ((rect.width() * 2000) / i6) / 2;
                int height = ((rect.height() * 2000) / i7) / 2;
                this.f33875f.add(new k0.a(new Rect(centerX - (width / 2), centerY - (height / 2), centerX + width, centerY + height), 1000 / list.size()));
            }
            list.clear();
        }

        public void b(List<Rect> list, int i6, int i7, boolean z5) {
            if (list == null) {
                o4.a("ScankitDecode", "areas is null");
                return;
            }
            if (list.size() == 0) {
                this.f33874e = Collections.singletonList(new k0.a(new Rect(-100, -100, 100, 100), 1000));
                return;
            }
            this.f33874e = new ArrayList();
            if (z5) {
                int i8 = (i7 > i6 ? i7 - i6 : i6 - i7) >> 1;
                for (Rect rect : list) {
                    int centerY = (((rect.centerY() + i8) * 2000) / i6) - 1000;
                    int centerX = ((rect.centerX() * 2000) / i7) - 1000;
                    int height = ((rect.height() * 2000) / i6) / 2;
                    int width = ((rect.width() * 2000) / i7) / 2;
                    this.f33874e.add(new k0.a(new Rect(centerY - (height / 2), centerX - (width / 2), centerY + height, centerX + width), 1000 / list.size()));
                }
                return;
            }
            for (Rect rect2 : list) {
                int centerX2 = ((rect2.centerX() * 2000) / i6) - 1000;
                int centerY2 = ((rect2.centerY() * 2000) / i7) - 1000;
                int width2 = ((rect2.width() * 2000) / i6) / 2;
                int height2 = ((rect2.height() * 2000) / i7) / 2;
                this.f33874e.add(new k0.a(new Rect(centerX2 - (width2 / 2), centerY2 - (height2 / 2), centerX2 + width2, centerY2 + height2), 1000 / list.size()));
            }
            list.clear();
        }

        private void a() {
            this.f33873d = 0;
            this.f33876g = 0;
        }
    }

    public boolean b(float f6) {
        boolean z5;
        com.huawei.hms.scankit.a aVar = this.f33863c;
        if (aVar != null && aVar.a()) {
            return false;
        }
        try {
            m0 g6 = this.f33862b.g();
            if (g6 == null) {
                o4.d("ScankitDecode", "Zoom not supported,data is null");
                return false;
            }
            int c6 = g6.c();
            int b6 = g6.b();
            float intValue = ((r1.get(b6).intValue() * 1.0f) / 100.0f) * f6;
            if (((int) (intValue * 100.0f)) > g6.a().get(c6).intValue()) {
                intValue = (c6 * 1.0f) / 100.0f;
            }
            if (!this.f33862b.j()) {
                o4.d("ScankitDecode", "Zoom not supported");
                return false;
            }
            int a6 = a(intValue);
            if (a6 > b6) {
                this.f33862b.d(a6);
                z5 = true;
            } else {
                this.f33862b.d(b6);
                z5 = false;
            }
            this.f33862b.a(Collections.singletonList(new k0.a(new Rect(-150, -150, 150, 150), 1000)));
            return z5;
        } catch (RuntimeException unused) {
            o4.b("ScankitDecode", "Zoom not supported,RuntimeException happen");
            return false;
        } catch (Exception unused2) {
            o4.b("ScankitDecode", "Zoom not supported,Exception happen");
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004c A[Catch: RemoteException -> 0x0057, TryCatch #4 {RemoteException -> 0x0057, blocks: (B:7:0x003b, B:9:0x003f, B:12:0x004c, B:14:0x0050), top: B:6:0x003b }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003f A[Catch: RemoteException -> 0x0057, TryCatch #4 {RemoteException -> 0x0057, blocks: (B:7:0x003b, B:9:0x003f, B:12:0x004c, B:14:0x0050), top: B:6:0x003b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.content.Context r4) {
        /*
            r3 = this;
            java.lang.String r0 = "ScankitDecode"
            boolean r1 = r3.f33869i     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            if (r1 == 0) goto Ld
            java.lang.Class<com.huawei.hms.scankit.DecoderCreator> r4 = com.huawei.hms.scankit.DecoderCreator.class
            java.lang.Object r4 = r4.newInstance()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            goto L3b
        Ld:
            android.content.Context r4 = com.huawei.hms.hmsscankit.g.e(r4)     // Catch: java.lang.Throwable -> L11 java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
        L11:
            java.lang.ClassLoader r1 = r4.getClassLoader()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.String r2 = "com.huawei.hms.scankit.DecoderCreator"
            java.lang.Class r1 = r1.loadClass(r2)     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.ClassLoader r4 = r4.getClassLoader()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.String r2 = "com.huawei.hms.scankit.aiscan.common.BarcodeFormat"
            r4.loadClass(r2)     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            java.lang.Object r4 = r1.newInstance()     // Catch: java.lang.InstantiationException -> L29 java.lang.ClassNotFoundException -> L2f java.lang.IllegalAccessException -> L35
            goto L3b
        L29:
            java.lang.String r4 = "InstantiationException"
            com.huawei.hms.scankit.p.o4.a(r0, r4)
            goto L3a
        L2f:
            java.lang.String r4 = "ClassNotFoundException"
            com.huawei.hms.scankit.p.o4.a(r0, r4)
            goto L3a
        L35:
            java.lang.String r4 = "IllegalAccessException"
            com.huawei.hms.scankit.p.o4.a(r0, r4)
        L3a:
            r4 = 0
        L3b:
            boolean r1 = r4 instanceof android.os.IBinder     // Catch: android.os.RemoteException -> L57
            if (r1 == 0) goto L4c
            android.os.IBinder r4 = (android.os.IBinder) r4     // Catch: android.os.RemoteException -> L57
            com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator r4 = com.huawei.hms.hmsscankit.api.IRemoteDecoderCreator.Stub.asInterface(r4)     // Catch: android.os.RemoteException -> L57
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r4 = r4.newRemoteFrameDecoderDelegate()     // Catch: android.os.RemoteException -> L57
            r3.f33868h = r4     // Catch: android.os.RemoteException -> L57
            goto L5c
        L4c:
            com.huawei.hms.hmsscankit.api.IRemoteFrameDecoderDelegate r4 = r3.f33868h     // Catch: android.os.RemoteException -> L57
            if (r4 != 0) goto L5c
            com.huawei.hms.scankit.p.h4 r4 = com.huawei.hms.scankit.p.h4.a()     // Catch: android.os.RemoteException -> L57
            r3.f33868h = r4     // Catch: android.os.RemoteException -> L57
            goto L5c
        L57:
            java.lang.String r4 = "RemoteException"
            com.huawei.hms.scankit.p.o4.a(r0, r4)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.c.a(android.content.Context):void");
    }

    private boolean d() {
        Context context = this.f33861a;
        if (context == null) {
            return true;
        }
        Object systemService = context.getSystemService("window");
        if (!(systemService instanceof WindowManager)) {
            o4.d("ScankitDecode", "isScreenPortrait  getSystemService  WINDOW_SERVICE  error!!!");
            return true;
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x < point.y;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        if (message == null || !this.f33864d) {
            return;
        }
        int i6 = message.what;
        if (i6 == R.id.scankit_decode) {
            int i7 = this.f33867g;
            if (i7 <= 1) {
                this.f33867g = i7 + 1;
                this.f33863c.sendEmptyMessage(R.id.scankit_decode_failed);
                return;
            } else {
                Object obj = message.obj;
                if (obj instanceof byte[]) {
                    a((byte[]) obj, d());
                    return;
                }
                return;
            }
        }
        if (i6 != R.id.scankit_quit) {
            o4.d("ScankitDecode", "handleMessage  message.what:" + message.what);
            return;
        }
        this.f33864d = false;
        a aVar = f33859j;
        if (aVar != null) {
            aVar.f33872c = true;
            f33859j.cancel(true);
        }
        Looper.myLooper().quit();
    }

    c(Context context, j0 j0Var, com.huawei.hms.scankit.a aVar, Map<l1, Object> map, Rect rect, boolean z5) {
        this.f33869i = false;
        this.f33861a = context;
        this.f33862b = j0Var;
        this.f33863c = aVar;
        this.f33866f = rect;
        if (f33859j == null) {
            a aVar2 = new a(this);
            f33859j = aVar2;
            aVar2.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
        }
        this.f33867g = 0;
        this.f33869i = z5;
        a(context);
    }

    public float c() {
        if (b() == null) {
            return 1.0f;
        }
        return Math.round(r0.get(r0.size() - 1).intValue() / 100.0f);
    }

    public List<Integer> b() {
        return this.f33862b.g().a();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(byte[] r12, boolean r13) {
        /*
            Method dump skipped, instructions count: 435
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.scankit.c.a(byte[], boolean):void");
    }

    private boolean a(float f6, s6[] s6VarArr, w3.c cVar) {
        if (!b(f6)) {
            return false;
        }
        Message obtain = Message.obtain();
        obtain.what = R.id.scankit_decode_succeeded;
        HmsScan[] a6 = y6.a(s6VarArr);
        obtain.obj = a6;
        if (b.J != null) {
            b.J.a(a6, cVar);
        }
        this.f33863c.sendMessage(obtain);
        return true;
    }

    private void a(s6[] s6VarArr, byte[] bArr, int i6, int i7, w3.c cVar) {
        if (this.f33863c != null) {
            Message obtain = Message.obtain(this.f33863c, R.id.scankit_decode_succeeded, y6.a(s6VarArr));
            try {
                if (b.I != null) {
                    b.I.a(s6VarArr[0].e(), s6VarArr[0].b(), s6VarArr[0].m());
                }
            } catch (Exception unused) {
            }
            if (this.f33863c.c()) {
                Bundle bundle = new Bundle();
                a(bArr, i6, i7, bundle);
                obtain.setData(bundle);
            }
            obtain.sendToTarget();
        }
    }

    private static void a(byte[] bArr, int i6, int i7, Bundle bundle) {
        if (bArr == null || bArr.length == 0) {
            return;
        }
        YuvImage yuvImage = new YuvImage(bArr, 17, i6, i7, null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, i6, i7), 100, byteArrayOutputStream);
        bundle.putByteArray("barcode_bitmap", byteArrayOutputStream.toByteArray());
        bundle.putFloat("barcode_scaled_factor", 1.0f);
        try {
            byteArrayOutputStream.close();
        } catch (IOException unused) {
        }
    }

    public void a(Rect rect, boolean z5) {
        com.huawei.hms.scankit.a aVar = this.f33863c;
        if (aVar == null || !aVar.a()) {
            this.f33862b.a(rect, z5);
        }
    }

    public void a(int i6, List<k0.a> list) {
        g0 b6 = this.f33862b.b();
        int b7 = b6.b();
        int c6 = b6.c();
        int a6 = b6.a();
        if (i6 == 0) {
            return;
        }
        int i7 = a6 + i6;
        if (i7 <= b7) {
            b7 = i7 < c6 ? c6 : i7;
        }
        this.f33862b.c(b7);
        k0 c7 = this.f33862b.c();
        Rect b8 = c7.b();
        if (c7.a() > 0) {
            if (c7.a() == 1) {
                int centerX = b8.centerX();
                int centerY = b8.centerY();
                if (Math.sqrt(((centerX - list.get(0).f34480a.centerX()) * (centerX - list.get(0).f34480a.centerX())) + (centerY - list.get(0).f34480a.centerY()) + (centerY - list.get(0).f34480a.centerY())) > this.f33865e) {
                    list.set(0, new k0.a(list.get(0).f34480a, 1000));
                    this.f33862b.a(list.subList(0, 1));
                    return;
                }
                return;
            }
            this.f33862b.a(list);
        }
    }

    public int a(float f6) {
        List<Integer> b6 = b();
        if (b6 == null) {
            return -3;
        }
        if (b6.size() <= 0) {
            return -4;
        }
        if (Math.abs(f6 - 1.0f) < 1.0E-6f) {
            return 0;
        }
        if (f6 == c()) {
            return b6.size() - 1;
        }
        for (int i6 = 1; i6 < b6.size(); i6++) {
            float f7 = 100.0f * f6;
            if (b6.get(i6).intValue() >= f7 && b6.get(i6 - 1).intValue() <= f7) {
                return i6;
            }
        }
        return -1;
    }
}
