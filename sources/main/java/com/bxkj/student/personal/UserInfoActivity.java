package com.bxkj.student.personal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import com.bigkoo.pickerview.b;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.util.x;
import com.bxkj.base.v2.common.utils.b0;
import com.bxkj.base.v2.common.utils.g0;
import com.bxkj.student.R;
import com.bxkj.student.common.view.ToggleButton;
import com.bxkj.student.main.MyFragment;
import com.bxkj.student.personal.UserInfoActivity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.kuaishou.weapon.p0.t;
import com.stub.StubApp;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.yalantis.ucrop.b;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.n1;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class UserInfoActivity extends BaseActivity {

    /* renamed from: b1, reason: collision with root package name */
    private static final int f19558b1 = 221;

    /* renamed from: c1, reason: collision with root package name */
    private static final String f19559c1 = "temp_photo.jpg";
    private TextView F0;
    private EditText G0;
    private EditText H0;
    private TextView I0;
    private EditText J0;
    private Button K0;
    private ToggleButton L0;
    private ToggleButton M0;
    private ImageView N0;
    private ImageView O0;
    private TextView P0;
    private TextView Q0;
    private ImageView R0;
    private TextView S0;
    private File U0;
    private String V0;
    private TextView W;
    private String W0;
    private TextView X;
    private String X0;
    private TextView Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19560a0;

    /* renamed from: b0, reason: collision with root package name */
    private TextView f19562b0;

    /* renamed from: c0, reason: collision with root package name */
    private TextView f19563c0;

    /* renamed from: k0, reason: collision with root package name */
    private TextView f19564k0;

    /* renamed from: p0, reason: collision with root package name */
    private TextView f19565p0;
    private final int T0 = 204;
    private List<Map<String, Object>> Y0 = new ArrayList();
    private List<Map<String, Object>> Z0 = new ArrayList();

    /* renamed from: a1, reason: collision with root package name */
    UMAuthListener f19561a1 = new e();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserInfoActivity.this.M0.toggle();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            UserInfoActivity.this.L0.toggle();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends HttpCallBack {
        c() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).T).setMessage("上传失败，请重新再试").show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.g1(userInfoActivity.R0, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).T).setMessage(msg).show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.g1(userInfoActivity.R0, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "data"));
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.g1(userInfoActivity.R0, LoginUser.getLoginUser().getHeadImageUrl());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends HttpCallBack {
        d() {
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).T).setMessage("上传失败，请重新再试").show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.g1(userInfoActivity.R0, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).T).setMessage(msg).show();
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.g1(userInfoActivity.R0, LoginUser.getLoginUser().getHeadImageUrl());
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "data"));
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.g1(userInfoActivity.R0, LoginUser.getLoginUser().getHeadImageUrl());
            MyFragment myFragment = (MyFragment) cn.bluemobi.dylan.base.utils.a.n().o(MyFragment.class);
            if (myFragment != null) {
                myFragment.f0();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements UMAuthListener {
        e() {
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(((BaseActivity) UserInfoActivity.this).T, "您取消了绑定", 1).show();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            com.orhanobut.logger.j.c("platform=" + platform.name());
            com.orhanobut.logger.j.c("data=" + data);
            UserInfoActivity.this.l1(platform == SHARE_MEDIA.WEIXIN ? "1" : "0", data.get("openid"), data.get(CommonNetImpl.NAME), data.get("iconurl"));
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onError(SHARE_MEDIA platform, int action, Throwable t5) {
            com.orhanobut.logger.j.c(t5.getMessage());
            com.orhanobut.logger.j.c("action=" + action);
            Toast.makeText(((BaseActivity) UserInfoActivity.this).T, "绑定失败,请稍后再试", 1).show();
        }

        @Override // com.umeng.socialize.UMAuthListener
        public void onStart(SHARE_MEDIA platform) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19571a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19572b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f19573c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f19574d;

        f(final String val$finalLoginType, final String val$login_id, final String val$login_avatar, final String val$login_nickname) {
            this.f19571a = val$finalLoginType;
            this.f19572b = val$login_id;
            this.f19573c = val$login_avatar;
            this.f19574d = val$login_nickname;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            if (this.f19571a.equals("0")) {
                UserInfoActivity.this.n1();
            } else if (this.f19571a.equals("1")) {
                UserInfoActivity.this.o1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (this.f19571a.equals("0")) {
                UserInfoActivity.this.n1();
            } else if (this.f19571a.equals("1")) {
                UserInfoActivity.this.o1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if (this.f19571a.equals("0")) {
                UserInfoActivity.this.M0.setTag(this.f19572b);
                UserInfoActivity userInfoActivity = UserInfoActivity.this;
                userInfoActivity.g1(userInfoActivity.N0, this.f19573c);
                UserInfoActivity.this.Q0.setText(this.f19574d);
                return;
            }
            if (this.f19571a.equals("1")) {
                UserInfoActivity.this.L0.setTag(this.f19572b);
                UserInfoActivity userInfoActivity2 = UserInfoActivity.this;
                userInfoActivity2.g1(userInfoActivity2.O0, this.f19573c);
                UserInfoActivity.this.P0.setText(this.f19574d);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g extends HttpCallBack {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19576a;

        g(final String val$type) {
            this.f19576a = val$type;
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if ("1".equals(this.f19576a)) {
                UserInfoActivity.this.o1();
            } else if ("0".equals(this.f19576a)) {
                UserInfoActivity.this.n1();
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if ("1".equals(this.f19576a)) {
                UserInfoActivity.this.L0.setTag(null);
                UserInfoActivity.this.O0.setImageBitmap(null);
                UserInfoActivity.this.P0.setText("");
            } else if ("0".equals(this.f19576a)) {
                UserInfoActivity.this.M0.setTag(null);
                UserInfoActivity.this.N0.setImageBitmap(null);
                UserInfoActivity.this.Q0.setText("");
            }
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnFailure(Throwable ex) {
            super.netOnFailure(ex);
            if ("1".equals(this.f19576a)) {
                UserInfoActivity.this.o1();
            } else if ("0".equals(this.f19576a)) {
                UserInfoActivity.this.n1();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h extends HttpCallBack {
        h() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.Q().setVisibility(0);
            UserInfoActivity.this.h1(data);
            UserInfoActivity.this.V0 = JsonParse.getString(data, "photoUploaded");
            UserInfoActivity.this.W0 = JsonParse.getString(data, "suspId");
            UserInfoActivity.this.X0 = JsonParse.getString(data, "sysStuDetailId");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i implements CompoundButton.OnCheckedChangeListener {
        i() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            com.orhanobut.logger.j.c("tag_qq=" + isChecked);
            if (isChecked) {
                UserInfoActivity.this.b1();
            } else {
                UserInfoActivity.this.p1("0");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j implements CompoundButton.OnCheckedChangeListener {
        j() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                UserInfoActivity.this.c1();
            } else {
                UserInfoActivity.this.p1("1");
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class k extends HttpCallBack {
        k() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ n1 b(File file) {
            com.bumptech.glide.b.D(((BaseActivity) UserInfoActivity.this).T).e(file).m1(UserInfoActivity.this.R0);
            UserInfoActivity.this.W0(Uri.fromFile(file));
            return null;
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            if ("1".equals(UserInfoActivity.this.V0)) {
                b0.f16879a.r(((BaseActivity) UserInfoActivity.this).U, new Function1() { // from class: com.bxkj.student.personal.a
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        n1 b6;
                        b6 = UserInfoActivity.k.this.b((File) obj);
                        return b6;
                    }
                });
            } else {
                new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).T).setMessage("不允许重复上传，如有疑问请联系管理员").show();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class l extends HttpCallBack {
        l() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.finish();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            if (TextUtils.isEmpty(msg)) {
                msg = "服务器异常，请联系管理员";
            }
            new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class m implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f19583a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                m.this.f19583a.dismiss();
            }
        }

        m(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f19583a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f19583a.show();
            String trim = ((EditText) this.f19583a.findViewById(R.id.et_password)).getText().toString().trim();
            if (trim.isEmpty()) {
                UserInfoActivity.this.g0("密码不能为空");
                return;
            }
            try {
                Http.with(((BaseActivity) UserInfoActivity.this).T).setObservable(((e0.a) Http.getApiService(e0.a.class)).v(LoginUser.getLoginUser().getUserId(), new x().a(trim))).setDataListener(new a());
            } catch (Exception e6) {
                new iOSOneButtonDialog(((BaseActivity) UserInfoActivity.this).T).setMessage("验证密码异常，请联系管理员").show();
                e6.printStackTrace();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class n extends HttpCallBack {
        n() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.Y0 = (List) data.get("data");
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.k1(userInfoActivity.Y0, UserInfoActivity.this.f19565p0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class o extends HttpCallBack {
        o() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            UserInfoActivity.this.Z0 = (List) data.get("data");
            UserInfoActivity userInfoActivity = UserInfoActivity.this;
            userInfoActivity.k1(userInfoActivity.Z0, UserInfoActivity.this.F0);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class p implements b.InterfaceC0142b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f19588a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ List f19589b;

        p(final TextView val$textView, final List val$datas) {
            this.f19588a = val$textView;
            this.f19589b = val$datas;
        }

        @Override // com.bigkoo.pickerview.b.InterfaceC0142b
        public void a(int options1, int option2, int options3, View v5) {
            this.f19588a.setTag(JsonParse.getString((Map) this.f19589b.get(options1), "id"));
            this.f19588a.setText(JsonParse.getString((Map) this.f19589b.get(options1), CommonNetImpl.NAME));
        }
    }

    public static byte[] m1(String filename) {
        Throwable th;
        IOException iOException;
        FileChannel fileChannel;
        FileChannel fileChannel2 = null;
        try {
            fileChannel = new RandomAccessFile(filename, t.f36150k).getChannel();
        } catch (IOException e6) {
            iOException = e6;
            fileChannel = null;
        } catch (Throwable th2) {
            th = th2;
            try {
                fileChannel2.close();
                throw th;
            } catch (IOException e7) {
                e7.printStackTrace();
                throw th;
            }
        }
        try {
            try {
                MappedByteBuffer load = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0L, fileChannel.size()).load();
                com.orhanobut.logger.j.c(Boolean.valueOf(load.isLoaded()));
                byte[] bArr = new byte[(int) fileChannel.size()];
                if (load.remaining() > 0) {
                    load.get(bArr, 0, load.remaining());
                }
                try {
                    fileChannel.close();
                    return bArr;
                } catch (IOException e8) {
                    e8.printStackTrace();
                    return bArr;
                }
            } catch (Throwable th3) {
                th = th3;
                fileChannel2 = fileChannel;
                fileChannel2.close();
                throw th;
            }
        } catch (IOException e9) {
            iOException = e9;
            iOException.printStackTrace();
            try {
                fileChannel.close();
            } catch (IOException e10) {
                e10.printStackTrace();
            }
            return null;
        }
    }

    public File e1(Context context, Bitmap bmp) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        if (bmp != null && !bmp.isRecycled()) {
            File externalCacheDir = "mounted".equals(Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
            if (externalCacheDir == null || !externalCacheDir.exists()) {
                externalCacheDir = context.getCacheDir();
            }
            File file = new File(externalCacheDir, "avatar");
            boolean exists = file.exists();
            if (!exists) {
                exists = file.mkdirs();
            }
            if (exists) {
                File file2 = new File(file, "avatar" + System.currentTimeMillis() + g0.f16898c);
                try {
                    fileOutputStream = new FileOutputStream(file2);
                    try {
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                        try {
                            fileOutputStream.close();
                        } catch (IOException unused) {
                        }
                        return file2;
                    } catch (FileNotFoundException unused2) {
                        if (fileOutputStream != null) {
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream2 = fileOutputStream;
                        if (fileOutputStream2 != null) {
                            try {
                                fileOutputStream2.close();
                            } catch (IOException unused4) {
                            }
                        }
                        throw th;
                    }
                } catch (FileNotFoundException unused5) {
                    fileOutputStream = null;
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }
        return null;
    }

    private void U0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.T);
        iostwobuttondialog.setMessage("绑定手机号需要验证你的身份，请输入登录密码进行验证").setCenterCustomView(R.layout.dialog_confim_password).setRightButtonOnClickListener(new m(iostwobuttondialog)).show();
    }

    private void V0() {
        String trim = this.J0.getText().toString().trim();
        if (trim.isEmpty() || u.U(trim)) {
            Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).f1(LoginUser.getLoginUser().getUserId(), trim, this.f19565p0.getTag(), this.F0.getTag(), this.G0.getText().toString().trim(), (this.H0.isEnabled() ? this.H0.getText() : this.H0.getTag()).toString().trim(), this.W0, this.X0)).setDataListener(new l());
        } else {
            g0("请输入正确的邮箱");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(Uri uri) {
        File file;
        if (uri == null) {
            return;
        }
        if ("mounted".equals(Environment.getExternalStorageState())) {
            file = this.T.getExternalCacheDir();
            if (!file.exists()) {
                file.mkdirs();
            }
        } else {
            file = null;
        }
        if (file == null || !file.exists()) {
            file = this.T.getCacheDir();
            if (!file.exists()) {
                file.mkdirs();
            }
        }
        File file2 = new File(file, "avatar");
        if (!file2.exists()) {
            file2.mkdirs();
        }
        Uri fromFile = Uri.fromFile(new File(file2, System.currentTimeMillis() + "_" + f19559c1));
        b.a aVar = new b.a();
        aVar.D(ContextCompat.getColor(this.T, 2131099737));
        aVar.A(ContextCompat.getColor(this.T, 2131099735));
        aVar.y(ContextCompat.getColor(this.T, 2131099736));
        aVar.c(ContextCompat.getColor(this.T, 2131099731));
        com.yalantis.ucrop.b.i(uri, fromFile).s(aVar).q(9.0f, 16.0f).r(MediaPlayer.MEDIA_PLAYER_OPTION_SECURE_BUFFER_THRESHOLD, TTAdConstant.VIDEO_INFO_CODE).k(this, 69);
    }

    private void Y0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).x1()).setDataListener(new n());
    }

    private void Z0() {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).l0()).setDataListener(new o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.T);
        SHARE_MEDIA share_media = SHARE_MEDIA.QQ;
        if (uMShareAPI.isInstall(this, share_media)) {
            UMShareAPI.get(this.T).getPlatformInfo(this, share_media, this.f19561a1);
        } else {
            g0("您还未安装QQ或QQ版本过低");
            new Thread(new a()).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        UMShareAPI uMShareAPI = UMShareAPI.get(this.T);
        SHARE_MEDIA share_media = SHARE_MEDIA.WEIXIN;
        if (uMShareAPI.isInstall(this, share_media)) {
            UMShareAPI.get(this.T).getPlatformInfo(this, share_media, this.f19561a1);
        } else {
            g0("您还未安装微信或微信版本过低");
            new Thread(new b()).start();
        }
    }

    private void f1() {
        this.M0.setOnCheckedChangeListener(new i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(Map<String, Object> data) {
        String string = JsonParse.getString(data, "phone");
        LoginUser.getLoginUser().setAccount(JsonParse.getString(data, "userNum"));
        LoginUser.getLoginUser().setRealName(JsonParse.getString(data, CommonNetImpl.NAME));
        LoginUser.getLoginUser().setPhone(string);
        LoginUser.getLoginUser().setSex(JsonParse.getString(data, "sex"));
        LoginUser.getLoginUser().setSchoolName(JsonParse.getString(data, "schoolName"));
        LoginUser.getLoginUser().setHeadImageUrl(JsonParse.getString(data, "collectPhoto"));
        g1(this.R0, LoginUser.getLoginUser().getHeadImageUrl());
        this.W.setText(LoginUser.getLoginUser().getRealName());
        this.X.setText(LoginUser.getLoginUser().getAccount());
        this.Z.setText("1".equals(JsonParse.getString(data, "sex")) ? "男" : "女");
        this.Y.setText(LoginUser.getLoginUser().getSchoolName());
        this.I0.setText(LoginUser.getLoginUser().getPhone());
        this.f19560a0.setText(JsonParse.getString(data, "faculty"));
        this.f19562b0.setText(JsonParse.getString(data, "profession"));
        this.f19563c0.setText(JsonParse.getString(data, "grade"));
        this.f19564k0.setText(JsonParse.getString(data, "class"));
        this.f19565p0.setTag(JsonParse.getString(data, "nationId"));
        this.f19565p0.setText(JsonParse.getString(data, "nationName"));
        this.F0.setTag(JsonParse.getString(data, "sourceId"));
        this.F0.setText(JsonParse.getString(data, "sourceName"));
        this.G0.setText(JsonParse.getString(data, "address"));
        this.H0.setText(JsonParse.getString(data, "certificate"));
        this.J0.setText(JsonParse.getString(data, "email"));
        if (!TextUtils.isEmpty(string)) {
            this.I0.setText(string.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2") + "(更换)");
        }
        if (!JsonParse.getString(data, "weixinId").isEmpty()) {
            this.L0.setTag(JsonParse.getString(data, "weixinId"));
            this.L0.toggle();
            g1(this.O0, JsonParse.getString(data, "weixinImg"));
            this.P0.setText(JsonParse.getString(data, "weixinNickName"));
        }
        if (!JsonParse.getString(data, "qqId").isEmpty()) {
            this.M0.setTag(JsonParse.getString(data, "qqId"));
            this.M0.toggle();
            g1(this.N0, JsonParse.getString(data, "qqImg"));
            this.Q0.setText(JsonParse.getString(data, "qqNickName"));
        }
        i1();
        f1();
    }

    private void i1() {
        this.L0.setOnCheckedChangeListener(new j());
    }

    private void j1(String[] arr, int position) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, arr);
        intent.putExtra(ImagePagerActivity.S, position);
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(final List<Map<String, Object>> datas, final TextView textView) {
        com.bigkoo.pickerview.b H = new b.a(this.T, new p(textView, datas)).H();
        ArrayList arrayList = new ArrayList();
        Iterator<Map<String, Object>> it = datas.iterator();
        while (it.hasNext()) {
            arrayList.add(JsonParse.getString(it.next(), CommonNetImpl.NAME));
        }
        H.A(arrayList);
        H.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(final String finalLoginType, final String login_id, final String login_nickname, final String login_avatar) {
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).g1(LoginUser.getLoginUser().getUserId(), finalLoginType, login_id, login_nickname, login_avatar)).setDataListener(new f(finalLoginType, login_id, login_avatar, login_nickname));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1() {
        ToggleButton toggleButton = this.M0;
        if (toggleButton != null) {
            toggleButton.setOnCheckedChangeListener(null);
            this.M0.toggle();
            f1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1() {
        ToggleButton toggleButton = this.L0;
        if (toggleButton != null) {
            toggleButton.setOnCheckedChangeListener(null);
            this.L0.toggle();
            i1();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(final String type) {
        if ("1".equals(type)) {
            if (this.L0.getTag() == null || u.b0((String) this.L0.getTag())) {
                return;
            }
        } else if ("0".equals(type) && (this.M0.getTag() == null || u.b0((String) this.M0.getTag()))) {
            return;
        }
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).a1(type, LoginUser.getLoginUser().getUserId())).setDataListener(new g(type));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f19565p0.setOnClickListener(this);
        this.F0.setOnClickListener(this);
        this.I0.setOnClickListener(this);
        this.K0.setOnClickListener(this);
        this.S0.setOnClickListener(this);
        this.R0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("个人资料");
    }

    public void a1(Context context, Intent intent, Uri uri, boolean writeAble) {
        int i6 = writeAble ? 3 : 1;
        intent.addFlags(i6);
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 65536).iterator();
        while (it.hasNext()) {
            context.grantUriPermission(it.next().activityInfo.packageName, uri, i6);
        }
    }

    public void d1(final File file) {
        com.bumptech.glide.b.D(this.T).e(file).m1(this.R0);
    }

    public void g1(ImageView imageView, String url) {
        cn.bluemobi.dylan.base.utils.o.f(this.T, url, imageView, 2131689689, 2131689689);
    }

    private void T0() {
        this.W = (TextView) findViewById(2131298986);
        this.X = (TextView) findViewById(R.id.tv_account);
        this.Y = (TextView) findViewById(R.id.tv_school_name);
        this.f19560a0 = (TextView) findViewById(R.id.tv_department);
        this.f19562b0 = (TextView) findViewById(2131298971);
        this.f19564k0 = (TextView) findViewById(R.id.tv_class_name);
        this.f19565p0 = (TextView) findViewById(R.id.tv_nation);
        this.F0 = (TextView) findViewById(R.id.tv_birthplace);
        this.G0 = (EditText) findViewById(R.id.tv_home_address);
        this.H0 = (EditText) findViewById(R.id.tv_ID_number);
        this.I0 = (TextView) findViewById(2131299035);
        this.J0 = (EditText) findViewById(R.id.tv_email);
        this.K0 = (Button) findViewById(2131296599);
        this.f19563c0 = (TextView) findViewById(2131298922);
        this.Z = (TextView) findViewById(2131299099);
        this.L0 = (ToggleButton) findViewById(R.id.tag_wechat);
        this.M0 = (ToggleButton) findViewById(R.id.tag_qq);
        this.N0 = (ImageView) findViewById(R.id.iv_qq_head);
        this.O0 = (ImageView) findViewById(R.id.iv_wechat_head);
        this.P0 = (TextView) findViewById(R.id.tv_wechat_nick_name);
        this.Q0 = (TextView) findViewById(R.id.tv_qq_nick_name);
        this.S0 = (TextView) findViewById(R.id.tv_edit_head);
        this.R0 = (ImageView) findViewById(2131297148);
    }

    private Bitmap X0(Uri uri) {
        try {
            return BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e6) {
            e6.printStackTrace();
            return null;
        }
    }

    private void q1(Uri uri) {
        this.U0 = new File(com.bxkj.base.util.j.c(StubApp.getOrigApplicationContext(getApplicationContext()), uri));
        Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).O(LoginUser.getLoginUser().getUserId(), com.bxkj.base.util.j.b(this.U0.getPath()))).setDataListener(new d());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_user_info;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        Q().setVisibility(8);
        Http.with(this.T).setObservable(((e0.a) Http.getApiService(e0.a.class)).j1()).setDataListener(new h());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        T0();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
        if (requestCode == 204 && resultCode == -1) {
            Bitmap X0 = X0(Uri.fromFile(this.U0));
            this.R0.setImageBitmap(X0);
            this.U0 = e1(this.T, X0);
            com.bumptech.glide.b.D(this.T).e(this.U0).m1(this.R0);
            Http.with(this.T).hideOtherStatusMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).O(LoginUser.getLoginUser().getUserId(), com.bxkj.base.util.j.b(this.U0.getPath()))).setDataListener(new c());
            return;
        }
        if (requestCode == 221 && resultCode == -1) {
            Uri data2 = data.getData();
            if (data2 != null) {
                q1(data2);
                return;
            }
            return;
        }
        if (resultCode == -1 && requestCode == 69) {
            q1(com.yalantis.ucrop.b.e(data));
        } else if (resultCode == 96) {
            com.yalantis.ucrop.b.a(data).printStackTrace();
            new iOSOneButtonDialog(this.T).setMessage("头像裁剪失败，请重新再试").show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        switch (v5.getId()) {
            case 2131296599:
                V0();
                break;
            case 2131297148:
                String headImageUrl = LoginUser.getLoginUser().getHeadImageUrl();
                if (!TextUtils.isEmpty(headImageUrl)) {
                    j1(new String[]{headImageUrl}, 1);
                    break;
                }
                break;
            case R.id.tv_birthplace /* 2131298814 */:
                if (this.Z0.size() == 0) {
                    Z0();
                    break;
                } else {
                    k1(this.Z0, this.F0);
                    break;
                }
            case R.id.tv_edit_head /* 2131298888 */:
                Http.with(this.T).hideSuccessMessage().setObservable(((e0.a) Http.getApiService(e0.a.class)).c1("3")).setDataListener(new k());
                break;
            case R.id.tv_nation /* 2131298989 */:
                if (this.Y0.size() == 0) {
                    Y0();
                    break;
                } else {
                    k1(this.Y0, this.f19565p0);
                    break;
                }
            case 2131299035:
                U0();
                break;
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        String phone = LoginUser.getLoginUser().getPhone();
        if (!TextUtils.isEmpty(phone)) {
            this.I0.setText(phone.replaceAll("(\\d{3})\\d{4}(\\d{4})", "$1****$2") + "(更换)");
        }
    }
}
