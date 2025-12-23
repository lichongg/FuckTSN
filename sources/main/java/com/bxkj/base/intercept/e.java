package com.bxkj.base.intercept;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.http.ResponseInterceptor;
import com.bjtsn.dylan.lifecycleobserver.LifecycleObserver;
import com.bxkj.base.BaseApp;
import com.bxkj.base.user.LoginUser;
import com.huawei.hms.framework.common.ContainerUtils;
import com.orhanobut.logger.j;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class e implements ResponseInterceptor {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends com.bjtsn.dylan.lifecycleobserver.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Dialog f16512a;

        a(Dialog dialog) {
            this.f16512a = dialog;
        }

        @Override // com.bjtsn.dylan.lifecycleobserver.b
        public void onDestroy() {
            Dialog dialog = this.f16512a;
            if (dialog != null && dialog.isShowing()) {
                this.f16512a.dismiss();
            }
            super.onDestroy();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16514a;

        b(Context context) {
            this.f16514a = context;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            LoginUser.getLoginUser().setLogin(false);
            LoginUser.getLoginUser().setToken("");
            LoginUser.getLoginUser().setUserId("");
            cn.bluemobi.dylan.base.utils.a.n().j();
            if (LoginUser.getLoginUser().getUserType() == 1) {
                this.f16514a.startActivity(new Intent().setComponent(new ComponentName(com.bxkj.student.d.f17843b, "com.bxkj.student.MainActivity")).setFlags(67108864));
                this.f16514a.startActivity(new Intent().setComponent(new ComponentName(com.bxkj.student.d.f17843b, "com.bxkj.student.personal.login.LoginActivity")).setFlags(268435456));
            } else {
                this.f16514a.startActivity(new Intent().setComponent(new ComponentName("com.bxkj.teacher", "com.bxkj.teacher.login.LoginActivity")).setFlags(67108864));
            }
        }
    }

    private void d(Context context, Dialog dialog) {
        if (context instanceof Activity) {
            new LifecycleObserver((FragmentActivity) context).c(new a(dialog));
        }
    }

    private String f(Map<String, Object> map) {
        if (map == null) {
            return "";
        }
        Set<Map.Entry<String, Object>> entrySet = map.entrySet();
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Object> entry : entrySet) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (sb.indexOf(ContainerUtils.KEY_VALUE_DELIMITER) != -1) {
                sb.append(com.snail.antifake.deviceid.e.f37542d);
            }
            sb.append(key);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(value);
        }
        return sb.toString();
    }

    @Override // cn.bluemobi.dylan.http.ResponseInterceptor
    public boolean onResponse(final Context context, int i6, String str, Map<String, Object> map, String str2) {
        if (i6 == 201) {
            if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/ispwdmod")) {
                if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/appstu/uploadGatherPhoto")) {
                    if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/runingFace/appRuningFace")) {
                        if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/callStuIdentify/userAddCallStuIdentify")) {
                            if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/face/checkUserByFace")) {
                                if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/appLearnResource/learnResourceDetailOperation")) {
                                    if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/sportRecordSetting/checkTimeOut")) {
                                        if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/appSportRecord/appAddSportRecord")) {
                                            if (!str2.equals(LoginUser.getLoginUser().getServerUrl() + "app/getSysUserByThirdId")) {
                                                new iOSOneButtonDialog(context).setMessage(str).show();
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (i6 == 601) {
            iOSOneButtonDialog iosonebuttondialog = new iOSOneButtonDialog(context);
            iosonebuttondialog.setCancelable(false);
            iosonebuttondialog.setMessage(str).show();
            return false;
        }
        if (i6 != 602) {
            if (i6 == 603) {
                new iOSOneButtonDialog(context).setMessage(str).setButtonOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.intercept.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BaseApp.c().i(context);
                    }
                }).show();
            }
            return false;
        }
        iOSOneButtonDialog iosonebuttondialog2 = new iOSOneButtonDialog(context);
        iosonebuttondialog2.setCancelable(false);
        iosonebuttondialog2.setMessage(str).show();
        iosonebuttondialog2.setButtonOnClickListener(new b(context));
        return false;
    }

    private void e(String str) {
        ((ClipboardManager) BaseApp.c().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("错误信息", str));
    }

    private String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return JsonParse.formatJson(str);
        } catch (Exception e6) {
            e6.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(StringBuilder sb, Context context) {
        e(sb.toString());
        Toast.makeText(context, "已复制到剪切板", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i(StringBuilder sb, Context context) {
        e(sb.toString());
        Toast.makeText(context, "已复制到剪切板", 0).show();
    }

    @Override // cn.bluemobi.dylan.http.ResponseInterceptor
    public void onError(final Context context, Throwable th) {
        if (!LoginUser.getLoginUser().isOpenModel()) {
            return;
        }
        j.c(th.getMessage());
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String stringWriter2 = stringWriter.toString();
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(context);
        iostwobuttondialog.setMessageGrivity(3);
        iostwobuttondialog.setLeftButtonText("复制到剪切板");
        final StringBuilder sb = new StringBuilder();
        sb.append("接口请求报错:\n" + stringWriter2);
        iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.base.intercept.d
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                e.this.h(sb, context);
            }
        });
        iostwobuttondialog.setMessage(sb).show();
        d(context, iostwobuttondialog);
    }

    @Override // cn.bluemobi.dylan.http.ResponseInterceptor
    public boolean onResponseStart(final Context context, String str, Map<String, Object> map, String str2, int i6) {
        if (!LoginUser.getLoginUser().isOpenModel()) {
            return false;
        }
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(context);
        iostwobuttondialog.setTitle("接口信息");
        iostwobuttondialog.setMessageGrivity(3);
        iostwobuttondialog.setLeftButtonText("复制到剪切板");
        final StringBuilder sb = new StringBuilder();
        sb.append("请求地址:\n" + str);
        sb.append("\n请求参数:\n" + f(map));
        sb.append("\n响应状态:" + i6);
        sb.append("\n响应数据:\n" + g(str2));
        iostwobuttondialog.setLeftButtonOnClickListener(new iOSTwoButtonDialog.LeftButtonOnClick() { // from class: com.bxkj.base.intercept.b
            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.LeftButtonOnClick
            public final void buttonLeftOnClick() {
                e.this.i(sb, context);
            }
        });
        iostwobuttondialog.setMessage(sb).show();
        d(context, iostwobuttondialog);
        return false;
    }
}
