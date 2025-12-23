package com.kwad.sdk.crash.report.upload;

import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import cn.jpush.android.api.JThirdPlatFormInterface;
import cn.jpush.android.local.JPushConstants;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.core.network.p;
import com.kwad.sdk.crash.utils.h;
import com.kwad.sdk.utils.w;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.net.g;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    private static void a(@NonNull File file, @NonNull String str, String str2, @NonNull Map<String, String> map, @NonNull a aVar) {
        DataInputStream dataInputStream;
        OutputStream outputStream;
        HttpURLConnection httpURLConnection;
        byte[] bytes;
        com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "uploadLogFile " + Thread.currentThread());
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        String uuid = UUID.randomUUID().toString();
        String name = file.getName();
        String str3 = JPushConstants.HTTPS_PRE + com.kwad.sdk.core.network.idc.a.HF().W("ulog", "ulog-sdk.gifshow.com") + "/rest/log/sdk/file/upload";
        int i6 = -1;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str3).openConnection();
            try {
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setConnectTimeout(5000);
                httpURLConnection.setReadTimeout(5000);
                httpURLConnection.setUseCaches(false);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("connection", "Keep-Alive");
                httpURLConnection.setRequestProperty("User-Agent", p.getUserAgent());
                httpURLConnection.setRequestProperty("Charset", "UTF-8");
                httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + uuid);
                httpURLConnection.setRequestProperty("Content-MD5", Base64.encodeToString(com.kwad.sdk.utils.a.gN(file.getPath()), 2));
                httpURLConnection.setRequestProperty("file-type", "." + w.getExtension(file.getName()));
                httpURLConnection.setRequestProperty("origin-name", name);
                httpURLConnection.setRequestProperty("Cookie", "did=" + str);
                httpURLConnection.connect();
                outputStream = httpURLConnection.getOutputStream();
                try {
                    for (String str4 : map.keySet()) {
                        outputStream.write(e(str4, map.get(str4), uuid));
                    }
                    bytes = ("\r\n--" + uuid + "--\r\n").getBytes();
                    StringBuilder sb = new StringBuilder();
                    sb.append("--");
                    sb.append(uuid);
                    sb.append(g.f50795q);
                    sb.append("Content-Disposition: form-data;name=\"file\";filename=\"" + name + "\"\r\n");
                    sb.append("Content-Type: application/octet-stream\r\n\r\n");
                    outputStream.write(sb.toString().getBytes());
                    dataInputStream = new DataInputStream(new FileInputStream(file));
                } catch (Exception e6) {
                    e = e6;
                    dataInputStream = null;
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = null;
                }
            } catch (Exception e7) {
                e = e7;
                dataInputStream = null;
                outputStream = null;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream = null;
                outputStream = null;
            }
        } catch (Exception e8) {
            e = e8;
            dataInputStream = null;
            outputStream = null;
        } catch (Throwable th3) {
            th = th3;
            dataInputStream = null;
            outputStream = null;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = dataInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else {
                    outputStream.write(bArr, 0, read);
                }
            }
            outputStream.write(g.f50795q.getBytes());
            outputStream.write(bytes);
            outputStream.flush();
            int responseCode = httpURLConnection.getResponseCode();
            cVar.code = responseCode;
            cVar.aEi = responseCode;
            if (responseCode == 200) {
                cVar.aEk = h.inputStream2String(httpURLConnection.getInputStream());
                try {
                    if (new JSONObject(cVar.aEk).optInt("result", -1) == 1) {
                        aVar.LY();
                    } else {
                        e eVar = e.aQK;
                        aVar.LX();
                    }
                } catch (JSONException unused) {
                    e eVar2 = e.aQL;
                    aVar.LX();
                }
                com.kwad.sdk.core.d.c.d("AnrAndNativeAdExceptionCollector", "response.body= " + cVar.aEk);
            } else {
                e eVar3 = e.aQJ;
                e.aQJ.zb();
                aVar.LX();
                com.kwad.sdk.core.network.idc.a HF = com.kwad.sdk.core.network.idc.a.HF();
                int i7 = cVar.code;
                if (i7 == 0) {
                    i7 = -1;
                }
                HF.a(str3, i7, (Throwable) null);
            }
            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection);
        } catch (Exception e9) {
            e = e9;
            httpURLConnection2 = httpURLConnection;
            try {
                e eVar4 = e.aQJ;
                e.getCause();
                aVar.LX();
                com.kwad.sdk.core.network.idc.a HF2 = com.kwad.sdk.core.network.idc.a.HF();
                int i8 = cVar.code;
                if (i8 != 0) {
                    i6 = i8;
                }
                HF2.a(str3, i6, e);
                com.kwad.sdk.core.d.c.printStackTrace(e);
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            } catch (Throwable th4) {
                th = th4;
                com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
                com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
                com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            httpURLConnection2 = httpURLConnection;
            com.kwad.sdk.crash.utils.b.closeQuietly(httpURLConnection2);
            com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
            com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
            throw th;
        }
        com.kwad.sdk.crash.utils.b.closeQuietly(dataInputStream);
        com.kwad.sdk.crash.utils.b.closeQuietly(outputStream);
    }

    private static byte[] e(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(str3);
        sb.append(g.f50795q);
        sb.append("Content-Disposition: form-data; name=\"" + str + "\"");
        sb.append(g.f50795q);
        sb.append("Content-Length: " + str2.length());
        sb.append(g.f50795q);
        sb.append(g.f50795q);
        sb.append(str2);
        sb.append(g.f50795q);
        return sb.toString().getBytes();
    }

    private static Map<String, String> a(f fVar) {
        HashMap hashMap = new HashMap();
        if (fVar != null) {
            if (!TextUtils.isEmpty(fVar.aQU)) {
                hashMap.put("uploadToken", fVar.aQU);
            }
            if (!TextUtils.isEmpty(fVar.aQR)) {
                hashMap.put(NotificationCompat.CATEGORY_SYSTEM, fVar.aQR);
            }
            if (!TextUtils.isEmpty(fVar.aQQ)) {
                hashMap.put("did", fVar.aQQ);
            }
            if (!TextUtils.isEmpty(fVar.aQP)) {
                hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_SID, fVar.aQP);
            }
            if (!TextUtils.isEmpty(fVar.aPl)) {
                hashMap.put("appver", fVar.aPl);
            }
            if (!TextUtils.isEmpty(fVar.mTaskId)) {
                hashMap.put("taskId", fVar.mTaskId);
            }
            if (!TextUtils.isEmpty(fVar.mToken)) {
                hashMap.put(JThirdPlatFormInterface.KEY_TOKEN, fVar.mToken);
            }
            if (!TextUtils.isEmpty(fVar.aQO)) {
                hashMap.put("uid", fVar.aQO);
            }
            if (!TextUtils.isEmpty(fVar.aQS)) {
                hashMap.put(MediationConstant.KEY_EXTRA_INFO, fVar.aQS);
            }
        }
        return hashMap;
    }

    public static void a(File file, f fVar, a aVar) {
        a(file, fVar.aQQ, fVar.mToken, a(fVar), aVar);
    }
}
