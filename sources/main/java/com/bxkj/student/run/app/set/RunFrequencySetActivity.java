package com.bxkj.student.run.app.set;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class RunFrequencySetActivity extends BaseActivity {
    private RadioGroup W;
    private Button X;

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.W.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.bxkj.student.run.app.set.a
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public final void onCheckedChanged(RadioGroup radioGroup, int i6) {
                RunFrequencySetActivity.this.j0(radioGroup, i6);
            }
        });
        this.X.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.student.run.app.set.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RunFrequencySetActivity.this.k0(view);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        ((RadioButton) this.W.getChildAt(LoginUser.getLoginUser().getFrequency())).setChecked(true);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("播报频率设置");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j0(RadioGroup radioGroup, int i6) {
        LoginUser loginUser = LoginUser.getLoginUser();
        RadioGroup radioGroup2 = this.W;
        loginUser.setFrequency(radioGroup2.indexOfChild(radioGroup2.findViewById(i6)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(View view) {
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_set_frequency;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (RadioGroup) findViewById(2131298361);
        this.X = (Button) findViewById(2131296623);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
