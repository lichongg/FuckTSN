package com.umeng.socialize.tracker;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.socialize.tracker.utils.HttpRequestListener;
import com.umeng.socialize.tracker.utils.b;
import com.umeng.socialize.tracker.utils.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private static final String f42493a = "TrackerManagerImpl";

    /* renamed from: b, reason: collision with root package name */
    private static final int f42494b = 3000;

    /* renamed from: c, reason: collision with root package name */
    private static final String f42495c = "_$";

    /* renamed from: d, reason: collision with root package name */
    private static final int f42496d = 16;

    /* renamed from: e, reason: collision with root package name */
    private static final int f42497e = 64;

    /* renamed from: f, reason: collision with root package name */
    private static final String f42498f = "自定义属性名长度不能超过16个字符。";

    /* renamed from: g, reason: collision with root package name */
    private static final String f42499g = "自定义属性值长度不能超过64个字符。";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f42505a = new b();

        private a() {
        }
    }

    private b() {
    }

    public static b a() {
        return a.f42505a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return "错误详情 [" + (jSONObject.has("code") ? jSONObject.optInt("code") : 0) + "]: " + (jSONObject.has("msg") ? jSONObject.optString("msg") : "");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str) {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has(com.umeng.socialize.tracker.a.f42491l)) {
                return optJSONObject.optString(com.umeng.socialize.tracker.a.f42491l);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (Throwable unused) {
        }
        return (jSONObject.has("code") ? jSONObject.getInt("code") : 0) == 200;
    }

    public void a(Context context, String str, String str2, String str3, String str4, Map<String, String> map, final int i6, final TrackerResultHandler trackerResultHandler) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (String str5 : map.keySet()) {
                String str6 = map.get(str5);
                if (!TextUtils.isEmpty(str5) && str5.length() <= 16 && !TextUtils.isEmpty(str6) && str6.length() <= 64) {
                    hashMap.put(str5, str6);
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            for (String str7 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str7)) {
                    jSONObject3.put(str7, hashMap.get(str7));
                }
            }
            jSONObject2.put(com.umeng.socialize.tracker.a.f42483d, str);
            jSONObject2.put(com.umeng.socialize.tracker.a.f42484e, str2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put(com.umeng.socialize.tracker.a.f42486g, str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put(com.umeng.socialize.tracker.a.f42485f, str3);
            } else {
                jSONObject2.put(com.umeng.socialize.tracker.a.f42485f, (Object) null);
            }
            jSONObject.put(com.umeng.socialize.tracker.a.f42482c, jSONObject2);
            jSONObject.put(com.umeng.socialize.tracker.a.f42487h, jSONObject3);
            final String jSONObject4 = jSONObject.toString();
            context.getApplicationContext();
            c.a(new Runnable() { // from class: com.umeng.socialize.tracker.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String str8 = jSONObject4;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("Content-Type", "application/json");
                    com.umeng.socialize.tracker.utils.b bVar = new com.umeng.socialize.tracker.utils.b(com.umeng.socialize.tracker.a.f42480a, b.a.POST, hashMap2, new HttpRequestListener() { // from class: com.umeng.socialize.tracker.b.1.1
                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        public void a() {
                        }

                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        public void a(String str9) {
                            if (TextUtils.isEmpty(str9)) {
                                trackerResultHandler.codeGenerateFailed(new Throwable(com.umeng.socialize.tracker.utils.a.EmptyResponse.a()));
                                return;
                            }
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> utc:onRequestSuccess: " + str9);
                            if (b.f(str9)) {
                                String e6 = b.e(str9);
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> utc:success:rootTrackCode: " + e6);
                                trackerResultHandler.codeGenerateSuccess(e6);
                                return;
                            }
                            String d6 = b.d(str9);
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> utc:failed:error: " + d6);
                            trackerResultHandler.codeGenerateFailed(new Throwable(d6));
                        }

                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        public void a(Throwable th) {
                            trackerResultHandler.codeGenerateFailed(th);
                        }
                    });
                    int i7 = i6;
                    bVar.a((i7 <= 0 || i7 > 10) ? 3000 : i7 * 1000, str8);
                }
            });
        } catch (Throwable unused) {
            trackerResultHandler.codeGenerateFailed(new Throwable(com.umeng.socialize.tracker.utils.a.ErrorMakeRequestBody.a()));
        }
    }
}
