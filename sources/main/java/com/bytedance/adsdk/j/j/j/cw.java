package com.bytedance.adsdk.j.j.j;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.zip.CRC32;

/* loaded from: D:\Downloads\app\classes3.dex */
public class cw extends tl<com.bytedance.adsdk.j.j.xt.j, com.bytedance.adsdk.j.j.xt.xt> {

    /* renamed from: m, reason: collision with root package name */
    static final /* synthetic */ boolean f23137m = true;
    byte[] cw;

    /* renamed from: j, reason: collision with root package name */
    public final byte f23138j;

    /* renamed from: r, reason: collision with root package name */
    List<up> f23139r;
    List<up> up;
    public final byte xt;
    private static final byte[] az = {-119, 80, 78, 71, 13, 10, 26, 10};
    private static final byte[] av = {0, 0, 0, 0, 73, 69, 78, 68, -82, 66, 96, -126};

    /* renamed from: i, reason: collision with root package name */
    private static final ThreadLocal<CRC32> f23136i = new ThreadLocal<>();

    private CRC32 j() {
        ThreadLocal<CRC32> threadLocal = f23136i;
        CRC32 crc32 = threadLocal.get();
        if (crc32 != null) {
            return crc32;
        }
        CRC32 crc322 = new CRC32();
        threadLocal.set(crc322);
        return crc322;
    }

    public cw(com.bytedance.adsdk.j.j.xt.j jVar, m mVar) {
        super(jVar);
        this.f23139r = new ArrayList();
        this.up = new ArrayList();
        this.f23138j = mVar.ws;
        this.xt = mVar.jy;
        int i6 = mVar.qv * 1000;
        short s5 = mVar.vl;
        int i7 = i6 / (s5 == 0 ? (short) 100 : s5);
        this.vl = i7;
        if (i7 < 10) {
            this.vl = 100;
        }
        this.tl = mVar.cw;
        this.f23163g = mVar.tl;
        this.oq = mVar.f23160g;
        this.qv = mVar.oq;
    }

    private int j(com.bytedance.adsdk.j.j.xt.xt xtVar) throws IOException {
        int i6;
        Iterator<up> it = this.up.iterator();
        int i7 = 33;
        while (it.hasNext()) {
            i7 += it.next().f23165r + 12;
        }
        for (up upVar : this.f23139r) {
            if (upVar instanceof oq) {
                i6 = upVar.f23165r + 12;
            } else if (upVar instanceof ae) {
                i6 = upVar.f23165r + 8;
            }
            i7 += i6;
        }
        int length = i7 + av.length;
        xtVar.cw(length);
        xtVar.j(az);
        xtVar.xt(13);
        int j6 = xtVar.j();
        xtVar.j(vl.f23166j);
        xtVar.xt(this.tl);
        xtVar.xt(this.f23163g);
        xtVar.j(this.cw);
        CRC32 j7 = j();
        j7.reset();
        j7.update(xtVar.xt(), j6, 17);
        xtVar.xt((int) j7.getValue());
        for (up upVar2 : this.up) {
            if (!(upVar2 instanceof qv)) {
                ((com.bytedance.adsdk.j.j.xt.j) this.ae).d_();
                ((com.bytedance.adsdk.j.j.xt.j) this.ae).j(upVar2.ae);
                ((com.bytedance.adsdk.j.j.xt.j) this.ae).j(xtVar.xt(), xtVar.j(), upVar2.f23165r + 12);
                xtVar.r(upVar2.f23165r + 12);
            }
        }
        for (up upVar3 : this.f23139r) {
            if (upVar3 instanceof oq) {
                ((com.bytedance.adsdk.j.j.xt.j) this.ae).d_();
                ((com.bytedance.adsdk.j.j.xt.j) this.ae).j(upVar3.ae);
                ((com.bytedance.adsdk.j.j.xt.j) this.ae).j(xtVar.xt(), xtVar.j(), upVar3.f23165r + 12);
                xtVar.r(upVar3.f23165r + 12);
            } else if (upVar3 instanceof ae) {
                xtVar.xt(upVar3.f23165r - 4);
                int j8 = xtVar.j();
                xtVar.j(oq.f23161j);
                ((com.bytedance.adsdk.j.j.xt.j) this.ae).d_();
                ((com.bytedance.adsdk.j.j.xt.j) this.ae).j(upVar3.ae + 12);
                ((com.bytedance.adsdk.j.j.xt.j) this.ae).j(xtVar.xt(), xtVar.j(), upVar3.f23165r - 4);
                xtVar.r(upVar3.f23165r - 4);
                j7.reset();
                j7.update(xtVar.xt(), j8, upVar3.f23165r);
                xtVar.xt((int) j7.getValue());
            }
        }
        xtVar.j(av);
        return length;
    }

    @Override // com.bytedance.adsdk.j.j.j.tl
    public Bitmap j(Canvas canvas, Paint paint, int i6, Bitmap bitmap, com.bytedance.adsdk.j.j.xt.xt xtVar) {
        Bitmap decodeByteArray;
        try {
            int j6 = j(xtVar);
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = false;
            options.inSampleSize = i6;
            options.inMutable = true;
            options.inBitmap = bitmap;
            byte[] xt = xtVar.xt();
            try {
                decodeByteArray = BitmapFactory.decodeByteArray(xt, 0, j6, options);
            } catch (IllegalArgumentException unused) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inJustDecodeBounds = false;
                options2.inSampleSize = i6;
                options2.inMutable = true;
                decodeByteArray = BitmapFactory.decodeByteArray(xt, 0, j6, options2);
            }
            if (!f23137m && decodeByteArray == null) {
                throw new AssertionError();
            }
            Rect rect = this.jy;
            rect.left = 0;
            rect.top = 0;
            rect.right = decodeByteArray.getWidth();
            this.jy.bottom = decodeByteArray.getHeight();
            Rect rect2 = this.ws;
            int i7 = this.oq;
            float f6 = i6;
            rect2.left = (int) (i7 / f6);
            rect2.top = (int) (this.qv / f6);
            rect2.right = (int) ((i7 / f6) + decodeByteArray.getWidth());
            this.ws.bottom = (int) ((this.qv / f6) + decodeByteArray.getHeight());
            canvas.drawBitmap(decodeByteArray, this.jy, this.ws, paint);
            return decodeByteArray;
        } catch (IOException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }
}
