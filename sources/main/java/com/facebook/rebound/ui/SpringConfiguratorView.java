package com.facebook.rebound.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.facebook.rebound.OrigamiValueConverter;
import com.facebook.rebound.Spring;
import com.facebook.rebound.SpringConfig;
import com.facebook.rebound.SpringConfigRegistry;
import com.facebook.rebound.SpringListener;
import com.facebook.rebound.SpringSystem;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.net.ftp.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes4.dex */
public class SpringConfiguratorView extends FrameLayout {

    /* renamed from: n, reason: collision with root package name */
    private static final int f32513n = 100000;

    /* renamed from: o, reason: collision with root package name */
    private static final float f32514o = 0.0f;

    /* renamed from: p, reason: collision with root package name */
    private static final float f32515p = 200.0f;

    /* renamed from: q, reason: collision with root package name */
    private static final float f32516q = 0.0f;

    /* renamed from: r, reason: collision with root package name */
    private static final float f32517r = 50.0f;

    /* renamed from: s, reason: collision with root package name */
    private static final DecimalFormat f32518s = new DecimalFormat("#.#");

    /* renamed from: a, reason: collision with root package name */
    private final SpinnerAdapter f32519a;

    /* renamed from: b, reason: collision with root package name */
    private final List<SpringConfig> f32520b;

    /* renamed from: c, reason: collision with root package name */
    private final Spring f32521c;

    /* renamed from: d, reason: collision with root package name */
    private final float f32522d;

    /* renamed from: e, reason: collision with root package name */
    private final float f32523e;

    /* renamed from: f, reason: collision with root package name */
    private final SpringConfigRegistry f32524f;

    /* renamed from: g, reason: collision with root package name */
    private final int f32525g;

    /* renamed from: h, reason: collision with root package name */
    private SeekBar f32526h;

    /* renamed from: i, reason: collision with root package name */
    private SeekBar f32527i;

    /* renamed from: j, reason: collision with root package name */
    private Spinner f32528j;

    /* renamed from: k, reason: collision with root package name */
    private TextView f32529k;

    /* renamed from: l, reason: collision with root package name */
    private TextView f32530l;

