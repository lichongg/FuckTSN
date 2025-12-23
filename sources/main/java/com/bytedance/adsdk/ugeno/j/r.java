package com.bytedance.adsdk.ugeno.j;

import android.text.TextUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.baidu.mobads.sdk.api.PrerollVideoResponse;
import com.bytedance.adsdk.ugeno.j.cw;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class r {
    public static float[] cw(String str) {
        float[] fArr = {0.0f, 0.0f};
        JSONArray j6 = com.bytedance.adsdk.ugeno.m.xt.j(str, (JSONArray) null);
        if (j6 != null && j6.length() == 2) {
            fArr[0] = (float) j6.optDouble(0);
            fArr[1] = (float) j6.optDouble(1);
        }
        return fArr;
    }

    public static int j(int i6) {
        if (i6 < 0) {
            return -1;
        }
        if (i6 == 0) {
            return 1;
        }
        return i6 - 1;
    }

    public static List<cw> j(String str, JSONObject jSONObject) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() <= 0) {
                return null;
            }
            for (int i6 = 0; i6 < jSONArray.length(); i6++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i6);
                if (optJSONObject != null) {
                    arrayList.add(j(optJSONObject, jSONObject));
                }
            }
            return arrayList;
        } catch (JSONException e6) {
            throw new RuntimeException(e6);
        }
    }

    public static cw.j r(String str) {
        JSONArray j6;
        if (TextUtils.isEmpty(str) || (j6 = com.bytedance.adsdk.ugeno.m.xt.j(str, (JSONArray) null)) == null || j6.length() != 2) {
            return null;
        }
        cw.j jVar = new cw.j();
        jVar.f23672j = j6.optString(0);
        jVar.xt = j6.optString(1);
        return jVar;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    public static Interpolator xt(String str) {
        switch (str.hashCode()) {
            case -1965072618:
                if (str.equals("ease_in")) {
                    return new AccelerateInterpolator();
                }
                break;
            case -1102672091:
                str.equals("linear");
                break;
            case -787702915:
                if (str.equals("ease_out")) {
                    return new DecelerateInterpolator();
                }
                break;
            case 1065009829:
                if (str.equals("ease_in_out")) {
                    return new AccelerateDecelerateInterpolator();
                }
                break;
        }
        return new LinearInterpolator();
    }

    public static cw j(JSONObject jSONObject, JSONObject jSONObject2) {
        if (jSONObject == null) {
            return null;
        }
        cw cwVar = new cw();
        cwVar.xt(com.bytedance.adsdk.ugeno.m.cw.j(com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("delay"), jSONObject2), 0L));
        cwVar.cw(com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString(CommonNetImpl.NAME), jSONObject2));
        cwVar.xt(com.bytedance.adsdk.ugeno.m.cw.j(com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("playState"), jSONObject2), 1));
        cwVar.j(com.bytedance.adsdk.ugeno.m.cw.j(com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("duration"), jSONObject2), 0L));
        cwVar.j(com.bytedance.adsdk.ugeno.m.cw.j(com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("playCount"), jSONObject2), 1));
        cwVar.j(com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("playDirection"), jSONObject2));
        cwVar.j(r(jSONObject.optString("transformOrigin")));
        cwVar.xt(com.bytedance.adsdk.ugeno.r.xt.j(jSONObject.optString("timingFunction", "linear"), jSONObject2));
        cwVar.j(jSONObject.optJSONObject("effect"));
        cwVar.j(j(jSONObject.optJSONArray("keyframes"), jSONObject2));
        return cwVar;
    }

    public static Map<String, TreeMap<Float, String>> j(JSONArray jSONArray, JSONObject jSONObject) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        HashMap hashMap = new HashMap();
        for (int i6 = 0; i6 < jSONArray.length(); i6++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i6);
            if (optJSONObject != null) {
                float optDouble = (float) optJSONObject.optDouble(IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET);
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    TreeMap treeMap = (TreeMap) hashMap.get(next);
                    if (!TextUtils.equals(next, IjkMediaPlayer.OnNativeInvokeListener.ARG_OFFSET)) {
                        if (hashMap.containsKey(next) && treeMap != null) {
                            treeMap.put(Float.valueOf(optDouble), com.bytedance.adsdk.ugeno.r.xt.j(optJSONObject.optString(next), jSONObject));
                        } else {
                            TreeMap treeMap2 = new TreeMap();
                            treeMap2.put(Float.valueOf(optDouble), com.bytedance.adsdk.ugeno.r.xt.j(optJSONObject.optString(next), jSONObject));
                            hashMap.put(next, treeMap2);
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static int j(String str) {
        int hashCode = str.hashCode();
        if (hashCode == -1408024454) {
            return str.equals("alternate") ? 2 : 1;
        }
        if (hashCode != -1039745817) {
            return 1;
        }
        str.equals(PrerollVideoResponse.NORMAL);
        return 1;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static int j(String str, int i6) {
        int i7 = i6 / 2;
        if (!TextUtils.isEmpty(str)) {
            str.getClass();
            switch (str) {
                case "bottom":
                case "right":
                    return i6;
                case "center":
                    break;
                case "top":
                case "left":
                    return 0;
                default:
                    if (str.endsWith("%")) {
                        try {
                            return (int) ((i6 * Float.parseFloat(str.substring(0, str.length() - 1))) / 100.0f);
                        } catch (NumberFormatException unused) {
                            break;
                        }
                    } else {
                        try {
                            return Integer.parseInt(str);
                        } catch (NumberFormatException unused2) {
                            return i7;
                        }
                    }
            }
        }
        return i7;
    }
}
