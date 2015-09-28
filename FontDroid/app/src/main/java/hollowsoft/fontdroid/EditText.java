package hollowsoft.fontdroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;

/**
 * Created by IgorMorais on 9/28/15.
 */
public class EditText extends android.widget.EditText implements IFont {

    public EditText(final Context context) {
        super(context);
    }

    public EditText(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        getStyleable(context, attributeSet, 0, 0);
    }

    public EditText(final Context context, final AttributeSet attributeSet, final int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);

        getStyleable(context, attributeSet, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public EditText(final Context context, final AttributeSet attributeSet, final int defStyleAttr, final int defStyleRes) {
        super(context, attributeSet, defStyleAttr, defStyleRes);

        getStyleable(context, attributeSet, defStyleAttr, defStyleRes);
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
