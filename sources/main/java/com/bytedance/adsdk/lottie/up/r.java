package com.bytedance.adsdk.lottie.up;

import com.bytedance.adsdk.lottie.qv;
import com.bytedance.sdk.component.utils.vl;
import java.util.HashSet;
import java.util.Set;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r implements qv {

    /* renamed from: j, reason: collision with root package name */
    private static final Set<String> f23560j = new HashSet();

    @Override // com.bytedance.adsdk.lottie.qv
    public void j(String str) {
        j(str, null);
    }

    @Override // com.bytedance.adsdk.lottie.qv
    public void j(String str, Throwable th) {
        Set<String> set = f23560j;
        if (set.contains(str)) {
            return;
        }
        vl.xt("LOTTIE", str, th);
        set.add(str);
    }

    @Override // com.bytedance.adsdk.lottie.qv
    public void xt(String str, Throwable th) {
        boolean z5 = com.bytedance.adsdk.lottie.up.f23548j;
    }
}
