package dk.hovdeforlob4.valutaomregener_android_h4

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ListViewAdapter: ArrayAdapter<Rate>{
    constructor(context: Activity, arrayList: ArrayList<Rate>): super(context,
                R.layout.listview_item,arrayList){
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.listview_item, null)

        val textViewRate = view.findViewById<TextView>(R.id.textView_Rate)
        val textViewValue = view.findViewById<TextView>(R.id.textview_value)

        textViewRate.text = arrayList[position].


        return super.getView(position, convertView, parent)
    }
}