/*
 * Copyright (c) 2014 HollowSoft @Igor Morais
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
 * Like AnalogClock, but digital.  Shows seconds.
 *
 * @deprecated It is recommended you use {@link TextClock} instead.
 *
 * @author Igor Morais
 * @author Mor41s.1gor@gmail.com
 */
@Deprecated
public abstract class AbstractDigitalClock extends android.widget.DigitalClock {

    /**
     *
     * @param context
     */
    public AbstractDigitalClock(final Context context) {
        super(context);
    }

    /**
     *
     * @param context
     * @param attributeSet
     */
    public AbstractDigitalClock(final Context context, final AttributeSet attributeSet) {
        super(context, attributeSet);

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
     *
     * @return
     */
    protected abstract String getTypefaceAssetPath();
}
