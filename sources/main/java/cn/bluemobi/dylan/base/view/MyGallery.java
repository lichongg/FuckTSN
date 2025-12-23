package cn.bluemobi.dylan.base.view;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import cn.bluemobi.dylan.base.R;
import java.util.Timer;
import java.util.TimerTask;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class MyGallery extends Gallery implements AdapterView.OnItemSelectedListener {
    private static final int timerAnimation = 1;
    private boolean autoPlay;
    private int count;
    private LinearLayout ll_focus_indicator_container;
    private final Handler mHandler;
    private int preSelImgIndex;
    private final TimerTask task;
    private final Timer timer;

    public MyGallery(Context context) {
        super(context);
        this.preSelImgIndex = 0;
        this.mHandler = new Handler() { // from class: cn.bluemobi.dylan.base.view.MyGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                if (MyGallery.this.getSelectedItemPosition() >= MyGallery.this.getCount() - 1) {
                    MyGallery.this.onKeyDown(21, null);
                } else {
                    MyGallery.this.onKeyDown(22, null);
                }
            }
        };
        Timer timer = new Timer();
        this.timer = timer;
        TimerTask timerTask = new TimerTask() { // from class: cn.bluemobi.dylan.base.view.MyGallery.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MyGallery.this.autoPlay) {
                    MyGallery.this.mHandler.sendEmptyMessage(1);
                } else {
                    MyGallery.this.timer.cancel();
                }
            }
        };
        this.task = timerTask;
        this.autoPlay = true;
        this.count = 0;
        timer.schedule(timerTask, 3000L, 3000L);
    }

    private void init() {
    }

    private void InitFocusIndicatorContainer() {
        this.ll_focus_indicator_container.removeAllViews();
        int i6 = this.count;
        if (i6 == 0) {
            destroy();
            return;
        }
        if (i6 == 1) {
            destroy();
        }
        for (int i7 = 0; i7 < this.count; i7++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setId(i7);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.weight = 1.0f;
            layoutParams.setMargins(10, 10, 10, 10);
            imageView.setLayoutParams(layoutParams);
            imageView.setPadding(0, 0, 0, 0);
            imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.pub_dot_normal));
            this.ll_focus_indicator_container.addView(imageView);
        }
    }

    public void destroy() {
        this.timer.cancel();
        this.mHandler.removeCallbacks(this.task);
    }

    public void init(int i6, LinearLayout linearLayout) {
        this.count = i6;
        this.ll_focus_indicator_container = linearLayout;
        InitFocusIndicatorContainer();
        setOnItemSelectedListener(this);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i6, long j6) {
        int i7 = this.count;
        if (i7 == 0) {
            return;
        }
        int i8 = i6 % i7;
        ImageView imageView = (ImageView) this.ll_focus_indicator_container.findViewById(this.preSelImgIndex);
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(getContext().getResources().getDrawable(R.drawable.pub_dot_normal));
        ((ImageView) this.ll_focus_indicator_container.findViewById(i8)).setImageDrawable(getContext().getResources().getDrawable(R.drawable.pub_dot_focus));
        this.preSelImgIndex = i8;
    }

    public void setAutoPlay(boolean z5) {
        this.autoPlay = z5;
    }

    private boolean isScrollingLeft(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent2.getX() > motionEvent.getX()) {
            return true;
        }
        return false;
    }

    @Override // android.widget.Gallery, android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f6, float f7) {
        int i6;
        if (isScrollingLeft(motionEvent, motionEvent2)) {
            i6 = 21;
        } else {
            i6 = 22;
        }
        onKeyDown(i6, null);
        return true;
    }

    public MyGallery(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.preSelImgIndex = 0;
        this.mHandler = new Handler() { // from class: cn.bluemobi.dylan.base.view.MyGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                if (MyGallery.this.getSelectedItemPosition() >= MyGallery.this.getCount() - 1) {
                    MyGallery.this.onKeyDown(21, null);
                } else {
                    MyGallery.this.onKeyDown(22, null);
                }
            }
        };
        Timer timer = new Timer();
        this.timer = timer;
        TimerTask timerTask = new TimerTask() { // from class: cn.bluemobi.dylan.base.view.MyGallery.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MyGallery.this.autoPlay) {
                    MyGallery.this.mHandler.sendEmptyMessage(1);
                } else {
                    MyGallery.this.timer.cancel();
                }
            }
        };
        this.task = timerTask;
        this.autoPlay = true;
        this.count = 0;
        timer.schedule(timerTask, 3000L, 3000L);
    }

    public MyGallery(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.preSelImgIndex = 0;
        this.mHandler = new Handler() { // from class: cn.bluemobi.dylan.base.view.MyGallery.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                if (MyGallery.this.getSelectedItemPosition() >= MyGallery.this.getCount() - 1) {
                    MyGallery.this.onKeyDown(21, null);
                } else {
                    MyGallery.this.onKeyDown(22, null);
                }
            }
        };
        Timer timer = new Timer();
        this.timer = timer;
        TimerTask timerTask = new TimerTask() { // from class: cn.bluemobi.dylan.base.view.MyGallery.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (MyGallery.this.autoPlay) {
                    MyGallery.this.mHandler.sendEmptyMessage(1);
                } else {
                    MyGallery.this.timer.cancel();
                }
            }
        };
        this.task = timerTask;
        this.autoPlay = true;
        this.count = 0;
        timer.schedule(timerTask, 3000L, 3000L);
        init();
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
