package com.umeng.socialize.net.utils;

import android.os.Bundle;
import cn.jpush.android.local.JPushConstants;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.socialize.utils.ContextUtil;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import master.flame.danmaku.danmaku.model.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class SocializeNetUtils {
    private static final String TAG = "SocializeNetUtils";

    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine + d.L);
                    }
                } catch (IOException e6) {
                    SLog.error(UmengText.NET.TOOL, e6);
                }
                try {
                    break;
                } catch (IOException e7) {
                }
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e72) {
                    SLog.error(UmengText.NET.TOOL, e72);
                }
            }
        }
        return sb.toString();
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                String[] split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                try {
                    bundle.putString(URLDecoder.decode(split[0], "UTF-8"), URLDecoder.decode(split[1], "UTF-8"));
                } catch (UnsupportedEncodingException e6) {
                    SLog.error(UmengText.NET.TOOL, e6);
                }
            }
        }
        return bundle;
    }

    public static boolean isConSpeCharacters(String str) {
        return str.replaceAll("[一-龥]*[a-z]*[A-Z]*\\d*-*_*\\s*", "").length() != 0;
    }

    public static boolean isSelfAppkey(String str) {
        return str.equals("5126ff896c738f2bfa000438") && !ContextUtil.getPackageName().equals("com.umeng.soexample");
    }

    public static Bundle parseUri(String str) {
        try {
            return decodeUrl(new URI(str).getQuery());
        } catch (Exception e6) {
            SLog.error(UmengText.NET.TOOL, e6);
            return new Bundle();
        }
    }

    public static Bundle parseUrl(String str) {
        try {
            URL url = new URL(str);
            Bundle decodeUrl = decodeUrl(url.getQuery());
            decodeUrl.putAll(decodeUrl(url.getRef()));
            return decodeUrl;
        } catch (MalformedURLException e6) {
            SLog.error(UmengText.NET.TOOL, e6);
            return new Bundle();
        }
    }

    public static String request(String str) {
        try {
            URLConnection openConnection = new URL(str).openConnection();
            if (openConnection != null) {
                openConnection.connect();
                InputStream inputStream = openConnection.getInputStream();
                if (inputStream != null) {
                    return convertStreamToString(inputStream);
                }
            }
            return "";
        } catch (Exception e6) {
            SLog.error(UmengText.NET.TOOL, e6);
            return "";
        }
    }

    public static boolean startWithHttp(String str) {
        return str.startsWith(JPushConstants.HTTP_PRE) || str.startsWith(JPushConstants.HTTPS_PRE);
    }

    /* JADX WARN: Code restructure failed: missing block: B:52:0x00b2, code lost:
    
        if (r0 != null) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00b4, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00b8, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b9, code lost:
    
        com.umeng.socialize.utils.SLog.error(com.umeng.socialize.utils.UmengText.NET.CLOSE, r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00c7, code lost:
    
        if (r0 == null) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00dd, code lost:
    
        if (r0 != null) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00df, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x00e3, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00e4, code lost:
    
        com.umeng.socialize.utils.SLog.error(com.umeng.socialize.utils.UmengText.NET.CLOSE, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x00f2, code lost:
    
        if (r0 == null) goto L88;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00da A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.io.IOException, java.lang.Throwable] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] getNetData(java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.socialize.net.utils.SocializeNetUtils.getNetData(java.lang.String):byte[]");
    }
}
