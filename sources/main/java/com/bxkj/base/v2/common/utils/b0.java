package com.bxkj.base.v2.common.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bxkj.base.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import u.b;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nImageSelectUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageSelectUtils.kt\ncom/bxkj/base/v2/common/utils/ImageSelectUtils\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,257:1\n1#2:258\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class b0 {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b0 f16879a = new b0();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nImageSelectUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageSelectUtils.kt\ncom/bxkj/base/v2/common/utils/ImageSelectUtils$camera$1$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,257:1\n1#2:258\n*E\n"})
    public static final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ File f16880a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Context f16881b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<File, n1> f16882c;

        /* JADX WARN: Multi-variable type inference failed */
        a(File file, Context context, Function1<? super File, n1> function1) {
            this.f16880a = file;
            this.f16881b = context;
            this.f16882c = function1;
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            File file = this.f16880a;
            if (i6 != -1) {
                file = null;
            }
            if (file != null) {
                b0 b0Var = b0.f16879a;
                File file2 = b0Var.q() ? file : null;
                if (file2 != null) {
                    b0Var.l(this.f16881b, file2, this.f16882c);
                }
            }
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements top.zibin.luban.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<File, n1> f16883a;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super File, n1> function1) {
            this.f16883a = function1;
        }

        @Override // top.zibin.luban.d
        public void a(File file) {
            kotlin.jvm.internal.g0.p(file, "file");
            com.orhanobut.logger.j.d("压缩文件路径" + file.getAbsolutePath(), new Object[0]);
            this.f16883a.invoke(file);
        }

        @Override // top.zibin.luban.d
        public void onError(Throwable e6) {
            kotlin.jvm.internal.g0.p(e6, "e");
            e6.printStackTrace();
        }

        @Override // top.zibin.luban.d
        public void onStart() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    @SourceDebugExtension({"SMAP\nImageSelectUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ImageSelectUtils.kt\ncom/bxkj/base/v2/common/utils/ImageSelectUtils$gallery$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,257:1\n1#2:258\n*E\n"})
    public static final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16884a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<File, n1> f16885b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Context context, Function1<? super File, n1> function1) {
            this.f16884a = context;
            this.f16885b = function1;
        }

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            Uri data;
            if (intent != null) {
                if (i6 != -1) {
                    intent = null;
                }
                if (intent == null || (data = intent.getData()) == null) {
                    return;
                }
                Context context = this.f16884a;
                Function1<File, n1> function1 = this.f16885b;
                b0 b0Var = b0.f16879a;
                String p5 = b0Var.p(data, context);
                if (p5 != null) {
                    b0Var.l(context, new File(p5), function1);
                }
            }
        }
    }

    private final void m(Context context, u.b bVar, Function1<? super File, n1> function1) {
        bVar.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI)).c(new c(context, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void s(Ref.ObjectRef objectRef, View view) {
        ((Dialog) objectRef.element).dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(Ref.ObjectRef objectRef, final FragmentActivity fragmentActivity, final Function1 function1, View view) {
        ((Dialog) objectRef.element).dismiss();
        com.bxkj.base.v2.common.ext.b0.x(fragmentActivity, "拍照", new Function0() { // from class: com.bxkj.base.v2.common.utils.w
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 u5;
                u5 = b0.u(FragmentActivity.this, function1);
                return u5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 u(FragmentActivity fragmentActivity, Function1 function1) {
        f16879a.k(fragmentActivity, function1);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void v(Ref.ObjectRef objectRef, final FragmentActivity fragmentActivity, final Function1 function1, View view) {
        ((Dialog) objectRef.element).dismiss();
        com.bxkj.base.v2.common.ext.b0.O(fragmentActivity, null, new Function0() { // from class: com.bxkj.base.v2.common.utils.a0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 w5;
                w5 = b0.w(FragmentActivity.this, function1);
                return w5;
            }
        }, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 w(FragmentActivity fragmentActivity, Function1 function1) {
        f16879a.o(fragmentActivity, function1);
        return n1.f44123a;
    }

    public final void j(@NotNull Fragment fragment, @NotNull Function1<? super File, n1> callback) {
        kotlin.jvm.internal.g0.p(fragment, "fragment");
        kotlin.jvm.internal.g0.p(callback, "callback");
        FragmentActivity requireActivity = fragment.requireActivity();
        kotlin.jvm.internal.g0.o(requireActivity, "requireActivity(...)");
        i(requireActivity, new u.b(fragment), callback);
    }

    public final void k(@NotNull FragmentActivity fragmentActivity, @NotNull Function1<? super File, n1> callback) {
        kotlin.jvm.internal.g0.p(fragmentActivity, "fragmentActivity");
        kotlin.jvm.internal.g0.p(callback, "callback");
        i(fragmentActivity, new u.b(fragmentActivity), callback);
    }

    public final void n(@NotNull Fragment fragment, @NotNull Function1<? super File, n1> callback) {
        kotlin.jvm.internal.g0.p(fragment, "fragment");
        kotlin.jvm.internal.g0.p(callback, "callback");
        FragmentActivity requireActivity = fragment.requireActivity();
        kotlin.jvm.internal.g0.o(requireActivity, "requireActivity(...)");
        m(requireActivity, new u.b(fragment), callback);
    }

    public final void o(@NotNull FragmentActivity fragmentActivity, @NotNull Function1<? super File, n1> callback) {
        kotlin.jvm.internal.g0.p(fragmentActivity, "fragmentActivity");
        kotlin.jvm.internal.g0.p(callback, "callback");
        m(fragmentActivity, new u.b(fragmentActivity), callback);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [T, android.app.Dialog] */
    public final void r(@NotNull final FragmentActivity mContext, @NotNull final Function1<? super File, n1> callback) {
        kotlin.jvm.internal.g0.p(mContext, "mContext");
        kotlin.jvm.internal.g0.p(callback, "callback");
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.pub_dialog_add_picture, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tv_camera);
        kotlin.jvm.internal.g0.n(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tv_gallery);
        kotlin.jvm.internal.g0.n(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.tv_cancel);
        kotlin.jvm.internal.g0.n(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) findViewById3;
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ?? dialog = new Dialog(mContext, cn.bluemobi.dylan.base.R.style.custom_dialog);
        objectRef.element = dialog;
        dialog.setContentView(inflate);
        Window window = ((Dialog) objectRef.element).getWindow();
        if (window != null) {
            window.setGravity(80);
        }
        Display defaultDisplay = mContext.getWindowManager().getDefaultDisplay();
        Window window2 = ((Dialog) objectRef.element).getWindow();
        WindowManager.LayoutParams attributes = window2 != null ? window2.getAttributes() : null;
        if (attributes != null) {
            attributes.width = defaultDisplay.getWidth();
        }
        Window window3 = ((Dialog) objectRef.element).getWindow();
        if (window3 != null) {
            window3.setAttributes(attributes);
        }
        ((Dialog) objectRef.element).show();
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b0.s(Ref.ObjectRef.this, view);
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b0.t(Ref.ObjectRef.this, mContext, callback, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b0.v(Ref.ObjectRef.this, mContext, callback, view);
            }
        });
    }

    private b0() {
    }

    private final void i(Context context, u.b bVar, Function1<? super File, n1> function1) {
        File file;
        Uri uriForFile;
        if (q()) {
            if (kotlin.jvm.internal.g0.g("mounted", Environment.getExternalStorageState())) {
                file = context.getExternalCacheDir();
                if ((file == null || !file.exists()) && file != null) {
                    file.mkdirs();
                }
            } else {
                file = null;
            }
            if (file == null || !file.exists()) {
                file = context.getCacheDir();
                if (!file.exists()) {
                    file.mkdirs();
                }
            }
            File file2 = new File(file, "temp");
            if (!file2.exists()) {
                file2.mkdirs();
            }
            File file3 = new File(file2, System.currentTimeMillis() + "_temp_photo.jpg");
            if (Build.VERSION.SDK_INT < 24) {
                uriForFile = Uri.fromFile(file3);
                kotlin.jvm.internal.g0.m(uriForFile);
            } else {
                uriForFile = FileProvider.getUriForFile(context, "com.bxkj.student.provider", file3);
                kotlin.jvm.internal.g0.m(uriForFile);
            }
            Intent intent = new Intent();
            intent.putExtra("output", uriForFile);
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(1);
            bVar.startActivityForResult(intent).c(new a(file3, context, function1));
            return;
        }
        Toast.makeText(context, "未找到存储卡，无法拍照！", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(Context context, File file, Function1<? super File, n1> function1) {
        top.zibin.luban.c.k(context).f(file).h(new b(function1)).e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p(Uri uri, Context context) {
        Cursor query = context.getContentResolver().query(uri, null, null, null, null);
        if (query == null) {
            return null;
        }
        int columnIndex = query.getColumnIndex("_display_name");
        int columnIndex2 = query.getColumnIndex("_size");
        query.moveToFirst();
        String string = query.getString(columnIndex);
        kotlin.jvm.internal.g0.o(string, "getString(...)");
        String.valueOf(query.getLong(columnIndex2));
        File file = new File(context.getFilesDir(), string);
        try {
            try {
                InputStream openInputStream = context.getContentResolver().openInputStream(uri);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                kotlin.jvm.internal.g0.m(openInputStream);
                byte[] bArr = new byte[Math.min(openInputStream.available(), 1048576)];
                while (true) {
                    int read = openInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                file.length();
                openInputStream.close();
                fileOutputStream.close();
                file.getPath();
                file.length();
            } catch (Exception e6) {
                kotlin.jvm.internal.g0.m(e6.getMessage());
            }
            query.close();
            return file.getPath();
        } catch (Throwable th) {
            query.close();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean q() {
        return kotlin.jvm.internal.g0.g(Environment.getExternalStorageState(), "mounted");
    }
}
