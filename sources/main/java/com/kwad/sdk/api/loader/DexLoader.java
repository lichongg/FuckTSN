package com.kwad.sdk.api.loader;

import android.content.Context;
import android.content.res.AssetManager;
import androidx.annotation.Keep;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Objects;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@Keep
/* loaded from: D:\Downloads\app\classes6.dex */
public class DexLoader {
    private static final String DEX_ROOT_DIR_NAME = "ksad_dex";
    private static final String TAG = "DexLoader";
    private static final String TARGET_DEX_NAME = "dexJar.jar";
    private static final String dexJarCheckFileName = "ksaddex_makejar.check";
    private static final String dexJarFileName = "ksad_data.jar";
    private static String sDexPathRoot;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.Closeable, java.io.InputStream] */
    private static File copyAssetsToData(Context context, String str, DexLoadError dexLoadError) {
        Closeable closeable;
        Closeable closeable2;
        FileOutputStream fileOutputStream;
        File file;
        Closeable closeable3 = null;
        try {
            try {
                AssetManager assets = context.getAssets();
                File file2 = new File(getDexRootPath(context));
                if (!file2.exists()) {
                    file2.mkdir();
                }
                file = new File(getTargetDexFilePath(context));
                if (file.exists()) {
                    file.delete();
                }
                file.createNewFile();
                str = assets.open(str);
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e6) {
                    e = e6;
                    fileOutputStream = null;
                    closeable2 = str;
                } catch (Throwable th) {
                    th = th;
                    closeable = null;
                    closeable3 = str;
                    closeQuietly(closeable3);
                    closeQuietly(closeable);
                    throw th;
                }
            } catch (IOException e7) {
                e = e7;
                closeable2 = null;
                fileOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                closeable = null;
                closeQuietly(closeable3);
                closeQuietly(closeable);
                throw th;
            }
            try {
                int a6 = p.a(getTargetDexFilePath(context), (InputStream) str, p.bb(context));
                if (a6 != 1 && dexLoadError != null) {
                    dexLoadError.setErrorCode(a6);
                }
                fileOutputStream.flush();
                file.setReadable(true);
                file.setWritable(false);
                closeQuietly(str);
                closeQuietly(fileOutputStream);
                return file;
            } catch (IOException e8) {
                e = e8;
                closeable2 = str;
                e.printStackTrace();
                if (dexLoadError != null) {
                    dexLoadError.setErrorCode(-3);
                    dexLoadError.setErrorMsg(e.getMessage());
                }
                closeQuietly(closeable2);
                closeQuietly(fileOutputStream);
                return null;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static boolean isTargetDexFileExist(Context context) {
        return false;
    }

    private static String obtainCheckMd5(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split(com.snail.antifake.deviceid.e.f37542d);
        if (split.length == 0) {
            return null;
        }
        return split[0];
    }

    private static int obtainVersionCode(String str) {
        if (str == null) {
            return -1;
        }
        String[] split = str.split(com.snail.antifake.deviceid.e.f37542d);
        if (split.length == 0) {
            return -1;
        }
        int length = split.length;
        for (int i6 = 0; i6 < length; i6++) {
            String str2 = split[i6];
            if (str2.startsWith("versionCode:")) {
                try {
                    return Integer.parseInt(str2.replace("versionCode:", "").trim());
                } catch (NumberFormatException e6) {
                    e6.printStackTrace();
                }
            }
        }
        return -1;
    }

    private static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private static void copyFile(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[1024];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    private static String getDexRootPath(Context context) {
        String str = sDexPathRoot;
        if (str != null) {
            return str;
        }
        return context.getApplicationInfo().dataDir + File.separator + DEX_ROOT_DIR_NAME;
    }

    private static boolean checkLocal(Context context, String str, int i6) {
        if (i6 != 4063001) {
            return false;
        }
        File file = new File(getTargetDexFilePath(context));
        if (!file.exists() || !Objects.equals(y.getFileMD5(file), str)) {
            return false;
        }
        return true;
    }

    private static ClassLoader createDexClassLoader(Context context, ClassLoader classLoader, String str, DexLoadError dexLoadError) {
        try {
            String b6 = z.b(classLoader);
            Objects.toString(classLoader);
            ClassLoader a6 = g.a(context, classLoader, str, context.getCacheDir().getAbsolutePath(), b6);
            Objects.toString(a6.loadClass("com.kwad.sdk.KsAdSDKImpl"));
            return a6;
        } catch (ClassNotFoundException e6) {
            e6.printStackTrace();
            if (dexLoadError != null) {
                dexLoadError.setErrorMsg(e6.getMessage());
                dexLoadError.setErrorCode(-1);
                return null;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            if (dexLoadError != null) {
                dexLoadError.setErrorMsg(th.getMessage());
                dexLoadError.setErrorCode(-2);
                return null;
            }
            return null;
        }
    }

    public static String getTargetDexFilePath(Context context) {
        return getDexRootPath(context) + File.separator + TARGET_DEX_NAME;
    }

    public static ClassLoader initDex(Context context, ClassLoader classLoader) {
        q Dp = r.Dp();
        if (Dp != null) {
            Dp.onInit(context);
        }
        Objects.toString(Dp);
        DexLoadError dexLoadError = new DexLoadError();
        String prepareDexFile = prepareDexFile(context, dexLoadError);
        dexLoadError.toString();
        if (!dexLoadError.success()) {
            if (Dp != null) {
                Dp.reportDexLoadError(context, dexLoadError);
            }
            return null;
        }
        ClassLoader createDexClassLoader = createDexClassLoader(context, classLoader, prepareDexFile, dexLoadError);
        dexLoadError.toString();
        if (dexLoadError.success()) {
            return createDexClassLoader;
        }
        if (Dp != null) {
            Dp.reportDexLoadError(context, dexLoadError);
        }
        return null;
    }

    private static String prepareDexFile(Context context, DexLoadError dexLoadError) {
        String targetDexFilePath = getTargetDexFilePath(context);
        String readCheckFile = readCheckFile(context);
        String obtainCheckMd5 = obtainCheckMd5(readCheckFile);
        if (checkLocal(context, obtainCheckMd5, obtainVersionCode(readCheckFile))) {
            return targetDexFilePath;
        }
        File copyAssetsToData = copyAssetsToData(context, dexJarFileName, dexLoadError);
        if (copyAssetsToData != null && copyAssetsToData.exists()) {
            String fileMD5 = y.getFileMD5(copyAssetsToData);
            if (Objects.equals(fileMD5, obtainCheckMd5)) {
                return copyAssetsToData.getAbsolutePath();
            }
            dexLoadError.setErrorCode(-4);
            dexLoadError.setErrorMsg("targetMd5:" + fileMD5 + ", assetJarFileMd5:" + obtainCheckMd5);
            return targetDexFilePath;
        }
        return targetDexFilePath;
    }

    private static String readCheckFile(Context context) {
        Closeable closeable;
        Throwable th;
        InputStream inputStream;
        InputStream inputStream2;
        BufferedReader bufferedReader;
        InputStream inputStream3;
        AssetManager assets = context.getAssets();
        String str = null;
        try {
            try {
                InputStream open = assets.open(dexJarCheckFileName);
                try {
                    StringBuilder sb = new StringBuilder();
                    bufferedReader = new BufferedReader(new InputStreamReader(open, "UTF-8"));
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            sb.append(readLine);
                            sb.append(com.snail.antifake.deviceid.e.f37542d);
                        } catch (IOException e6) {
                            e = e6;
                            inputStream2 = open;
                            e.printStackTrace();
                            inputStream3 = inputStream2;
                            closeQuietly(inputStream3);
                            closeQuietly(bufferedReader);
                            return str;
                        }
                    }
                    str = sb.toString().trim();
                    inputStream3 = open;
                } catch (IOException e7) {
                    e = e7;
                    bufferedReader = null;
                    inputStream2 = open;
                } catch (Throwable th2) {
                    closeable = null;
                    th = th2;
                    inputStream = open;
                    closeQuietly(inputStream);
                    closeQuietly(closeable);
                    throw th;
                }
            } catch (IOException e8) {
                e = e8;
                inputStream2 = null;
                bufferedReader = null;
            } catch (Throwable th3) {
                closeable = null;
                th = th3;
                inputStream = null;
            }
            closeQuietly(inputStream3);
            closeQuietly(bufferedReader);
            return str;
        } catch (Throwable th4) {
            th = th4;
            inputStream = assets;
        }
    }
}