    /* renamed from: m, reason: collision with root package name */
    private SpringConfig f32531m;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.facebook.rebound.ui.SpringConfiguratorView$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class OnNubTouchListener implements View.OnTouchListener {
        private OnNubTouchListener() {
        }

        /* synthetic */ OnNubTouchListener(SpringConfiguratorView springConfiguratorView, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                SpringConfiguratorView.this.q();
                return true;
            }
            return true;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class RevealerSpringListener implements SpringListener {
        private RevealerSpringListener() {
        }

        /* synthetic */ RevealerSpringListener(SpringConfiguratorView springConfiguratorView, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringUpdate(Spring spring) {
            float f6 = (float) spring.f();
            float f7 = SpringConfiguratorView.this.f32523e;
            SpringConfiguratorView.this.setTranslationY((f6 * (SpringConfiguratorView.this.f32522d - f7)) + f7);
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringActivate(Spring spring) {
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringAtRest(Spring spring) {
        }

        @Override // com.facebook.rebound.SpringListener
        public void onSpringEndStateChange(Spring spring) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class SeekbarListener implements SeekBar.OnSeekBarChangeListener {
        private SeekbarListener() {
        }

        /* synthetic */ SeekbarListener(SpringConfiguratorView springConfiguratorView, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i6, boolean z5) {
            if (seekBar == SpringConfiguratorView.this.f32526h) {
                double d6 = ((i6 * 200.0f) / 100000.0f) + 0.0f;
                SpringConfiguratorView.this.f32531m.f32504b = OrigamiValueConverter.d(d6);
                String format = SpringConfiguratorView.f32518s.format(d6);
                SpringConfiguratorView.this.f32530l.setText("T:" + format);
            }
            if (seekBar == SpringConfiguratorView.this.f32527i) {
                double d7 = ((i6 * 50.0f) / 100000.0f) + 0.0f;
                SpringConfiguratorView.this.f32531m.f32503a = OrigamiValueConverter.a(d7);
                String format2 = SpringConfiguratorView.f32518s.format(d7);
                SpringConfiguratorView.this.f32529k.setText("F:" + format2);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class SpinnerAdapter extends BaseAdapter {

        /* renamed from: a, reason: collision with root package name */
        private final Context f32535a;

        /* renamed from: b, reason: collision with root package name */
        private final List<String> f32536b = new ArrayList();

        @Override // android.widget.Adapter
        public long getItemId(int i6) {
            return i6;
        }

        public SpinnerAdapter(Context context) {
            this.f32535a = context;
        }

        public void a(String str) {
            this.f32536b.add(str);
            notifyDataSetChanged();
        }

        public void b() {
            this.f32536b.clear();
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            return this.f32536b.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i6) {
            return this.f32536b.get(i6);
        }

        @Override // android.widget.Adapter
        public View getView(int i6, View view, ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                textView = new TextView(this.f32535a);
                textView.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
                int f6 = Util.f(12.0f, SpringConfiguratorView.this.getResources());
                textView.setPadding(f6, f6, f6, f6);
                textView.setTextColor(SpringConfiguratorView.this.f32525g);
            } else {
                textView = (TextView) view;
            }
            textView.setText(this.f32536b.get(i6));
            return textView;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class SpringSelectedListener implements AdapterView.OnItemSelectedListener {
        private SpringSelectedListener() {
        }

        /* synthetic */ SpringSelectedListener(SpringConfiguratorView springConfiguratorView, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i6, long j6) {
            SpringConfiguratorView springConfiguratorView = SpringConfiguratorView.this;
            springConfiguratorView.f32531m = (SpringConfig) springConfiguratorView.f32520b.get(i6);
            SpringConfiguratorView springConfiguratorView2 = SpringConfiguratorView.this;
            springConfiguratorView2.r(springConfiguratorView2.f32531m);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    public SpringConfiguratorView(Context context) {
        this(context, null);
    }

    public SpringConfiguratorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q() {
        this.f32521c.x(this.f32521c.h() == 1.0d ? 0.0d : 1.0d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(SpringConfig springConfig) {
        int round = Math.round(((((float) OrigamiValueConverter.c(springConfig.f32504b)) - 0.0f) * 100000.0f) / 200.0f);
        int round2 = Math.round(((((float) OrigamiValueConverter.b(springConfig.f32503a)) - 0.0f) * 100000.0f) / 50.0f);
        this.f32526h.setProgress(round);
        this.f32527i.setProgress(round2);
    }

    public void p() {
        Map<SpringConfig, String> b6 = this.f32524f.b();
        this.f32519a.b();
        this.f32520b.clear();
        for (Map.Entry<SpringConfig, String> entry : b6.entrySet()) {
            if (entry.getKey() != SpringConfig.f32502c) {
                this.f32520b.add(entry.getKey());
                this.f32519a.a(entry.getValue());
            }
        }
        this.f32520b.add(SpringConfig.f32502c);
        this.f32519a.a(b6.get(SpringConfig.f32502c));
        this.f32519a.notifyDataSetChanged();
        if (this.f32520b.size() > 0) {
            this.f32528j.setSelection(0);
        }
    }

    @TargetApi(11)
    public SpringConfiguratorView(Context context, AttributeSet attributeSet, int i6) {
        super(context, attributeSet, i6);
        this.f32520b = new ArrayList();
        this.f32525g = Color.argb(255, l.f50687n, l.f50687n, l.f50687n);
        SpringSystem m6 = SpringSystem.m();
        this.f32524f = SpringConfigRegistry.c();
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(context);
        this.f32519a = spinnerAdapter;
        Resources resources = getResources();
        this.f32523e = Util.f(40.0f, resources);
        float f6 = Util.f(280.0f, resources);
        this.f32522d = f6;
        Spring d6 = m6.d();
        this.f32521c = d6;
        AnonymousClass1 anonymousClass1 = null;
        d6.v(1.0d).x(1.0d).a(new RevealerSpringListener(this, anonymousClass1));
        addView(o(context));
        SeekbarListener seekbarListener = new SeekbarListener(this, anonymousClass1);
        this.f32526h.setMax(100000);
        this.f32526h.setOnSeekBarChangeListener(seekbarListener);
        this.f32527i.setMax(100000);
        this.f32527i.setOnSeekBarChangeListener(seekbarListener);
        this.f32528j.setAdapter((android.widget.SpinnerAdapter) spinnerAdapter);
        this.f32528j.setOnItemSelectedListener(new SpringSelectedListener(this, anonymousClass1));
        p();
        setTranslationY(f6);
    }

    private View o(Context context) {
        Resources resources = getResources();
        int f6 = Util.f(5.0f, resources);
        int f7 = Util.f(10.0f, resources);
        int f8 = Util.f(20.0f, resources);
        TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.setMargins(0, 0, f6, 0);
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(Util.a(-1, Util.f(300.0f, resources)));
        FrameLayout frameLayout2 = new FrameLayout(context);
        FrameLayout.LayoutParams b6 = Util.b();
        b6.setMargins(0, f8, 0, 0);
        frameLayout2.setLayoutParams(b6);
        frameLayout2.setBackgroundColor(Color.argb(100, 0, 0, 0));
        frameLayout.addView(frameLayout2);
        this.f32528j = new Spinner(context, 0);
        FrameLayout.LayoutParams c6 = Util.c();
        c6.gravity = 48;
        c6.setMargins(f7, f7, f7, 0);
        this.f32528j.setLayoutParams(c6);
        frameLayout2.addView(this.f32528j);
        LinearLayout linearLayout = new LinearLayout(context);
        FrameLayout.LayoutParams c7 = Util.c();
        c7.setMargins(0, 0, 0, Util.f(80.0f, resources));
        c7.gravity = 80;
        linearLayout.setLayoutParams(c7);
        linearLayout.setOrientation(1);
        frameLayout2.addView(linearLayout);
        LinearLayout linearLayout2 = new LinearLayout(context);
        FrameLayout.LayoutParams c8 = Util.c();
        c8.setMargins(f7, f7, f7, f8);
        linearLayout2.setPadding(f7, f7, f7, f7);
        linearLayout2.setLayoutParams(c8);
        linearLayout2.setOrientation(0);
        linearLayout.addView(linearLayout2);
        SeekBar seekBar = new SeekBar(context);
        this.f32526h = seekBar;
        seekBar.setLayoutParams(layoutParams);
        linearLayout2.addView(this.f32526h);
        TextView textView = new TextView(getContext());
        this.f32530l = textView;
        textView.setTextColor(this.f32525g);
        FrameLayout.LayoutParams a6 = Util.a(Util.f(50.0f, resources), -1);
        this.f32530l.setGravity(19);
        this.f32530l.setLayoutParams(a6);
        this.f32530l.setMaxLines(1);
        linearLayout2.addView(this.f32530l);
        LinearLayout linearLayout3 = new LinearLayout(context);
        FrameLayout.LayoutParams c9 = Util.c();
        c9.setMargins(f7, f7, f7, f8);
        linearLayout3.setPadding(f7, f7, f7, f7);
        linearLayout3.setLayoutParams(c9);
        linearLayout3.setOrientation(0);
        linearLayout.addView(linearLayout3);
        SeekBar seekBar2 = new SeekBar(context);
        this.f32527i = seekBar2;
        seekBar2.setLayoutParams(layoutParams);
        linearLayout3.addView(this.f32527i);
        TextView textView2 = new TextView(getContext());
        this.f32529k = textView2;
        textView2.setTextColor(this.f32525g);
        FrameLayout.LayoutParams a7 = Util.a(Util.f(50.0f, resources), -1);
        this.f32529k.setGravity(19);
        this.f32529k.setLayoutParams(a7);
        this.f32529k.setMaxLines(1);
        linearLayout3.addView(this.f32529k);
        View view = new View(context);
        FrameLayout.LayoutParams a8 = Util.a(Util.f(60.0f, resources), Util.f(40.0f, resources));
        a8.gravity = 49;
        view.setLayoutParams(a8);
        view.setOnTouchListener(new OnNubTouchListener(this, null));
        view.setBackgroundColor(Color.argb(255, 0, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME, 209));
        frameLayout.addView(view);
        return frameLayout;
    }

    public void n() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        this.f32521c.d();
    }
}
