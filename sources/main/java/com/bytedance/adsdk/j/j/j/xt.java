package com.bytedance.adsdk.j.j.j;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import com.bytedance.adsdk.j.j.j.g;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt extends g<com.bytedance.adsdk.j.j.xt.j, com.bytedance.adsdk.j.j.xt.xt> {
    private com.bytedance.adsdk.j.j.xt.xt ae;

    /* renamed from: g, reason: collision with root package name */
    private final Paint f23167g;
    private final j oq;
    private int tl;

    /* renamed from: com.bytedance.adsdk.j.j.j.xt$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.j.j.j.g
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.j.j.xt.xt r() {
        if (this.ae == null) {
            this.ae = new com.bytedance.adsdk.j.j.xt.xt();
        }
        return this.ae;
    }

    private static class j {
        ByteBuffer cw;

        /* renamed from: j, reason: collision with root package name */
        byte f23168j;
        Rect xt;

        private j() {
            this.xt = new Rect();
        }

        /* synthetic */ j(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    @Override // com.bytedance.adsdk.j.j.j.g
    protected void cw() {
        this.oq.cw = null;
        this.ae = null;
    }

    @Override // com.bytedance.adsdk.j.j.j.g
    protected int xt() {
        return this.tl;
    }

    public xt(com.bytedance.adsdk.j.j.cw.xt xtVar, g.j jVar) {
        super(xtVar, jVar);
        Paint paint = new Paint();
        this.f23167g = paint;
        this.oq = new j(null);
        paint.setAntiAlias(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.j.j.j.g
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public com.bytedance.adsdk.j.j.xt.j cw(com.bytedance.adsdk.j.j.xt.m mVar) {
        return new com.bytedance.adsdk.j.j.xt.j(mVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.j.j.j.g
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Rect xt(com.bytedance.adsdk.j.j.xt.j jVar) throws IOException {
        List<up> j6 = r.j(jVar);
        ArrayList arrayList = new ArrayList();
        byte[] bArr = new byte[0];
        Iterator<up> it = j6.iterator();
        cw cwVar = null;
        boolean z5 = false;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            up next = it.next();
            if (next instanceof com.bytedance.adsdk.j.j.j.j) {
                this.tl = ((com.bytedance.adsdk.j.j.j.j) next).cw;
                z5 = true;
            } else if (next instanceof m) {
                cwVar = new cw(jVar, (m) next);
                cwVar.up = arrayList;
                cwVar.cw = bArr;
                this.f23142j.add(cwVar);
            } else if (next instanceof ae) {
                if (cwVar != null) {
                    cwVar.f23139r.add(next);
                }
            } else if (next instanceof oq) {
                if (!z5) {
                    jy jyVar = new jy(jVar);
                    jyVar.tl = i6;
                    jyVar.f23163g = i7;
                    this.f23142j.add(jyVar);
                    this.tl = 1;
                    break;
                }
                if (cwVar != null) {
                    cwVar.f23139r.add(next);
                }
            } else if (next instanceof vl) {
                vl vlVar = (vl) next;
                i6 = vlVar.xt;
                i7 = vlVar.cw;
                bArr = vlVar.tl;
            } else if (!(next instanceof qv)) {
                arrayList.add(next);
            }
        }
        int i8 = i6 * i7;
        int i9 = this.cw;
        this.up = ByteBuffer.allocate(((i8 / (i9 * i9)) + 1) * 4);
        j jVar2 = this.oq;
        int i10 = this.cw;
        jVar2.cw = ByteBuffer.allocate(((i8 / (i10 * i10)) + 1) * 4);
        return new Rect(0, 0, i6, i7);
    }

    @Override // com.bytedance.adsdk.j.j.j.g
    protected void j(tl<com.bytedance.adsdk.j.j.xt.j, com.bytedance.adsdk.j.j.xt.xt> tlVar) {
        if (tlVar == null || this.f23143m == null) {
            return;
        }
        try {
            Bitmap j6 = j(this.f23143m.width() / this.cw, this.f23143m.height() / this.cw);
            Canvas canvas = this.f23144r.get(j6);
            if (canvas == null) {
                canvas = new Canvas(j6);
                this.f23144r.put(j6, canvas);
            }
            Canvas canvas2 = canvas;
            if (tlVar instanceof cw) {
                this.up.rewind();
                j6.copyPixelsFromBuffer(this.up);
                if (this.xt == 0) {
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                } else {
                    canvas2.save();
                    canvas2.clipRect(this.oq.xt);
                    j jVar = this.oq;
                    byte b6 = jVar.f23168j;
                    if (b6 == 1) {
                        canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                    } else if (b6 == 2) {
                        jVar.cw.rewind();
                        j6.copyPixelsFromBuffer(this.oq.cw);
                    }
                    canvas2.restore();
                }
                if (((cw) tlVar).xt == 2) {
                    j jVar2 = this.oq;
                    if (jVar2.f23168j != 2) {
                        jVar2.cw.rewind();
                        j6.copyPixelsToBuffer(this.oq.cw);
                    }
                }
                this.oq.f23168j = ((cw) tlVar).xt;
                canvas2.save();
                if (((cw) tlVar).f23138j == 0) {
                    int i6 = tlVar.oq;
                    int i7 = this.cw;
                    int i8 = tlVar.qv;
                    canvas2.clipRect(i6 / i7, i8 / i7, (i6 + tlVar.tl) / i7, (i8 + tlVar.f23163g) / i7);
                    canvas2.drawColor(0, PorterDuff.Mode.CLEAR);
                }
                Rect rect = this.oq.xt;
                int i9 = tlVar.oq;
                int i10 = this.cw;
                int i11 = tlVar.qv;
                rect.set(i9 / i10, i11 / i10, (i9 + tlVar.tl) / i10, (i11 + tlVar.f23163g) / i10);
                canvas2.restore();
            }
            Bitmap j7 = j(tlVar.tl, tlVar.f23163g);
            j(tlVar.j(canvas2, this.f23167g, this.cw, j7, r()));
            j(j7);
            this.up.rewind();
            j6.copyPixelsToBuffer(this.up);
            j(j6);
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }
}
