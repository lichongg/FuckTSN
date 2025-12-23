package com.bytedance.adsdk.lottie.r;

import android.graphics.Path;
import android.util.JsonReader;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.kuaishou.weapon.p0.t;
import com.umeng.analytics.pro.bi;
import java.io.IOException;
import java.util.Collections;

/* loaded from: D:\Downloads\app\classes3.dex */
class av {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    static com.bytedance.adsdk.lottie.model.xt.up j(JsonReader jsonReader, com.bytedance.adsdk.lottie.m mVar) throws IOException {
        char c6;
        com.bytedance.adsdk.lottie.model.j.r rVar = null;
        Path.FillType fillType = Path.FillType.WINDING;
        String str = null;
        com.bytedance.adsdk.lottie.model.xt.ae aeVar = null;
        com.bytedance.adsdk.lottie.model.j.cw cwVar = null;
        com.bytedance.adsdk.lottie.model.j.m mVar2 = null;
        com.bytedance.adsdk.lottie.model.j.m mVar3 = null;
        boolean z5 = false;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.getClass();
            int i6 = -1;
            switch (nextName.hashCode()) {
                case 101:
                    if (nextName.equals("e")) {
                        c6 = 0;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 103:
                    if (nextName.equals("g")) {
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
                case 114:
                    if (nextName.equals(t.f36150k)) {
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
                case 3324:
                    if (nextName.equals(LiveConfigKey.HIGH)) {
                        c6 = 6;
                        break;
                    }
                    c6 = 65535;
                    break;
                case 3519:
                    if (nextName.equals("nm")) {
                        c6 = 7;
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
                    mVar3 = r.cw(jsonReader, mVar);
                    break;
                case 1:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String nextName2 = jsonReader.nextName();
                        nextName2.getClass();
                        if (nextName2.equals("k")) {
                            cwVar = r.j(jsonReader, mVar, i6);
                        } else if (nextName2.equals("p")) {
                            i6 = jsonReader.nextInt();
                        } else {
                            jsonReader.skipValue();
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 2:
                    rVar = r.xt(jsonReader, mVar);
                    break;
                case 3:
                    fillType = jsonReader.nextInt() == 1 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD;
                    break;
                case 4:
                    mVar2 = r.cw(jsonReader, mVar);
                    break;
                case 5:
                    aeVar = jsonReader.nextInt() == 1 ? com.bytedance.adsdk.lottie.model.xt.ae.LINEAR : com.bytedance.adsdk.lottie.model.xt.ae.RADIAL;
                    break;
                case 6:
                    z5 = jsonReader.nextBoolean();
                    break;
                case 7:
                    str = jsonReader.nextString();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        if (rVar == null) {
            rVar = new com.bytedance.adsdk.lottie.model.j.r(Collections.singletonList(new com.bytedance.adsdk.lottie.m.j(100)));
        }
        return new com.bytedance.adsdk.lottie.model.xt.up(str, aeVar, fillType, cwVar, rVar, mVar2, mVar3, null, null, z5);
    }
}
