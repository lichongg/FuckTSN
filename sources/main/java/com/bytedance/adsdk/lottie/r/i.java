package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.model.xt.w;
import com.umeng.analytics.pro.bi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\Downloads\app\classes3.dex */
class i {
    static com.bytedance.adsdk.lottie.model.xt.m j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        char c6;
        com.bytedance.adsdk.lottie.model.j.cw cwVar;
        com.bytedance.adsdk.lottie.model.j.m mVar2;
        ArrayList arrayList = new ArrayList();
        String str = null;
        com.bytedance.adsdk.lottie.model.j.r rVar = null;
        com.bytedance.adsdk.lottie.model.xt.ae aeVar = null;
        com.bytedance.adsdk.lottie.model.j.cw cwVar2 = null;
        com.bytedance.adsdk.lottie.model.j.m mVar3 = null;
        com.bytedance.adsdk.lottie.model.j.m mVar4 = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar = null;
        w.j jVar = null;
        w.xt xtVar2 = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar3 = null;
        float f6 = 0.0f;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            String str2 = str;
            com.bytedance.adsdk.lottie.model.j.r rVar2 = rVar;
            com.bytedance.adsdk.lottie.model.xt.ae aeVar2 = aeVar;
            switch (nextName.hashCode()) {
                case 100:
                    if (nextName.equals("d")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 101:
                    if (nextName.equals("e")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 103:
                    if (nextName.equals("g")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 115:
                    if (nextName.equals("s")) {
                        c6 = 4;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 116:
                    if (nextName.equals(bi.aL)) {
                        c6 = 5;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 119:
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c6 = 6;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3324:
                    if (nextName.equals(LiveConfigKey.HIGH)) {
                        c6 = 7;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c6 = '\b';
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c6 = '\t';
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c6 = '\n';
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c6 = 11;
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
                        jsonReader2.beginObject();
                        com.bytedance.adsdk.lottie.model.j.xt xtVar4 = null;
                        String str3 = null;
                        while (jsonReader.hasNext()) {
                            com.bytedance.adsdk.lottie.model.j.cw cwVar3 = cwVar2;
                            String nextName2 = jsonReader.nextName();
                            nextName2.getClass();
                            com.bytedance.adsdk.lottie.model.j.m mVar5 = mVar3;
                            if (nextName2.equals("n")) {
                                str3 = jsonReader.nextString();
                            } else if (nextName2.equals("v")) {
                                xtVar4 = r.j(jsonReader, mVar);
                            } else {
                                jsonReader.skipValue();
                            }
                            cwVar2 = cwVar3;
                            mVar3 = mVar5;
                        }
                        com.bytedance.adsdk.lottie.model.j.cw cwVar4 = cwVar2;
                        com.bytedance.adsdk.lottie.model.j.m mVar6 = mVar3;
                        jsonReader.endObject();
                        if (str3.equals("o")) {
                            xtVar3 = xtVar4;
                            cwVar2 = cwVar4;
                            mVar3 = mVar6;
                            jsonReader2 = jsonReader;
                        } else {
                            if (str3.equals("d") || str3.equals("g")) {
                                mVar.j(true);
                                arrayList.add(xtVar4);
                            }
                            jsonReader2 = jsonReader;
                            cwVar2 = cwVar4;
                            mVar3 = mVar6;
                        }
                    }
                    cwVar = cwVar2;
                    mVar2 = mVar3;
                    jsonReader.endArray();
                    if (arrayList.size() == 1) {
                        arrayList.add(arrayList.get(0));
                        str = str2;
                        rVar = rVar2;
                        cwVar2 = cwVar;
                        aeVar = aeVar2;
                        mVar3 = mVar2;
                        break;
                    }
                    str = str2;
                    rVar = rVar2;
                    cwVar2 = cwVar;
                    aeVar = aeVar2;
                    mVar3 = mVar2;
                    break;
                case 1:
                    mVar4 = r.cw(jsonReader, mVar);
                    str = str2;
                    rVar = rVar2;
                    aeVar = aeVar2;
                    break;
                case 2:
                    jsonReader.beginObject();
                    int i6 = -1;
                    while (jsonReader.hasNext()) {
                        String nextName3 = jsonReader.nextName();
                        nextName3.getClass();
                        if (nextName3.equals("k")) {
                            cwVar2 = r.j(jsonReader, mVar, i6);
                        } else if (nextName3.equals("p")) {
                            i6 = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    str = str2;
                    rVar = rVar2;
                    aeVar = aeVar2;
                    break;
                case 3:
                    rVar = r.xt(jsonReader, mVar);
                    str = str2;
                    aeVar = aeVar2;
                    break;
                case 4:
                    mVar3 = r.cw(jsonReader, mVar);
                    str = str2;
                    rVar = rVar2;
                    aeVar = aeVar2;
                    break;
                case 5:
                    aeVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.model.xt.ae.LINEAR : com.bytedance.adsdk.lottie.model.xt.ae.RADIAL;
                    str = str2;
                    rVar = rVar2;
                    break;
                case 6:
                    xtVar = r.j(jsonReader, mVar);
                    str = str2;
                    rVar = rVar2;
                    aeVar = aeVar2;
                    break;
                case 7:
                    z5 = jsonReader.nextBoolean();
                    str = str2;
                    rVar = rVar2;
                    aeVar = aeVar2;
                    break;
                case '\b':
                    jVar = w.j.values()[jsonReader.nextInt() - 1];
                    str = str2;
                    rVar = rVar2;
                    aeVar = aeVar2;
                    break;
                case '\t':
                    xtVar2 = w.xt.values()[jsonReader.nextInt() - 1];
                    str = str2;
                    rVar = rVar2;
                    aeVar = aeVar2;
                    break;
                case '\n':
                    f6 = (float) jsonReader.nextDouble();
                    str = str2;
                    rVar = rVar2;
                    aeVar = aeVar2;
                    break;
                case 11:
                    str = jsonReader.nextString();
                    rVar = rVar2;
                    aeVar = aeVar2;
                    break;
                default:
                    jsonReader.skipValue();
                    cwVar = cwVar2;
                    mVar2 = mVar3;
                    str = str2;
                    rVar = rVar2;
                    cwVar2 = cwVar;
                    aeVar = aeVar2;
                    mVar3 = mVar2;
                    break;
            }
        }
        com.bytedance.adsdk.lottie.model.j.r rVar3 = rVar;
        return new com.bytedance.adsdk.lottie.model.xt.m(str, aeVar, cwVar2, rVar3 == null ? new com.bytedance.adsdk.lottie.model.j.r(Collections.singletonList(new com.bytedance.adsdk.lottie.m.j(100))) : rVar3, mVar3, mVar4, xtVar, jVar, xtVar2, f6, arrayList, xtVar3, z5);
    }
}
