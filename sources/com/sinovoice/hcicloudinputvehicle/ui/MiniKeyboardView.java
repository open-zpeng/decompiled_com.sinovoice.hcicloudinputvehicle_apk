package com.sinovoice.hcicloudinputvehicle.ui;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sinovoice.hcicloudinputvehicle.R;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class MiniKeyboardView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private static final String f259a = MiniKeyboardView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private CharSequence f260b;
    private KeyboardView c;
    private LayoutInflater d;
    private int e;
    private int f;
    private ArrayList<String> g;

    public MiniKeyboardView(@NonNull Context context) {
        super(context);
        this.e = 0;
        this.g = new ArrayList<>();
    }

    public void a() {
        getChildAt(this.f).setActivated(false);
        getChildAt(this.e).setActivated(true);
        this.f = this.e;
    }

    public void b(int i) {
        int i2 = this.e;
        if (i2 + i < 0 || i2 + i >= getChildCount()) {
            return;
        }
        getChildAt(this.f).setActivated(false);
        getChildAt(this.e + i).setActivated(true);
        this.f = this.e + i;
    }

    public char getCurrentLongPressChar() {
        return this.g.get(this.f).charAt(0);
    }

    public void setMiniKey(CharSequence charSequence) {
        this.f260b = charSequence;
        this.g.clear();
        for (int i = 0; i < charSequence.length(); i++) {
            char charAt = charSequence.charAt(i);
            TextView textView = (TextView) this.d.inflate(R.layout.key_pop, (ViewGroup) null);
            textView.setText(String.valueOf(charAt));
            this.g.add(String.valueOf(charAt));
            addView(textView);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.width = (int) getResources().getDimension(R.dimen.key_pop_width);
            layoutParams.height = (int) getResources().getDimension(R.dimen.key_pop_height);
            int dimension = (int) getResources().getDimension(R.dimen.key_pop_padding);
            layoutParams.setMargins(dimension, dimension, dimension, dimension);
            textView.setLayoutParams(layoutParams);
            if (charAt >= '0' && charAt <= '9') {
                this.e = i;
            }
        }
        getChildAt(this.e).setActivated(true);
        this.f = this.e;
        requestLayout();
    }

    public void setPopupParent(KeyboardView keyboardView) {
        this.c = keyboardView;
    }

    public MiniKeyboardView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = 0;
        this.g = new ArrayList<>();
        this.d = (LayoutInflater) getContext().getSystemService("layout_inflater");
    }

    public MiniKeyboardView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.e = 0;
        this.g = new ArrayList<>();
    }
}
