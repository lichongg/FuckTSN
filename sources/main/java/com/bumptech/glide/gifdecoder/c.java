package com.bumptech.glide.gifdecoder;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class c {

    /* renamed from: e, reason: collision with root package name */
    private static final String f14838e = "GifHeaderParser";

    /* renamed from: f, reason: collision with root package name */
    private static final int f14839f = 255;

    /* renamed from: g, reason: collision with root package name */
    private static final int f14840g = 44;

    /* renamed from: h, reason: collision with root package name */
    private static final int f14841h = 33;

    /* renamed from: i, reason: collision with root package name */
    private static final int f14842i = 59;

    /* renamed from: j, reason: collision with root package name */
    private static final int f14843j = 249;

    /* renamed from: k, reason: collision with root package name */
    private static final int f14844k = 255;

    /* renamed from: l, reason: collision with root package name */
    private static final int f14845l = 254;

    /* renamed from: m, reason: collision with root package name */
    private static final int f14846m = 1;

    /* renamed from: n, reason: collision with root package name */
    private static final int f14847n = 28;

    /* renamed from: o, reason: collision with root package name */
    private static final int f14848o = 2;

    /* renamed from: p, reason: collision with root package name */
    private static final int f14849p = 1;

    /* renamed from: q, reason: collision with root package name */
    private static final int f14850q = 128;

    /* renamed from: r, reason: collision with root package name */
    private static final int f14851r = 64;

    /* renamed from: s, reason: collision with root package name */
    private static final int f14852s = 7;

    /* renamed from: t, reason: collision with root package name */
    private static final int f14853t = 128;

    /* renamed from: u, reason: collision with root package name */
    private static final int f14854u = 7;

    /* renamed from: v, reason: collision with root package name */
    static final int f14855v = 2;

    /* renamed from: w, reason: collision with root package name */
    static final int f14856w = 10;

    /* renamed from: x, reason: collision with root package name */
    private static final int f14857x = 256;

    /* renamed from: b, reason: collision with root package name */
    private ByteBuffer f14859b;

    /* renamed from: c, reason: collision with root package name */
    private b f14860c;

    /* renamed from: a, reason: collision with root package name */
    private final byte[] f14858a = new byte[256];

    /* renamed from: d, reason: collision with root package name */
    private int f14861d = 0;

    private void j(int i6) {
        boolean z5 = false;
        while (!z5 && !b() && this.f14860c.f14827c <= i6) {
            int e6 = e();
            if (e6 == 33) {
                int e7 = e();
                if (e7 == 1) {
                    s();
                } else if (e7 == 249) {
                    this.f14860c.f14828d = new a();
                    k();
                } else if (e7 == 254) {
                    s();
                } else if (e7 != 255) {
                    s();
                } else {
                    g();
                    StringBuilder sb = new StringBuilder();
                    for (int i7 = 0; i7 < 11; i7++) {
                        sb.append((char) this.f14858a[i7]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        n();
                    } else {
                        s();
                    }
                }
            } else if (e6 == 44) {
                b bVar = this.f14860c;
                if (bVar.f14828d == null) {
                    bVar.f14828d = new a();
                }
                f();
            } else if (e6 != 59) {
                this.f14860c.f14826b = 1;
            } else {
                z5 = true;
            }
        }
    }

    private void p() {
        this.f14859b = null;
        Arrays.fill(this.f14858a, (byte) 0);
        this.f14860c = new b();
        this.f14861d = 0;
    }

    public void a() {
        this.f14859b = null;
        this.f14860c = null;
    }

    private boolean b() {
        return this.f14860c.f14826b != 0;
    }

    private int e() {
        try {
            return this.f14859b.get() & 255;
        } catch (Exception unused) {
            this.f14860c.f14826b = 1;
            return 0;
        }
    }

    private void f() {
        this.f14860c.f14828d.f14812a = o();
        this.f14860c.f14828d.f14813b = o();
        this.f14860c.f14828d.f14814c = o();
        this.f14860c.f14828d.f14815d = o();
        int e6 = e();
        boolean z5 = (e6 & 128) != 0;
        int pow = (int) Math.pow(2.0d, (e6 & 7) + 1);
        a aVar = this.f14860c.f14828d;
        aVar.f14816e = (e6 & 64) != 0;
        if (z5) {
            aVar.f14822k = h(pow);
        } else {
            aVar.f14822k = null;
        }
        this.f14860c.f14828d.f14821j = this.f14859b.position();
        t();
        if (b()) {
            return;
        }
        b bVar = this.f14860c;
        bVar.f14827c++;
        bVar.f14829e.add(bVar.f14828d);
    }

    @Nullable
    private int[] h(int i6) {
        byte[] bArr = new byte[i6 * 3];
        int[] iArr = null;
        try {
            this.f14859b.get(bArr);
            iArr = new int[256];
            int i7 = 0;
            int i8 = 0;
            while (i7 < i6) {
                int i9 = bArr[i8] & 255;
                int i10 = i8 + 2;
                int i11 = bArr[i8 + 1] & 255;
                i8 += 3;
                int i12 = i7 + 1;
                iArr[i7] = (i11 << 8) | (i9 << 16) | ViewCompat.MEASURED_STATE_MASK | (bArr[i10] & 255);
                i7 = i12;
            }
            return iArr;
        } catch (BufferUnderflowException unused) {
            Log.isLoggable(f14838e, 3);
            this.f14860c.f14826b = 1;
            return iArr;
        }
    }

    private void l() {
        StringBuilder sb = new StringBuilder();
        for (int i6 = 0; i6 < 6; i6++) {
            sb.append((char) e());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f14860c.f14826b = 1;
            return;
        }
        m();
        if (!this.f14860c.f14832h || b()) {
            return;
        }
        b bVar = this.f14860c;
        bVar.f14825a = h(bVar.f14833i);
        b bVar2 = this.f14860c;
        bVar2.f14836l = bVar2.f14825a[bVar2.f14834j];
    }

    private void m() {
        this.f14860c.f14830f = o();
        this.f14860c.f14831g = o();
        int e6 = e();
        b bVar = this.f14860c;
        bVar.f14832h = (e6 & 128) != 0;
        bVar.f14833i = (int) Math.pow(2.0d, (e6 & 7) + 1);
        this.f14860c.f14834j = e();
        this.f14860c.f14835k = e();
    }

    private int o() {
        return this.f14859b.getShort();
    }

    @NonNull
    public b d() {
        if (this.f14859b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f14860c;
        }
        l();
        if (!b()) {
            i();
            b bVar = this.f14860c;
            if (bVar.f14827c < 0) {
                bVar.f14826b = 1;
            }
        }
        return this.f14860c;
    }

    public c r(@Nullable byte[] bArr) {
        if (bArr != null) {
            q(ByteBuffer.wrap(bArr));
            return this;
        }
        this.f14859b = null;
        this.f14860c.f14826b = 2;
        return this;
    }

    private void g() {
        int e6 = e();
        this.f14861d = e6;
        if (e6 > 0) {
            int i6 = 0;
            while (true) {
                try {
                    int i7 = this.f14861d;
                    if (i6 < i7) {
                        int i8 = i7 - i6;
                        this.f14859b.get(this.f14858a, i6, i8);
                        i6 += i8;
                    } else {
                        return;
                    }
                } catch (Exception unused) {
                    Log.isLoggable(f14838e, 3);
                    this.f14860c.f14826b = 1;
                    return;
                }
            }
        }
    }

    private void i() {
        j(Integer.MAX_VALUE);
    }

    private void k() {
        e();
        int e6 = e();
        a aVar = this.f14860c.f14828d;
        int i6 = (e6 & 28) >> 2;
        aVar.f14818g = i6;
        boolean z5 = true;
        if (i6 == 0) {
            aVar.f14818g = 1;
        }
        if ((e6 & 1) == 0) {
            z5 = false;
        }
        aVar.f14817f = z5;
        int o5 = o();
        if (o5 < 2) {
            o5 = 10;
        }
        a aVar2 = this.f14860c.f14828d;
        aVar2.f14820i = o5 * 10;
        aVar2.f14819h = e();
        e();
    }

    private void n() {
        do {
            g();
            byte[] bArr = this.f14858a;
            if (bArr[0] == 1) {
                this.f14860c.f14837m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f14861d <= 0) {
                return;
            }
        } while (!b());
    }

    private void s() {
        int e6;
        do {
            e6 = e();
            this.f14859b.position(Math.min(this.f14859b.position() + e6, this.f14859b.limit()));
        } while (e6 > 0);
    }

    private void t() {
        e();
        s();
    }

    public boolean c() {
        l();
        if (!b()) {
            j(2);
        }
        if (this.f14860c.f14827c > 1) {
            return true;
        }
        return false;
    }

    public c q(@NonNull ByteBuffer byteBuffer) {
        p();
        ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f14859b = asReadOnlyBuffer;
        asReadOnlyBuffer.position(0);
        this.f14859b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
