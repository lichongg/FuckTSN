package com.bytedance.sdk.openadsdk.core.rn;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.List;

/* loaded from: D:\Downloads\app\classes4.dex */
public class w {

    private static class j {
        String cw;

        /* renamed from: j, reason: collision with root package name */
        String f30169j;
        String xt;

        public boolean equals(Object obj) {
            String str;
            if (!(obj instanceof j)) {
                return super.equals(obj);
            }
            j jVar = (j) obj;
            String str2 = this.f30169j;
            return str2 != null && str2.equals(jVar.f30169j) && (str = this.cw) != null && str.equals(jVar.cw);
        }

        public String toString() {
            try {
                return "<" + this.f30169j + " name=\"" + this.xt + "\" path=\"" + this.cw + "\" />";
            } catch (Throwable unused) {
                return super.toString();
            }
        }

        j(String str, String str2, String str3) {
            this.f30169j = str;
            this.xt = str2;
            this.cw = str3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void j() {
        /*
            Method dump skipped, instructions count: 642
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.rn.w.j():void");
    }

    private static List<j> cw() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new j("external-path", "tt_external_download", "Download"));
        arrayList.add(new j("external-files-path", "tt_external_files_download", "Download"));
        arrayList.add(new j("files-path", "tt_internal_file_download", "Download"));
        arrayList.add(new j("cache-path", "tt_internal_cache_download", "Download"));
        return arrayList;
    }

    private static List<j> r() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new j("external-path", "tt_external_root", "."));
        return arrayList;
    }

    private static List<String> xt() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.kuaishou.weapon.p0.g.f36041a);
        arrayList.add(com.kuaishou.weapon.p0.g.f36042b);
        arrayList.add(com.kuaishou.weapon.p0.g.f36044d);
        arrayList.add(com.kuaishou.weapon.p0.g.f36043c);
        arrayList.add(com.kuaishou.weapon.p0.g.f36050j);
        arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
        arrayList.add(com.kuaishou.weapon.p0.g.f36048h);
        arrayList.add(com.kuaishou.weapon.p0.g.f36047g);
        return arrayList;
    }

    private static String j(Context context) {
        try {
            return com.bytedance.sdk.component.utils.i.xt(context);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static List<j> j(Context context, int i6) {
        XmlResourceParser xmlResourceParser;
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            xmlResourceParser = context.getResources().getXml(i6);
        } catch (Throwable unused) {
            xmlResourceParser = null;
        }
        try {
            for (int eventType = xmlResourceParser.getEventType(); eventType != 1; eventType = xmlResourceParser.next()) {
                if (eventType == 2) {
                    String name = xmlResourceParser.getName();
                    int attributeCount = xmlResourceParser.getAttributeCount();
                    String str = null;
                    String str2 = null;
                    for (int i7 = 0; i7 < attributeCount; i7++) {
                        String attributeName = xmlResourceParser.getAttributeName(i7);
                        if (attributeName.equals(CommonNetImpl.NAME)) {
                            str = xmlResourceParser.getAttributeValue(i7);
                        } else if (attributeName.equals("path")) {
                            str2 = xmlResourceParser.getAttributeValue(i7);
                        }
                    }
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        arrayList.add(new j(name, str, str2));
                    }
                }
            }
            xmlResourceParser.close();
            return arrayList;
        } catch (Throwable unused2) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return null;
        }
    }
}
