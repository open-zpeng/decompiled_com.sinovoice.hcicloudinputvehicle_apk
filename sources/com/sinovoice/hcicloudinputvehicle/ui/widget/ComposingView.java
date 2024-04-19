package com.sinovoice.hcicloudinputvehicle.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.tools.b;
import com.sinovoice.hcicloudinputvehicle.tools.f;
import com.sinovoice.hcicloudinputvehicle.ui.UITheme;
/* loaded from: classes.dex */
public class ComposingView extends View {

    /* renamed from: a  reason: collision with root package name */
    private static final String f306a = ComposingView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private final float f307b;
    private Paint c;
    private String d;
    private String[] e;
    private Context f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private String m;

    public ComposingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f307b = 45.0f;
        this.d = "";
        this.i = 1;
        this.k = 0;
        this.f = context;
    }

    public void a() {
        this.d = "";
        invalidate();
        requestLayout();
    }

    public void b(UITheme uITheme) {
        this.j = uITheme.b("colorComposingText");
        setBackground(uITheme.e("candidate_input_bg"));
        Paint paint = new Paint();
        this.c = paint;
        paint.setColor(this.j);
        this.c.setAntiAlias(true);
        this.c.setTextSize(this.f.getResources().getDimension(R.dimen.candidate_composing_font_size));
        this.c.setTypeface(f.a());
        this.k = (int) this.f.getResources().getDimension(R.dimen.composing_padding);
        this.l = this.f.getResources().getDisplayMetrics().widthPixels;
    }

    public void c(String str, String str2) {
        String str3 = f306a;
        Log.d(str3, "setComposingInfo: composing: " + str + "selectComposing: " + str2);
        setComposingInfo(str);
        this.m = str2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        int i2;
        float f;
        if (this.g > this.l && this.i == 1) {
            canvas.translate(-(i - i2), 0.0f);
        }
        if (this.e != null && this.i > 1) {
            for (int i3 = 0; i3 < this.i; i3++) {
                canvas.drawText(this.e[i3], ((int) (this.g - this.c.measureText(this.d))) / 2, ((int) (((this.h - (this.c.getTextSize() * this.i)) / 2.0f) - this.c.ascent())) + (i3 * this.c.getTextSize()), this.c);
            }
        } else if (this.d.length() > 0) {
            int i4 = this.k;
            int textSize = (int) (((this.h - this.c.getTextSize()) / 2.0f) - this.c.ascent());
            if (this.m.isEmpty()) {
                canvas.drawText(this.d, i4, textSize, this.c);
                return;
            }
            int indexOf = this.d.indexOf(this.m);
            String substring = this.d.substring(0, indexOf);
            String substring2 = this.d.substring(indexOf + this.m.length(), this.d.length());
            float f2 = i4;
            float f3 = textSize;
            canvas.drawText(substring, f2, f3, this.c);
            this.c.setFlags(8);
            this.c.setAntiAlias(true);
            canvas.drawText(this.m, (int) (f2 + this.c.measureText(substring)), f3, this.c);
            this.c.setFlags(1);
            canvas.drawText(substring2, (int) (f + this.c.measureText(this.m)), f3, this.c);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int ceil = (int) Math.ceil(this.c.measureText(this.d));
        if (ceil > 0) {
            ceil += this.k * 2;
        }
        int a2 = b.a(getContext(), 22.0f);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            ceil = size;
        } else if (mode == Integer.MIN_VALUE) {
            ceil = Math.min(ceil, size);
        }
        if (mode2 == 1073741824) {
            a2 = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            a2 = Math.min(a2, size2);
        }
        setMeasuredDimension(ceil, a2);
        String str = f306a;
        b.b.a.b.a.a(str, "[onMeasure] w = [" + ceil + "] h = [" + a2 + "]");
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.g = i;
        this.h = i2;
        String str = f306a;
        b.b.a.b.a.a(str, "[onSizeChanged] w = [" + i + "] h = [" + i2 + "]");
    }

    public void setComposingInfo(String str) {
        int i;
        b.b.a.b.a.a(f306a, "[setComposingInfo] composing = [" + str + "]");
        this.d = str;
        this.m = "";
        this.i = 1;
        int measureText = (int) this.c.measureText(str);
        while (true) {
            i = this.l;
            if (measureText <= i - 20) {
                break;
            }
            this.i++;
            measureText -= i - 20;
        }
        int i2 = i - 20;
        int i3 = this.i;
        if (i3 > 1) {
            String[] strArr = new String[i3];
            int i4 = 0;
            int i5 = 0;
            while (i4 < this.i) {
                Paint paint = this.c;
                String str2 = this.d;
                int breakText = paint.breakText(str2.substring(i5, str2.length()), true, i2, null) + i5;
                strArr[i4] = this.d.substring(i5, breakText);
                i4++;
                i5 = breakText;
            }
            this.e = strArr;
        }
        invalidate();
        requestLayout();
    }
}
