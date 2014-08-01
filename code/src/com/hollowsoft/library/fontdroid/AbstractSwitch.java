/*
 * Copyright (c) 2014 HollowSoft @IgorMorais
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 *
 *          You may obtain a copy of the License at
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an “AS IS” BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hollowsoft.library.fontdroid;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;

import com.hollowsoft.library.fontdroid.TypefaceCache.PathType;

/**
 * A Switch is a two-state toggle switch widget that can select between two
 * options. The user may drag the "thumb" back and forth to choose the selected option,
 * or simply tap to toggle as if it were a checkbox. The {@link #setText(CharSequence) text}
 * property controls the text displayed in the label for the switch, whereas the
 * {@link #setTextOff(CharSequence) off} and {@link #setTextOn(CharSequence) on} text
 * controls the text on the thumb. Similarly, the
 * {@link #setTextAppearance(android.content.Context, int) textAppearance} and the related
 * setTypeface() methods control the typeface and style of label text, whereas the
 * {@link #setSwitchTextAppearance(android.content.Context, int) switchTextAppearance} and
 * the related seSwitchTypeface() methods control that of the thumb.
 *
 * <p>See the <a href="{@docRoot}guide/topics/ui/controls/togglebutton.html">Toggle Buttons</a>
 * guide.</p>
 *
 * @attr ref android.R.styleable#Switch_textOn
 * @attr ref android.R.styleable#Switch_textOff
 * @attr ref android.R.styleable#Switch_switchMinWidth
 * @attr ref android.R.styleable#Switch_switchPadding
 * @attr ref android.R.styleable#Switch_switchTextAppearance
 * @attr ref android.R.styleable#Switch_thumb
 * @attr ref android.R.styleable#Switch_thumbTextPadding
 * @attr ref android.R.styleable#Switch_track
 *
 * @author Igor Morais
 * @author mor41s.1gor@gmail.com
 */
@TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
public abstract class AbstractSwitch extends android.widget.Switch {

    /**
     *
     * @param context
     */
    public AbstractSwitch(final Context context) {
        super(context);
    }

    /**
     *
     * @param context
     * @param attributeSet
     */
    public AbstractSwitch(final Context context, final AttributeSet attributeSet) {
        super(context, attributeSet);

        setTypeface(getTypefaceAssetPath());
    }

    /**
     *
     * @param context
     * @param attributeSet
     * @param defStyle
     */
    public AbstractSwitch(final Context context, final AttributeSet attributeSet, final int defStyle) {
        super(context, attributeSet, defStyle);

        setTypeface(getTypefaceAssetPath());
    }

    /**
     *
     * @param typefaceAssetPath
     */
    private void setTypeface(final String typefaceAssetPath) {

        if (!isInEditMode() && !StringUtility.isNullOrEmpty(typefaceAssetPath)) {

            setTypeface(getTypeface(typefaceAssetPath, PathType.ASSET));
        }
    }

    /**
     *
     * @param typefacePath
     * @param pathType
     * @return
     */
    protected Typeface getTypeface(final String typefacePath, final PathType pathType) {
        return getTypeface(typefacePath, pathType, true);
    }

    /**
     *
     * @param typefacePath
     * @param pathType
     * @param tryCache
     * @return
     */
    protected Typeface getTypeface(final String typefacePath, final PathType pathType, final boolean tryCache) {

        return tryCache ? TypefaceCache.getInstance().get(getContext(), typefacePath, pathType)
                : pathType == PathType.ASSET ? Typeface.createFromAsset(getContext().getAssets(), typefacePath)
                        : Typeface.createFromFile(typefacePath);
    }

    /**
     *
     * @param typefacePath
     * @param pathType
     */
    public void setTypeface(final String typefacePath, final PathType pathType) {
        setTypeface(typefacePath, pathType, true);
    }

    /**
     *
     * @param typefacePath
     * @param pathType
     * @param tryCache
     */
    public void setTypeface(final String typefacePath, final PathType pathType, final boolean tryCache) {
        setTypeface(getTypeface(typefacePath, pathType, tryCache));
    }

    /**
     * Get {@code Typeface} path from the specified asset folder.
     *
     * @return The {@code Typeface} path from the specified asset folder.
     */
    protected abstract String getTypefaceAssetPath();
}
