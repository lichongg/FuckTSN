package com.bytedance.sdk.component.panglearmor.j.xt;

import com.bxkj.base.v2.common.utils.g0;
import com.bytedance.component.sdk.annotation.DungeonFlag;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class m {
    @DungeonFlag
    private static String j(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            byte[] digest = MessageDigest.getInstance("SHA1").digest(bArr);
            StringBuilder sb = new StringBuilder();
            for (byte b6 : digest) {
                sb.append(Integer.toHexString((b6 & 255) | 256).substring(1, 3).toUpperCase());
                sb.append(":");
            }
            return sb.substring(0, sb.length() - 1);
        } catch (NoSuchAlgorithmException unused) {
            return null;
        }
    }

    private static JSONObject xt(List<j> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        for (j jVar : list) {
            if (jVar != null) {
                arrayList.add(j(jVar.xt()));
                arrayList2.add(String.valueOf(jVar.j()));
            }
        }
        j(jSONObject, "sign", arrayList, false);
        j(jSONObject, "subject", arrayList2, false);
        return jSONObject;
    }

    public static void j(JSONObject jSONObject, String str, List<String> list, boolean z5) {
        if (jSONObject == null || list == null || list.isEmpty()) {
            return;
        }
        if (z5) {
            try {
                jSONObject.put(str + "Size", list.size());
            } catch (JSONException unused) {
                return;
            }
        }
        jSONObject.put(str, up.j(list));
    }

    private static JSONObject j(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (String str : list) {
            if (str.endsWith(g0.f16898c)) {
                arrayList2.add(str.substring(0, str.lastIndexOf(g0.f16898c)));
            } else if (str.endsWith(".xml")) {
                arrayList.add(str.substring(0, str.lastIndexOf(".xml")));
            } else {
                arrayList3.add(str);
            }
        }
        j(jSONObject, "xml", arrayList, true);
        j(jSONObject, "png", arrayList2, true);
        j(jSONObject, "other", arrayList3, true);
        return jSONObject;
    }

    public static long j(long j6, InputStream inputStream) throws IOException {
        if (j6 != -1) {
            return j6;
        }
        byte[] bArr = new byte[8192];
        long j7 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return j7;
            }
            j7 += read;
        }
    }

    private static void j(File file, List<j> list) {
        try {
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, t.f36150k);
            try {
                xt j6 = cw.j(randomAccessFile, 0L, randomAccessFile.length());
                list.addAll(com.bytedance.sdk.component.panglearmor.j.j.xt.j.j.j.j(j6, com.bytedance.sdk.component.panglearmor.j.j.j.j.j(j6)));
                randomAccessFile.close();
            } finally {
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x0271, code lost:
    
        if (r10 == null) goto L118;
     */
    @com.bytedance.component.sdk.annotation.DungeonFlag
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject j(java.io.File r23) {
        /*
            Method dump skipped, instructions count: 629
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.panglearmor.j.xt.m.j(java.io.File):org.json.JSONObject");
    }
}
