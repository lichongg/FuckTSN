package com.bxkj.student.life.lost;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AddQuestionActivity extends BaseActivity {
    private EditText W;
    private EditText X;
    private Button Y;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            AddQuestionActivity.this.i0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i0() {
        String trim = this.W.getText().toString().trim();
        String trim2 = this.X.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            g0("请填写问题");
            return;
        }
        if (TextUtils.isEmpty(trim2)) {
            g0("请填写答案");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("question", trim);
        intent.putExtra("answer", trim2);
        setResult(-1, intent);
        finish();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.Y.setOnClickListener(new a());
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("添加问题");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_add_question;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (EditText) findViewById(R.id.et_question);
        this.X = (EditText) findViewById(R.id.et_answer);
        this.Y = (Button) findViewById(R.id.bt_save);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
