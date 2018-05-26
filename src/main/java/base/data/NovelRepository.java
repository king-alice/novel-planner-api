package base.data;

import java.util.List;
import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import base.domain.Novel;

@Component
public interface NovelRepository extends CrudRepository<Novel,UUID> {
	
}
