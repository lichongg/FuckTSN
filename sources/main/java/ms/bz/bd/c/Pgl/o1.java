package ms.bz.bd.c.Pgl;

import com.bytedance.framwork.core.sdkmonitor.SDKMonitor;
import com.bytedance.sdk.component.utils.vl;
import com.google.common.primitives.SignedBytes;
import io.netty.handler.codec.http.HttpConstants;
import io.netty.handler.codec.memcache.binary.BinaryMemcacheOpcodes;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes8.dex */
public final class o1 extends pblw {

    /* renamed from: b, reason: collision with root package name */
    private SDKMonitor f50314b;

    final class pgla implements SDKMonitor.IGetExtendParams {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ JSONObject f50315a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f50316b;

        pgla(JSONObject jSONObject, String str) {
            this.f50315a = jSONObject;
            this.f50316b = str;
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void d(long j6, long j7, String str, String str2, int i6) {
        SDKMonitor sDKMonitor = this.f50314b;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorSLA(j6, j7, str, (String) null, str2, i6, (JSONObject) null);
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void e(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "28895c", new byte[]{16, 54, 74, 95, 14, 117, BinaryMemcacheOpcodes.GATK, 60, Byte.MAX_VALUE, 108, 45, 46, 103, 66, 13, 89, 48, 23, 104, 110, 38, 40, 11, 94, 15, 102, 39, 16, 106, 108, 45, HttpConstants.SEMICOLON, 70, 72, 74, 57, 124, 84, 41});
        if (this.f50314b == null) {
            return;
        }
        try {
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "218b31", new byte[]{48, 54, 89, 0, 5, 37, 52, 30, 104, Utf8.REPLACEMENT_BYTE, 38}), str);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "d7d139", new byte[]{118, 52, 3, SignedBytes.MAX_POWER_OF_TWO, 11, BinaryMemcacheOpcodes.SASL_AUTH, 117, 15}), jSONObject);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "4e2978", new byte[]{40, 98, 85, 95, 1, HttpConstants.COMMA}), jSONObject2);
            jSONObject4.put((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "157b25", new byte[]{HttpConstants.COMMA, 56, 67, 51, 21, 54, 32}), jSONObject3);
            vl.r((String) com.volcengine.mobsecBiz.matrix.pgla.a(16777217, 0, 0L, "1d042f", new byte[]{13, 67, 119, 97, 62, 84, 17}), jSONObject4.toString());
        } catch (JSONException e6) {
            vl.j(e6);
        }
        if (jSONObject.length() > 0 || jSONObject2.length() > 0) {
            this.f50314b.monitorEvent(str, jSONObject, jSONObject2, jSONObject3);
        }
    }

    @Override // ms.bz.bd.c.Pgl.pblw
    public final void h(long j6, long j7, String str, String str2, int i6) {
        SDKMonitor sDKMonitor = this.f50314b;
        if (sDKMonitor == null) {
            return;
        }
        sDKMonitor.monitorApiError(j6, j7, str, (String) null, str2, i6, (JSONObject) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0026 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0027  */
    @Override // ms.bz.bd.c.Pgl.pblw
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean g(java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 347
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ms.bz.bd.c.Pgl.o1.g(java.lang.String):boolean");
    }
}
