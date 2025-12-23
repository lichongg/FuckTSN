package com.kwad.sdk.crash.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.crash.report.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class c extends b {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    static class a {
        private static final c aPe = new c(0);
    }

    /* synthetic */ c(byte b6) {
        this();
    }

    public final void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        a(th, exceptionMessage, context, ((f) ServiceProvider.get(f.class)).Bk());
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 1;
    }

    private c() {
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        for (File file : fileArr) {
            fVar.a(file, countDownLatch);
        }
    }

    public static c LG() {
        return a.aPe;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x01aa A[Catch: all -> 0x01c3, TryCatch #2 {all -> 0x01c3, blocks: (B:29:0x01a0, B:31:0x01aa, B:33:0x01bd, B:35:0x01c7, B:37:0x01cc, B:39:0x01d9, B:42:0x01e1, B:43:0x01e4, B:44:0x0206, B:49:0x01ea, B:51:0x01ef, B:52:0x01f7, B:55:0x01ff), top: B:28:0x01a0 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(@androidx.annotation.NonNull java.lang.Throwable r18, @androidx.annotation.NonNull com.kwad.sdk.crash.model.message.ExceptionMessage r19, @androidx.annotation.Nullable android.content.Context r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 653
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.handler.c.a(java.lang.Throwable, com.kwad.sdk.crash.model.message.ExceptionMessage, android.content.Context, boolean):void");
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, com.kwad.sdk.crash.f fVar, e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.e.Lr().isDebug()) {
            b.initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }
}
