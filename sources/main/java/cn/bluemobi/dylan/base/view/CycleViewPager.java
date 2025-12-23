package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import cn.bluemobi.dylan.base.R;
import com.bumptech.glide.b;
import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class CycleViewPager extends FrameLayout implements ViewPager.OnPageChangeListener {
    private static final String TAG = "CycleViewPager";
    private int WHEEL;
    private int WHEEL_WAIT;
    private int delay;
    private int dotHeight;
    private int dotWidth;
    private Handler handler;
    private ImageCycleViewSelectListener imageCycleViewSelectListener;
    private List<String> infos;
    private List<Integer> infos0;
    private boolean isCycle;
    private boolean isScrolling;
    private boolean isWheel;
    private ViewPagerAdapter mAdapter;
    private Context mContext;
    private int mCurrentPosition;
    private ImageCycleViewListener mImageCycleViewListener;
    private LinearLayout mIndicatorLayout;
    private int mIndicatorSelected;
    private int mIndicatorUnselected;
    private ImageView[] mIndicators;
    private TextView mTitle;
    private ViewPager mViewPager;
    private List<View> mViews;
    private long releaseTime;
    final Runnable runnable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ImageCycleViewListener {
        void onImageClick(String str, int i6, View view);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface ImageCycleViewSelectListener {
        void onItemSelect(int i6);
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class ViewPagerAdapter extends PagerAdapter {
        private ViewPagerAdapter() {
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i6, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            return CycleViewPager.this.mViews.size();
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public View instantiateItem(ViewGroup viewGroup, int i6) {
            View view = (View) CycleViewPager.this.mViews.get(i6);
            if (CycleViewPager.this.mImageCycleViewListener != null) {
                view.setOnClickListener(new View.OnClickListener() { // from class: cn.bluemobi.dylan.base.view.CycleViewPager.ViewPagerAdapter.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view2) {
                        CycleViewPager.this.mImageCycleViewListener.onImageClick((String) CycleViewPager.this.infos.get(CycleViewPager.this.mCurrentPosition - 1), CycleViewPager.this.mCurrentPosition - 1, view2);
                    }
                });
            }
            viewGroup.addView(view);
            return view;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }
    }

    public CycleViewPager(Context context) {
        this(context, null);
    }

    private View getImageView(Context context, int i6) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        b.D(context).p(Integer.valueOf(i6)).m1(imageView);
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    public static void setText(TextView textView, String str) {
        if (str == null || textView == null) {
            return;
        }
        textView.setText(str);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i6) {
        if (i6 == 1) {
            this.isScrolling = true;
            return;
        }
        if (i6 == 0) {
            this.releaseTime = System.currentTimeMillis();
            this.mViewPager.setCurrentItem(this.mCurrentPosition, false);
        }
        this.isScrolling = false;
    }

    public void setData(List<String> list, ImageCycleViewListener imageCycleViewListener) {
        setData(list, imageCycleViewListener, 0);
    }

    public void setDataResource(List<Integer> list, ImageCycleViewListener imageCycleViewListener) {
        setDataResource(list, imageCycleViewListener, 0);
    }

    public CycleViewPager(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.pub_layout_cycle_view, (ViewGroup) this, true);
        this.mViewPager = (ViewPager) findViewById(R.id.cycle_view_pager);
        this.mTitle = (TextView) findViewById(R.id.cycle_title);
        this.mIndicatorLayout = (LinearLayout) findViewById(R.id.cycle_indicator);
        this.handler = new Handler() { // from class: cn.bluemobi.dylan.base.view.CycleViewPager.2
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == CycleViewPager.this.WHEEL && CycleViewPager.this.mViews.size() > 0) {
                    if (!CycleViewPager.this.isScrolling) {
                        CycleViewPager.this.mViewPager.setCurrentItem((CycleViewPager.this.mCurrentPosition + 1) % CycleViewPager.this.mViews.size(), true);
                    }
                    CycleViewPager.this.releaseTime = System.currentTimeMillis();
                    CycleViewPager.this.handler.removeCallbacks(CycleViewPager.this.runnable);
                    CycleViewPager.this.handler.postDelayed(CycleViewPager.this.runnable, r0.delay);
                    return;
                }
                if (message.what == CycleViewPager.this.WHEEL_WAIT && CycleViewPager.this.mViews.size() > 0) {
                    CycleViewPager.this.handler.removeCallbacks(CycleViewPager.this.runnable);
                    CycleViewPager.this.handler.postDelayed(CycleViewPager.this.runnable, r0.delay);
                }
            }
        };
    }

    private void setIndicator(int i6) {
        ImageView[] imageViewArr;
        ImageCycleViewSelectListener imageCycleViewSelectListener = this.imageCycleViewSelectListener;
        if (imageCycleViewSelectListener != null) {
            imageCycleViewSelectListener.onItemSelect(i6);
        }
        int i7 = 0;
        while (true) {
            try {
                imageViewArr = this.mIndicators;
                if (i7 >= imageViewArr.length) {
                    break;
                }
                imageViewArr[i7].setBackgroundResource(this.mIndicatorUnselected);
                i7++;
            } catch (Exception unused) {
                return;
            }
        }
        if (imageViewArr.length > i6) {
            imageViewArr[i6].setBackgroundResource(this.mIndicatorSelected);
        }
    }

    public static void setText(TextView textView, int i6) {
        if (textView != null) {
            setText(textView, i6 + "");
        }
    }

    public boolean isCycle() {
        return this.isCycle;
    }

    public boolean isWheel() {
        return this.isWheel;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        this.handler.removeCallbacks(this.runnable);
        super.onDetachedFromWindow();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i6) {
        int size = this.mViews.size();
        int i7 = size - 1;
        this.mCurrentPosition = i6;
        if (this.isCycle) {
            if (i6 == 0) {
                this.mCurrentPosition = size - 2;
            } else if (i6 == i7) {
                this.mCurrentPosition = 1;
            }
            i6 = this.mCurrentPosition - 1;
        }
        setIndicator(i6);
    }

    public void refreshData() {
        ViewPagerAdapter viewPagerAdapter = this.mAdapter;
        if (viewPagerAdapter != null) {
            viewPagerAdapter.notifyDataSetChanged();
        }
    }

    public void setCycle(boolean z5) {
        this.isCycle = z5;
    }

    public void setData(List<String> list, ImageCycleViewListener imageCycleViewListener, int i6) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        this.mViews.clear();
        this.infos = list;
        if (this.isCycle) {
            this.mViews.add(getImageView(this.mContext, list.get(list.size() - 1)));
            for (int i7 = 0; i7 < this.infos.size(); i7++) {
                this.mViews.add(getImageView(this.mContext, this.infos.get(i7)));
            }
            this.mViews.add(getImageView(this.mContext, this.infos.get(0)));
        } else {
            for (int i8 = 0; i8 < this.infos.size(); i8++) {
                this.mViews.add(getImageView(this.mContext, this.infos.get(i8)));
            }
        }
        List<View> list2 = this.mViews;
        if (list2 == null || list2.size() == 0) {
            setVisibility(8);
            return;
        }
        this.mImageCycleViewListener = imageCycleViewListener;
        int size = this.mViews.size();
        this.mIndicators = new ImageView[size];
        if (this.isCycle) {
            this.mIndicators = new ImageView[size - 2];
        }
        this.mIndicatorLayout.removeAllViews();
        int i9 = 0;
        while (true) {
            ImageView[] imageViewArr = this.mIndicators;
            if (i9 >= imageViewArr.length) {
                break;
            }
            imageViewArr[i9] = new ImageView(this.mContext);
            this.mIndicators[i9].setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dotWidth, this.dotHeight);
            layoutParams.setMargins(10, 0, 10, 0);
            this.mIndicators[i9].setLayoutParams(layoutParams);
            this.mIndicatorLayout.addView(this.mIndicators[i9]);
            i9++;
        }
        this.mAdapter = new ViewPagerAdapter();
        setIndicator(0);
        this.mViewPager.setOffscreenPageLimit(3);
        this.mViewPager.setOnPageChangeListener(this);
        this.mViewPager.setAdapter(this.mAdapter);
        if (i6 < 0 || i6 >= this.mViews.size()) {
            i6 = 0;
        }
        if (this.isCycle) {
            i6++;
        }
        this.mViewPager.setCurrentItem(i6);
        setWheel(isWheel());
    }

    public void setDataResource(List<Integer> list, ImageCycleViewListener imageCycleViewListener, int i6) {
        if (list == null || list.size() == 0) {
            setVisibility(8);
            return;
        }
        this.mViews.clear();
        this.infos0 = list;
        if (this.isCycle) {
            this.mViews.add(getImageView(this.mContext, this.infos.get(r3.size() - 1)));
            for (int i7 = 0; i7 < this.infos.size(); i7++) {
                this.mViews.add(getImageView(this.mContext, this.infos.get(i7)));
            }
            this.mViews.add(getImageView(this.mContext, this.infos.get(0)));
        } else {
            for (int i8 = 0; i8 < this.infos.size(); i8++) {
                this.mViews.add(getImageView(this.mContext, this.infos.get(i8)));
            }
        }
        List<View> list2 = this.mViews;
        if (list2 == null || list2.size() == 0) {
            setVisibility(8);
            return;
        }
        this.mImageCycleViewListener = imageCycleViewListener;
        int size = this.mViews.size();
        this.mIndicators = new ImageView[size];
        if (this.isCycle) {
            this.mIndicators = new ImageView[size - 2];
        }
        this.mIndicatorLayout.removeAllViews();
        int i9 = 0;
        while (true) {
            ImageView[] imageViewArr = this.mIndicators;
            if (i9 >= imageViewArr.length) {
                break;
            }
            imageViewArr[i9] = new ImageView(this.mContext);
            this.mIndicators[i9].setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.dotWidth, this.dotHeight);
            layoutParams.setMargins(10, 0, 10, 0);
            this.mIndicators[i9].setLayoutParams(layoutParams);
            this.mIndicatorLayout.addView(this.mIndicators[i9]);
            i9++;
        }
        this.mAdapter = new ViewPagerAdapter();
        setIndicator(0);
        this.mViewPager.setOffscreenPageLimit(3);
        this.mViewPager.setOnPageChangeListener(this);
        this.mViewPager.setAdapter(this.mAdapter);
        if (i6 < 0 || i6 >= this.mViews.size()) {
            i6 = 0;
        }
        if (this.isCycle) {
            i6++;
        }
        this.mViewPager.setCurrentItem(i6);
        setWheel(isWheel());
    }

    public void setDelay(int i6) {
        this.delay = i6;
    }

    public void setImageCycleViewSelectListener(ImageCycleViewSelectListener imageCycleViewSelectListener) {
        this.imageCycleViewSelectListener = imageCycleViewSelectListener;
    }

    public void setIndicatorSize(int i6, int i7) {
        this.dotWidth = i6;
        this.dotHeight = i7;
    }

    public void setIndicators(int i6, int i7) {
        this.mIndicatorSelected = i6;
        this.mIndicatorUnselected = i7;
    }

    public void setWheel(boolean z5) {
        this.isWheel = z5;
        this.isCycle = true;
        if (z5) {
            this.handler.postDelayed(this.runnable, this.delay);
        }
    }

    public CycleViewPager(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.WHEEL = 100;
        this.WHEEL_WAIT = 101;
        this.mViews = new ArrayList();
        this.isScrolling = false;
        this.isCycle = true;
        this.isWheel = true;
        this.delay = 3000;
        this.mCurrentPosition = 0;
        this.releaseTime = 0L;
        this.runnable = new Runnable() { // from class: cn.bluemobi.dylan.base.view.CycleViewPager.1
            @Override // java.lang.Runnable
            public void run() {
                if (CycleViewPager.this.mContext == null || !CycleViewPager.this.isWheel) {
                    return;
                }
                if (System.currentTimeMillis() - CycleViewPager.this.releaseTime > CycleViewPager.this.delay - 500) {
                    CycleViewPager.this.handler.sendEmptyMessage(CycleViewPager.this.WHEEL);
                } else {
                    CycleViewPager.this.handler.sendEmptyMessage(CycleViewPager.this.WHEEL_WAIT);
                }
            }
        };
        this.dotWidth = -2;
        this.dotHeight = -2;
        this.mContext = context;
        initView();
    }

    private View getImageView(Context context, String str) {
        RelativeLayout relativeLayout = new RelativeLayout(context);
        ImageView imageView = new ImageView(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(layoutParams);
        try {
            b.D(context).p(Integer.valueOf(Integer.parseInt(str))).m1(imageView);
        } catch (NumberFormatException unused) {
            b.D(context).a(str).m1(imageView);
        }
        ImageView imageView2 = new ImageView(context);
        imageView2.setLayoutParams(layoutParams);
        relativeLayout.addView(imageView);
        relativeLayout.addView(imageView2);
        return relativeLayout;
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i6, float f6, int i7) {
    }
}
