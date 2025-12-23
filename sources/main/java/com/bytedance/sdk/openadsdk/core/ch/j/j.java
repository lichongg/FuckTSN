package com.bytedance.sdk.openadsdk.core.ch.j;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.support.v4.media.session.PlaybackStateCompat;
import cn.jpush.android.api.JThirdPlatFormInterface;
import com.baidu.idl.face.platform.FaceEnvironment;
import com.bytedance.sdk.component.g.xt.cw;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.ch.xt;
import com.bytedance.sdk.openadsdk.core.cw.r;
import com.bytedance.sdk.openadsdk.core.kt.ws;
import com.bytedance.sdk.openadsdk.core.rn.uf;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.core.v.up;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import master.flame.danmaku.danmaku.model.android.d;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes4.dex */
public class j implements xt {

    /* renamed from: j, reason: collision with root package name */
    private static volatile j f28011j;
    private static final FileFilter xt = new FileFilter() { // from class: com.bytedance.sdk.openadsdk.core.ch.j.j.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            if (!name.startsWith("cpu")) {
                return false;
            }
            for (int i6 = 3; i6 < name.length(); i6++) {
                if (!Character.isDigit(name.charAt(i6))) {
                    return false;
                }
            }
            return true;
        }
    };

    public static int cw() {
        int i6 = -1;
        for (int i7 = 0; i7 < r(); i7++) {
            try {
                File file = new File("/sys/devices/system/cpu/cpu" + i7 + "/cpufreq/cpuinfo_max_freq");
                if (file.exists() && file.canRead()) {
                    byte[] bArr = new byte[128];
                    FileInputStream fileInputStream = new FileInputStream(file);
                    try {
                        fileInputStream.read(bArr);
                        int i8 = 0;
                        while (Character.isDigit(bArr[i8]) && i8 < 128) {
                            i8++;
                        }
                        int parseInt = Integer.parseInt(new String(bArr, 0, i8));
                        if (parseInt > i6) {
                            i6 = parseInt;
                        }
                    } catch (NumberFormatException unused) {
                    } catch (Throwable th) {
                        fileInputStream.close();
                        throw th;
                    }
                    fileInputStream.close();
                }
            } catch (IOException unused2) {
                return -1;
            }
        }
        if (i6 == -1) {
            FileInputStream fileInputStream2 = new FileInputStream("/proc/cpuinfo");
            try {
                int j6 = j("cpu MHz", fileInputStream2) * 1000;
                if (j6 > i6) {
                    i6 = j6;
                }
            } finally {
                fileInputStream2.close();
            }
        }
        return i6;
    }

    @TargetApi(16)
    public static long j(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
        return memoryInfo.totalMem;
    }

    public static int r() {
        try {
            int xt2 = xt("/sys/devices/system/cpu/possible");
            if (xt2 == -1) {
                xt2 = xt("/sys/devices/system/cpu/present");
            }
            return xt2 == -1 ? new File("/sys/devices/system/cpu/").listFiles(xt).length : xt2;
        } catch (NullPointerException | SecurityException unused) {
            return -1;
        }
    }

    public static j xt() {
        if (f28011j == null) {
            synchronized (j.class) {
                try {
                    if (f28011j == null) {
                        f28011j = new j();
                    }
                } finally {
                }
            }
        }
        return f28011j;
    }

    private void tl() {
        try {
            cw cw = up.j().xt().cw();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("os", FaceEnvironment.OS);
            jSONObject.put("device_model", Build.MODEL);
            cw.j(Uri.parse(uf.tl("/api/ad/union/sdk/device_score")).buildUpon().appendQueryParameter("is_bidding", "1").appendQueryParameter(JThirdPlatFormInterface.KEY_EXTRA, com.bytedance.sdk.component.utils.j.xt(jSONObject.toString())).toString());
            com.bytedance.sdk.component.g.xt j6 = cw.j();
            if (j6 == null || !j6.tl()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(j6.r());
            if (jSONObject2.optInt("code") != 200) {
                j("bytebench_value", "-1.0");
                return;
            }
            double optDouble = jSONObject2.optDouble("score");
            j("bytebench_update_time", String.valueOf(System.currentTimeMillis()));
            j("bytebench_value", String.valueOf(optDouble));
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("score", optDouble);
            ws.j().r(jSONObject3);
        } catch (Exception e6) {
            vl.j(e6);
            JSONObject jSONObject4 = new JSONObject();
            try {
                jSONObject4.put("score", -1);
                ws.j().r(jSONObject4);
            } catch (JSONException e7) {
                vl.j(e7);
            }
        }
    }

    public boolean ae() {
        String j6 = j("bytebench_update_time");
        return j6.isEmpty() || System.currentTimeMillis() - Long.parseLong(j6) >= 15552000000L;
    }

    public boolean m() {
        String j6 = j("update_time");
        return j6.isEmpty() || System.currentTimeMillis() - Long.parseLong(j6) >= 15552000000L;
    }

    private int g() {
        int xt2 = xt(v.getContext());
        int oq = oq();
        int i6 = 2;
        if (xt2 != 0 && xt2 != 1 && oq != 0) {
            if (xt2 != 2 || oq <= 0) {
                if (xt2 > 2) {
                    if (oq > 1) {
                        i6 = 0;
                    }
                } else {
                    i6 = -1000;
                }
            }
            i6 = 1;
        }
        j("ram_level", String.valueOf(xt2));
        j("cpu_level", String.valueOf(oq));
        j("update_time", String.valueOf(System.currentTimeMillis()));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ram", xt2);
            jSONObject.put("cpu", oq);
            jSONObject.put("level", i6);
        } catch (JSONException e6) {
            vl.j(e6);
        }
        ws.j().cw(jSONObject);
        j(i6);
        return i6;
    }

    private static int oq() {
        int cw = cw() / 1000;
        if (cw <= 1600) {
            return 0;
        }
        if (cw <= 2000) {
            return 1;
        }
        if (cw <= 2500) {
            return 2;
        }
        return 3;
    }

    public void up() {
        if (v.xt().sh() && m()) {
            g();
        }
        if (v.xt().cb() && ae()) {
            tl();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0034, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int j(java.lang.String r6, java.io.FileInputStream r7) {
        /*
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]
            int r7 = r7.read(r0)     // Catch: java.lang.Throwable -> L37
            r1 = 0
        L9:
            if (r1 >= r7) goto L3b
            r2 = r0[r1]     // Catch: java.lang.Throwable -> L37
            r3 = 10
            if (r2 == r3) goto L13
            if (r1 != 0) goto L34
        L13:
            if (r2 != r3) goto L17
            int r1 = r1 + 1
        L17:
            r2 = r1
        L18:
            if (r2 >= r7) goto L34
            int r3 = r2 - r1
            r4 = r0[r2]     // Catch: java.lang.Throwable -> L37
            char r5 = r6.charAt(r3)     // Catch: java.lang.Throwable -> L37
            if (r4 != r5) goto L34
            int r4 = r6.length()     // Catch: java.lang.Throwable -> L37
            int r4 = r4 + (-1)
            if (r3 != r4) goto L31
            int r6 = j(r0, r2)     // Catch: java.lang.Throwable -> L37
            return r6
        L31:
            int r2 = r2 + 1
            goto L18
        L34:
            int r1 = r1 + 1
            goto L9
        L37:
            r6 = move-exception
            com.bytedance.sdk.component.utils.vl.j(r6)
        L3b:
            r6 = -1
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.ch.j.j.j(java.lang.String, java.io.FileInputStream):int");
    }

    private static int xt(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String readLine = bufferedReader.readLine();
                bufferedReader.close();
                int cw = cw(readLine);
                fileInputStream.close();
                return cw;
            } finally {
            }
        } catch (IOException unused) {
            return -1;
        }
    }

    private static int j(byte[] bArr, int i6) {
        byte b6;
        while (i6 < bArr.length && (b6 = bArr[i6]) != 10) {
            if (Character.isDigit(b6)) {
                int i7 = i6 + 1;
                while (i7 < bArr.length && Character.isDigit(bArr[i7])) {
                    i7++;
                }
                return Integer.parseInt(new String(bArr, 0, i6, i7 - i6));
            }
            i6++;
        }
        return -1;
    }

    private static int xt(Context context) {
        long j6 = j(context) / PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED;
        if (j6 <= 2000) {
            return 0;
        }
        if (j6 <= 3000) {
            return 1;
        }
        if (j6 <= d.f50003r) {
            return 2;
        }
        return j6 <= 6000 ? 3 : 4;
    }

    private static int cw(String str) {
        if (str == null || !str.matches("0-[\\d]+$")) {
            return -1;
        }
        return Integer.valueOf(str.substring(2)).intValue() + 1;
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public String j() {
        return "DeviceRate";
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public String j(String str) {
        return com.bytedance.sdk.openadsdk.ats.cw.xt(j()).xt(str, "");
    }

    @Override // com.bytedance.sdk.openadsdk.core.ch.xt
    public void j(String str, String str2) {
        com.bytedance.sdk.openadsdk.ats.cw.xt(j()).j(str, str2);
    }

    private void j(int i6) {
        j("device_level", String.valueOf(i6));
        r.j().tl(i6);
    }
}
