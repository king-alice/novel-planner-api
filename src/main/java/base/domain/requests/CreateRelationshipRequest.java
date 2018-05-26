package base.domain.requests;

import java.util.UUID;

import base.data.reference.RelationshipType;

public class CreateRelationshipRequest {
	public UUID first;
	public UUID second;
	public RelationshipType relationshipType;
}
