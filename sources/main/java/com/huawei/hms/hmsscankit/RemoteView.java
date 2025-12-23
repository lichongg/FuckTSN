package com.huawei.hms.hmsscankit;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.os.RemoteException;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.huawei.hms.feature.dynamic.DeferredLifecycleHelper;
import com.huawei.hms.feature.dynamic.LifecycleDelegate;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.feature.dynamic.OnDelegateCreatedListener;
import com.huawei.hms.hmsscankit.api.IOnErrorCallback;
import com.huawei.hms.hmsscankit.api.IOnLightCallback;
import com.huawei.hms.hmsscankit.api.IOnResultCallback;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteViewDelegate;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanBase;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.w7;
import com.huawei.hms.scankit.p.y3;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes5.dex */
public class RemoteView extends FrameLayout {
    private static final int MAX_BITMAP_SIZE = 52428800;
    public static final int REQUEST_CODE_PHOTO = 4371;
    private static final String TAG = "ScanKitRemoteView";
    private static boolean flagForGallery = false;
    private static boolean isOnStop = true;
    private Context mContext;
    private boolean mContinuouslyScan;
    private OnErrorCallback mOnErrorCallback;
    private a mRemoteHelper;
    private boolean mReturnedBitmap;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static class Builder {
        Activity mContext;
        HmsScanAnalyzerOptions mFormat;
        Rect mRect;
        boolean mIsCustomed = true;
        boolean mContinuouslyScan = true;
        boolean mReturnedBitmap = false;

        public Builder enableReturnBitmap() {
            this.mReturnedBitmap = true;
            return this;
        }

        public RemoteView build() {
            Activity activity = this.mContext;
            boolean z5 = this.mIsCustomed;
            HmsScanAnalyzerOptions hmsScanAnalyzerOptions = this.mFormat;
            return new RemoteView(activity, z5, hmsScanAnalyzerOptions == null ? 0 : hmsScanAnalyzerOptions.mode, this.mRect).setContinuouslyScan(this.mContinuouslyScan).enableReturnBitmap(this.mReturnedBitmap);
        }

        public Builder setBoundingBox(Rect rect) {
            this.mRect = rect;
            return this;
        }

        public Builder setContext(Activity activity) {
            this.mContext = activity;
            return this;
        }

        public Builder setContinuouslyScan(boolean z5) {
            this.mContinuouslyScan = z5;
            return this;
        }

        public Builder setFormat(int i6, int... iArr) {
            this.mFormat = new HmsScanAnalyzerOptions.Creator().setHmsScanTypes(i6, iArr).create();
            return this;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private class a extends DeferredLifecycleHelper<b> {

        /* renamed from: a, reason: collision with root package name */
        private ViewGroup f33686a;

        /* renamed from: b, reason: collision with root package name */
        public Activity f33687b;

        /* renamed from: c, reason: collision with root package name */
        private OnDelegateCreatedListener<b> f33688c;

        /* renamed from: d, reason: collision with root package name */
        private IRemoteViewDelegate f33689d;

        /* renamed from: e, reason: collision with root package name */
        private IOnResultCallback f33690e = null;

        /* renamed from: f, reason: collision with root package name */
        private boolean f33691f;

        /* renamed from: g, reason: collision with root package name */
        private boolean f33692g;

        /* renamed from: h, reason: collision with root package name */
        private int f33693h;

        /* renamed from: i, reason: collision with root package name */
        private IOnLightCallback f33694i;

        /* renamed from: j, reason: collision with root package name */
        private Rect f33695j;

        /* renamed from: k, reason: collision with root package name */
        private Bundle f33696k;

        /* renamed from: l, reason: collision with root package name */
        private boolean f33697l;

        /* renamed from: m, reason: collision with root package name */
        private boolean f33698m;

        /* renamed from: n, reason: collision with root package name */
        private int f33699n;

        /* renamed from: o, reason: collision with root package name */
        private boolean f33700o;

        /* renamed from: p, reason: collision with root package name */
        private boolean f33701p;

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        /* renamed from: com.huawei.hms.hmsscankit.RemoteView$a$a, reason: collision with other inner class name */
        class ViewOnClickListenerC0544a implements View.OnClickListener {
            ViewOnClickListenerC0544a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                Activity activity = aVar.f33687b;
                if (activity != null) {
                    RemoteView.this.startPhotoCode(activity);
                }
            }
        }

        /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
        class b implements View.OnClickListener {
            b() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a aVar = a.this;
                Activity activity = aVar.f33687b;
                if (activity != null) {
                    RemoteView.this.startPhotoCode(activity);
                }
            }
        }

        a(Activity activity, ViewGroup viewGroup, boolean z5, int i6, Rect rect) {
            this.f33686a = viewGroup;
            this.f33687b = activity;
            this.f33691f = z5;
            this.f33693h = i6;
            this.f33695j = rect;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void d() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f33689d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.pauseContinuouslyScan();
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f33689d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.resumeContinuouslyScan();
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean f() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f33689d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOffLight();
                return true;
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean g() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f33689d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                iRemoteViewDelegate.turnOnLight();
                return true;
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
                return false;
            }
        }

