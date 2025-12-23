package com.ss.android.socialbase.appdownloader.j;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\Downloads\app\classes6.dex */
public class e extends d {
    public static String b(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuffer.append(entry.getKey());
            stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
            stringBuffer.append(URLEncoder.encode(entry.getValue()));
            stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        }
        String stringBuffer2 = stringBuffer.toString();
        return stringBuffer2.endsWith(ContainerUtils.FIELD_DELIMITER) ? stringBuffer2.substring(0, stringBuffer2.length() - 1) : stringBuffer2;
    }

    @Override // com.ss.android.socialbase.appdownloader.j.k
    public Intent xt() {
        String cw = this.f38465b.cw("s");
        String b6 = com.ss.android.socialbase.appdownloader.m.a.b(this.f38465b.cw("bb"), cw);
        if (!TextUtils.isEmpty(b6) && b6.split(",").length == 2) {
            String b7 = com.ss.android.socialbase.appdownloader.m.a.b(this.f38465b.cw("bc"), cw);
            if (!TextUtils.isEmpty(b7) && b7.split(",").length == 2) {
                String[] split = b6.split(",");
                String[] split2 = b7.split(",");
                String b8 = com.ss.android.socialbase.appdownloader.m.a.b(this.f38465b.cw("bd"), cw);
                String b9 = com.ss.android.socialbase.appdownloader.m.a.b(this.f38465b.cw("be"), cw);
                String b10 = com.ss.android.socialbase.appdownloader.m.a.b(this.f38465b.cw("bf"), cw);
                HashMap hashMap = new HashMap();
                hashMap.put(split[0], split[1]);
                hashMap.put(split2[0], split2[1]);
                hashMap.put(b8, this.f38466c);
                Intent intent = new Intent();
                intent.setAction(b10);
                intent.setData(Uri.parse(b9 + b(hashMap)));
                intent.addFlags(268468224);
                return intent;
            }
        }
        return null;
    }

    public e(Context context, com.ss.android.socialbase.downloader.jy.j jVar, String str) {
        super(context, jVar, str);
    }
}
