package com.xiaopeng.libtheme;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.util.Log;
import java.util.HashMap;
@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes.dex */
public class TextView extends android.widget.TextView {

    /* renamed from: a  reason: collision with root package name */
    private HashMap<String, Integer> f456a;

    public TextView(Context context) {
        this(context, null);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (a.b(configuration)) {
            a.d(this, this.f456a);
        }
    }

    public void setXTextColor(int i) {
        Log.i("XTextView", "setXTextColor resId=" + i);
    }

    public TextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
        this.f456a = a.c(context, attributeSet);
    }

    public TextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }
}
