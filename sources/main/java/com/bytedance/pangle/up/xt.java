package com.bytedance.pangle.up;

import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.ae;
import com.bytedance.pangle.util.g;
import com.bytedance.pangle.util.tl;
import com.bytedance.sdk.openadsdk.api.m;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.json.JSONException;
import org.json.JSONObject;
import tv.cjump.jni.DeviceUtils;

/* loaded from: D:\Downloads\app\classes4.dex */
public class xt {

    /* renamed from: j, reason: collision with root package name */
    private static String f25541j;
    private static Map<String, Integer> xt;

    public static void j(File file, File file2, String str, Map<String, List<ZipEntry>> map) throws IOException {
        ZipFile zipFile = null;
        try {
            j(str, file2);
            ZipFile zipFile2 = new ZipFile(file);
            if (map == null) {
                try {
                    map = j(zipFile2);
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    throw th;
                }
            }
            boolean j6 = j(map, f25541j);
            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper copyNativeLib pre-verify-matchHostAbi[" + j6 + "], pkg=" + str);
            if (j6) {
                List<ZipEntry> j7 = j(map);
                if (j7 != null && !j7.isEmpty()) {
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    Iterator<ZipEntry> it = j7.iterator();
                    while (it.hasNext()) {
                        j(zipFile2, it.next(), file2);
                    }
                }
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copyNativeLib, supportedSoEntries empty, pkg=".concat(String.valueOf(str)));
                zipFile2.close();
                return;
            }
            zipFile2.close();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static int xt() {
        return xt.get(j()).intValue();
    }

    static {
        HashMap hashMap = new HashMap();
        xt = hashMap;
        hashMap.put("arm64-v8a", 64);
        xt.put("armeabi-v7a", 32);
        xt.put("armeabi", 32);
        xt.put("x86_64", 64);
        xt.put(DeviceUtils.f54642a, 32);
        xt.put("mips64", 64);
        xt.put(DeviceUtils.f54643b, 32);
        f25541j = cw();
    }

    private static JSONObject r() {
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
            m.j(e6);
            return jSONObject;
        }
    }

    private static String cw() {
        JSONObject r5 = r();
        String j6 = j(r5);
        if (j6 == null) {
            return xt(r5);
        }
        return j6;
    }

    private static String xt(JSONObject jSONObject) {
        HashSet hashSet;
        String[] strArr;
        try {
            ZipFile zipFile = new ZipFile(new File(Zeus.getAppApplication().getPackageManager().getPackageInfo(Zeus.getAppApplication().getPackageName(), 0).applicationInfo.sourceDir));
            hashSet = new HashSet(j(zipFile).keySet());
            try {
                zipFile.close();
            } catch (IOException unused) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, close sourceApkZipFile error!");
            }
            if (g.j()) {
                strArr = Build.SUPPORTED_ABIS;
            } else {
                strArr = new String[]{Build.CPU_ABI, Build.CPU_ABI2};
            }
        } catch (Throwable th) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual failed!", th);
            j(jSONObject, "manualError", "1");
        }
        if (hashSet.isEmpty()) {
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, host source apk .so is empty, use supportedABIs[0]=" + strArr[0]);
            j(jSONObject, "supportedABI0", strArr[0]);
            return strArr[0];
        }
        for (String str : strArr) {
            if (hashSet.contains(str)) {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiManual, match cpuAbi=".concat(String.valueOf(str)));
                j(jSONObject, "matchCpuAbi", str);
                return str;
            }
        }
        if (g.j()) {
            String[] strArr2 = Build.SUPPORTED_ABIS;
            j(jSONObject, "defaultABI0", strArr2[0]);
            return strArr2[0];
        }
        String str2 = Build.CPU_ABI;
        j(jSONObject, "defaultABI", str2);
        return str2;
    }

    private static void j(String str, File file) throws IOException {
        Plugin plugin = Zeus.getPlugin(str);
        if (plugin.mSharedHostSos.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(plugin.mSharedHostSos);
        String str2 = Zeus.getAppApplication().getApplicationInfo().nativeLibraryDir;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        String[] split = str2.split(File.pathSeparator);
        for (String str3 : plugin.mSharedHostSos) {
            for (String str4 : split) {
                File file2 = new File(str4, str3);
                if (arrayList.contains(str3) && file2.exists()) {
                    tl.j(file2.getAbsolutePath(), new File(file, str3).getAbsolutePath());
                    ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoFromHost, hostSoPath=" + file2.getAbsolutePath());
                    arrayList.remove(str3);
                }
            }
        }
    }

    private static Map<String, List<ZipEntry>> j(ZipFile zipFile) {
        String[] split;
        HashMap hashMap = new HashMap();
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
        while (entries.hasMoreElements()) {
            ZipEntry nextElement = entries.nextElement();
            if (!nextElement.isDirectory() && !nextElement.getName().contains("../") && nextElement.getName().startsWith("lib/") && compile.matcher(nextElement.getName()).matches() && (split = nextElement.getName().split(File.separator)) != null && split.length >= 2) {
                String str = split[split.length - 2];
                if (xt.containsKey(str)) {
                    if (hashMap.get(str) == null) {
                        hashMap.put(str, new LinkedList());
                    }
                    ((List) hashMap.get(str)).add(nextElement);
                }
            }
        }
        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper getAllSoZipEntries, zipFile=" + zipFile.getName() + ", soEntries=" + hashMap.toString());
        return hashMap;
    }

    public static boolean xt(File file) {
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                    Pattern compile = Pattern.compile("^lib/[^/]+/lib[^/]+.so$");
                    while (entries.hasMoreElements()) {
                        ZipEntry nextElement = entries.nextElement();
                        if (!nextElement.isDirectory() && compile.matcher(nextElement.getName()).matches()) {
                            try {
                                zipFile2.close();
                                return true;
                            } catch (IOException unused) {
                                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                                return true;
                            }
                        }
                    }
                    try {
                        zipFile2.close();
                    } catch (IOException unused2) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                    }
                    return false;
                } catch (IOException e6) {
                    e = e6;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, get sourceApk ZipFile failed!", e);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused4) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper hasNativeLib, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static List<ZipEntry> j(Map<String, List<ZipEntry>> map) {
        LinkedList linkedList;
        HashSet hashSet;
        if (map == null || map.isEmpty()) {
            return null;
        }
        linkedList = new LinkedList();
        hashSet = new HashSet();
        String str = f25541j;
        str.getClass();
        switch (str) {
            case "mips64":
                j(map, "mips64", linkedList, hashSet);
                break;
            case "x86_64":
                j(map, "x86_64", linkedList, hashSet);
                break;
            case "armeabi":
                j(map, "armeabi", linkedList, hashSet);
                j(map, "armeabi-v7a", linkedList, hashSet);
                break;
            case "x86":
                j(map, DeviceUtils.f54642a, linkedList, hashSet);
                break;
            case "mips":
                j(map, DeviceUtils.f54643b, linkedList, hashSet);
                break;
            case "armeabi-v7a":
                j(map, "armeabi-v7a", linkedList, hashSet);
                j(map, "armeabi", linkedList, hashSet);
                break;
            case "arm64-v8a":
                j(map, "arm64-v8a", linkedList, hashSet);
                break;
        }
        return linkedList;
    }

    private static void j(Map<String, List<ZipEntry>> map, String str, List<ZipEntry> list, Set<String> set) {
        List<ZipEntry> list2 = map.get(str);
        if (list2 == null || list2.size() == 0) {
            return;
        }
        for (ZipEntry zipEntry : list2) {
            String substring = zipEntry.getName().substring(zipEntry.getName().lastIndexOf(File.separator) + 1);
            if (!set.contains(substring)) {
                list.add(zipEntry);
                set.add(substring);
            }
        }
    }

    private static void j(ZipFile zipFile, ZipEntry zipEntry, File file) throws IOException {
        String name = zipEntry.getName();
        if (name.contains("..")) {
            return;
        }
        File file2 = new File(file, name.substring(name.lastIndexOf(File.separator) + 1));
        int i6 = 0;
        boolean z5 = false;
        do {
            if (file2.exists()) {
                file2.delete();
            }
            try {
                ZeusLogger.i(ZeusLogger.TAG_INSTALL, "NativeLibHelper copySoZipEntry, soZipEntry=" + zipEntry + ", targetSoFile=" + file2);
                ae.j(zipFile.getInputStream(zipEntry), new FileOutputStream(file2));
                z5 = true;
            } catch (IOException e6) {
                if (i6 >= 3) {
                    throw e6;
                }
                i6++;
            }
        } while (!z5);
    }

    public static String j() {
        String str = f25541j;
        if (str != null) {
            return str;
        }
        String cw = cw();
        f25541j = cw;
        return cw;
    }

    private static String j(JSONObject jSONObject) {
        boolean is64Bit;
        if (!g.j()) {
            return null;
        }
        try {
            String str = (String) FieldUtils.readField(Zeus.getAppApplication().getApplicationInfo(), "primaryCpuAbi");
            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, primaryCpuAbi=".concat(String.valueOf(str)));
            j(jSONObject, "primaryCpuAbi", str);
            if (str == null) {
                return null;
            }
            int i6 = 0;
            if (g.oq()) {
                try {
                    is64Bit = Process.is64Bit();
                    i6 = is64Bit ? 64 : 32;
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode=".concat(String.valueOf(i6)));
                } catch (Exception unused) {
                    ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode exception default=".concat(String.valueOf(i6)));
                }
            } else {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto, processMode default=0");
            }
            j(jSONObject, "processMode", String.valueOf(i6));
            if (i6 != 0) {
                if (xt.get(str).intValue() != i6) {
                    return null;
                }
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto2, sHostAbi=".concat(str));
            } else {
                ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto1, sHostAbi=".concat(str));
            }
            return str;
        } catch (Exception e6) {
            ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper inferHostAbiAuto failed!", e6);
            j(jSONObject, "autoError", "1");
            return null;
        }
    }

    public static com.bytedance.pangle.util.up<Boolean, Map<String, List<ZipEntry>>> j(File file) {
        boolean z5;
        HashMap hashMap = new HashMap();
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    hashMap.putAll(j(zipFile2));
                    if (hashMap.isEmpty()) {
                        ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [true] soEntries empty, ".concat(String.valueOf(file)));
                        z5 = true;
                    } else {
                        boolean j6 = j(hashMap, f25541j);
                        if (j6) {
                            ZeusLogger.i(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + j6 + "], " + file);
                        } else {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi [" + j6 + "], " + file);
                        }
                        z5 = j6;
                    }
                    com.bytedance.pangle.util.up<Boolean, Map<String, List<ZipEntry>>> upVar = new com.bytedance.pangle.util.up<>(Boolean.valueOf(z5), hashMap);
                    try {
                        zipFile2.close();
                        return upVar;
                    } catch (IOException unused) {
                        ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        return upVar;
                    }
                } catch (IOException e6) {
                    e = e6;
                    zipFile = zipFile2;
                    ZeusLogger.errReport(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, get sourceApk ZipFile failed!", e);
                    com.bytedance.pangle.util.up<Boolean, Map<String, List<ZipEntry>>> upVar2 = new com.bytedance.pangle.util.up<>(Boolean.FALSE, hashMap);
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused2) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    return upVar2;
                } catch (Throwable th) {
                    th = th;
                    zipFile = zipFile2;
                    if (zipFile != null) {
                        try {
                            zipFile.close();
                        } catch (IOException unused3) {
                            ZeusLogger.w(ZeusLogger.TAG_SO, "NativeLibHelper isPluginApkMatchHostAbi, close sourceApkZipFile error!");
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static boolean j(Map<String, List<ZipEntry>> map, String str) {
        if (TextUtils.equals(str, "armeabi") || TextUtils.equals(str, "armeabi-v7a")) {
            return map.containsKey("armeabi") || map.containsKey("armeabi-v7a");
        }
        return map.containsKey(str);
    }

    private static void j(JSONObject jSONObject, String str, String str2) {
        try {
            jSONObject.put(str, str2);
        } catch (JSONException e6) {
            m.j(e6);
        }
    }
}
