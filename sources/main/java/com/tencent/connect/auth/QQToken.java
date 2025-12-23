package com.tencent.connect.auth;

import android.annotation.TargetApi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.g;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.open.web.security.JniInterface;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QQToken {
    public static final int AUTH_QQ = 2;
    public static final int AUTH_QZONE = 3;
    public static final int AUTH_WEB = 1;

    /* renamed from: g, reason: collision with root package name */
    private static SharedPreferences f40248g;

    /* renamed from: a, reason: collision with root package name */
    private String f40249a;

    /* renamed from: b, reason: collision with root package name */
    private String f40250b;

    /* renamed from: c, reason: collision with root package name */
    private String f40251c;

    /* renamed from: d, reason: collision with root package name */
    private int f40252d = 1;

    /* renamed from: e, reason: collision with root package name */
    private long f40253e = -1;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.open.utils.a f40254f;

    @TargetApi(11)
    private static synchronized SharedPreferences a() {
        SharedPreferences sharedPreferences;
        synchronized (QQToken.class) {
            try {
                if (f40248g == null) {
                    f40248g = g.a().getSharedPreferences("token_info_file", 0);
                }
                sharedPreferences = f40248g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sharedPreferences;
    }

    @Deprecated
    private static String c(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_spkey";
    }

    public String getAccessToken() {
        return this.f40250b;
    }

    public String getAppId() {
        return this.f40249a;
    }

    public int getAuthSource() {
        return this.f40252d;
    }

    public long getExpireTimeInSecond() {
        return this.f40253e;
    }

    public String getOpenId() {
        return this.f40251c;
    }

    public String getOpenIdWithCache() {
        String openId = getOpenId();
        try {
            if (!TextUtils.isEmpty(openId)) {
                SLog.i("QQToken", "getOpenId from field openId = " + openId + " appId = " + this.f40249a);
                return openId;
            }
            JSONObject loadSession = loadSession(this.f40249a);
            if (loadSession != null) {
                openId = loadSession.getString("openid");
                if (!TextUtils.isEmpty(openId)) {
                    setOpenId(openId);
                }
            }
            SLog.i("QQToken", "getOpenId from Session openId = " + openId + " appId = " + this.f40249a);
            return openId;
        } catch (Exception e6) {
            SLog.i("QQToken", "getLocalOpenIdByAppId " + e6.toString());
            return openId;
        }
    }

    public boolean isSessionValid() {
        return this.f40250b != null && System.currentTimeMillis() < this.f40253e;
    }

    public JSONObject loadSession(String str) {
        try {
            if (this.f40254f == null) {
                this.f40254f = new com.tencent.open.utils.a(g.a());
            }
            return a(str, this.f40254f);
        } catch (Exception e6) {
            SLog.i("QQToken", "login loadSession" + e6.toString());
            return null;
        }
    }

    public boolean saveSession(JSONObject jSONObject) {
        try {
            if (this.f40254f == null) {
                this.f40254f = new com.tencent.open.utils.a(g.a());
            }
            return a(this.f40249a, jSONObject, this.f40254f);
        } catch (Exception e6) {
            SLog.i("QQToken", "login saveSession" + e6.toString());
            return false;
        }
    }

    public void setAccessToken(String str, String str2) throws NumberFormatException {
        this.f40250b = str;
        this.f40253e = 0L;
        if (str2 != null) {
            this.f40253e = System.currentTimeMillis() + (Long.parseLong(str2) * 1000);
        }
    }

    public void setAppId(String str) {
        this.f40249a = str;
    }

    public void setAuthSource(int i6) {
        this.f40252d = i6;
    }

    public void setOpenId(String str) {
        this.f40251c = str;
        com.tencent.open.b.b.a().a(str);
    }

    public QQToken(String str) {
        this.f40249a = str;
    }

    @Deprecated
    private static String b(String str) {
        return Base64.encodeToString(m.j(str), 2);
    }

    public void removeSession(String str) {
        SharedPreferences.Editor edit = a().edit();
        edit.remove(c(str));
        edit.remove(c(str));
        edit.remove(a(str));
        edit.apply();
        SLog.i("QQToken", "removeSession sucess");
    }

    private static synchronized JSONObject a(String str, com.tencent.open.utils.a aVar) {
        String b6;
        synchronized (QQToken.class) {
            if (g.a() == null) {
                SLog.i("QQToken", "loadJsonPreference context null");
                return null;
            }
            if (str == null) {
                SLog.i("QQToken", "loadJsonPreference prefKey is null");
                return null;
            }
            String string = a().getString(a(str), "");
            if (TextUtils.isEmpty(string)) {
                if (!JniInterface.isJniOk) {
                    k.a(AuthAgent.SECURE_LIB_FILE_NAME, AuthAgent.SECURE_LIB_NAME, 5);
                    JniInterface.loadSo();
                }
                if (!JniInterface.isJniOk) {
                    SLog.i("QQToken", "loadJsonPreference jni load fail SECURE_LIB_VERSION=5");
                    return null;
                }
                String c6 = c(str);
                String string2 = a().getString(c6, "");
                try {
                    if (TextUtils.isEmpty(string2)) {
                        String b7 = b(str);
                        String string3 = a().getString(b7, "");
                        try {
                            if (TextUtils.isEmpty(string3)) {
                                SLog.i("QQToken", "loadJsonPreference oldDesValue null");
                                return null;
                            }
                            try {
                                b6 = JniInterface.d1(string3);
                                if (TextUtils.isEmpty(b6)) {
                                    SLog.i("QQToken", "loadJsonPreference decodeResult d1 empty");
                                    return null;
                                }
                                a(str, new JSONObject(b6), aVar);
                            } catch (Exception e6) {
                                SLog.e("QQToken", "Catch Exception", e6);
                                return null;
                            }
                        } finally {
                            a().edit().remove(b7).apply();
                        }
                    } else {
                        try {
                            b6 = JniInterface.d2(string2);
                            a(str, new JSONObject(b6), aVar);
                        } catch (Exception e7) {
                            SLog.e("QQToken", "Catch Exception", e7);
                            return null;
                        }
                    }
                } finally {
                    a().edit().remove(c6).apply();
                }
            } else {
                b6 = aVar.b(string);
            }
            try {
                JSONObject jSONObject = new JSONObject(b6);
                SLog.i("QQToken", "loadJsonPreference sucess");
                return jSONObject;
            } catch (Exception e8) {
                SLog.i("QQToken", "loadJsonPreference decode " + e8.toString());
                return null;
            }
        }
    }

    private static synchronized boolean a(String str, JSONObject jSONObject, com.tencent.open.utils.a aVar) {
        synchronized (QQToken.class) {
            if (g.a() == null) {
                SLog.i("QQToken", "saveJsonPreference context null");
                return false;
            }
            if (str != null && jSONObject != null) {
                try {
                    String string = jSONObject.getString("expires_in");
                    if (!TextUtils.isEmpty(string)) {
                        jSONObject.put(Constants.PARAM_EXPIRES_TIME, System.currentTimeMillis() + (Long.parseLong(string) * 1000));
                        String a6 = a(str);
                        String a7 = aVar.a(jSONObject.toString());
                        if (a6.length() > 6 && a7 != null) {
                            a().edit().putString(a6, a7).commit();
                            SLog.i("QQToken", "saveJsonPreference sucess");
                            return true;
                        }
                        SLog.i("QQToken", "saveJsonPreference keyEncode or josnEncode null");
                        return false;
                    }
                    SLog.i("QQToken", "expires is null");
                    return false;
                } catch (Exception e6) {
                    SLog.e("QQToken", "saveJsonPreference exception:" + e6.toString());
                    return false;
                }
            }
            SLog.i("QQToken", "saveJsonPreference prefKey or jsonObject null");
            return false;
        }
    }

    private static String a(String str) {
        return Base64.encodeToString(m.j(str), 2) + "_aes_google";
    }
}
