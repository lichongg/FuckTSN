package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes6.dex */
public class ax {

    /* renamed from: a, reason: collision with root package name */
    private JSONObject f35748a;

    public String a(String str) {
        JSONObject jSONObject = this.f35748a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set b(int i6) {
        HashSet hashSet = new HashSet();
        if (i6 == 1) {
            hashSet.add("AudioTrack");
            hashSet.add("processrea");
            hashSet.add("RemitDatab");
            hashSet.add("BrowserBlo");
            hashSet.add("game_push");
            hashSet.add("Godzilla:I");
            hashSet.add("IndexedDB");
            hashSet.add("ScopeRetry");
            hashSet.add("RobustPatc");
            hashSet.add("FrescoIoBo");
            hashSet.add("key_config");
        }
        return hashSet;
    }

    public ax(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f35874g).intValue(), 1, 0, "");
                if (!TextUtils.isEmpty(pqr)) {
                    this.f35748a = new JSONObject(pqr);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public Set a(Context context, String str, int i6) {
        JSONObject jSONObject = this.f35748a;
        if (jSONObject == null) {
            return null;
        }
        try {
            String string = jSONObject.getString(str);
            Set a6 = a(i6);
            if (TextUtils.isEmpty(string) || string.length() <= 3) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            HashSet hashSet = new HashSet();
            for (int i7 = 0; i7 < jSONArray.length(); i7++) {
                String string2 = jSONArray.getString(i7);
                if (!string2.contains("azeroth") && !string2.contains("OkHttp") && !string2.contains("retrofit")) {
                    int i8 = 0;
                    while (string2.contains(" ")) {
                        string2 = string2.replace(" ", "");
                        i8++;
                        if (i8 > 200) {
                            break;
                        }
                    }
                    String replace = string2.replace(com.snail.antifake.deviceid.e.f37542d, "").replace("\t", "").replace("\u200b", "");
                    boolean startsWith = replace.startsWith(":");
                    String str2 = replace;
                    if (startsWith) {
                        str2 = replace.substring(1);
                    }
                    String substring = str2.length() > 10 ? str2.substring(0, 10) : str2;
                    if (str2.contains("ridge")) {
                        hashSet.add(str2);
                    }
                    String packageName = context.getPackageName();
                    if (!str2.contains(packageName) && !packageName.contains(str2) && !a6.contains(substring) && !b(i6).contains(substring)) {
                        hashSet.add(str2);
                    }
                }
            }
            if (hashSet.size() > 0) {
                return hashSet;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public Set a(int i6) {
        HashSet hashSet = new HashSet();
        if (i6 == 1) {
            hashSet.add("HeapTaskDa");
            hashSet.add("queued-wor");
            hashSet.add("JDWP");
            hashSet.add("dTi");
            hashSet.add("MessageHan");
            hashSet.add("MediaPrefe");
            hashSet.add("CleanupRef");
            hashSet.add("GeoLocatio");
            hashSet.add("securityai");
            hashSet.add("Connectivi");
            hashSet.add("PatchManag");
            hashSet.add("CronetInte");
            hashSet.add("AegonLogge");
            hashSet.add("Countly");
            hashSet.add("DownloadSt");
            hashSet.add("GoogleApiH");
            hashSet.add("PlatformSe");
            hashSet.add("MemoryInfr");
            hashSet.add("CronetLibr");
            hashSet.add("Dex2OatIni");
            hashSet.add("EncodeApiH");
            hashSet.add("CookieMons");
        }
        return hashSet;
    }
}
