# TremblingPreventAppBarBehavior
AppBar를 Fling 했을 때의 관성의 방향과 NestedScrollView에서 Fling 했을 때의 관성의 방향이 반대가 되어 바들바들 떨리는 현상을 방지하는 AppBarLayout의 Behavior  


## 사용법

```groovy
repositories {
  google()
  mavenCentral()
}

dependencies {
    implementation 'io.github.CaptainWonJong:TremblingPreventAppBarBehavior:1.0.0'
}
```

```xml
<com.google.android.material.appbar.AppBarLayout
    android:id="@+id/appbar"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:layout_behavior="io.github.captainwonjong.behavior.TremblingPreventAppBarBehavior">

  ~~~
</com.google.android.material.appbar.AppBarLayout>
```



## 기능 요약

- NestedScroll의 최대속도를 제어하여 부드럽게 스크롤합니다. (onNestedPreScroll, onNestedFling)
- NestedScroll의 관성의 방향이 위쪽으로 진행중일 때, AppBar의 관성의 방향이 아래쪽으로 작용한다면 위쪽으로 작용하던 NestedScroll의 관성을 제거합니다
- AppBar의 관성의 방향이 아래쪽으로 진행중일 때, NestedScrol의 관성의 방향이 위쪽으로 작용한다면 아래쪽으로 작용하던 AppBar의 관성을 제거합니다

