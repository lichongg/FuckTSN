package com.bxkj.student.v2.ui.sports.v3.detail;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import cn.bluemobi.dylan.base.view.NoSlidingViewPager;
import com.bxkj.base.v2.base.BaseActivity;
import com.bxkj.base.v2.common.utils.c0;
import com.bxkj.student.R;
import com.bxkj.student.common.utils.k;
import com.bxkj.student.databinding.AcV3RecordDetailBinding;
import com.bxkj.student.v2.common.utils.i;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.BasicFragment;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.DataFragment;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordChartFragment;
import com.bxkj.student.v2.ui.sports.v3.detail.tab.V3RecordTraceFragment;
import com.bxkj.student.v2.vm.sports.record.RecordDetailVM;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;
import kotlin.collections.i1;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import kotlin.n1;
import kotlin.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nV3RecordDetailActivity.kt\nKotlin\n*S Kotlin\n*F\n+ 1 V3RecordDetailActivity.kt\ncom/bxkj/student/v2/ui/sports/v3/detail/V3RecordDetailActivity\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,177:1\n1#2:178\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class V3RecordDetailActivity extends BaseActivity<AcV3RecordDetailBinding, RecordDetailVM> {

    @Nullable
    private V3RecordTraceFragment U;

    @Nullable
    private BasicFragment V;

    @Nullable
    private V3RecordChartFragment W;

    @Nullable
    private DataFragment X;

    @NotNull
    private final String[] Y = {"概况", "轨迹", "图表", "数据"};

    private final void O() {
        final ArrayList arrayList = new ArrayList();
        this.U = new V3RecordTraceFragment();
        this.V = new BasicFragment();
        this.W = new V3RecordChartFragment();
        this.X = new DataFragment();
        BasicFragment basicFragment = this.V;
        g0.m(basicFragment);
        arrayList.add(basicFragment);
        V3RecordTraceFragment v3RecordTraceFragment = this.U;
        g0.m(v3RecordTraceFragment);
        arrayList.add(v3RecordTraceFragment);
        V3RecordChartFragment v3RecordChartFragment = this.W;
        g0.m(v3RecordChartFragment);
        arrayList.add(v3RecordChartFragment);
        DataFragment dataFragment = this.X;
        g0.m(dataFragment);
        arrayList.add(dataFragment);
        NoSlidingViewPager noSlidingViewPager = L().viewPager;
        final FragmentManager supportFragmentManager = getSupportFragmentManager();
        noSlidingViewPager.setAdapter(new FragmentPagerAdapter(supportFragmentManager) { // from class: com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity$setData$1
            @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
            public void destroyItem(ViewGroup container, int i6, Object object) {
                g0.p(container, "container");
                g0.p(object, "object");
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public int getCount() {
                return arrayList.size();
            }

            @Override // androidx.fragment.app.FragmentPagerAdapter
            public Fragment getItem(int i6) {
                return arrayList.get(i6);
            }

            @Override // androidx.viewpager.widget.PagerAdapter
            public CharSequence getPageTitle(int i6) {
                String[] strArr;
                strArr = V3RecordDetailActivity.this.Y;
                return strArr[i6];
            }
        });
        L().tb.setupWithViewPager(L().viewPager);
        if (getIntent().hasExtra("exerciseRecordId")) {
            D().I(getIntent().getStringExtra("exerciseRecordId"));
        }
        if (getIntent().hasExtra("identify")) {
            D().J(getIntent().getStringExtra("identify"));
        }
        D().B();
        M();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(final V3RecordDetailActivity v3RecordDetailActivity, final Bitmap bitmap, SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
        UMImage uMImage = new UMImage(v3RecordDetailActivity.H(), bitmap);
        if (snsPlatform.mKeyword.equals("tsnCircle")) {
            v3RecordDetailActivity.D().D(new Function1() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.a
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    n1 S;
                    S = V3RecordDetailActivity.S(V3RecordDetailActivity.this, bitmap, (Map) obj);
                    return S;
                }
            });
        } else {
            new ShareAction(v3RecordDetailActivity.r()).setPlatform(share_media).setCallback(new UMShareListener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.V3RecordDetailActivity$shareImage$1$2
                @Override // com.umeng.socialize.UMShareListener
                public void onCancel(SHARE_MEDIA platform) {
                    g0.p(platform, "platform");
                    Toast.makeText(V3RecordDetailActivity.this.H(), " 分享取消了", 0).show();
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onError(SHARE_MEDIA platform, Throwable t5) {
                    g0.p(platform, "platform");
                    g0.p(t5, "t");
                    t5.printStackTrace();
                    Toast.makeText(V3RecordDetailActivity.this.H(), " 分享失败啦", 0).show();
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onResult(SHARE_MEDIA platform) {
                    g0.p(platform, "platform");
                }

                @Override // com.umeng.socialize.UMShareListener
                public void onStart(SHARE_MEDIA share_media2) {
                    g0.p(share_media2, "share_media");
                }
            }).withMedia(uMImage).share();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 S(V3RecordDetailActivity v3RecordDetailActivity, Bitmap bitmap, Map it) {
        g0.p(it, "it");
        File a6 = com.bxkj.student.v2.common.utils.c.f20881a.a(v3RecordDetailActivity.H(), bitmap);
        if (a6 != null) {
            i iVar = i.f20904a;
            Context H = v3RecordDetailActivity.H();
            c0 c0Var = c0.f16887a;
            iVar.b(H, i1.j0(o0.a(CommonNetImpl.NAME, c0Var.t(it, CommonNetImpl.NAME)), o0.a("linkUrl", c0Var.t(it, "linkUrl")), o0.a("imagePath", a6.getPath())));
        }
        return n1.f44123a;
    }

    public final void Q(@NotNull final Bitmap bitmap) {
        g0.p(bitmap, "bitmap");
        new ShareAction(r()).setDisplayList(SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE).addButton("圈子", "tsnCircle", "circle_icon", "circle_icon").setShareboardclickCallback(new ShareBoardlistener() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.b
            @Override // com.umeng.socialize.utils.ShareBoardlistener
            public final void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                V3RecordDetailActivity.R(V3RecordDetailActivity.this, bitmap, snsPlatform, share_media);
            }
        }).open();
    }

    public final void T() {
        new V3ExceptionDialog().show(J(), "V3ExceptionDialog");
    }

    public final void U() {
        new V3RankTipsDialog().show(J(), "showRankTipsDialog");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(V3RecordDetailActivity v3RecordDetailActivity) {
        v3RecordDetailActivity.O();
    }

    public final void M() {
        if (TextUtils.isEmpty(D().A())) {
            D().y();
        } else {
            D().x();
        }
    }

    public final void P() {
        DataFragment dataFragment;
        if (L().tb.getSelectedTabPosition() == 0) {
            BasicFragment basicFragment = this.V;
            if (basicFragment != null) {
                Q(basicFragment.h());
                return;
            }
            return;
        }
        if (L().tb.getSelectedTabPosition() == 1) {
            V3RecordTraceFragment v3RecordTraceFragment = this.U;
            if (v3RecordTraceFragment != null) {
                v3RecordTraceFragment.W();
                return;
            }
            return;
        }
        if (L().tb.getSelectedTabPosition() == 2) {
            V3RecordChartFragment v3RecordChartFragment = this.W;
            if (v3RecordChartFragment != null) {
                Q(v3RecordChartFragment.i());
                return;
            }
            return;
        }
        if (L().tb.getSelectedTabPosition() == 3 && (dataFragment = this.X) != null) {
            Q(dataFragment.g());
        }
    }

    @Override // com.bxkj.base.v2.base.a
    public void t() {
        L().setMActivity(this);
        k.g(r(), ContextCompat.getColor(H(), R.color.v3_tab_color3));
        L().setMActivity(this);
        getWindow().getDecorView().post(new Runnable() { // from class: com.bxkj.student.v2.ui.sports.v3.detail.c
            @Override // java.lang.Runnable
            public final void run() {
                V3RecordDetailActivity.N(V3RecordDetailActivity.this);
            }
        });
    }

    @Override // com.bxkj.base.v2.base.a
    public void p() {
    }
}
