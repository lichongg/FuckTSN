package com.ss.android.socialbase.downloader.r;

import java.util.List;

/* loaded from: D:\Downloads\app\classes6.dex */
public abstract class xt implements x {

    /* renamed from: j, reason: collision with root package name */
    private boolean f38979j = false;

    @Override // com.ss.android.socialbase.downloader.r.x
    public void j(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f38979j = true;
    }

    @Override // com.ss.android.socialbase.downloader.r.x
    public boolean j() {
        return this.f38979j;
    }
}