        public void b(boolean z5) {
            this.f33697l = z5;
        }

        public void c(boolean z5) {
            this.f33698m = z5;
        }

        @Override // com.huawei.hms.feature.dynamic.DeferredLifecycleHelper
        public void createDelegate(OnDelegateCreatedListener<b> onDelegateCreatedListener) {
            Bundle bundle;
            IRemoteCreator d6;
            this.f33688c = onDelegateCreatedListener;
            if (onDelegateCreatedListener == null || getDelegate() != null) {
                return;
            }
            this.f33689d = null;
            try {
                bundle = new Bundle();
                boolean z5 = this.f33691f;
                if (!z5 && this.f33693h == 0 && this.f33695j == null) {
                    o4.d(RemoteView.TAG, "!mCustomed && mFormatValue == 0 && mRect == null");
                } else {
                    bundle.putBoolean(DetailRect.CUSTOMED_FLAG, z5);
                    bundle.putInt(DetailRect.FORMAT_FLAG, this.f33693h);
                    Rect rect = this.f33695j;
                    if (rect != null) {
                        bundle.putParcelable(DetailRect.RECT_FLAG, rect);
                    }
                }
                boolean z6 = this.f33697l;
                if (z6) {
                    bundle.putBoolean(DetailRect.SCAN_OFFSCEEN_FLAG, z6);
                }
                boolean z7 = this.f33692g;
                if (z7) {
                    bundle.putBoolean(DetailRect.DEEPLINK_JUMP_FLAG, z7);
                    bundle.putAll(this.f33696k);
                }
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putBoolean(DetailRect.RETURN_BITMAP, this.f33698m);
                bundle.putAll(y3.a(this.f33687b));
                bundle.putBoolean(DetailRect.SCAN_NEW_UI, true);
                bundle.putInt(DetailRect.SCAN_VIEWTYPE_FLAG, this.f33699n);
                bundle.putBoolean(DetailRect.SCAN_CAMERA_PERMISSION, this.f33700o);
                bundle.putBoolean(HmsScanBase.SCAN_GUIDE_FLAG, this.f33701p);
                d6 = g.d(this.f33687b);
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
            if (d6 == null) {
                return;
            }
            this.f33689d = d6.newRemoteViewDelegate(ObjectWrapper.wrap(this.f33687b), ObjectWrapper.wrap(bundle));
            IRemoteViewDelegate iRemoteViewDelegate = this.f33689d;
            if (iRemoteViewDelegate == null) {
                return;
            }
            try {
                IOnResultCallback iOnResultCallback = this.f33690e;
                if (iOnResultCallback != null) {
                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                    this.f33689d.setOnClickListener(ObjectWrapper.wrap(new ViewOnClickListenerC0544a()));
                }
                this.f33689d.setOnClickListener(ObjectWrapper.wrap(new b()));
                IOnLightCallback iOnLightCallback = this.f33694i;
                if (iOnLightCallback != null) {
                    this.f33689d.setOnLightVisbleCallBack(iOnLightCallback);
                }
            } catch (RemoteException unused2) {
                o4.b("exception", "RemoteException");
            }
            this.f33688c.onDelegateCreated(new b(this.f33686a, this.f33689d));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            if (this.f33687b != null) {
                this.f33687b = null;
            }
            if (this.f33686a != null) {
                this.f33686a = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean c() {
            IRemoteViewDelegate iRemoteViewDelegate = this.f33689d;
            if (iRemoteViewDelegate == null) {
                return false;
            }
            try {
                return iRemoteViewDelegate.getLightStatus();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
                return false;
            }
        }

        a(Activity activity, ViewGroup viewGroup, boolean z5, int i6, Rect rect, int i7) {
            this.f33686a = viewGroup;
            this.f33687b = activity;
            this.f33691f = z5;
            this.f33693h = i6;
            this.f33695j = rect;
            this.f33699n = i7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(boolean z5) {
            this.f33692g = z5;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(Bundle bundle) {
            this.f33696k = bundle;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnResultCallback iOnResultCallback) {
            this.f33690e = iOnResultCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.f33689d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnResultCallback(iOnResultCallback);
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnErrorCallback iOnErrorCallback) {
            IRemoteViewDelegate iRemoteViewDelegate = this.f33689d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnErrorCallback(iOnErrorCallback);
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        a(Activity activity, ViewGroup viewGroup, boolean z5, int i6, Rect rect, int i7, boolean z6, boolean z7) {
            this.f33686a = viewGroup;
            this.f33687b = activity;
            this.f33691f = z5;
            this.f33693h = i6;
            this.f33695j = rect;
            this.f33699n = i7;
            this.f33700o = z6;
            this.f33701p = z7;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(IOnLightCallback iOnLightCallback) {
            this.f33694i = iOnLightCallback;
            IRemoteViewDelegate iRemoteViewDelegate = this.f33689d;
            if (iRemoteViewDelegate != null) {
                try {
                    iRemoteViewDelegate.setOnLightVisbleCallBack(iOnLightCallback);
                } catch (RemoteException unused) {
                    o4.b("exception", "RemoteException");
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0043, code lost:
        
            com.huawei.hms.scankit.p.o4.e("ScanUtil", "input image is too large:" + r3.getWidth());
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0064 A[Catch: Error -> 0x0068, Exception -> 0x006e, RemoteException -> 0x0074, IllegalStateException -> 0x007a, TRY_LEAVE, TryCatch #2 {RemoteException -> 0x0074, Error -> 0x0068, IllegalStateException -> 0x007a, Exception -> 0x006e, blocks: (B:7:0x000b, B:9:0x0017, B:12:0x0026, B:13:0x0060, B:15:0x0064, B:21:0x0043, B:22:0x005d), top: B:6:0x000b }] */
        /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a(int r3, int r4, android.content.Intent r5) {
            /*
                r2 = this;
                java.lang.String r0 = "ScanKitRemoteView"
                r1 = -1
                if (r4 != r1) goto L7f
                if (r5 == 0) goto L7f
                r4 = 4371(0x1113, float:6.125E-42)
                if (r3 != r4) goto L7f
                com.huawei.hms.hmsscankit.RemoteView r3 = com.huawei.hms.hmsscankit.RemoteView.this     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                android.content.Context r3 = com.huawei.hms.hmsscankit.RemoteView.access$1300(r3)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                android.graphics.Bitmap r3 = com.huawei.hms.scankit.p.w7.a(r3, r5)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                if (r3 == 0) goto L41
                int r4 = r3.getWidth()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                int r5 = r3.getHeight()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                int r4 = r4 * r5
                r5 = 52428800(0x3200000, float:4.7019774E-37)
                if (r4 <= r5) goto L26
                goto L41
            L26:
                com.huawei.hms.hmsscankit.RemoteView r4 = com.huawei.hms.hmsscankit.RemoteView.this     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                android.content.Context r4 = com.huawei.hms.hmsscankit.RemoteView.access$1300(r4)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                com.huawei.hms.ml.scan.HmsScanAnalyzerOptions$Creator r5 = new com.huawei.hms.ml.scan.HmsScanAnalyzerOptions$Creator     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                r5.<init>()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                r1 = 1
                com.huawei.hms.ml.scan.HmsScanAnalyzerOptions$Creator r5 = r5.setPhotoMode(r1)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                com.huawei.hms.ml.scan.HmsScanAnalyzerOptions r5 = r5.create()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                int r1 = r2.f33693h     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                com.huawei.hms.ml.scan.HmsScan[] r3 = com.huawei.hms.hmsscankit.f.a(r4, r3, r5, r1)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                goto L60
            L41:
                if (r3 == 0) goto L5d
                java.lang.String r4 = "ScanUtil"
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                r5.<init>()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                java.lang.String r1 = "input image is too large:"
                r5.append(r1)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                int r3 = r3.getWidth()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                r5.append(r3)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                java.lang.String r3 = r5.toString()     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                com.huawei.hms.scankit.p.o4.e(r4, r3)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
            L5d:
                r3 = 0
                com.huawei.hms.ml.scan.HmsScan[] r3 = new com.huawei.hms.ml.scan.HmsScan[r3]     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
            L60:
                com.huawei.hms.hmsscankit.api.IOnResultCallback r4 = r2.f33690e     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                if (r4 == 0) goto L7f
                r4.onResult(r3)     // Catch: java.lang.Error -> L68 java.lang.Exception -> L6e android.os.RemoteException -> L74 java.lang.IllegalStateException -> L7a
                return
            L68:
                java.lang.String r3 = "Exception in error"
                com.huawei.hms.scankit.p.o4.b(r0, r3)
                goto L7f
            L6e:
                java.lang.String r3 = "Exception in remoteview"
                com.huawei.hms.scankit.p.o4.b(r0, r3)
                goto L7f
            L74:
                java.lang.String r3 = "RemoteException in remoteview"
                com.huawei.hms.scankit.p.o4.b(r0, r3)
                goto L7f
            L7a:
                java.lang.String r3 = "IllegalStateException in remoteview"
                com.huawei.hms.scankit.p.o4.b(r0, r3)
            L7f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hmsscankit.RemoteView.a.a(int, int, android.content.Intent):void");
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    private static class b implements LifecycleDelegate {

        /* renamed from: a, reason: collision with root package name */
        private ViewGroup f33705a;

        /* renamed from: b, reason: collision with root package name */
        private View f33706b;

        /* renamed from: c, reason: collision with root package name */
        private IRemoteViewDelegate f33707c;

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onCreate(Bundle bundle) {
            try {
                this.f33707c.onCreate(bundle);
                this.f33706b = (View) ObjectWrapper.unwrap(this.f33707c.getView());
                this.f33705a.removeAllViews();
                this.f33705a.addView(this.f33706b);
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
            return new View(null);
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onDestroy() {
            try {
                this.f33707c.onDestroy();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onPause() {
            try {
                this.f33707c.onPause();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onStart() {
            try {
                this.f33707c.onStart();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onStop() {
            try {
                this.f33707c.onStop();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        b(ViewGroup viewGroup, IRemoteViewDelegate iRemoteViewDelegate) {
            this.f33705a = viewGroup;
            this.f33707c = iRemoteViewDelegate;
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onResume() {
            try {
                if (!RemoteView.isOnStop) {
                    if (RemoteView.flagForGallery) {
                        this.f33707c.onStart();
                        return;
                    } else {
                        this.f33707c.onResume();
                        return;
                    }
                }
                this.f33707c.onResume();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onDestroyView() {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onLowMemory() {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onSaveInstanceState(Bundle bundle) {
        }

        @Override // com.huawei.hms.feature.dynamic.LifecycleDelegate
        public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        }
    }

    RemoteView(Activity activity, boolean z5, int i6, Rect rect) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mOnErrorCallback = null;
        this.mContext = activity;
        this.mRemoteHelper = new a(activity, this, z5, i6, rect);
    }

    private boolean checkPhotoPermission(Activity activity) {
        return Build.VERSION.SDK_INT >= 33 ? w7.b((Context) activity) || activity.checkPermission("android.permission.READ_MEDIA_IMAGES", Process.myPid(), Process.myUid()) == 0 : w7.b((Context) activity) || activity.checkPermission(com.kuaishou.weapon.p0.g.f36049i, Process.myPid(), Process.myUid()) == 0;
    }

    private void requestPhotoPermission(Activity activity) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 33) {
            activity.requestPermissions(new String[]{"android.permission.READ_MEDIA_IMAGES"}, REQUEST_CODE_PHOTO);
        } else if (i6 >= 23) {
            activity.requestPermissions(new String[]{com.kuaishou.weapon.p0.g.f36049i}, REQUEST_CODE_PHOTO);
        }
    }

    private void startActivityForGallery(Activity activity) {
        try {
            Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            Intent intent = new Intent("android.intent.action.PICK", uri);
            if (w7.g(activity)) {
                if (w7.a(new Intent(), "com.android.gallery3d", activity) != null && w7.a("com.android.gallery3d", activity)) {
                    o4.d(TAG, "Start Gallery:com.android.gallery3d");
                    intent.setPackage("com.android.gallery3d");
                } else if (w7.a(new Intent(), "com.huawei.photos", activity) != null && w7.a("com.huawei.photos", activity)) {
                    intent.setPackage("com.huawei.photos");
                    o4.d(TAG, "Start Gallery:com.huawei.photos");
                }
            }
            intent.setDataAndType(uri, "image/*");
            flagForGallery = true;
            activity.startActivityForResult(intent, REQUEST_CODE_PHOTO);
        } catch (Exception unused) {
            o4.b(TAG, "startPhotoCode Exception");
        }
    }

    RemoteView enableReturnBitmap(boolean z5) {
        this.mReturnedBitmap = z5;
        this.mRemoteHelper.c(z5);
        return this;
    }

    public boolean getLightStatus() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            return aVar.c();
        }
        return false;
    }

    public void onActivityResult(int i6, int i7, Intent intent) {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.a(i6, i7, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Context context = this.mContext;
        if ((context instanceof Activity) && ((Activity) context).getWindow() != null) {
            ((Activity) this.mContext).getWindow().setFlags(16777216, 16777216);
        }
        this.mRemoteHelper.onCreate(bundle);
    }

    public final void onDestroy() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.onDestroy();
            this.mRemoteHelper.b();
            this.mRemoteHelper = null;
        }
    }

    public final void onPause() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.onPause();
        }
        a aVar2 = this.mRemoteHelper;
        if (aVar2 != null && flagForGallery) {
            aVar2.onStop();
        }
        isOnStop = false;
    }

    public void onRequestPermissionsResult(int i6, String[] strArr, int[] iArr, Activity activity) {
        if (i6 == 4371 && iArr.length == 1 && iArr[0] == 0) {
            startPhotoCode(activity);
        }
    }

    public final void onResume() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.onResume();
        }
        flagForGallery = false;
    }

    public final void onStart() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.onStart();
        }
        flagForGallery = false;
    }

    public final void onStop() {
        a aVar = this.mRemoteHelper;
        if (aVar != null && !flagForGallery) {
            aVar.onStop();
        }
        isOnStop = true;
    }

    public void pauseContinuouslyScan() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.d();
        }
    }

    public void resumeContinuouslyScan() {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.e();
        }
    }

    public void selectPictureFromLocalFile() {
        startPhotoCode((Activity) this.mContext);
    }

    RemoteView setContinuouslyScan(boolean z5) {
        this.mContinuouslyScan = z5;
        return this;
    }

    public void setOnErrorCallback(OnErrorCallback onErrorCallback) {
        this.mOnErrorCallback = onErrorCallback;
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.a(new c(this.mOnErrorCallback));
        }
    }

    public void setOnLightVisibleCallback(OnLightVisibleCallBack onLightVisibleCallBack) {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.a(new d(onLightVisibleCallBack));
        }
    }

    public void setOnResultCallback(OnResultCallback onResultCallback) {
        a aVar = this.mRemoteHelper;
        if (aVar != null) {
            aVar.a(new e(onResultCallback, this.mContinuouslyScan));
        }
    }

    public boolean switchLight() {
        if (this.mRemoteHelper != null) {
            return !getLightStatus() ? this.mRemoteHelper.g() : this.mRemoteHelper.f();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startPhotoCode(Activity activity) {
        if (checkPhotoPermission(activity)) {
            startActivityForGallery(activity);
            return;
        }
        o4.d(TAG, "no photo permission");
        if (this.mOnErrorCallback == null) {
            requestPhotoPermission(activity);
        } else {
            o4.b(TAG, "no photo permission, report error2");
            this.mOnErrorCallback.onError(2);
        }
    }

    RemoteView(Activity activity, boolean z5, int i6, Rect rect, int i7) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mOnErrorCallback = null;
        this.mContext = activity;
        this.mRemoteHelper = new a(activity, this, z5, i6, rect, i7);
    }

    RemoteView(Activity activity, boolean z5, int i6, Rect rect, int i7, boolean z6, boolean z7) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mOnErrorCallback = null;
        this.mContext = activity;
        this.mRemoteHelper = new a(activity, this, z5, i6, rect, i7, z6, z7);
    }

    RemoteView(Activity activity, boolean z5, int i6, Rect rect, boolean z6) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mOnErrorCallback = null;
        this.mContext = activity;
        a aVar = new a(activity, this, z5, i6, rect);
        this.mRemoteHelper = aVar;
        aVar.b(z6);
    }

    RemoteView(Activity activity, boolean z5, Bundle bundle) {
        super(activity);
        this.mContinuouslyScan = true;
        this.mReturnedBitmap = false;
        this.mOnErrorCallback = null;
        this.mContext = activity;
        a aVar = new a(activity, this, false, 0, null);
        this.mRemoteHelper = aVar;
        aVar.a(z5);
        this.mRemoteHelper.a(bundle);
    }
}
