package com.bytedance.msdk.core.admanager;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.SplashAd;
import com.bytedance.msdk.j.j.r;
import com.bytedance.msdk.j.up.cw;
import com.bytedance.msdk.m.xt.xt;
import com.bytedance.sdk.component.utils.vl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes3.dex */
public class j {
    private static final ArrayList<String> cw;

    /* renamed from: j, reason: collision with root package name */
    private static final ArrayList<C0349j> f24411j = new ArrayList<>();

    /* renamed from: r, reason: collision with root package name */
    private static final ArrayList<String> f24412r;
    private static final String[] xt;

    private static int cw(String str, String str2) {
        String substring = str2.substring(2);
        if (str.startsWith("v") || str.startsWith(ExifInterface.GPS_MEASUREMENT_INTERRUPTED)) {
            str = str.substring(1);
        }
        return str.compareTo(substring);
    }

    public static boolean j(String str, int i6, int i7) {
        ArrayList<C0349j> arrayList = f24411j;
        if (arrayList.size() <= 0) {
            return TextUtils.equals("baidu", str);
        }
        Iterator<C0349j> it = arrayList.iterator();
        while (it.hasNext()) {
            C0349j next = it.next();
            if (next != null && TextUtils.equals(next.f24413j, str) && i7 == next.xt) {
                String str2 = next.cw;
                r j6 = xt.j().j(str);
                String xt2 = j6 != null ? j6.xt() : null;
                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(xt2)) {
                    if (str2.startsWith("<=")) {
                        return j(xt2, str2);
                    }
                    if (str2.startsWith(">=")) {
                        return xt(xt2, str2);
                    }
                }
            }
        }
        return false;
    }

    private static boolean xt(String str, String str2) {
        return cw(str, str2) >= 0;
    }

    /* renamed from: com.bytedance.msdk.core.admanager.j$j, reason: collision with other inner class name */
    private static class C0349j {
        String cw;

        /* renamed from: j, reason: collision with root package name */
        String f24413j;
        int xt;

        C0349j(String str, int i6, String str2) {
            this.f24413j = str;
            this.xt = i6;
            this.cw = str2;
        }
    }

    static {
        String[] strArr = {"TTTransparentActivity", "openadsdk", "com.bykv", "com.qq", "com.kwad", "baidu", "mbridge", MediationConstant.ADN_SIGMOB, MediationConstant.ADN_UNITY, MediationConstant.ADN_KLEVIN};
        xt = strArr;
        cw = new ArrayList<>(Arrays.asList(strArr));
        f24412r = new ArrayList<>();
    }

    public static boolean xt(String str) {
        cw.xt(MediationConstant.TAG, "--==--- activityStr: ".concat(String.valueOf(str)));
        Iterator<String> it = cw.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return cw(str);
            }
        }
        return false;
    }

    private static boolean cw(String str) {
        ArrayList<String> arrayList = f24412r;
        if (arrayList.size() == 0) {
            return true;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    private static boolean j(String str, String str2) {
        return cw(str, str2) <= 0;
    }

    public static void j(String str) {
        ArrayList<String> arrayList;
        List asList;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                cw.clear();
                JSONArray optJSONArray = jSONObject.optJSONArray("act_str");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    for (int i6 = 0; i6 < optJSONArray.length(); i6++) {
                        String optString = optJSONArray.optString(i6);
                        if (!TextUtils.isEmpty(optString)) {
                            cw.add(optString);
                        }
                    }
                }
                f24412r.clear();
                JSONArray optJSONArray2 = jSONObject.optJSONArray("not_act_str");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    for (int i7 = 0; i7 < optJSONArray2.length(); i7++) {
                        String optString2 = optJSONArray2.optString(i7);
                        if (!TextUtils.isEmpty(optString2)) {
                            f24412r.add(optString2);
                        }
                    }
                }
                f24411j.clear();
                JSONArray optJSONArray3 = jSONObject.optJSONArray("not_support");
                if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                    for (int i8 = 0; i8 < optJSONArray3.length(); i8++) {
                        JSONObject optJSONObject = optJSONArray3.optJSONObject(i8);
                        if (optJSONObject != null) {
                            f24411j.add(new C0349j(optJSONObject.optString(SplashAd.KEY_BIDFAIL_ADN), optJSONObject.optInt("subtype"), optJSONObject.optString("versions")));
                        }
                    }
                }
                arrayList = cw;
                asList = Arrays.asList(xt);
            } catch (JSONException e6) {
                vl.j(e6);
                arrayList = cw;
                asList = Arrays.asList(xt);
            }
            arrayList.addAll(asList);
        } catch (Throwable th) {
            cw.addAll(Arrays.asList(xt));
            throw th;
        }
    }
}
