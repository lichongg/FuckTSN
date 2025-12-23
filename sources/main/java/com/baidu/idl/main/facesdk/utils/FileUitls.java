package com.baidu.idl.main.facesdk.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class FileUitls {
    public static boolean assetOpen(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                context.getAssets().open(str);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean fileIsExists(String str) {
        try {
            return new File(str).exists();
        } catch (Exception e6) {
            e6.getMessage();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0035 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Bitmap getBitmap(android.content.Context r1, java.lang.String r2) {
        /*
            r0 = 0
            android.content.res.Resources r1 = r1.getResources()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            java.io.InputStream r1 = r1.open(r2)     // Catch: java.lang.Throwable -> L21 java.lang.Exception -> L23
            android.graphics.Bitmap r2 = android.graphics.BitmapFactory.decodeStream(r1)     // Catch: java.lang.Throwable -> L1c java.lang.Exception -> L1f
            if (r1 == 0) goto L1b
            r1.close()     // Catch: java.io.IOException -> L17
            return r2
        L17:
            r1 = move-exception
            r1.printStackTrace()
        L1b:
            return r2
        L1c:
            r2 = move-exception
            r0 = r1
            goto L33
        L1f:
            r2 = move-exception
            goto L25
        L21:
            r2 = move-exception
            goto L33
        L23:
            r2 = move-exception
            r1 = r0
        L25:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L1c
            if (r1 == 0) goto L32
            r1.close()     // Catch: java.io.IOException -> L2e
            goto L32
        L2e:
            r1 = move-exception
            r1.printStackTrace()
        L32:
            return r0
        L33:
            if (r0 == 0) goto L3d
            r0.close()     // Catch: java.io.IOException -> L39
            goto L3d
        L39:
            r1 = move-exception
            r1.printStackTrace()
        L3d:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.utils.FileUitls.getBitmap(android.content.Context, java.lang.String):android.graphics.Bitmap");
    }

    public static byte[] getByteArrayFromAssets(Context context, String str) {
        byte[] bArr = null;
        try {
            InputStream open = context.getAssets().open(str);
            bArr = new byte[open.available()];
            open.read(bArr);
            open.close();
            return bArr;
        } catch (IOException e6) {
            e6.getMessage();
            e6.printStackTrace();
            return bArr;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0067, code lost:
    
        if (r3 == null) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0041, code lost:
    
        if (r3 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x003b, code lost:
    
        r3.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0039, code lost:
    
        if (r3 == null) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] getModelContent(android.content.Context r4, java.lang.String r5) {
        /*
            r0 = 0
            byte[] r0 = new byte[r0]
            java.io.File r1 = new java.io.File
            r1.<init>(r5)
            boolean r2 = r1.exists()
            r3 = 0
            if (r2 == 0) goto L44
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.io.FileNotFoundException -> L31
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L2d java.io.IOException -> L2f java.io.FileNotFoundException -> L31
            int r1 = r2.available()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27 java.io.FileNotFoundException -> L2a
            byte[] r0 = new byte[r1]     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27 java.io.FileNotFoundException -> L2a
            r2.read(r0)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27 java.io.FileNotFoundException -> L2a
            r2.close()     // Catch: java.io.IOException -> L21
            goto L22
        L21:
        L22:
            r3 = r2
            goto L44
        L24:
            r4 = move-exception
            r3 = r2
            goto L33
        L27:
            r3 = r2
            goto L39
        L2a:
            r3 = r2
            goto L41
        L2d:
            r4 = move-exception
            goto L33
        L2f:
            goto L39
        L31:
            goto L41
        L33:
            if (r3 == 0) goto L38
            r3.close()     // Catch: java.io.IOException -> L38
        L38:
            throw r4
        L39:
            if (r3 == 0) goto L44
        L3b:
            r3.close()     // Catch: java.io.IOException -> L3f
            goto L44
        L3f:
            goto L44
        L41:
            if (r3 == 0) goto L44
            goto L3b
        L44:
            int r1 = r0.length
            if (r1 <= 0) goto L48
            return r0
        L48:
            android.content.res.Resources r4 = r4.getResources()     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            android.content.res.AssetManager r4 = r4.getAssets()     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            java.io.InputStream r3 = r4.open(r5)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            int r4 = r3.available()     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            byte[] r0 = new byte[r4]     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
            r3.read(r0)     // Catch: java.lang.Throwable -> L61 java.io.IOException -> L63
        L5d:
            r3.close()     // Catch: java.io.IOException -> L6a
            goto L6a
        L61:
            r4 = move-exception
            goto L6b
        L63:
            r4 = move-exception
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L61
            if (r3 == 0) goto L6a
            goto L5d
        L6a:
            return r0
        L6b:
            if (r3 == 0) goto L70
            r3.close()     // Catch: java.io.IOException -> L70
        L70:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.idl.main.facesdk.utils.FileUitls.getModelContent(android.content.Context, java.lang.String):byte[]");
    }

    public static boolean saveFile(File file, Bitmap bitmap) {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream2);
                    try {
                        fileOutputStream2.close();
                        return true;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                        return true;
                    }
                } catch (Exception e7) {
                    e = e7;
                    fileOutputStream = fileOutputStream2;
                    e.printStackTrace();
                    if (fileOutputStream == null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Exception e8) {
                        e8.printStackTrace();
                        return false;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileOutputStream = fileOutputStream2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Exception e9) {
                            e9.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception e10) {
            e = e10;
        }
    }

    public static void deleteLicense(Context context, String str) {
        File file = new File(context.getFilesDir().getParent() + "/" + str);
        if (file.exists()) {
            file.delete();
        }
        File dir = context.getDir(str, 0);
        if (dir == null || !dir.exists()) {
            return;
        }
        dir.delete();
    }

    public static String readFile(String str) {
        File file = new File(str);
        String str2 = "";
        if (file.isDirectory()) {
            return "";
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    fileInputStream.close();
                    return str2;
                }
                str2 = readLine;
            }
        } catch (FileNotFoundException unused) {
            return str2;
        } catch (IOException e6) {
            e6.getMessage();
            return str2;
        }
    }

    public static ArrayList<String> readLicense(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        File file = new File(str);
        if (file.isDirectory()) {
            return arrayList;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    fileInputStream.close();
                    return arrayList;
                }
                arrayList.add(readLine);
            }
        } catch (FileNotFoundException unused) {
            return arrayList;
        } catch (IOException e6) {
            e6.getMessage();
            return arrayList;
        }
    }

    public static File getBatchFaceDirectory(String str) {
        File sDRootFile = getSDRootFile();
        if (sDRootFile != null && sDRootFile.exists()) {
            File file = new File(sDRootFile, str);
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    public static File getFaceDirectory() {
        File sDRootFile = getSDRootFile();
        if (sDRootFile != null && sDRootFile.exists()) {
            File file = new File(sDRootFile, "faces");
            if (!file.exists()) {
                file.mkdirs();
            }
            return file;
        }
        return null;
    }

    public static String getSDPath() {
        File file;
        if (Environment.getExternalStorageState().equals("mounted")) {
            file = Environment.getExternalStorageDirectory();
        } else {
            file = null;
        }
        if (file == null) {
            return null;
        }
        return file.toString();
    }

    public static File getSDRootFile() {
        if (isSdCardAvailable()) {
            return Environment.getExternalStorageDirectory();
        }
        return null;
    }

    public static boolean isSdCardAvailable() {
        return Environment.getExternalStorageState().equals("mounted");
    }
}
