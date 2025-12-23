package com.bxkj.student.v2.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import androidx.core.content.ContextCompat;
import com.bxkj.student.App;
import com.bxkj.student.R;
import com.google.mlkit.common.sdkinternal.OptionalModuleUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.jvm.internal.g0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f20881a = new a(null);

    /* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.v vVar) {
            this();
        }

        private a() {
        }

        private final Bitmap d(int i6, Bitmap bitmap, String str) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setTextSize(cn.bluemobi.dylan.base.utils.u.a(15.0f, App.f17573d.a()));
            paint.setColor(i6);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.SANS_SERIF, 1));
            paint.getTextBounds(str, 0, str.length(), new Rect());
            canvas.drawText(str, bitmap.getWidth() / 2, bitmap.getHeight() / 2, paint);
            return bitmap;
        }

        @Nullable
        public final File a(@NotNull Context context, @Nullable Bitmap bitmap) {
            FileOutputStream fileOutputStream;
            g0.p(context, "context");
            FileOutputStream fileOutputStream2 = null;
            if (bitmap != null && !bitmap.isRecycled()) {
                com.orhanobut.logger.j.d("bmp.getWidth()=" + bitmap.getWidth() + "bmp.getHeight()" + bitmap.getHeight(), new Object[0]);
                File externalCacheDir = g0.g("mounted", Environment.getExternalStorageState()) ? context.getExternalCacheDir() : null;
                if (externalCacheDir == null || !externalCacheDir.exists()) {
                    externalCacheDir = context.getCacheDir();
                }
                File file = new File(externalCacheDir, OptionalModuleUtils.FACE);
                boolean exists = file.exists();
                if (!exists) {
                    exists = file.mkdirs();
                }
                if (exists) {
                    File file2 = new File(file, "sports" + System.currentTimeMillis() + com.bxkj.base.v2.common.utils.g0.f16898c);
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                        try {
                            bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                            try {
                                fileOutputStream.close();
                            } catch (IOException unused) {
                            }
                            return file2;
                        } catch (FileNotFoundException unused2) {
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused3) {
                                }
                            }
                            return null;
                        } catch (Throwable th) {
                            th = th;
                            fileOutputStream2 = fileOutputStream;
                            if (fileOutputStream2 != null) {
                                try {
                                    fileOutputStream2.close();
                                } catch (IOException unused4) {
                                }
                            }
                            throw th;
                        }
                    } catch (FileNotFoundException unused5) {
                        fileOutputStream = null;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
            return null;
        }

        @NotNull
        public final Bitmap b(@NotNull String text) {
            g0.p(text, "text");
            Drawable drawable = ContextCompat.getDrawable(App.f17573d.a(), R.mipmap.point_number);
            g0.n(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
            int parseColor = Color.parseColor("#b2b2b2");
            g0.m(copy);
            return d(parseColor, copy, text);
        }

        @NotNull
        public final Bitmap c(@NotNull String text) {
            g0.p(text, "text");
            Drawable drawable = ContextCompat.getDrawable(App.f17573d.a(), R.mipmap.point_ok_nuber);
            g0.n(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            Bitmap copy = ((BitmapDrawable) drawable).getBitmap().copy(Bitmap.Config.ARGB_8888, true);
            int parseColor = Color.parseColor("#3ecda1");
            g0.m(copy);
            return d(parseColor, copy, text);
        }
    }
}
