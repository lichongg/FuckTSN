package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.amap.api.col.p0003l.b3;
import com.amap.api.col.p0003l.b8;
import com.amap.api.col.p0003l.c3;
import com.amap.api.col.p0003l.d3;
import com.amap.api.col.p0003l.p4;
import com.amap.api.col.p0003l.v5;
import com.amap.api.col.p0003l.x5;
import com.amap.api.col.p0003l.y2;
import com.amap.api.col.p0003l.z2;
import com.autonavi.amap.mapcore.MsgProcessor;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.config.a;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AeUtil {
    private static final String AMAP_ASSETS_DB_CK_PATH = "ae/res.ck";
    private static final String AMAP_GLOBAL_DB_NAME = "global.db";
    private static final String AMAP_GLOBAL_SP_ITEM_MD5 = "amap_res_global_db_md5";
    private static final String AMAP_GLOBAL_SP_NAME = "amap_res_global_db";
    private static final String AMAP_INTERSECTION_ASSETS_DIR = "VM3DRes";
    public static final String AMAP_RESZIP_TARGET_DIR_NAME = "res920";
    public static final String CONFIGNAME = "GNaviConfig.xml";
    public static final boolean IS_AE = true;
    public static final String RESZIPNAME = "res.zip";
    public static final String ROOTPATH = "/amap/";
    public static final String ROOT_DATA_PATH_NAME = "data_v6";
    public static final String ROOT_DATA_PATH_OLD_NAME = "data";
    private static String global_db_path;

    private static String formatFileSeparator(String str) {
        return str != null ? str.replace("//", "/") : str;
    }

    private static String getAssetsGlobalDbMd5(Context context) {
        return new String(FileUtil.readFileContentsFromAssets(context, AMAP_ASSETS_DB_CK_PATH));
    }

    public static String getGlobalDbPath() {
        return global_db_path;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void loadAndSaveIntersectionRes(String str, String str2, Context context) {
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        try {
            String[] list = context.getAssets().list(str);
            if (list == null) {
                return;
            }
            for (String str3 : list) {
                readAssetsFileAndSave(str + "/" + str3, new File(str2, str3).getAbsolutePath(), context);
            }
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0040, code lost:
    
        if (r8.equals(r10) != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0071, code lost:
    
        if (r3 != null) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00b7, code lost:
    
        if (r3 == null) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void loadEngineRes(java.lang.String r10, android.content.Context r11) {
        /*
            java.lang.String r0 = "loadEngineRes error:"
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "res920"
            r1.<init>(r10, r2)
            boolean r10 = r1.exists()
            r2 = 1
            r3 = 0
            r4 = 0
            if (r10 == 0) goto L18
            boolean r10 = r1.isDirectory()
            if (r10 != 0) goto L24
        L18:
            boolean r10 = r1.mkdirs()
            if (r10 == 0) goto L24
            java.lang.String r10 = getAssetsGlobalDbMd5(r11)
            r5 = 1
            goto L26
        L24:
            r10 = r3
            r5 = 0
        L26:
            java.lang.String r6 = "amap_res_global_db_md5"
            java.lang.String r7 = "amap_res_global_db"
            if (r5 != 0) goto L43
            java.lang.String r10 = getAssetsGlobalDbMd5(r11)
            java.lang.String r8 = ""
            java.lang.String r8 = com.amap.api.col.p0003l.r2.b(r11, r7, r6, r8)
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L44
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L43
            goto L44
        L43:
            r2 = r5
        L44:
            if (r2 == 0) goto L47
            goto L4b
        L47:
            boolean r4 = checkEngineRes(r1)
        L4b:
            java.lang.String r5 = "/global.db"
            if (r4 != 0) goto Lc5
            android.content.res.AssetManager r4 = r11.getAssets()     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L7e java.lang.Exception -> L80
            java.lang.String r8 = "ae/res.zip"
            java.io.InputStream r3 = r4.open(r8)     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L7e java.lang.Exception -> L80
            java.lang.String r4 = r1.getAbsolutePath()     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L7e java.lang.Exception -> L80
            com.autonavi.base.amap.mapcore.FileUtil.decompress(r3, r4)     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L7e java.lang.Exception -> L80
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L7e java.lang.Exception -> L80
            r4.<init>()     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L7e java.lang.Exception -> L80
            r4.append(r1)     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L7e java.lang.Exception -> L80
            r4.append(r5)     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L7e java.lang.Exception -> L80
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L7e java.lang.Exception -> L80
            com.autonavi.base.amap.mapcore.AeUtil.global_db_path = r1     // Catch: java.lang.Throwable -> L7c java.lang.OutOfMemoryError -> L7e java.lang.Exception -> L80
            if (r3 == 0) goto Ld6
        L73:
            r3.close()     // Catch: java.io.IOException -> L77
            goto Ld6
        L77:
            r0 = move-exception
            r0.printStackTrace()
            goto Ld6
        L7c:
            r10 = move-exception
            goto Lba
        L7e:
            r1 = move-exception
            goto L82
        L80:
            r1 = move-exception
            goto L9e
        L82:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L7c
            com.amap.api.col.p0003l.b3.D(r1)     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r0 = r1.getMessage()     // Catch: java.lang.Throwable -> L7c
            r4.append(r0)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L7c
            com.amap.api.col.p0003l.y2.o(r11, r0)     // Catch: java.lang.Throwable -> L7c
            if (r3 == 0) goto Ld6
            goto L73
        L9e:
            r1.printStackTrace()     // Catch: java.lang.Throwable -> L7c
            com.amap.api.col.p0003l.b3.D(r1)     // Catch: java.lang.Throwable -> L7c
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L7c
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r0 = r1.getMessage()     // Catch: java.lang.Throwable -> L7c
            r4.append(r0)     // Catch: java.lang.Throwable -> L7c
            java.lang.String r0 = r4.toString()     // Catch: java.lang.Throwable -> L7c
            com.amap.api.col.p0003l.y2.o(r11, r0)     // Catch: java.lang.Throwable -> L7c
            if (r3 == 0) goto Ld6
            goto L73
        Lba:
            if (r3 == 0) goto Lc4
            r3.close()     // Catch: java.io.IOException -> Lc0
            goto Lc4
        Lc0:
            r11 = move-exception
            r11.printStackTrace()
        Lc4:
            throw r10
        Lc5:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            com.autonavi.base.amap.mapcore.AeUtil.global_db_path = r0
        Ld6:
            if (r2 == 0) goto Ldb
            com.amap.api.col.p0003l.r2.c(r11, r7, r6, r10)
        Ldb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.AeUtil.loadEngineRes(java.lang.String, android.content.Context):void");
    }

    public static boolean loadLib(Context context) {
        try {
            if (!a.f10289b) {
                System.loadLibrary(a.f10288a);
                a.f10289b = true;
            }
            return true;
        } catch (Throwable th) {
            v5.p(th, "AeUtil", "loadLib");
            b3.D(th);
            d3.l(c3.f5803c, "load so failed " + th.getMessage());
            return false;
        }
    }

    private static boolean checkEngineRes(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.getName().contains(AMAP_GLOBAL_DB_NAME)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void initCrashHandle(Context context) {
        p4 s5;
        try {
            if (x5.a(b3.s()).c(context) && (s5 = b3.s()) != null) {
                MsgProcessor.nativeInitInfo(context, x5.a(s5).d(context), s5.a(), s5.e(), s5.f(), s5.i());
            }
        } catch (Throwable th) {
            b3.D(th);
        }
    }

    public static void initIntersectionRes(final Context context, final GLMapEngine.InitParam initParam) {
        String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "/VM3DRes/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        initParam.mIntersectionResPath = str;
        initParam.mIntersectionResPath = formatFileSeparator(str);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                z2.a().b(new b8() { // from class: com.autonavi.base.amap.mapcore.AeUtil.2
                    @Override // com.amap.api.col.p0003l.b8
                    public final void runTask() {
                        AeUtil.loadAndSaveIntersectionRes("map_assets/VM3DRes", GLMapEngine.InitParam.this.mIntersectionResPath, context);
                    }
                });
                return;
            } catch (Exception e6) {
                e6.printStackTrace();
                return;
            }
        }
        loadAndSaveIntersectionRes("map_assets/VM3DRes", initParam.mIntersectionResPath, context);
    }

    public static GLMapEngine.InitParam initResource(final Context context) {
        final String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "/data_v6/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                z2.a().b(new b8() { // from class: com.autonavi.base.amap.mapcore.AeUtil.1
                    @Override // com.amap.api.col.p0003l.b8
                    public final void runTask() {
                        AeUtil.loadEngineRes(mapBaseStorage, context);
                    }
                });
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        } else {
            loadEngineRes(mapBaseStorage, context);
        }
        GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
        byte[] readFileContentsFromAssets = FileUtil.readFileContentsFromAssets(context, "ae/GNaviConfig.xml");
        initParam.mRootPath = mapBaseStorage;
        if (readFileContentsFromAssets != null) {
            try {
                String str2 = new String(readFileContentsFromAssets, "utf-8");
                initParam.mConfigContent = str2;
                if (!str2.contains(ROOT_DATA_PATH_NAME)) {
                    throw new Exception("GNaviConfig.xml 和数据目录data_v6不匹配");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                y2.o(context, "initConfig error:" + th.getMessage());
            }
        }
        String str3 = str + "/map/";
        initParam.mOfflineDataPath = str3;
        initParam.mP3dCrossPath = str;
        initParam.mOfflineDataPath = formatFileSeparator(str3);
        initParam.mRootPath = formatFileSeparator(initParam.mRootPath);
        initParam.mP3dCrossPath = formatFileSeparator(initParam.mP3dCrossPath);
        return initParam;
    }

    public static void readAssetsFileAndSave(String str, String str2, Context context) {
        FileOutputStream fileOutputStream;
        if (!TextUtils.isEmpty(str)) {
            InputStream inputStream = null;
            try {
                try {
                    InputStream open = context.getAssets().open(str);
                    try {
                        File file = new File(str2);
                        if (file.exists()) {
                            file.delete();
                        }
                        file.createNewFile();
                        FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                        try {
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = open.read(bArr, 0, 1024);
                                if (read > 0) {
                                    fileOutputStream2.write(bArr, 0, read);
                                } else {
                                    try {
                                        break;
                                    } catch (IOException e6) {
                                        e6.printStackTrace();
                                    }
                                }
                            }
                            open.close();
                            fileOutputStream2.close();
                        } catch (Throwable th) {
                            inputStream = open;
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            try {
                                th.printStackTrace();
                                if (inputStream != null) {
                                    try {
                                        inputStream.close();
                                    } catch (IOException e7) {
                                        e7.printStackTrace();
                                    }
                                }
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                            } finally {
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        inputStream = open;
                        fileOutputStream = null;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileOutputStream = null;
                }
            } catch (IOException e8) {
                e8.printStackTrace();
            }
        }
    }
}
