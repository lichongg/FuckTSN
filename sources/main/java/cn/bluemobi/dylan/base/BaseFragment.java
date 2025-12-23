package cn.bluemobi.dylan.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    protected boolean f1092c = false;

    /* renamed from: d, reason: collision with root package name */
    protected boolean f1093d = false;

    /* renamed from: e, reason: collision with root package name */
    protected final String f1094e = "LazyLoadFragment";

    /* renamed from: f, reason: collision with root package name */
    private View f1095f;

    /* renamed from: g, reason: collision with root package name */
    protected Context f1096g;

    /* renamed from: h, reason: collision with root package name */
    protected Activity f1097h;

    /* renamed from: i, reason: collision with root package name */
    private Toast f1098i;

    public abstract void b();

    protected abstract void e();

    protected abstract void f(View view);

    protected abstract int i();

    private void g() {
        if (this.f1092c) {
            if (getUserVisibleHint()) {
                h();
                this.f1093d = true;
            } else if (this.f1093d) {
                M();
            }
        }
    }

    protected View d() {
        return this.f1095f;
    }

    protected void h() {
        if (this.f1093d) {
            return;
        }
        e();
    }

    protected void j(GridView gridView) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText("暂无数据！");
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) gridView.getParent()).addView(textView);
        gridView.setEmptyView(textView);
    }

    protected void k(GridView gridView, String str) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) gridView.getParent()).addView(textView);
        gridView.setEmptyView(textView);
    }

    protected void l(ListView listView) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText("暂无数据！");
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) listView.getParent()).addView(textView);
        listView.setEmptyView(textView);
        listView.setVisibility(0);
    }

    protected void m(ListView listView, String str) {
        TextView textView = new TextView(getContext());
        textView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        textView.setText(str);
        textView.setGravity(17);
        textView.setTextSize(2, 16.0f);
        textView.setVisibility(8);
        ((ViewGroup) listView.getParent()).addView(textView);
        listView.setEmptyView(textView);
    }

    public void n(CharSequence charSequence) {
        Toast toast = this.f1098i;
        if (toast == null) {
            this.f1098i = Toast.makeText(getContext(), charSequence, 0);
        } else {
            toast.setText(charSequence);
        }
        this.f1098i.show();
    }

    protected <T extends View> T c(int i6) {
        return (T) d().findViewById(i6);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        this.f1095f = layoutInflater.inflate(i(), viewGroup, false);
        cn.bluemobi.dylan.base.utils.a.n().d(this);
        this.f1092c = true;
        this.f1096g = getContext();
        this.f1097h = getActivity();
        f(this.f1095f);
        g();
        b();
        return this.f1095f;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        cn.bluemobi.dylan.base.utils.a.n().t(this);
        super.onDestroyView();
        this.f1092c = false;
        this.f1093d = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        Toast toast = this.f1098i;
        if (toast != null) {
            toast.cancel();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void setUserVisibleHint(boolean z5) {
        super.setUserVisibleHint(z5);
        g();
    }

    protected void M() {
    }
}
