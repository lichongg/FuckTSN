package com.bxkj.student.personal;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AboutUsActivity extends BaseActivity {

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View v5) {
            AboutUsActivity.this.m0();
            return false;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements iOSTwoButtonDialog.RightButtonOnClick {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ iOSTwoButtonDialog f19538a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements iOSTwoButtonDialog.RightButtonOnClick {
            a() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(false);
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.bxkj.student.personal.AboutUsActivity$b$b, reason: collision with other inner class name */
        class C0262b implements iOSTwoButtonDialog.RightButtonOnClick {
            C0262b() {
            }

            @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
            public void buttonRightOnClick() {
                LoginUser.getLoginUser().setOpenModel(true);
            }
        }

        b(final iOSTwoButtonDialog val$iOSTwoButtonDialog) {
            this.f19538a = val$iOSTwoButtonDialog;
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            this.f19538a.show();
            String trim = ((EditText) this.f19538a.findViewById(R.id.et_password)).getText().toString().trim();
            if (trim.isEmpty()) {
                AboutUsActivity.this.g0("密码不能为空");
                return;
            }
            try {
                this.f19538a.dismiss();
                if (!"396436".equals(trim)) {
                    new iOSOneButtonDialog(((BaseActivity) AboutUsActivity.this).T).setMessage("密码错误，请联系管理员").show();
                } else if (LoginUser.getLoginUser().isOpenModel()) {
                    new iOSTwoButtonDialog(((BaseActivity) AboutUsActivity.this).T).setMessage("确定关闭开发者模式？").setRightButtonOnClickListener(new a()).show();
                } else {
                    new iOSTwoButtonDialog(((BaseActivity) AboutUsActivity.this).T).setMessage("确定打开开发者模式？").setRightButtonOnClickListener(new C0262b()).show();
                }
            } catch (Exception e6) {
                new iOSOneButtonDialog(((BaseActivity) AboutUsActivity.this).T).setMessage("验证密码异常，请联系管理员").show();
                e6.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        iOSTwoButtonDialog iostwobuttondialog = new iOSTwoButtonDialog(this.T);
        iostwobuttondialog.setMessage("开发者模式专供开发者调试使用，请谨慎开启！开关开发者模式需要验证你的身份，请输入密码进行验证").setCenterCustomView(R.layout.dialog_confim_password).setRightButtonOnClickListener(new b(iostwobuttondialog)).show();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("关于我们");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        findViewById(2131297182).setOnLongClickListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_about_us;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
