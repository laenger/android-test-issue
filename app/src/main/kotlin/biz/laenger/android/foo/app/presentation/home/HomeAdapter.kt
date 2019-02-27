package biz.laenger.android.foo.app.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import biz.laenger.android.foo.app.R
import biz.laenger.android.foo.app.presentation.home.HomeAdapter.HomeViewHolder
import kotlinx.android.synthetic.main.app_item_home.view.*
import kotlinx.collections.immutable.immutableListOf

class HomeAdapter(context: Context) : RecyclerView.Adapter<HomeViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private val items = immutableListOf(
            HomeItem(R.string.home_item_one, R.drawable.ic_filter_1_black_24dp, R.id.navigateToFeatureOne),
            HomeItem(R.string.home_item_two, R.drawable.ic_filter_2_black_24dp, R.id.navigateToFeatureTwo)
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder =
            HomeViewHolder(inflater.inflate(R.layout.app_item_home, parent, false))

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) = holder.bind(items[position])

    inner class HomeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var item: HomeItem

        fun bind(item: HomeItem) {
            this.item = item
            itemView.item_home_title.setText(item.titleRes)
            itemView.item_home_title.setCompoundDrawablesWithIntrinsicBounds(0, item.drawableRes, 0, 0)
            itemView.setOnClickListener(Navigation.createNavigateOnClickListener(item.destinationRes))
        }
    }

    data class HomeItem(@StringRes val titleRes: Int, @DrawableRes val drawableRes: Int, @IdRes val destinationRes: Int)

}
