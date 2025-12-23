package com.bytedance.msdk.core.j;

import android.util.SparseArray;
import com.bytedance.msdk.api.r.j.cw.cw;
import com.bytedance.sdk.openadsdk.i.r;
import java.util.function.Function;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    public static cw j(final Function<SparseArray<Object>, Object> function) {
        if (function != null) {
            return new cw() { // from class: com.bytedance.msdk.core.j.j.1
                @Override // com.bytedance.msdk.api.r.j.ae.up
                public void j(long j6) {
                    function.apply(r.j().j(8166).j(Void.class).j(8074, Long.valueOf(j6)).xt());
                }

                @Override // com.bytedance.msdk.api.r.j.ae.up
                public void xt(long j6) {
                    function.apply(r.j().j(8167).j(Void.class).j(8074, Long.valueOf(j6)).xt());
                }

                @Override // com.bytedance.msdk.api.r.j.ae.up
                public void cw(long j6) {
                    function.apply(r.j().j(8169).j(Void.class).j(8074, Long.valueOf(j6)).xt());
                }

                @Override // com.bytedance.msdk.api.r.j.ae.up
                public void j() {
                    function.apply(r.j().j(8168).j(Void.class).xt());
                }

                @Override // com.bytedance.msdk.api.r.j.ae.up
                public void xt() {
                    function.apply(r.j().j(8170).j(Void.class).xt());
                }

                @Override // com.bytedance.msdk.api.r.j.ae.up
                public void j(int i6, int i7) {
                    function.apply(r.j().j(8171).j(Void.class).j(8014, Integer.valueOf(i6)).j(8075, Integer.valueOf(i7)).xt());
                }

                @Override // com.bytedance.msdk.api.r.j.ae.up
                public void j(long j6, int i6, int i7) {
                    function.apply(r.j().j(8172).j(Void.class).j(8014, Integer.valueOf(i6)).j(8075, Integer.valueOf(i7)).j(8074, Long.valueOf(j6)).xt());
                }
            };
        }
        return null;
    }
}
