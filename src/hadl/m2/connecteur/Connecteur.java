package hadl.m2.connecteur;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class Connecteur {

	private List<RoleTo> to = new ArrayList<>();
	private List<RoleFrom> from = new ArrayList<>();
	
	public Connecteur(RoleTo[] to, RoleFrom[] from) {
		this.to.addAll(Arrays.asList(to));
		this.from.addAll(Arrays.asList(from));
	}
}
