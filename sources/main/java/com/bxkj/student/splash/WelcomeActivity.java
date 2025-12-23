package com.bxkj.student.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.bluemobi.dylan.base.BaseActivity;
import cn.bluemobi.dylan.base.view.iOSTwoButtonDialog;
import com.bxkj.base.user.LoginUser;
import com.bxkj.student.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class WelcomeActivity extends BaseActivity {
    private iOSTwoButtonDialog W;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v5) {
            LoginUser.getLoginUser().setLastVersionCode(WelcomeActivity.this.j0());
            WelcomeActivity.this.startActivity(new Intent(((BaseActivity) WelcomeActivity.this).T, (Class<?>) SplashActivity.class));
            WelcomeActivity.this.finish();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b extends PagerAdapter {

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ List f20467f;

        b(final List val$views) {
            this.f20467f = val$views;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) this.f20467f.get(position));
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return this.f20467f.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView((View) this.f20467f.get(position), 0);
            return this.f20467f.get(position);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int j0() {
        try {
            return this.T.getPackageManager().getPackageInfo(this.T.getPackageName(), 0).versionCode;
        } catch (Exception e6) {
            e6.printStackTrace();
            return 0;
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void T() {
        d0(false);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        iOSTwoButtonDialog iostwobuttondialog = this.W;
        if (iostwobuttondialog != null && iostwobuttondialog.isShowing()) {
            this.W.dismiss();
        }
        super.onDestroy();
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    protected int O() {
        return R.layout.ac_welcome;
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void U(Bundle savedInstanceState) {
        k0();
    }

    public void k0() {
        getWindow().setBackgroundDrawableResource(R.mipmap.guide1);
        ViewPager viewPager = new ViewPager(this);
        ArrayList arrayList = new ArrayList();
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        ImageView imageView = new ImageView(this);
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        imageView.setScaleType(scaleType);
        imageView.setLayoutParams(layoutParams);
        imageView.setImageResource(R.mipmap.guide1);
        arrayList.add(imageView);
        ImageView imageView2 = new ImageView(this);
        imageView2.setScaleType(scaleType);
        imageView2.setLayoutParams(layoutParams);
        imageView2.setImageResource(R.mipmap.guide2);
        arrayList.add(imageView2);
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView3 = new ImageView(this);
        imageView3.setScaleType(scaleType);
        imageView3.setLayoutParams(layoutParams);
        imageView3.setImageResource(R.mipmap.guide3);
        relativeLayout.addView(imageView3);
        imageView3.setOnClickListener(new a());
        arrayList.add(relativeLayout);
        viewPager.setAdapter(new b(arrayList));
        setContentView(viewPager);
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void M() {
    }

    @Override // cn.bluemobi.dylan.base.BaseActivity
    public void S() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
