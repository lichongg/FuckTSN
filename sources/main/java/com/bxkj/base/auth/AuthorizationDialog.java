package com.bxkj.base.auth;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import com.bxkj.base.R;
import com.bxkj.base.user.LoginUser;
import java.util.Map;
import x.d;
import x.e;
import x.g;
import x.h;
import x.i;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class AuthorizationDialog extends DialogFragment {

    /* renamed from: c, reason: collision with root package name */
    private c f16394c;

    /* renamed from: d, reason: collision with root package name */
    private int f16395d;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AuthorizationDialog.this.d();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> map) {
            AuthorizationDialog.this.dismiss();
            if (AuthorizationDialog.this.f16394c != null) {
                AuthorizationDialog.this.f16394c.a();
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface c {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i6 = this.f16395d;
        Http.with(getContext()).setObservable(i6 == 0 ? ((g) Http.getApiService(g.class)).D(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone()) : i6 == 1 ? ((e) Http.getApiService(e.class)).e(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone()) : i6 == 2 ? ((i) Http.getApiService(i.class)).h(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone()) : i6 == 3 ? ((d) Http.getApiService(d.class)).c(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone()) : i6 == 4 ? ((h) Http.getApiService(h.class)).f(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone()) : i6 == 5 ? ((x.b) Http.getApiService(x.b.class)).g(LoginUser.getLoginUser().getSchoolId(), LoginUser.getLoginUser().getUserId(), LoginUser.getLoginUser().getRealName(), LoginUser.getLoginUser().getSex(), LoginUser.getLoginUser().getAccount(), LoginUser.getLoginUser().getPhone()) : null).setDataListener(new b());
    }

    public DialogFragment e(int i6) {
        this.f16395d = i6;
        return this;
    }

    public AuthorizationDialog f(c cVar) {
        this.f16394c = cVar;
        return this;
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_authorization, viewGroup);
        TextView textView = (TextView) inflate.findViewById(R.id.bt_ok);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_name);
        int i6 = this.f16395d;
        if (i6 == 0) {
            textView2.setText(R.string.app_mall);
        } else if (i6 == 1) {
            textView2.setText("帮帮忙");
        } else if (i6 == 2) {
            textView2.setText("二手市场");
        } else if (i6 == 3) {
            textView2.setText("求职招聘");
        } else if (i6 == 4) {
            textView2.setText("跑腿");
        } else if (i6 == 5) {
            textView2.setText("捐赠寄卖");
        }
        textView.setOnClickListener(new a());
        return inflate;
    }
}
