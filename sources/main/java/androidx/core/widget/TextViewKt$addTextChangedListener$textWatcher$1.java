package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1\n*L\n1#1,97:1\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class TextViewKt$addTextChangedListener$textWatcher$1 implements TextWatcher {
    final /* synthetic */ Function1<Editable, n1> $afterTextChanged;
    final /* synthetic */ Function4<CharSequence, Integer, Integer, Integer, n1> $beforeTextChanged;
    final /* synthetic */ Function4<CharSequence, Integer, Integer, Integer, n1> $onTextChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public TextViewKt$addTextChangedListener$textWatcher$1(Function1<? super Editable, n1> function1, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, n1> function4, Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, n1> function42) {
        this.$afterTextChanged = function1;
        this.$beforeTextChanged = function4;
        this.$onTextChanged = function42;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(@Nullable Editable editable) {
        this.$afterTextChanged.invoke(editable);
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
        this.$beforeTextChanged.invoke(charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
        this.$onTextChanged.invoke(charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
    }
}
