package com.bxkj.student.personal.customer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import com.bxkj.student.R;
import com.bxkj.student.personal.login.LoginActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import t.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class ContactUsFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private TextView f19620j;

    /* renamed from: k, reason: collision with root package name */
    private ListView f19621k;

    /* renamed from: l, reason: collision with root package name */
    private List<Map<String, Object>> f19622l = new ArrayList();

    /* renamed from: m, reason: collision with root package name */
    private cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> f19623m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        a(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            ContactUsFragment.this.Y((TextView) holder.h(R.id.tv_qq), JsonParse.getString(stringObjectMap, "qq"), JsonParse.getString(stringObjectMap, "androidQqKey"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends HttpCallBack {
        b() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            ContactUsFragment.this.X(JsonParse.getString(data, "customerServicePhone", "4008330860"));
            ContactUsFragment.this.f19622l = JsonParse.getList(data, "customerServiceQq");
            ContactUsFragment.this.f19623m.c(ContactUsFragment.this.f19622l);
            FragmentActivity activity = ContactUsFragment.this.getActivity();
            String string = JsonParse.getString(data, "serviceQq", "884165111");
            if (activity instanceof LoginActivity) {
                ((LoginActivity) activity).C0(string);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19626a;

        c(final String val$customerServicePhone) {
            this.f19626a = val$customerServicePhone;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            ContactUsFragment.this.U(this.f19626a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d extends ClickableSpan {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19628a;

        d(final String val$key) {
            this.f19628a = val$key;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View widget) {
            ContactUsFragment.this.W(this.f19628a);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f19630a;

        e(final String val$phoneNum) {
            this.f19630a = val$phoneNum;
        }

        @Override // t.b.a
        public void a() {
            Intent intent = new Intent("android.intent.action.DIAL");
            intent.setData(Uri.parse("tel:" + this.f19630a));
            ContactUsFragment.this.startActivity(intent);
        }

        @Override // t.b.a
        public void b(String... permission) {
            new iOSOneButtonDialog(((BaseFragment) ContactUsFragment.this).f1096g).setMessage("您拒绝了拨打电话权限,无法联系客服！").show();
        }

        @Override // t.b.a
        public void c(String... permission) {
            new iOSOneButtonDialog(((BaseFragment) ContactUsFragment.this).f1096g).setMessage("您拒绝了拨打电话权限,无法联系客服！").show();
        }
    }

    private void V() {
        Http.with(this.f1096g).hideLoadingDialog().setObservable(((e0.a) Http.getApiService(e0.a.class)).a0()).setDataListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X(String customerServicePhone) {
        SpannableString spannableString = new SpannableString("客服电话：" + customerServicePhone);
        spannableString.setSpan(new c(customerServicePhone), 5, spannableString.length(), 33);
        spannableString.setSpan(new UnderlineSpan(), 5, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f1096g, 2131099737)), 5, spannableString.length(), 33);
        this.f19620j.setText(spannableString);
        this.f19620j.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y(TextView tv_qq_group, String customerServiceQq, String key) {
        SpannableString spannableString = new SpannableString("加入QQ群：" + customerServiceQq);
        spannableString.setSpan(new d(key), 6, spannableString.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.f1096g, 2131099737)), 6, spannableString.length(), 33);
        tv_qq_group.setText(spannableString);
        tv_qq_group.setMovementMethod(LinkMovementMethod.getInstance());
    }

    public void U(String phoneNum) {
        new t.b(this).c("android.permission.CALL_PHONE").d(new e(phoneNum));
    }

    public boolean W(String key) {
        Intent intent = new Intent();
        intent.setData(Uri.parse("mqqopensdkapi://bizAgent/qm/qr?url=http%3A%2F%2Fqm.qq.com%2Fcgi-bin%2Fqm%2Fqr%3Ffrom%3Dapp%26p%3Dandroid%26jump_from%3Dwebapi%26k%3D" + key));
        try {
            startActivity(intent);
            return true;
        } catch (Exception unused) {
            new iOSOneButtonDialog(this.f1096g).setMessage("您还未安装手机QQ或安装的手机QQ版本太低").show();
            return false;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void e() {
        a aVar = new a(this.f1096g, R.layout.item_for_contact_qq_group, this.f19622l);
        this.f19623m = aVar;
        this.f19621k.setAdapter((ListAdapter) aVar);
        X("4008330860");
        V();
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f19620j = (TextView) c(2131299035);
        this.f19621k = (ListView) c(R.id.lv_qq_group);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.fm_contact_us;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
