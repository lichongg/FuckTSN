package com.bxkj.student.personal;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.base.v2.common.qrcode.b;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class MyQRCodeActivity extends BaseActivity {
    private ImageView W;
    private ImageView X;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        h0(this, 1.0f);
        this.W.setImageBitmap(new b(this.U).f(LoginUser.getLoginUser().getAccount(), 2131689689));
        this.X.setImageBitmap(new b(this.U).b(LoginUser.getLoginUser().getAccount()));
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("我的二维码");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        h0(this, -1.0f);
        super.onDestroy();
    }

    private void h0(Activity activity, float brightness) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.screenBrightness = brightness;
        window.setAttributes(attributes);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_my_qrcode;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (ImageView) findViewById(R.id.iv_qrcode);
        this.X = (ImageView) findViewById(R.id.iv_code);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
