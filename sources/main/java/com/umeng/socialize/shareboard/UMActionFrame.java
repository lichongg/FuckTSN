package com.umeng.socialize.shareboard;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.umeng.socialize.shareboard.widgets.SocializeViewPager;
import com.umeng.socialize.utils.SLog;
import com.umeng.socialize.utils.UmengText;
import java.util.List;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes7.dex */
class UMActionFrame extends LinearLayout {
    private ShareBoardConfig mConfig;
    private PopupWindow.OnDismissListener mDismissListener;

    public UMActionFrame(Context context) {
        super(context);
    }

    private boolean verifyMethodExists() {
        try {
        } catch (Exception e6) {
            SLog.error(e6);
        }
        return Class.forName("androidx.viewpager.widget.ViewPager").getMethod("addOnPageChangeListener", ViewPager.OnPageChangeListener.class) != null;
    }

    public void setSnsPlatformData(List<SnsPlatform> list) {
        setSnsPlatformData(list, new ShareBoardConfig());
    }

    public UMActionFrame(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private View createShareTitle() {
        TextView textView = new TextView(getContext());
        textView.setText(this.mConfig.mTitleText);
        textView.setTextColor(this.mConfig.mTitleTextColor);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = dip2px(20.0f);
        textView.setLayoutParams(layoutParams);
        return textView;
    }

    private View createShareboardLayout(List<SnsPlatform> list) {
        final IndicatorView createIndicatorView;
        int i6;
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setBackgroundColor(this.mConfig.mShareboardBgColor);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        ShareBoardConfig shareBoardConfig = this.mConfig;
        if (shareBoardConfig.mShareboardPosition == ShareBoardConfig.SHAREBOARD_POSITION_CENTER && (i6 = shareBoardConfig.mTopMargin) != 0) {
            layoutParams.topMargin = i6;
        }
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(layoutParams);
        if (this.mConfig.mTitleVisibility) {
            linearLayout.addView(createShareTitle());
        }
        int calculateMenuHeightInDp = this.mConfig.calculateMenuHeightInDp(list.size());
        ViewPager createViewPagerInstance = createViewPagerInstance();
        if (createViewPagerInstance != null) {
            SocializeMenuPagerAdapter socializeMenuPagerAdapter = new SocializeMenuPagerAdapter(getContext(), this.mConfig);
            socializeMenuPagerAdapter.setData(list);
            settingMenuLayout(createViewPagerInstance, calculateMenuHeightInDp);
            linearLayout.addView(createViewPagerInstance);
            createViewPagerInstance.setAdapter(socializeMenuPagerAdapter);
            createIndicatorView = this.mConfig.mIndicatorVisibility ? createIndicatorView() : null;
            if (createIndicatorView != null) {
                createIndicatorView.setPageCount(socializeMenuPagerAdapter.getCount());
                linearLayout.addView(createIndicatorView);
            }
            ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() { // from class: com.umeng.socialize.shareboard.UMActionFrame.2
                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageSelected(int i7) {
                    IndicatorView indicatorView = createIndicatorView;
                    if (indicatorView != null) {
                        indicatorView.setSelectedPosition(i7);
                    }
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i7) {
                }

                @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
                public void onPageScrolled(int i7, float f6, int i8) {
                }
            };
            if (verifyMethodExists()) {
                createViewPagerInstance.addOnPageChangeListener(onPageChangeListener);
            } else {
                createViewPagerInstance.setOnPageChangeListener(onPageChangeListener);
            }
        } else {
            SocializeViewPager createSocializeViewPagerInstance = createSocializeViewPagerInstance();
            if (createSocializeViewPagerInstance == null) {
                return null;
            }
            SocializeMenuAdapter socializeMenuAdapter = new SocializeMenuAdapter(getContext(), this.mConfig);
            socializeMenuAdapter.setData(list);
            settingMenuLayout(createSocializeViewPagerInstance, calculateMenuHeightInDp);
            linearLayout.addView(createSocializeViewPagerInstance);
            createSocializeViewPagerInstance.setAdapter(socializeMenuAdapter);
            createIndicatorView = this.mConfig.mIndicatorVisibility ? createIndicatorView() : null;
            if (createIndicatorView != null) {
                createIndicatorView.setPageCount(socializeMenuAdapter.getCount());
                linearLayout.addView(createIndicatorView);
            }
            createSocializeViewPagerInstance.addOnPageChangeListener(new SocializeViewPager.OnPageChangeListener() { // from class: com.umeng.socialize.shareboard.UMActionFrame.3
                @Override // com.umeng.socialize.shareboard.widgets.SocializeViewPager.OnPageChangeListener
                public void onPageSelected(int i7) {
                    IndicatorView indicatorView = createIndicatorView;
                    if (indicatorView != null) {
                        indicatorView.setSelectedPosition(i7);
                    }
                }

                @Override // com.umeng.socialize.shareboard.widgets.SocializeViewPager.OnPageChangeListener
                public void onPageScrollStateChanged(int i7) {
                }

                @Override // com.umeng.socialize.shareboard.widgets.SocializeViewPager.OnPageChangeListener
                public void onPageScrolled(int i7, float f6, int i8) {
                }
            });
        }
        if (this.mConfig.mCancelBtnVisibility) {
            linearLayout.addView(createCancelBtn());
        }
        return linearLayout;
    }

    private SocializeViewPager createSocializeViewPagerInstance() {
        try {
            return (SocializeViewPager) Class.forName("com.umeng.socialize.shareboard.widgets.SocializeViewPager").getConstructor(Context.class).newInstance(getContext());
        } catch (Exception e6) {
            SLog.error(UmengText.SHAREBOARD.NULLJAR, e6);
            return null;
        }
    }

    private ViewPager createViewPagerInstance() {
        try {
            return (ViewPager) Class.forName("androidx.viewpager.widget.ViewPager").getConstructor(Context.class).newInstance(getContext());
        } catch (Exception e6) {
            SLog.error(e6);
            return null;
        }
    }

    private StateListDrawable getBtnBg() {
        ColorDrawable colorDrawable = new ColorDrawable(this.mConfig.mCancelBtnBgColor);
        ColorDrawable colorDrawable2 = new ColorDrawable(this.mConfig.mCancelBtnBgPressedColor);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{R.attr.state_pressed}, colorDrawable2);
        stateListDrawable.addState(new int[0], colorDrawable);
        return stateListDrawable;
    }

