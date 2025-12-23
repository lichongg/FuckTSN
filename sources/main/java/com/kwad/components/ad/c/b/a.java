package com.kwad.components.ad.c.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.kwad.components.ad.c.c.b;
import com.kwad.components.ad.c.e;
import com.kwad.components.ad.c.f;
import com.kwad.components.core.m.c;
import com.kwad.components.core.video.a;
import com.kwad.components.core.widget.KsLogoView;
import com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener;
import com.kwad.sdk.R;
import com.kwad.sdk.api.KsAdVideoPlayConfig;
import com.kwad.sdk.core.imageloader.KSImageLoader;
import com.kwad.sdk.core.imageloader.core.DisplayImageOptionsCompat;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener;
import com.kwad.sdk.core.imageloader.utils.BlurUtils;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.video.videoview.a;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.mvp.Presenter;
import com.kwad.sdk.widget.d;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SuppressLint({"ViewConstructor"})
/* loaded from: D:\Downloads\app\classes6.dex */
public final class a extends c<com.kwad.components.ad.c.c> implements View.OnClickListener, d {
    private KsAdVideoPlayConfig bU;
    private a.b cA;
    private OfflineOnAudioConflictListener cB;
    private f ce;
    private List<Integer> ck;
    private FrameLayout cl;
    private ImageView cm;

    /* renamed from: cn, reason: collision with root package name */
    private LinearLayout f36335cn;
    private ImageView co;
    private boolean cp;
    private com.kwad.sdk.core.video.videoview.a cq;
    private e cr;
    private LinearLayout cs;
    private TextView ct;
    private TextView cu;
    private TextView cv;
    private ImageView cw;
    private KsLogoView cx;
    public InterfaceC0551a cy;
    private a.InterfaceC0692a cz;
    private AdInfo mAdInfo;
    private SceneImpl mAdScene;
    private AdTemplate mAdTemplate;
    private com.kwad.components.core.e.d.c mApkDownloadHelper;
    private Context mContext;
    private boolean mIsAudioEnable;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: com.kwad.components.ad.c.b.a$a, reason: collision with other inner class name */
    public interface InterfaceC0551a {
        void a(int i6, int i7, AdTemplate adTemplate);

        void as();

        void d(AdTemplate adTemplate);

