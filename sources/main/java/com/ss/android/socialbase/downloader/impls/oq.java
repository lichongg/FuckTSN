package com.ss.android.socialbase.downloader.impls;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkRequest;
import com.ss.android.socialbase.downloader.downloader.kt;

/* loaded from: D:\Downloads\app\classes6.dex */
public class oq implements kt {
    @Override // com.ss.android.socialbase.downloader.downloader.kt
    public long j(int i6, int i7) {
        if (i6 == 1) {
            return 3000L;
        }
        if (i6 == 2) {
            return 15000L;
        }
        if (i6 == 3) {
            return WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS;
        }
        if (i6 > 3) {
            return PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
        }
        return 0L;
    }
}
