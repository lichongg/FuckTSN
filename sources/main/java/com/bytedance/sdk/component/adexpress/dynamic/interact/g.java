package com.bytedance.sdk.component.adexpress.dynamic.interact;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.sdk.component.adexpress.dynamic.dynamicview.DynamicBaseWidget;
import com.tencent.connect.common.Constants;
import io.netty.util.internal.StringUtil;

/* loaded from: D:\Downloads\app\classes4.dex */
public class g {
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ae j(Context context, DynamicBaseWidget dynamicBaseWidget, com.bytedance.sdk.component.adexpress.dynamic.cw.ae aeVar, com.bytedance.sdk.component.adexpress.dynamic.cw.oq oqVar, com.bytedance.sdk.component.adexpress.xt.jy jyVar) {
        String str = null;
        if (context == null || dynamicBaseWidget == null || aeVar == null) {
            return null;
        }
        String nd = aeVar.nd();
        String a6 = jyVar.a();
        nd.getClass();
        char c6 = 65535;
        switch (nd.hashCode()) {
            case 48:
                if (nd.equals("0")) {
                    c6 = 0;
                    break;
                }
                break;
            case 49:
                if (nd.equals("1")) {
                    c6 = 1;
                    break;
                }
                break;
            case 50:
                if (nd.equals("2")) {
                    c6 = 2;
                    break;
                }
                break;
            case 53:
                if (nd.equals("5")) {
                    c6 = 3;
                    break;
                }
                break;
            case 54:
                if (nd.equals("6")) {
                    c6 = 4;
                    break;
                }
                break;
            case 55:
                if (nd.equals("7")) {
                    c6 = 5;
                    break;
                }
                break;
            case 56:
                if (nd.equals("8")) {
                    c6 = 6;
                    break;
                }
                break;
            case 57:
                if (nd.equals("9")) {
                    c6 = 7;
                    break;
                }
                break;
            case 1567:
                if (nd.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ)) {
                    c6 = '\b';
                    break;
                }
                break;
            case 1568:
                if (nd.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE)) {
                    c6 = '\t';
                    break;
                }
                break;
            case 1569:
                if (nd.equals(Constants.VIA_REPORT_TYPE_SET_AVATAR)) {
                    c6 = '\n';
                    break;
                }
                break;
            case 1570:
                if (nd.equals(Constants.VIA_REPORT_TYPE_JOININ_GROUP)) {
                    c6 = 11;
                    break;
                }
                break;
            case 1571:
                if (nd.equals(Constants.VIA_REPORT_TYPE_MAKE_FRIEND)) {
                    c6 = '\f';
                    break;
                }
                break;
            case 1573:
                if (nd.equals(Constants.VIA_REPORT_TYPE_START_WAP)) {
                    c6 = StringUtil.CARRIAGE_RETURN;
                    break;
                }
                break;
            case 1574:
                if (nd.equals(Constants.VIA_REPORT_TYPE_START_GROUP)) {
                    c6 = 14;
                    break;
                }
                break;
            case 1575:
                if (nd.equals("18")) {
                    c6 = 15;
                    break;
                }
                break;
            case 1598:
                if (nd.equals("20")) {
                    c6 = 16;
                    break;
                }
                break;
            case 1600:
                if (nd.equals(Constants.VIA_REPORT_TYPE_DATALINE)) {
                    c6 = 17;
                    break;
                }
                break;
            case 1601:
                if (nd.equals(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR)) {
                    c6 = 18;
                    break;
                }
                break;
            case 1602:
                if (nd.equals(Constants.VIA_REPORT_TYPE_CHAT_AIO)) {
                    c6 = 19;
                    break;
                }
                break;
            case 1603:
                if (nd.equals(Constants.VIA_REPORT_TYPE_CHAT_AUDIO)) {
                    c6 = 20;
                    break;
                }
                break;
            case 1607:
                if (nd.equals("29")) {
                    c6 = 21;
                    break;
                }
                break;
        }
        switch (c6) {
            case 0:
                return new up(context, dynamicBaseWidget, aeVar);
            case 1:
                return new cw(context, dynamicBaseWidget, aeVar);
            case 2:
                return new xt(context, dynamicBaseWidget, aeVar);
            case 3:
                return aeVar.ol() == 1 ? new i(context, dynamicBaseWidget, aeVar, aeVar.ff()) : new av(context, dynamicBaseWidget, aeVar);
            case 4:
            case '\t':
                return new jy(context, dynamicBaseWidget, aeVar);
            case 5:
            case '\f':
                return new qv(context, dynamicBaseWidget, aeVar);
            case 6:
                return new vl(context, dynamicBaseWidget, aeVar);
            case 7:
            case '\r':
                return new ws(context, dynamicBaseWidget, aeVar, nd, oqVar, jyVar.g(), jyVar.p());
            case '\b':
                return new r(context, dynamicBaseWidget, aeVar);
            case '\n':
                return new av(context, dynamicBaseWidget, aeVar);
            case 11:
                return new i(context, dynamicBaseWidget, aeVar);
            case 14:
            case 15:
                return new mi(context, dynamicBaseWidget, aeVar, nd, oqVar, jyVar.g(), jyVar.p());
            case 16:
                if (com.bytedance.sdk.component.adexpress.r.j()) {
                    return new oq(context, dynamicBaseWidget, aeVar, a6 + "static/lotties/glass-swipe/glass-swipe.json", "20");
                }
                if (!TextUtils.isEmpty(a6)) {
                    str = a6 + "brush_mask.json";
                }
                return new oq(context, dynamicBaseWidget, aeVar, str, "20");
            case 17:
                if (!com.bytedance.sdk.component.adexpress.r.j()) {
                    return new w(context, dynamicBaseWidget, aeVar);
                }
                return new oq(context, dynamicBaseWidget, aeVar, a6 + "static/lotties/202327swiper-up-star/index.json", Constants.VIA_REPORT_TYPE_DATALINE);
            case 18:
                if (!com.bytedance.sdk.component.adexpress.r.j()) {
                    return null;
                }
                return new oq(context, dynamicBaseWidget, aeVar, a6 + "static/lotties/202327swiper-up-star/click.json", Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR);
            case 19:
                if (com.bytedance.sdk.component.adexpress.r.j()) {
                    return new j(context, dynamicBaseWidget, aeVar);
                }
                if (!TextUtils.isEmpty(a6)) {
                    str = a6 + "swiper_up_star.json";
                }
                return new oq(context, dynamicBaseWidget, aeVar, str, Constants.VIA_REPORT_TYPE_CHAT_AIO);
            case 20:
                if (!com.bytedance.sdk.component.adexpress.r.j()) {
                    return null;
                }
                return new oq(context, dynamicBaseWidget, aeVar, a6 + "static/lotties/gesture-slide.json", Constants.VIA_REPORT_TYPE_CHAT_AUDIO);
            case 21:
                return new m(context, dynamicBaseWidget, aeVar, oqVar, jyVar.g(), jyVar.p());
            default:
                return null;
        }
    }
}
