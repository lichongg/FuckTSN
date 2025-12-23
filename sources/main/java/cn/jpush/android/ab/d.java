package cn.jpush.android.ab;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import cn.jpush.android.ad.j;
import cn.jpush.android.api.CallBackParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.api.TagAliasCallback;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.service.TagAliasReceiver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile d f3362a;

    /* renamed from: d, reason: collision with root package name */
    private static final Object f3363d = new Object();

    /* renamed from: b, reason: collision with root package name */
    private TagAliasReceiver f3364b;

    /* renamed from: c, reason: collision with root package name */
    private ConcurrentHashMap<Long, CallBackParams> f3365c = new ConcurrentHashMap<>();

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f3366e = new AtomicBoolean(false);

    public static d a() {
        if (f3362a == null) {
            synchronized (f3363d) {
                try {
                    if (f3362a == null) {
                        f3362a = new d();
                    }
                } finally {
                }
            }
        }
        return f3362a;
    }

    public ConcurrentHashMap<Long, CallBackParams> b() {
        return this.f3365c;
    }

    private void c(Context context) {
        ConcurrentHashMap<Long, CallBackParams> concurrentHashMap = this.f3365c;
        if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<Long, CallBackParams> entry : this.f3365c.entrySet()) {
            if (entry.getValue().isTimeOut(20000L)) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Long l6 = (Long) it.next();
            Logger.w("TagAliasOperator", "cleanTimeOutCallback timeout rid:" + l6);
            a(context, JPushInterface.ErrorCode.TIMEOUT, l6.longValue());
        }
    }

    public CallBackParams a(long j6) {
        return this.f3365c.get(Long.valueOf(j6));
    }

    public void b(long j6) {
        this.f3365c.remove(Long.valueOf(j6));
    }

    private d() {
    }

    public JPushMessage a(Context context, Intent intent) {
        StringBuilder sb;
        long longExtra = intent.getLongExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_SEQID, -1L);
        boolean z5 = false;
        int intExtra = intent.getIntExtra(TagAliasReceiver.KEY_TAGALIASOPERATOR_CALLBACKCODE, 0);
        Logger.v("TagAliasOperator", "parseTagAliasResponse2JPushMessage, errorCode:" + intExtra + " rid:" + longExtra);
        CallBackParams a6 = a(longExtra);
        if (a6 == null) {
            Logger.w("TagAliasOperator", "tagalias callback is null; rid=" + longExtra);
            return null;
        }
        a().b(longExtra);
        if (intExtra == 0) {
            try {
                int i6 = a6.action;
                if (i6 == 5) {
                    int i7 = a6.protoType;
                    if (i7 == 1) {
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tags");
                        if (stringArrayListExtra != null) {
                            a6.tags = new HashSet(stringArrayListExtra);
                            sb = new StringBuilder();
                            sb.append("all tags was loaded, value:");
                            sb.append(a6.tags);
                        }
                    } else if (i7 == 2) {
                        a6.alias = intent.getStringExtra("alias");
                        sb = new StringBuilder();
                        sb.append("alias was loaded, value:");
                        sb.append(a6.tags);
                    }
                    Logger.d("TagAliasOperator", sb.toString());
                } else if (i6 == 6) {
                    z5 = intent.getBooleanExtra("validated", false);
                }
            } catch (Throwable th) {
                Logger.d("TagAliasOperator", "get tag or alias failed - error:" + th);
            }
        }
        JPushMessage jPushMessage = new JPushMessage();
        jPushMessage.setProtoType(a6.protoType);
        jPushMessage.setAction(a6.action);
        jPushMessage.setErrorCode(intExtra);
        jPushMessage.setSequence(a6.sequence);
        int i8 = a6.protoType;
        if (i8 == 1) {
            if (a6.action == 6) {
                jPushMessage.setCheckTag(a(a6));
                jPushMessage.setTagCheckStateResult(z5);
                jPushMessage.setTagCheckOperator(true);
            } else {
                jPushMessage.setTags(a6.tags);
            }
        } else if (i8 == 3) {
            try {
                String stringExtra = intent.getStringExtra("message_des");
                if (TextUtils.isEmpty(stringExtra)) {
                    jPushMessage.setPros(a6.pros);
                } else {
                    HashMap hashMap = new HashMap();
                    JSONObject jSONObject = new JSONObject(stringExtra);
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject.get(next));
                    }
                    jPushMessage.setPros(hashMap);
                }
            } catch (Throwable th2) {
                Logger.d("TagAliasOperator", "pros des  failed - error:" + th2);
                jPushMessage.setPros(a6.pros);
            }
        } else {
            jPushMessage.setAlias(a6.alias);
        }
        return jPushMessage;
    }

    public synchronized void b(Context context) {
        String str;
        String str2;
        ConcurrentHashMap<Long, CallBackParams> concurrentHashMap;
        String str3;
        String str4;
        c(context);
        if (this.f3366e.get() && (concurrentHashMap = this.f3365c) != null && concurrentHashMap.isEmpty()) {
            try {
                TagAliasReceiver tagAliasReceiver = this.f3364b;
                if (tagAliasReceiver != null) {
                    context.unregisterReceiver(tagAliasReceiver);
                    this.f3364b = null;
                }
            } catch (IllegalArgumentException e6) {
                e = e6;
                str3 = "TagAliasOperator";
                str4 = "Receiver not registered, cannot call unregisterReceiver";
                Logger.ww(str3, str4, e);
                this.f3366e.set(false);
                str = "TagAliasOperator";
                str2 = "unRegister tag alias callback";
                Logger.v(str, str2);
            } catch (Exception e7) {
                e = e7;
                str3 = "TagAliasOperator";
                str4 = "other exception";
                Logger.ww(str3, str4, e);
                this.f3366e.set(false);
                str = "TagAliasOperator";
                str2 = "unRegister tag alias callback";
                Logger.v(str, str2);
            }
            this.f3366e.set(false);
            str = "TagAliasOperator";
            str2 = "unRegister tag alias callback";
        } else {
            str = "TagAliasOperator";
            str2 = "tagAliasCallbacks is not empty";
        }
        Logger.v(str, str2);
    }

    private String a(CallBackParams callBackParams) {
        if (callBackParams == null) {
            Logger.w("TagAliasOperator", "callBack was null");
            return null;
        }
        try {
            Set<String> set = callBackParams.tags;
            if (set != null && set.size() > 0) {
                return (String) callBackParams.tags.toArray()[0];
            }
        } catch (Throwable th) {
            Logger.d("TagAliasOperator", "get origin check tag failed, error:" + th);
        }
        return null;
    }

    public synchronized void a(Context context) {
        try {
            if (this.f3366e.get()) {
                Logger.d("TagAliasOperator", "tag alias callback register is called");
            } else {
                try {
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addCategory(context.getPackageName());
                    intentFilter.addAction(TagAliasReceiver.ACTION_TAG_ALIAS_TIMEOUT);
                    intentFilter.addAction(TagAliasReceiver.ACTION_TAG_ALIAS_CALLBACK);
                    if (this.f3364b == null) {
                        this.f3364b = new TagAliasReceiver();
                    }
                    j.a(context, this.f3364b, intentFilter, context.getPackageName() + JPushInterface.PUSH_MESSAGE_PERMISSION_POSTFIX, null);
                    this.f3366e.set(true);
                } catch (Exception e6) {
                    Logger.e("TagAliasOperator", "setTagAndAlias e:" + e6.getMessage());
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private void a(Context context, int i6, long j6) {
        String str;
        if (i6 == JPushInterface.ErrorCode.TIMEOUT) {
            str = "action - onTimeout rid:" + j6;
        } else {
            str = "action - on send data over limit";
        }
        Logger.v("TagAliasOperator", str);
        CallBackParams a6 = a(j6);
        if (a6 != null) {
            b(j6);
            a(context, a6, i6, false);
        } else {
            Logger.w("TagAliasOperator", "tagalias callback is null; rid=" + j6);
        }
    }

    private void a(Context context, int i6, long j6, Intent intent) {
        StringBuilder sb;
        Logger.v("TagAliasOperator", "SetAliasAndTags finish : errorCode:" + i6 + " rid:" + j6);
        CallBackParams a6 = a(j6);
        if (a6 == null) {
            Logger.w("TagAliasOperator", "tagalias callback is null; rid=" + j6);
            return;
        }
        a().b(j6);
        boolean z5 = false;
        if (intent != null) {
            try {
                int i7 = a6.action;
                if (i7 == 5) {
                    int i8 = a6.protoType;
                    if (i8 == 1) {
                        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("tags");
                        if (stringArrayListExtra != null) {
                            a6.tags = new HashSet(stringArrayListExtra);
                            sb = new StringBuilder();
                            sb.append("all tags was loaded, value:");
                            sb.append(a6.tags);
                        }
                    } else if (i8 == 2) {
                        a6.alias = intent.getStringExtra("alias");
                        sb = new StringBuilder();
                        sb.append("alias was loaded, value:");
                        sb.append(a6.tags);
                    }
                    Logger.d("TagAliasOperator", sb.toString());
                } else if (i7 == 6) {
                    z5 = intent.getBooleanExtra("validated", false);
                }
            } catch (Throwable th) {
                Logger.d("TagAliasOperator", "get tag or alias failed - error:" + th);
            }
        }
        a(context, a6, i6, z5);
    }

    public void a(Context context, long j6, int i6, Intent intent) {
        Context context2;
        Logger.v("TagAliasOperator", "action - onTagAliasResponse rid:" + j6 + " tagAliasCallbacks :" + a().b());
        if (TagAliasReceiver.ACTION_TAG_ALIAS_TIMEOUT.equals(intent.getAction())) {
            a(context, i6, j6);
            context2 = context;
        } else {
            context2 = context;
            a(context2, i6, j6, intent);
        }
        b(context2);
    }

    private void a(Context context, CallBackParams callBackParams, int i6, boolean z5) {
        Logger.d("TagAliasOperator", "action - invokeUserCallback, errorCode:" + i6 + ",callBack:" + callBackParams);
        if (callBackParams.protoType != 0) {
            Logger.w("TagAliasOperator", "new proto type do not call user callback");
            return;
        }
        TagAliasCallback tagAliasCallback = callBackParams.tagAliasCallBack;
        if (tagAliasCallback != null) {
            tagAliasCallback.gotResult(i6, callBackParams.alias, callBackParams.tags);
        }
    }

    public void a(Context context, Long l6, CallBackParams callBackParams) {
        c(context);
        this.f3365c.put(l6, callBackParams);
    }
}
