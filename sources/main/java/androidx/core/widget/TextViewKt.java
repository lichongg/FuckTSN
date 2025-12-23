package androidx.core.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.n1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
@SourceDebugExtension({"SMAP\nTextView.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n1#1,97:1\n65#1:98\n77#1,4:99\n93#1,3:103\n65#1,16:106\n93#1,3:122\n65#1,16:125\n93#1,3:141\n*S KotlinDebug\n*F\n+ 1 TextView.kt\nandroidx/core/widget/TextViewKt\n*L\n35#1:98\n35#1:99,4\n35#1:103,3\n49#1:106,16\n49#1:122,3\n58#1:125,16\n58#1:141,3\n*E\n"})
/* loaded from: D:\Downloads\app\classes.dex */
public final class TextViewKt {
    @NotNull
    public static final TextWatcher addTextChangedListener(@NotNull TextView textView, @NotNull Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, n1> function4, @NotNull Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, n1> function42, @NotNull Function1<? super Editable, n1> function1) {
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(function1, function4, function42);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    public static /* synthetic */ TextWatcher addTextChangedListener$default(TextView textView, Function4 function4, Function4 function42, Function1 function1, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            function4 = new Function4<CharSequence, Integer, Integer, Integer, n1>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$1
                public final void invoke(@Nullable CharSequence charSequence, int i7, int i8, int i9) {
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ n1 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return n1.f44123a;
                }
            };
        }
        if ((i6 & 2) != 0) {
            function42 = new Function4<CharSequence, Integer, Integer, Integer, n1>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$2
                public final void invoke(@Nullable CharSequence charSequence, int i7, int i8, int i9) {
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ n1 invoke(CharSequence charSequence, Integer num, Integer num2, Integer num3) {
                    invoke(charSequence, num.intValue(), num2.intValue(), num3.intValue());
                    return n1.f44123a;
                }
            };
        }
        if ((i6 & 4) != 0) {
            function1 = new Function1<Editable, n1>() { // from class: androidx.core.widget.TextViewKt$addTextChangedListener$3
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Editable editable) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ n1 invoke(Editable editable) {
                    invoke2(editable);
                    return n1.f44123a;
                }
            };
        }
        TextViewKt$addTextChangedListener$textWatcher$1 textViewKt$addTextChangedListener$textWatcher$1 = new TextViewKt$addTextChangedListener$textWatcher$1(function1, function4, function42);
        textView.addTextChangedListener(textViewKt$addTextChangedListener$textWatcher$1);
        return textViewKt$addTextChangedListener$textWatcher$1;
    }

    @NotNull
    public static final TextWatcher doAfterTextChanged(@NotNull TextView textView, @NotNull final Function1<? super Editable, n1> function1) {
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doAfterTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                Function1.this.invoke(editable);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doBeforeTextChanged(@NotNull TextView textView, @NotNull final Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, n1> function4) {
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doBeforeTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
                Function4.this.invoke(charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }

    @NotNull
    public static final TextWatcher doOnTextChanged(@NotNull TextView textView, @NotNull final Function4<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, n1> function4) {
        TextWatcher textWatcher = new TextWatcher() { // from class: androidx.core.widget.TextViewKt$doOnTextChanged$$inlined$addTextChangedListener$default$1
            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
                Function4.this.invoke(charSequence, Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8));
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i6, int i7, int i8) {
            }
        };
        textView.addTextChangedListener(textWatcher);
        return textWatcher;
    }
}
