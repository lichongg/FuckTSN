package com.amap.api.col.p0003l;

import android.content.Context;
import com.amap.api.col.p0003l.v;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public final class w extends v {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static abstract class a implements v.a {
        public abstract boolean d(w wVar);

        public abstract boolean e(w wVar);

        public abstract void f(w wVar);

        @Override // com.amap.api.col.3l.v.a
        public final void a(v vVar) {
            f((w) vVar);
        }

        @Override // com.amap.api.col.3l.v.a
        public final boolean b(v vVar) {
            return d((w) vVar);
        }

        @Override // com.amap.api.col.3l.v.a
        public final boolean c(v vVar) {
            return e((w) vVar);
        }
    }

    public w(Context context, a aVar) {
        super(context, aVar);
    }

    public final float s() {
        return (float) (((Math.atan2(m(), l()) - Math.atan2(k(), j())) * 180.0d) / 3.141592653589793d);
    }
}
