package cn.jpush.android.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.ad.h;
import cn.jpush.android.api.InAppSlotParams;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.JPushMessage;
import cn.jpush.android.local.JPushConstants;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: D:\Downloads\app\classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static ConcurrentLinkedQueue<Long> f3679a = new ConcurrentLinkedQueue<>();

    /* renamed from: c, reason: collision with root package name */
    private static final Object f3680c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static d f3681d;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<Long, a> f3682b = new ConcurrentHashMap<>();

    private class a {

        /* renamed from: a, reason: collision with root package name */
        public int f3683a;

        /* renamed from: b, reason: collision with root package name */
        public String f3684b;

        public a(int i6, String str) {
            this.f3683a = i6;
            this.f3684b = str;
        }

        public String toString() {
            return "MobileBean{sequence=" + this.f3683a + ", mobileNumber='" + this.f3684b + "'}";
        }
    }

    private static int a(long j6) {
        if (f3679a.size() >= 3) {
            long longValue = j6 - f3679a.element().longValue();
            if (longValue < 0) {
                f3679a.clear();
                return 2;
            }
            if (longValue <= 10000) {
                return 1;
            }
            while (f3679a.size() >= 3) {
                f3679a.poll();
            }
        }
        f3679a.offer(Long.valueOf(j6));
        return 0;
    }

    public JPushMessage a(Context context, Intent intent) {
        JPushMessage jPushMessage;
        Object th;
        int intExtra;
        int intExtra2;
        String stringExtra;
        if (intent == null) {
            return null;
        }
        try {
            intExtra = intent.getIntExtra(InAppSlotParams.SLOT_KEY.SEQ, -1);
            intExtra2 = intent.getIntExtra("code", -1);
            stringExtra = intent.getStringExtra("mobile");
            jPushMessage = new JPushMessage();
        } catch (Throwable th2) {
            jPushMessage = null;
            th = th2;
        }
        try {
            jPushMessage.setSequence(intExtra);
            jPushMessage.setErrorCode(intExtra2);
            jPushMessage.setMobileNumber(stringExtra);
            return jPushMessage;
        } catch (Throwable th3) {
            th = th3;
            Logger.w("MobileNumberHelper", "parese mobile number response to JPushMessage failed, error:" + th);
            return jPushMessage;
        }
    }

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            try {
                if (f3681d == null) {
                    synchronized (f3680c) {
                        try {
                            if (f3681d == null) {
                                f3681d = new d();
                            }
                        } finally {
                        }
                    }
                }
                dVar = f3681d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return dVar;
    }

    public void a(Context context, int i6, int i7, String str) {
        try {
            Logger.d("MobileNumberHelper", "Action - onResult,sequence:" + i6 + ",code:" + i7 + ",mobileNumber:" + str);
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            Intent intent = new Intent();
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.d("MobileNumberHelper", "not found messageReceiver");
            } else {
                intent = new Intent(context, Class.forName(messageReceiverClass));
                intent.setAction("mobile_result");
                intent.putExtra(InAppSlotParams.SLOT_KEY.SEQ, i6);
                intent.putExtra("code", i7);
                intent.putExtra("mobile", str);
            }
            cn.jpush.android.helper.a.a(context, intent);
        } catch (Throwable th) {
            Logger.ww("MobileNumberHelper", "onResult error:" + th);
        }
    }

    public void a(Context context, int i6, String str) {
        Logger.dd("MobileNumberHelper", "action - setMobileNubmer, sequence:" + i6 + ",mobileNumber:" + str);
        Bundle bundle = new Bundle();
        bundle.putInt(InAppSlotParams.SLOT_KEY.SEQ, i6);
        bundle.putString("mobile", str);
        JCoreHelper.runActionWithService(context, JPushConstants.SDK_TYPE, "set_mobile", bundle);
    }

    public void a(Context context, long j6, int i6) {
        if (this.f3682b.size() != 0) {
            a remove = this.f3682b.remove(Long.valueOf(j6));
            Logger.d("MobileNumberHelper", "mobileBean:" + remove);
            if (remove == null) {
                Logger.d("MobileNumberHelper", "#unexcepted, do not find mobile number request cache");
                return;
            }
            if (i6 == 0) {
                cn.jpush.android.cache.a.a(context, remove.f3684b);
            } else if (i6 == 11) {
                i6 = JPushInterface.ErrorCode.ERROR_CODE_INTERNEL_SERVER_ERROR;
            } else if (i6 == 10) {
                i6 = JPushInterface.ErrorCode.ERROR_CODE_INVALID_MOBILENUMBER;
            }
            a(context, remove.f3683a, i6, remove.f3684b);
        }
    }

    public void a(Context context, Bundle bundle) {
        if (bundle == null) {
            Logger.ww("MobileNumberHelper", "[setMobileNum] bundle is bull");
            return;
        }
        int i6 = bundle.getInt(InAppSlotParams.SLOT_KEY.SEQ, 0);
        String string = bundle.getString("mobile");
        String f6 = cn.jpush.android.cache.a.f(context);
        Logger.dd("MobileNumberHelper", "action:setMobileNum sequence:" + i6 + ",mobileNumber:" + string + ",lastMobileNumber:" + f6);
        if (f6 != null && TextUtils.equals(string, f6)) {
            Logger.dd("MobileNumberHelper", "already set this mobile number");
            a(context, i6, JPushInterface.ErrorCode.SUCCESS, string);
            return;
        }
        if (cn.jpush.android.cache.a.b(context) == 1) {
            a(context, i6, JPushInterface.ErrorCode.PUSH_STOPED, string);
            return;
        }
        if (f6 != null) {
            cn.jpush.android.cache.a.a(context, (String) null);
        }
        int a6 = a(System.currentTimeMillis());
        if (a6 != 0) {
            Logger.w("MobileNumberHelper", a6 == 1 ? "set mobile number too soon,over 3 times in 10s" : "set mobile number failed,time shaft error，please try again");
            a(context, i6, a6 == 1 ? JPushInterface.ErrorCode.INVOKE_TOO_SOON : JPushInterface.ErrorCode.INCORRECT_TIME, string);
            return;
        }
        int c6 = h.c(string);
        if (c6 == 0) {
            byte[] a7 = cn.jpush.android.z.b.a(string);
            long a8 = f.a();
            this.f3682b.put(Long.valueOf(a8), new a(i6, string));
            JCoreHelper.sendRequest(context, JPushConstants.SDK_TYPE, 26, 1, a8, 0L, a7);
            return;
        }
        Logger.dd("MobileNumberHelper", "Invalid mobile number: " + string + ", will not set mobile number this time.");
        a(context, i6, c6, string);
    }
}
