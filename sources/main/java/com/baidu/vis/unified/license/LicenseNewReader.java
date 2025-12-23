package com.baidu.vis.unified.license;

import android.content.Context;
import com.google.android.gms.actions.SearchIntents;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
class LicenseNewReader {
    public static final String TAG = "License-SDK";

    public static int readFile(Context context, String str, ArrayList<String> arrayList) {
        if (context != null && str != null && arrayList != null) {
            ArrayList arrayList2 = new ArrayList();
            ReadStatusCode readStatusCode = new ReadStatusCode();
            readStatusCode.is_from_asset = false;
            InputStream inputStream = null;
            try {
                try {
                    InputStream inputStream2 = LicenseReaderUtils.get_local_license_file_inputstream(context, str, readStatusCode);
                    if (inputStream2 == null) {
                        if (inputStream2 != null) {
                            try {
                                inputStream2.close();
                                return -1;
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                        }
                        return -1;
                    }
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream2));
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            arrayList2.add(readLine);
                        } else {
                            try {
                                break;
                            } catch (IOException e7) {
                                e7.printStackTrace();
                            }
                        }
                    }
                    inputStream2.close();
                    if (arrayList2.size() > 0) {
                        if (readStatusCode.is_from_asset) {
                            LicenseReaderUtils.write_license_content(context, str, arrayList2);
                        }
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList.add((String) it.next());
                        }
                    }
                    return arrayList2.size();
                } catch (FileNotFoundException unused) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e8) {
                            e8.printStackTrace();
                        }
                    }
                } catch (IOException unused2) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e9) {
                            e9.printStackTrace();
                        }
                    }
                    return -2;
                } catch (Exception e10) {
                    e10.getMessage();
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (IOException e11) {
                            e11.printStackTrace();
                        }
                    }
                    return -2;
                }
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e12) {
                        e12.printStackTrace();
                    }
                }
                throw th;
            }
        }
        return -1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x005a, code lost:
    
        if (r4 == null) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int writeFile(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            r0 = -1
            if (r3 == 0) goto L7a
            if (r4 == 0) goto L7a
            if (r5 != 0) goto L9
            goto L7a
        L9:
            java.lang.String r1 = "/"
            boolean r1 = r4.startsWith(r1)
            if (r1 == 0) goto L17
            java.io.File r3 = new java.io.File
            r3.<init>(r4)
            goto L1f
        L17:
            r1 = 0
            java.io.File r3 = r3.getDir(r4, r1)
            r3.getAbsolutePath()
        L1f:
            r3.delete()
            boolean r4 = r3.exists()
            r1 = -2
            if (r4 != 0) goto L2e
            r3.createNewFile()     // Catch: java.io.IOException -> L2d
            goto L2e
        L2d:
            return r1
        L2e:
            r4 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.IOException -> L56 java.io.FileNotFoundException -> L58
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L52 java.lang.Exception -> L54 java.io.IOException -> L56 java.io.FileNotFoundException -> L58
            byte[] r3 = r5.getBytes()     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.io.IOException -> L4c java.io.FileNotFoundException -> L4f
            r2.write(r3)     // Catch: java.lang.Throwable -> L46 java.lang.Exception -> L49 java.io.IOException -> L4c java.io.FileNotFoundException -> L4f
            r3 = 1
            r2.close()     // Catch: java.io.IOException -> L40
            return r3
        L40:
            r3 = move-exception
            r3.printStackTrace()
        L44:
            r0 = -2
            goto L6e
        L46:
            r3 = move-exception
            r4 = r2
            goto L6f
        L49:
            r4 = r2
            goto L5a
        L4c:
            r3 = move-exception
            r4 = r2
            goto L60
        L4f:
            r3 = move-exception
            r4 = r2
            goto L66
        L52:
            r3 = move-exception
            goto L6f
        L54:
            goto L5a
        L56:
            r3 = move-exception
            goto L60
        L58:
            r3 = move-exception
            goto L66
        L5a:
            if (r4 == 0) goto L44
        L5c:
            r4.close()     // Catch: java.io.IOException -> L40
            goto L44
        L60:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L52
            if (r4 == 0) goto L44
            goto L5c
        L66:
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L52
            if (r4 == 0) goto L6e
            r4.close()     // Catch: java.io.IOException -> L40
        L6e:
            return r0
        L6f:
            if (r4 == 0) goto L79
            r4.close()     // Catch: java.io.IOException -> L75
            goto L79
        L75:
            r4 = move-exception
            r4.printStackTrace()
        L79:
            throw r3
        L7a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.vis.unified.license.LicenseNewReader.writeFile(android.content.Context, java.lang.String, java.lang.String):int");
    }

    public static HttpStatus httpPostRequest(Context context, String str, String str2) {
        String str3 = "";
        try {
            if (!"".equals(str2)) {
                JSONObject jSONObject = new JSONObject(str2);
                str3 = String.format("sdk_v=%s&query=%s", jSONObject.getString("sdk_v"), jSONObject.getString(SearchIntents.EXTRA_QUERY));
            }
            return HttpUtils.requestPost(str, str3, "application/x-www-form-urlencoded", "License-SDK");
        } catch (Exception e6) {
            e6.getMessage();
            e6.printStackTrace();
            return null;
        }
    }

    LicenseNewReader() {
    }
}
