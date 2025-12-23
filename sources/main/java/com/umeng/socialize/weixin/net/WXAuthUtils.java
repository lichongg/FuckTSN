package com.umeng.socialize.weixin.net;

import com.umeng.socialize.utils.SLog;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import master.flame.danmaku.danmaku.model.d;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class WXAuthUtils {
    public static String convertStreamToString(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        sb.append(readLine);
                        sb.append(d.L);
                    }
                } catch (IOException e6) {
                    SLog.error(e6);
                }
                try {
                    break;
                } catch (IOException e7) {
                }
            } finally {
                try {
                    inputStream.close();
                } catch (IOException e72) {
                    SLog.error(e72);
                }
            }
        }
        return sb.toString();
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
            SLog.error(e6);
            return "";
        }
    }
}
