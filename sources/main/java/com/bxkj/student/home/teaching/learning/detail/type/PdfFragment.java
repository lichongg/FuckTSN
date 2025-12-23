package com.bxkj.student.home.teaching.learning.detail.type;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import cn.bluemobi.dylan.base.BaseFragment;
import cn.bluemobi.dylan.base.view.iOSOneButtonDialog;
import com.bxkj.base.util.file.a;
import com.bxkj.student.R;
import com.daimajia.numberprogressbar.NumberProgressBar;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;
import com.github.barteksc.pdfviewer.listener.OnPageChangeListener;
import com.orhanobut.logger.j;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.File;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public class PdfFragment extends BaseFragment {

    /* renamed from: j, reason: collision with root package name */
    private String f18653j;

    /* renamed from: k, reason: collision with root package name */
    private String f18654k;

    /* renamed from: l, reason: collision with root package name */
    private com.bxkj.base.util.file.a f18655l;

    /* renamed from: m, reason: collision with root package name */
    private File f18656m;

    /* renamed from: n, reason: collision with root package name */
    private PDFView f18657n;

    /* renamed from: o, reason: collision with root package name */
    private TextView f18658o;

    /* renamed from: p, reason: collision with root package name */
    private FrameLayout f18659p;

    /* renamed from: q, reason: collision with root package name */
    private NumberProgressBar f18660q;

    /* renamed from: r, reason: collision with root package name */
    private String f18661r = "";

    /* renamed from: s, reason: collision with root package name */
    private String f18662s = "";

    /* renamed from: t, reason: collision with root package name */
    private Disposable f18663t;

    /* renamed from: u, reason: collision with root package name */
    private b f18664u;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    class a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.bxkj.base.util.file.c f18665a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ObservableEmitter f18666b;

        a(final com.bxkj.base.util.file.c val$fileVo, final ObservableEmitter val$e) {
            this.f18665a = val$fileVo;
            this.f18666b = val$e;
        }

        @Override // com.bxkj.base.util.file.a.b
        public void a(File file) {
            this.f18665a.d(file);
            this.f18666b.onNext(this.f18665a);
            this.f18666b.onComplete();
        }

        @Override // com.bxkj.base.util.file.a.b
        public void c(int progress) {
            PdfFragment.this.c0(progress);
        }

        @Override // com.bxkj.base.util.file.a.b
        public void b(Exception e6) {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public interface b {
        void onSuccess();
    }

    private void T() {
        this.f18663t = Observable.create(new ObservableOnSubscribe() { // from class: com.bxkj.student.home.teaching.learning.detail.type.d
            @Override // io.reactivex.ObservableOnSubscribe
            public final void subscribe(ObservableEmitter observableEmitter) {
                PdfFragment.this.V(observableEmitter);
            }
        }).compose(com.bxkj.base.util.file.d.d()).subscribe(new Consumer() { // from class: com.bxkj.student.home.teaching.learning.detail.type.e
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PdfFragment.this.W((com.bxkj.base.util.file.c) obj);
            }
        });
    }

    private void U(String url) {
        this.f18661r = url;
        this.f18662s = "aa." + com.bxkj.base.util.file.b.i(this.f18661r);
        this.f18655l = com.bxkj.base.util.file.a.b();
        T();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(ObservableEmitter observableEmitter) throws Exception {
        com.bxkj.base.util.file.c cVar = new com.bxkj.base.util.file.c();
        this.f18655l.a(this.f18661r, com.bxkj.base.util.file.b.e(this.f1096g), this.f18662s, new a(cVar, observableEmitter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X(int i6, int i7) {
        this.f18658o.setText((i6 + 1) + "/" + i7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Y(int i6) {
        b bVar = this.f18664u;
        if (bVar != null) {
            bVar.onSuccess();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(int i6, Integer num) throws Exception {
        this.f18660q.setProgress(i6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b0, reason: merged with bridge method [inline-methods] */
    public void W(com.bxkj.base.util.file.c fileVo) {
        try {
            NumberProgressBar numberProgressBar = this.f18660q;
            if (numberProgressBar != null) {
                numberProgressBar.setProgress(fileVo.b());
                this.f18660q.setVisibility(8);
            }
            this.f18656m = fileVo.a();
            j.c("file.getName().toLowerCase()=" + this.f18656m.getName().toLowerCase());
            if (this.f18656m.getName().toLowerCase().endsWith("pdf")) {
                this.f18657n.fromFile(this.f18656m).spacing(10).onPageChange(new OnPageChangeListener() { // from class: com.bxkj.student.home.teaching.learning.detail.type.b
                    @Override // com.github.barteksc.pdfviewer.listener.OnPageChangeListener
                    public final void onPageChanged(int i6, int i7) {
                        PdfFragment.this.X(i6, i7);
                    }
                }).onLoad(new OnLoadCompleteListener() { // from class: com.bxkj.student.home.teaching.learning.detail.type.c
                    @Override // com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener
                    public final void loadComplete(int i6) {
                        PdfFragment.this.Y(i6);
                    }
                }).load();
                return;
            }
            new iOSOneButtonDialog(this.f1096g).setMessage("暂不支持当前文件类型【" + com.bxkj.base.util.file.b.i(this.f18656m.getPath()) + "】请联系管理员").show();
        } catch (Exception e6) {
            e6.printStackTrace();
        }
    }

    public void a0(b loadOfficeListener) {
        this.f18664u = loadOfficeListener;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        Disposable disposable = this.f18663t;
        if (disposable != null && !disposable.isDisposed()) {
            this.f18663t.dispose();
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c0(final int progress) {
        Observable.just(Integer.valueOf(progress)).compose(com.bxkj.base.util.file.d.d()).subscribe(new Consumer() { // from class: com.bxkj.student.home.teaching.learning.detail.type.a
            @Override // io.reactivex.functions.Consumer
            public final void accept(Object obj) {
                PdfFragment.this.Z(progress, (Integer) obj);
            }
        });
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void e() {
        if (getArguments().containsKey("url")) {
            U(getArguments().getString("url"));
            return;
        }
        if (getArguments().containsKey("filePath")) {
            String string = getArguments().getString("filePath");
            com.bxkj.base.util.file.c cVar = new com.bxkj.base.util.file.c();
            cVar.d(new File(string));
            this.f18660q.setVisibility(8);
            W(cVar);
        }
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected void f(View view) {
        this.f18657n = (PDFView) c(R.id.pdfView);
        this.f18660q = (NumberProgressBar) c(R.id.number_progress_bar);
        this.f18658o = (TextView) c(R.id.tv_page);
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    protected int i() {
        return R.layout.ac_pdf_reader;
    }

    @Override // cn.bluemobi.dylan.base.BaseFragment
    public void b() {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v5) {
    }
}
