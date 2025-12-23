package com.bytedance.msdk.api.r;

import androidx.annotation.Nullable;

/* loaded from: D:\Downloads\app\classes3.dex */
public class ws {
    public boolean cw() {
        return true;
    }

    public boolean j() {
        return true;
    }

    @Nullable
    public g xt() {
        return null;
    }

    public static ws j(final com.bytedance.msdk.j.cw.cw cwVar) {
        return new ws() { // from class: com.bytedance.msdk.api.r.ws.1
            @Override // com.bytedance.msdk.api.r.ws
            public boolean cw() {
                com.bytedance.msdk.j.cw.cw cwVar2 = com.bytedance.msdk.j.cw.cw.this;
                return cwVar2 != null ? cwVar2.tl() : super.cw();
            }

            @Override // com.bytedance.msdk.api.r.ws
            public boolean j() {
                com.bytedance.msdk.j.cw.cw cwVar2 = com.bytedance.msdk.j.cw.cw.this;
                return cwVar2 != null ? cwVar2.g() : super.j();
            }

            @Override // com.bytedance.msdk.api.r.ws
            public g xt() {
                com.bytedance.msdk.j.cw.r az;
                com.bytedance.msdk.j.cw.cw cwVar2 = com.bytedance.msdk.j.cw.cw.this;
                return (cwVar2 == null || (az = cwVar2.az()) == null || az.j() == 0.0d || az.xt() == 0.0d) ? super.xt() : new g(az.j(), az.xt());
            }
        };
    }
}
