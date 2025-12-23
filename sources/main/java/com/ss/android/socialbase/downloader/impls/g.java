package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;

/* loaded from: D:\Downloads\app\classes6.dex */
public class g implements com.ss.android.socialbase.downloader.downloader.jy {
    @Override // com.ss.android.socialbase.downloader.downloader.jy
    public int j(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        String up = com.ss.android.socialbase.downloader.az.m.up(String.format("%s_%s", str, str2));
        if (TextUtils.isEmpty(up)) {
            return 0;
        }
        return up.hashCode();
    }
}
