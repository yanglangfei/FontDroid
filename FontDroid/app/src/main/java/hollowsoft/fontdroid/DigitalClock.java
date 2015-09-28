package hollowsoft.fontdroid;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class DigitalClock extends android.widget.DigitalClock implements IFont {

    public DigitalClock(final Context context) {
        super(context);
    }

    public DigitalClock(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        getStyleable(context, attributeSet, 0, 0);
    }

    private void getStyleable(final Context context, final AttributeSet attributeSet, final int defStyleAttr, final int defStyleRes) {

        final TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.Font, defStyleAttr, defStyleRes);

        if (!isInEditMode()) {

            final String fontPath = typedArray.getString(R.styleable.Font_fontPath);

            setFont(fontPath);
        }

        typedArray.recycle();
    }

    @Override
    public void setFont(final String path) {

        final Typeface typeface = FontCache.with().put(path, getContext().getAssets());

        setTypeface(typeface);
    }
}
