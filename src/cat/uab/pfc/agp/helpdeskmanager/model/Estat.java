package cat.uab.pfc.agp.helpdeskmanager.model;

import cat.uab.pfc.agp.helpdeskmanager.R;

public enum Estat {

	NOVA(R.color.estat_nova),
	EN_PROGRES(R.color.estat_en_progres),
	TANCADA(R.color.estat_tancada);

	private int colorId;

	Estat(int colorId) {
		this.colorId = colorId;
	}

	public int getColorId() {
		return colorId;
	};

}
