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
