![1] FontDroid
==============

[![Android Arsenal](https://img.shields.io/badge/Android%20Arsenal-FontDroid-brightgreen.svg?style=flat)](https://android-arsenal.com/details/1/916)

FontDroid is a small library that gives the ability to use custom fonts in an Android application. You can use any font with extension `.TTF` or `.OTF`.

![3] &nbsp; ![4] &nbsp; ![5]

###### Supported Widgets:

* [AutoCompleteTextView](http://developer.android.com/reference/android/widget/AutoCompleteTextView.html)
* [Button](http://developer.android.com/reference/android/widget/Button.html)
* [CheckBox](http://developer.android.com/guide/topics/ui/controls/checkbox.html)
* [CheckedTextView](http://developer.android.com/reference/android/widget/CheckedTextView.html)
* [Chronometer](http://developer.android.com/reference/android/widget/Chronometer.html)
* [DigitalClock](http://developer.android.com/reference/android/widget/DigitalClock.html)
* [EditText](http://developer.android.com/reference/android/widget/EditText.html)
* [MultiAutoCompleteTextView](http://developer.android.com/reference/android/widget/MultiAutoCompleteTextView.html)
* [RadioButton](http://developer.android.com/guide/topics/ui/controls/radiobutton.html)
* [Switch](http://developer.android.com/reference/android/widget/Switch.html)
* [TextClock](http://developer.android.com/reference/android/widget/TextClock.html)
* [TextView](http://developer.android.com/reference/android/widget/TextView.html)
* [ToggleButton](http://developer.android.com/reference/android/widget/ToggleButton.html)


Setup
-----

You can clone this repository like this.

`git clone https://github.com/MoraisIgor/FontDroid.git`

And add it to your project reference.

For more detailed information, look here [Referencing a library project](http://developer.android.com/tools/projects/projects-eclipse.html#ReferencingLibraryProject).


Example
-------

The custom font can be set to a widget in some different ways, all examples below are using a plain `TextView`. But all widgets have the same usage.

##### The Layout Way

All supported widgets can be found in graphical layout tab. You can drag and drop as usually.

![2]

```xml
<com.hollowsoft.library.fontdroid.XXX
...
```

These widgets have the following custom attributes:

```xml
<attr name="typefaceAssetPath" format="string" />
<attr name="typefaceFilePath" format="string" />
<attr name="typefaceCache" format="boolean" />
```

I think the attributes names are self explanatory, but let me say:

* `typefaceAssetPath` - Typeface path from the specified asset folder.
* `typefaceFilePath` - Typeface path from the specified file.
* `typefaceCache` - Load typeface from cache, default value is true.

You can set a custom font just for a single widget or for the entire application.

###### Set In Single Widget

```xml
<com.hollowsoft.library.fontdroid.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Font Droid"
        android:textSize="50sp"
        app:typefaceAssetPath="fonts/LeviBrush.ttf" />
```

You also need to put this tag in your root view element. That is necessary when working with custom views in Android.

```xml
xmlns:app="http://schemas.android.com/apk/res-auto"
```

Now, let me show the complete example.

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent" >

    <com.hollowsoft.library.fontdroid.TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_centerInParent="true"
        android:text="Font Droid"
        android:textSize="50sp"
        app:typefaceAssetPath="fonts/LeviBrush.ttf" />

</RelativeLayout>
```

###### Set To The Entire Application

Like the previous example, you will specify the custom widgets in your layout.

```xml
<com.hollowsoft.library.fontdroid.TextView
...
```

But you can set the custom font in a style, rather than specify just for a single widget.

The style must have the name `TextAppearance.Hollow`, the attribute `parent` is optional.

```xml
<style name="TextAppearance.Hollow" parent="@android:style/TextAppearance.Holo">
    <item name="typefaceAssetPath">fonts/LeviBrush.ttf</item>
</style>
```

You can use this style normally like `textAppearance` attribute.

```xml
<style name="Theme.Example" parent="@android:style/Theme.Holo.Light.DarkActionBar">
    <item name="android:textAppearance">@style/TextAppearance.Hollow</item>
</style>
```

##### The Code Way

This is not the best way, but sometimes you will need to set this by code.

You can extend the abstract classes or use the custom widget classes.

###### Extend Abstract Class

All widgets has an `abstract` class version (ex: `AbstractTextView`).

You can extend the abstract class.

```java
public class MyTextView extends AbstractTextView {
...
```

And implement an `abstract` method `getTypefaceAssetPath()` in your subclass, creating your own custom widget.

```java
/**
 * Get {@code Typeface} path from the specified asset folder.
 *
 * @return The {@code Typeface} path from the specified asset folder.
 */
protected String getTypefaceAssetPath() {
    return "fonts/LeviBrush.ttf";
}
```

###### Use The Custom Widget Class

You can use it as usual, but you have a few new methods.

```java
TextView textView = (TextView) findViewById(R.id.text_view);
textView.setTypeface("fonts/LeviBrush.ttf", PathType.ASSET);
```

or

```java
TextView textView = new TextView(this);
textView.setTypeface("fonts/LeviBrush.ttf", PathType.ASSET);
```

Pay attention on import.

```java
import com.hollowsoft.library.fontdroid.TextView;
```

For more detailed information, look at sample application.


Thanks
------

Fonts used in sample application:

* [Bombing](http://qkila.com)
* [Dark Net Warrior](http://www.imagex-fonts.com)
* [Jenna Sue](http://www.jennasuedesign.com)
* [Levi Brush](http://loremipsum.ro)
* [Orange Juice](http://brittneymurphydesign.com)

Awesome tools for code quality improvement:

* [Android Lint](http://developer.android.com/tools/help/lint.html)
* [Checkstyle](http://checkstyle.sourceforge.net)
* [FindBugs](http://findbugs.sourceforge.net)
* [PMD](http://pmd.sourceforge.net)


Contact
-------

* [GitHub Page](http://moraisigor.github.io)
* [Home Page](http://igormorais.com)


License
-------

```
    Copyright (c) 2014 HollowSoft @IgorMorais
    
    Licensed under the Apache License, Version 2.0 (the “License”);
    you may not use this file except in compliance with the License.
    
         You may obtain a copy of the License at
         http://www.apache.org/licenses/LICENSE-2.0
         
    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an “AS IS” BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
```


[1]: https://raw.githubusercontent.com/MoraisIgor/FontDroid/master/raw/android.png
[2]: https://raw.githubusercontent.com/MoraisIgor/FontDroid/master/raw/widget.png
[3]: https://raw.githubusercontent.com/MoraisIgor/FontDroid/master/raw/1.png
[4]: https://raw.githubusercontent.com/MoraisIgor/FontDroid/master/raw/2.png
[5]: https://raw.githubusercontent.com/MoraisIgor/FontDroid/master/raw/3.png