    private void init(List<SnsPlatform> list) {
        setBackgroundColor(Color.argb(50, 0, 0, 0));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(100L);
        setAnimation(alphaAnimation);
        setOrientation(1);
        int i6 = this.mConfig.mShareboardPosition;
        if (i6 == ShareBoardConfig.SHAREBOARD_POSITION_BOTTOM) {
            setGravity(80);
        } else if (i6 == ShareBoardConfig.SHAREBOARD_POSITION_CENTER) {
            setGravity(17);
            int dip2px = dip2px(36.0f);
            setPadding(dip2px, 0, dip2px, 0);
        }
        setOnClickListener(new View.OnClickListener() { // from class: com.umeng.socialize.shareboard.UMActionFrame.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UMActionFrame.this.mDismissListener != null) {
                    UMActionFrame.this.mDismissListener.onDismiss();
                }
            }
        });
        View createShareboardLayout = createShareboardLayout(list);
        if (createShareboardLayout == null) {
            return;
        }
        createShareboardLayout.setClickable(true);
        addView(createShareboardLayout);
    }

    private void settingMenuLayout(View view, int i6) {
        int dip2px = dip2px(20.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dip2px(i6));
        layoutParams.topMargin = dip2px;
        int dip2px2 = dip2px(10.0f);
        layoutParams.rightMargin = dip2px2;
        layoutParams.leftMargin = dip2px2;
        view.setLayoutParams(layoutParams);
        view.setPadding(0, 0, 0, dip2px);
    }

    public View createCancelBtn() {
        TextView textView = new TextView(getContext());
        textView.setText(this.mConfig.mCancelBtnText);
        textView.setTextColor(this.mConfig.mCancelBtnColor);
        textView.setClickable(true);
        textView.setTextSize(15.0f);
        textView.setGravity(17);
        ShareBoardConfig shareBoardConfig = this.mConfig;
        if (shareBoardConfig.mCancelBtnBgPressedColor != 0) {
            textView.setBackground(getBtnBg());
        } else {
            textView.setBackgroundColor(shareBoardConfig.mCancelBtnBgColor);
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.umeng.socialize.shareboard.UMActionFrame.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (UMActionFrame.this.mDismissListener != null) {
                    UMActionFrame.this.mDismissListener.onDismiss();
                }
            }
        });
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, dip2px(50.0f)));
        return textView;
    }

    public IndicatorView createIndicatorView() {
        int dip2px = dip2px(20.0f);
        IndicatorView indicatorView = new IndicatorView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = dip2px;
        indicatorView.setLayoutParams(layoutParams);
        ShareBoardConfig shareBoardConfig = this.mConfig;
        indicatorView.setIndicatorColor(shareBoardConfig.mIndicatorNormalColor, shareBoardConfig.mIndicatorSelectedColor);
        indicatorView.setIndicator(3, 5);
        return indicatorView;
    }

    void setDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        this.mDismissListener = onDismissListener;
    }

    @TargetApi(11)
    public UMActionFrame(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
    }

    private int dip2px(float f6) {
        return (int) ((f6 * getContext().getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setSnsPlatformData(List<SnsPlatform> list, ShareBoardConfig shareBoardConfig) {
        if (shareBoardConfig == null) {
            this.mConfig = new ShareBoardConfig();
        } else {
            this.mConfig = shareBoardConfig;
        }
        init(list);
    }

    @TargetApi(21)
    public UMActionFrame(Context context, AttributeSet attributeSet, int i6, int i7) {
        super(context, attributeSet, i6, i7);
    }
}
