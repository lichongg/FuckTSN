package xyz.adscope.amps.tool.test;

import android.content.Context;
import androidx.annotation.RequiresApi;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import xyz.adscope.amps.common.AMPSConstants;
import xyz.adscope.common.tool.LogUtil;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes9.dex */
public class FileUtils {
    @RequiresApi(api = 19)
    public static String getTestConfig(Context context) throws IOException {
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        InputStream inputStream;
        BufferedReader bufferedReader2;
        Exception e6;
        InputStream inputStream2;
        InputStream open;
        try {
            try {
                open = context.getAssets().open("amps_test_config_json_bz");
                try {
                    inputStreamReader = new InputStreamReader(open, StandardCharsets.UTF_8);
                } catch (Exception e7) {
                    bufferedReader2 = null;
                    e6 = e7;
                    inputStreamReader = null;
                    inputStream2 = open;
                } catch (Throwable th2) {
                    bufferedReader = null;
                    th = th2;
                    inputStreamReader = null;
                    inputStream = open;
                }
            } catch (Exception e8) {
                inputStreamReader = null;
                bufferedReader2 = null;
                e6 = e8;
                inputStream2 = null;
            } catch (Throwable th3) {
                inputStreamReader = null;
                bufferedReader = null;
                th = th3;
                inputStream = null;
            }
            try {
                bufferedReader2 = new BufferedReader(inputStreamReader);
            } catch (Exception e9) {
                bufferedReader2 = null;
                e6 = e9;
                inputStream2 = open;
            } catch (Throwable th4) {
                bufferedReader = null;
                th = th4;
                inputStream = open;
                if (inputStream != null) {
                    inputStream.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        break;
                    }
                    sb.append(readLine);
                }
                String sb2 = sb.toString();
                if (open != null) {
                    open.close();
                }
                inputStreamReader.close();
                bufferedReader2.close();
                return sb2;
            } catch (Exception e10) {
                e6 = e10;
                inputStream2 = open;
                LogUtil.e(AMPSConstants.AMPS_LOG_TAG, "getTestConfig error is = " + e6.getMessage());
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                if (inputStreamReader != null) {
                    inputStreamReader.close();
                }
                if (bufferedReader2 == null) {
                    return "";
                }
                bufferedReader2.close();
                return "";
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = context;
        }
    }
}
