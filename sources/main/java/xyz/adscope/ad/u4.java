package xyz.adscope.ad;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xyz.adscope.ad.a2;
import xyz.adscope.ad.publish.ad.nativead.INativeAdListener;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class u4<C extends a2, L extends INativeAdListener> extends b2<C, L> {
    @Override // xyz.adscope.ad.b2
    protected void a(List<s3> list) {
        this.f54867d = true;
        INativeAdListener iNativeAdListener = (INativeAdListener) c();
        if (iNativeAdListener != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<s3> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new y6(it.next()));
            }
            iNativeAdListener.onAdLoaded(arrayList);
        }
    }

    u4(Context context, C c6, c cVar) {
        super(context, c6, cVar);
    }
}
