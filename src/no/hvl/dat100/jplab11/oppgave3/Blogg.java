package no.hvl.dat100.jplab11.oppgave3;

import no.hvl.dat100.jplab11.common.TODO;
import no.hvl.dat100.jplab11.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggstabell;
	private int nesteledig;

	public Blogg() {
		this.innleggstabell = new Innlegg[20];
		this.nesteledig = 0;
	}

	public Blogg(int lengde) {
		this.innleggstabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}

	public Innlegg[] getSamling() {
		return innleggstabell;

	}

	public int finnInnlegg(Innlegg innlegg) {

		for (int i = 0; i < innleggstabell.length; i++) {
			
			if (innleggstabell[i] != null) {
				if (innleggstabell[i].erLik(innlegg)) {
					return i;
				}
			}
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {

		if (finnInnlegg(innlegg) != -1) {
			return true;
		}

		return false;

	}

	public boolean ledigPlass() {

		for (int i = 0; i < innleggstabell.length; i++) {
			if (innleggstabell[i] == null) {
				return true;
			}
		}
		return false;

	}

	public boolean leggTil(Innlegg innlegg) {

		if (ledigPlass()) {
			for (int i = 0; i < innleggstabell.length; i++) {
				if (innleggstabell[i] == null) {
					this.innleggstabell[i] = innlegg;
					nesteledig++;
					return true;
				}
			}
		}
		return false;

	}

	public String toString() {
		String txt = innleggstabell.length + "\n";
		for (int i = 0; i < innleggstabell.length; i++) {
			if(innleggstabell[i]!=null) {
			txt += innleggstabell[i].toString();
			}
		}

		return txt;
	}

	// valgfrie oppgaver nedenfor

	public void utvid() {
		Innlegg[] nyTabell = new Innlegg[(innleggstabell.length) * 2];

		for (int i = 0; i < innleggstabell.length; i++) {
			nyTabell[i] = innleggstabell[i];

		}
		innleggstabell = nyTabell;

	}

	public boolean leggTilUtvid(Innlegg innlegg) {

		if (finnes(innlegg)) {
			return false;
		}

		if (!ledigPlass()) {
			utvid();
		}
		leggTil(innlegg);

		return true;

	}

	public boolean slett(Innlegg innlegg) {

		int x = finnInnlegg(innlegg);
		if(x == -1) {
			return false;
		}
		innleggstabell[x] = null;
		nesteledig--;
		return true;
		
	}

	public int[] search(String keyword) {

		throw new UnsupportedOperationException(TODO.method());

	}
}