package com.sinovoice.hcicloudinputvehicle.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import com.sinovoice.hcicloudsdk.common.asr.AsrConfig;
/* loaded from: classes.dex */
public class UITools {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f293a = {"xml", "drawable", "string", "color", "dimen", "fraction", "integer", "array", AsrConfig.GrammarConfig.VALUE_OF_PARAM_GRAMMAR_TYPE_ID};

    /* loaded from: classes.dex */
    public interface Res {
        public static final int ARRAY = 7;
        public static final int COLOR = 3;
        public static final int COLORLLIST = 9;
        public static final int DIMEN = 4;
        public static final int DRAWABLE = 1;
        public static final int FRACTION = 5;
        public static final int ID = 8;
        public static final int INTEGER = 6;
        public static final int NOT_FOUND = -1;
        public static final int STRING = 2;
        public static final int XML = 0;
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        int f294a;

        /* renamed from: b  reason: collision with root package name */
        Context f295b;

        public a(Context context, int i) {
            this.f295b = context;
            this.f294a = i;
        }

        public Context a() {
            return this.f295b;
        }

        public int b() {
            return this.f294a;
        }
    }

    public static int a(Paint paint, int i, int i2, String str) {
        if (i2 <= 0) {
            return i;
        }
        paint.setTextSize(i);
        while (paint.measureText(str) >= i2) {
            i -= 2;
            paint.setTextSize(i);
        }
        return i;
    }

    public static int b(Context context, Context context2, String str) {
        return ((Integer) i(context, context2, str, 3)).intValue();
    }

    public static ColorStateList c(Context context, Context context2, String str) {
        return (ColorStateList) i(context, context2, str, 9);
    }

    public static float d(Context context, Context context2, String str) {
        return ((Float) i(context, context2, str, 4)).floatValue();
    }

    public static Drawable e(Context context, Context context2, String str) {
        return (Drawable) i(context, context2, str, 1);
    }

    public static float f(Context context, Context context2, String str) {
        return ((Float) i(context, context2, str, 5)).floatValue();
    }

    public static int g(Context context, Context context2, String str) {
        return ((Integer) i(context, context2, str, 6)).intValue();
    }

    public static a h(Context context, Context context2, String str, String str2) {
        int j = j(context, str, str2);
        if (j != 0) {
            return new a(context, j);
        }
        return new a(context2, j(context2, str, str2));
    }

    private static Object i(Context context, Context context2, String str, int i) {
        a h = h(context, context2, str, f293a[i]);
        if (i != 9) {
            switch (i) {
                case 0:
                    return h.a().getResources().getXml(h.b());
                case 1:
                    return h.a().getResources().getDrawable(h.b());
                case 2:
                    return h.a().getResources().getString(h.b());
                case 3:
                    return Integer.valueOf(h.a().getResources().getColor(h.b()));
                case 4:
                    return Float.valueOf(h.a().getResources().getDimension(h.b()));
                case 5:
                    return Float.valueOf(h.a().getResources().getFraction(h.b(), 1, 1));
                case 6:
                    return Integer.valueOf(h.a().getResources().getInteger(h.b()));
                default:
                    return null;
            }
        }
        return h.a().getResources().getColorStateList(h.b());
    }

    private static int j(Context context, String str, String str2) {
        if (context == null) {
            return 0;
        }
        return context.getResources().getIdentifier(str, str2, context.getPackageName());
    }

    public static Integer k(Context context, String str, int i) {
        Resources resources = context.getResources();
        if (resources != null) {
            return Integer.valueOf(resources.getIdentifier(str, f293a[i], context.getPackageName()));
        }
        return 0;
    }

    public static String[] l(Context context, Context context2, String str, String str2) {
        a s = s(context, context, str, str2, 7);
        return s.a().getResources().getStringArray(s.f294a);
    }

    public static int m(Context context, Context context2, String str, String str2) {
        a s = s(context, context2, str, str2, 3);
        try {
            return s.a().getResources().getColor(s.f294a);
        } catch (Resources.NotFoundException unused) {
            return b(context, context2, str2);
        }
    }

    public static ColorStateList n(Context context, Context context2, String str, String str2) {
        a s = s(context, context2, str, str2, 3);
        try {
            return s.a().getResources().getColorStateList(s.f294a);
        } catch (Resources.NotFoundException unused) {
            return c(context, context2, str2);
        }
    }

    public static float o(Context context, Context context2, String str, String str2) {
        a s = s(context, context2, str, str2, 4);
        try {
            return s.f295b.getResources().getDimension(s.f294a);
        } catch (Resources.NotFoundException unused) {
            return d(context2, context2, str2);
        }
    }

    public static Drawable p(Context context, Context context2, String str, String str2) {
        a s = s(context, context2, str, str2, 1);
        try {
            return s.a().getResources().getDrawable(s.f294a);
        } catch (Resources.NotFoundException unused) {
            return e(context, context2, str2);
        }
    }

    public static float q(Context context, Context context2, String str, String str2) {
        a s = s(context, context2, str, str2, 5);
        try {
            return s.f295b.getResources().getFraction(s.f294a, 1, 1);
        } catch (Resources.NotFoundException unused) {
            return f(context2, context2, str2);
        }
    }

    public static int r(Context context, Context context2, String str, String str2) {
        a s = s(context, context2, str, str2, 6);
        try {
            return s.f295b.getResources().getInteger(s.f294a);
        } catch (Resources.NotFoundException unused) {
            return g(context, context2, str2);
        }
    }

    public static a s(Context context, Context context2, String str, String str2, int i) {
        int intValue = k(context, str, i).intValue();
        if (intValue != 0) {
            return new a(context, intValue);
        }
        return h(context, context2, str2, f293a[i]);
    }

    public static String t(Context context, Context context2, String str, String str2) {
        a s = s(context, context2, str, str2, 2);
        return s.a().getResources().getString(s.f294a);
    }

    public static Integer u(Context context, Context context2, String str, String str2) {
        Integer k;
        try {
            k = k(context, str, 0);
        } catch (Resources.NotFoundException unused) {
            k = k(context2, str, 0);
        }
        if (k.intValue() != 0) {
            return k;
        }
        return null;
    }
}
