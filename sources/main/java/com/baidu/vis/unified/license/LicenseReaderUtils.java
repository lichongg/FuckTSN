package com.baidu.vis.unified.license;

import android.content.Context;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class LicenseReaderUtils {
    public static final String TAG = "License-SDK";

    public static String getSuccessInfo(Context context, String str) {
        String str2 = null;
        if (context != null && !TextUtils.isEmpty(str)) {
            FileInputStream read_license_from_data = read_license_from_data(context, str);
            try {
                if (read_license_from_data != null) {
                    try {
                        str2 = new BufferedReader(new InputStreamReader(read_license_from_data)).readLine();
                    } catch (FileNotFoundException | IOException unused) {
                    } catch (Exception e6) {
                        e6.getMessage();
                    }
                }
            } finally {
                try {
                    read_license_from_data.close();
                } catch (IOException e7) {
                    e7.printStackTrace();
                }
            }
        }
        return str2;
    }

    private static InputStream read_license_from_asset(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            return context.getAssets().open(str);
        } catch (IOException e6) {
            e6.printStackTrace();
            return null;
        } catch (Exception e7) {
            e7.getMessage();
            e7.printStackTrace();
            return null;
        }
    }

    private static FileInputStream read_license_from_data(Context context, String str) {
        if (context == null) {
            return null;
        }
        try {
            File dir = context.getDir(str, 0);
            if (dir == null || !dir.exists() || !dir.isFile() || dir.length() == 0) {
                return null;
            }
            return new FileInputStream(dir);
        } catch (FileNotFoundException e6) {
            e6.printStackTrace();
            return null;
        } catch (Exception e7) {
            e7.getMessage();
            e7.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0068, code lost:
    
        if (r4 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0061, code lost:
    
        r4.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005f, code lost:
    
        if (r4 == null) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int setSuccessInfo(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            r0 = -1
            if (r3 == 0) goto L77
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 != 0) goto L77
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 == 0) goto L11
            goto L77
        L11:
            r1 = 0
            java.io.File r3 = r3.getDir(r4, r1)
            if (r3 == 0) goto L21
            boolean r4 = r3.exists()
            if (r4 == 0) goto L21
            r3.delete()
        L21:
            if (r3 == 0) goto L31
            boolean r4 = r3.exists()
            if (r4 != 0) goto L31
            r3.createNewFile()     // Catch: java.io.IOException -> L2d
            goto L31
        L2d:
            r4 = move-exception
            r4.printStackTrace()
        L31:
            r4 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58 java.io.FileNotFoundException -> L5a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L56 java.io.IOException -> L58 java.io.FileNotFoundException -> L5a
            byte[] r3 = r5.getBytes()     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50 java.io.FileNotFoundException -> L53
            r2.write(r3)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50 java.io.FileNotFoundException -> L53
            r3 = 10
            r2.write(r3)     // Catch: java.lang.Throwable -> L4d java.io.IOException -> L50 java.io.FileNotFoundException -> L53
            r2.close()     // Catch: java.io.IOException -> L48
            r0 = 0
            goto L6b
        L48:
            r3 = move-exception
            r3.printStackTrace()
            goto L6b
        L4d:
            r3 = move-exception
            r4 = r2
            goto L6c
        L50:
            r3 = move-exception
            r4 = r2
            goto L5c
        L53:
            r3 = move-exception
            r4 = r2
            goto L65
        L56:
            r3 = move-exception
            goto L6c
        L58:
            r3 = move-exception
            goto L5c
        L5a:
            r3 = move-exception
            goto L65
        L5c:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L56
            if (r4 == 0) goto L6b
        L61:
            r4.close()     // Catch: java.io.IOException -> L48
            goto L6b
        L65:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L56
            if (r4 == 0) goto L6b
            goto L61
        L6b:
            return r0
        L6c:
            if (r4 == 0) goto L76
            r4.close()     // Catch: java.io.IOException -> L72
            goto L76
        L72:
            r4 = move-exception
            r4.printStackTrace()
        L76:
            throw r3
        L77:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vis.unified.license.LicenseReaderUtils.setSuccessInfo(android.content.Context, java.lang.String, java.lang.String):int");
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0074, code lost:
    
        if (r3 == null) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x006d, code lost:
    
        r3.close();
        r3 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x006b, code lost:
    
        if (r3 == null) goto L58;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:60:0x005e -> B:31:0x0077). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean write_license_content(android.content.Context r2, java.lang.String r3, java.util.ArrayList<java.lang.String> r4) {
        /*
            r0 = 0
            if (r4 == 0) goto L83
            int r1 = r4.size()
            if (r1 == 0) goto L83
            if (r2 != 0) goto Ld
            goto L83
        Ld:
            java.io.File r2 = r2.getDir(r3, r0)
            if (r2 == 0) goto L1c
            boolean r3 = r2.exists()
            if (r3 == 0) goto L1c
            r2.delete()
        L1c:
            if (r2 == 0) goto L2c
            boolean r3 = r2.exists()
            if (r3 != 0) goto L2c
            r2.createNewFile()     // Catch: java.io.IOException -> L28
            goto L2c
        L28:
            r3 = move-exception
            r3.printStackTrace()
        L2c:
            r3 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L64 java.io.FileNotFoundException -> L66
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L62 java.io.IOException -> L64 java.io.FileNotFoundException -> L66
            java.util.Iterator r2 = r4.iterator()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52 java.io.FileNotFoundException -> L55
        L36:
            boolean r3 = r2.hasNext()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52 java.io.FileNotFoundException -> L55
            if (r3 == 0) goto L58
            java.lang.Object r3 = r2.next()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52 java.io.FileNotFoundException -> L55
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52 java.io.FileNotFoundException -> L55
            byte[] r3 = r3.getBytes()     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52 java.io.FileNotFoundException -> L55
            r1.write(r3)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52 java.io.FileNotFoundException -> L55
            r3 = 10
            r1.write(r3)     // Catch: java.lang.Throwable -> L4f java.io.IOException -> L52 java.io.FileNotFoundException -> L55
            goto L36
        L4f:
            r2 = move-exception
            r3 = r1
            goto L78
        L52:
            r2 = move-exception
            r3 = r1
            goto L68
        L55:
            r2 = move-exception
            r3 = r1
            goto L71
        L58:
            r1.close()     // Catch: java.io.IOException -> L5d
            r0 = 1
            goto L77
        L5d:
            r2 = move-exception
            r2.printStackTrace()
            goto L77
        L62:
            r2 = move-exception
            goto L78
        L64:
            r2 = move-exception
            goto L68
        L66:
            r2 = move-exception
            goto L71
        L68:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L62
            if (r3 == 0) goto L77
        L6d:
            r3.close()     // Catch: java.io.IOException -> L5d
            goto L77
        L71:
            r2.printStackTrace()     // Catch: java.lang.Throwable -> L62
            if (r3 == 0) goto L77
            goto L6d
        L77:
            return r0
        L78:
            if (r3 == 0) goto L82
            r3.close()     // Catch: java.io.IOException -> L7e
            goto L82
        L7e:
            r3 = move-exception
            r3.printStackTrace()
        L82:
            throw r2
        L83:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vis.unified.license.LicenseReaderUtils.write_license_content(android.content.Context, java.lang.String, java.util.ArrayList):boolean");
    }

    public static InputStream get_local_license_file_inputstream(Context context, String str, ReadStatusCode readStatusCode) {
        if (context == null) {
            return null;
        }
        readStatusCode.is_from_asset = false;
        FileInputStream read_license_from_system_path = str.startsWith("/") ? read_license_from_system_path(str) : read_license_from_data(context, str);
        if (read_license_from_system_path != null) {
            return read_license_from_system_path;
        }
        InputStream read_license_from_asset = read_license_from_asset(context, str);
        readStatusCode.is_from_asset = true;
        return read_license_from_asset;
    }

    private static ArrayList<String> read_license_content(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayList<String> arrayList = new ArrayList<>();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    private static FileInputStream read_license_from_system_path(String str) {
        try {
            return new FileInputStream(new File(str));
        } catch (FileNotFoundException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    LicenseReaderUtils() {
    }
}
