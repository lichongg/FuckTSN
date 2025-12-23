package com.bumptech.glide.gifdecoder;

import android.graphics.Bitmap;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.gifdecoder.GifDecoder;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class d implements GifDecoder {
    private static final String A = "d";
    private static final int B = 4096;
    private static final int C = -1;
    private static final int D = -1;
    private static final int E = 4;
    private static final int F = 255;

    @ColorInt
    private static final int G = 0;

    /* renamed from: f, reason: collision with root package name */
    @ColorInt
    private int[] f14862f;

    /* renamed from: g, reason: collision with root package name */
    @ColorInt
    private final int[] f14863g;

    /* renamed from: h, reason: collision with root package name */
    private final GifDecoder.a f14864h;

    /* renamed from: i, reason: collision with root package name */
    private ByteBuffer f14865i;

    /* renamed from: j, reason: collision with root package name */
    private byte[] f14866j;

    /* renamed from: k, reason: collision with root package name */
    private c f14867k;

    /* renamed from: l, reason: collision with root package name */
    private short[] f14868l;

    /* renamed from: m, reason: collision with root package name */
    private byte[] f14869m;

    /* renamed from: n, reason: collision with root package name */
    private byte[] f14870n;

    /* renamed from: o, reason: collision with root package name */
    private byte[] f14871o;

    /* renamed from: p, reason: collision with root package name */
    @ColorInt
    private int[] f14872p;

    /* renamed from: q, reason: collision with root package name */
    private int f14873q;

    /* renamed from: r, reason: collision with root package name */
    private b f14874r;

    /* renamed from: s, reason: collision with root package name */
    private Bitmap f14875s;

    /* renamed from: t, reason: collision with root package name */
    private boolean f14876t;

    /* renamed from: u, reason: collision with root package name */
    private int f14877u;

    /* renamed from: v, reason: collision with root package name */
    private int f14878v;

    /* renamed from: w, reason: collision with root package name */
    private int f14879w;

    /* renamed from: x, reason: collision with root package name */
    private int f14880x;

    /* renamed from: y, reason: collision with root package name */
    @Nullable
    private Boolean f14881y;

    /* renamed from: z, reason: collision with root package name */
    @NonNull
    private Bitmap.Config f14882z;

    public d(@NonNull GifDecoder.a aVar, b bVar, ByteBuffer byteBuffer) {
        this(aVar, bVar, byteBuffer, 1);
    }

    @ColorInt
    private int q(int i6, int i7, int i8) {
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = i6; i14 < this.f14878v + i6; i14++) {
            byte[] bArr = this.f14871o;
            if (i14 >= bArr.length || i14 >= i7) {
                break;
            }
            int i15 = this.f14862f[bArr[i14] & 255];
            if (i15 != 0) {
                i9 += (i15 >> 24) & 255;
                i10 += (i15 >> 16) & 255;
                i11 += (i15 >> 8) & 255;
                i12 += i15 & 255;
                i13++;
            }
        }
        int i16 = i6 + i8;
        for (int i17 = i16; i17 < this.f14878v + i16; i17++) {
            byte[] bArr2 = this.f14871o;
            if (i17 >= bArr2.length || i17 >= i7) {
                break;
            }
            int i18 = this.f14862f[bArr2[i17] & 255];
            if (i18 != 0) {
                i9 += (i18 >> 24) & 255;
                i10 += (i18 >> 16) & 255;
                i11 += (i18 >> 8) & 255;
                i12 += i18 & 255;
                i13++;
            }
        }
        if (i13 == 0) {
            return 0;
        }
        return ((i9 / i13) << 24) | ((i10 / i13) << 16) | ((i11 / i13) << 8) | (i12 / i13);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void c(@NonNull b bVar, @NonNull byte[] bArr) {
        n(bVar, ByteBuffer.wrap(bArr));
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void clear() {
        this.f14874r = null;
        byte[] bArr = this.f14871o;
        if (bArr != null) {
            this.f14864h.e(bArr);
        }
        int[] iArr = this.f14872p;
        if (iArr != null) {
            this.f14864h.f(iArr);
        }
        Bitmap bitmap = this.f14875s;
        if (bitmap != null) {
            this.f14864h.c(bitmap);
        }
        this.f14875s = null;
        this.f14865i = null;
        this.f14881y = null;
        byte[] bArr2 = this.f14866j;
        if (bArr2 != null) {
            this.f14864h.e(bArr2);
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void d() {
        this.f14873q = -1;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002f A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x001f, B:13:0x0028, B:15:0x002f, B:16:0x0039, B:18:0x004a, B:19:0x0056, B:22:0x005f, B:24:0x0063, B:28:0x006c, B:30:0x0070, B:32:0x0082, B:34:0x0086, B:35:0x008a, B:38:0x005b, B:40:0x0090, B:43:0x0011, B:45:0x0019, B:46:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004a A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x001f, B:13:0x0028, B:15:0x002f, B:16:0x0039, B:18:0x004a, B:19:0x0056, B:22:0x005f, B:24:0x0063, B:28:0x006c, B:30:0x0070, B:32:0x0082, B:34:0x0086, B:35:0x008a, B:38:0x005b, B:40:0x0090, B:43:0x0011, B:45:0x0019, B:46:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0063 A[Catch: all -> 0x000e, TRY_LEAVE, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x001f, B:13:0x0028, B:15:0x002f, B:16:0x0039, B:18:0x004a, B:19:0x0056, B:22:0x005f, B:24:0x0063, B:28:0x006c, B:30:0x0070, B:32:0x0082, B:34:0x0086, B:35:0x008a, B:38:0x005b, B:40:0x0090, B:43:0x0011, B:45:0x0019, B:46:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c A[Catch: all -> 0x000e, TRY_ENTER, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x001f, B:13:0x0028, B:15:0x002f, B:16:0x0039, B:18:0x004a, B:19:0x0056, B:22:0x005f, B:24:0x0063, B:28:0x006c, B:30:0x0070, B:32:0x0082, B:34:0x0086, B:35:0x008a, B:38:0x005b, B:40:0x0090, B:43:0x0011, B:45:0x0019, B:46:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x005b A[Catch: all -> 0x000e, TryCatch #0 {all -> 0x000e, blocks: (B:3:0x0001, B:5:0x0009, B:8:0x001f, B:13:0x0028, B:15:0x002f, B:16:0x0039, B:18:0x004a, B:19:0x0056, B:22:0x005f, B:24:0x0063, B:28:0x006c, B:30:0x0070, B:32:0x0082, B:34:0x0086, B:35:0x008a, B:38:0x005b, B:40:0x0090, B:43:0x0011, B:45:0x0019, B:46:0x001d), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0055  */
    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized android.graphics.Bitmap h() {
        /*
            r8 = this;
            monitor-enter(r8)
            com.bumptech.glide.gifdecoder.b r0 = r8.f14874r     // Catch: java.lang.Throwable -> Le
            int r0 = r0.f14827c     // Catch: java.lang.Throwable -> Le
            r1 = 3
            r2 = 1
            if (r0 <= 0) goto L11
            int r0 = r8.f14873q     // Catch: java.lang.Throwable -> Le
            if (r0 >= 0) goto L1f
            goto L11
        Le:
            r0 = move-exception
            goto L97
        L11:
            java.lang.String r0 = com.bumptech.glide.gifdecoder.d.A     // Catch: java.lang.Throwable -> Le
            boolean r0 = android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            if (r0 == 0) goto L1d
            com.bumptech.glide.gifdecoder.b r0 = r8.f14874r     // Catch: java.lang.Throwable -> Le
            int r0 = r0.f14827c     // Catch: java.lang.Throwable -> Le
        L1d:
            r8.f14877u = r2     // Catch: java.lang.Throwable -> Le
        L1f:
            int r0 = r8.f14877u     // Catch: java.lang.Throwable -> Le
            r3 = 0
            if (r0 == r2) goto L90
            r4 = 2
            if (r0 != r4) goto L28
            goto L90
        L28:
            r0 = 0
            r8.f14877u = r0     // Catch: java.lang.Throwable -> Le
            byte[] r5 = r8.f14866j     // Catch: java.lang.Throwable -> Le
            if (r5 != 0) goto L39
            com.bumptech.glide.gifdecoder.GifDecoder$a r5 = r8.f14864h     // Catch: java.lang.Throwable -> Le
            r6 = 255(0xff, float:3.57E-43)
            byte[] r5 = r5.a(r6)     // Catch: java.lang.Throwable -> Le
            r8.f14866j = r5     // Catch: java.lang.Throwable -> Le
        L39:
            com.bumptech.glide.gifdecoder.b r5 = r8.f14874r     // Catch: java.lang.Throwable -> Le
            java.util.List<com.bumptech.glide.gifdecoder.a> r5 = r5.f14829e     // Catch: java.lang.Throwable -> Le
            int r6 = r8.f14873q     // Catch: java.lang.Throwable -> Le
            java.lang.Object r5 = r5.get(r6)     // Catch: java.lang.Throwable -> Le
            com.bumptech.glide.gifdecoder.a r5 = (com.bumptech.glide.gifdecoder.a) r5     // Catch: java.lang.Throwable -> Le
            int r6 = r8.f14873q     // Catch: java.lang.Throwable -> Le
            int r6 = r6 - r2
            if (r6 < 0) goto L55
            com.bumptech.glide.gifdecoder.b r7 = r8.f14874r     // Catch: java.lang.Throwable -> Le
            java.util.List<com.bumptech.glide.gifdecoder.a> r7 = r7.f14829e     // Catch: java.lang.Throwable -> Le
            java.lang.Object r6 = r7.get(r6)     // Catch: java.lang.Throwable -> Le
            com.bumptech.glide.gifdecoder.a r6 = (com.bumptech.glide.gifdecoder.a) r6     // Catch: java.lang.Throwable -> Le
            goto L56
        L55:
            r6 = r3
        L56:
            int[] r7 = r5.f14822k     // Catch: java.lang.Throwable -> Le
            if (r7 == 0) goto L5b
            goto L5f
        L5b:
            com.bumptech.glide.gifdecoder.b r7 = r8.f14874r     // Catch: java.lang.Throwable -> Le
            int[] r7 = r7.f14825a     // Catch: java.lang.Throwable -> Le
        L5f:
            r8.f14862f = r7     // Catch: java.lang.Throwable -> Le
            if (r7 != 0) goto L6c
            java.lang.String r0 = com.bumptech.glide.gifdecoder.d.A     // Catch: java.lang.Throwable -> Le
            android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            r8.f14877u = r2     // Catch: java.lang.Throwable -> Le
            monitor-exit(r8)
            return r3
        L6c:
            boolean r1 = r5.f14817f     // Catch: java.lang.Throwable -> Le
            if (r1 == 0) goto L8a
            int[] r1 = r8.f14863g     // Catch: java.lang.Throwable -> Le
            int r2 = r7.length     // Catch: java.lang.Throwable -> Le
            java.lang.System.arraycopy(r7, r0, r1, r0, r2)     // Catch: java.lang.Throwable -> Le
            int[] r1 = r8.f14863g     // Catch: java.lang.Throwable -> Le
            r8.f14862f = r1     // Catch: java.lang.Throwable -> Le
            int r2 = r5.f14819h     // Catch: java.lang.Throwable -> Le
            r1[r2] = r0     // Catch: java.lang.Throwable -> Le
            int r0 = r5.f14818g     // Catch: java.lang.Throwable -> Le
            if (r0 != r4) goto L8a
            int r0 = r8.f14873q     // Catch: java.lang.Throwable -> Le
            if (r0 != 0) goto L8a
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Le
            r8.f14881y = r0     // Catch: java.lang.Throwable -> Le
        L8a:
            android.graphics.Bitmap r0 = r8.y(r5, r6)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r8)
            return r0
        L90:
            java.lang.String r0 = com.bumptech.glide.gifdecoder.d.A     // Catch: java.lang.Throwable -> Le
            android.util.Log.isLoggable(r0, r1)     // Catch: java.lang.Throwable -> Le
            monitor-exit(r8)
            return r3
        L97:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> Le
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.d.h():android.graphics.Bitmap");
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void n(@NonNull b bVar, @NonNull ByteBuffer byteBuffer) {
        o(bVar, byteBuffer, 1);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized void o(@NonNull b bVar, @NonNull ByteBuffer byteBuffer, int i6) {
        try {
            if (i6 <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i6);
            }
            int highestOneBit = Integer.highestOneBit(i6);
            this.f14877u = 0;
            this.f14874r = bVar;
            this.f14873q = -1;
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.f14865i = asReadOnlyBuffer;
            asReadOnlyBuffer.position(0);
            this.f14865i.order(ByteOrder.LITTLE_ENDIAN);
            this.f14876t = false;
            Iterator<a> it = bVar.f14829e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().f14818g == 3) {
                    this.f14876t = true;
                    break;
                }
            }
            this.f14878v = highestOneBit;
            int i7 = bVar.f14830f;
            this.f14880x = i7 / highestOneBit;
            int i8 = bVar.f14831g;
            this.f14879w = i8 / highestOneBit;
            this.f14871o = this.f14864h.a(i7 * i8);
            this.f14872p = this.f14864h.d(this.f14880x * this.f14879w);
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public synchronized int read(@Nullable byte[] bArr) {
        try {
            b d6 = u().r(bArr).d();
            this.f14874r = d6;
            if (bArr != null) {
                c(d6, bArr);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f14877u;
    }

    public d(@NonNull GifDecoder.a aVar, b bVar, ByteBuffer byteBuffer, int i6) {
        this(aVar);
        o(bVar, byteBuffer, i6);
    }

    private void r(a aVar) {
        int i6;
        int i7;
        int i8;
        int i9;
        int[] iArr = this.f14872p;
        int i10 = aVar.f14815d;
        int i11 = this.f14878v;
        int i12 = i10 / i11;
        int i13 = aVar.f14813b / i11;
        int i14 = aVar.f14814c / i11;
        int i15 = aVar.f14812a / i11;
        boolean z5 = this.f14873q == 0;
        int i16 = this.f14880x;
        int i17 = this.f14879w;
        byte[] bArr = this.f14871o;
        int[] iArr2 = this.f14862f;
        Boolean bool = this.f14881y;
        int i18 = 8;
        int i19 = 0;
        int i20 = 0;
        int i21 = 1;
        while (i20 < i12) {
            int[] iArr3 = iArr;
            if (aVar.f14816e) {
                if (i19 >= i12) {
                    int i22 = i21 + 1;
                    i6 = i12;
                    if (i22 == 2) {
                        i21 = i22;
                        i19 = 4;
                    } else if (i22 == 3) {
                        i21 = i22;
                        i19 = 2;
                        i18 = 4;
                    } else if (i22 != 4) {
                        i21 = i22;
                    } else {
                        i21 = i22;
                        i19 = 1;
                        i18 = 2;
                    }
                } else {
                    i6 = i12;
                }
                i7 = i19 + i18;
            } else {
                i6 = i12;
                i7 = i19;
                i19 = i20;
            }
            int i23 = i19 + i13;
            boolean z6 = i11 == 1;
            if (i23 < i17) {
                int i24 = i23 * i16;
                int i25 = i24 + i15;
                int i26 = i25 + i14;
                int i27 = i24 + i16;
                if (i27 < i26) {
                    i26 = i27;
                }
                i8 = i7;
                int i28 = i20 * i11 * aVar.f14814c;
                if (z6) {
                    int i29 = i25;
                    while (i29 < i26) {
                        int i30 = i29;
                        int i31 = iArr2[bArr[i28] & 255];
                        if (i31 != 0) {
                            iArr3[i30] = i31;
                        } else if (z5 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i28 += i11;
                        i29 = i30 + 1;
                    }
                } else {
                    int i32 = ((i26 - i25) * i11) + i28;
                    i9 = i11;
                    int i33 = i25;
                    while (i33 < i26) {
                        int i34 = i26;
                        int q5 = q(i28, i32, aVar.f14814c);
                        if (q5 != 0) {
                            iArr3[i33] = q5;
                        } else if (z5 && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i28 += i9;
                        i33++;
                        i26 = i34;
                    }
                    i20++;
                    i11 = i9;
                    iArr = iArr3;
                    i12 = i6;
                    i19 = i8;
                }
            } else {
                i8 = i7;
            }
            i9 = i11;
            i20++;
            i11 = i9;
            iArr = iArr3;
            i12 = i6;
            i19 = i8;
        }
        if (this.f14881y == null) {
            this.f14881y = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    private void s(a aVar) {
        a aVar2 = aVar;
        int[] iArr = this.f14872p;
        int i6 = aVar2.f14815d;
        int i7 = aVar2.f14813b;
        int i8 = aVar2.f14814c;
        int i9 = aVar2.f14812a;
        boolean z5 = this.f14873q == 0;
        int i10 = this.f14880x;
        byte[] bArr = this.f14871o;
        int[] iArr2 = this.f14862f;
        int i11 = 0;
        byte b6 = -1;
        while (i11 < i6) {
            int i12 = (i11 + i7) * i10;
            int i13 = i12 + i9;
            int i14 = i13 + i8;
            int i15 = i12 + i10;
            if (i15 < i14) {
                i14 = i15;
            }
            int i16 = aVar2.f14814c * i11;
            int i17 = i13;
            while (i17 < i14) {
                byte b7 = bArr[i16];
                int[] iArr3 = iArr;
                int i18 = b7 & 255;
                if (i18 != b6) {
                    int i19 = iArr2[i18];
                    if (i19 != 0) {
                        iArr3[i17] = i19;
                    } else {
                        b6 = b7;
                    }
                }
                i16++;
                i17++;
                iArr = iArr3;
            }
            i11++;
            aVar2 = aVar;
        }
        Boolean bool = this.f14881y;
        this.f14881y = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.f14881y == null && z5 && b6 != -1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v15, types: [short] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    private void t(a aVar) {
        int i6;
        int i7;
        byte[] bArr;
        short s5;
        d dVar = this;
        if (aVar != null) {
            dVar.f14865i.position(aVar.f14821j);
        }
        if (aVar == null) {
            b bVar = dVar.f14874r;
            i6 = bVar.f14830f;
            i7 = bVar.f14831g;
        } else {
            i6 = aVar.f14814c;
            i7 = aVar.f14815d;
        }
        int i8 = i6 * i7;
        byte[] bArr2 = dVar.f14871o;
        if (bArr2 == null || bArr2.length < i8) {
            dVar.f14871o = dVar.f14864h.a(i8);
        }
        byte[] bArr3 = dVar.f14871o;
        if (dVar.f14868l == null) {
            dVar.f14868l = new short[4096];
        }
        short[] sArr = dVar.f14868l;
        if (dVar.f14869m == null) {
            dVar.f14869m = new byte[4096];
        }
        byte[] bArr4 = dVar.f14869m;
        if (dVar.f14870n == null) {
            dVar.f14870n = new byte[4097];
        }
        byte[] bArr5 = dVar.f14870n;
        int x5 = dVar.x();
        int i9 = 1 << x5;
        int i10 = i9 + 1;
        int i11 = i9 + 2;
        int i12 = x5 + 1;
        int i13 = (1 << i12) - 1;
        for (int i14 = 0; i14 < i9; i14++) {
            sArr[i14] = 0;
            bArr4[i14] = (byte) i14;
        }
        byte[] bArr6 = dVar.f14866j;
        int i15 = i12;
        int i16 = i11;
        int i17 = i13;
        int i18 = 0;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = -1;
        int i25 = 0;
        int i26 = 0;
        while (true) {
            if (i18 >= i8) {
                break;
            }
            if (i19 == 0) {
                i19 = dVar.w();
                if (i19 <= 0) {
                    dVar.f14877u = 3;
                    break;
                }
                i20 = 0;
            }
            i22 += (bArr6[i20] & 255) << i21;
            i20++;
            i19--;
            int i27 = i21 + 8;
            int i28 = i16;
            int i29 = i15;
            int i30 = i24;
            short[] sArr2 = sArr;
            int i31 = i25;
            while (true) {
                bArr = bArr4;
                if (i27 < i29) {
                    i16 = i28;
                    i25 = i31;
                    break;
                }
                int i32 = i22 & i17;
                i22 >>= i29;
                i27 -= i29;
                if (i32 == i9) {
                    i29 = i12;
                    i28 = i11;
                    i17 = i13;
                    bArr4 = bArr;
                    i30 = -1;
                } else {
                    if (i32 == i10) {
                        i25 = i31;
                        i16 = i28;
                        break;
                    }
                    byte[] bArr7 = bArr5;
                    if (i30 == -1) {
                        bArr3[i23] = bArr[i32];
                        i23++;
                        i18++;
                        i30 = i32;
                        i31 = i30;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                    } else {
                        if (i32 >= i28) {
                            bArr7[i26] = (byte) i31;
                            i26++;
                            s5 = i30;
                        } else {
                            s5 = i32;
                        }
                        while (s5 >= i9) {
                            bArr7[i26] = bArr[s5];
                            i26++;
                            s5 = sArr2[s5];
                        }
                        int i33 = bArr[s5] & 255;
                        byte b6 = (byte) i33;
                        bArr3[i23] = b6;
                        while (true) {
                            i23++;
                            i18++;
                            if (i26 <= 0) {
                                break;
                            }
                            i26--;
                            bArr3[i23] = bArr7[i26];
                        }
                        if (i28 < 4096) {
                            sArr2[i28] = (short) i30;
                            bArr[i28] = b6;
                            i28++;
                            if ((i28 & i17) == 0 && i28 < 4096) {
                                i29++;
                                i17 += i28;
                            }
                        }
                        i30 = i32;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                        i31 = i33;
                    }
                }
            }
            i21 = i27;
            sArr = sArr2;
            bArr4 = bArr;
            i24 = i30;
            i15 = i29;
            dVar = this;
        }
        Arrays.fill(bArr3, i23, i8, (byte) 0);
    }

    @NonNull
    private c u() {
        if (this.f14867k == null) {
            this.f14867k = new c();
        }
        return this.f14867k;
    }

    private Bitmap v() {
        Boolean bool = this.f14881y;
        Bitmap b6 = this.f14864h.b(this.f14880x, this.f14879w, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.f14882z);
        b6.setHasAlpha(true);
        return b6;
    }

    private int x() {
        return this.f14865i.get() & 255;
    }

    private Bitmap y(a aVar, a aVar2) {
        int i6;
        int i7;
        Bitmap bitmap;
        int[] iArr = this.f14872p;
        int i8 = 0;
        if (aVar2 == null) {
            Bitmap bitmap2 = this.f14875s;
            if (bitmap2 != null) {
                this.f14864h.c(bitmap2);
            }
            this.f14875s = null;
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && aVar2.f14818g == 3 && this.f14875s == null) {
            Arrays.fill(iArr, 0);
        }
        if (aVar2 != null && (i7 = aVar2.f14818g) > 0) {
            if (i7 == 2) {
                if (!aVar.f14817f) {
                    b bVar = this.f14874r;
                    int i9 = bVar.f14836l;
                    if (aVar.f14822k == null || bVar.f14834j != aVar.f14819h) {
                        i8 = i9;
                    }
                }
                int i10 = aVar2.f14815d;
                int i11 = this.f14878v;
                int i12 = i10 / i11;
                int i13 = aVar2.f14813b / i11;
                int i14 = aVar2.f14814c / i11;
                int i15 = aVar2.f14812a / i11;
                int i16 = this.f14880x;
                int i17 = (i13 * i16) + i15;
                int i18 = (i12 * i16) + i17;
                while (i17 < i18) {
                    int i19 = i17 + i14;
                    for (int i20 = i17; i20 < i19; i20++) {
                        iArr[i20] = i8;
                    }
                    i17 += this.f14880x;
                }
            } else if (i7 == 3 && (bitmap = this.f14875s) != null) {
                int i21 = this.f14880x;
                bitmap.getPixels(iArr, 0, i21, 0, 0, i21, this.f14879w);
            }
        }
        t(aVar);
        if (aVar.f14816e || this.f14878v != 1) {
            r(aVar);
        } else {
            s(aVar);
        }
        if (this.f14876t && ((i6 = aVar.f14818g) == 0 || i6 == 1)) {
            if (this.f14875s == null) {
                this.f14875s = v();
            }
            Bitmap bitmap3 = this.f14875s;
            int i22 = this.f14880x;
            bitmap3.setPixels(iArr, 0, i22, 0, 0, i22, this.f14879w);
        }
        Bitmap v5 = v();
        int i23 = this.f14880x;
        v5.setPixels(iArr, 0, i23, 0, 0, i23, this.f14879w);
        return v5;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void a(@NonNull Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.f14882z = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @Deprecated
    public int b() {
        int i6 = this.f14874r.f14837m;
        if (i6 == -1) {
            return 1;
        }
        return i6;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int e() {
        return this.f14873q;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int f(@Nullable InputStream inputStream, int i6) {
        if (inputStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i6 > 0 ? i6 + 4096 : 16384);
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr, 0, 16384);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                byteArrayOutputStream.flush();
                read(byteArrayOutputStream.toByteArray());
            } catch (IOException unused) {
            }
        } else {
            this.f14877u = 2;
        }
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused2) {
            }
        }
        return this.f14877u;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int g() {
        return this.f14865i.limit() + this.f14871o.length + (this.f14872p.length * 4);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    @NonNull
    public ByteBuffer getData() {
        return this.f14865i;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getHeight() {
        return this.f14874r.f14831g;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getStatus() {
        return this.f14877u;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int getWidth() {
        return this.f14874r.f14830f;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public void i() {
        this.f14873q = (this.f14873q + 1) % this.f14874r.f14827c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int j() {
        return this.f14874r.f14827c;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int k(int i6) {
        if (i6 < 0) {
            return -1;
        }
        b bVar = this.f14874r;
        if (i6 < bVar.f14827c) {
            return bVar.f14829e.get(i6).f14820i;
        }
        return -1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int l() {
        int i6 = this.f14874r.f14837m;
        if (i6 == -1) {
            return 1;
        }
        if (i6 == 0) {
            return 0;
        }
        return i6 + 1;
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int m() {
        int i6;
        if (this.f14874r.f14827c <= 0 || (i6 = this.f14873q) < 0) {
            return 0;
        }
        return k(i6);
    }

    @Override // com.bumptech.glide.gifdecoder.GifDecoder
    public int p() {
        return this.f14874r.f14837m;
    }

    private int w() {
        int x5 = x();
        if (x5 <= 0) {
            return x5;
        }
        ByteBuffer byteBuffer = this.f14865i;
        byteBuffer.get(this.f14866j, 0, Math.min(x5, byteBuffer.remaining()));
        return x5;
    }

    public d(@NonNull GifDecoder.a aVar) {
        this.f14863g = new int[256];
        this.f14882z = Bitmap.Config.ARGB_8888;
        this.f14864h = aVar;
        this.f14874r = new b();
    }
}
