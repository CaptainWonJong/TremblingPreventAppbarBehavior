import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.widget.OverScroller
import androidx.coordinatorlayout.widget.CoordinatorLayout
import com.google.android.material.appbar.AppBarLayout
import kotlin.math.abs

/**
 * @author CaptainWonJong@gmail.com
 */
class TremblingPreventAppBarBehavior(
    context: Context?,
    attrs: AttributeSet?
) : AppBarLayout.Behavior(context, attrs) {
    private val maxFlingVelocityY = 2000
    private val invalidMinusTouchY = -1f

    private var scroller: OverScroller? = OverScroller(context)

    private var beforeTouchY = 0f
    private var minusTouchY = invalidMinusTouchY

    override fun onNestedPreScroll(
        coordinatorLayout: CoordinatorLayout, child: AppBarLayout,
        target: View, dx: Int, dy: Int, consumed: IntArray, type: Int
    ) {
        stopAppBarLayoutFling()
        if (dy < 0 && minusTouchY >= 0) {
            return
        } else {
            super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type)
        }
    }

    override fun onNestedScroll(
        coordinatorLayout: CoordinatorLayout,
        child: AppBarLayout,
        target: View,
        dxConsumed: Int,
        dyConsumed: Int,
        dxUnconsumed: Int,
        dyUnconsumed: Int,
        type: Int,
        consumed: IntArray
    ) {
        if (dyUnconsumed < 0 && minusTouchY >= 0) {
            return
        } else {
            super.onNestedScroll(
                coordinatorLayout,
                child,
                target,
                dxConsumed,
                dyConsumed,
                dxUnconsumed,
                dyUnconsumed,
                type,
                consumed
            )
        }
    }

    override fun onStopNestedScroll(coordinatorLayout: CoordinatorLayout, abl: AppBarLayout, target: View, type: Int) {
        minusTouchY = invalidMinusTouchY
        super.onStopNestedScroll(coordinatorLayout, abl, target, type)
    }

    override fun onTouchEvent(parent: CoordinatorLayout, child: AppBarLayout, e: MotionEvent): Boolean {
        val consumed = super.onTouchEvent(parent, child, e)
        if (e.actionMasked != MotionEvent.ACTION_CANCEL) {
            beforeTouchY = e.y
        }
        when (e.actionMasked) {
            MotionEvent.ACTION_MOVE -> {
                stopAppBarLayoutFling()
                minusTouchY = beforeTouchY - e.y
            }
        }
        return consumed
    }

    override fun onNestedPreFling(
        coordinatorLayout: CoordinatorLayout,
        child: AppBarLayout,
        target: View,
        velocityX: Float,
        velocityY: Float
    ): Boolean {
        return if (abs(velocityY) > maxFlingVelocityY) {
            super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY / 1000)
        } else {
            super.onNestedPreFling(coordinatorLayout, child, target, velocityX, velocityY)
        }
    }

    override fun onNestedFling(
        coordinatorLayout: CoordinatorLayout,
        child: AppBarLayout,
        target: View,
        velocityX: Float,
        velocityY: Float,
        consumed: Boolean
    ): Boolean {
        return if (abs(velocityY) > maxFlingVelocityY) {
            super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY / 1000, consumed)
        } else {
            super.onNestedFling(coordinatorLayout, child, target, velocityX, velocityY, consumed)
        }
    }

    private fun stopAppBarLayoutFling() {
        javaClass.superclass?.superclass?.superclass?.getDeclaredField("scroller")?.apply {
            isAccessible = true
        }?.let {
            scroller = it.get(this) as? OverScroller
            scroller?.forceFinished(true)
        }
    }
}