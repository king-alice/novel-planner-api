CREATE TABLE characters(
	id UUID UNIQUE,
	name varchar(100)
);

CREATE TABLE character_relationships(
	id UUID,
	first UUID REFERENCES characters (id),
	second UUID REFERENCES characters (id),
	relationship_type varchar(100)
)