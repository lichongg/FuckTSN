package com.bykv.vk.component.ttvideo.utils;

/* loaded from: D:\Downloads\app\classes3.dex */
public class VersionInfo {
    private static String[] mVersion;

    /* JADX WARN: Code restructure failed: missing block: B:35:0x006d, code lost:
    
        if (r7 != null) goto L56;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String[] getVersion() {
        /*
            java.lang.String[] r0 = com.bykv.vk.component.ttvideo.utils.VersionInfo.mVersion
            if (r0 != 0) goto L7e
            r0 = 4
            java.lang.String[] r0 = new java.lang.String[r0]
            r1 = 0
            java.lang.String r2 = "null"
            r0[r1] = r2
            r3 = 1
            r0[r3] = r2
            r4 = 2
            r0[r4] = r2
            r5 = 3
            r0[r5] = r2
            java.lang.String r2 = "/proc/version"
            r6 = 0
            java.io.FileReader r7 = new java.io.FileReader     // Catch: java.lang.Throwable -> L52
            r7.<init>(r2)     // Catch: java.lang.Throwable -> L52
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L50
            r8 = 8192(0x2000, float:1.148E-41)
            r2.<init>(r7, r8)     // Catch: java.lang.Throwable -> L50
            java.lang.String r6 = r2.readLine()     // Catch: java.lang.Throwable -> L4d
            java.lang.String r8 = "\\s+"
            java.lang.String[] r6 = r6.split(r8)     // Catch: java.lang.Throwable -> L4d
            r6 = r6[r4]     // Catch: java.lang.Throwable -> L4d
            r0[r1] = r6     // Catch: java.lang.Throwable -> L4d
            r2.close()     // Catch: java.lang.Throwable -> L3e
        L35:
            r7.close()     // Catch: java.lang.Throwable -> L39
            goto L70
        L39:
            r1 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r1)
            goto L70
        L3e:
            r1 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r1)     // Catch: java.lang.Throwable -> L43
            goto L35
        L43:
            r0 = move-exception
            r7.close()     // Catch: java.lang.Throwable -> L48
            goto L4c
        L48:
            r1 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r1)
        L4c:
            throw r0
        L4d:
            r6 = r2
            goto L54
        L50:
            goto L54
        L52:
            r7 = r6
        L54:
            if (r6 == 0) goto L6d
            r6.close()     // Catch: java.lang.Throwable -> L5a
            goto L6d
        L5a:
            r1 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r1)     // Catch: java.lang.Throwable -> L61
            if (r7 == 0) goto L70
            goto L35
        L61:
            r0 = move-exception
            if (r7 == 0) goto L6c
            r7.close()     // Catch: java.lang.Throwable -> L68
            goto L6c
        L68:
            r1 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r1)
        L6c:
            throw r0
        L6d:
            if (r7 == 0) goto L70
            goto L35
        L70:
            java.lang.String r1 = android.os.Build.VERSION.RELEASE
            r0[r3] = r1
            java.lang.String r1 = android.os.Build.MODEL
            r0[r4] = r1
            java.lang.String r1 = android.os.Build.DISPLAY
            r0[r5] = r1
            com.bykv.vk.component.ttvideo.utils.VersionInfo.mVersion = r0
        L7e:
            java.lang.String[] r0 = com.bykv.vk.component.ttvideo.utils.VersionInfo.mVersion
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.component.ttvideo.utils.VersionInfo.getVersion():java.lang.String[]");
    }
}
