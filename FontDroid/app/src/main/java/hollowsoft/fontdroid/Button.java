/*
 * Copyright 2015 Igor Morais
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package hollowsoft.fontdroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;

public class Button extends android.widget.Button implements IFont {

    public Button(final Context context) {
        super(context);
    }

    public Button(final Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        getStyleable(context, attributeSet, 0, 0);
    }

    public Button(final Context context, final AttributeSet attributeSet, final int defStyleAttr) {
        super(context, attributeSet, defStyleAttr);

        getStyleable(context, attributeSet, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public Button(final Context context, final AttributeSet attributeSet, final int defStyleAttr, final int defStyleRes) {
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
