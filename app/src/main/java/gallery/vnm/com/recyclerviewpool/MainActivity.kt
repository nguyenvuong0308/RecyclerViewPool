package gallery.vnm.com.recyclerviewpool

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rcvMain.adapter
        rcvMain.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rcvMain.adapter = AdapterParent(this)
        rcvMain.setHasFixedSize(true)
    }
}
