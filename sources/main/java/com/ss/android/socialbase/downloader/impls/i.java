package com.ss.android.socialbase.downloader.impls;

import android.text.TextUtils;
import com.ss.android.socialbase.downloader.downloader.kt;

/* loaded from: D:\Downloads\app\classes6.dex */
public class i implements kt {

    /* renamed from: j, reason: collision with root package name */
    private final long[] f38840j;

    @Override // com.ss.android.socialbase.downloader.downloader.kt
    public long j(int i6, int i7) {
        long[] jArr = this.f38840j;
        if (jArr == null || jArr.length <= 0) {
            return 0L;
        }
        int i8 = i6 - 1;
        if (i8 < 0) {
            i8 = 0;
        }
        if (i8 > jArr.length - 1) {
            i8 = jArr.length - 1;
        }
        return jArr[i8];
    }

    public i(String str) {
        this.f38840j = j(str);
    }

    private long[] j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String[] split = str.split(",");
            if (split.length == 0) {
                return null;
            }
            long[] jArr = new long[split.length];
            for (int i6 = 0; i6 < split.length; i6++) {
                jArr[i6] = Long.parseLong(split[i6]);
            }
            return jArr;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.vl.j(th);
            return null;
        }
    }
}
