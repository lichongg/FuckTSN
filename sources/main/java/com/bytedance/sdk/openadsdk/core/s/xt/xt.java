package com.bytedance.sdk.openadsdk.core.s.xt;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.core.v;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
import tv.cjump.jni.DeviceUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {
    private static Map<String, Integer> cw = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private static String f30203j;
    private static String xt;

    private static Map<String, List<ZipEntry>> j(ZipFile zipFile) {
        String[] split;
        HashMap hashMap = new HashMap();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                String str = split[split.length - 2];
                if (cw.containsKey(str)) {
                    if (hashMap.get(str) == null) {
                        hashMap.put(str, new LinkedList());
                    }
                    ((List) hashMap.get(str)).add(nextElement);
                }
            }
        }
        vl.j("NativeLibHelper", "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
        return hashMap;
    }

    private static String xt() {
        JSONObject cw2 = cw();
        String j6 = j(cw2);
        return j6 == null ? xt(cw2) : j6;
    }

    static {
        if (cw.j()) {
            xt = Build.SUPPORTED_ABIS[0];
        } else {
            xt = Build.CPU_ABI;
        }
        cw.put("arm64-v8a", 64);
        cw.put("armeabi-v7a", 32);
        cw.put("armeabi", 32);
        cw.put("x86_64", 64);
        cw.put(DeviceUtils.f54642a, 32);
        cw.put("mips64", 64);
        cw.put(DeviceUtils.f54643b, 32);
        f30203j = xt();
    }

    private static JSONObject cw() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("primaryCpuAbi", "0");
            jSONObject.put("processMode", "0");
            jSONObject.put("supportedABI0", "0");
            jSONObject.put("matchCpuAbi", "0");
            jSONObject.put("defaultABI0", "0");
            jSONObject.put("defaultABI", "0");
            jSONObject.put("autoError", "0");
            jSONObject.put("manualError", "0");
            return jSONObject;
        } catch (JSONException e6) {
            vl.j(e6);
            return jSONObject;
        }
    }

    private static String xt(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            Context context = v.getContext();
            ZipFile zipFile = new ZipFile(new File(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(j(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                vl.xt("NativeLibHelper", "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            if (cw.j()) {
                strArr = Build.SUPPORTED_ABIS;
            } else {
                strArr = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            }
        } catch (Throwable th) {
            vl.cw("NativeLibHelper", "NativeLibHelper inferHostAbiManual failed!", th);
            j(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            vl.xt("NativeLibHelper", "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            j(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                vl.xt("NativeLibHelper", "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                j(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (cw.j()) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            j(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        String str2 = Build.CPU_ABI;
        j(jSONObject, "defaultABI", str2);
        return str2;
    }

    public static String j() {
        String str = f30203j;
        if (str != null) {
            return str;
        }
        String xt2 = xt();
        f30203j = xt2;
        return xt2;
    }

    private static String j(JSONObject jSONObject) {
        boolean is64Bit;
        if (!cw.j()) {
            return null;
        }
        try {
            String str = (String) j.j(v.getContext().getApplicationInfo(), "primaryCpuAbi");
            vl.xt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
            j(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i6 = 0;
            if (cw.xt()) {
                try {
                    is64Bit = Process.is64Bit();
                    i6 = is64Bit ? 64 : 32;
                    vl.xt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i6)));
                } catch (Exception unused) {
                    vl.xt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i6)));
                }
            } else {
                vl.xt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            j(jSONObject, "processMode", String.valueOf(i6));
            if (i6 != 0) {
                if (cw.get(str).intValue() != i6) {
                    return null;
                }
                vl.xt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(str));
            } else {
                vl.xt("NativeLibHelper", "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(str));
            }
            return str;
        } catch (Exception e6) {
            vl.cw("NativeLibHelper", "NativeLibHelper inferHostAbiAuto failed!", e6);
            j(jSONObject, "autoError", "1");
            return null;
        }
    }

    private static void j(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e6) {
            vl.j(e6);
        }
    }
}
