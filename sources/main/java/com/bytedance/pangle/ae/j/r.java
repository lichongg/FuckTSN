package com.bytedance.pangle.ae.j;

import android.content.pm.PackageInfo;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.ae;
import com.huawei.hms.framework.common.hianalytics.WiseOpenHianalyticsData;
import java.io.File;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {
    public static up j(File file) {
        ZipFile zipFile;
        j jVar;
        int xt;
        int i6;
        try {
            if (!file.exists()) {
                ZeusLogger.w(ZeusLogger.TAG_INSTALL, file.getAbsolutePath() + " not exists!");
                ae.j((ZipFile) null);
                return null;
            }
            ZipFile zipFile2 = new ZipFile(file);
            try {
                ZipEntry entry = zipFile2.getEntry("AndroidManifest.xml");
                if (entry == null) {
                    ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "没有找到AndroidManifest.xml entry");
                    ae.j(zipFile2);
                    return null;
                }
                jVar = new j();
                try {
                    jVar.j(zipFile2.getInputStream(entry));
                    do {
                        xt = jVar.xt();
                        if (xt == 1) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "已达到END_DOCUMENT");
                            try {
                                jVar.j();
                            } catch (Throwable unused) {
                            }
                            ae.j(zipFile2);
                            return null;
                        }
                    } while (xt != 2);
                    int cw = jVar.cw();
                    String str = null;
                    String str2 = null;
                    for (int i7 = 0; i7 != cw; i7++) {
                        if ("versionCode".equals(jVar.j(i7))) {
                            str = j(jVar, i7);
                        } else if (WiseOpenHianalyticsData.UNION_PACKAGE.equals(jVar.j(i7))) {
                            str2 = j(jVar, i7);
                        }
                    }
                    try {
                        i6 = Integer.parseInt(str);
                    } catch (Throwable unused2) {
                        i6 = -1;
                    }
                    if (i6 == -1) {
                        ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "versionCode获取失败:".concat(String.valueOf(str)));
                        try {
                            jVar.j();
                        } catch (Throwable unused3) {
                        }
                        ae.j(zipFile2);
                        return null;
                    }
                    up upVar = new up(str2, i6);
                    try {
                        jVar.j();
                    } catch (Throwable unused4) {
                    }
                    ae.j(zipFile2);
                    return upVar;
                } catch (Throwable th) {
                    zipFile = zipFile2;
                    th = th;
                    try {
                        PackageInfo packageArchiveInfo = Zeus.getAppApplication().getPackageManager().getPackageArchiveInfo(file.getPath(), 0);
                        if (packageArchiveInfo == null) {
                            ZeusLogger.errReport(ZeusLogger.TAG_INSTALL, "packageArchiveInfo == null", th);
                            return null;
                        }
                        up upVar2 = new up(packageArchiveInfo.packageName, packageArchiveInfo.versionCode);
                        if (jVar != null) {
                            try {
                                jVar.j();
                            } catch (Throwable unused5) {
                            }
                        }
                        ae.j(zipFile);
                        return upVar2;
                    } finally {
                        if (jVar != null) {
                            try {
                                jVar.j();
                            } catch (Throwable unused6) {
                            }
                        }
                        ae.j(zipFile);
                    }
                }
            } catch (Throwable th2) {
                zipFile = zipFile2;
                th = th2;
                jVar = null;
            }
        } catch (Throwable th3) {
            th = th3;
            zipFile = null;
            jVar = null;
        }
    }

    private static String j(int i6) {
        if ((i6 >>> 24) == 1) {
            return "android:";
        }
        return "";
    }

    private static String j(j jVar, int i6) {
        int xt = jVar.xt(i6);
        int cw = jVar.cw(i6);
        if (xt == 3) {
            return jVar.r(i6);
        }
        return xt == 2 ? String.format("?%s%08X", j(cw), Integer.valueOf(cw)) : (xt < 16 || xt > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(cw), Integer.valueOf(xt)) : String.valueOf(cw);
    }
}
