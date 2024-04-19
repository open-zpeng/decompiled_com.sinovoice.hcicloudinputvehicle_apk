package com.sinovoice.hcicloudinputvehicle.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.tools.e;
import com.sinovoice.hcicloudinputvehicle.tools.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class SymbolAdapter extends RecyclerView.Adapter<b> {

    /* renamed from: a  reason: collision with root package name */
    private final LayoutInflater f269a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f270b;
    private final SymbolView c;
    private final e d;
    private UITheme e;
    LinkedList<c> f;
    private String[] g;
    private int h;
    private int i;
    private int j;
    private int k;
    private c l;
    private int m;
    private ColorStateList n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f271a;

        a(String str) {
            this.f271a = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            SymbolAdapter.this.c.j(this.f271a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.ViewHolder {

        /* renamed from: a  reason: collision with root package name */
        TextView f273a;

        /* renamed from: b  reason: collision with root package name */
        RelativeLayout f274b;

        public b(View view) {
            super(view);
            this.f273a = (TextView) view.findViewById(R.id.tv_symbol_item);
            this.f274b = (RelativeLayout) view.findViewById(R.id.symbols_item_root);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c {

        /* renamed from: a  reason: collision with root package name */
        String f275a;

        /* renamed from: b  reason: collision with root package name */
        String[] f276b;

        c(String str, String[] strArr) {
            this.f275a = str;
            this.f276b = strArr;
        }
    }

    public SymbolAdapter(Context context, SymbolView symbolView) {
        this.f270b = context;
        this.f269a = (LayoutInflater) context.getSystemService("layout_inflater");
        this.c = symbolView;
        this.d = e.a(context);
        this.m = (int) context.getResources().getDimension(R.dimen.symbol_item_width);
    }

    private void f() {
        this.l = this.f.getFirst();
        int c2 = this.d.c("common_string_size");
        if (c2 != -1) {
            this.l.f276b = new String[c2];
            for (int i = 0; i < c2; i++) {
                String[] strArr = this.l.f276b;
                e eVar = this.d;
                strArr[i] = eVar.e("common_string_" + i, "");
            }
        }
    }

    public void b(String str) {
        LinkedList linkedList = new LinkedList(Arrays.asList(this.l.f276b));
        if (!linkedList.remove(str)) {
            linkedList.removeLast();
        }
        linkedList.addFirst(str);
        String[] strArr = new String[linkedList.size()];
        linkedList.toArray(strArr);
        this.l.f276b = strArr;
        if (this.k == 0) {
            this.g = strArr;
        }
        i();
    }

    public ArrayList<String> c() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<c> it = this.f.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().f275a);
        }
        return arrayList;
    }

    public void d(UITheme uITheme) {
        this.e = uITheme;
        this.i = (int) uITheme.d("key_font_size");
        this.j = (int) uITheme.d("keyboard_key_height");
        this.n = this.e.c(this.f270b.getResources().getResourceName(R.color.key_text_color_selector));
    }

    public void e() {
        String[] stringArray;
        this.f = new LinkedList<>();
        for (String str : this.f270b.getResources().getStringArray(R.array.symbols_list)) {
            this.f.add(new c(this.e.h(str + "_label"), this.e.i(str)));
        }
        f();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: g */
    public void onBindViewHolder(b bVar, int i) {
        String[] strArr = this.g;
        if (strArr != null) {
            String str = strArr[i];
            bVar.f273a.setText(str);
            bVar.f273a.setTypeface(f.a());
            ColorStateList colorStateList = this.n;
            if (colorStateList != null) {
                bVar.f273a.setTextColor(colorStateList);
            }
            int i2 = this.i;
            if (str.length() > 5) {
                i2 = UITools.a(bVar.f273a.getPaint(), this.i, this.m, str);
            }
            bVar.f273a.setTextSize(0, i2);
            bVar.f273a.setBackground(this.e.e("keyboard_normal_key"));
            bVar.f273a.setSoundEffectsEnabled(com.sinovoice.hcicloudinputvehicle.service.f.b().a().f());
            bVar.f273a.setOnClickListener(new a(str));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.g.length;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: h */
    public b onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new b(this.f269a.inflate(R.layout.symbols_item, viewGroup, false));
    }

    public void i() {
        if (this.l.f276b != null) {
            Log.d("SymbolAdapter", "saveFrequencyInfo mCommonSymbols:" + Arrays.toString(this.l.f276b));
            this.d.g("common_string_size", this.l.f276b.length);
            for (int i = 0; i < this.l.f276b.length; i++) {
                e eVar = this.d;
                eVar.h("common_string_" + i, this.l.f276b[i]);
            }
        }
    }

    public void j(int i) {
        this.k = i;
        this.g = this.f.get(i).f276b;
        this.h = 0;
        notifyDataSetChanged();
    }
}
