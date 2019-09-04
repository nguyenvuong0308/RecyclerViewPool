package gallery.vnm.com.recyclerviewpool

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import kotlinx.android.synthetic.main.item_child.view.*

class AdapterChild(var context: Context) : RecyclerView.Adapter<AdapterChild.Holder>() {
    var listImage = arrayListOf(
        "https://images.pexels.com/photos/67636/rose-blue-flower-rose-blooms-67636.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://image.shutterstock.com/image-photo/white-transparent-leaf-on-mirror-260nw-1029171697.jpg",
        "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500",
        "https://helpx.adobe.com/content/dam/help/en/stock/how-to/visual-reverse-image-search/jcr_content/main-pars/image/visual-reverse-image-search-v2_intro.jpg"
    )

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.item_child, p0, false))
    }


    override fun onViewRecycled(holder: Holder) {
        super.onViewRecycled(holder)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
    }


    override fun getItemCount(): Int {
        return listImage.size
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        p0.binData(listImage[p1])
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun binData(image: String) {
            Glide.with(context).load(image).diskCacheStrategy(DiskCacheStrategy.ALL).into(itemView.ivDefault)
        }

    }
}