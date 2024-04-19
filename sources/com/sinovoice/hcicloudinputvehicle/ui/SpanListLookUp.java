package com.sinovoice.hcicloudinputvehicle.ui;

import android.graphics.Paint;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import java.util.List;
/* loaded from: classes.dex */
public class SpanListLookUp extends GridLayoutManager.SpanSizeLookup {

    /* renamed from: a  reason: collision with root package name */
    private static final String f261a = "SpanListLookUp";

    /* renamed from: b  reason: collision with root package name */
    private List<String> f262b;
    private Paint c;
    private int d;
    private int e = 0;
    private int f;
    private int[] g;
    int h;

    public SpanListLookUp(List<String> list, int i, int i2) {
        this.d = i2;
        this.f = i;
        Paint paint = new Paint();
        this.c = paint;
        paint.setTextSize(i);
        d(list);
    }

    private void a() {
        int i;
        int[] iArr = this.g;
        if (iArr == null || iArr.length == 0) {
            return;
        }
        int i2 = 0;
        if (iArr.length == 1) {
            iArr[0] = 1;
            return;
        }
        try {
            int i3 = (this.d / 6) - this.e;
            for (int i4 = 0; i4 < this.f262b.size(); i4++) {
                String str = this.f262b.get(i4);
                if (str.length() <= 2) {
                    this.g[i4] = 1;
                } else {
                    this.g[i4] = (((int) this.c.measureText(str)) / i3) + 1;
                }
            }
            int i5 = 6;
            while (true) {
                int[] iArr2 = this.g;
                if (i2 >= iArr2.length) {
                    break;
                }
                i5 -= iArr2[i2];
                if (i5 != 0) {
                    if (i5 >= 0) {
                        i2++;
                    } else {
                        if (i5 == -1) {
                            int i6 = i2 - 1;
                            if (iArr2[i6] == 1) {
                                iArr2[i6] = 2;
                                i2--;
                            }
                        }
                        int i7 = -i5;
                        for (int i8 = i2 - 1; i8 >= 0; i8--) {
                            int[] iArr3 = this.g;
                            if (iArr3[i8] == 1) {
                                iArr3[i8] = 2;
                                i7--;
                                if (i7 == 0) {
                                    break;
                                }
                            }
                        }
                        i2--;
                    }
                }
                i5 = 6;
                i2++;
            }
            Log.d(f261a, "calculateSpanSize: total=" + i5);
            if (i5 != 6) {
                i5 = 6 - i5;
            }
            int length = this.g.length - 1;
            this.h = length;
            if (length < 0) {
                return;
            }
            do {
                int[] iArr4 = this.g;
                int i9 = this.h;
                i5 -= iArr4[i9];
                if (i5 == 0) {
                    return;
                }
                i = i9 - 1;
                this.h = i;
            } while (i >= 0);
        } catch (Exception e) {
            b.b.a.b.a.b(f261a, "SpanLookCrash:" + e.getMessage());
        }
    }

    public boolean b(int i) {
        int i2;
        return (this.g.length == 1 || (i2 = this.h) == -1 || i < i2) ? false : true;
    }

    public void c(int i) {
        this.e = i;
    }

    public void d(List<String> list) {
        this.f262b = list;
        this.g = new int[list.size()];
        a();
    }

    @Override // android.support.v7.widget.GridLayoutManager.SpanSizeLookup
    public int getSpanSize(int i) {
        int[] iArr = this.g;
        if (iArr == null || i < 0 || i >= iArr.length) {
            return 1;
        }
        int i2 = iArr[i];
        return i2 < 0 ? i2 * (-1) : i2;
    }
}
