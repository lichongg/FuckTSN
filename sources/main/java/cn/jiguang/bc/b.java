package cn.jiguang.bc;

import android.content.Context;
import cn.jiguang.bb.f;
import cn.jiguang.bz.y;
import cn.jiguang.net.HttpRequest;
import cn.jiguang.net.HttpResponse;
import cn.jiguang.net.HttpUtils;
import com.kuaishou.weapon.p0.t;
import java.io.File;
import java.io.RandomAccessFile;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    public static boolean a(Context context, String str, File file) {
        byte[] bArr;
        RandomAccessFile randomAccessFile;
        HttpResponse httpResponse;
        int responseCode;
        f.c("UploadLogUtils", "url is : " + str + "\n fileName is : " + file.getName());
        RandomAccessFile randomAccessFile2 = null;
        try {
            bArr = new byte[(int) file.length()];
            randomAccessFile = new RandomAccessFile(file, t.f36150k);
        } catch (Throwable th) {
            th = th;
        }
        try {
            randomAccessFile.read(bArr);
            HttpRequest httpRequest = new HttpRequest(str);
            httpRequest.setRequestProperty("Connection", "Keep-Alive");
            httpRequest.setRequestProperty("Content-Type", "multipart/form-data");
            httpRequest.setUseCaches(false);
            httpRequest.setHaveRspData(true);
            httpRequest.setDoInPut(true);
            httpRequest.setDoOutPut(true);
            httpRequest.setBody(bArr);
            httpResponse = HttpUtils.httpResponse(context, httpRequest, false, true);
            responseCode = httpResponse.getResponseCode();
            f.c("UploadLogUtils", "response code is " + responseCode + ", response message is " + httpResponse.toString());
        } catch (Throwable th2) {
            th = th2;
            randomAccessFile2 = randomAccessFile;
            try {
                f.c("UploadLogUtils", "error message is : " + th.getMessage());
                return false;
            } finally {
                y.a(randomAccessFile2);
            }
        }
        if (responseCode == 200) {
            y.a(randomAccessFile);
            return true;
        }
        String responseBody = httpResponse.getResponseBody();
        cn.jiguang.bb.b.a(context, false, "", responseBody);
        f.c("UploadLogUtils", "error response is : " + responseBody);
        y.a(randomAccessFile);
        return false;
    }
}
