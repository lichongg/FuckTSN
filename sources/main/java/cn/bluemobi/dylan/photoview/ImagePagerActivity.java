package cn.bluemobi.dylan.photoview;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.stub.StubApp;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class ImagePagerActivity extends FragmentActivity {
    private static final String R = "STATE_POSITION";
    public static final String S = "image_index";
    public static final String T = "image_urls";
    public static final String U = "is_show_save_button";
    private HackyViewPager M;
    private int N;
    private TextView O;
    private ImageView P;
    private boolean Q;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i6) {
            ImagePagerActivity.this.O.setText(ImagePagerActivity.this.getString(R.string.viewpager_indicator, Integer.valueOf(i6 + 1), Integer.valueOf(ImagePagerActivity.this.M.getAdapter().getCount())));
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i6) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i6, float f6, int i7) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class b implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String[] f1284a;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class a implements cn.bluemobi.dylan.photoview.c {

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: cn.bluemobi.dylan.photoview.ImagePagerActivity$b$a$a, reason: collision with other inner class name */
            class RunnableC0015a implements Runnable {
                RunnableC0015a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(ImagePagerActivity.this, "已成功保存到相册", 0).show();
                }
            }

            /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
            /* renamed from: cn.bluemobi.dylan.photoview.ImagePagerActivity$b$a$b, reason: collision with other inner class name */
            class RunnableC0016b implements Runnable {
                RunnableC0016b() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(ImagePagerActivity.this, "保存失败，请稍后再试", 0).show();
                }
            }

            a() {
            }

            @Override // cn.bluemobi.dylan.photoview.c
            public void a() {
                ImagePagerActivity.this.runOnUiThread(new RunnableC0016b());
            }

            @Override // cn.bluemobi.dylan.photoview.c
            public void onSuccess() {
                ImagePagerActivity.this.runOnUiThread(new RunnableC0015a());
            }
        }

        b(String[] strArr) {
            this.f1284a = strArr;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ImagePagerActivity imagePagerActivity = ImagePagerActivity.this;
            new Thread(new cn.bluemobi.dylan.photoview.b(imagePagerActivity, this.f1284a[imagePagerActivity.M.getCurrentItem()], new a())).start();
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class c extends FragmentStatePagerAdapter {

        /* renamed from: f, reason: collision with root package name */
        public String[] f1289f;

        public c(FragmentManager fragmentManager, String[] strArr) {
            super(fragmentManager);
            this.f1289f = strArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            String[] strArr = this.f1289f;
            if (strArr == null) {
                return 0;
            }
            return strArr.length;
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i6) {
            return ImageDetailFragment.e(this.f1289f[i6]);
        }
    }

    static {
        StubApp.interface11(7546);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(R, this.M.getCurrentItem());
    }
}
