package biz.laenger.android.foo.feature.two.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import biz.laenger.android.foo.feature.two.R
import kotlinx.android.synthetic.main.feature_two_fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.feature_two_fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        feature_two_fragment_main_text.setOnClickListener(
                Navigation.createNavigateOnClickListener(biz.laenger.android.foo.app.R.id.navigateToFeatureOne))
    }

}
