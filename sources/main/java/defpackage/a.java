package defpackage;

import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import cn.bluemobi.dylan.smartwebview.SmartWebView;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.n;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nCustomWebChromeClient.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CustomWebChromeClient.kt\nCustomWebChromeClient\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,90:1\n37#2,2:91\n*S KotlinDebug\n*F\n+ 1 CustomWebChromeClient.kt\nCustomWebChromeClient\n*L\n85#1:91,2\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class a extends SmartWebView.b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private final Fragment f15a;

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private ValueCallback<Uri> f16b;

    /* renamed from: c, reason: collision with root package name */
    @Nullable
    private ValueCallback<Uri[]> f17c;

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    /* renamed from: a$a, reason: collision with other inner class name */
    public static final class C0000a implements b.a {
        C0000a() {
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            if (a.this.f16b == null && a.this.f17c == null) {
                return;
            }
            Uri data = (intent == null || i6 != -1) ? null : intent.getData();
            if (a.this.f17c != null) {
                a.this.e(i6, intent);
            } else if (a.this.f16b != null) {
                ValueCallback valueCallback = a.this.f16b;
                g0.m(valueCallback);
                valueCallback.onReceiveValue(data);
                a.this.f16b = null;
            }
        }
    }

    public final void openFileChooser(@NotNull ValueCallback<Uri> valueCallback) {
        g0.p(valueCallback, "valueCallback");
        this.f16b = valueCallback;
        f();
    }

    public a(@NotNull Fragment fragment) {
        g0.p(fragment, "fragment");
        this.f15a = fragment;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void e(int i6, Intent intent) {
        if (this.f17c == null) {
            return;
        }
        List arrayList = new ArrayList();
        if (i6 == -1 && intent != null) {
            String dataString = intent.getDataString();
            ClipData clipData = intent.getClipData();
            if (clipData != null && clipData.getItemCount() > 0 && arrayList.size() >= clipData.getItemCount()) {
                int itemCount = clipData.getItemCount();
                for (int i7 = 0; i7 < itemCount; i7++) {
                    Uri uri = clipData.getItemAt(i7).getUri();
                    g0.o(uri, "getUri(...)");
                    arrayList.set(i7, uri);
                }
            }
            if (dataString != null) {
                arrayList = n.nz(new Uri[]{Uri.parse(dataString)});
            }
        }
        ValueCallback<Uri[]> valueCallback = this.f17c;
        if (valueCallback != 0) {
            valueCallback.onReceiveValue(arrayList.toArray(new Uri[0]));
        }
        this.f17c = null;
    }

    private final void f() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        intent.setType("image/*");
        new b(this.f15a).startActivityForResult(intent).c(new C0000a());
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(@Nullable WebView webView, @NotNull ValueCallback<Uri[]> filePathCallback, @Nullable WebChromeClient.FileChooserParams fileChooserParams) {
        g0.p(filePathCallback, "filePathCallback");
        this.f17c = filePathCallback;
        f();
        return true;
    }

    public final void openFileChooser(@NotNull ValueCallback<Uri> valueCallback, @Nullable String str) {
        g0.p(valueCallback, "valueCallback");
        this.f16b = valueCallback;
        f();
    }

    public final void openFileChooser(@NotNull ValueCallback<Uri> valueCallback, @Nullable String str, @Nullable String str2) {
        g0.p(valueCallback, "valueCallback");
        this.f16b = valueCallback;
        f();
    }
}
