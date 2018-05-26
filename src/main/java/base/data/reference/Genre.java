package base.data.reference;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

public enum Genre {
	FANTASY,
	ROMANCE,
	COMEDY,
	HORROR,
	THRILLER,
	CRIME,
	NON_FICTION,
	AUTOBIOGRAPHY,
	TRAVEL,
	ACTION,
	ADVENTURE
}
