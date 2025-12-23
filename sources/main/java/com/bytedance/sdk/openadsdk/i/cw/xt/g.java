package com.bytedance.sdk.openadsdk.i.cw.xt;

import a1.a;
import a1.b;
import android.graphics.Bitmap;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public abstract class g extends oq {

    /* renamed from: j, reason: collision with root package name */
    private SparseArray<Object> f31405j;

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq, com.bytedance.sdk.openadsdk.i.cw.xt.jy, com.bytedance.sdk.openadsdk.i.cw.xt.tl, java.util.function.Function
    /* renamed from: j */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        k6.objectValue(-99999985, Class.class);
        if (intValue == -99999986) {
            return u_();
        }
        if (intValue != 140111) {
            switch (intValue) {
                case 170101:
                    j(k6.booleanValue(0));
                    break;
                case 170102:
                    j((Bitmap) k6.objectValue(0, Bitmap.class), k6.intValue(1));
                    break;
                case 170103:
                    j(new com.bytedance.sdk.openadsdk.f.j.xt.j.j(b.a(k6.objectValue(0, a.a()))));
                    break;
                default:
                    return super.apply(sparseArray);
            }
        } else {
            Function a6 = b.a(k6.objectValue(0, a.a()));
            j(k6.intValue(1) == 1 ? new com.bytedance.sdk.openadsdk.mediation.ad.j.xt.j.up(a6) : new com.bytedance.sdk.openadsdk.ch.j.xt.j.cw(a6));
        }
        return null;
    }

    public abstract void j(Bitmap bitmap, int i6);

    public abstract void j(com.bytedance.sdk.openadsdk.f.j.xt.j.j jVar);

    public abstract void j(boolean z5);

    @Override // com.bytedance.sdk.openadsdk.i.cw.xt.oq, com.bytedance.sdk.openadsdk.i.cw.xt.jy
    public SparseArray<Object> u_() {
        SparseArray<Object> sparseArray = this.f31405j;
        if (sparseArray != null) {
            return sparseArray;
        }
        SparseArray<Object> s5 = s();
        this.f31405j = s5;
        return s5;
    }

    private SparseArray<Object> s() {
        return super.u_();
    }
}
