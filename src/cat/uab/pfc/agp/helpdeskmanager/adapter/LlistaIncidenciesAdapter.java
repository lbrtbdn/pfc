package cat.uab.pfc.agp.helpdeskmanager.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import cat.uab.pfc.agp.helpdeskmanager.R;
import cat.uab.pfc.agp.helpdeskmanager.model.Incidencia;

public class LlistaIncidenciesAdapter extends ArrayAdapter<Incidencia> {

	private static class IncidenciaListViewHolder {
		View estatView;
		TextView assumpteView;
		TextView dataView;
		TextView tipusView;
	}

	public LlistaIncidenciesAdapter(Context context, List<Incidencia> objects) {
		super(context, 0, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// Obtenir ViewHolder
		View elementView = convertView;
		IncidenciaListViewHolder holder = null;

		// Si item no existeix (no estem reutilitzant), creem el
		// ViewHolder i l'afegim a la convertView
		if (elementView == null) {
			LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			elementView = inflater.inflate(R.layout.element_llista_incidencia, null);

			holder = new IncidenciaListViewHolder();
			holder.estatView = elementView.findViewById(R.id.estat);
			holder.assumpteView = (TextView) elementView.findViewById(R.id.assumpte);
			holder.dataView = (TextView) elementView.findViewById(R.id.data);
			holder.tipusView = (TextView) elementView.findViewById(R.id.tipus);

			elementView.setTag(holder);
		} else {
			// Si ja existeix (estem reutilitzant), obtenir el viewHolder de
			// dins
			holder = (IncidenciaListViewHolder) convertView.getTag();
		}

		// Pintar ViewHolder
		pintarViewHolder(holder, position);

		return elementView;

	}

	private void pintarViewHolder(IncidenciaListViewHolder holder, int position) {

		Incidencia incidencia = getItem(position);

		int color = getContext().getResources().getColor(incidencia.getEstat().getColorId());
		String assumpte = incidencia.getAssumpte();
		String data = incidencia.getData().toString();
		String tipus = incidencia.getTipus();

		holder.estatView.setBackgroundColor(color);
		holder.assumpteView.setText(assumpte);
		holder.dataView.setText(data);
		holder.tipusView.setText(tipus);
	}
}