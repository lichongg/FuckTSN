package com.tencent.connect.emotion;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.widget.Toast;
import com.huawei.hms.framework.common.ContainerUtils;
import com.stub.StubApp;
import com.tencent.connect.a;
import com.tencent.connect.auth.QQToken;
import com.tencent.connect.common.BaseApi;
import com.tencent.connect.common.Constants;
import com.tencent.connect.common.UIListenerManager;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.k;
import com.tencent.open.utils.m;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
public class QQEmotion extends BaseApi {

    /* renamed from: a, reason: collision with root package name */
    private IUiListener f40375a;

    private boolean a(Context context, ArrayList<Uri> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        if (arrayList.size() > 9) {
            SLog.i("QQEMOTION", "isLegality -->illegal, file count > 9, count = " + arrayList.size());
            return false;
        }
        long j6 = 0;
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            long a6 = m.a(context, arrayList.get(i6));
            if (a6 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                SLog.i("QQEMOTION", "isLegality -->illegal, fileSize: " + a6);
                return false;
            }
            j6 += a6;
        }
        if (j6 > 3145728) {
            SLog.i("QQEMOTION", "isLegality -->illegal, totalSize: " + j6);
            return false;
        }
        SLog.i("QQEMOTION", "isLegality -->legal, totalSize: " + j6);
        return true;
    }

    public void setEmotions(Activity activity, ArrayList<Uri> arrayList, IUiListener iUiListener) {
        if (a.a("QQEmotion", iUiListener)) {
            return;
        }
        IUiListener iUiListener2 = this.f40375a;
        if (iUiListener2 != null) {
            iUiListener2.onCancel();
        }
        this.f40375a = iUiListener;
        if (!k.b(activity)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机未安装QQ，请安装最新版QQ后再试。", 1).show();
            return;
        }
        if (k.c(activity, "8.0.0") < 0) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "当前手机QQ版本过低，不支持设置表情功能。", 1).show();
            return;
        }
        if (!a(StubApp.getOrigApplicationContext(activity.getApplicationContext()), arrayList)) {
            Toast.makeText(StubApp.getOrigApplicationContext(activity.getApplicationContext()), "图片不符合要求，不支持设置表情功能。", 1).show();
            return;
        }
        String a6 = m.a(activity);
        StringBuffer stringBuffer = new StringBuffer("mqqapi://profile/sdk_face_collection?");
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(a6)) {
            if (a6.length() > 20) {
                a6 = a6.substring(0, 20) + "...";
            }
            sb.append(a6);
            stringBuffer.append("&app_name=" + Base64.encodeToString(m.j(a6), 2));
        }
        String appId = this.f40366c.getAppId();
        String openId = this.f40366c.getOpenId();
        if (!TextUtils.isEmpty(appId)) {
            stringBuffer.append("&share_id=" + appId);
            sb.append(appId);
        }
        if (!TextUtils.isEmpty(openId)) {
            sb.append(openId);
            stringBuffer.append("&open_id=" + Base64.encodeToString(m.j(openId), 2));
        }
        stringBuffer.append("&sdk_version=" + Base64.encodeToString(m.j(Constants.SDK_VERSION), 2));
        sb.append(Constants.SDK_VERSION);
        String a7 = a(activity, arrayList);
        if (TextUtils.isEmpty(a7)) {
            iUiListener.onError(new UiError(-6, Constants.MSG_UNKNOWN_ERROR, "picPathList is null"));
            return;
        }
        sb.append(a7);
        stringBuffer.append("&set_uri_list=" + Base64.encodeToString(m.j(a7), 2));
        stringBuffer.append(ContainerUtils.FIELD_DELIMITER);
        stringBuffer.append(Constants.KEY_PPSTS);
        stringBuffer.append(ContainerUtils.KEY_VALUE_DELIMITER);
        stringBuffer.append(k.a(activity, sb.toString()));
        SLog.v("QQEMOTION", "-->set avatar, url: " + stringBuffer.toString());
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(stringBuffer.toString()));
        intent.setPackage("com.tencent.mobileqq");
        intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
        UIListenerManager.getInstance().setListenerWithRequestcode(Constants.REQUEST_EDIT_EMOTION, iUiListener);
        a(activity, Constants.REQUEST_EDIT_EMOTION, intent, false);
    }

    public QQEmotion(QQToken qQToken) {
        super(qQToken);
    }

    private String a(Activity activity, ArrayList<Uri> arrayList) {
        StringBuilder sb = new StringBuilder();
        Iterator<Uri> it = arrayList.iterator();
        while (it.hasNext()) {
            Uri a6 = m.a(activity, this.f40366c.getAppId(), m.b(activity, it.next()));
            if (a6 == null) {
                SLog.e("QQEmotion", "getFilePathListJson: grantedUri = null");
            } else {
                sb.append(a6);
                sb.append(";");
            }
        }
        String sb2 = sb.toString();
        SLog.i("QQEmotion", "-->getFilePathListJson listStr : " + sb2);
        return sb2;
    }
}
