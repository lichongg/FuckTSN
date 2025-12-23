package com.huawei.hms.common.util;

import android.content.Context;
import android.os.Build;
import com.huawei.hms.feature.dynamic.ModuleCopy;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class ExtractNativeUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final String f33105a = "ExtractNativeUtils";

    /* renamed from: b, reason: collision with root package name */
    public static final int f33106b = 0;

    /* renamed from: c, reason: collision with root package name */
    public static final int f33107c = -1;

    /* renamed from: d, reason: collision with root package name */
    public static final int f33108d = 50;

    /* renamed from: e, reason: collision with root package name */
    public static final int f33109e = 52428800;

    /* renamed from: f, reason: collision with root package name */
    public static final Pattern f33110f = Pattern.compile("lib/([^/]+)/(.*\\.so)$");

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static /* synthetic */ class a {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        public String f33111a;

        /* renamed from: b, reason: collision with root package name */
        public ZipEntry f33112b;

        /* renamed from: c, reason: collision with root package name */
        public String f33113c;

        public b(ZipEntry zipEntry, String str, String str2) {
            this.f33112b = zipEntry;
            this.f33111a = str;
            this.f33113c = str2;
        }

        public /* synthetic */ b(ZipEntry zipEntry, String str, String str2, a aVar) {
            this(zipEntry, str, str2);
        }
    }

    public static int a(File file, String str) {
        Logger.i(f33105a, "begin extractNativeLibrary");
        int i6 = 0;
        ZipFile zipFile = null;
        try {
            try {
                ZipFile zipFile2 = new ZipFile(file);
                try {
                    try {
                        Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                        HashMap hashMap = new HashMap();
                        int b6 = b(entries, hashMap, 0);
                        if (b6 == -1) {
                            Logger.e(f33105a, "Unsafe zip name!");
                        } else {
                            if (b6 <= 50) {
                                Iterator it = hashMap.keySet().iterator();
                                int i7 = 0;
                                while (it.hasNext()) {
                                    try {
                                        Set<b> set = (Set) hashMap.get((String) it.next());
                                        if (set == null) {
                                            Logger.e(f33105a, "Get nativeZipEntries failed.");
                                        } else {
                                            for (b bVar : set) {
                                                String str2 = str + File.separator + bVar.f33113c;
                                                ModuleCopy.makeDirectory(str2);
                                                new File(str2).setExecutable(true, false);
                                                i7 = c(zipFile2, bVar, str2);
                                                if (i7 != 0) {
                                                    try {
                                                        zipFile2.close();
                                                        return i7;
                                                    } catch (IOException e6) {
                                                        Logger.e(f33105a, "IOException:", e6);
                                                        return i7;
                                                    }
                                                }
                                                new File(str2, bVar.f33111a).setReadable(true, false);
                                            }
                                        }
                                    } catch (IOException e7) {
                                        e = e7;
                                        i6 = i7;
                                        zipFile = zipFile2;
                                        Logger.e(f33105a, "catch IOException ", e);
                                        if (zipFile == null) {
                                            return i6;
                                        }
                                        try {
                                            zipFile.close();
                                            return i6;
                                        } catch (IOException e8) {
                                            e = e8;
                                            i7 = i6;
                                            Logger.e(f33105a, "IOException:", e);
                                            return i7;
                                        }
                                    }
                                }
                                try {
                                    zipFile2.close();
                                    return i7;
                                } catch (IOException e9) {
                                    e = e9;
                                    Logger.e(f33105a, "IOException:", e);
                                    return i7;
                                }
                            }
                            Logger.e(f33105a, "the total number is larger than the max");
                        }
                        try {
                            zipFile2.close();
                            return -1;
                        } catch (IOException e10) {
                            Logger.e(f33105a, "IOException:", e10);
                            return -1;
                        }
                    } catch (Throwable th) {
                        th = th;
                        zipFile = zipFile2;
                        if (zipFile != null) {
                            try {
                                zipFile.close();
                            } catch (IOException e11) {
                                Logger.e(f33105a, "IOException:", e11);
                            }
                        }
                        throw th;
                    }
                } catch (IOException e12) {
                    e = e12;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e13) {
            e = e13;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002d, code lost:
    
        com.huawei.hms.common.util.Logger.e(com.huawei.hms.common.util.ExtractNativeUtils.f33105a, "so file too big , " + r10.f33113c + " , " + r10.f33111a);
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ae A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:70:0x00a4 -> B:15:0x00a7). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(java.util.zip.ZipFile r9, com.huawei.hms.common.util.ExtractNativeUtils.b r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 193
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.util.ExtractNativeUtils.c(java.util.zip.ZipFile, com.huawei.hms.common.util.ExtractNativeUtils$b, java.lang.String):int");
    }

    public static boolean d(Context context, String str) {
        if (Build.VERSION.SDK_INT <= 23) {
            Logger.i(f33105a, "The android version is below android 6.");
            return true;
        }
        try {
            if ((context.getPackageManager().getPackageArchiveInfo(str, 128).applicationInfo.flags & 268435456) == 268435456) {
                Logger.i(f33105a, "The extract-native-flag has set, need to extract.");
                return true;
            }
            Logger.i(f33105a, "The extract-native-flag has not set, No need to extract.");
            return false;
        } catch (Exception unused) {
            Logger.w(f33105a, "Get package name failed: name not found.");
            return true;
        }
    }

    public static int b(Enumeration enumeration, HashMap<String, HashSet<b>> hashMap, int i6) {
        while (enumeration.hasMoreElements()) {
            Object nextElement = enumeration.nextElement();
            if (nextElement != null && (nextElement instanceof ZipEntry)) {
                ZipEntry zipEntry = (ZipEntry) nextElement;
                String name = zipEntry.getName();
                if (name.contains("../")) {
                    Logger.e(f33105a, "Unsafe zip name!");
                    return -1;
                }
                Matcher matcher = f33110f.matcher(name);
                if (matcher.matches()) {
                    String group = matcher.group(1);
                    String group2 = matcher.group(2);
                    HashSet<b> hashSet = hashMap.get(group);
                    if (hashSet == null) {
                        hashSet = new HashSet<>();
                        hashMap.put(group, hashSet);
                    }
                    hashSet.add(new b(zipEntry, group2, group, null));
                    i6++;
                }
            }
        }
        return i6;
    }
}
