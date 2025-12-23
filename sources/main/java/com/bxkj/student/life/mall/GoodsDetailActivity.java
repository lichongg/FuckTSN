package com.bxkj.student.life.mall;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.adapter.common.ViewHolder;
import cn.bluemobi.dylan.base.utils.SeralizableMap;
import cn.bluemobi.dylan.base.utils.u;
import cn.bluemobi.dylan.base.view.CycleViewPager;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import cn.bluemobi.dylan.http.Http;
import cn.bluemobi.dylan.http.HttpCallBack;
import cn.bluemobi.dylan.http.JsonParse;
import cn.bluemobi.dylan.photoview.ImagePagerActivity;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import com.bxkj.base.auth.a;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import com.bxkj.student.common.view.NumberButton;
import com.bxkj.student.common.view.SlideDetailsLayout;
import com.bxkj.student.life.mall.order.ConfirmOrderActivity;
import com.bxkj.student.personal.login.LoginActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class GoodsDetailActivity extends BaseActivity {
    private SmartWebView F0;
    private TextView G0;
    private TextView H0;
    private TextView I0;
    private TextView J0;
    private TextView K0;
    private TextView L0;
    private TextView M0;
    private TextView N0;
    private TextView O0;
    private TextView P0;
    private TextView Q0;
    private TextView R0;
    private Button S0;
    private Button T0;
    private Button U0;
    private String V0;
    private FloatingActionButton W;
    private Map<String, Object> W0;
    private RelativeLayout X;
    private List<String> X0;
    private LinearLayout Y;
    private LinearLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    private SlideDetailsLayout f19151a0;

    /* renamed from: b0, reason: collision with root package name */
    private ScrollView f19152b0;

    /* renamed from: c0, reason: collision with root package name */
    private ScrollView f19153c0;

    /* renamed from: k0, reason: collision with root package name */
    private LinearLayout f19154k0;

    /* renamed from: p0, reason: collision with root package name */
    private CycleViewPager f19155p0;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a extends com.zhy.view.flowlayout.b<Map<String, Object>> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TagFlowLayout f19156d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(List datas, final TagFlowLayout val$rv_size) {
            super(datas);
            this.f19156d = val$rv_size;
        }

        @Override // com.zhy.view.flowlayout.b
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public View d(FlowLayout parent, int position, Map<String, Object> stringObjectMap) {
            TextView textView = (TextView) LayoutInflater.from(((BaseActivity) GoodsDetailActivity.this).T).inflate(R.layout.item_tag, (ViewGroup) this.f19156d, false);
            textView.setText(JsonParse.getString(stringObjectMap, "modelName"));
            return textView;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements TagFlowLayout.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f19158a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f19159b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zhy.view.flowlayout.b f19160c;

        b(final TextView val$tv_stock, final String val$stock, final com.zhy.view.flowlayout.b val$modelNameAdapter) {
            this.f19158a = val$tv_stock;
            this.f19159b = val$stock;
            this.f19160c = val$modelNameAdapter;
        }

        @Override // com.zhy.view.flowlayout.TagFlowLayout.a
        public void a(Set<Integer> selectPosSet) {
            if (selectPosSet == null || selectPosSet.size() == 0) {
                this.f19158a.setText(this.f19159b);
                return;
            }
            this.f19158a.setText("库存：" + JsonParse.getString((Map) this.f19160c.b(selectPosSet.iterator().next().intValue()), "branchStock"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class c implements NumberButton.OnWarnListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TextView f19162a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ double f19163b;

        c(final TextView val$tv_count, final double val$price) {
            this.f19162a = val$tv_count;
            this.f19163b = val$price;
        }

        @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
        public void onNumberChanged(int number) {
            this.f19162a.setText("共" + number + "件￥" + new DecimalFormat("0.00").format(this.f19163b * number) + "元");
        }

        @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
        public void onWarningForBuyMax(int max) {
        }

        @Override // com.bxkj.student.common.view.NumberButton.OnWarnListener
        public void onWarningForInventory(int inventory) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class d implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TagFlowLayout f19165a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NumberButton f19166b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zhy.view.flowlayout.b f19167c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f19168d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements a.g {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$d$a$a, reason: collision with other inner class name */
            class C0244a extends HttpCallBack {
                C0244a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    d.this.f19168d.dismiss();
                    HashMap hashMap = new HashMap(3);
                    HashMap hashMap2 = new HashMap(3);
                    hashMap2.putAll(JsonParse.getMap(data, "address"));
                    hashMap.put("address", hashMap2);
                    hashMap.put("goodsList", JsonParse.getList(data, "comms"));
                    hashMap.put("postFee", Double.valueOf(JsonParse.getDouble(data, "postFee")));
                    hashMap.put("goodsPrice", Double.valueOf(JsonParse.getDouble(data, "totalPrize")));
                    SeralizableMap seralizableMap = new SeralizableMap();
                    seralizableMap.setMap(hashMap);
                    GoodsDetailActivity.this.startActivity(new Intent(((BaseActivity) GoodsDetailActivity.this).T, (Class<?>) ConfirmOrderActivity.class).putExtra("map", seralizableMap));
                }
            }

            a() {
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                d dVar = d.this;
                Http.with(((BaseActivity) GoodsDetailActivity.this).T).setObservable(((x.g) Http.getApiService(x.g.class)).g(LoginUser.getLoginUser().getOpenId(), GoodsDetailActivity.this.V0, JsonParse.getString((Map) dVar.f19167c.b(dVar.f19165a.getSelectedList().iterator().next().intValue()), "id"), d.this.f19166b.getNumber())).setDataListener(new C0244a());
            }
        }

        d(final TagFlowLayout val$rv_size, final NumberButton val$number_button, final com.zhy.view.flowlayout.b val$modelNameAdapter, final Dialog val$dialog) {
            this.f19165a = val$rv_size;
            this.f19166b = val$number_button;
            this.f19167c = val$modelNameAdapter;
            this.f19168d = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            if (this.f19165a.getSelectedList() == null || this.f19165a.getSelectedList().size() <= 0) {
                GoodsDetailActivity.this.g0("请选择商品属性");
            } else if (this.f19166b.getNumber() <= 0) {
                GoodsDetailActivity.this.g0("请选择商品数量");
            } else {
                new com.bxkj.base.auth.a(((BaseActivity) GoodsDetailActivity.this).T).i(new a()).b(GoodsDetailActivity.this.getSupportFragmentManager(), 0);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class e implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ TagFlowLayout f19172a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ NumberButton f19173b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ com.zhy.view.flowlayout.b f19174c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Dialog f19175d;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements a.g {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: com.bxkj.student.life.mall.GoodsDetailActivity$e$a$a, reason: collision with other inner class name */
            class C0245a extends HttpCallBack {
                C0245a() {
                }

                @Override // cn.bluemobi.dylan.http.HttpResponse
                public void netOnSuccess(Map<String, Object> data) {
                    e.this.f19175d.dismiss();
                    GoodsDetailActivity.this.g0("加入购物车成功");
                    GoodsListFragment goodsListFragment = (GoodsListFragment) cn.bluemobi.dylan.base.utils.a.n().o(GoodsListFragment.class);
                    if (goodsListFragment != null) {
                        goodsListFragment.f0();
                    }
                }
            }

            a() {
            }

            @Override // com.bxkj.base.auth.a.g
            public void a() {
                e eVar = e.this;
                Http.with(((BaseActivity) GoodsDetailActivity.this).T).setObservable(((x.g) Http.getApiService(x.g.class)).c(LoginUser.getLoginUser().getOpenId(), GoodsDetailActivity.this.V0, JsonParse.getString((Map) eVar.f19174c.b(eVar.f19172a.getSelectedList().iterator().next().intValue()), "id"), e.this.f19173b.getNumber())).setDataListener(new C0245a());
            }
        }

        e(final TagFlowLayout val$rv_size, final NumberButton val$number_button, final com.zhy.view.flowlayout.b val$modelNameAdapter, final Dialog val$dialog) {
            this.f19172a = val$rv_size;
            this.f19173b = val$number_button;
            this.f19174c = val$modelNameAdapter;
            this.f19175d = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            if (this.f19172a.getSelectedList() == null || this.f19172a.getSelectedList().size() <= 0) {
                GoodsDetailActivity.this.g0("请选择商品属性");
            } else if (this.f19173b.getNumber() <= 0) {
                GoodsDetailActivity.this.g0("请选择商品数量");
            } else {
                new com.bxkj.base.auth.a(((BaseActivity) GoodsDetailActivity.this).T).i(new a()).b(GoodsDetailActivity.this.getSupportFragmentManager(), 0);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class f extends cn.bluemobi.dylan.base.adapter.common.abslistview.a<Map<String, Object>> {
        f(Context context, int layoutId, List datas) {
            super(context, layoutId, datas);
        }

        @Override // cn.bluemobi.dylan.base.adapter.common.abslistview.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(ViewHolder holder, Map<String, Object> stringObjectMap) {
            holder.J(R.id.tv_specification, JsonParse.getString(stringObjectMap, CommonNetImpl.NAME) + "：\u3000");
            holder.J(2131299181, JsonParse.getString(stringObjectMap, "value"));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class g implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Dialog f19180a;

        g(final Dialog val$dialog) {
            this.f19180a = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            Dialog dialog = this.f19180a;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f19180a.dismiss();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class h implements a.g {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a extends HttpCallBack {
            a() {
            }

            @Override // cn.bluemobi.dylan.http.HttpResponse
            public void netOnSuccess(Map<String, Object> data) {
                GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
                goodsDetailActivity.I0("收藏".equals(goodsDetailActivity.O0.getText().toString().trim()));
            }
        }

        h() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            Http.with(((BaseActivity) GoodsDetailActivity.this).T).setObservable(((x.g) Http.getApiService(x.g.class)).i(GoodsDetailActivity.this.V0, LoginUser.getLoginUser().getOpenId())).setDataListener(new a());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class i implements SlideDetailsLayout.OnSlideDetailsListener {
        i() {
        }

        @Override // com.bxkj.student.common.view.SlideDetailsLayout.OnSlideDetailsListener
        public void onStatucChanged(SlideDetailsLayout.Status status) {
            if (status == SlideDetailsLayout.Status.OPEN) {
                GoodsDetailActivity.this.f19153c0.setVisibility(0);
                GoodsDetailActivity.this.W.setVisibility(0);
            } else {
                GoodsDetailActivity.this.f19153c0.setVisibility(8);
                GoodsDetailActivity.this.W.setVisibility(8);
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class j implements a.g {
        j() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            GoodsDetailActivity.this.G0();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class k implements a.g {
        k() {
        }

        @Override // com.bxkj.base.auth.a.g
        public void a() {
            GoodsDetailActivity.this.startActivity(new Intent(((BaseActivity) GoodsDetailActivity.this).T, (Class<?>) CartActivity.class));
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class l implements iOSTwoButtonDialog.RightButtonOnClick {
        l() {
        }

        @Override // cn.bluemobi.dylan.base.view.iOSTwoButtonDialog.RightButtonOnClick
        public void buttonRightOnClick() {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(GoodsDetailActivity.this.getString(R.string.link_phone_number)));
            intent.setFlags(268435456);
            GoodsDetailActivity.this.startActivity(intent);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class m implements ShareBoardlistener {

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements UMShareListener {
            a() {
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onCancel(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) GoodsDetailActivity.this).T, " 分享取消了", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onResult(SHARE_MEDIA platform) {
                Toast.makeText(((BaseActivity) GoodsDetailActivity.this).T, " 分享成功啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onError(SHARE_MEDIA platform, Throwable t5) {
                t5.printStackTrace();
                Toast.makeText(((BaseActivity) GoodsDetailActivity.this).T, " 分享失败啦", 0).show();
            }

            @Override // com.umeng.socialize.UMShareListener
            public void onStart(SHARE_MEDIA share_media) {
            }
        }

        m() {
        }

        @Override // com.umeng.socialize.utils.ShareBoardlistener
        public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
            UMWeb uMWeb = new UMWeb("http://m.boxkj.com/admin/studentAppUpdate/downloadUrl");
            uMWeb.setTitle("校园生活如此简单");
            uMWeb.setThumb(new UMImage(((BaseActivity) GoodsDetailActivity.this).T, "http://m.boxkj.com/resources/wechat/images/xiaowei.png"));
            uMWeb.setDescription(GoodsDetailActivity.this.getString(R.string.welcome_user_app));
            new ShareAction(GoodsDetailActivity.this).setPlatform(share_media).setCallback(new a()).withMedia(uMWeb).share();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class n extends HttpCallBack {
        n() {
        }

        @Override // cn.bluemobi.dylan.http.HttpResponse
        public void netOnSuccess(Map<String, Object> data) {
            GoodsDetailActivity.this.X.setVisibility(0);
            GoodsDetailActivity.this.W0 = data;
            GoodsDetailActivity.this.J0();
        }

        @Override // cn.bluemobi.dylan.http.HttpCallBack, cn.bluemobi.dylan.http.HttpResponse
        public void netOnOtherStatus(int status, String msg) {
            super.netOnOtherStatus(status, msg);
            new iOSOneButtonDialog(((BaseActivity) GoodsDetailActivity.this).T).setMessage(msg).show();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class o implements CycleViewPager.ImageCycleViewListener {
        o() {
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewListener
        public void onImageClick(String url, int position, View imageView) {
            String[] strArr = new String[GoodsDetailActivity.this.X0.size()];
            GoodsDetailActivity goodsDetailActivity = GoodsDetailActivity.this;
            goodsDetailActivity.N0((String[]) goodsDetailActivity.X0.toArray(strArr), position);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class p implements CycleViewPager.ImageCycleViewSelectListener {
        p() {
        }

        @Override // cn.bluemobi.dylan.base.view.CycleViewPager.ImageCycleViewSelectListener
        public void onItemSelect(int position) {
            GoodsDetailActivity.this.N0.setText((position + 1) + "/" + GoodsDetailActivity.this.X0.size());
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class q implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Dialog f19193a;

        q(final Dialog val$dialog) {
            this.f19193a = val$dialog;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            Dialog dialog = this.f19193a;
            if (dialog == null || !dialog.isShowing()) {
                return;
            }
            this.f19193a.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(boolean hasFavorited) {
        if (hasFavorited) {
            K0();
        } else {
            L0();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        if (this.W0.containsKey("imgArr")) {
            List<String> list = (List) this.W0.get("imgArr");
            this.X0 = list;
            this.f19155p0.setData(list, new o());
            this.N0.setText("1/" + this.X0.size());
            this.f19155p0.setImageCycleViewSelectListener(new p());
        } else {
            this.N0.setText("0");
        }
        this.L0.setText(JsonParse.getString(this.W0, CommonNetImpl.NAME));
        this.M0.setText("￥" + JsonParse.getMoney(this.W0, "discountPrice"));
        this.G0.setText("原价：￥" + JsonParse.getMoney(this.W0, "regionPrice"));
        this.H0.setText("库存：" + JsonParse.getString(this.W0, "stock"));
        this.I0.setText("销量：" + JsonParse.getString(this.W0, "saledNum"));
        this.K0.setText(JsonParse.getString(this.W0, "postFeeTip"));
        I0(JsonParse.getBoolean(this.W0, "hasFavorited", false));
        this.F0.h(JsonParse.getString(this.W0, "memo"));
        if ("1".equals(JsonParse.getString(this.W0, "downState"))) {
            M0();
        }
    }

    private void M0() {
        this.Z.setVisibility(8);
        this.U0.setVisibility(0);
        this.Q0.setEnabled(false);
        this.Y.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(String[] arr, int position) {
        Intent intent = new Intent(this.T, (Class<?>) ImagePagerActivity.class);
        intent.putExtra(ImagePagerActivity.T, arr);
        intent.putExtra(ImagePagerActivity.S, position);
        startActivity(intent);
        overridePendingTransition(2130772094, 2130772095);
    }

    private void O0() {
        Dialog dialog = new Dialog(this.T, R.style.Dialog_FullScreen);
        dialog.setContentView(R.layout.dialog_select_size);
        dialog.getWindow().setGravity(80);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        dialog.getWindow().setAttributes(attributes);
        dialog.show();
        dialog.findViewById(2131297111).setOnClickListener(new q(dialog));
        ImageView imageView = (ImageView) dialog.findViewById(2131297182);
        List<String> list = this.X0;
        if (list != null && list.size() > 0) {
            com.bumptech.glide.b.D(this.T).a(this.X0.get(0)).y0(R.mipmap.icon_smal).z(R.mipmap.icon_smal).m1(imageView);
        }
        ((TextView) dialog.findViewById(2131298986)).setText(JsonParse.getString(this.W0, CommonNetImpl.NAME));
        ((TextView) dialog.findViewById(2131299047)).setText("￥" + JsonParse.getMoney(this.W0, "discountPrice"));
        TextView textView = (TextView) dialog.findViewById(R.id.tv_stock);
        String str = "库存：" + JsonParse.getString(this.W0, "stock");
        textView.setText(str);
        TagFlowLayout tagFlowLayout = (TagFlowLayout) dialog.findViewById(R.id.tfl);
        List<Map<String, Object>> list2 = JsonParse.getList(this.W0, "models");
        tagFlowLayout.setMaxSelectCount(1);
        a aVar = new a(list2, tagFlowLayout);
        tagFlowLayout.setAdapter(aVar);
        tagFlowLayout.setOnSelectListener(new b(textView, str, aVar));
        double d6 = JsonParse.getDouble(this.W0, "discountPrice");
        TextView textView2 = (TextView) dialog.findViewById(2131298848);
        textView2.setText("共1件￥" + d6 + "元");
        NumberButton numberButton = (NumberButton) dialog.findViewById(2131298253);
        numberButton.setBuyMax(JsonParse.getInt(this.W0, "stock"));
        numberButton.setCurrentNumber(JsonParse.getInt(this.W0, "stock") <= 0 ? 0 : 1);
        numberButton.setOnWarnListener(new c(textView2, d6));
        ((Button) dialog.findViewById(R.id.bt_buy)).setOnClickListener(new d(tagFlowLayout, numberButton, aVar, dialog));
        ((Button) dialog.findViewById(2131296581)).setOnClickListener(new e(tagFlowLayout, numberButton, aVar, dialog));
    }

    private void P0() {
        Dialog dialog = new Dialog(this.T, R.style.Dialog_FullScreen);
        dialog.setContentView(R.layout.dialog_specifications);
        dialog.getWindow().setGravity(80);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        dialog.getWindow().setAttributes(attributes);
        dialog.show();
        ListView listView = (ListView) dialog.findViewById(2131298096);
        ArrayList arrayList = new ArrayList();
        HashMap hashMap = new HashMap();
        hashMap.put("specification", "商品名称：\u3000");
        hashMap.put("value", "商品名称");
        arrayList.add(hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("specification", "商品编号：\u3000");
        hashMap2.put("value", "商品编号");
        arrayList.add(hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("specification", "品牌：\u3000\u3000\u3000");
        hashMap3.put("value", "品牌");
        arrayList.add(hashMap3);
        HashMap hashMap4 = new HashMap();
        hashMap4.put("specification", "上架时间：\u3000");
        hashMap4.put("value", "上架时间");
        arrayList.add(hashMap4);
        HashMap hashMap5 = new HashMap();
        hashMap5.put("specification", "商品毛重：\u3000");
        hashMap5.put("value", "商品毛重");
        arrayList.add(hashMap5);
        HashMap hashMap6 = new HashMap();
        hashMap6.put("specification", "库存：\u3000\u3000\u3000");
        hashMap6.put("value", "库存");
        arrayList.add(hashMap6);
        HashMap hashMap7 = new HashMap();
        hashMap7.put("specification", "面料：\u3000\u3000\u3000");
        hashMap7.put("value", "面料");
        arrayList.add(hashMap7);
        listView.setAdapter((ListAdapter) new f(this.T, R.layout.item_for_specifications, arrayList));
        ((ImageView) dialog.findViewById(2131297111)).setOnClickListener(new g(dialog));
    }

    private void Q0() {
        new ShareAction(this).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).setShareboardclickCallback(new m()).open();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
        this.f19151a0.setOnSlideDetailsListener(new i());
        this.J0.setOnClickListener(this);
        this.S0.setOnClickListener(this);
        this.T0.setOnClickListener(this);
        this.Y.setOnClickListener(this);
        this.O0.setOnClickListener(this);
        this.P0.setOnClickListener(this);
        this.Q0.setOnClickListener(this);
        this.W.setOnClickListener(this);
        this.R0.setOnClickListener(this);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        setTitle("商品详情");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        if (!LoginUser.getLoginUser().isLogin()) {
            startActivity(new Intent(this.T, (Class<?>) LoginActivity.class));
        } else {
            new com.bxkj.base.auth.a(this.T).i(new h()).b(getSupportFragmentManager(), 0);
        }
    }

    private void H0() {
        String str;
        if (LoginUser.getLoginUser().isLogin() && LoginUser.getLoginUser().isAuthorizationInMall()) {
            str = LoginUser.getLoginUser().getOpenId();
        } else {
            str = null;
        }
        Http.with(this.T).hideOtherStatusMessage().setObservable(((x.g) Http.getApiService(x.g.class)).d(this.V0, str)).setDataListener(new n());
    }

    private void K0() {
        Drawable drawable = getResources().getDrawable(R.mipmap.goods_collection_star_red);
        drawable.setBounds(0, 0, u.a(21.0f, this.T), u.a(21.0f, this.T));
        this.O0.setCompoundDrawables(null, drawable, null, null);
        this.O0.setText("已收藏");
    }

    private void L0() {
        Drawable drawable = getResources().getDrawable(R.mipmap.goods_collection_star_grey);
        drawable.setBounds(0, 0, u.a(21.0f, this.T), u.a(21.0f, this.T));
        this.O0.setCompoundDrawables(null, drawable, null, null);
        this.O0.setText("收藏");
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_goods_detail;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
        if (getIntent().hasExtra("goodsId")) {
            this.V0 = getIntent().getStringExtra("goodsId");
        }
        H0();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        this.W = (FloatingActionButton) findViewById(R.id.fb_go_top);
        this.G0 = (TextView) findViewById(R.id.tv_origin_price);
        this.f19151a0 = (SlideDetailsLayout) findViewById(R.id.tb);
        this.f19152b0 = (ScrollView) findViewById(R.id.mHeader);
        this.f19153c0 = (ScrollView) findViewById(R.id.mFooter);
        this.f19154k0 = (LinearLayout) this.f19152b0.getChildAt(0);
        this.f19155p0 = (CycleViewPager) findViewById(R.id.cv);
        this.G0.getPaint().setFlags(16);
        SmartWebView smartWebView = (SmartWebView) findViewById(R.id.wv);
        this.F0 = smartWebView;
        smartWebView.j("http://btblcn.com//mobi//commodity//details//de90164762b24a299f45a143e1dbe1ba");
        this.J0 = (TextView) findViewById(R.id.tv_specifications);
        this.S0 = (Button) findViewById(2131296581);
        this.T0 = (Button) findViewById(R.id.bt_buy);
        this.L0 = (TextView) findViewById(2131298986);
        this.M0 = (TextView) findViewById(2131299047);
        this.H0 = (TextView) findViewById(R.id.tv_stock);
        this.I0 = (TextView) findViewById(R.id.tv_sale_num);
        this.X = (RelativeLayout) findViewById(2131298404);
        this.N0 = (TextView) findViewById(R.id.tv_indicator);
        this.Y = (LinearLayout) findViewById(R.id.ll_select);
        this.O0 = (TextView) findViewById(R.id.tv_collect);
        this.R0 = (TextView) findViewById(2131299035);
        this.P0 = (TextView) findViewById(R.id.tv_cart);
        this.K0 = (TextView) findViewById(R.id.tv_post_price_desc);
        this.Q0 = (TextView) findViewById(R.id.tv_share);
        this.Z = (LinearLayout) findViewById(R.id.ll_bottom_menu);
        this.U0 = (Button) findViewById(R.id.bt_under_the_shelf);
        this.X.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
        switch (v5.getId()) {
            case 2131296581:
                O0();
                break;
            case R.id.bt_buy /* 2131296589 */:
                O0();
                break;
            case R.id.fb_go_top /* 2131296971 */:
                this.f19152b0.smoothScrollTo(0, 0);
                this.f19151a0.smoothClose(true);
                break;
            case R.id.ll_select /* 2131298074 */:
                O0();
                break;
            case R.id.tv_cart /* 2131298827 */:
                new com.bxkj.base.auth.a(this.T).i(new k()).b(getSupportFragmentManager(), 0);
                break;
            case R.id.tv_collect /* 2131298841 */:
                new com.bxkj.base.auth.a(this.T).i(new j()).b(getSupportFragmentManager(), 0);
                break;
            case 2131299035:
                new iOSTwoButtonDialog(this.T).setTitle("提示").setMessage(getString(2131952741)).setRightButtonOnClickListener(new l()).show();
                break;
            case R.id.tv_share /* 2131299100 */:
                Q0();
                break;
            case R.id.tv_specifications /* 2131299108 */:
                P0();
                break;
        }
    }
}