        void e(AdTemplate adTemplate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean f(boolean z5) {
        if (!z5) {
            return false;
        }
        if (!com.kwad.sdk.core.config.e.FL()) {
            return !com.kwad.components.core.t.a.aC(this.mContext).sX() ? com.kwad.components.core.t.a.aC(this.mContext).aQ(false) : !com.kwad.components.core.t.a.aC(this.mContext).sW();
        }
        if (!this.cp) {
            this.cp = com.kwad.components.core.t.a.aC(this.mContext).aQ(true);
        }
        return this.cp;
    }

    @Override // com.kwad.components.core.m.c
    public final boolean ai() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.kwad.components.core.m.c
    /* renamed from: am, reason: merged with bridge method [inline-methods] */
    public com.kwad.components.ad.c.c al() {
        f fVar = new f(this.nY, com.kwad.sdk.core.response.b.a.cG(this.mAdInfo));
        this.ce = fVar;
        fVar.wi();
        com.kwad.components.ad.c.c cVar = new com.kwad.components.ad.c.c();
        cVar.setAdTemplate(this.mAdTemplate);
        cVar.mAdScene = this.mAdScene;
        cVar.mApkDownloadHelper = this.mApkDownloadHelper;
        return cVar;
    }

    private static Presenter an() {
        Presenter presenter = new Presenter();
        presenter.a(new b());
        return presenter;
    }

    static /* synthetic */ boolean b(a aVar, boolean z5) {
        aVar.cp = false;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(long j6) {
        int ceil = (int) Math.ceil(j6 / 1000.0f);
        List<Integer> list = this.ck;
        if (list == null || list.isEmpty()) {
            return;
        }
        Iterator<Integer> it = this.ck.iterator();
        while (it.hasNext()) {
            if (ceil >= it.next().intValue()) {
                com.kwad.sdk.core.adlog.c.a(this.mAdTemplate, ceil, (JSONObject) null);
                it.remove();
                return;
            }
        }
    }

    @Override // com.kwad.components.core.m.c
    public final void ak() {
        FrameLayout frameLayout = (FrameLayout) this.nY.findViewById(R.id.ksad_banner_item_content);
        this.cl = frameLayout;
        frameLayout.setOnClickListener(this);
        LinearLayout linearLayout = (LinearLayout) this.nY.findViewById(R.id.ksad_banner_item_info);
        this.cs = linearLayout;
        linearLayout.setOnClickListener(this);
        TextView textView = (TextView) this.nY.findViewById(R.id.ksad_banner_item_des);
        this.ct = textView;
        textView.setText(com.kwad.sdk.core.response.b.a.au(this.mAdInfo));
        this.ct.setOnClickListener(this);
        TextView textView2 = (TextView) this.nY.findViewById(R.id.ksad_banner_item_title);
        this.cu = textView2;
        textView2.setText(com.kwad.sdk.core.response.b.a.cl(this.mAdInfo));
        this.cu.setOnClickListener(this);
        LinearLayout linearLayout2 = (LinearLayout) this.nY.findViewById(R.id.ksad_banner_button_base);
        this.f36335cn = linearLayout2;
        linearLayout2.setOnClickListener(this);
        TextView textView3 = (TextView) this.nY.findViewById(R.id.ksad_banner_item_button);
        this.cv = textView3;
        textView3.setText(com.kwad.sdk.core.response.b.a.aE(this.mAdInfo));
        this.cv.setOnClickListener(this);
        ImageView imageView = (ImageView) this.nY.findViewById(R.id.ksad_banner_item_close);
        this.cw = imageView;
        imageView.setOnClickListener(this);
        ImageView imageView2 = (ImageView) this.nY.findViewById(R.id.ksad_banner_item_image);
        this.cm = imageView2;
        imageView2.setOnClickListener(this);
        ImageView imageView3 = (ImageView) this.nY.findViewById(R.id.ksad_banner_item_image_bg);
        this.co = imageView3;
        imageView3.setOnClickListener(this);
        this.cx = (KsLogoView) this.nY.findViewById(R.id.ksad_banner_logo);
        if (TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.K(this.mAdInfo)) && TextUtils.isEmpty(com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl)) {
            int i6 = (int) ((this.mContext.getResources().getDisplayMetrics().density * 40.0f) + 0.5f);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i6, i6);
            layoutParams.gravity = 17;
            this.cm.setLayoutParams(layoutParams);
            KSImageLoader.loadImage(this.cm, com.kwad.sdk.core.response.b.a.co(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setCornerRound(8).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.3
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BitmapFactory.decodeStream(inputStream);
                    return true;
                }
            });
        } else if (com.kwad.sdk.core.response.b.a.bd(this.mAdInfo)) {
            DisplayMetrics displayMetrics = this.mContext.getResources().getDisplayMetrics();
            AdInfo.AdMaterialInfo.MaterialFeature aU = com.kwad.sdk.core.response.b.a.aU(this.mAdInfo);
            if (!TextUtils.isEmpty(aU.materialUrl)) {
                int i7 = aU.width;
                int i8 = aU.height;
                if (i7 > 0 && i7 < i8) {
                    this.co.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    KSImageLoader.loadImage(this.co, com.kwad.sdk.core.response.b.a.O(this.mAdInfo), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.5
                        @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                        public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                            decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                            return true;
                        }
                    });
                    int i9 = (int) ((displayMetrics.density * 54.0f) + 0.5f);
                    FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((i9 / 16) * 9, i9);
                    layoutParams2.gravity = 5;
                    layoutParams2.rightMargin = (int) ((displayMetrics.density * 14.0f) + 0.5f);
                    this.cm.setLayoutParams(layoutParams2);
                }
            }
            KSImageLoader.loadImage(this.cm, com.kwad.sdk.core.response.b.a.aU(this.mAdInfo).materialUrl, this.mAdTemplate);
        } else {
            this.cm.setScaleType(ImageView.ScaleType.CENTER_CROP);
            KSImageLoader.loadImage(this.cm, com.kwad.sdk.core.response.b.a.bu(this.mAdInfo).getUrl(), this.mAdTemplate, new DisplayImageOptionsCompat.Builder().setBlurRadius(50).build(), new SimpleImageLoadingListener() { // from class: com.kwad.components.ad.c.b.a.4
                @Override // com.kwad.sdk.core.imageloader.core.listener.SimpleImageLoadingListener, com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
                public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
                    decodedResult.mBitmap = BlurUtils.stackBlur(BitmapFactory.decodeStream(inputStream), 50, false);
                    return true;
                }
            });
            this.cm.setOnClickListener(this);
        }
        this.cx.aP(this.mAdTemplate);
        this.cl.setVisibility(4);
    }

    public final void ao() {
        this.cl.setVisibility(0);
        this.cy.d(this.mAdTemplate);
    }

    @Override // com.kwad.components.core.m.c
    public final void initData() {
        this.mAdInfo = com.kwad.sdk.core.response.b.e.el(this.mAdTemplate);
        this.mApkDownloadHelper = new com.kwad.components.core.e.d.c(this.mAdTemplate);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view == this.cl || view == this.cm || view == this.cq || view == this.co) {
            this.cy.a(100, 3, this.mAdTemplate);
            return;
        }
        if (view == this.cs || view == this.f36335cn) {
            this.cy.a(53, 2, this.mAdTemplate);
            return;
        }
        if (view == this.ct) {
            this.cy.a(32, 2, this.mAdTemplate);
            return;
        }
        if (view == this.cu) {
            this.cy.a(31, 2, this.mAdTemplate);
        } else if (view == this.cv) {
            this.cy.a(29, 1, this.mAdTemplate);
        } else if (view == this.cw) {
            this.cy.e(this.mAdTemplate);
        }
    }

    public a(Context context, AdTemplate adTemplate, InterfaceC0551a interfaceC0551a) {
        super(context);
        this.mIsAudioEnable = true;
        this.cA = new a.b() { // from class: com.kwad.components.ad.c.b.a.1
            @Override // com.kwad.components.core.video.a.c
            public final void aq() {
                com.kwad.sdk.core.video.videoview.a aVar = a.this.cq;
                a aVar2 = a.this;
                aVar.setVideoSoundEnable(aVar2.f(aVar2.mIsAudioEnable));
            }

            @Override // com.kwad.components.core.video.a.c
            public final void ar() {
                com.kwad.sdk.core.adlog.c.bY(((com.kwad.components.ad.c.c) a.this.Rv).mAdTemplate);
            }

            @Override // com.kwad.components.core.video.a.c
            public final void d(long j6) {
                a.this.c(j6);
            }

            @Override // com.kwad.components.core.video.a.b
            public final void onVideoPlayError(int i6, int i7) {
                InterfaceC0551a interfaceC0551a2 = a.this.cy;
                if (interfaceC0551a2 != null) {
                    interfaceC0551a2.as();
                }
            }

            @Override // com.kwad.components.core.video.a.c
            public final void onVideoPlayStart() {
                com.kwad.sdk.core.adlog.c.bX(a.this.mAdTemplate);
            }
        };
        this.cB = new OfflineOnAudioConflictListener() { // from class: com.kwad.components.ad.c.b.a.2
            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeOccupied() {
                a.b(a.this, false);
                if (a.this.cq != null) {
                    a.this.cq.setVideoSoundEnable(false);
                }
            }

            @Override // com.kwad.components.offline.api.core.api.OfflineOnAudioConflictListener
            public final void onAudioBeReleased() {
            }
        };
        this.mAdTemplate = adTemplate;
        this.mAdScene = adTemplate.mAdScene;
        this.cy = interfaceC0551a;
        this.mContext = getContext();
        qs();
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ap() {
        /*
            r3 = this;
            boolean r0 = com.kwad.sdk.core.config.e.FL()
            r1 = 1
            if (r0 != 0) goto L14
            android.content.Context r0 = r3.mContext
            com.kwad.components.core.t.a r0 = com.kwad.components.core.t.a.aC(r0)
            boolean r0 = r0.sW()
            if (r0 == 0) goto L14
            goto L34
        L14:
            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = r3.bU
            boolean r2 = r0 instanceof com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl
            if (r2 == 0) goto L2a
            com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl r0 = (com.kwad.components.core.internal.api.KSAdVideoPlayConfigImpl) r0
            int r0 = r0.getVideoSoundValue()
            if (r0 == 0) goto L2a
            com.kwad.sdk.api.KsAdVideoPlayConfig r0 = r3.bU
            boolean r0 = r0.isVideoSoundEnable()
            r0 = r0 ^ r1
            goto L35
        L2a:
            com.kwad.sdk.core.response.model.AdInfo r0 = r3.mAdInfo
            boolean r0 = com.kwad.sdk.core.response.b.a.bX(r0)
            if (r0 != 0) goto L33
            goto L34
        L33:
            r1 = 0
        L34:
            r0 = r1
        L35:
            com.kwad.sdk.core.response.model.AdTemplate r1 = r3.mAdTemplate
            if (r1 == 0) goto L3d
            r2 = r0 ^ 1
            r1.mIsAudioEnable = r2
        L3d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.c.b.a.ap():boolean");
    }

    @Override // com.kwad.components.core.m.c, com.kwad.sdk.widget.KSFrameLayout
    public final void aa() {
        super.aa();
    }

    @Override // com.kwad.sdk.widget.d
    public final void b(View view) {
        if (com.kwad.sdk.core.response.b.d.ea(this.mAdTemplate)) {
            onClick(view);
        }
    }

    @Override // com.kwad.components.core.m.c
    public final int getLayoutId() {
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
            return R.layout.ksad_banner_item_land;
        }
        return R.layout.ksad_banner_item;
    }

    @Override // com.kwad.components.core.m.c
    @NonNull
    public final Presenter onCreatePresenter() {
        getContext();
        return an();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.kwad.sdk.api.KsAdVideoPlayConfig r9) {
        /*
            Method dump skipped, instructions count: 384
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.components.ad.c.b.a.a(com.kwad.sdk.api.KsAdVideoPlayConfig):void");
    }

    @Override // com.kwad.sdk.widget.d
    public final void a(View view) {
        onClick(view);
    }
}
