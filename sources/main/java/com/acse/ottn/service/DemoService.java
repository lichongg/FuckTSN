package com.acse.ottn.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.text.TextUtils;
import com.acse.ottn.c2;
import com.acse.ottn.h;
import com.acse.ottn.io.reactivex.ObservableEmitter;
import com.acse.ottn.io.reactivex.ObservableOnSubscribe;
import com.acse.ottn.io.reactivex.functions.Consumer;
import com.acse.ottn.io.reactivex.schedulers.Schedulers;
import com.acse.ottn.n;
import com.stub.StubApp;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.json.JSONObject;
import rx.e;
import rx.l;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class DemoService extends Service {

    /* renamed from: a, reason: collision with root package name */
    public static String f5107a = "DemoService";

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class a implements Consumer<String> {
        public a() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(String str) throws Exception {
            if (!TextUtils.isEmpty(str)) {
                n.c().a(DemoService.this, str);
                DemoService.this.stopSelf();
            }
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class b implements Consumer<Throwable> {
        public b() {
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer, rx.functions.b
        public /* synthetic */ void call(Object obj) {
            com.acse.ottn.io.reactivex.functions.c.a(this, obj);
        }

        @Override // com.acse.ottn.io.reactivex.functions.Consumer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public class c implements ObservableOnSubscribe<String> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f5110a;

        @Override // com.acse.ottn.io.reactivex.ObservableOnSubscribe, rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l) obj);
        }

        public c(String str) {
            this.f5110a = str;
        }

        @Override // com.acse.ottn.io.reactivex.ObservableOnSubscribe
        public /* synthetic */ void call(l<? super String> lVar) {
            com.acse.ottn.io.reactivex.a.b(this, lVar);
        }

        @Override // com.acse.ottn.io.reactivex.ObservableOnSubscribe
        public void subscribe(ObservableEmitter<String> observableEmitter) throws Exception {
            String str;
            try {
                str = new JSONObject(new OkHttpClient().newCall(new Request.Builder().url(this.f5110a).build()).execute().body().string()).getString("content");
                c2.a("samon-->code1", str);
            } catch (Exception e6) {
                e6.printStackTrace();
                c2.a("samon-->code11", "shortcode is null");
                c2.a(DemoService.f5107a, e6.getMessage());
                str = "";
            }
            observableEmitter.onNext(str);
        }
    }

    static {
        StubApp.interface11(9599);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void a(String str) {
        e.j1(new c(str)).w5(Schedulers.newThread()).I3(h.a()).u5(new a(), new b());
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i6, int i7) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("tkl_url");
            if (!TextUtils.isEmpty(stringExtra)) {
                try {
                    a(stringExtra);
                } catch (Exception unused) {
                    c2.b(f5107a, "request code fail ");
                }
            }
        } else {
            stopSelf();
        }
        return super.onStartCommand(intent, i6, i7);
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }
}
