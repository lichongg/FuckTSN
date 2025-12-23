package com.bxkj.student.run.app.set.brandset;

import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class OtherSetFramgment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f20040j;

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        SpannableString spannableString = new SpannableString(getString(R.string.set_hint));
        N(spannableString, "【" + getString(2131951695) + "】");
        O(spannableString, "【" + getString(2131951695) + "】");
        N(spannableString, "【后台运行】");
        N(spannableString, "【自启动】");
        N(spannableString, "【后台定位】");
        N(spannableString, "【后台联网】");
        this.f20040j.setText(spannableString);
    }

    private void N(SpannableString spannableString, String text) {
        int indexOf = spannableString.toString().indexOf(text);
        spannableString.setSpan(new StyleSpan(1), indexOf, text.length() + indexOf, 33);
    }

    private void O(SpannableString spannableString, String text) {
        int lastIndexOf = spannableString.toString().lastIndexOf(text);
        spannableString.setSpan(new StyleSpan(1), lastIndexOf, text.length() + lastIndexOf, 33);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f20040j = (TextView) c(R.id.tv_set);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_other_set;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
