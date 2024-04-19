package com.sinovoice.hcicloudinputvehicle.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.tools.f;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class SymbolTitleAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private final Context f278a;

    /* renamed from: b  reason: collision with root package name */
    private final LayoutInflater f279b;
    private UITheme c;
    private SymbolView d;
    private int e = 0;
    private ArrayList<String> f;
    private ColorStateList g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f280a;

        a(int i) {
            this.f280a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SymbolTitleAdapter.this.d.setSymbolsLabelIndex(this.f280a);
            SymbolTitleAdapter.this.e = this.f280a;
            SymbolTitleAdapter.this.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f282a;

        public b(View view) {
            super(view);
            this.f282a = (TextView) view.findViewById(R.id.item_btn_symbol_title);
        }
    }

    public SymbolTitleAdapter(Context context) {
        this.f278a = context;
        this.f279b = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    public void c() {
        this.e = 0;
        notifyDataSetChanged();
    }

    public void d(UITheme uITheme) {
        this.c = uITheme;
        this.g = uITheme.c(this.f278a.getResources().getResourceName(R.color.symbol_key_text_color_selector));
    }

    public void e(ArrayList<String> arrayList, SymbolView symbolView) {
        this.f = arrayList;
        Log.d("SymbolTitleAdapter", "mTitles:" + this.f);
        this.d = symbolView;
        this.e = 0;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: f */
    public void onBindViewHolder(b bVar, int i) {
        ArrayList<String> arrayList = this.f;
        if (arrayList != null) {
            bVar.f282a.setText(arrayList.get(i));
            bVar.f282a.setTypeface(f.a());
            ColorStateList colorStateList = this.g;
            if (colorStateList != null) {
                bVar.f282a.setTextColor(colorStateList);
            }
            bVar.f282a.setBackground(this.c.e(this.f278a.getResources().getResourceName(R.drawable.keyboard_function_key)));
            bVar.f282a.setSelected(i == this.e);
            bVar.f282a.setSoundEffectsEnabled(com.sinovoice.hcicloudinputvehicle.service.f.b().a().f());
            bVar.f282a.setOnClickListener(new a(i));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: g */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(this.f279b.inflate(R.layout.symbol_title_item, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    public void h(int i) {
        this.e = i;
        notifyDataSetChanged();
    }
}
