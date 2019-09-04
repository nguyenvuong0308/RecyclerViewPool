package gallery.vnm.com.recyclerviewpool

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.SparseIntArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_parent.view.*


class AdapterParent(var context: Context) : RecyclerView.Adapter<AdapterParent.Holder>() {
    private val positionList = SparseIntArray()
    private var viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        return Holder(LayoutInflater.from(context).inflate(R.layout.item_parent, p0, false))
    }

    override fun getItemCount(): Int {
        return 15
    }

    override fun onBindViewHolder(p0: Holder, p1: Int) {
        val lastSeenFirstPosition = positionList.get(p1, 0)
        if (lastSeenFirstPosition >= 0) {
            p0.layoutManager.scrollToPositionWithOffset(lastSeenFirstPosition, 0)
        }
    }

    override fun onViewRecycled(holder: Holder) {
        // Store position
        val position = holder.adapterPosition
        val firstVisiblePosition = holder.layoutManager.findFirstVisibleItemPosition()
        positionList.put(position, firstVisiblePosition)
        super.onViewRecycled(holder)
    }

    inner class Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val innerRecycler: RecyclerView? = null
        private var adapter: AdapterChild? = null
        var layoutManager: LinearLayoutManager

        init {
            itemView.rcvChild.setHasFixedSize(true)
            layoutManager = LinearLayoutManager(
                context,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            adapter = AdapterChild(context)

            itemView.rcvChild.layoutManager = layoutManager
            itemView.rcvChild.adapter = adapter
            itemView.rcvChild.setRecycledViewPool(viewPool)
        }

    }
}