package com.huawei.hms.scankit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.scankit.aiscan.common.BarcodeFormat;
import com.huawei.hms.scankit.p.e5;
import com.huawei.hms.scankit.p.f5;
import com.huawei.hms.scankit.p.i8;
import com.huawei.hms.scankit.p.j0;
import com.huawei.hms.scankit.p.l1;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.u6;
import com.huawei.hms.scankit.p.v5;
import com.huawei.hms.scankit.p.v6;
import java.util.Collection;
import java.util.Map;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class a extends Handler implements v6 {

    /* renamed from: a, reason: collision with root package name */
    private final f5 f33795a;

    /* renamed from: b, reason: collision with root package name */
    private d f33796b;

    /* renamed from: c, reason: collision with root package name */
    private final int f33797c;

    /* renamed from: d, reason: collision with root package name */
    private EnumC0546a f33798d;

    /* renamed from: e, reason: collision with root package name */
    private Context f33799e;

    /* renamed from: f, reason: collision with root package name */
    private final j0 f33800f;

    /* renamed from: g, reason: collision with root package name */
    private final ViewfinderView f33801g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f33802h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f33803i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f33804j;

    /* renamed from: k, reason: collision with root package name */
    private e5 f33805k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f33806l;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.huawei.hms.scankit.a$a, reason: collision with other inner class name */
    private enum EnumC0546a {
        PREVIEW,
        SUCCESS,
        DONE
    }

    a(Context context, ViewfinderView viewfinderView, f5 f5Var, Collection<BarcodeFormat> collection, Map<l1, ?> map, String str, j0 j0Var, Rect rect, int i6, boolean z5, boolean z6) {
        this.f33801g = viewfinderView;
        this.f33795a = f5Var;
        this.f33797c = i6;
        this.f33799e = context;
        d dVar = new d(context, j0Var, this, collection, map, str, this);
        this.f33796b = dVar;
        dVar.a(rect);
        this.f33796b.a(z6);
        this.f33796b.start();
        this.f33806l = z5;
        j0Var.a(new j(this.f33796b));
        this.f33798d = EnumC0546a.SUCCESS;
        this.f33800f = j0Var;
        j0Var.p();
        o4.a("scan-time", "start preview time:" + System.currentTimeMillis());
        f();
        v5.a(null);
    }

    public void a(e5 e5Var) {
        this.f33805k = e5Var;
    }

    public int b() {
        return this.f33797c;
    }

    public void c(boolean z5) {
        this.f33802h = z5;
    }

    private u6 b(u6 u6Var) {
        float b6;
        float c6;
        int max;
        Point b7 = i8.b(this.f33799e);
        Point e6 = this.f33800f.e();
        int i6 = b7.x;
        int i7 = b7.y;
        if (i6 < i7) {
            b6 = (u6Var.b() * ((i6 * 1.0f) / e6.y)) - (Math.max(b7.x, e6.y) / 2.0f);
            c6 = u6Var.c() * ((i7 * 1.0f) / e6.x);
            max = Math.min(b7.y, e6.x);
        } else {
            b6 = (u6Var.b() * ((i6 * 1.0f) / e6.x)) - (Math.min(b7.y, e6.y) / 2.0f);
            c6 = u6Var.c() * ((i7 * 1.0f) / e6.y);
            max = Math.max(b7.x, e6.x);
        }
        return new u6(b6, c6 - (max / 2.0f));
    }

    public boolean a() {
        e5 e5Var = this.f33805k;
        if (e5Var != null) {
            return e5Var.a();
        }
        return false;
    }

    public boolean c() {
        return this.f33803i;
    }

    public boolean d() {
        return this.f33804j;
    }

    public void e() {
        this.f33798d = EnumC0546a.DONE;
        this.f33800f.q();
        Message.obtain(this.f33796b.a(), R.id.scankit_quit).sendToTarget();
        try {
            this.f33796b.b();
            this.f33796b.join(50L);
        } catch (InterruptedException unused) {
            o4.e("CaptureHandler", "quitSynchronously   wait interrupt");
        }
        this.f33796b = null;
        removeMessages(R.id.scankit_decode_succeeded);
        removeMessages(R.id.scankit_decode_failed);
    }

    public void f() {
        if (this.f33798d == EnumC0546a.SUCCESS) {
            this.f33798d = EnumC0546a.PREVIEW;
            this.f33800f.o();
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        HmsScan hmsScan;
        int i6 = message.what;
        if (i6 == R.id.scankit_restart_preview) {
            f();
            return;
        }
        if (i6 != R.id.scankit_decode_succeeded) {
            if (i6 == R.id.scankit_decode_failed) {
                this.f33798d = EnumC0546a.PREVIEW;
                this.f33800f.o();
                return;
            }
            return;
        }
        this.f33798d = EnumC0546a.SUCCESS;
        Object obj = message.obj;
        if (obj instanceof HmsScan[]) {
            HmsScan[] hmsScanArr = (HmsScan[]) obj;
            if (hmsScanArr.length <= 0 || (hmsScan = hmsScanArr[0]) == null || TextUtils.isEmpty(hmsScan.originalValue)) {
                o4.d("CaptureHandler", "retrieve  HmsScan lenth is 0");
            } else {
                o4.d("CaptureHandler", "scan successful");
                Bitmap bitmap = null;
                float f6 = 0.0f;
                if (this.f33803i) {
                    o4.d("CaptureHandler", "scan successful & return bitmap");
                    Bundle data = message.getData();
                    if (data != null) {
                        byte[] byteArray = data.getByteArray("barcode_bitmap");
                        f6 = data.getFloat("barcode_scaled_factor", 0.0f);
                        if (byteArray != null && byteArray.length > 0) {
                            bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                        }
                    }
                    this.f33795a.a(hmsScanArr, bitmap, f6);
                } else {
                    this.f33795a.a(hmsScanArr, null, 0.0f);
                }
                if (!this.f33806l) {
                    return;
                }
            }
            f();
        }
    }

    @Override // com.huawei.hms.scankit.p.v6
    public void a(u6 u6Var) {
        if (this.f33801g != null) {
            this.f33801g.a(b(u6Var));
        }
    }

    public void a(boolean z5) {
        this.f33803i = z5;
    }

    public void b(boolean z5) {
        this.f33804j = z5;
    }
}
