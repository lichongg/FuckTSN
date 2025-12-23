package com.bytedance.adsdk.lottie.r;

import android.graphics.Rect;
import android.util.JsonReader;
import android.util.JsonToken;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.g;
import com.bytedance.adsdk.lottie.m;
import com.bytedance.adsdk.lottie.model.layer.tl;
import com.kuaishou.weapon.p0.t;
import com.kwad.components.offline.api.tk.model.report.TKDownloadReason;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class v {
    public static com.bytedance.adsdk.lottie.m j(JsonReader jsonReader) throws IOException {
        int i6;
        SparseArray<com.bytedance.adsdk.lottie.model.r> sparseArray;
        HashMap hashMap;
        float j6 = com.bytedance.adsdk.lottie.up.g.j();
        LongSparseArray<com.bytedance.adsdk.lottie.model.layer.tl> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap hashMap2 = new HashMap();
        HashMap hashMap3 = new HashMap();
        HashMap hashMap4 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArray<com.bytedance.adsdk.lottie.model.r> sparseArray2 = new SparseArray<>();
        m.r rVar = new m.r();
        m.xt xtVar = new m.xt();
        m.cw cwVar = new m.cw();
        m.j jVar = new m.j();
        com.bytedance.adsdk.lottie.m mVar = new com.bytedance.adsdk.lottie.m();
        jsonReader.beginObject();
        String str = null;
        int i7 = 0;
        int i8 = 0;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        while (jsonReader.hasNext()) {
            float f9 = f6;
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c6 = 65535;
            switch (nextName.hashCode()) {
                case -1408207997:
                    i6 = i7;
                    if (nextName.equals("assets")) {
                        c6 = 0;
                        break;
                    }
                    break;
                case -1109732030:
                    i6 = i7;
                    if (nextName.equals(RtspHeaders.Values.LAYERS)) {
                        c6 = 1;
                        break;
                    }
                    break;
                case -865448777:
                    i6 = i7;
                    if (nextName.equals("globalEvent")) {
                        c6 = 2;
                        break;
                    }
                    break;
                case 104:
                    i6 = i7;
                    if (nextName.equals("h")) {
                        c6 = 3;
                        break;
                    }
                    break;
                case 118:
                    i6 = i7;
                    if (nextName.equals("v")) {
                        c6 = 4;
                        break;
                    }
                    break;
                case 119:
                    i6 = i7;
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c6 = 5;
                        break;
                    }
                    break;
                case 3208:
                    i6 = i7;
                    if (nextName.equals("dl")) {
                        c6 = 6;
                        break;
                    }
                    break;
                case 3276:
                    i6 = i7;
                    if (nextName.equals(SocializeProtocolConstants.PROTOCOL_KEY_FR)) {
                        c6 = 7;
                        break;
                    }
                    break;
                case 3292:
                    i6 = i7;
                    if (nextName.equals("gc")) {
                        c6 = '\b';
                        break;
                    }
                    break;
                case 3367:
                    i6 = i7;
                    if (nextName.equals(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP)) {
                        c6 = '\t';
                        break;
                    }
                    break;
                case 3553:
                    i6 = i7;
                    if (nextName.equals("op")) {
                        c6 = '\n';
                        break;
                    }
                    break;
                case 3002509:
                    i6 = i7;
                    if (nextName.equals("area")) {
                        c6 = 11;
                        break;
                    }
                    break;
                case 94623709:
                    i6 = i7;
                    if (nextName.equals("chars")) {
                        c6 = '\f';
                        break;
                    }
                    break;
                case 97615364:
                    i6 = i7;
                    if (nextName.equals("fonts")) {
                        c6 = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 110364485:
                    i6 = i7;
                    if (nextName.equals("timer")) {
                        c6 = 14;
                        break;
                    }
                    break;
                case 839250809:
                    i6 = i7;
                    if (nextName.equals("markers")) {
                        c6 = 15;
                        break;
                    }
                    break;
                default:
                    i6 = i7;
                    break;
            }
            switch (c6) {
                case 0:
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    j(jsonReader, mVar, hashMap2, hashMap3);
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case 1:
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    j(jsonReader, mVar, arrayList, longSparseArray);
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case 2:
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    j(jsonReader, cwVar);
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case 3:
                    i7 = jsonReader.nextInt();
                    sparseArray2 = sparseArray2;
                    f6 = f9;
                    break;
                case 4:
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    String[] split = jsonReader.nextString().split("\\.");
                    if (!com.bytedance.adsdk.lottie.up.g.j(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]), 4, 4, 0)) {
                        mVar.j("Lottie only supports bodymovin >= 4.4.0");
                    }
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case 5:
                    i8 = jsonReader.nextInt();
                    f6 = f9;
                    i7 = i6;
                    break;
                case 6:
                    str = jsonReader.nextString();
                    f6 = f9;
                    i7 = i6;
                    break;
                case 7:
                    sparseArray = sparseArray2;
                    hashMap4 = hashMap4;
                    f8 = (float) jsonReader.nextDouble();
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case '\b':
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    j(jsonReader, xtVar);
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case '\t':
                    sparseArray = sparseArray2;
                    hashMap4 = hashMap4;
                    f7 = (float) jsonReader.nextDouble();
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case '\n':
                    f6 = ((float) jsonReader.nextDouble()) - 0.01f;
                    sparseArray2 = sparseArray2;
                    hashMap4 = hashMap4;
                    i7 = i6;
                    break;
                case 11:
                    j(jsonReader, jVar);
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case '\f':
                    j(jsonReader, mVar, sparseArray2);
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case '\r':
                    j(jsonReader, hashMap4);
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case 14:
                    j(jsonReader, rVar);
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                case 15:
                    j(jsonReader, arrayList2);
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
                default:
                    jsonReader.skipValue();
                    sparseArray = sparseArray2;
                    hashMap = hashMap4;
                    hashMap4 = hashMap;
                    sparseArray2 = sparseArray;
                    f6 = f9;
                    i7 = i6;
                    break;
            }
        }
        jsonReader.endObject();
        Rect rect = new Rect(0, 0, (int) (i8 * j6), (int) (i7 * j6));
        float f10 = f7;
        mVar.j(rect, f10, f6, f8, arrayList, longSparseArray, hashMap2, hashMap3, sparseArray2, hashMap4, arrayList2, rVar, str, xtVar, cwVar, jVar);
        return mVar;
    }

    private static void xt(JsonReader jsonReader, m.xt xtVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode != 3239) {
                    if (hashCode != 3276) {
                        if (hashCode == 107027 && nextName.equals("lel")) {
                            xtVar.ae = cw(jsonReader);
                        }
                        jsonReader.skipValue();
                    } else if (nextName.equals(SocializeProtocolConstants.PROTOCOL_KEY_FR)) {
                        xtVar.up = jsonReader.nextInt();
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (nextName.equals(t.f36153n)) {
                    xtVar.f23348m = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (IOException e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private static JSONArray cw(JsonReader jsonReader) {
        JSONArray jSONArray = new JSONArray();
        try {
            jsonReader.beginArray();
            while (jsonReader.hasNext()) {
                JSONObject jSONObject = new JSONObject();
                jSONArray.put(jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    int hashCode = nextName.hashCode();
                    if (hashCode != 3324) {
                        if (hashCode == 116753 && nextName.equals("vid")) {
                            try {
                                jSONObject.put("vid", jsonReader.nextString());
                            } catch (JSONException e6) {
                                com.bytedance.sdk.component.utils.vl.j(e6);
                            }
                        }
                        jsonReader.skipValue();
                    } else if (nextName.equals(LiveConfigKey.HIGH)) {
                        try {
                            jSONObject.put(LiveConfigKey.HIGH, jsonReader.nextInt());
                        } catch (JSONException e7) {
                            com.bytedance.sdk.component.utils.vl.j(e7);
                        }
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
            }
            jsonReader.endArray();
        } catch (Exception e8) {
            com.bytedance.sdk.component.utils.vl.j(e8);
        }
        return jSONArray;
    }

    private static List<g.xt> r(JsonReader jsonReader) {
        try {
            ArrayList arrayList = new ArrayList();
            while (jsonReader.hasNext()) {
                g.xt xtVar = new g.xt();
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName = jsonReader.nextName();
                    int hashCode = nextName.hashCode();
                    if (hashCode != 99) {
                        if (hashCode != 102) {
                            if (hashCode != 108) {
                                if (hashCode != 115) {
                                    if (hashCode != 3153) {
                                        if (hashCode != 3449) {
                                            if (hashCode != 96670) {
                                                if (hashCode != 101199) {
                                                    if (hashCode == 3029637 && nextName.equals("bold")) {
                                                        xtVar.ae = jsonReader.nextInt();
                                                    }
                                                    jsonReader.skipValue();
                                                } else if (nextName.equals("fcl")) {
                                                    xtVar.cw = jsonReader.nextString();
                                                } else {
                                                    jsonReader.skipValue();
                                                }
                                            } else if (nextName.equals("ali")) {
                                                xtVar.f23231g = jsonReader.nextString();
                                            } else {
                                                jsonReader.skipValue();
                                            }
                                        } else if (nextName.equals("le")) {
                                            xtVar.xt = jsonReader.nextInt();
                                        } else {
                                            jsonReader.skipValue();
                                        }
                                    } else if (nextName.equals("bs")) {
                                        xtVar.tl = jsonReader.nextInt();
                                    } else {
                                        jsonReader.skipValue();
                                    }
                                } else if (nextName.equals("s")) {
                                    xtVar.f23233m = jsonReader.nextInt();
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else if (nextName.equals(t.f36143d)) {
                                xtVar.f23232j = jsonReader.nextInt();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if (nextName.equals("f")) {
                            xtVar.up = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (nextName.equals("c")) {
                        xtVar.f23234r = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                }
                jsonReader.endObject();
                arrayList.add(xtVar);
            }
            return arrayList;
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
            return null;
        }
    }

    private static Map<String, Object> xt(JsonReader jsonReader) throws IOException {
        HashMap hashMap = new HashMap();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (nextName.equals("lel")) {
                hashMap.put("lel", cw(jsonReader));
            } else if (!nextName.equals("lottie_back")) {
                jsonReader.skipValue();
            } else {
                JSONObject jSONObject = new JSONObject();
                hashMap.put("lottie_back", jSONObject);
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String nextName2 = jsonReader.nextName();
                    nextName2.getClass();
                    if (!nextName2.equals(LiveConfigKey.HIGH)) {
                        jsonReader.skipValue();
                    } else {
                        try {
                            jSONObject.putOpt(LiveConfigKey.HIGH, Integer.valueOf(jsonReader.nextInt()));
                            jSONObject.putOpt("vid", "lottie_back");
                        } catch (JSONException e6) {
                            com.bytedance.sdk.component.utils.vl.j(e6);
                        }
                    }
                }
                jsonReader.endObject();
            }
        }
        jsonReader.endObject();
        Object remove = hashMap.remove("lottie_back");
        if (remove instanceof JSONObject) {
            Object obj = hashMap.get("lel");
            if (obj instanceof JSONArray) {
                ((JSONArray) obj).put(remove);
            } else {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(remove);
                hashMap.put("lel", jSONArray);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    private static void j(JsonReader jsonReader, m.j jVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode != 104) {
                    switch (hashCode) {
                        case 119:
                            if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                                jVar.cw = jsonReader.nextString();
                                break;
                            } else {
                                jsonReader.skipValue();
                                break;
                            }
                        case 120:
                            if (nextName.equals("x")) {
                                jVar.f23333j = jsonReader.nextString();
                                break;
                            } else {
                                jsonReader.skipValue();
                                break;
                            }
                        case 121:
                            if (nextName.equals("y")) {
                                jVar.xt = jsonReader.nextString();
                                break;
                            } else {
                                jsonReader.skipValue();
                                break;
                            }
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                } else if (nextName.equals("h")) {
                    jVar.f23335r = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private static void j(JsonReader jsonReader, m.cw cwVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode != 3239) {
                    if (hashCode == 107027) {
                        if (nextName.equals("lel")) {
                            cwVar.cw = cw(jsonReader);
                        } else {
                            jsonReader.skipValue();
                        }
                    } else {
                        if (hashCode == 3237004 && nextName.equals("inel")) {
                            cwVar.xt = new int[][]{new int[]{-1, -1}};
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                jsonReader.beginArray();
                                for (int i6 = 0; i6 < 2; i6++) {
                                    if (jsonReader.hasNext()) {
                                        cwVar.xt[0][i6] = jsonReader.nextInt();
                                    }
                                }
                                jsonReader.endArray();
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.skipValue();
                    }
                } else if (nextName.equals(t.f36153n)) {
                    cwVar.f23332j = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private static void j(JsonReader jsonReader, m.xt xtVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode != 3139) {
                    if (hashCode != 3232) {
                        if (hashCode != 3571) {
                            if (hashCode == 3666) {
                                if (nextName.equals("se")) {
                                    xtVar.f23347j = jsonReader.nextInt();
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else {
                                if (hashCode == 98713 && nextName.equals("cpf")) {
                                    xt(jsonReader, xtVar);
                                }
                                jsonReader.skipValue();
                            }
                        } else if (nextName.equals(t.f36163x)) {
                            xtVar.f23349r = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (nextName.equals("ee")) {
                        xtVar.cw = xt(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (nextName.equals("be")) {
                    xtVar.xt = xt(jsonReader);
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private static void j(JsonReader jsonReader, m.r rVar) {
        try {
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode != 3123) {
                    if (hashCode != 3239) {
                        if (hashCode != 3355) {
                            if (hashCode != 3418) {
                                if (hashCode != 3704) {
                                    if (hashCode == 107027) {
                                        if (nextName.equals("lel")) {
                                            rVar.ae = cw(jsonReader);
                                        } else {
                                            jsonReader.skipValue();
                                        }
                                    } else {
                                        if (hashCode == 3237004 && nextName.equals("inel")) {
                                            rVar.up = new int[]{-1, -1};
                                            jsonReader.beginArray();
                                            for (int i6 = 0; i6 < 2; i6++) {
                                                if (jsonReader.hasNext()) {
                                                    rVar.up[i6] = jsonReader.nextInt();
                                                }
                                            }
                                            jsonReader.endArray();
                                        }
                                        jsonReader.skipValue();
                                    }
                                } else if (nextName.equals("tl")) {
                                    rVar.cw = jsonReader.nextString();
                                } else {
                                    jsonReader.skipValue();
                                }
                            } else if (nextName.equals("ke")) {
                                rVar.f23340j = jsonReader.nextInt();
                            } else {
                                jsonReader.skipValue();
                            }
                        } else if (nextName.equals("id")) {
                            rVar.xt = jsonReader.nextString();
                        } else {
                            jsonReader.skipValue();
                        }
                    } else if (nextName.equals(t.f36153n)) {
                        rVar.f23341m = jsonReader.nextString();
                    } else {
                        jsonReader.skipValue();
                    }
                } else if (nextName.equals("at")) {
                    rVar.f23342r = jsonReader.nextString();
                } else {
                    jsonReader.skipValue();
                }
            }
            jsonReader.endObject();
        } catch (Exception e6) {
            com.bytedance.sdk.component.utils.vl.j(e6);
        }
    }

    private static void j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, List<com.bytedance.adsdk.lottie.model.layer.tl> list, LongSparseArray<com.bytedance.adsdk.lottie.model.layer.tl> longSparseArray) throws IOException {
        jsonReader.beginArray();
        int i6 = 0;
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.layer.tl j6 = f.j(jsonReader, mVar);
            if (j6.qv() == tl.j.IMAGE) {
                i6++;
            }
            list.add(j6);
            longSparseArray.put(j6.up(), j6);
            if (i6 > 4) {
                com.bytedance.adsdk.lottie.up.up.xt("You have " + i6 + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.endArray();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, Map<String, List<com.bytedance.adsdk.lottie.model.layer.tl>> map, Map<String, com.bytedance.adsdk.lottie.g> map2) throws IOException {
        char c6;
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.beginObject();
            String str = null;
            String str2 = null;
            String str3 = null;
            String str4 = null;
            List<g.xt> list = null;
            String str5 = null;
            int[][] iArr = null;
            JSONArray jSONArray = null;
            String str6 = null;
            String str7 = null;
            g.j jVar = null;
            int i6 = 0;
            int i7 = 0;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.getClass();
                switch (nextName.hashCode()) {
                    case -1109732030:
                        if (nextName.equals(RtspHeaders.Values.LAYERS)) {
                            c6 = 0;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case -847116302:
                        if (nextName.equals("ugen_v")) {
                            c6 = 1;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 104:
                        if (nextName.equals("h")) {
                            c6 = 2;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 112:
                        if (nextName.equals("p")) {
                            c6 = 3;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 117:
                        if (nextName.equals("u")) {
                            c6 = 4;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 119:
                        if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                            c6 = 5;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 3239:
                        if (nextName.equals(t.f36153n)) {
                            c6 = 6;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 3355:
                        if (nextName.equals("id")) {
                            c6 = 7;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 3633:
                        if (nextName.equals("rc")) {
                            c6 = '\b';
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 3695:
                        if (nextName.equals("tc")) {
                            c6 = '\t';
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 107027:
                        if (nextName.equals("lel")) {
                            c6 = '\n';
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 107902:
                        if (nextName.equals(TKDownloadReason.KSAD_TK_MD5)) {
                            c6 = 11;
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 112793:
                        if (nextName.equals("rel")) {
                            c6 = '\f';
                            break;
                        }
                        c6 = 65535;
                        break;
                    case 3237004:
                        if (nextName.equals("inel")) {
                            c6 = StringUtil.CARRIAGE_RETURN;
                            break;
                        }
                        c6 = 65535;
                        break;
                    default:
                        c6 = 65535;
                        break;
                }
                switch (c6) {
                    case 0:
                        JsonReader jsonReader2 = jsonReader;
                        jsonReader2.beginArray();
                        while (jsonReader2.hasNext()) {
                            com.bytedance.adsdk.lottie.model.layer.tl j6 = f.j(jsonReader, mVar);
                            longSparseArray.put(j6.up(), j6);
                            arrayList.add(j6);
                            jsonReader2 = jsonReader;
                        }
                        jsonReader.endArray();
                        break;
                    case 1:
                        str7 = jsonReader.nextString();
                        break;
                    case 2:
                        i7 = jsonReader.nextInt();
                        break;
                    case 3:
                        str2 = jsonReader.nextString();
                        break;
                    case 4:
                        str3 = jsonReader.nextString();
                        break;
                    case 5:
                        i6 = jsonReader.nextInt();
                        break;
                    case 6:
                        str5 = jsonReader.nextString();
                        break;
                    case 7:
                        str = jsonReader.nextString();
                        break;
                    case '\b':
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                            break;
                        } else {
                            g.j jVar2 = new g.j();
                            jsonReader.beginObject();
                            j(jsonReader, jVar2);
                            jsonReader.endObject();
                            jVar = jVar2;
                            break;
                        }
                    case '\t':
                        jsonReader.beginArray();
                        list = r(jsonReader);
                        jsonReader.endArray();
                        break;
                    case '\n':
                        jSONArray = cw(jsonReader);
                        break;
                    case 11:
                        str6 = jsonReader.nextString();
                        break;
                    case '\f':
                        str4 = jsonReader.nextString();
                        break;
                    case '\r':
                        iArr = new int[][]{new int[]{-1, -1}};
                        jsonReader.beginArray();
                        if (jsonReader.hasNext()) {
                            jsonReader.beginArray();
                            for (int i8 = 0; i8 < 2; i8++) {
                                if (jsonReader.hasNext()) {
                                    iArr[0][i8] = jsonReader.nextInt();
                                }
                            }
                            jsonReader.endArray();
                        }
                        jsonReader.endArray();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            if (str2 != null) {
                com.bytedance.adsdk.lottie.g gVar = new com.bytedance.adsdk.lottie.g(i6, i7, str, str2, str3, str4, list, str5, iArr, jSONArray, str6, str7, jVar);
                map2.put(gVar.qv(), gVar);
            } else {
                map.put(str, arrayList);
            }
        }
        jsonReader.endArray();
    }

    private static void j(JsonReader jsonReader, g.j jVar) {
        while (jsonReader.hasNext()) {
            try {
                String nextName = jsonReader.nextName();
                int hashCode = nextName.hashCode();
                if (hashCode == -2128704353) {
                    if (nextName.equals("is_secondary")) {
                        jVar.xt = jsonReader.nextBoolean();
                    } else {
                        jsonReader.skipValue();
                    }
                } else {
                    if (hashCode == 3308 && nextName.equals("gs")) {
                        if (jsonReader.peek() == JsonToken.NULL) {
                            jsonReader.nextNull();
                        } else {
                            jVar.f23229j = new g.j.C0314j();
                            jsonReader.beginObject();
                            while (jsonReader.hasNext()) {
                                String nextName2 = jsonReader.nextName();
                                if (nextName2.hashCode() == 114 && nextName2.equals(t.f36150k)) {
                                    jVar.f23229j.f23230j = (float) jsonReader.nextDouble();
                                }
                                jsonReader.skipValue();
                            }
                            jsonReader.endObject();
                        }
                    }
                    jsonReader.skipValue();
                }
            } catch (Exception e6) {
                com.bytedance.sdk.component.utils.vl.j(e6);
                return;
            }
        }
    }

    private static void j(JsonReader jsonReader, Map<String, com.bytedance.adsdk.lottie.model.cw> map) throws IOException {
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            if (!nextName.equals("list")) {
                jsonReader.skipValue();
            } else {
                jsonReader.beginArray();
                while (jsonReader.hasNext()) {
                    com.bytedance.adsdk.lottie.model.cw j6 = ws.j(jsonReader);
                    map.put(j6.xt(), j6);
                }
                jsonReader.endArray();
            }
        }
        jsonReader.endObject();
    }

    private static void j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar, SparseArray<com.bytedance.adsdk.lottie.model.r> sparseArray) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            com.bytedance.adsdk.lottie.model.r j6 = jy.j(jsonReader, mVar);
            sparseArray.put(j6.hashCode(), j6);
        }
        jsonReader.endArray();
    }

    private static void j(JsonReader jsonReader, List<com.bytedance.adsdk.lottie.model.m> list) throws IOException {
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            jsonReader.beginObject();
            float f6 = 0.0f;
            String str = null;
            float f7 = 0.0f;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                nextName.getClass();
                switch (nextName) {
                    case "cm":
                        str = jsonReader.nextString();
                        break;
                    case "dr":
                        f7 = (float) jsonReader.nextDouble();
                        break;
                    case "tm":
                        f6 = (float) jsonReader.nextDouble();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
            jsonReader.endObject();
            list.add(new com.bytedance.adsdk.lottie.model.m(str, f6, f7));
        }
        jsonReader.endArray();
    }
}
