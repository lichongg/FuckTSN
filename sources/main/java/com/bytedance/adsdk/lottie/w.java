package com.bytedance.adsdk.lottie;

import android.util.Pair;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public class w {

    /* renamed from: j, reason: collision with root package name */
    private boolean f23566j = false;
    private final Set<Object> xt = new j();
    private final Map<String, com.bytedance.adsdk.lottie.up.ae> cw = new HashMap();

    /* renamed from: r, reason: collision with root package name */
    private final Comparator<Pair<String, Float>> f23567r = new Comparator<Pair<String, Float>>() { // from class: com.bytedance.adsdk.lottie.w.1
        @Override // java.util.Comparator
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float floatValue = ((Float) pair.second).floatValue();
            float floatValue2 = ((Float) pair2.second).floatValue();
            if (floatValue2 > floatValue) {
                return 1;
            }
            return floatValue > floatValue2 ? -1 : 0;
        }
    };

    void j(boolean z5) {
        this.f23566j = z5;
    }

    public void j(String str, float f6) {
        if (this.f23566j) {
            com.bytedance.adsdk.lottie.up.ae aeVar = this.cw.get(str);
            if (aeVar == null) {
                aeVar = new com.bytedance.adsdk.lottie.up.ae();
                this.cw.put(str, aeVar);
            }
            aeVar.j(f6);
            if (str.equals("__container")) {
                Iterator<Object> it = this.xt.iterator();
                while (it.hasNext()) {
                    it.next();
                }
            }
        }
    }
}
