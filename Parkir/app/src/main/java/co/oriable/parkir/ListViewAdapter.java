package co.oriable.parkir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import android.widget.TextView;

import java.util.List;



public class ListViewAdapter extends ArrayAdapter<Kendaraan> {

    private List<Kendaraan> kendaraanitemList;

    private Context context;

    public ListViewAdapter(List<Kendaraan> kendaraanitemList, Context context) {
        super(context, R.layout.list_item, kendaraanitemList);
        this.kendaraanitemList = kendaraanitemList;
        this.context = context;
    }



    @Override
    public View getView(final int position,View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View listViewItem = inflater.inflate(R.layout.list_item, null, true);

        TextView textViewNo = listViewItem.findViewById(R.id.textViewno_kendaraan);
        TextView textViewName = listViewItem.findViewById(R.id.textViewnama_pemilik);
        TextView textViewType = listViewItem.findViewById(R.id.textViewjenis_kendaraan);
        TextView textViewStatus = listViewItem.findViewById(R.id.textViewstatus);


        Kendaraan kendaraanItem = kendaraanitemList.get(position);

        textViewNo.setText(kendaraanItem.getNo_kendaraan());
        textViewName.setText(kendaraanItem.getNama_pemilik());
        textViewType.setText(kendaraanItem.getJenis_kendaraan());
        textViewStatus.setText(kendaraanItem.getStatus());

        return listViewItem;
    }
}