package com.bxkj.base.v2.common.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
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
@SourceDebugExtension({"SMAP\nFileSelectUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FileSelectUtil.kt\ncom/bxkj/base/v2/common/utils/FileSelectUtil\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,311:1\n1#2:312\n*E\n"})
/* loaded from: D:\Downloads\app\classes3.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final u f16942a = new u();

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16943a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f16944b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<File, n1> f16945c;

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            if (i6 == -1) {
                u uVar = u.f16942a;
                if (uVar.B()) {
                    uVar.s(this.f16943a, this.f16944b, this.f16945c);
                    return;
                }
            }
            this.f16945c.invoke(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        a(Context context, File file, Function1<? super File, n1> function1) {
            this.f16943a = context;
            this.f16944b = file;
            this.f16945c = function1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class b implements top.zibin.luban.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<File, n1> f16946a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ File f16947b;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super File, n1> function1, File file) {
            this.f16946a = function1;
            this.f16947b = file;
        }

        @Override // top.zibin.luban.d
        public void a(File file) {
            kotlin.jvm.internal.g0.p(file, "file");
            com.orhanobut.logger.j.d("压缩文件路径" + file.getAbsolutePath(), new Object[0]);
            this.f16946a.invoke(file);
        }

        @Override // top.zibin.luban.d
        public void onError(Throwable e6) {
            kotlin.jvm.internal.g0.p(e6, "e");
            this.f16946a.invoke(this.f16947b);
            e6.printStackTrace();
        }

        @Override // top.zibin.luban.d
        public void onStart() {
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class c implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FragmentActivity f16948a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<File, n1> f16949b;

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            if (i6 != -1 || intent == null) {
                this.f16949b.invoke(null);
                return;
            }
            Uri data = intent.getData();
            if (data == null) {
                this.f16949b.invoke(null);
                return;
            }
            String A = u.f16942a.A(data, this.f16948a);
            if (A == null || A.length() == 0) {
                this.f16949b.invoke(null);
                return;
            }
            File file = new File(A);
            if (file.exists()) {
                this.f16949b.invoke(file);
            } else {
                this.f16949b.invoke(null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        c(FragmentActivity fragmentActivity, Function1<? super File, n1> function1) {
            this.f16948a = fragmentActivity;
            this.f16949b = function1;
        }
    }

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class d implements b.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f16950a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<File, n1> f16951b;

        @Override // u.b.a
        public void a(int i6, Intent intent) {
            if (i6 != -1 || intent == null) {
                this.f16951b.invoke(null);
                return;
            }
            Uri data = intent.getData();
            if (data == null) {
                this.f16951b.invoke(null);
                return;
            }
            u uVar = u.f16942a;
            String A = uVar.A(data, this.f16950a);
            if (A == null || A.length() == 0) {
                this.f16951b.invoke(null);
                return;
            }
            File file = new File(A);
            if (file.exists()) {
                uVar.s(this.f16950a, file, this.f16951b);
            } else {
                this.f16951b.invoke(null);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        d(Context context, Function1<? super File, n1> function1) {
            this.f16950a = context;
            this.f16951b = function1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void D(Function1 function1, Ref.ObjectRef objectRef, View view) {
        function1.invoke(null);
        ((Dialog) objectRef.element).dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean E(Function1 function1, DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
        if (i6 != 4 || keyEvent.getAction() != 1) {
            return false;
        }
        function1.invoke(null);
        dialogInterface.dismiss();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 r(Function1 function1) {
        function1.invoke(null);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 v(Function1 function1) {
        function1.invoke(null);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 z(Function1 function1) {
        function1.invoke(null);
        return n1.f44123a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void F(Ref.ObjectRef objectRef, FragmentActivity fragmentActivity, Function1 function1, View view) {
        ((Dialog) objectRef.element).dismiss();
        f16942a.p(fragmentActivity, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void G(Ref.ObjectRef objectRef, FragmentActivity fragmentActivity, Function1 function1, View view) {
        ((Dialog) objectRef.element).dismiss();
        f16942a.x(fragmentActivity, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void H(Ref.ObjectRef objectRef, FragmentActivity fragmentActivity, Function1 function1, View view) {
        ((Dialog) objectRef.element).dismiss();
        f16942a.t(fragmentActivity, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 q(FragmentActivity fragmentActivity, Function1 function1) {
        f16942a.o(fragmentActivity, new u.b(fragmentActivity), function1);
        return n1.f44123a;
    }

    private final void t(final FragmentActivity fragmentActivity, final Function1<? super File, n1> function1) {
        com.bxkj.base.v2.common.ext.b0.H(fragmentActivity, "文件", new Function0() { // from class: com.bxkj.base.v2.common.utils.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 u5;
                u5 = u.u(FragmentActivity.this, function1);
                return u5;
            }
        }, new Function0() { // from class: com.bxkj.base.v2.common.utils.q
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 v5;
                v5 = u.v(Function1.this);
                return v5;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 u(FragmentActivity fragmentActivity, Function1 function1) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        new u.b(fragmentActivity).startActivityForResult(intent).c(new c(fragmentActivity, function1));
        return n1.f44123a;
    }

    private final void w(Context context, u.b bVar, Function1<? super File, n1> function1) {
        bVar.startActivityForResult(new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI)).c(new d(context, function1));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final n1 y(FragmentActivity fragmentActivity, Function1 function1) {
        f16942a.w(fragmentActivity, new u.b(fragmentActivity), function1);
        return n1.f44123a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [T, android.app.Dialog] */
    public final void C(@NotNull final FragmentActivity mContext, @NotNull final Function1<? super File, n1> callback) {
        kotlin.jvm.internal.g0.p(mContext, "mContext");
        kotlin.jvm.internal.g0.p(callback, "callback");
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.pub_dialog_add_file, (ViewGroup) null);
        View findViewById = inflate.findViewById(R.id.tv_camera);
        kotlin.jvm.internal.g0.n(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tv_gallery);
        kotlin.jvm.internal.g0.n(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.tv_file);
        kotlin.jvm.internal.g0.n(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView3 = (TextView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.tv_cancel);
        kotlin.jvm.internal.g0.n(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView4 = (TextView) findViewById4;
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
        ((Dialog) objectRef.element).setCanceledOnTouchOutside(false);
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.j
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.D(Function1.this, objectRef, view);
            }
        });
        ((Dialog) objectRef.element).setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: com.bxkj.base.v2.common.utils.l
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i6, KeyEvent keyEvent) {
                boolean E;
                E = u.E(Function1.this, dialogInterface, i6, keyEvent);
                return E;
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.F(Ref.ObjectRef.this, mContext, callback, view);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.n
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.G(Ref.ObjectRef.this, mContext, callback, view);
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.bxkj.base.v2.common.utils.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.H(Ref.ObjectRef.this, mContext, callback, view);
            }
        });
    }

    public final void p(@NotNull final FragmentActivity fragmentActivity, @NotNull final Function1<? super File, n1> callback) {
        kotlin.jvm.internal.g0.p(fragmentActivity, "fragmentActivity");
        kotlin.jvm.internal.g0.p(callback, "callback");
        com.bxkj.base.v2.common.ext.b0.y(fragmentActivity, "拍照", new Function0() { // from class: com.bxkj.base.v2.common.utils.r
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 q5;
                q5 = u.q(FragmentActivity.this, callback);
                return q5;
            }
        }, new Function0() { // from class: com.bxkj.base.v2.common.utils.s
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 r5;
                r5 = u.r(Function1.this);
                return r5;
            }
        });
    }

    public final void x(@NotNull final FragmentActivity fragmentActivity, @NotNull final Function1<? super File, n1> callback) {
        kotlin.jvm.internal.g0.p(fragmentActivity, "fragmentActivity");
        kotlin.jvm.internal.g0.p(callback, "callback");
        com.bxkj.base.v2.common.ext.b0.N(fragmentActivity, "相册", new Function0() { // from class: com.bxkj.base.v2.common.utils.t
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 y5;
                y5 = u.y(FragmentActivity.this, callback);
                return y5;
            }
        }, new Function0() { // from class: com.bxkj.base.v2.common.utils.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                n1 z5;
                z5 = u.z(Function1.this);
                return z5;
            }
        });
    }

    private u() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String A(Uri uri, Context context) {
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
    public final boolean B() {
        return kotlin.jvm.internal.g0.g(Environment.getExternalStorageState(), "mounted");
    }

    private final void o(Context context, u.b bVar, Function1<? super File, n1> function1) {
        File file;
        Uri uriForFile;
        if (B()) {
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
                uriForFile = FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".provider", file3);
                kotlin.jvm.internal.g0.m(uriForFile);
            }
            Intent intent = new Intent();
            intent.putExtra("output", uriForFile);
            intent.setAction("android.media.action.IMAGE_CAPTURE");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(1);
            bVar.startActivityForResult(intent).c(new a(context, file3, function1));
            return;
        }
        Toast.makeText(context, "未找到存储卡，无法拍照！", 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void s(Context context, File file, Function1<? super File, n1> function1) {
        top.zibin.luban.c.k(context).f(file).h(new b(function1, file)).e();
    }
}
