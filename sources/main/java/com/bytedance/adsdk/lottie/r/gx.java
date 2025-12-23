package com.bytedance.adsdk.lottie.r;

import android.util.JsonReader;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.adsdk.lottie.model.xt.w;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: D:\Downloads\app\classes3.dex */
class gx {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static com.bytedance.adsdk.lottie.model.xt.w j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        char c6;
        char c7;
        ArrayList arrayList = new ArrayList();
        com.bytedance.adsdk.lottie.model.j.r rVar = null;
        String str = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar = null;
        com.bytedance.adsdk.lottie.model.j.j jVar = null;
        com.bytedance.adsdk.lottie.model.j.xt xtVar2 = null;
        w.j jVar2 = null;
        float f6 = 0.0f;
        w.xt xtVar3 = null;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            switch (nextName.hashCode()) {
                case 99:
                    if (nextName.equals("c")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 100:
                    if (nextName.equals("d")) {
                        c6 = 1;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 111:
                    if (nextName.equals("o")) {
                        c6 = 2;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 119:
                    if (nextName.equals(IAdInterListener.AdReqParam.WIDTH)) {
                        c6 = 3;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3324:
                    if (nextName.equals(LiveConfigKey.HIGH)) {
                        c6 = 4;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3447:
                    if (nextName.equals("lc")) {
                        c6 = 5;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3454:
                    if (nextName.equals("lj")) {
                        c6 = 6;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3487:
                    if (nextName.equals("ml")) {
                        c6 = 7;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c6 = '\b';
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
                    jVar = r.ae(jsonReader, mVar);
                    continue;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        String str2 = null;
                        com.bytedance.adsdk.lottie.model.j.xt xtVar4 = null;
                        while (jsonReader.hasNext()) {
                            String nextName2 = jsonReader.nextName();
                            nextName2.getClass();
                            if (nextName2.equals("n")) {
                                str2 = jsonReader.nextString();
                            } else if (nextName2.equals("v")) {
                                xtVar4 = r.j(jsonReader, mVar);
                            } else {
                                jsonReader.skipValue();
                            }
                        }
                        jsonReader.endObject();
                        str2.getClass();
                        switch (str2.hashCode()) {
                            case 100:
                                if (str2.equals("d")) {
                                    c7 = 0;
                                    break;
                                }
                                c7 = 65535;
                                break;
                            case 103:
                                if (str2.equals("g")) {
                                    c7 = 1;
                                    break;
                                }
                                c7 = 65535;
                                break;
                            case 111:
                                if (str2.equals("o")) {
                                    c7 = 2;
                                    break;
                                }
                                c7 = 65535;
                                break;
                            default:
                                c7 = 65535;
                                break;
                        }
                        switch (c7) {
                            case 0:
                            case 1:
                                mVar.j(true);
                                arrayList.add(xtVar4);
                                break;
                            case 2:
                                xtVar = xtVar4;
                                break;
                        }
                    }
                    jsonReader.endArray();
                    if (arrayList.size() != 1) {
                        break;
                    } else {
                        arrayList.add(arrayList.get(0));
                        break;
                    }
                case 2:
                    rVar = r.xt(jsonReader, mVar);
                    continue;
                case 3:
                    xtVar2 = r.j(jsonReader, mVar);
                    continue;
                case 4:
                    z5 = jsonReader.nextBoolean();
                    continue;
                case 5:
                    jVar2 = w.j.values()[jsonReader.nextInt() - 1];
                    continue;
                case 6:
                    xtVar3 = w.xt.values()[jsonReader.nextInt() - 1];
                    continue;
                case 7:
                    f6 = (float) jsonReader.nextDouble();
                    continue;
                case '\b':
                    str = jsonReader.nextString();
                    continue;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (rVar == null) {
            rVar = new com.bytedance.adsdk.lottie.model.j.r(Collections.singletonList(new com.bytedance.adsdk.lottie.m.j(100)));
        }
        return new com.bytedance.adsdk.lottie.model.xt.w(str, xtVar, arrayList, jVar, rVar, xtVar2, jVar2, xtVar3, f6, z5);
    }
}
