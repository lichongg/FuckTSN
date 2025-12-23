package com.bxkj.student.personal;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.d;
import com.bxkj.student.common.versionupdate.a;
import com.bxkj.student.personal.password.UpdatePasswordActivity;
import com.bxkj.student.personal.password.forget.FindPasswordTypeActivity;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class SystemSetActivity extends BaseActivity {
    private LinearLayout W;
    private LinearLayout X;
    private LinearLayout Y;
    private TextView Z;

    /* renamed from: a0, reason: collision with root package name */
    private TextView f19552a0;

    /* renamed from: b0, reason: collision with root package name */
    private LinearLayout f19553b0;

    /* renamed from: c0, reason: collision with root package name */
    private LinearLayout f19554c0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayout f19555k0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements a.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bxkj.student.common.versionupdate.a f19556a;

        a(final com.bxkj.student.common.versionupdate.a val$versionUpdate) {
            this.f19556a = val$versionUpdate;
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void a(boolean hasNewVersion, String versionName, String downLoadUrl, String instruction) {
            if (hasNewVersion) {
                this.f19556a.d(versionName, downLoadUrl, instruction);
            } else {
                new iOSOneButtonDialog(((BaseActivity) SystemSetActivity.this).T).setMessage("当前已是最新版本").show();
            }
        }

        @Override // com.bxkj.student.common.versionupdate.a.d
        public void b() {
        }
    }

    public static long i0(File dir) {
        long i02;
        long j6 = 0;
        if (dir == null || !dir.isDirectory()) {
            return 0L;
        }
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                i02 = file.length();
            } else if (file.isDirectory()) {
                j6 += file.length();
                i02 = i0(file);
            }
            j6 += i02;
        }
        return j6;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnClickListener(this);
        this.f19554c0.setOnClickListener(this);
        this.f19555k0.setOnClickListener(this);
        this.f19553b0.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.X.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        this.f19552a0.setText("v" + j0());
        try {
            this.Z.setText(d.k(this.T));
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("系统设置");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_system_set;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (LinearLayout) findViewById(R.id.ll_edit_password);
        this.X = (LinearLayout) findViewById(R.id.ll_forget_password);
        this.Y = (LinearLayout) findViewById(R.id.ll_clear_cache);
        this.Z = (TextView) findViewById(R.id.tv_cache_size);
        this.f19552a0 = (TextView) findViewById(R.id.tv_version);
        this.f19553b0 = (LinearLayout) findViewById(R.id.ll_help_center);
        this.f19554c0 = (LinearLayout) findViewById(R.id.ll_version);
        this.f19555k0 = (LinearLayout) findViewById(R.id.ll_about_us);
    }

    public String j0() {
        try {
            return getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
        } catch (Exception e6) {
            e6.printStackTrace();
            return "1.0";
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        switch (v5.getId()) {
            case R.id.ll_about_us /* 2131298008 */:
                startActivity(new Intent(this.T, (Class<?>) AboutUsActivity.class));
                break;
            case R.id.ll_clear_cache /* 2131298024 */:
                d.g(this.T);
                new iOSOneButtonDialog(this.T).setMessage("缓存清除成功").show();
                break;
            case R.id.ll_edit_password /* 2131298033 */:
                startActivity(new Intent(this.T, (Class<?>) UpdatePasswordActivity.class));
                break;
            case R.id.ll_forget_password /* 2131298038 */:
                startActivity(new Intent(this.T, (Class<?>) FindPasswordTypeActivity.class));
                break;
            case R.id.ll_help_center /* 2131298044 */:
                startActivity(new Intent(this.T, (Class<?>) HelpCenterListActivity.class));
                break;
            case R.id.ll_version /* 2131298084 */:
                com.bxkj.student.common.versionupdate.a aVar = new com.bxkj.student.common.versionupdate.a(this.T);
                aVar.b(new a(aVar));
                break;
        }
    }
}
