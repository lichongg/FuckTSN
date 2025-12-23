package com.bytedance.pangle.tl;

import android.system.Os;
import android.system.OsConstants;
import java.io.FileDescriptor;

/* loaded from: D:\Downloads\app\classes4.dex */
class vl implements qv {

    /* renamed from: j, reason: collision with root package name */
    private static final long f25531j = Os.sysconf(OsConstants._SC_PAGESIZE);
    private final long cw;

    /* renamed from: r, reason: collision with root package name */
    private final long f25532r;
    private final FileDescriptor xt;

    @Override // com.bytedance.pangle.tl.qv
    public long j() {
        return this.f25532r;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0123 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x005d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0145 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.bytedance.pangle.tl.qv
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(com.bytedance.pangle.tl.oq r18, long r19, int r21) throws java.io.IOException, java.security.DigestException {
        /*
            Method dump skipped, instructions count: 329
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.pangle.tl.vl.j(com.bytedance.pangle.tl.oq, long, int):void");
    }

    vl(FileDescriptor fileDescriptor, long j6, long j7) {
        this.xt = fileDescriptor;
        this.cw = j6;
        this.f25532r = j7;
    }
}
