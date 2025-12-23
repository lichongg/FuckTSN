package cn.jpush.android.ab;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.ad.h;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.helper.f;
import cn.jpush.android.local.JPushConstants;
import cn.jpush.android.service.TagAliasReceiver;
import com.acse.ottn.l3;
import com.stub.StubApp;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<Long> f3347a = new ConcurrentLinkedQueue<>();

    private static int a(long j6) {
        if (f3347a.size() >= 10) {
            long longValue = j6 - f3347a.element().longValue();
            if (longValue < 0) {
                f3347a.clear();
                return 2;
            }
            if (longValue <= 10000) {
                return 1;
            }
            while (f3347a.size() >= 10) {
                f3347a.poll();
            }
        }
        f3347a.offer(Long.valueOf(j6));
        return 0;
    }

    private static String b(int i6) {
        switch (i6) {
            case 1:
                return "add";
            case 2:
                return l3.f4738h;
            case 3:
                return "del";
            case 4:
                return "clean";
            case 5:
                return l3.f4736f;
            case 6:
                return "valid";
            default:
                return null;
        }
    }

    private static boolean c(int i6) {
        return i6 == 2 || i6 == 3 || i6 == 5;
    }

    private static boolean d(int i6) {
        return i6 == 0 || i6 == 1 || i6 == 2;
    }

    public static long a(Context context, String str, int i6, long j6, int i7) {
        long j7;
        int i8;
        JSONObject jSONObject;
        Context context2;
        Intent a6;
        Logger.d("TagAliasHelper", "action - onRecvTagAliasCallBack");
        try {
            if (i6 == 4) {
                a.a(context, j6, i7);
                return j6;
            }
            if (i6 != 3) {
                JSONObject jSONObject2 = new JSONObject(str);
                int optInt = jSONObject2.optInt("code", JPushInterface.ErrorCode.UNKNOWN_ERROR);
                if (i6 == 0) {
                    j6 = jSONObject2.optLong(InAppSlotParams.SLOT_KEY.SEQ);
                }
                j7 = j6;
                jSONObject = jSONObject2;
                i8 = optInt;
            } else {
                j7 = j6;
                i8 = i7;
                jSONObject = null;
            }
            Intent intent = new Intent();
            if (i6 == 0) {
                intent.setAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
            } else {
                String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
                if (!TextUtils.isEmpty(messageReceiverClass)) {
                    intent = new Intent(context, Class.forName(messageReceiverClass));
                }
                intent.setAction("tag_alias_message");
                if (i6 == 1) {
                    intent.putExtra("message_type", 1);
                } else if (i6 == 3) {
                    intent.putExtra("message_type", 3);
                    intent.putExtra("message_des", str);
                } else {
                    intent.putExtra("message_type", 2);
                }
            }
            Intent intent2 = intent;
            intent2.addCategory(context.getPackageName());
            intent2.putExtra("proto_type", i6);
            intent2.setPackage(context.getPackageName());
            intent2.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, i8);
            intent2.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, j7);
            if (i6 != 3) {
                context2 = context;
                a6 = c.a().a(context2, j7, i8, jSONObject, intent2);
            } else {
                context2 = context;
                a6 = c.a().a(context2, j7, i8, intent2);
            }
            if (a6 != null) {
                cn.jpush.android.helper.a.a(context2, a6);
            }
            return j7;
        } catch (Throwable unused) {
            Logger.w("TagAliasHelper", "tagalias msgContent:" + str);
            return -1L;
        }
    }

    public static String b(Set<String> set) {
        String str = null;
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return "";
        }
        int i6 = 0;
        for (String str2 : set) {
            if (TextUtils.isEmpty(str2) || !h.a(str2)) {
                Logger.ee("TagAliasHelper", "Invalid tag: " + str2);
            } else {
                if (str != null) {
                    str2 = str + "," + str2;
                }
                i6++;
                if (i6 >= 1000) {
                    return str2;
                }
                str = str2;
            }
        }
        return str;
    }

    protected static String a(Context context, String str, long j6, int i6) {
        String jSONObject;
        if (c(i6)) {
            try {
                JSONObject a6 = a(i6);
                if (b(2, i6)) {
                    if (TextUtils.isEmpty(str)) {
                        Logger.ee("TagAliasHelper", "alias was empty. Give up action.");
                        a(context, 2, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j6);
                        return null;
                    }
                    if (!a(context, 2, str, j6)) {
                        return null;
                    }
                    a6.put("alias", str);
                }
                jSONObject = a6.toString();
                Logger.d("TagAliasHelper", "alias str:" + jSONObject);
            } catch (Throwable th) {
                Logger.w("TagAliasHelper", "alias exception:" + th);
            }
            if (!TextUtils.isEmpty(jSONObject)) {
                return jSONObject;
            }
            Logger.d("TagAliasHelper", "alias request action was empty");
            return null;
        }
        Logger.e("TagAliasHelper", "unsupport alias action type");
        a(context, 2, JPushInterface.ErrorCode.UNKNOWN_ERROR, j6);
        return null;
    }

    private static boolean b(int i6, int i7) {
        return i6 == 2 && i7 == 2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.CharSequence, java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v4, types: [org.json.JSONArray] */
    protected static String a(Context context, List<String> list, long j6, int i6, int i7, int i8) {
        String jSONObject;
        if (i6 != 0) {
            try {
                JSONObject a6 = a(i6);
                if (a(1, i6)) {
                    if (list != null && !list.isEmpty()) {
                        HashSet hashSet = new HashSet(list);
                        if (!a(context, 1, hashSet, j6)) {
                            return null;
                        }
                        Object b6 = b(hashSet);
                        if (!b(context, b6, j6, 1)) {
                            return null;
                        }
                        if (i6 != 6) {
                            b6 = new JSONArray();
                            Iterator<String> it = list.iterator();
                            while (it.hasNext()) {
                                b6.put(it.next());
                            }
                        } else if (TextUtils.isEmpty(b6)) {
                            Logger.ee("TagAliasHelper", "stags was empty. Give up action.");
                            a(context, 1, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j6);
                            return null;
                        }
                        a6.put("tags", b6);
                    }
                    Logger.ee("TagAliasHelper", "tags was empty. Give up action.");
                    a(context, 1, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j6);
                    return null;
                }
                if (i6 == 5) {
                    if (i8 == -1) {
                        i8 = 1;
                    }
                    a6.put("curr", i8);
                }
                jSONObject = a6.toString();
                Logger.d("TagAliasHelper", "tag str:" + jSONObject);
            } catch (Throwable th) {
                Logger.w("TagAliasHelper", "tag exception:" + th);
            }
            if (!TextUtils.isEmpty(jSONObject)) {
                return jSONObject;
            }
            Logger.d("TagAliasHelper", "tag request action was empty");
            return null;
        }
        Logger.e("TagAliasHelper", "unsupport tag action type");
        a(context, 1, JPushInterface.ErrorCode.UNKNOWN_ERROR, j6);
        return null;
    }

    private static boolean b(Context context, String str, long j6, int i6) {
        if (str != null) {
            if (!a(str.replaceAll(",", ""), i6 != 0)) {
                a(context, i6, JPushInterface.ErrorCode.TOO_LONG_TAGALIAS, j6);
                StringBuilder sb = new StringBuilder();
                sb.append("The length of tags should be less than ");
                sb.append(i6 != 0 ? 5000 : 7000);
                sb.append(" bytes.");
                Logger.ww("TagAliasHelper", sb.toString());
                return false;
            }
        }
        return true;
    }

    private static String a(Context context, List<String> list, String str, long j6) {
        String jSONObject;
        HashSet hashSet = list != null ? new HashSet(list) : null;
        if (str != null && !a(context, 0, str, j6)) {
            return null;
        }
        if (hashSet != null && !a(context, 0, hashSet, j6)) {
            return null;
        }
        String b6 = b(hashSet);
        if (!b(context, b6, j6, 0)) {
            return null;
        }
        if (b6 == null && str == null) {
            Logger.ee("TagAliasHelper", "NULL alias and tags. Give up action.");
            a(context, 0, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j6);
            return null;
        }
        Logger.dd("TagAliasHelper", "action:setAliasAndTags - alias:" + str + ", tags:" + b6);
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("platform", "a");
            if (str != null) {
                jSONObject2.put("alias", str);
            }
            if (hashSet != null) {
                jSONObject2.put("tags", b6);
            }
            jSONObject = jSONObject2.toString();
            Logger.d("TagAliasHelper", "tagalias str:" + jSONObject);
        } catch (Throwable th) {
            Logger.w("TagAliasHelper", "tagalias exception:" + th);
            a(context, 0, JPushInterface.ErrorCode.UNKNOWN_ERROR, j6);
        }
        if (!TextUtils.isEmpty(jSONObject)) {
            return jSONObject;
        }
        Logger.d("TagAliasHelper", "tagalias request action was empty");
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.String] */
    protected static String a(Context context, Map<String, Object> map, long j6, int i6) {
        JSONObject jSONObject;
        ?? r7;
        Object obj;
        long j7;
        Context context2;
        JSONObject jSONObject2;
        StringBuilder sb;
        long j8;
        Context context3;
        if (d(i6)) {
            try {
                jSONObject2 = new JSONObject();
                jSONObject = new JSONObject();
            } catch (Throwable th) {
                th = th;
                jSONObject = context;
                r7 = j6;
            }
            try {
            } catch (Throwable th2) {
                obj = th2;
                context2 = context;
                j7 = j6;
                Logger.w("TagAliasHelper", "pros exception:" + obj);
                context3 = context2;
                j8 = j7;
                a(context3, 3, JPushInterface.ErrorCode.UNKNOWN_ERROR, j8);
                return null;
            }
            if (i6 == 2) {
                return jSONObject2.toString();
            }
            if (map.isEmpty()) {
                Logger.ee("TagAliasHelper", "pros was empty. Give up action.");
                a(context, 3, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j6);
                return null;
            }
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                String key = entry.getKey();
                if (TextUtils.isEmpty(key)) {
                    Logger.ee("TagAliasHelper", "pros key was empty. Give up action.");
                    a(context, 3, JPushInterface.ErrorCode.NULL_TAGANDALIAS, j6);
                    return null;
                }
                Object value = entry.getValue();
                r7 = "";
                if (!(value instanceof Integer) && !(value instanceof Boolean)) {
                    if (value instanceof Date) {
                        sb = new StringBuilder();
                        sb.append(((Date) value).getTime());
                        sb.append("");
                        value = sb.toString();
                        jSONObject2.put(key, value);
                    } else if (value instanceof String) {
                        jSONObject2.put(key, value);
                    } else {
                        jSONObject.put(key, value);
                    }
                }
                sb = new StringBuilder();
                sb.append(value);
                sb.append("");
                value = sb.toString();
                jSONObject2.put(key, value);
            }
            String jSONObject3 = jSONObject.toString();
            try {
            } catch (Throwable th3) {
                th = th3;
                obj = th;
                context2 = jSONObject;
                j7 = r7;
                Logger.w("TagAliasHelper", "pros exception:" + obj);
                context3 = context2;
                j8 = j7;
                a(context3, 3, JPushInterface.ErrorCode.UNKNOWN_ERROR, j8);
                return null;
            }
            if (!TextUtils.isEmpty(jSONObject3) && !jSONObject3.equals("{}")) {
                a(context, jSONObject3, 3, j6, JPushInterface.ErrorCode.ERROR_CODE_PROPERTY_ERROR);
                return null;
            }
            if (!TextUtils.isEmpty(jSONObject2.toString())) {
                return jSONObject2.toString();
            }
            Logger.d("TagAliasHelper", "pros request action was empty");
            return null;
        }
        context3 = context;
        j8 = j6;
        Logger.e("TagAliasHelper", "unsupport pros action type");
        a(context3, 3, JPushInterface.ErrorCode.UNKNOWN_ERROR, j8);
        return null;
    }

    public static Set<String> a(Set<String> set) {
        if (set == null) {
            return null;
        }
        if (set.isEmpty()) {
            return set;
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i6 = 0;
        for (String str : set) {
            if (TextUtils.isEmpty(str) || !h.a(str)) {
                Logger.ee("TagAliasHelper", "Invalid tag : " + str);
            } else {
                linkedHashSet.add(str);
                i6++;
                if (i6 >= 1000) {
                    Logger.ww("TagAliasHelper", "The lenght of tags maybe more than 1000.");
                    return linkedHashSet;
                }
            }
        }
        return linkedHashSet;
    }

    private static JSONObject a(int i6) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("platform", "a");
        jSONObject.put("op", b(i6));
        return jSONObject;
    }

    public static void a(Context context, int i6, int i7, long j6) {
        a(context, i6, i7, j6, -1);
    }

    public static void a(Context context, int i6, int i7, long j6, int i8) {
        try {
            if (i6 == 4) {
                a.a(context, i7, i8);
                return;
            }
            Intent intent = new Intent();
            intent.addCategory(context.getPackageName());
            intent.setPackage(context.getPackageName());
            if (i6 == 0) {
                intent.setAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
            } else {
                intent.setAction("tag_alias_message");
                intent.setClass(context, Class.forName(JPushConstants.getMessageReceiverClass(context)));
                int i9 = 1;
                if (i6 != 1) {
                    i9 = 3;
                    if (i6 != 3) {
                        intent.putExtra("message_type", 2);
                    }
                }
                intent.putExtra("message_type", i9);
            }
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, i7);
            intent.putExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, j6);
            cn.jpush.android.helper.a.a(context, intent);
        } catch (Throwable th) {
            Logger.ww("TagAliasHelper", "NotifyTagAliasError:" + th.getMessage());
        }
    }

    protected static void a(Context context, int i6, long j6, String str) {
        Logger.dd("TagAliasHelper", "tagalias:" + str);
        if (str == null) {
            Logger.w("TagAliasHelper", "tagaliasRequest was null");
        } else {
            int i7 = i6 == 0 ? 10 : i6 == 1 ? 28 : 29;
            JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, i7, i6 == 0 ? 4 : i6 == 1 ? 1 : 2, j6, 20000L, cn.jpush.android.z.b.a(JCoreHelper.getAppKey(context), i7, str));
        }
    }

    protected static void a(Context context, long j6, int i6) {
        Logger.dd("TagAliasHelper", " protoType=" + i6);
        JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 40, 1, j6, 20000L, cn.jpush.android.z.b.a(i6));
    }

    protected static void a(Context context, long j6, String str, int i6) {
        Logger.dd("TagAliasHelper", "pros:" + str + " protoType=" + i6);
        if (str != null) {
            JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 38, 0, j6, 20000L, cn.jpush.android.z.b.a(i6, str));
        } else {
            Logger.w("TagAliasHelper", "prosRequest was null");
        }
    }

    public static void a(Context context, Bundle bundle) {
        int i6;
        int i7;
        int i8;
        ArrayList<String> arrayList;
        String a6;
        String str;
        String str2;
        Context context2;
        int i9;
        int i10;
        int i11;
        int i12;
        String str3;
        int i13;
        int i14;
        String string = bundle.getString("alias");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("tags");
        CallBackParams callBackParams = (CallBackParams) bundle.getSerializable("callback");
        long j6 = bundle.getLong(RtspHeaders.Values.SEQ, 0L);
        try {
            i6 = Integer.parseInt(bundle.getString("proto_type"));
        } catch (Throwable th) {
            Logger.w("TagAliasHelper", "load tag/alias proto type failed - error:" + th);
            a(context, 0, JPushInterface.ErrorCode.UNKNOWN_ERROR, j6);
            i6 = 0;
        }
        try {
            i7 = Integer.parseInt(bundle.getString("action_type"));
        } catch (Throwable th2) {
            Logger.w("TagAliasHelper", "load tag/alias action type failed - error:" + th2);
            a(context, i6, JPushInterface.ErrorCode.UNKNOWN_ERROR, j6);
            i7 = 0;
        }
        if (i6 != 4 || !cn.jpush.android.cache.a.b(context, 0)) {
            if (cn.jpush.android.cache.a.e(context)) {
                a(context, i6, JPushInterface.ErrorCode.PUSH_STOPED, j6, i7);
                return;
            }
            int i15 = i7;
            int i16 = i6;
            int a7 = a(System.currentTimeMillis());
            if (a7 != 0) {
                Logger.w("TagAliasHelper", a7 == 1 ? "set tags/alias too soon,over 10 times in 10s" : "set tags/alias failed,time shaft error，please try again");
                a(context, i16, a7 == 1 ? JPushInterface.ErrorCode.INVOKE_TOO_SOON : JPushInterface.ErrorCode.INCORRECT_TIME, j6, i15);
                return;
            }
            long j7 = j6;
            if (c.a().a(context, i16, j6, i15)) {
                a(context, i16, JPushInterface.ErrorCode.ERROR_CODE_SERVER_UNAVAILABLE, j7, i15);
                return;
            }
            if (i16 == 0) {
                Logger.d("TagAliasHelper", "old tag/alias proto");
                i8 = i15;
                a6 = a(context, stringArrayList, string, j7);
                arrayList = stringArrayList;
            } else if (i16 == 1) {
                arrayList = stringArrayList;
                a6 = a(context, arrayList, j7, i15, -1, -1);
                i8 = i15;
                j7 = j7;
            } else {
                i8 = i15;
                arrayList = stringArrayList;
                a6 = i16 == 2 ? a(context, string, j7, i8) : i16 == 3 ? a(context, callBackParams.pros, j7, i8) : null;
            }
            Logger.d("TagAliasHelper", "onPushServiceTagAliasAction request=" + a6);
            if (a6 == null || !(i16 == 1 || i16 == 2)) {
                str = a6;
                str2 = string;
                context2 = context;
                i9 = i16;
            } else {
                if (!c.a().a(i16)) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(i16 == 1 ? CommonNetImpl.TAG : "alias");
                    sb.append(" is operatoring, please wait last operator complete");
                    Logger.w("TagAliasHelper", sb.toString());
                    a(context, i16, i16 == 1 ? JPushInterface.ErrorCode.ERROR_CODE_TAG_OPERATORING : JPushInterface.ErrorCode.ERROR_CODE_ALIAS_OPERATORING, j7);
                    return;
                }
                long j8 = j7;
                ArrayList<String> arrayList2 = arrayList;
                int i17 = i8;
                str = a6;
                str2 = string;
                context2 = context;
                i9 = i16;
                c.a().a(i9, i17, j8, arrayList2, str2, null);
                i8 = i17;
                arrayList = arrayList2;
                j7 = j8;
            }
            if (str == null || i9 != 3) {
                i10 = i9;
                i11 = i8;
            } else {
                if (!c.a().a(i9)) {
                    Logger.w("TagAliasHelper", "pros is operatoring, please wait last operator complete");
                    a(context2, i9, JPushInterface.ErrorCode.ERROR_CODE_PROPERTIES_OPERATORING, j7);
                    return;
                }
                long j9 = j7;
                ArrayList<String> arrayList3 = arrayList;
                int i18 = i8;
                c.a().a(i9, i18, j9, arrayList3, str2, callBackParams.pros);
                i11 = i18;
                j7 = j9;
                i10 = i9;
            }
            if (i10 != 4) {
                i12 = i10;
                str3 = str;
                i13 = 3;
                i14 = 4;
            } else if (!c.a().a(i10)) {
                Logger.w("TagAliasHelper", "push status is operatoring, please wait last operator complete");
                a(context2, i10, JPushInterface.ErrorCode.ERROR_CODE_PROPERTIES_OPERATORING, j7, i11);
                return;
            } else {
                str3 = str;
                i12 = i10;
                i13 = 3;
                i14 = 4;
                c.a().a(i12, i11, j7, null, null, null);
            }
            if (i12 == i13) {
                a(context2, j7, str3, callBackParams.action);
                return;
            } else if (i12 == i14) {
                a(context2, j7, callBackParams.action);
                return;
            } else {
                a(context2, i12, j7, str3);
                return;
            }
        }
        a.a(context, 1, i7);
    }

    public static void a(Context context, String str, Set<String> set, CallBackParams callBackParams) {
        int i6;
        long a6 = f.a();
        if (callBackParams != null) {
            d.a().a(context, Long.valueOf(a6), callBackParams);
        }
        if (!(context instanceof Application)) {
            context = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        if (callBackParams != null && callBackParams.protoType == 0) {
            d.a().a(context);
        }
        Bundle bundle = new Bundle();
        bundle.putString("alias", str);
        bundle.putStringArrayList("tags", set != null ? new ArrayList<>(set) : null);
        if (callBackParams != null && (((i6 = callBackParams.protoType) == 3 && callBackParams.pros != null) || i6 == 4)) {
            bundle.putSerializable("callback", callBackParams);
        }
        bundle.putLong(RtspHeaders.Values.SEQ, a6);
        StringBuilder sb = new StringBuilder();
        sb.append(callBackParams != null ? callBackParams.protoType : 0);
        sb.append("");
        bundle.putString("proto_type", sb.toString());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(callBackParams != null ? callBackParams.action : 0);
        sb2.append("");
        bundle.putString("action_type", sb2.toString());
        Logger.d("TagAliasHelper", "setAliasAndTags bundle=" + bundle);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "tagalis", bundle);
    }

    private static boolean a(int i6, int i7) {
        if (i6 == 1) {
            return i7 == 1 || i7 == 2 || i7 == 3 || i7 == 6;
        }
        return false;
    }

    private static boolean a(Context context, int i6, String str, long j6) {
        int b6 = h.b(str);
        if (b6 == 0) {
            return true;
        }
        Logger.dd("TagAliasHelper", "Invalid alias: " + str + ", will not set alias this time.");
        a(context, i6, b6, j6);
        return false;
    }

    private static boolean a(Context context, int i6, Set<String> set, long j6) {
        int a6 = h.a(set);
        if (a6 == 0) {
            return true;
        }
        Logger.dd("TagAliasHelper", "Invalid tags, will not set tags this time.");
        a(context, i6, a6, j6);
        return false;
    }

    private static boolean a(String str, boolean z5) {
        int length = !TextUtils.isEmpty(str) ? str.getBytes().length : 0;
        Logger.v("TagAliasHelper", "tags length:" + length);
        return z5 ? length <= 5000 : length <= 7000;
    }
}
