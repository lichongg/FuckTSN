package com.bytedance.adsdk.lottie.j.j;

import android.graphics.Path;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes3.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private final List<tj> f23293j = new ArrayList();

    void j(tj tjVar) {
        this.f23293j.add(tjVar);
    }

    public void j(Path path) {
        for (int size = this.f23293j.size() - 1; size >= 0; size--) {
            com.bytedance.adsdk.lottie.up.g.j(path, this.f23293j.get(size));
        }
    }
}
