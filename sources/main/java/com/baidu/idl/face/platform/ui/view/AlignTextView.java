package com.baidu.idl.face.platform.ui.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.widget.TextView;

/* compiled from: r8-map-id-90f57856855cc25dcb99430ee461a8d254046ac77d3f49675e58b81fe049f342 */
/* loaded from: D:\Downloads\app\classes2.dex */
public class AlignTextView extends TextView {
    private int mLineY;
    private int mViewWidth;

    public AlignTextView(Context context) {
        super(context);
    }

    public AlignTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void drawScaledText(Canvas canvas, String str, float f6) {
        float f7 = 0.0f;
        if (isFirstLineOfParagraph(str)) {
            canvas.drawText("  ", 0.0f, this.mLineY, getPaint());
            f7 = 0.0f + Layout.getDesiredWidth("  ", getPaint());
            str = str.substring(3);
        }
        int length = str.length() - 1;
        int i6 = 2;
        if (str.length() > 2 && str.charAt(0) == 12288 && str.charAt(1) == 12288) {
            String substring = str.substring(0, 2);
            float desiredWidth = Layout.getDesiredWidth(substring, getPaint());
            canvas.drawText(substring, f7, this.mLineY, getPaint());
            f7 += desiredWidth;
        } else {
            i6 = 0;
        }
        float f8 = (this.mViewWidth - f6) / length;
        while (i6 < str.length()) {
            String valueOf = String.valueOf(str.charAt(i6));
            float desiredWidth2 = Layout.getDesiredWidth(valueOf, getPaint());
            canvas.drawText(valueOf, f7, this.mLineY, getPaint());
            f7 += desiredWidth2 + f8;
            i6++;
        }
    }

    private boolean isFirstLineOfParagraph(String str) {
        if (str.length() <= 3 || str.charAt(0) != ' ' || str.charAt(1) != ' ') {
            return false;
        }
        return true;
    }

    private boolean needScale(String str) {
        if (str.length() == 0 || str.charAt(str.length() - 1) == '\n') {
            return false;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        TextPaint paint = getPaint();
        paint.setColor(getCurrentTextColor());
        paint.drawableState = getDrawableState();
        this.mViewWidth = getMeasuredWidth();
        String charSequence = getText().toString();
        this.mLineY = 0;
        this.mLineY = (int) (0 + getTextSize());
        Layout layout = getLayout();
        if (layout != null) {
            Paint.FontMetrics fontMetrics = paint.getFontMetrics();
            int ceil = (int) ((((int) Math.ceil(fontMetrics.descent - fontMetrics.ascent)) * layout.getSpacingMultiplier()) + layout.getSpacingAdd());
            for (int i6 = 0; i6 < layout.getLineCount(); i6++) {
                int lineStart = layout.getLineStart(i6);
                int lineEnd = layout.getLineEnd(i6);
                float desiredWidth = Layout.getDesiredWidth(charSequence, lineStart, lineEnd, getPaint());
                String substring = charSequence.substring(lineStart, lineEnd);
                if (!substring.equals("")) {
                    if (i6 < layout.getLineCount() - 1) {
                        if (needScale(substring)) {
                            drawScaledText(canvas, substring, desiredWidth);
                        } else {
                            canvas.drawText(substring, 0.0f, this.mLineY, paint);
                        }
                    } else {
                        canvas.drawText(substring, 0.0f, this.mLineY, paint);
                    }
                    this.mLineY += ceil;
                } else {
                    return;
                }
            }
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z5, int i6, int i7, int i8, int i9) {
        super.onLayout(z5, i6, i7, i8, i9);
    }
}
