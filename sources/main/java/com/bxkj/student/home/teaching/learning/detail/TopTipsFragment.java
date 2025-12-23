package com.bxkj.student.home.teaching.learning.detail;

import android.view.View;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import com.bxkj.student.R;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class TopTipsFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f18511j;

    public String N(long recordingTime) {
        long j6 = recordingTime / 60;
        if (j6 >= 10) {
            return String.valueOf(j6);
        }
        return "0" + j6;
    }

    public String O(long recordingTime) {
        long j6 = recordingTime % 60;
        if (j6 >= 10) {
            return String.valueOf(j6);
        }
        return "0" + j6;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        if (getArguments().containsKey("duration")) {
            String string = getArguments().getString("duration");
            this.f18511j.setText("本资源时长" + N(Long.parseLong(string)) + "分" + O(Long.parseLong(string)) + "秒，积分" + getArguments().getString("integral") + "分，底部倒计时结束后，方可积分。提前退出资源观看页面，不积分，不显示进度条。只有第一次积分。");
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f18511j = (TextView) c(2131298879);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_learn_top_tips;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
