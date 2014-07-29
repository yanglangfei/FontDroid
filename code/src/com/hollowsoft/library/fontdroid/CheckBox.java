/*
 * Copyright (c) 2013 HollowSoft @IgorMorais
 *
 * Licensed under the Apache License, Version 2.0 (the “License”);
 * you may not use this file except in compliance with the License.
 *
 * 			You may obtain a copy of the License at
 * 			http://www.apache.org/licenses/LICENSE-2.0
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
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.hollowsoft.library.fontdroid.TypefaceCache.PathType;

/**
 * <p>
 * A checkbox is a specific type of two-states button that can be either checked
 * or unchecked. A example usage of a checkbox inside your activity would be the
 * following:
 * </p>
 *
 * <pre class="prettyprint">
 * public class MyActivity extends Activity {
 *     protected void onCreate(Bundle icicle) {
 *         super.onCreate(icicle);
 *
 *         setContentView(R.layout.content_layout_id);
 *
 *         final CheckBox checkBox = (CheckBox) findViewById(R.id.checkbox_id);
 *         if (checkBox.isChecked()) {
 *             checkBox.setChecked(false);
 *         }
 *     }
 * }
 * </pre>
 *
 * <p>
 * See the <a href="{@docRoot}
 * guide/topics/ui/controls/checkbox.html">Checkboxes</a> guide.
 * </p>
 *
 * <p>
 * <strong>XML attributes</strong>
 * </p>
 * <p>
 * See {@link android.R.styleable#CompoundButton CompoundButton Attributes},
 * {@link android.R.styleable#Button Button Attributes},
 * {@link android.R.styleable#TextView TextView Attributes},
 * {@link android.R.styleable#View View Attributes}
 * </p>
 *
 * @attr ref com.hollowsoft.library.utility.R.styleable#Typeface_typefaceAssetPath
 * @attr ref com.hollowsoft.library.utility.R.styleable#Typeface_typefaceFilePath
 * @attr ref com.hollowsoft.library.utility.R.styleable#Typeface_typefaceCache
 *
 * @author Igor Morais
 * @author mor41s.1gor@gmail.com
 */
public class CheckBox extends android.widget.CheckBox {

    /**
     *
     * @param context
     */
    public CheckBox(final Context context) {
        super(context);
    }

    /**
     *
     * @param context
     * @param attributeSet
     */
    public CheckBox(final Context context, final AttributeSet attributeSet) {
        super(context, attributeSet);

        setTypeface(attributeSet, 0);
    }

    /**
     *
     * @param context
     * @param attributeSet
     * @param defStyle
     */
    public CheckBox(final Context context, final AttributeSet attributeSet, final int defStyle) {
        super(context, attributeSet, defStyle);

        setTypeface(attributeSet, defStyle);
    }

    /**
     *
     * @param attributeSet
     * @param defStyle
     */
    private void setTypeface(final AttributeSet attributeSet, final int defStyle) {

        if (!isInEditMode()) {

            final TypedArray typedArray = getContext().obtainStyledAttributes(attributeSet, R.styleable.Typeface,
                    defStyle, R.style.TextAppearance_Hollow);

            final boolean typefaceCache = typedArray.getBoolean(R.styleable.Typeface_typefaceCache, true);

            final String typefaceAssetPath = typedArray.getString(R.styleable.Typeface_typefaceAssetPath);
            if (StringUtility.isNullOrEmpty(typefaceAssetPath)) {

                final String typefaceFilePath = typedArray.getString(R.styleable.Typeface_typefaceFilePath);
                if (!StringUtility.isNullOrEmpty(typefaceFilePath)) {

                    setTypeface(getTypeface(typefaceFilePath, PathType.FILE, typefaceCache));
                }

            } else {
                setTypeface(getTypeface(typefaceAssetPath, PathType.ASSET, typefaceCache));
            }

            typedArray.recycle();
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
}
