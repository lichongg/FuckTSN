package com.bykv.vk.component.ttvideo.mediakit.net;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: D:\Downloads\app\classes3.dex */
public class AVMDLDNSParserBridge implements AVMDLDNSParserListener {
    private static final String TAG = "AVMDLDNSParserBridge";
    private static boolean v2Usable = true;
    public String host;
    String ipList = null;
    boolean isFinish = false;
    private Lock lock = new ReentrantLock();
    private long handle = 0;

    private static native void _notifyParserResult(long j6, String str, String str2, long j7, String str3);

    private static native void _notifyParserResultV2(long j6, String str, String str2, long j7, String str3, int i6);

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a3 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #3 {all -> 0x004b, blocks: (B:7:0x0012, B:9:0x001e, B:12:0x0033, B:13:0x0039, B:45:0x0042, B:18:0x0055, B:29:0x005f, B:31:0x0067, B:38:0x0096, B:40:0x00a3, B:35:0x0071), top: B:6:0x0012 }] */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v17 */
    /* JADX WARN: Type inference failed for: r5v18 */
    /* JADX WARN: Type inference failed for: r5v22 */
    /* JADX WARN: Type inference failed for: r5v23 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int parserResult(long r12, java.lang.String r14, int r15) {
        /*
            Method dump skipped, instructions count: 205
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.parserResult(long, java.lang.String, int):int");
    }

    public String getBackUp(String str) {
        AVMDLDNSInfo backUpIp;
        if (AVMDLDNSParser.getIntValue(5) != 1 || (backUpIp = IPCache.getInstance().getBackUpIp(str)) == null) {
            return null;
        }
        return backUpIp.mIpList;
    }

    public void release() {
        String.format("----start release:%s", this);
        this.lock.lock();
        try {
            this.handle = 0L;
            this.lock.unlock();
            String.format("remove host:%s", this.host);
            AVMDLDNSParser.getInstance().removeHost(this.host, this);
            String.format("****end call release:%s", this);
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public String getResult() {
        this.lock.lock();
        try {
            return this.ipList;
        } finally {
            this.lock.unlock();
        }
    }

    boolean isFinish() {
        return this.isFinish;
    }

    @Override // com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserListener
    public void onCompletion(int i6, String str, String str2, long j6, String str3, int i7) {
        if (!this.isFinish && v2Usable) {
            parserResult(i6, str, str2, j6, str3, i7, 2);
        }
        if (this.isFinish) {
            return;
        }
        parserResult(i6, str, str2, j6, str3, i7, 1);
    }

    public int start(long j6, String str) {
        int parserResult = v2Usable ? parserResult(j6, str, 2) : 0;
        return parserResult <= 0 ? parserResult(j6, str, 1) : parserResult;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0078  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void parserResult(int r17, java.lang.String r18, java.lang.String r19, long r20, java.lang.String r22, int r23, int r24) {
        /*
            r16 = this;
            r1 = r16
            java.util.concurrent.locks.Lock r0 = r1.lock
            r0.lock()
            r0 = 0
            boolean r2 = r1.isFinish     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r3 = 3
            r4 = 2
            r5 = 1
            if (r2 != 0) goto L8e
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            java.lang.String r6 = "receive completion code:%d result:%s type:%d"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            boolean r8 = android.text.TextUtils.isEmpty(r19)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            if (r8 == 0) goto L23
            java.lang.String r8 = "null"
            goto L25
        L20:
            r0 = move-exception
            goto Lb4
        L23:
            r8 = r19
        L25:
            java.lang.Integer r9 = java.lang.Integer.valueOf(r23)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r3[r0] = r7     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r3[r5] = r8     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r3[r4] = r9     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            java.lang.String.format(r2, r6, r3)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            boolean r3 = android.text.TextUtils.isEmpty(r19)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r6 = 0
            if (r3 == 0) goto L66
            r3 = 5
            int r3 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParser.getIntValue(r3)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            if (r3 != r5) goto L66
            com.bykv.vk.component.ttvideo.mediakit.net.IPCache r3 = com.bykv.vk.component.ttvideo.mediakit.net.IPCache.getInstance()     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r10 = r18
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSInfo r3 = r3.getBackUpIp(r10)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            if (r3 == 0) goto L68
            java.lang.String r8 = r3.mIpList     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            int r3 = r3.mType     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            java.lang.String r9 = "get backup ip, result:%s type:%d"
            java.lang.Integer r11 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            java.lang.Object[] r12 = new java.lang.Object[r4]     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r12[r0] = r8     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r12[r5] = r11     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            java.lang.String.format(r2, r9, r12)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r15 = r3
            r12 = r6
            r11 = r8
            goto L6e
        L66:
            r10 = r18
        L68:
            r11 = r19
            r12 = r20
            r15 = r23
        L6e:
            r1.ipList = r11     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r1.isFinish = r5     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            long r8 = r1.handle     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 == 0) goto La5
            r2 = r24
            if (r2 != r4) goto L84
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r5     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r14 = r22
            _notifyParserResultV2(r8, r10, r11, r12, r14, r15)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            goto La5
        L84:
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r0     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r10 = r18
            r14 = r22
            _notifyParserResult(r8, r10, r11, r12, r14)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            goto La5
        L8e:
            java.util.Locale r2 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            java.lang.String r6 = "has finished not nedd cur completion code:%d result:%s expiredTime:%d"
            java.lang.Integer r7 = java.lang.Integer.valueOf(r17)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            java.lang.Long r8 = java.lang.Long.valueOf(r20)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r3[r0] = r7     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r3[r5] = r19     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            r3[r4] = r8     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
            java.lang.String.format(r2, r6, r3)     // Catch: java.lang.Throwable -> L20 java.lang.UnsatisfiedLinkError -> Lab
        La5:
            java.util.concurrent.locks.Lock r0 = r1.lock
            r0.unlock()
            return
        Lab:
            boolean r2 = com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable     // Catch: java.lang.Throwable -> L20
            if (r2 == 0) goto Lb1
            com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.v2Usable = r0     // Catch: java.lang.Throwable -> L20
        Lb1:
            r1.isFinish = r0     // Catch: java.lang.Throwable -> L20
            goto La5
        Lb4:
            java.util.concurrent.locks.Lock r2 = r1.lock
            r2.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.mediakit.net.AVMDLDNSParserBridge.parserResult(int, java.lang.String, java.lang.String, long, java.lang.String, int, int):void");
    }
}
