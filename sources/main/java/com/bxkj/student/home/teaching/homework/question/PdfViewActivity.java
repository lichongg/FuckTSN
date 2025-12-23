package com.bxkj.student.home.teaching.homework.question;

import android.os.Bundle;
import android.view.View;
import cn.bluemobi.dylan.base.BaseActivity;
import com.bxkj.student.R;
import com.bxkj.student.home.teaching.learning.detail.type.PdfFragment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PdfViewActivity extends BaseActivity {
    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        PdfFragment pdfFragment = new PdfFragment();
        Bundle bundle = new Bundle();
        if (getIntent().hasExtra("url")) {
            bundle.putString("url", getIntent().getStringExtra("url"));
        } else if (getIntent().hasExtra("filePath")) {
            bundle.putString("filePath", getIntent().getStringExtra("filePath"));
        }
        pdfFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().add(2131298068, pdfFragment).commitAllowingStateLoss();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("预览PDF文件");
        if (getIntent().hasExtra("title")) {
            setTitle(getIntent().getStringExtra("title"));
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.pub_empty;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
