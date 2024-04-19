package com.sinovoice.hcicloudinputvehicle.ui.CandidateView;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.sinovoice.hcicloudinputvehicle.R;
import com.sinovoice.hcicloudinputvehicle.service.HciCloudIME;
import com.sinovoice.hcicloudinputvehicle.tools.f;
import com.sinovoice.hcicloudinputvehicle.ui.SpanListLookUp;
import com.sinovoice.hcicloudinputvehicle.ui.UITheme;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class MoreCandidateView extends RelativeLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static final String f244a = MoreCandidateView.class.getCanonicalName();

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f245b;
    private RelativeLayout c;
    private RelativeLayout d;
    private ImageButton e;
    private b f;
    private Context g;
    private List<String> h;
    private GridLayoutManager i;
    private SpanListLookUp j;
    private OnCandidateActionListener k;
    private UITheme l;
    private int m;

    /* loaded from: classes.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            super.onScrollStateChanged(recyclerView, i);
            if (i == 0 && MoreCandidateView.this.getLastPosition() + 16 >= MoreCandidateView.this.getItemCount() - 1) {
                MoreCandidateView.this.k.getMoreList();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            super.onScrolled(recyclerView, i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class b extends RecyclerView.Adapter<C0014b> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes.dex */
        public class a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f248a;

            a(int i) {
                this.f248a = i;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (MoreCandidateView.this.k != null) {
                    MoreCandidateView.this.k.onCandidateSelected(this.f248a);
                    MoreCandidateView.this.getBack();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.sinovoice.hcicloudinputvehicle.ui.CandidateView.MoreCandidateView$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0014b extends RecyclerView.ViewHolder {

            /* renamed from: a  reason: collision with root package name */
            TextView f250a;

            /* renamed from: b  reason: collision with root package name */
            LinearLayout f251b;
            View c;

            public C0014b(View view) {
                super(view);
                this.f250a = (TextView) view.findViewById(R.id.more_candidate_item_txt);
                this.f251b = (LinearLayout) view.findViewById(R.id.more_candidate_root);
                this.c = view.findViewById(R.id.divider);
            }
        }

        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: a */
        public void onBindViewHolder(C0014b c0014b, int i) {
            if (MoreCandidateView.this.h != null) {
                c0014b.c.setBackgroundColor(MoreCandidateView.this.l.b(MoreCandidateView.this.g.getResources().getResourceName(R.color.colorMoreCandidateDivider)));
                String str = (String) MoreCandidateView.this.h.get(i);
                if (getItemCount() != 1 && !MoreCandidateView.this.j.b(i)) {
                    c0014b.c.setVisibility(0);
                } else {
                    c0014b.c.setVisibility(8);
                }
                c0014b.f250a.setText(str);
                c0014b.f250a.setTypeface(f.a());
                c0014b.f250a.setTextColor(MoreCandidateView.this.l.c(MoreCandidateView.this.g.getResources().getResourceName(R.color.more_candidate_text_color_selector)));
                c0014b.f250a.setBackground(MoreCandidateView.this.l.e(MoreCandidateView.this.g.getResources().getResourceName(R.drawable.candidate_key_bg_selector)));
                c0014b.f250a.setSoundEffectsEnabled(com.sinovoice.hcicloudinputvehicle.service.f.b().a().f());
                c0014b.f250a.setOnClickListener(new a(i));
            }
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: b */
        public C0014b onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C0014b(LayoutInflater.from(MoreCandidateView.this.g).inflate(R.layout.view_more_candidate_item, viewGroup, false));
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (MoreCandidateView.this.h != null) {
                return MoreCandidateView.this.h.size();
            }
            return 0;
        }
    }

    public MoreCandidateView(Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getBack() {
        this.f245b.scrollToPosition(0);
        this.k.onBack();
        setVisibility(8);
    }

    private int getFirstPosition() {
        int findFirstCompletelyVisibleItemPosition = this.i.findFirstCompletelyVisibleItemPosition();
        String str = f244a;
        Log.d(str, "getFirstPosition: findFirstVisibleItemPosition " + findFirstCompletelyVisibleItemPosition);
        return findFirstCompletelyVisibleItemPosition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getItemCount() {
        return this.i.getItemCount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLastPosition() {
        int findLastCompletelyVisibleItemPosition = this.i.findLastCompletelyVisibleItemPosition();
        String str = f244a;
        Log.d(str, "getLastPosition:findLastVisibleItemPosition " + findLastCompletelyVisibleItemPosition);
        return findLastCompletelyVisibleItemPosition;
    }

    private void l(Context context) {
        this.g = context;
        LayoutInflater.from(context).inflate(R.layout.view_morecandidate, this);
        this.m = this.g.getResources().getDimensionPixelOffset(R.dimen.more_candidate_width) - (this.g.getResources().getDimensionPixelOffset(R.dimen.more_candidate_padding_left) * 2);
        String str = f244a;
        Log.d(str, "mWidth: " + this.m);
    }

    public static void n(Drawable drawable, RecyclerView recyclerView) {
        try {
            Method declaredMethod = View.class.getDeclaredMethod("getScrollCache", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(recyclerView, new Object[0]);
            Object obj = invoke.getClass().getField("scrollBar").get(invoke);
            Field declaredField = obj.getClass().getDeclaredField("mVerticalThumb");
            declaredField.setAccessible(true);
            declaredField.set(obj, drawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void i() {
        setVisibility(8);
    }

    public void j() {
        this.f245b.scrollToPosition(0);
        i();
    }

    public void k(UITheme uITheme) {
        this.l = uITheme;
        this.c.setBackground(uITheme.e(getResources().getResourceName(R.drawable.more_candidate_back_ground)));
        this.e.setSoundEffectsEnabled(com.sinovoice.hcicloudinputvehicle.service.f.b().a().f());
        this.e.setImageDrawable(uITheme.e(getResources().getResourceName(R.drawable.symbol_page_up)));
        n(uITheme.e(getResources().getResourceName(R.drawable.scroll_bar_shape)), this.f245b);
        this.d.setBackground(uITheme.e(getResources().getResourceName(R.drawable.more_candidate_bg)));
        this.f245b.requestLayout();
    }

    public void m(HciCloudIME hciCloudIME) {
        setVisibility(0);
        this.k = hciCloudIME;
        hciCloudIME.getMoreList();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.more_candidate_back) {
            return;
        }
        getBack();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Log.e(f244a, "onDraw()");
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f245b = (RecyclerView) findViewById(R.id.more_candidate_recyclerview);
        this.c = (RelativeLayout) findViewById(R.id.rl_candidate_more_root);
        this.d = (RelativeLayout) findViewById(R.id.rl_candidate_more_cantainer_bg);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.g, 6);
        this.i = gridLayoutManager;
        this.f245b.setLayoutManager(gridLayoutManager);
        this.i.setSpanSizeLookup(this.j);
        b bVar = new b();
        this.f = bVar;
        this.f245b.setAdapter(bVar);
        this.f245b.addOnScrollListener(new a());
        ImageButton imageButton = (ImageButton) findViewById(R.id.more_candidate_back);
        this.e = imageButton;
        imageButton.setOnClickListener(this);
    }

    public void setCandidateData(List<String> list) {
        if (getVisibility() == 8 || list == null || list.size() == 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list);
        this.h = arrayList;
        SpanListLookUp spanListLookUp = this.j;
        if (spanListLookUp == null) {
            SpanListLookUp spanListLookUp2 = new SpanListLookUp(this.h, getResources().getDimensionPixelSize(R.dimen.more_candidate_txt_size), this.m);
            this.j = spanListLookUp2;
            spanListLookUp2.c(getResources().getDimensionPixelOffset(R.dimen.more_candidate_item_margin_left));
            this.i.setSpanSizeLookup(this.j);
        } else {
            spanListLookUp.d(arrayList);
        }
        this.f.notifyDataSetChanged();
    }

    public void setOnCandidateAction(OnCandidateActionListener onCandidateActionListener) {
        this.k = onCandidateActionListener;
    }

    public MoreCandidateView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MoreCandidateView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        l(context);
    }
}
