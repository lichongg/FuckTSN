package com.kwad.sdk.utils;

import android.view.MotionEvent;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.aj;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes6.dex */
public final class b {
    public static boolean a(aj.a aVar, List<Integer> list) {
        int abs = Math.abs(aVar.QO() - aVar.QQ());
        int abs2 = Math.abs(aVar.QP() - aVar.QR());
        if (list == null || list.isEmpty() || list.size() < 2) {
            return abs > 20 || abs2 > 20;
        }
        int atan2 = (int) ((Math.atan2(abs2, abs) * 180.0d) / 3.141592653589793d);
        return atan2 > list.get(0).intValue() && atan2 < list.get(1).intValue();
    }

    public static boolean g(aj.a aVar) {
        if (aVar == null) {
            return false;
        }
        return (Math.abs(aVar.QQ() - aVar.QO()) > 20) || (Math.abs(aVar.QR() - aVar.QP()) > 20);
    }

    public static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, AdTemplate adTemplate) {
        boolean z5 = false;
        if (adTemplate == null) {
            return false;
        }
        AdInfo el = com.kwad.sdk.core.response.b.e.el(adTemplate);
        float abs = Math.abs(motionEvent2.getRawX() - motionEvent.getRawX());
        float abs2 = Math.abs(motionEvent2.getRawY() - motionEvent.getRawY());
        List<Integer> U = com.kwad.sdk.core.response.b.a.U(el);
        if (U == null || U.isEmpty() || U.size() < 2) {
            return abs > 20.0f || abs2 > 20.0f;
        }
        int atan2 = (int) ((Math.atan2(abs2, abs) * 180.0d) / 3.141592653589793d);
        if (atan2 > U.get(0).intValue() && atan2 < U.get(1).intValue()) {
            z5 = true;
        }
        if (z5) {
            adTemplate.swipeAngle = atan2;
        }
        return z5;
    }

    public static boolean a(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent != null && motionEvent2 != null) {
            boolean z5 = Math.abs(motionEvent2.getY() - motionEvent.getY()) > 20.0f;
            if (Math.abs(motionEvent2.getX() - motionEvent.getX()) > 20.0f || z5) {
                return true;
            }
        }
        return false;
    }
}
