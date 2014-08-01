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

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.hollowsoft.library.fontdroid.TypefaceCache.PathType;

/**
 * <p>
 * A radio button is a two-states button that can be either checked or
 * unchecked. When the radio button is unchecked, the user can press or click it
 * to check it. However, contrary to a {@link android.widget.CheckBox}, a radio
 * button cannot be unchecked by the user once checked.
 * </p>
 *
 * <p>
 * Radio buttons are normally used together in a
 * {@link android.widget.RadioGroup}. When several radio buttons live inside
 * a radio group, checking one radio button unchecks all the others.</p>
 * </p>
 *
 * <p>See the <a href="{@docRoot}guide/topics/ui/controls/radiobutton.html">Radio Buttons</a>
 * guide.</p>
 *
 * <p><strong>XML attributes</strong></p>
 * <p>
 * See {@link android.R.styleable#CompoundButton CompoundButton Attributes},
 * {@link android.R.styleable#Button Button Attributes},
 * {@link android.R.styleable#TextView TextView Attributes},
 * {@link android.R.styleable#View View Attributes}
 * </p>
 *
 * @author Igor Morais
 * @author mor41s.1gor@gmail.com
 */
public abstract class AbstractRadioButton extends android.widget.RadioButton {

    /**
     *
     * @param context
     */
    public AbstractRadioButton(final Context context) {
        super(context);
    }

    /**
     *
     * @param context
     * @param attributeSet
     */
    public AbstractRadioButton(final Context context, final AttributeSet attributeSet) {
        super(context, attributeSet);

        setTypeface(getTypefaceAssetPath());
    }

    /**
     *
     * @param context
     * @param attributeSet
     * @param defStyle
     */
    public AbstractRadioButton(final Context context, final AttributeSet attributeSet, final int defStyle) {
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
