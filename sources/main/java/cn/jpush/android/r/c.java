package cn.jpush.android.r;

import android.content.Context;
import android.text.TextUtils;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import java.io.Closeable;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class c {
    public static cn.jpush.android.d.d a(Context context, cn.jpush.android.d.d dVar) {
        String str;
        String str2;
        boolean z5;
        try {
            String str3 = dVar.bi;
            if (TextUtils.isEmpty(str3)) {
                str3 = cn.jpush.android.ad.a.d(dVar.bj);
            }
            String str4 = str3;
            String str5 = dVar.f3588d;
            LinkedHashMap<String, cn.jpush.android.t.b> a6 = a(context);
            cn.jpush.android.t.b bVar = a6.get(str4);
            str = "";
            if (bVar != null) {
                str2 = bVar.f3830b;
                if (cn.jpush.android.ad.c.a(str2)) {
                    dVar.be = "file://" + str2;
                    bVar.f3831c = System.currentTimeMillis();
                    Logger.d("InAppTplHelper", "use cache template, templateId: " + str4 + ", webPagePath: " + str2 + ", totalTemplateCount: " + a6.values().size() + ", update template file time: " + new File(str2).setLastModified(bVar.f3831c));
                } else {
                    a6.remove(str4);
                    Logger.d("InAppTplHelper", "local config has template path, but the template file is not exist, will download again.");
                    str2 = "";
                }
                a(context, a6);
            } else {
                str2 = "";
            }
            String str6 = dVar.bj;
            int i6 = 0;
            if (TextUtils.isEmpty(str2)) {
                Logger.d("InAppTplHelper", "no local template cache, start download template, url: " + str6);
                if (TextUtils.isEmpty(str6)) {
                    Logger.w("InAppTplHelper", "template url is Empty! Give up to download!");
                    z5 = false;
                } else {
                    String a7 = cn.jpush.android.w.b.a(context, str6, "inapp_tpl", 5, 5000L);
                    boolean isEmpty = TextUtils.isEmpty(a7);
                    str = isEmpty ? "" : a7;
                    z5 = !isEmpty;
                }
                if (!z5) {
                    Logger.w("InAppTplHelper", "NOTE: failed to download html page. Give up this.");
                    return null;
                }
                String str7 = cn.jpush.android.ad.c.a(context, "h5_tpls", 20) + str4 + ".html";
                Logger.d("InAppTplHelper", "download template success, will save to local of path: " + str7);
                if (cn.jpush.android.ad.c.b(str7, str)) {
                    dVar.be = "file://" + str7;
                    Logger.d("InAppTplHelper", "cache h5 template to local success, templateId: " + str4 + ", path: " + dVar.be);
                    a6.put(str4, cn.jpush.android.t.b.a(str4, str7, System.currentTimeMillis()));
                    a(context, a6);
                } else {
                    dVar.be = dVar.bj;
                }
            }
            if (dVar.bn.size() > 0) {
                Logger.d("InAppTplHelper", "template has image resource, start download image to local, images: " + dVar.bn.toString());
                ArrayList<String> a8 = a(dVar.bn, context, str6.substring(0, str6.lastIndexOf("/") + 1), str5);
                if (a8 == null) {
                    Logger.w("InAppTplHelper", "Load notify in-app message image resources failed, give up this in app!");
                    return null;
                }
                Logger.d("InAppTplHelper", "Load notify in-app message image succeed, webView will open cache!");
                String str8 = dVar.bl;
                try {
                    JSONObject jSONObject = new JSONObject(str8);
                    while (i6 < a8.size()) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("in_pic_path");
                        int i7 = i6 + 1;
                        sb.append(i7);
                        jSONObject.put(sb.toString(), a8.get(i6));
                        i6 = i7;
                    }
                    dVar.bl = jSONObject.toString();
                    Logger.d("InAppTplHelper", "http image resources replace local path, new templateData: " + dVar.bl);
                } catch (Throwable th) {
                    dVar.bl = str8;
                    Logger.w("InAppTplHelper", "replace template picture resource error, " + th.getMessage());
                }
            } else {
                Logger.d("InAppTplHelper", "template no image resource.");
            }
        } catch (Throwable unused) {
        }
        return dVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x009a A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x002b, B:10:0x0047, B:12:0x004d, B:14:0x006d, B:17:0x0076, B:18:0x0096, B:20:0x009a, B:22:0x00a0, B:24:0x00aa, B:26:0x00b4, B:28:0x00ce, B:30:0x00d5, B:32:0x00f5, B:34:0x00fb, B:36:0x0117, B:38:0x0100, B:41:0x007b, B:43:0x007f), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00aa A[Catch: all -> 0x0073, TryCatch #0 {all -> 0x0073, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x002b, B:10:0x0047, B:12:0x004d, B:14:0x006d, B:17:0x0076, B:18:0x0096, B:20:0x009a, B:22:0x00a0, B:24:0x00aa, B:26:0x00b4, B:28:0x00ce, B:30:0x00d5, B:32:0x00f5, B:34:0x00fb, B:36:0x0117, B:38:0x0100, B:41:0x007b, B:43:0x007f), top: B:2:0x000c }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0117 A[Catch: all -> 0x0073, TRY_LEAVE, TryCatch #0 {all -> 0x0073, blocks: (B:3:0x000c, B:6:0x0021, B:8:0x002b, B:10:0x0047, B:12:0x004d, B:14:0x006d, B:17:0x0076, B:18:0x0096, B:20:0x009a, B:22:0x00a0, B:24:0x00aa, B:26:0x00b4, B:28:0x00ce, B:30:0x00d5, B:32:0x00f5, B:34:0x00fb, B:36:0x0117, B:38:0x0100, B:41:0x007b, B:43:0x007f), top: B:2:0x000c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static cn.jpush.android.d.d b(android.content.Context r17, cn.jpush.android.d.d r18) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.c.b(android.content.Context, cn.jpush.android.d.d):cn.jpush.android.d.d");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x006b A[Catch: all -> 0x0038, TryCatch #1 {all -> 0x0038, blocks: (B:9:0x0010, B:11:0x002d, B:15:0x0040, B:17:0x006b, B:19:0x00a0, B:21:0x003c), top: B:8:0x0010, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a0 A[Catch: all -> 0x0038, TRY_LEAVE, TryCatch #1 {all -> 0x0038, blocks: (B:9:0x0010, B:11:0x002d, B:15:0x0040, B:17:0x006b, B:19:0x00a0, B:21:0x003c), top: B:8:0x0010, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String a(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
            java.lang.String r1 = "InAppTplHelper"
            java.lang.String r4 = "inapp_image"
            r6 = 3145728(0x300000, float:4.408104E-39)
            r7 = 1
            r5 = 3
            r2 = r8
            r3 = r9
            byte[] r8 = cn.jpush.android.w.b.a(r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lc3
            if (r8 == 0) goto Lc6
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r9.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = "download image resource success, path: "
            r9.append(r0)     // Catch: java.lang.Throwable -> L38
            r9.append(r3)     // Catch: java.lang.Throwable -> L38
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Throwable -> L38
            cn.jpush.android.helper.Logger.d(r1, r9)     // Catch: java.lang.Throwable -> L38
            java.lang.String r9 = "http://"
            boolean r9 = r3.startsWith(r9)     // Catch: java.lang.Throwable -> L38
            r0 = 1
            if (r9 != 0) goto L3c
            java.lang.String r9 = "https://"
            boolean r9 = r3.startsWith(r9)     // Catch: java.lang.Throwable -> L38
            if (r9 == 0) goto L36
            goto L3c
        L36:
            r9 = r3
            goto L40
        L38:
            r0 = move-exception
            r8 = r0
            goto Lbd
        L3c:
            java.lang.String r9 = cn.jpush.android.ad.c.a(r3, r0)     // Catch: java.lang.Throwable -> L38
        L40:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r4.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r5.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r6 = "j_in_app_"
            r5.append(r6)     // Catch: java.lang.Throwable -> L38
            r5.append(r10)     // Catch: java.lang.Throwable -> L38
            java.lang.String r10 = r5.toString()     // Catch: java.lang.Throwable -> L38
            r5 = 0
            java.lang.String r10 = cn.jpush.android.ad.c.a(r2, r10, r5, r0)     // Catch: java.lang.Throwable -> L38
            r4.append(r10)     // Catch: java.lang.Throwable -> L38
            r4.append(r9)     // Catch: java.lang.Throwable -> L38
            java.lang.String r10 = r4.toString()     // Catch: java.lang.Throwable -> L38
            boolean r8 = cn.jpush.android.ad.c.a(r10, r8)     // Catch: java.lang.Throwable -> L38
            if (r8 == 0) goto La0
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r8.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = "download image resource cache to local success, path: "
            r8.append(r0)     // Catch: java.lang.Throwable -> L38
            r8.append(r10)     // Catch: java.lang.Throwable -> L38
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L38
            cn.jpush.android.helper.Logger.d(r1, r8)     // Catch: java.lang.Throwable -> L38
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r8.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = "download image resource cache to local success, Uri.fromFile: "
            r8.append(r0)     // Catch: java.lang.Throwable -> L38
            java.io.File r0 = new java.io.File     // Catch: java.lang.Throwable -> L38
            r0.<init>(r9)     // Catch: java.lang.Throwable -> L38
            android.net.Uri r9 = android.net.Uri.fromFile(r0)     // Catch: java.lang.Throwable -> L38
            r8.append(r9)     // Catch: java.lang.Throwable -> L38
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L38
            cn.jpush.android.helper.Logger.d(r1, r8)     // Catch: java.lang.Throwable -> L38
            cn.jpush.android.ad.e.a(r10, r3)     // Catch: java.lang.Throwable -> L38
            return r10
        La0:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L38
            r9.<init>()     // Catch: java.lang.Throwable -> L38
            java.lang.String r0 = "Succeed to load image - "
            r9.append(r0)     // Catch: java.lang.Throwable -> L38
            r9.append(r10)     // Catch: java.lang.Throwable -> L38
            java.lang.String r10 = ", cache local status: "
            r9.append(r10)     // Catch: java.lang.Throwable -> L38
            r9.append(r8)     // Catch: java.lang.Throwable -> L38
            java.lang.String r8 = r9.toString()     // Catch: java.lang.Throwable -> L38
            cn.jpush.android.helper.Logger.v(r1, r8)     // Catch: java.lang.Throwable -> L38
            goto Lf3
        Lbd:
            java.lang.String r9 = "Write storage error,  create img file fail."
            cn.jpush.android.helper.Logger.ww(r1, r9, r8)     // Catch: java.lang.Throwable -> Lc3
            goto Lf3
        Lc3:
            r0 = move-exception
            r8 = r0
            goto Ldb
        Lc6:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lc3
            r8.<init>()     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r9 = "download image resource failed, path: "
            r8.append(r9)     // Catch: java.lang.Throwable -> Lc3
            r8.append(r3)     // Catch: java.lang.Throwable -> Lc3
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Lc3
            cn.jpush.android.helper.Logger.w(r1, r8)     // Catch: java.lang.Throwable -> Lc3
            goto Lf3
        Ldb:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r10 = "load h5 template image resource failed, "
            r9.append(r10)
            java.lang.String r8 = r8.getMessage()
            r9.append(r8)
            java.lang.String r8 = r9.toString()
            cn.jpush.android.helper.Logger.w(r1, r8)
        Lf3:
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.c.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    private static void b(Context context, String str, String str2) {
        Logger.d("InAppTplHelper", "handleImage   downImage is null ");
        String a6 = cn.jpush.android.w.b.a(str);
        Logger.d("InAppTplHelper", "handleImage   downImage is null,errorCode= " + a6);
        if (!TextUtils.isEmpty(a6)) {
            Logger.d("InAppTplHelper", "downImage fail by network,so save it,wait network change good to show ");
            cn.jpush.android.w.b.b(str);
        } else {
            Logger.d("InAppTplHelper", "downImage fail by other reason，so delete message");
            cn.jpush.android.helper.c.a(context, str2, 3008L, 4);
            cn.jpush.android.p.b.a().c(str2);
        }
    }

    private static ArrayList<String> a(ArrayList<String> arrayList, Context context, String str, String str2) {
        return a(arrayList, context, str, str2, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00be A[Catch: all -> 0x009d, TryCatch #1 {all -> 0x009d, blocks: (B:26:0x007c, B:30:0x0096, B:33:0x00a3, B:35:0x00be, B:36:0x00d5, B:39:0x009f), top: B:25:0x007c, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.ArrayList<java.lang.String> a(java.util.ArrayList<java.lang.String> r10, android.content.Context r11, java.lang.String r12, java.lang.String r13, boolean r14) {
        /*
            Method dump skipped, instructions count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.jpush.android.r.c.a(java.util.ArrayList, android.content.Context, java.lang.String, java.lang.String, boolean):java.util.ArrayList");
    }

    private static LinkedHashMap<String, cn.jpush.android.t.b> a(Context context) {
        LinkedHashMap<String, cn.jpush.android.t.b> linkedHashMap = new LinkedHashMap<>();
        if (context == null) {
            Logger.w("InAppTplHelper", "readTemplateConfig context is null");
            return linkedHashMap;
        }
        try {
            File a6 = cn.jpush.android.ad.c.a(context, "tpl.cache");
            if (a6 != null && a6.exists()) {
                String c6 = cn.jpush.android.ad.c.c(a6);
                if (!TextUtils.isEmpty(c6)) {
                    JSONObject jSONObject = new JSONObject(c6);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        cn.jpush.android.t.b a7 = cn.jpush.android.t.b.a(jSONObject.getJSONObject(keys.next()));
                        if (a7 != null) {
                            linkedHashMap.put(a7.f3829a, a7);
                        }
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            try {
                Logger.w("InAppTplHelper", "readTemplateConfig failed, " + th.getMessage());
                return linkedHashMap;
            } finally {
                m.a((Closeable) null);
            }
        }
    }

    public static LinkedHashMap<String, cn.jpush.android.t.b> a(LinkedHashMap<String, cn.jpush.android.t.b> linkedHashMap) {
        LinkedHashMap<String, cn.jpush.android.t.b> linkedHashMap2 = new LinkedHashMap<>();
        try {
            ArrayList<Map.Entry> arrayList = new ArrayList(linkedHashMap.entrySet());
            Collections.sort(arrayList, new Comparator<Map.Entry<String, cn.jpush.android.t.b>>() { // from class: cn.jpush.android.r.c.1
                @Override // java.util.Comparator
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public int compare(Map.Entry<String, cn.jpush.android.t.b> entry, Map.Entry<String, cn.jpush.android.t.b> entry2) {
                    if (entry2.getValue().f3831c > entry.getValue().f3831c) {
                        return 1;
                    }
                    if (entry2.getValue().f3831c < entry.getValue().f3831c) {
                        return -1;
                    }
                    return 0;
                }
            });
            for (Map.Entry entry : arrayList) {
                linkedHashMap2.put((String) entry.getKey(), (cn.jpush.android.t.b) entry.getValue());
            }
            return linkedHashMap2;
        } catch (Throwable th) {
            Logger.w("InAppTplHelper", "sortHashMap failed, " + th.getMessage());
            return linkedHashMap2;
        }
    }

    private static void a(Context context, LinkedHashMap<String, cn.jpush.android.t.b> linkedHashMap) {
        try {
            File a6 = cn.jpush.android.ad.c.a(context, "tpl.cache");
            if (a6 == null) {
                Logger.w("InAppTplHelper", "saveTemplateConfig file is null");
                return;
            }
            JSONObject jSONObject = new JSONObject();
            if (linkedHashMap.size() > 20) {
                linkedHashMap = a(linkedHashMap);
            }
            int i6 = 0;
            for (Map.Entry<String, cn.jpush.android.t.b> entry : linkedHashMap.entrySet()) {
                cn.jpush.android.t.b value = entry.getValue();
                if (i6 < 20) {
                    jSONObject.put(entry.getKey(), value.a());
                } else {
                    String str = value.f3830b;
                    File file = new File(str);
                    if (file.exists() && file.isFile()) {
                        file.delete();
                        Logger.d("InAppTplHelper", "exceed max template cache count, delete old template file: " + str + ", maxCacheCount: 20");
                    }
                }
                i6++;
            }
            Logger.d("InAppTplHelper", "[saveTemplateConfig] template config info: " + jSONObject.toString() + ", templateSize: " + linkedHashMap.values().size());
            cn.jpush.android.ad.c.a(a6.getAbsolutePath(), jSONObject.toString());
        } catch (Throwable th) {
            Logger.w("InAppTplHelper", "saveTemplateConfig failed, " + th.getMessage());
        }
    }
}
