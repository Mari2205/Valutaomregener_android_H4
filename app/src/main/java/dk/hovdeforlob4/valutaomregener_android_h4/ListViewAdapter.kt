package dk.hovdeforlob4.valutaomregener_android_h4

import android.app.Activity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

///**
// * @see_Adapter create a adapter : https://www.youtube.com/watch?v=KPvYXXERLjk
// */
class ListViewAdapter(private val context: Activity,private val arrayList: ArrayList<Rate>): ArrayAdapter<Rate>(context,
                      R.layout.listview_item,arrayList){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        Log.d("list_view", "inside adaptor")
        val inflater: LayoutInflater = LayoutInflater.from(context)
        val view: View = inflater.inflate(R.layout.listview_item, null)

        val textViewRate = view.findViewById<TextView>(R.id.textView_Rate)
        val textViewValue = view.findViewById<TextView>(R.id.textview_value)

        textViewRate.text = arrayList[position].name
        textViewValue.text = arrayList[position].spotRate.toString()

        return view
    }
}