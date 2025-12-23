package com.tencent.open.utils;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import com.stub.StubApp;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private static Map<String, i> f40656a = Collections.synchronizedMap(new HashMap());

    /* renamed from: b, reason: collision with root package name */
    private static String f40657b = null;

    /* renamed from: c, reason: collision with root package name */
    private Context f40658c;

    /* renamed from: d, reason: collision with root package name */
    private String f40659d;

    /* renamed from: e, reason: collision with root package name */
    private JSONObject f40660e = null;

    /* renamed from: f, reason: collision with root package name */
    private long f40661f = 0;

    /* renamed from: g, reason: collision with root package name */
    private int f40662g = 0;

    /* renamed from: h, reason: collision with root package name */
    private boolean f40663h = true;

    private void b() {
        if (this.f40662g != 0) {
            d("update thread is running, return");
            return;
        }
        this.f40662g = 1;
        final HashMap hashMap = new HashMap();
        hashMap.put("appid", this.f40659d);
        hashMap.put("status_os", Build.VERSION.RELEASE);
        hashMap.put("status_machine", f.a().c(g.a()));
        hashMap.put("status_version", Build.VERSION.SDK);
        hashMap.put(SocializeProtocolConstants.PROTOCOL_KEY_VERSION, Constants.SDK_VERSION);
        hashMap.put("sdkp", "a");
        l.a(new Runnable() { // from class: com.tencent.open.utils.i.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    com.tencent.open.a.g a6 = com.tencent.open.a.f.a().a("https://cgi.connect.qq.com/qqconnectopen/openapi/policy_conf", hashMap);
                    String a7 = a6.a();
                    SLog.i("openSDK_LOG.OpenConfig", "update: get config statusCode " + a6.d());
                    i.this.a(m.d(a7));
                } catch (Exception e6) {
                    SLog.e("openSDK_LOG.OpenConfig", "get config error ", e6);
                }
                i.this.f40662g = 0;
            }
        });
    }

    private String c(String str) {
        InputStream open;
        String str2;
        String str3 = "";
        try {
            try {
                if (this.f40659d != null) {
                    str2 = str + "." + this.f40659d;
                } else {
                    str2 = str;
                }
                open = this.f40658c.openFileInput(str2);
            } catch (FileNotFoundException unused) {
                open = this.f40658c.getAssets().open(str);
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open, Charset.forName("UTF-8")));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                try {
                    try {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            stringBuffer.append(readLine);
                        } catch (Throwable th) {
                            try {
                                open.close();
                                bufferedReader.close();
                            } catch (IOException e6) {
                                e6.printStackTrace();
                            }
                            throw th;
                        }
                    } catch (IOException e7) {
                        e7.printStackTrace();
                        open.close();
                    }
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            str3 = stringBuffer.toString();
            open.close();
            bufferedReader.close();
            return str3;
        } catch (IOException e9) {
            e9.printStackTrace();
            return "";
        }
    }

    private void d(String str) {
        if (this.f40663h) {
            SLog.v("openSDK_LOG.OpenConfig", str + "; appid: " + this.f40659d);
        }
    }

    private i(Context context, String str) {
        this.f40658c = null;
        this.f40659d = null;
        this.f40658c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f40659d = str;
        a();
        b();
    }

    public static i a(Context context, String str) {
        i iVar;
        synchronized (f40656a) {
            try {
                SLog.v("openSDK_LOG.OpenConfig", "getInstance begin");
                if (str != null) {
                    f40657b = str;
                }
                if (str == null && (str = f40657b) == null) {
                    str = "0";
                }
                iVar = f40656a.get(str);
                if (iVar == null) {
                    iVar = new i(context, str);
                    f40656a.put(str, iVar);
                }
                SLog.v("openSDK_LOG.OpenConfig", "getInstance end");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iVar;
    }

    public boolean b(String str) {
        d("get " + str);
        c();
        Object opt = this.f40660e.opt(str);
        if (opt == null) {
            return false;
        }
        if (opt instanceof Integer) {
            return !opt.equals(0);
        }
        if (opt instanceof Boolean) {
            return ((Boolean) opt).booleanValue();
        }
        return false;
    }

    private void a() {
        try {
            this.f40660e = new JSONObject(c("com.tencent.open.config.json"));
        } catch (JSONException unused) {
            this.f40660e = new JSONObject();
        }
    }

    private void a(String str, String str2) {
        try {
            if (this.f40659d != null) {
                str = str + "." + this.f40659d;
            }
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f40658c.openFileOutput(str, 0), Charset.forName("UTF-8"));
            outputStreamWriter.write(str2);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e6) {
            e6.printStackTrace();
        }
    }

    private void c() {
        int optInt = this.f40660e.optInt("Common_frequency");
        if (optInt == 0) {
            optInt = 1;
        }
        if (SystemClock.elapsedRealtime() - this.f40661f >= optInt * 3600000) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        d("cgi back, do update");
        this.f40660e = jSONObject;
        a("com.tencent.open.config.json", jSONObject.toString());
        this.f40661f = SystemClock.elapsedRealtime();
    }

    public int a(String str) {
        d("get " + str);
        c();
        return this.f40660e.optInt(str);
    }
}
