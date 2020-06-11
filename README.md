# AspectRatioFrameLayout

固定宽高比的 FrameLayout，可以指定宽度自适应高度，也可以指定高度，自适应宽度。

## 依赖

```
implementation 'me.buck.customview:aspect-ratio-framelayout:1.0.0'
```

## 使用

`app:aspect_ratio` 指定宽高比，默认 1:1

```
<me.buck.customview.AspectRatioFrameLayout
    android:layout_marginTop="20dp"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/colorAccent"
    app:aspect_ratio="5:3" />

```

![image](/art/art.png)