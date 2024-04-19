package com.sinovoice.hcicloudinputvehicle.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.service.e;
import com.sinovoice.hcicloudinputvehicle.service.f;
/* loaded from: classes.dex */
public class SymbolView extends FrameLayout implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f284a = SymbolView.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private SymbolRecyclerView f285b;
    private SymbolRecyclerView c;
    private SymbolAdapter d;
    private UITheme e;
    private SymbolTitleAdapter f;
    private int g;
    private SymbolView h;
    private ImageButton i;
    private ImageButton j;
    private ImageButton k;
    private ImageButton l;
    private ImageButton m;
    private View n;
    private boolean o;
    private OnSymbolActionListener p;
    private LinearLayout q;
    private boolean r;
    private Handler s;
    private e t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            String str = SymbolView.f284a;
            b.b.a.b.a.a(str, "onScrollStateChanged:  state=" + i);
            SymbolView.this.e();
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            String str = SymbolView.f284a;
            b.b.a.b.a.a(str, "onScrollStateChanged:  state=" + i);
            SymbolView.this.e();
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    }

    /* loaded from: classes.dex */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == 0 && SymbolView.this.r) {
                sendMessageDelayed(Message.obtain(this, 0), 80L);
                SymbolView.this.f();
            }
        }
    }

    public SymbolView(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (getLastPositionShowOnSymbol() == this.d.getItemCount() - 1) {
            this.k.setEnabled(false);
        } else {
            this.k.setEnabled(true);
        }
        if (getFirstPositionShowOnSymbol() == 0) {
            this.j.setEnabled(false);
        } else {
            this.j.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        OnSymbolActionListener onSymbolActionListener = this.p;
        if (onSymbolActionListener != null) {
            onSymbolActionListener.onDelete();
        }
    }

    private void getBack() {
        this.n.setVisibility(0);
        h();
        this.f.c();
        this.t.o();
    }

    private int getFirstPositionShowOnSymbol() {
        return ((StaggeredGridLayoutManager) this.c.getLayoutManager()).findFirstCompletelyVisibleItemPositions(null)[0];
    }

    private int getLastPositionShowOnSymbol() {
        int[] findLastCompletelyVisibleItemPositions;
        int i = 0;
        for (int i2 : ((StaggeredGridLayoutManager) this.c.getLayoutManager()).findLastCompletelyVisibleItemPositions(null)) {
            if (i2 >= i) {
                i = i2;
            }
        }
        return i;
    }

    private void getNextPage() {
        this.c.smoothScrollToPosition(getLastPositionShowOnSymbol() + 12);
    }

    private void getPrePage() {
        int firstPositionShowOnSymbol = getFirstPositionShowOnSymbol() - 12;
        if (firstPositionShowOnSymbol < 0) {
            firstPositionShowOnSymbol = 0;
        }
        this.c.smoothScrollToPosition(firstPositionShowOnSymbol);
    }

    private void i(Context context) {
        SymbolView symbolView = (SymbolView) LayoutInflater.from(context).inflate(R.layout.symbol_view, this);
        this.h = symbolView;
        this.f285b = (SymbolRecyclerView) symbolView.findViewById(R.id.symbol_title);
        this.c = (SymbolRecyclerView) this.h.findViewById(R.id.symbols_list_recycle);
        this.q = (LinearLayout) this.h.findViewById(R.id.symbol_bottom);
        this.d = new SymbolAdapter(context, this);
        this.f = new SymbolTitleAdapter(context);
        this.i = (ImageButton) findViewById(R.id.btn_symbol_lock);
        this.j = (ImageButton) findViewById(R.id.btn_symbol_pre_page);
        this.k = (ImageButton) findViewById(R.id.btn_symbol_next_page);
        this.l = (ImageButton) findViewById(R.id.btn_symbol_back);
        this.m = (ImageButton) findViewById(R.id.btn_symbol_delete);
        this.i.setOnClickListener(this);
        this.i.setActivated(this.o);
        this.j.setOnClickListener(this);
        this.k.setOnClickListener(this);
        this.l.setOnClickListener(this);
        this.m.setOnClickListener(this);
        this.m.setOnLongClickListener(this);
    }

    private void k() {
        boolean f = f.b().a().f();
        this.i.setSoundEffectsEnabled(f);
        this.j.setSoundEffectsEnabled(f);
        this.k.setSoundEffectsEnabled(f);
        this.l.setSoundEffectsEnabled(f);
        this.m.setSoundEffectsEnabled(f);
        this.m.setSoundEffectsEnabled(f);
    }

    private void n() {
        boolean z = !this.o;
        this.o = z;
        this.i.setActivated(z);
    }

    public void g(UITheme uITheme) {
        this.e = uITheme;
        this.g = (int) uITheme.d("more_candidate_height");
        this.h.setBackground(uITheme.e(getResources().getResourceName(R.drawable.keyboard_back_ground_more)));
        this.i.setBackground(uITheme.e(getResources().getResourceName(R.drawable.keyboard_function_key)));
        this.j.setBackground(uITheme.e(getResources().getResourceName(R.drawable.keyboard_function_key)));
        this.k.setBackground(uITheme.e(getResources().getResourceName(R.drawable.keyboard_function_key)));
        this.m.setBackground(uITheme.e(getResources().getResourceName(R.drawable.keyboard_function_key)));
        this.l.setBackground(uITheme.e(getResources().getResourceName(R.drawable.keyboard_function_key)));
        Drawable e = uITheme.e(getResources().getResourceName(R.drawable.symbol_lock_icon_selector));
        Drawable e2 = uITheme.e(getResources().getResourceName(R.drawable.symbol_pre_icon_selector));
        Drawable e3 = uITheme.e(getResources().getResourceName(R.drawable.symbol_next_icon_selector));
        Drawable e4 = uITheme.e(getResources().getResourceName(R.drawable.symbol_delete_icon_selector));
        Drawable e5 = uITheme.e(getResources().getResourceName(R.drawable.symbol_back_icon_selector));
        this.f285b.setSoliColor(uITheme.b(getResources().getResourceName(R.color.symbol_fade)));
        this.c.setSoliColor(uITheme.b(getResources().getResourceName(R.color.symbol_fade)));
        this.i.setImageDrawable(e);
        this.j.setImageDrawable(e2);
        this.k.setImageDrawable(e3);
        this.m.setImageDrawable(e4);
        this.l.setImageDrawable(e5);
        this.j.setEnabled(false);
        this.k.setEnabled(true);
    }

    public void h() {
        setVisibility(8);
    }

    public void j(String str) {
        OnSymbolActionListener onSymbolActionListener = this.p;
        if (onSymbolActionListener != null) {
            onSymbolActionListener.onSymbolSelected(str);
        }
        this.d.b(str);
        if (this.o) {
            return;
        }
        getBack();
    }

    public void l(SymbolView symbolView, e eVar) {
        this.n = symbolView;
        this.t = eVar;
        this.d.d(this.e);
        this.d.e();
        this.c.setAdapter(this.d);
        this.c.setLayoutManager(new StaggeredGridLayoutManager(5, 1));
        this.c.setOnScrollListener(new b());
        this.f.d(this.e);
        this.f.e(this.d.c(), this);
        this.f285b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f285b.setAdapter(this.f);
        this.f285b.setOverScrollMode(2);
        setSymbolsLabelIndex(2);
        this.f.h(2);
        setVisibility(0);
        k();
    }

    public void m(View view, e eVar) {
        this.n = view;
        this.t = eVar;
        this.d.d(this.e);
        this.d.e();
        this.c.setAdapter(this.d);
        this.c.setLayoutManager(new StaggeredGridLayoutManager(5, 1));
        this.c.setOnScrollListener(new a());
        this.f.d(this.e);
        this.f.e(this.d.c(), this);
        this.f285b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        this.f285b.setAdapter(this.f);
        this.f285b.setOverScrollMode(2);
        setSymbolsLabelIndex(0);
        setVisibility(0);
        k();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.s = new c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_symbol_back /* 2131230756 */:
                getBack();
                return;
            case R.id.btn_symbol_delete /* 2131230757 */:
                this.r = false;
                f();
                return;
            case R.id.btn_symbol_lock /* 2131230758 */:
                n();
                return;
            case R.id.btn_symbol_next_page /* 2131230759 */:
                getNextPage();
                return;
            case R.id.btn_symbol_pre_page /* 2131230760 */:
                getPrePage();
                return;
            default:
                return;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1 || motionEvent.getAction() == 4) {
            this.r = false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnLongClickListener
    public boolean onLongClick(View view) {
        this.r = true;
        this.s.sendMessageDelayed(getHandler().obtainMessage(0), 300L);
        return false;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && size > (i5 = this.g)) {
            size = i5;
        }
        if (mode == 0 && size > (i4 = this.g)) {
            size = i4;
        }
        if (mode == Integer.MIN_VALUE && size > (i3 = this.g)) {
            size = i3;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(size, mode));
    }

    public void setOnSymbolActionListener(OnSymbolActionListener onSymbolActionListener) {
        this.p = onSymbolActionListener;
    }

    public void setSymbolsLabelIndex(int i) {
        this.k.setEnabled(true);
        this.j.setEnabled(false);
        this.d.j(i);
        this.c.scrollToPosition(0);
    }

    public SymbolView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.o = true;
        i(context);
    }
}
