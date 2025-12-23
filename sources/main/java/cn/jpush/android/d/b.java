package cn.jpush.android.d;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import cn.jpush.android.api.CustomMessage;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.JCoreHelper;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.local.JPushConstants;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import java.io.LineNumberReader;
import java.io.StringReader;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: D:\Downloads\app\classes2.dex */
public class b {
    public static CustomMessage a(Intent intent) {
        CustomMessage customMessage = null;
        try {
            String stringExtra = intent.getStringExtra("msgid");
            CustomMessage customMessage2 = new CustomMessage();
            try {
                customMessage2.messageId = stringExtra;
                customMessage2.appId = intent.getStringExtra("appId");
                customMessage2.senderId = intent.getStringExtra("senderId");
                String stringExtra2 = intent.getStringExtra("data");
                if (stringExtra2 != null) {
                    JSONObject jSONObject = new JSONObject(stringExtra2);
                    customMessage2.message = jSONObject.optString(CrashHianalyticsData.MESSAGE, "");
                    customMessage2.contentType = jSONObject.optString("content_type", "");
                    customMessage2.title = jSONObject.optString("title", "");
                    customMessage2.extra = jSONObject.optString("extras", "");
                }
                if (JPushConstants.SDK_VERSION_CODE >= 387) {
                    customMessage2.platform = intent.getByteExtra("platform", (byte) 0);
                }
                d.a(stringExtra, intent.getStringExtra("_j_data_"));
                return customMessage2;
            } catch (Throwable th) {
                th = th;
                customMessage = customMessage2;
                Logger.w("MessageHelper", "processMessage failed:" + th.getMessage());
                return customMessage;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static cn.jpush.android.b.b a(d dVar) {
        try {
            cn.jpush.android.b.b a6 = cn.jpush.android.b.b.a(new JSONObject(dVar.f3593i).optJSONObject("geofence"));
            if (a6 == null) {
                return null;
            }
            a6.f3555t = dVar;
            return a6;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b(Context context, d dVar) {
        try {
            String messageReceiverClass = JPushConstants.getMessageReceiverClass(context);
            if (TextUtils.isEmpty(messageReceiverClass)) {
                Logger.dd("MessageHelper", "not found user push message,use old action to user");
                Intent intent = new Intent(JPushInterface.ACTION_MESSAGE_RECEIVED);
                intent.putExtra(JPushInterface.EXTRA_APP_KEY, dVar.f3587c);
                intent.putExtra(JPushInterface.EXTRA_MESSAGE, dVar.f3598n);
                intent.putExtra(JPushInterface.EXTRA_CONTENT_TYPE, dVar.f3599o);
                intent.putExtra(JPushInterface.EXTRA_TITLE, dVar.f3600p);
                intent.putExtra(JPushInterface.EXTRA_EXTRA, dVar.f3601q);
                intent.putExtra(JPushInterface.EXTRA_MSG_ID, dVar.f3588d);
                if (JPushConstants.SDK_VERSION_CODE >= 387) {
                    intent.putExtra(JPushInterface.EXTRA_TYPE_PLATFORM, dVar.ai);
                }
                intent.addCategory(dVar.f3586b);
                intent.setPackage(context.getPackageName());
                Locale locale = Locale.ENGLISH;
                context.sendBroadcast(intent, String.format(locale, "%s.permission.JPUSH_MESSAGE", dVar.f3586b));
                Logger.i("MessageHelper", "Send broadcast to app: " + String.format(locale, "%s.permission.JPUSH_MESSAGE", dVar.f3586b));
            } else {
                Intent intent2 = new Intent(context, Class.forName(messageReceiverClass));
                intent2.setAction(cn.jpush.android.ad.a.e(context, "custom_msg"));
                intent2.putExtra("data", dVar.f3593i);
                intent2.putExtra("msgid", dVar.f3588d);
                intent2.putExtra("appId", dVar.f3586b);
                intent2.putExtra("senderId", dVar.f3587c);
                intent2.putExtra("platform", dVar.ai);
                intent2.putExtra("_j_data_", dVar.f3591g);
                if (JPushConstants.getPushMessageReceiver(context) != null) {
                    JPushConstants.getPushMessageReceiver(context).onMessage(context, a(intent2));
                } else {
                    cn.jpush.android.helper.a.a(context, intent2);
                }
            }
            byte b6 = dVar.ai;
            if (b6 != 0) {
                cn.jpush.android.helper.c.a(dVar.f3588d, "", b6, 1106L, context);
            } else {
                cn.jpush.android.helper.c.a(dVar.f3588d, 1106L, context);
            }
        } catch (Throwable th) {
            Logger.e("MessageHelper", "sendBroadcastToApp error:" + th.getMessage());
        }
    }

    private static void a(Context context, int i6, long j6, long j7, String str) {
        JCoreHelper.sendData(context, JPushConstants.SDK_TYPE, 4, 3, j7, cn.jpush.android.z.b.a(0, (byte) i6, j6, str));
        try {
            int optInt = new JSONObject(str).optInt("data_msgtype");
            Logger.d("MessageHelper", " data_msgtype=" + optInt);
            if (1 == optInt || 3 == optInt || 5 == optInt) {
                cn.jpush.android.helper.c.a(j6 + "", 1108L, context);
                return;
            }
            if (32 == optInt) {
                cn.jpush.android.helper.c.a(context, j6 + "", 1000L, 4);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a(Context context, int i6, String str, String str2, String str3, long j6, byte b6) {
        if (!str2.equals(context.getPackageName())) {
            Logger.e("MessageHelper", "msg appId is not mine pkgname,appid:" + str2 + ",pkgname:" + context.getPackageName());
            return;
        }
        Logger.d("MessageHelper", "action:receivedPushMessage msgId = " + j6);
        d a6 = d.a(str, str2, str3, j6);
        if (a6 == null) {
            return;
        }
        a6.f3585a = i6;
        if (a(i6, a6)) {
            Logger.d("MessageHelper", "ssp notification, msgType: " + i6);
            return;
        }
        if (c.a(context, a6.a()) || cn.jpush.android.x.d.a(context, a6.f3588d, a6.f3592h, i6)) {
            return;
        }
        if (b6 != 0) {
            a6.ai = b6;
        }
        a6.f3585a = i6;
        cn.jpush.android.b.b a7 = a(a6);
        if (a7 != null && !TextUtils.isEmpty(a7.f3536a)) {
            cn.jpush.android.b.d.a().a(a7);
            return;
        }
        d a8 = d.a(context, a6);
        if (a8 != null) {
            Logger.dd("MessageHelper", "notify inapp message received");
            a8.f3585a = i6;
            a8.az = i6;
            cn.jpush.android.q.a.a().a(context, a6, a6.f3588d);
            return;
        }
        if (i6 == 115) {
            cn.jpush.android.q.a.a().a(context, d.a(a6), a6.f3588d);
        } else {
            a(context, a6);
        }
    }

    public static void a(Context context, d dVar) {
        Logger.d("MessageHelper", "processBasicEntity type:" + dVar.f3590f);
        int i6 = dVar.f3595k ? dVar.f3594j == 4 ? 3 : 1 : 2;
        dVar.f3590f = i6;
        if ((i6 & 2) != 0) {
            Logger.d("MessageHelper", "processBasicEntity user-defined message.");
            if (TextUtils.isEmpty(dVar.f3598n) && TextUtils.isEmpty(dVar.f3601q)) {
                Logger.ww("MessageHelper", "no message or extra send to user");
            } else {
                b(context, dVar);
            }
        }
        if ((dVar.f3590f & 1) != 0) {
            Logger.d("MessageHelper", "processBasicEntity notification");
            if (cn.jpush.android.cache.a.e(context)) {
                Logger.i("MessageHelper", "Service is stoped, give up all the message");
                return;
            }
            dVar.a(context);
            if (cn.jpush.android.x.b.b(context)) {
                cn.jpush.android.x.d.b(context, dVar.f3588d);
                cn.jpush.android.x.b.a(context, dVar);
            } else {
                cn.jpush.android.helper.c.a(dVar.f3588d, 986L, context);
                Logger.ii("MessageHelper", "push is invalidPushTime，Intercept the message");
            }
        }
    }

    public static void a(Context context, cn.jpush.android.z.c cVar) {
        String str;
        String str2;
        String d6 = d.d(cVar.c());
        a(context, cVar.a(), cVar.b(), cVar.getRid(), d6);
        long b6 = cVar.b();
        int a6 = cVar.a();
        String c6 = cVar.c();
        Logger.d("MessageHelper", "msgType = " + a6 + ", msgId = " + b6 + ", jdata = " + d6);
        StringBuilder sb = new StringBuilder();
        sb.append("msgContent: \n");
        sb.append(c6);
        Logger.v("MessageHelper", sb.toString());
        Logger.d("MessageHelper", "msgContent size:" + c6.getBytes().length);
        LineNumberReader lineNumberReader = new LineNumberReader(new StringReader(c6));
        try {
            String readLine = lineNumberReader.readLine();
            String readLine2 = lineNumberReader.readLine();
            if (readLine == null) {
                str2 = "NO appId";
            } else {
                if (readLine2 != null) {
                    int length = readLine.length() + readLine2.length();
                    int i6 = length + 2;
                    if (c6.length() > length + 3) {
                        String substring = c6.substring(i6);
                        if (readLine2.equals(JCoreHelper.getAppKey(context))) {
                            Logger.v("MessageHelper", "Message Fields - appId:" + readLine + ", senderId:" + readLine2 + ", msgContent:" + substring + ", contentLen: " + substring.length());
                            if (a6 != 0 && a6 != 2) {
                                if (a6 == 20) {
                                    cn.jpush.android.ab.b.a(context, substring, 0, -1L, -1);
                                    return;
                                }
                                if (a6 != 115 && a6 != 100 && a6 != 101 && a6 != 103 && a6 != 104) {
                                    str = "unknown msg type, type: " + a6;
                                }
                            }
                            a(context, a6, substring, readLine, readLine2, b6, (byte) 0);
                            return;
                        }
                        str2 = "msg senderId is not mine appkey,senderId:" + readLine2 + ",appkey:" + JCoreHelper.getAppKey(context);
                    } else {
                        str = "No msgContent";
                    }
                    Logger.d("MessageHelper", str);
                    return;
                }
                str2 = "NO senderId";
            }
            Logger.e("MessageHelper", str2);
        } catch (Throwable th) {
            Logger.e("MessageHelper", "Parse msgContent failed", th);
        }
    }

    public static boolean a(int i6, d dVar) {
        String str = "";
        if (dVar == null || i6 != 0) {
            return false;
        }
        try {
            JSONObject optJSONObject = new JSONObject(dVar.f3593i).optJSONObject("m_content");
            if (optJSONObject != null) {
                str = optJSONObject.optString("n_source", "");
            }
        } catch (Throwable unused) {
        }
        return TextUtils.equals(str, "ssp");
    }
}
