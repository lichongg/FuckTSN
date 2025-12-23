package com.bxkj.student.common.jpush;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import cn.jpush.android.api.JPushInterface;
import com.bxkj.base.chat.ChatActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.webview.H5DetailActivity;
import com.bxkj.student.MainActivity;
import com.bxkj.student.home.teaching.rollcall.BleSignActivity;
import com.bxkj.student.home.teaching.rollcall.term.ViewTermActivity;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.personal.customer.ContactCustomerActivity;
import com.bxkj.student.v2.ui.h5.H5AppActivity;
import com.orhanobut.logger.j;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class JPushReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    private static final String f17744a = "JPush";

    private static String a(Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        for (String str : bundle.keySet()) {
            if (str.equals(JPushInterface.EXTRA_NOTIFICATION_ID)) {
                sb.append("\nkey:" + str + ", value:" + bundle.getInt(str));
            } else if (str.equals(JPushInterface.EXTRA_CONNECTION_CHANGE)) {
                sb.append("\nkey:" + str + ", value:" + bundle.getBoolean(str));
            } else if (!str.equals(JPushInterface.EXTRA_EXTRA)) {
                sb.append("\nkey:" + str + ", value:" + bundle.getString(str));
            } else if (TextUtils.isEmpty(bundle.getString(JPushInterface.EXTRA_EXTRA))) {
                j.g(f17744a, "This message has no Extra data");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(bundle.getString(JPushInterface.EXTRA_EXTRA));
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String str2 = keys.next().toString();
                        sb.append("\nkey:" + str + ", value: [" + str2 + " - " + jSONObject.optString(str2) + "]");
                    }
                } catch (JSONException unused) {
                }
            }
        }
        return sb.toString();
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Intent intent2;
        Intent intent3;
        MainActivity mainActivity;
        try {
            Bundle extras = intent.getExtras();
            intent.getAction();
            a(extras);
            if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
                extras.getString(JPushInterface.EXTRA_REGISTRATION_ID);
                return;
            }
            if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
                extras.getString(JPushInterface.EXTRA_MESSAGE);
                return;
            }
            String string = extras.getString(JPushInterface.EXTRA_EXTRA);
            if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
                extras.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
                if (extras.containsKey(JPushInterface.EXTRA_EXTRA)) {
                    JSONObject jSONObject = new JSONObject(string);
                    if (jSONObject.has("type")) {
                        if (!"1".equals(jSONObject.getString("type"))) {
                            if (!"0".equals(jSONObject.getString("type")) || (mainActivity = (MainActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(MainActivity.class)) == null) {
                                return;
                            }
                            mainActivity.z0();
                            return;
                        }
                        ContactCustomerActivity contactCustomerActivity = (ContactCustomerActivity) cn.bluemobi.dylan.base.utils.a.n().getActivity(ContactCustomerActivity.class);
                        if (contactCustomerActivity != null) {
                            contactCustomerActivity.y0();
                        }
                        MyFragment myFragment = (MyFragment) cn.bluemobi.dylan.base.utils.a.n().o(MyFragment.class);
                        if (myFragment != null) {
                            myFragment.Z();
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            if (!JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
                if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
                    return;
                }
                if (!JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
                    intent.getAction();
                    return;
                } else {
                    intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
                    intent.getAction();
                    return;
                }
            }
            TextUtils.isEmpty(string);
            JSONObject jSONObject2 = new JSONObject(string);
            j.h(string);
            if (!jSONObject2.has("type")) {
                if (LoginUser.getLoginUser().getSysType() == 2) {
                    if (!jSONObject2.has("url") || TextUtils.isEmpty(jSONObject2.getString("url"))) {
                        intent3 = new Intent(context, (Class<?>) com.bxkj.student.v2.ui.MainActivity.class);
                    } else {
                        intent3 = new Intent(context, (Class<?>) H5AppActivity.class);
                        extras.putString("url", jSONObject2.getString("url"));
                        extras.putString("title", jSONObject2.getString("title"));
                    }
                    intent3.putExtras(extras);
                    intent3.setFlags(268435456);
                    context.startActivity(intent3);
                    return;
                }
                if (!jSONObject2.has("url") || TextUtils.isEmpty(jSONObject2.getString("url"))) {
                    intent2 = new Intent(context, (Class<?>) MainActivity.class);
                } else {
                    intent2 = new Intent(context, (Class<?>) H5DetailActivity.class);
                    extras.putString("url", jSONObject2.getString("url"));
                    extras.putString("title", jSONObject2.getString("title"));
                }
                intent2.putExtras(extras);
                intent2.setFlags(268435456);
                context.startActivity(intent2);
                return;
            }
            if ("0".equals(jSONObject2.getString("type"))) {
                Intent intent4 = new Intent(context, (Class<?>) H5DetailActivity.class);
                if (jSONObject2.has("url")) {
                    extras.putString("url", jSONObject2.getString("url"));
                    extras.putString("title", jSONObject2.getString("title"));
                }
                intent4.putExtras(extras);
                intent4.setFlags(335544320);
                context.startActivity(intent4);
                return;
            }
            if ("1".equals(jSONObject2.getString("type"))) {
                Intent intent5 = new Intent(context, (Class<?>) ContactCustomerActivity.class);
                intent5.putExtras(extras);
                intent5.setFlags(335544320);
                context.startActivity(intent5);
                return;
            }
            if ("2".equals(jSONObject2.getString("type"))) {
                Intent intent6 = new Intent();
                intent6.putExtras(extras);
                intent6.setFlags(335544320);
                if (!LoginUser.getLoginUser().isLogin()) {
                    context.startActivity(intent6.setClass(context, MainActivity.class));
                    return;
                }
                if (!LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("7") && !LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("85") && !LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("85") && !LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("130") && !LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("78") && !LoginUser.getLoginUser().getSchoolId().equalsIgnoreCase("97")) {
                    context.startActivity(intent6.setClass(context, BleSignActivity.class));
                    return;
                }
                context.startActivity(intent6.setClass(context, ViewTermActivity.class));
                return;
            }
            if ("3".equals(jSONObject2.getString("type"))) {
                try {
                    Intent intent7 = new Intent();
                    if (LoginUser.getLoginUser().isLogin()) {
                        intent7.setClass(context, ChatActivity.class);
                    } else {
                        context.startActivity(intent7.setClass(context, MainActivity.class));
                    }
                    intent7.putExtra("chatName", jSONObject2.getString("fromName"));
                    int parseInt = Integer.parseInt(jSONObject2.getString("chatType"));
                    intent7.putExtra("chatType", parseInt);
                    if (parseInt == 1) {
                        intent7.putExtra("userId", jSONObject2.getString("userId"));
                    } else {
                        intent7.putExtra("groupId", jSONObject2.getString("groupId"));
                    }
                    intent7.setFlags(335544320);
                    context.startActivity(intent7);
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        } catch (JSONException | Exception unused) {
        }
    }
}
