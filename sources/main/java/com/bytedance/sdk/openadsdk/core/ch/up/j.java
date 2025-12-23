package com.bytedance.sdk.openadsdk.core.ch.up;

import com.bytedance.sdk.openadsdk.ats.cw;
import com.bytedance.sdk.openadsdk.core.ch.xt;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f28024j;

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public String j() {
        return "ugen_render";
    }

    public static j xt() {
        if (f28024j == null) {
            synchronized (j.class) {
                try {
                    if (f28024j == null) {
                        f28024j = new j();
                    }
                } finally {
                }
            }
        }
        return f28024j;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public String j(String str) {
        int xt = cw.xt(j()).xt(str, 0);
        return (xt == 0 && (str.equals("h5_render_success") || str.equals("h5_render_fail") || str.equals("native_render_success") || str.equals("native_render_fail"))) ? "0" : String.valueOf(xt);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0104 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x000d, B:6:0x001f, B:9:0x00de, B:11:0x00e6, B:13:0x01a1, B:17:0x00ee, B:19:0x0104, B:20:0x0108, B:22:0x010e, B:44:0x011a, B:25:0x011e, B:27:0x0137, B:30:0x013d, B:41:0x0148, B:33:0x0156, B:36:0x015e, B:47:0x016c, B:49:0x0174, B:50:0x018f, B:51:0x0182, B:52:0x002b, B:54:0x0041, B:55:0x0045, B:57:0x004b, B:79:0x0057, B:60:0x005b, B:62:0x0074, B:65:0x007a, B:76:0x0085, B:68:0x0093, B:71:0x009b, B:82:0x00a9, B:84:0x00b1, B:85:0x00cc, B:86:0x00bf), top: B:3:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0174 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x000d, B:6:0x001f, B:9:0x00de, B:11:0x00e6, B:13:0x01a1, B:17:0x00ee, B:19:0x0104, B:20:0x0108, B:22:0x010e, B:44:0x011a, B:25:0x011e, B:27:0x0137, B:30:0x013d, B:41:0x0148, B:33:0x0156, B:36:0x015e, B:47:0x016c, B:49:0x0174, B:50:0x018f, B:51:0x0182, B:52:0x002b, B:54:0x0041, B:55:0x0045, B:57:0x004b, B:79:0x0057, B:60:0x005b, B:62:0x0074, B:65:0x007a, B:76:0x0085, B:68:0x0093, B:71:0x009b, B:82:0x00a9, B:84:0x00b1, B:85:0x00cc, B:86:0x00bf), top: B:3:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0182 A[Catch: all -> 0x0028, TryCatch #0 {all -> 0x0028, blocks: (B:4:0x000d, B:6:0x001f, B:9:0x00de, B:11:0x00e6, B:13:0x01a1, B:17:0x00ee, B:19:0x0104, B:20:0x0108, B:22:0x010e, B:44:0x011a, B:25:0x011e, B:27:0x0137, B:30:0x013d, B:41:0x0148, B:33:0x0156, B:36:0x015e, B:47:0x016c, B:49:0x0174, B:50:0x018f, B:51:0x0182, B:52:0x002b, B:54:0x0041, B:55:0x0045, B:57:0x004b, B:79:0x0057, B:60:0x005b, B:62:0x0074, B:65:0x007a, B:76:0x0085, B:68:0x0093, B:71:0x009b, B:82:0x00a9, B:84:0x00b1, B:85:0x00cc, B:86:0x00bf), top: B:3:0x000d }] */
    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void j(java.lang.String r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ch.up.j.j(java.lang.String, java.lang.String):void");
    }
}
