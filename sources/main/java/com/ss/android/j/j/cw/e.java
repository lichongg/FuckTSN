package com.ss.android.j.j.cw;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: D:\Downloads\app\classes6.dex */
public interface e {
    void j();

    void onDownloadActive(com.ss.android.j.j.up.e eVar, int i6);

    void onDownloadFailed(com.ss.android.j.j.up.e eVar);

    void onDownloadFinished(com.ss.android.j.j.up.e eVar);

    void onDownloadPaused(com.ss.android.j.j.up.e eVar, int i6);

    void onDownloadStart(@NonNull b bVar, @Nullable c cVar);

    void onInstalled(com.ss.android.j.j.up.e eVar);
}
