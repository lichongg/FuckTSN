package com.ss.android.socialbase.downloader.az;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes6.dex */
public class tl<K, T> extends LinkedHashMap<K, T> {

    /* renamed from: j, reason: collision with root package name */
    private int f38685j;

    public tl() {
        this(4, 4);
    }

    public tl(int i6, int i7) {
        this(i6, i7, true);
    }

    public void j(int i6) {
        this.f38685j = i6;
    }

    public tl(int i6, int i7, boolean z5) {
        super(i6, 0.75f, z5);
        j(i7);
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
        if (size() > this.f38685j) {
            return true;
        }
        return false;
    }
}
