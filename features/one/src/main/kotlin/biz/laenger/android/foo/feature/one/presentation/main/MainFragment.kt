package biz.laenger.android.foo.feature.one.presentation.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import biz.laenger.android.foo.feature.one.R
import kotlinx.android.synthetic.main.feature_one_fragment_main.*

class MainFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.feature_one_fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        feature_one_fragment_main_text.setOnClickListener(
                Navigation.createNavigateOnClickListener(biz.laenger.android.foo.app.R.id.navigateToFeatureTwo))
    }

}
