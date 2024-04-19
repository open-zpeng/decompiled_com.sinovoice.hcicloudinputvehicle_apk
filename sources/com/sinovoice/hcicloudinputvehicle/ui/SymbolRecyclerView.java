package com.sinovoice.hcicloudinputvehicle.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
/* loaded from: classes.dex */
public class SymbolRecyclerView extends RecyclerView {

    /* renamed from: a  reason: collision with root package name */
    private int f277a;

    public SymbolRecyclerView(Context context) {
        super(context);
    }

    @Override // android.view.View
    public int getSolidColor() {
        return this.f277a;
    }

    @Override // android.view.View
    protected float getTopFadingEdgeStrength() {
        return 0.0f;
    }

    public void setSoliColor(int i) {
        this.f277a = i;
    }

    public SymbolRecyclerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SymbolRecyclerView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
