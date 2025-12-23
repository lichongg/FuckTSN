package cn.jiguang.bi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jiguang.ap.a;
import cn.jiguang.api.JDispatchAction;
import cn.jiguang.internal.ActionManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.api.JPushInterface;
import com.huawei.hms.common.util.Logger;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap<String, JDispatchAction> f2219a;

    /* renamed from: cn.jiguang.bi.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private static final b f2220a = new b(null);
    }

    private b() {
        f2219a = ActionManager.getDispatchActionMap();
        cn.jiguang.bb.f.c("DispatchActionManager", "actiom map :" + f2219a);
        cn.jiguang.bb.f.c("DispatchActionManager", "actiom map size :" + f2219a.size());
        a(JConstants.SDK_TYPE, cn.jiguang.c.a.class.getCanonicalName());
    }

    public static b a() {
        return a.f2220a;
    }

    public byte b(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object beforLogin = value.beforLogin(context, entry.getKey(), 27, "platformtype");
                if (beforLogin instanceof Byte) {
                    return ((Byte) beforLogin).byteValue();
                }
            }
        }
        return (byte) 0;
    }

    public String c(Context context) {
        for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                Object beforLogin = value.beforLogin(context, entry.getKey(), 27, "platformregid");
                if (beforLogin instanceof String) {
                    return (String) beforLogin;
                }
            }
        }
        return "";
    }

    /* synthetic */ b(AnonymousClass1 anonymousClass1) {
        this();
    }

    private static int b(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        String[] split = str.split("\\.");
        return (Integer.parseInt(split[0]) << 16) + (Integer.parseInt(split[1]) << 8) + Integer.parseInt(split[2]);
    }

    public Object a(Context context, String str, int i6) {
        String str2;
        if (JConstants.SDK_VERSION_INT <= 284) {
            return null;
        }
        JDispatchAction jDispatchAction = f2219a.get(str);
        if (jDispatchAction != null) {
            Object dataByCmd = jDispatchAction.getDataByCmd(context, i6);
            if (dataByCmd != null) {
                return dataByCmd;
            }
            str2 = str + " sdk action data:" + dataByCmd + ", actionType: " + i6;
        } else {
            str2 = str + " sdk action is null";
        }
        cn.jiguang.bb.f.a("DispatchActionManager", str2);
        return null;
    }

    public short c() {
        short loginFlag;
        short s5 = 0;
        for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (loginFlag = value.getLoginFlag(entry.getKey())) != 0) {
                s5 = (short) (s5 | loginFlag);
            }
        }
        return s5;
    }

    public Map<Integer, Bundle> d() {
        int i6;
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
            Bundle pInfo = entry.getValue().getPInfo(entry.getKey());
            if (pInfo != null && (i6 = pInfo.getInt("pid", 0)) > 0) {
                hashMap.put(Integer.valueOf(i6), pInfo);
            }
        }
        return hashMap;
    }

    public String e() {
        String sdkVersion;
        StringBuilder sb = new StringBuilder();
        short s5 = 3;
        for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
            short regPriority = entry.getValue().getRegPriority(entry.getKey());
            if (s5 < regPriority) {
                s5 = regPriority;
            }
        }
        cn.jiguang.bb.f.c("DispatchActionManager", "max reg priority: " + ((int) s5));
        for (int i6 = 0; i6 <= s5; i6++) {
            if (i6 == 3) {
                sdkVersion = cn.jiguang.a.a.f1444b;
            } else {
                for (Map.Entry<String, JDispatchAction> entry2 : f2219a.entrySet()) {
                    JDispatchAction value = entry2.getValue();
                    if (value.getRegPriority(entry2.getKey()) == i6) {
                        sdkVersion = value.getSdkVersion(entry2.getKey());
                    }
                }
            }
            sb.append(sdkVersion);
            sb.append(Logger.f33116c);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public String f() {
        StringBuilder sb = new StringBuilder();
        sb.append(b(cn.jiguang.a.a.f1444b));
        sb.append(Logger.f33116c);
        short s5 = 0;
        for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
            s5 = (short) Math.max((int) s5, (int) entry.getValue().getLogPriority(entry.getKey()));
        }
        cn.jiguang.bb.f.c("DispatchActionManager", "max login priority: " + ((int) s5));
        for (int i6 = 1; i6 <= s5; i6++) {
            Iterator<Map.Entry<String, JDispatchAction>> it = f2219a.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry<String, JDispatchAction> next = it.next();
                    JDispatchAction value = next.getValue();
                    if (value.getLogPriority(next.getKey()) == i6) {
                        sb.append(b(value.getSdkVersion(next.getKey())));
                        sb.append(Logger.f33116c);
                        break;
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public JSONArray a(Context context) {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(a.C0025a.a(1, cn.jiguang.ap.a.a(), cn.jiguang.ap.a.e()));
        if (JConstants.SDK_VERSION_INT > 284) {
            Iterator<Map.Entry<String, JDispatchAction>> it = f2219a.entrySet().iterator();
            while (it.hasNext()) {
                try {
                    JDispatchAction value = it.next().getValue();
                    Object dataByCmd = value.getDataByCmd(context, 30003);
                    if (dataByCmd instanceof Integer) {
                        Object dataByCmd2 = value.getDataByCmd(context, 30004);
                        Object dataByCmd3 = value.getDataByCmd(context, 30005);
                        if ((dataByCmd2 instanceof Integer) && (dataByCmd3 instanceof Integer)) {
                            jSONArray.put(a.C0025a.a(((Integer) dataByCmd).intValue(), ((Integer) dataByCmd2).intValue(), ((Integer) dataByCmd3).intValue()));
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
        return jSONArray;
    }

    public String b(int i6) {
        for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && value.getRegPriority(entry.getKey()) == i6) {
                return value.getSdkVersion(entry.getKey());
            }
        }
        return "";
    }

    public void a(Context context, int i6, int i7, String str) {
        Context context2;
        int i8;
        int i9;
        String str2;
        for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                context2 = context;
                i8 = i6;
                i9 = i7;
                str2 = str;
                value.onEvent(context2, entry.getKey(), i8, i9, str2);
            } else {
                context2 = context;
                i8 = i6;
                i9 = i7;
                str2 = str;
            }
            context = context2;
            i6 = i8;
            i7 = i9;
            str = str2;
        }
        b(context, i6, i7, str);
    }

    public String b(String str, String str2) {
        String str3;
        JDispatchAction jDispatchAction = f2219a.get(str);
        if (jDispatchAction != null) {
            String sdkVersion = jDispatchAction.getSdkVersion(str);
            if (!TextUtils.isEmpty(sdkVersion)) {
                return sdkVersion;
            }
            str3 = str + " sdk action sdkversion:" + sdkVersion;
        } else {
            str3 = str + " sdk action is null";
        }
        cn.jiguang.bb.f.a("DispatchActionManager", str3);
        return str2;
    }

    public void a(Context context, cn.jiguang.bk.c cVar, ByteBuffer byteBuffer) {
        if (cVar == null) {
            cn.jiguang.bb.f.i("DispatchActionManager", "Action - dispatchMessage unexcepted - head was null");
            return;
        }
        d a6 = i.a().a(cVar.f2313e);
        if (a6 == null) {
            Context context2 = context;
            for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
                JDispatchAction value = entry.getValue();
                if (value != null && value.isSupportedCMD(entry.getKey(), cVar.f2311c)) {
                    value.dispatchMessage(context2, entry.getKey(), cVar.f2311c, cVar.f2310b, cVar.f2313e, -1L, byteBuffer);
                }
                context2 = context;
            }
            return;
        }
        cn.jiguang.bb.f.c("DispatchActionManager", "dispacth msg with reuqest :" + a6);
        JDispatchAction jDispatchAction = f2219a.get(a6.f2223c);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchMessage(context, a6.f2223c, cVar.f2311c, cVar.f2310b, cVar.f2313e, a6.f2222b, byteBuffer);
        }
        Bundle bundle = new Bundle();
        bundle.putLong("rid", cVar.f2313e);
        g.a().a(context, "tcp_a7", bundle);
    }

    public short b() {
        short regFlag;
        short s5 = 0;
        for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null && (regFlag = value.getRegFlag(entry.getKey())) != 0) {
                s5 = (short) (s5 | regFlag);
            }
        }
        return s5;
    }

    private void b(Context context, int i6, int i7, String str) {
        Intent intent;
        try {
            if (i6 == 0 && i7 == 0) {
                intent = new Intent(JPushInterface.ACTION_REGISTRATION_ID);
                intent.putExtra(JPushInterface.EXTRA_REGISTRATION_ID, str);
            } else {
                if (i6 != -1 && i6 != 1) {
                    intent = null;
                }
                Intent intent2 = new Intent(JPushInterface.ACTION_CONNECTION_CHANGE);
                if (i6 == -1) {
                    intent2.putExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                } else {
                    intent2.putExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, true);
                }
                intent = intent2;
            }
            if (intent != null) {
                String packageName = context.getPackageName();
                intent.addCategory(packageName);
                intent.setPackage(packageName);
                cn.jiguang.bz.a.a(context, intent);
            }
        } catch (Throwable th) {
            cn.jiguang.bb.f.i("DispatchActionManager", "sendToOldPushUser failed:" + th.getMessage());
        }
    }

    public void a(Context context, String str, long j6, int i6) {
        if (!TextUtils.isEmpty(str) && str.equals(JConstants.SDK_TYPE)) {
            if (i6 == 26) {
                j.a().b(context, j6);
                return;
            } else {
                if (i6 != 41) {
                    return;
                }
                cn.jiguang.bb.f.d("DispatchActionManager", "setCountry time out");
                g.a().a(context, "tcp_a25", new Bundle());
                return;
            }
        }
        JDispatchAction jDispatchAction = f2219a.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.dispatchTimeOutMessage(context, str, j6, i6);
            return;
        }
        cn.jiguang.bb.f.i("DispatchActionManager", "not found dispatch action by sdktype:" + str);
    }

    public void a(Context context, String str, Bundle bundle) {
        if (bundle == null) {
            cn.jiguang.bb.f.j("DispatchActionManager", "run action bundle is null");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            cn.jiguang.bb.f.j("DispatchActionManager", "run action sdktype is empty");
            return;
        }
        if (JConstants.SDK_TYPE.contains(str)) {
            str = JConstants.SDK_TYPE;
        }
        JDispatchAction jDispatchAction = f2219a.get(str);
        if (jDispatchAction != null) {
            jDispatchAction.onActionRun(context, str, bundle.getString("internal_action"), bundle);
            return;
        }
        cn.jiguang.bb.f.j("DispatchActionManager", "dispacth action is null by sdktype:" + str);
    }

    public void a(String str, String str2) {
        cn.jiguang.bb.f.c("DispatchActionManager", "addAction type:" + str + ",action:" + str2);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        if (f2219a.containsKey(str)) {
            cn.jiguang.bb.f.c("DispatchActionManager", "has same type action");
            return;
        }
        try {
            Object newInstance = Class.forName(str2).newInstance();
            if (!(newInstance instanceof JDispatchAction)) {
                cn.jiguang.bb.f.i("DispatchActionManager", "this action is not a JDispatchAction,please check and extends JDispatchAction");
                return;
            }
            f2219a.put(str, (JDispatchAction) newInstance);
            cn.jiguang.bb.f.c("DispatchActionManager", "action init:" + newInstance.getClass().getName());
        } catch (Throwable th) {
            cn.jiguang.bb.f.j("DispatchActionManager", "#unexcepted - instance " + str2 + " class failed:" + th);
        }
    }

    public boolean a(int i6) {
        for (Map.Entry<String, JDispatchAction> entry : f2219a.entrySet()) {
            JDispatchAction value = entry.getValue();
            if (value != null) {
                try {
                    cn.jiguang.bb.f.d("DispatchActionManager", "isAllowAction actionType:" + i6 + ",sdktype:" + entry.getKey() + ",action:" + value.checkAction(entry.getKey(), i6));
                    if (!value.checkAction(entry.getKey(), i6)) {
                        return false;
                    }
                } catch (Throwable th) {
                    cn.jiguang.bb.f.i("DispatchActionManager", "isAllowAction error:" + th.getMessage());
                }
            }
        }
        return true;
    }

    public boolean a(String str) {
        return f2219a.get(str) != null;
    }
}
