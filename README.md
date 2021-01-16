# TremblingPreventAppBarBehavior
AppBar를 Fling 했을 때의 관성의 방향과 NestedScrollView에서 Fling 했을 때의 관성의 방향이 반대가 되어 바들바들 떨리는 현상을 방지하는 AppBarLayout의 Behavior
([상식 - 1:1 영양상담(다이어트, 당뇨) - Google Play 앱](https://play.google.com/store/apps/details?id=com.doinglab.sangsik))  - 1.2.6 버전의 프로그램 상세화면에서 확인 가능



## 사용법

- Command + C, Command + V

  ```xml
  <com.google.android.material.appbar.AppBarLayout
      android:id="@+id/appbar"
      android:layout_width="match_parent"
      android:layout_height="wrap_content"
      app:layout_behavior="@{YOUR_PACKAGE}.TremblingPreventAppBarBehavior">
    
    ~~~
  </com.google.android.material.appbar.AppBarLayout>
  ```



## 기능 요약

- NestedScroll의 최대속도를 제어하여 부드럽게 스크롤합니다. (onNestedPreScroll, onNestedFling)
- NestedScroll의 관성의 방향이 위쪽으로 진행중일 때, AppBar의 관성의 방향이 아래쪽으로 작용한다면 위쪽으로 작용하던 NestedScroll의 관성 제거
- AppBar의 관성의 방향이 아래쪽으로 진행중일 때, NestedScrol의 관성의 방향이 위쪽으로 작용한다면 아래쪽으로 작용하던 AppBar의 관성 제거



## 그 외의 바들바들 떨리는 기본 AppBar의 Behavior 처리방법

- [배달의 민족](https://play.google.com/store/apps/details?id=com.sampleapp&hl=ko&gl=US) 처럼 관성을 확 죽여버리는 방법도 있음
- 다른 레퍼런스 앱들을 더 찾아봐야 할듯



전에 작업했던거 복붙하고 파일하고 클래스 이름 바꾼거라 오타 있을 수 있음.

