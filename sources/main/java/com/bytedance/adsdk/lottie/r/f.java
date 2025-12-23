package com.bytedance.adsdk.lottie.r;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import com.amap.api.col.p0003l.ef;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.model.layer.tl;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.snail.antifake.deviceid.e;
import com.umeng.analytics.pro.bi;
import io.netty.util.internal.StringUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: D:\Downloads\app\classes3.dex */
public class f {
    public static com.bytedance.adsdk.lottie.model.layer.tl j(com.bytedance.adsdk.lottie.m mVar) {
        Rect r5 = mVar.r();
        List list = Collections.EMPTY_LIST;
        return new com.bytedance.adsdk.lottie.model.layer.tl(list, mVar, "__container", -1L, tl.j.PRE_COMP, -1L, null, list, new com.bytedance.adsdk.lottie.model.j.vl(), 0, 0, 0, 0.0f, 0.0f, r5.width(), r5.height(), null, null, list, tl.xt.NONE, null, false, null, null);
    }

    /* renamed from: com.bytedance.adsdk.lottie.r.f$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: j, reason: collision with root package name */
        static final /* synthetic */ int[] f23503j;

        static {
            int[] iArr = new int[tl.xt.values().length];
            f23503j = iArr;
            try {
                iArr[tl.xt.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f23503j[tl.xt.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.bytedance.adsdk.lottie.model.layer.tl j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        Float f6;
        Float valueOf = Float.valueOf(0.0f);
        Float valueOf2 = Float.valueOf(1.0f);
        tl.xt xtVar = tl.xt.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        tl.xt xtVar2 = xtVar;
        String str = null;
        com.bytedance.adsdk.lottie.model.j.vl vlVar = null;
        com.bytedance.adsdk.lottie.model.j.oq oqVar = null;
        com.bytedance.adsdk.lottie.model.j.qv qvVar = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar3 = null;
        com.bytedance.adsdk.lottie.model.xt.j jVar = null;
        oq oqVar2 = null;
        long j6 = 0;
        long j7 = -1;
        float f7 = 1.0f;
        float f8 = 0.0f;
        float f9 = 0.0f;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        boolean z5 = false;
        String str2 = "UNSET";
        String str3 = null;
        tl.j jVar2 = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            char c6 = 65535;
            switch (nextName.hashCode()) {
                case -995424086:
                    if (nextName.equals("parent")) {
                        c6 = 0;
                        break;
                    }
                    break;
                case -903568142:
                    if (nextName.equals("shapes")) {
                        c6 = 1;
                        break;
                    }
                    break;
                case 104:
                    if (nextName.equals("h")) {
                        c6 = 2;
                        break;
                    }
                    break;
                case 116:
                    if (nextName.equals(bi.aL)) {
                        c6 = 3;
                        break;
                    }
                    break;
                case 119:
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c6 = 4;
                        break;
                    }
                    break;
                case 3177:
                    if (nextName.equals("cl")) {
                        c6 = 5;
                        break;
                    }
                    break;
                case 3233:
                    if (nextName.equals(ef.f6043r)) {
                        c6 = 6;
                        break;
                    }
                    break;
                case 3324:
                    if (nextName.equals(LiveConfigKey.HIGH)) {
                        c6 = 7;
                        break;
                    }
                    break;
                case 3367:
                    if (nextName.equals(IjkMediaPlayer.OnNativeInvokeListener.ARG_IP)) {
                        c6 = '\b';
                        break;
                    }
                    break;
                case 3432:
                    if (nextName.equals(MediationConstant.ADN_KS)) {
                        c6 = '\t';
                        break;
                    }
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c6 = '\n';
                        break;
                    }
                    break;
                case 3553:
                    if (nextName.equals("op")) {
                        c6 = 11;
                        break;
                    }
                    break;
                case 3664:
                    if (nextName.equals("sc")) {
                        c6 = '\f';
                        break;
                    }
                    break;
                case 3669:
                    if (nextName.equals(e.f37540b)) {
                        c6 = StringUtil.CARRIAGE_RETURN;
                        break;
                    }
                    break;
                case 3679:
                    if (nextName.equals("sr")) {
                        c6 = 14;
                        break;
                    }
                    break;
                case 3681:
                    if (nextName.equals("st")) {
                        c6 = 15;
                        break;
                    }
                    break;
                case 3684:
                    if (nextName.equals("sw")) {
                        c6 = 16;
                        break;
                    }
                    break;
                case 3705:
                    if (nextName.equals("tm")) {
                        c6 = 17;
                        break;
                    }
                    break;
                case 3712:
                    if (nextName.equals("tt")) {
                        c6 = 18;
                        break;
                    }
                    break;
                case 3717:
                    if (nextName.equals("ty")) {
                        c6 = 19;
                        break;
                    }
                    break;
                case 104415:
                    if (nextName.equals("ind")) {
                        c6 = 20;
                        break;
                    }
                    break;
                case 108390670:
                    if (nextName.equals("refId")) {
                        c6 = 21;
                        break;
                    }
                    break;
                case 1441620890:
                    if (nextName.equals("masksProperties")) {
                        c6 = 22;
                        break;
                    }
                    break;
            }
            switch (c6) {
                case 0:
                    j7 = jsonReader.nextInt();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.bytedance.adsdk.lottie.model.xt.cw j8 = tl.j(jsonReader, mVar);
                        if (j8 != null) {
                            arrayList2.add(j8);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 2:
                    f11 = (float) (jsonReader.nextDouble() * com.bytedance.adsdk.lottie.up.g.j());
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.getClass();
                        if (nextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                qvVar = xt.j(jsonReader, mVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (!nextName2.equals("d")) {
                            jsonReader.skipValue();
                        } else {
                            oqVar = r.m(jsonReader, mVar);
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    f10 = (float) (jsonReader.nextDouble() * com.bytedance.adsdk.lottie.up.g.j());
                    break;
                case 5:
                    str3 = jsonReader.nextString();
                    break;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String nextName3 = jsonReader.nextName();
                            nextName3.getClass();
                            if (nextName3.equals("nm")) {
                                arrayList3.add(jsonReader.nextString());
                            } else if (!nextName3.equals("ty")) {
                                jsonReader.skipValue();
                            } else {
                                int nextInt = jsonReader.nextInt();
                                if (nextInt == 29) {
                                    jVar = up.j(jsonReader, mVar);
                                } else if (nextInt == 25) {
                                    oqVar2 = new qv().j(jsonReader, mVar);
                                }
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    mVar.j("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList3)));
                    break;
                case 7:
                    z5 = jsonReader.nextBoolean();
                    break;
                case '\b':
                    f8 = (float) jsonReader.nextDouble();
                    break;
                case '\t':
                    vlVar = cw.j(jsonReader, mVar);
                    break;
                case '\n':
                    str2 = jsonReader.nextString();
                    break;
                case 11:
                    f9 = (float) jsonReader.nextDouble();
                    break;
                case '\f':
                    i8 = Color.parseColor(jsonReader.nextString());
                    break;
                case '\r':
                    i7 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.up.g.j());
                    break;
                case 14:
                    f7 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    f12 = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    i6 = (int) (jsonReader.nextInt() * com.bytedance.adsdk.lottie.up.g.j());
                    break;
                case 17:
                    xtVar3 = r.j(jsonReader, mVar, false);
                    break;
                case 18:
                    int nextInt2 = jsonReader.nextInt();
                    if (nextInt2 >= tl.xt.values().length) {
                        mVar.j("Unsupported matte type: ".concat(String.valueOf(nextInt2)));
                        break;
                    } else {
                        xtVar2 = tl.xt.values()[nextInt2];
                        int i9 = AnonymousClass1.f23503j[xtVar2.ordinal()];
                        if (i9 == 1) {
                            mVar.j("Unsupported matte type: Luma");
                        } else if (i9 == 2) {
                            mVar.j("Unsupported matte type: Luma Inverted");
                        }
                        mVar.j(1);
                        break;
                    }
                case 19:
                    int nextInt3 = jsonReader.nextInt();
                    jVar2 = tl.j.UNKNOWN;
                    if (nextInt3 >= jVar2.ordinal()) {
                        break;
                    } else {
                        jVar2 = tl.j.values()[nextInt3];
                        break;
                    }
                case 20:
                    j6 = jsonReader.nextInt();
                    break;
                case 21:
                    str = jsonReader.nextString();
                    break;
                case 22:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(x.j(jsonReader, mVar));
                    }
                    mVar.j(arrayList.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (f8 > 0.0f) {
            f6 = valueOf;
            arrayList4.add(new com.bytedance.adsdk.lottie.m.j(mVar, valueOf, valueOf, null, 0.0f, Float.valueOf(f8)));
        } else {
            f6 = valueOf;
        }
        if (f9 <= 0.0f) {
            f9 = mVar.ae();
        }
        arrayList4.add(new com.bytedance.adsdk.lottie.m.j(mVar, valueOf2, valueOf2, null, f8, Float.valueOf(f9)));
        arrayList4.add(new com.bytedance.adsdk.lottie.m.j(mVar, f6, f6, null, f9, Float.valueOf(Float.MAX_VALUE)));
        if (str2.endsWith(".ai") || "ai".equals(str3)) {
            mVar.j("Convert your Illustrator layers to shape layers.");
        }
        return new com.bytedance.adsdk.lottie.model.layer.tl(arrayList2, mVar, str2, j6, jVar2, j7, str, arrayList, vlVar, i6, i7, i8, f7, f12, f10, f11, oqVar, qvVar, arrayList4, xtVar2, xtVar3, z5, jVar, oqVar2);
    }
}
