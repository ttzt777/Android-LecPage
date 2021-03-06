package cc.bear3.lec

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import cc.bear3.lec.kernel.R

/**
 *
 * @author TT
 * @since 2020-12-8
 */
abstract class LecFragment : Fragment(), ILecPage {

    override lateinit var root: FrameLayout

    override var loadingView: View? = null
    override var errorView: View? = null

    override val lecState = MutableLiveData(Lec.Content)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.layout_lec, container, false) as FrameLayout

        root.addView(onCreateContentView(), getAttachParams())

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        defaultObserverLecState()
    }

    override fun getLifecycleOwner(): LifecycleOwner {
        return this
    }
}