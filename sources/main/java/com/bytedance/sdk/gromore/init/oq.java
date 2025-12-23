package com.bytedance.sdk.gromore.init;

import android.content.Context;
import android.util.SparseArray;
import com.bykv.j.j.j.j.e;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.sdk.openadsdk.core.la;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes4.dex */
public class oq implements Function<SparseArray<Object>, Object> {
    private ae cw;

    /* renamed from: j, reason: collision with root package name */
    private la f27340j;
    private r xt = new r();

    @Override // java.util.function.Function
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        PluginValueSet k6 = e.i(sparseArray).k();
        int intValue = k6.intValue(-99999987);
        if (intValue == -99999986) {
            la laVar = this.f27340j;
            if (laVar != null) {
                return laVar.j();
            }
        } else if (intValue != -999800) {
            if (intValue == 8303 || intValue == 999801) {
                if (intValue == 8303) {
                    com.bytedance.msdk.j.up.cw.xt("TMe", "initRequestCondition getBridge");
                    return this.xt;
                }
                if (this.f27340j != null) {
                    return this.cw;
                }
            }
        } else if (this.f27340j != null) {
            Context context = (Context) k6.objectValue(-998000, Context.class);
            return new m(context, this.f27340j.j(context));
        }
        return null;
    }

    public oq(la laVar) {
        this.f27340j = laVar;
        this.cw = new ae(this.f27340j);
    }
}
