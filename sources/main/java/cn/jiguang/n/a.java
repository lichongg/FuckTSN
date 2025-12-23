package cn.jiguang.n;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.ArrayMap;
import cn.jiguang.bb.f;
import cn.jiguang.bz.q;
import com.kuaishou.weapon.p0.g;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class a extends cn.jiguang.m.a {

    /* renamed from: b, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile a f3110b;

    /* renamed from: a, reason: collision with root package name */
    private Context f3111a;

    /* renamed from: c, reason: collision with root package name */
    private JSONObject f3112c;

    public static a a() {
        if (f3110b == null) {
            synchronized (a.class) {
                try {
                    if (f3110b == null) {
                        f3110b = new a();
                    }
                } finally {
                }
            }
        }
        return f3110b;
    }

    @Override // cn.jiguang.m.a
    protected String a(Context context) {
        this.f3111a = context;
        return "JBt";
    }

    @Override // cn.jiguang.m.a
    protected void c(Context context, String str) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 31) {
            f.c("JBt", "sdk is android 12, return");
            return;
        }
        if (cn.jiguang.g.a.a().g(2400)) {
            f.c("JBt", "not collect bluetooth data");
            return;
        }
        if (!q.b(context, "android.permission.BLUETOOTH") || !q.b(context, "android.permission.BLUETOOTH_ADMIN")) {
            f.c("JBt", "not has define permission");
            return;
        }
        if (i6 >= 23 && !q.a(context, g.f36048h) && !q.a(context, g.f36047g)) {
            f.c("JBt", "not has lt permission");
            return;
        }
        if (i6 >= 29 && !cn.jiguang.p.a.b(context)) {
            f.c("JBt", "not has lt service");
            return;
        }
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter != null && defaultAdapter.isEnabled()) {
                if (this.f3112c == null) {
                    this.f3112c = new JSONObject();
                }
                this.f3112c.put(CommonNetImpl.NAME, defaultAdapter.getName());
                this.f3112c.put("address", cn.jiguang.p.a.a(context));
                this.f3112c.put("scan_m", defaultAdapter.getScanMode());
                this.f3112c.put("state", defaultAdapter.getState());
                FutureTask futureTask = new FutureTask(new b(context));
                cn.jiguang.be.b.e(futureTask);
                ArrayMap<String, cn.jiguang.o.a> arrayMap = (ArrayMap) futureTask.get(120L, TimeUnit.SECONDS);
                if (arrayMap != null && arrayMap.size() > 0) {
                    JSONArray jSONArray = new JSONArray();
                    a(arrayMap, jSONArray);
                    if (jSONArray.length() > 0) {
                        this.f3112c.put("pls", jSONArray);
                    }
                }
                f.c("JBt", "collect bt success:" + this.f3112c);
                super.c(context, str);
                return;
            }
            f.c("JBt", "bt not enable");
        } catch (Throwable th) {
            f.i("JBt", "collect bt fail, error is " + th);
        }
    }

    @Override // cn.jiguang.m.a
    protected void d(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 31 && context.getApplicationInfo().targetSdkVersion >= 31) {
            f.c("JBt", "sdk is android 12, return");
            return;
        }
        if (cn.jiguang.g.a.a().g(2400)) {
            return;
        }
        JSONObject jSONObject = this.f3112c;
        if (jSONObject == null) {
            f.i("JBt", "there are no data to report");
            return;
        }
        cn.jiguang.be.b.a(context, jSONObject, "ble_info");
        super.d(context, str);
        f.c("JBt", str + "report success, reportData: " + this.f3112c);
        this.f3112c = null;
    }

    private a() {
    }

    private void a(ArrayMap<String, cn.jiguang.o.a> arrayMap, JSONArray jSONArray) {
        try {
            Iterator<Map.Entry<String, cn.jiguang.o.a>> it = arrayMap.entrySet().iterator();
            while (it.hasNext()) {
                cn.jiguang.o.a value = it.next().getValue();
                if (value != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("type", value.a());
                    jSONObject.put("class", value.b());
                    jSONObject.put(CommonNetImpl.NAME, TextUtils.isEmpty(value.d()) ? "" : value.d());
                    jSONObject.put("address", value.c());
                    jSONObject.put("b_state", value.e());
                    jSONObject.put("rssi", value.f());
                    jSONObject.put("uuids", cn.jiguang.p.b.a(value.g()));
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("adv_sid", value.i());
                    jSONObject2.put("adv_f", value.h());
                    jSONObject2.put(CommonNetImpl.NAME, value.j());
                    jSONObject2.put("man_id", value.k());
                    jSONObject2.put("s_data", value.l());
                    jSONObject2.put("s_uuids", cn.jiguang.p.b.a(value.m()));
                    jSONObject2.put("tpl", value.o());
                    jSONObject2.put(SocializeProtocolConstants.PROTOCOL_KEY_REQUEST_TYPE, value.n());
                    jSONObject2.put("pphy", value.p());
                    jSONObject2.put("sphy", value.q());
                    jSONObject.put("edd", jSONObject2);
                    jSONArray.put(jSONObject);
                }
            }
        } catch (Throwable th) {
            f.i("JBt", "packageJson bt fail, error is " + th);
        }
    }
}
