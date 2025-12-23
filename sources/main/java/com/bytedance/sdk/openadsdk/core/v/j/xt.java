package com.bytedance.sdk.openadsdk.core.v.j;

import android.graphics.Bitmap;
import com.bytedance.sdk.component.utils.r;
import com.bytedance.sdk.component.utils.vl;
import java.util.List;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private Bitmap cw;

    /* renamed from: j, reason: collision with root package name */
    int f30954j;

    /* renamed from: r, reason: collision with root package name */
    private List<Object> f30955r;
    private Map<String, String> up;
    private byte[] xt;

    public xt(byte[] bArr, int i6) {
        this.cw = null;
        this.f30955r = null;
        this.up = null;
        this.xt = bArr;
        this.f30954j = i6;
    }

    public byte[] cw() {
        try {
            if (this.xt == null) {
                this.xt = r.xt(this.cw);
            }
        } catch (OutOfMemoryError e6) {
            vl.j(e6);
        }
        return this.xt;
    }

    public Bitmap j() {
        return this.cw;
    }

    public boolean r() {
        if (this.cw != null) {
            return true;
        }
        byte[] bArr = this.xt;
        return bArr != null && bArr.length > 0;
    }

    public boolean up() {
        byte[] bArr = this.xt;
        return bArr != null && bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70;
    }

    public int xt() {
        return this.f30954j;
    }

    public xt(Bitmap bitmap, int i6) {
        this.xt = null;
        this.f30955r = null;
        this.up = null;
        this.cw = bitmap;
        this.f30954j = i6;
    }
}
